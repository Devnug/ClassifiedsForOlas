package devnug.classifiedsforolas;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Nug on 5/13/2015.
 */
public class JobPosting extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number";

    public static final String DEBUG_TAG = "JobPosting";

    TextView school;
    TextView opening;
    TextView desc;
    TextView link;
    static View v;

    @SuppressWarnings("unchecked")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.postinglist, null);
        Bundle args = getArguments();

        school = (TextView) v.findViewById(R.id.school);
        school.setText(args.getString("school"));

        opening = (TextView) v.findViewById(R.id.posting);
        school.setText(args.getString("posting"));

        desc = (TextView) v.findViewById(R.id.desc);
        school.setText(args.getString("desc"));

        link = (TextView) v.findViewById(R.id.link);
        school.setText(args.getString("link"));

        return v;
    }

}
