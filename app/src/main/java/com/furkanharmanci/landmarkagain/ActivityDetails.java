package com.furkanharmanci.landmarkagain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.furkanharmanci.landmarkagain.databinding.ActivityDetailsBinding;

public class ActivityDetails extends AppCompatActivity {

    // view binding
    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        // sayfa getirme methodu yazdık ve onu intent'e ilettik.
        Intent intent = getIntent();

        // gelecek seri verileri LandMark objesinden türeyen bir instance'a atadık.
        // Serializable şeklinde gelen Sınıf verileri LandMark sınıfından türeyen bir instance'a aktarıldı
        LandMark selectedLandMark =  (LandMark) intent.getSerializableExtra("landMark");

        // Sınıfın her bir prop'u UI'da uygun durumdaki yerlere set edildi.
        binding.nameText.setText(selectedLandMark.name);
        binding.countryText.setText(selectedLandMark.country);
        binding.imageView.setImageResource(selectedLandMark.image);
    }
}