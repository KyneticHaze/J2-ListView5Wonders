package com.furkanharmanci.landmarkagain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.furkanharmanci.landmarkagain.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    // bir view binding init edelim
    private ActivityMainBinding binding;

    // Bir obje listesi
    // Landmark objeleri tutan bir liste init ettik
    ArrayList<LandMark> objList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // her bir view'ı teker teker id'sinden bulup tanımlamak yerine bu adımları izledik. tek değişken(binding) ile tümüne ulaşacağız artık.
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // inflate() => xml ile kodumuzu bağlamak için kullanılan bir method
        View view = binding.getRoot();
        // Bağladığımız şeyi View sınıfından türeyen view instance'ına aktararak bir görünüme çevirdik.
        setContentView(view);



        //Data

        // Listeyi tanımladık.
        objList = new ArrayList<>();

        // Objeleri oluşturduk
        LandMark giza = new LandMark("Giza", "Egypt", R.drawable.giza);
        LandMark itza = new LandMark("Itza", "Mexico", R.drawable.itza);
        LandMark colosseum = new LandMark("Colosseum", "Italy", R.drawable.colloseum);
        LandMark mp = new LandMark("Machu Picchu", "Peru", R.drawable.mp);
        LandMark petra = new LandMark("Petra", "Jordan", R.drawable.petra);

        // Listeye objeler ekliyoruz.
        objList.add(giza);
        objList.add(itza);
        objList.add(colosseum);
        objList.add(mp);
        objList.add(petra);

        // ListView,

        // listView verilerini kullanıcı arayüzüne göndermek için ArrayAdapter sınıfından bir instance oluşturmalıyız.
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, objList.stream().map(obje -> obje.name).collect(Collectors.toList()));
            // context istiyor, bir R resource istiyor, bir de liste istiyor. Bu listeyi map ile yeni liste şekline çevirip verdik.

        binding.listView.setAdapter(arrayAdapter);
        // adapter'ü listView'a set ettik

        // listedeki her elemana tıklanıldığında tepki verecek methodu yazıyoruz
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Her elemana tıklama ile gerçekleşecek durumları yazıyoruz.
                Intent intent = new Intent(MainActivity.this, ActivityDetails.class);
                // Sayfa'dan sayfa geçmek için bir intent belirledik ve geçiş için sayfaları yazdık.

                // geçilecek sayfaya gönderilecek verileri ekleme methodunu yazdık.
                intent.putExtra("landMark", objList.get(position));
                // objList.get(i) hata verdi ve onu LandMark sınıfına Serializable interface'ini implement ederek çözdük.
                // Serializable interface'i verileri hızlıca çözümlüyor.

                // aktivite başlatma methodu yazdık.
                startActivity(intent);
            }
        });
    }
}