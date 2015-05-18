package devnug.classifiedsforolas;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.etsy.android.grid.StaggeredGridView;

public class JobFragment extends android.support.v4.app.Fragment implements OnClickListener {

	public final String DEBUG_TAG = "JobFragment";
	
	//public ArrayList<String> data;
	public static ListView lv1;
	public static StaggeredGridView gridView;
	static ArrayAdapter<Posting> adapter;
	EditText edt;
	Spinner typeSpinner;
	Spinner classSpinner;
	static View v;

	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section
	 * number.
	 */
	public static JobFragment newInstance(int sectionNumber) {
		JobFragment fragment = new JobFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	@SuppressWarnings("unchecked")
	@Override
    public View onCreateView(LayoutInflater inflater,final ViewGroup container,Bundle savedInstanceState) {
        /** Creating an array adapter to store the list of countries **/
		//data = new ArrayList<String>();
		//refreshList();
		
        //adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1,data);
 
        /** Setting the list adapter for the ListFragment **/
        //setListAdapter(adapter);
        //updateList(inflater);
        v = inflater.inflate(R.layout.datalist, null); 
        //adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, MainActivity.data);
        //adapter = new CustomAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1,data);
        adapter = new PostingAdapter<Posting>(v.getContext(), android.R.layout.simple_list_item_1,MainActivity.data);
        gridView = (StaggeredGridView)v.findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
        //container.addView(v);
        //setListAdapter(adapter);
        gridView.setOnItemClickListener(new OnItemClickListener() {
			  public void onItemClick(AdapterView<?> parent, View view,
			      int position, long id) {
				  	
				  // Refresh specific item in Listview to either show or hide description of the job
				  ((PostingAdapter<Posting>) parent.getAdapter()).changeState(view, position);

				  //Call new fragment to show info and link to website
				  Bundle bundle = new Bundle();
				  bundle.putString("school", ((Posting)gridView.getItemAtPosition(position)).getSchool());
				  bundle.putString("posting", ((Posting)gridView.getItemAtPosition(position)).getQuickDesc());
				  bundle.putString("desc", ((Posting)gridView.getItemAtPosition(position)).getDesc());
				  bundle.putString("link", ((Posting)gridView.getItemAtPosition(position)).getLink());
				  JobPosting toFragment = new JobPosting();
				  toFragment.setArguments(bundle);
				  //getFragmentManager().beginTransaction().replace(R.id.data_list, toFragment).commit();
			  	}
			}); 
        
        gridView.setTextFilterEnabled(true);
        
        edt = (EditText) v.findViewById(R.id.SearchText);
        //edt.setText(" ");
        
        edt.addTextChangedListener(new TextWatcher()
	    {


	        @Override
	        public void onTextChanged( CharSequence arg0, int arg1, int arg2, int arg3)
	        {
	        	// TODO Auto-generated method stub
	        	if(MainActivity.data.size() > 0)
	        		JobFragment.this.adapter.getFilter().filter(arg0);

	        }



	        @Override
	        public void beforeTextChanged( CharSequence arg0, int arg1, int arg2, int arg3)
	        {
	            // TODO Auto-generated method stub

	        }



	        @Override
	        public void afterTextChanged( Editable arg0)
	        {
	            // TODO Auto-generated method stub
	        	//if(MainActivity.data.size() > 0)
	        	//	JobFragment.this.adapter.getFilter().filter(arg0);

	        }
	    });
	    
        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
	
	public static void updateList(LayoutInflater inflater) {
		v = inflater.inflate(R.layout.datalist, null); 
        adapter = new PostingAdapter<Posting>(v.getContext(), R.layout.item_list, MainActivity.data);
        //adapter = new CustomAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1,data);
        gridView = (StaggeredGridView)v.findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
        //container.addView(v);
        //setListAdapter(adapter);
        
        gridView.setTextFilterEnabled(true);
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
