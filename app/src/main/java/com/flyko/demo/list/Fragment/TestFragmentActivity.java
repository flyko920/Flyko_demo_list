package com.flyko.demo.list.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;
import com.flyko.demo.list.R;

import java.util.List;

/**
 * Created by flykozhang on 16-2-4.
 */
public class TestFragmentActivity extends FragmentActivity implements TwoFragment.FragmentTwoBtnClickListener, OneFragment.FragmentOneBtnClickListener {
    private static final int FRAGMENT_ID_ONE = 1;
    private static final int FRAGMENT_ID_TWO = 2;

    @Override
    public void btuClick(int FRAGMENT_ID, int btu_id) {
        FragmentTransaction bt = getSupportFragmentManager().beginTransaction();
        switch (FRAGMENT_ID) {
            case FRAGMENT_ID_ONE:
                switch (btu_id) {
                    case R.id.id_fragment_one_btn:
                        Toast.makeText(this, "Fragment1 btu1", Toast.LENGTH_SHORT).show();
                        TwoFragment twoFragment = new TwoFragment();
                        bt.replace(R.id.id_content, twoFragment, "two");
                        bt.addToBackStack(null);
                        bt.commit();
                        break;
                    case R.id.id_fragment_one_btn2:
                        Toast.makeText(this, "Fragment1 btu2", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case FRAGMENT_ID_TWO:
                switch (btu_id) {
                    case R.id.id_fragment_one_btn:
                        Toast.makeText(this, "Fragment2 btu1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.id_fragment_one_btn2:
                        Toast.makeText(this, "Fragment2 btu2", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
        }
    }


    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testfragment_layout);
        if (savedInstanceState == null) {
            OneFragment oneFragment = new OneFragment();
            FragmentTransaction bt = getSupportFragmentManager().beginTransaction();
            bt.add(R.id.id_content, oneFragment, "one");
            bt.commit();
        }
    }



}
