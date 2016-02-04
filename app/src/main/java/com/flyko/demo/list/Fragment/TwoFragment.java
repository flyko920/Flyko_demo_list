package com.flyko.demo.list.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.flyko.demo.list.R;

/**
 * Created by flykozhang on 16-2-4.
 */
public class TwoFragment extends Fragment implements View.OnClickListener {
    Button fragment_one_btn,fragment_one_btn2;
    private static final int FRAGMENT_ID = 2;

    public interface FragmentTwoBtnClickListener{
        void btuClick(@NonNull int FRAGMENT_ID, @NonNull int btu_id);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        fragment_one_btn = (Button) view.findViewById(R.id.id_fragment_one_btn);
        fragment_one_btn2 = (Button) view.findViewById(R.id.id_fragment_one_btn2);
        fragment_one_btn.setText("第二页1" + "/n" + "下一页");
        fragment_one_btn2.setText("第二页2" + "/n" + "下一页");
        fragment_one_btn.setTag(fragment_one_btn.getId());
        fragment_one_btn2.setTag(fragment_one_btn2.getId());
        fragment_one_btn.setOnClickListener(this);
        fragment_one_btn2.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if(getActivity() instanceof FragmentTwoBtnClickListener){
            ((FragmentTwoBtnClickListener) getActivity()).btuClick(FRAGMENT_ID,(Integer) v.getTag());
        }
    }
}
