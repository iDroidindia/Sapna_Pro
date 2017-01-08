package sapna_pro.idi.sapna_pro;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sapana on 12/16/2016.
 */
public class Act_1_sept_1 extends Fragment {
    TextView time;
    @Nullable
    @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.layout_frag_main, container, false);

        time=(TextView) rootView.findViewById(R.id.tv_time_2);




        return rootView;



    }
}
