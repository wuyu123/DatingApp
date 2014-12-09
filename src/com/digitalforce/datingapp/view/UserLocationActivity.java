package com.digitalforce.datingapp.view;

import android.os.Bundle;
import com.digitalforce.datingapp.R;
import com.digitalforce.datingapp.constants.AppConstants;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by FARHAN on 12/10/2014.
 */
public class UserLocationActivity extends BaseActivity{

    private GoogleMap mMap;

    private String mLatitude="0";
    private String mLongitude="0";
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_map_layout);

        mLatitude = getIntent().getStringExtra(AppConstants.MAP_LATITUDE);
        mLongitude = getIntent().getStringExtra(AppConstants.MAP_LONGITUDE);
        userName = getIntent().getStringExtra(AppConstants.MAP_USER_NAME);

        setUpMapIfNeeded();
    }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the
        // map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map)).getMap();

            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();

            }
        }
    }

    private void setUpMap() {
          try{
              final LatLng pos = new LatLng(Float.parseFloat(mLatitude), Float.parseFloat(mLongitude));
              mMap.addMarker(new MarkerOptions()
                      .position(pos)
                      .title(userName));

              mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pos, 13));

          }catch(Exception e){}



    }


    @Override
    public void onEvent(int eventId, Object eventData) {

    }
}
