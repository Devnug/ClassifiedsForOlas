package devnug.classifiedsforolas;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Filter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
*  PostingAdapter<T>
*
*  Used to create a custom listview to show data for each job available 
*
*/
public class PostingAdapter<T> extends ArrayAdapter<T> implements Filter {
	
	public static final String TAG = "PostingAdapter";
	public List<T> object;
	public List<T> allObjects;
	public Filter myFilter;
	public PostingFilter postingFilter;

	public PostingAdapter(Context context, int resource, List<T> objects) {
		super(context, resource, objects);
		object = objects;
		allObjects = objects;
		
	}

	@Override
	public int getCount() {
		return object.size();
	}
 
	@Override
	public T getItem(int position) {
		return object.get(position);
	}
 
	//@Override
	//public Posting getItemId(int position) {
	//	return object.get(position).getId();
	//}
	
	@Override
	public android.widget.Filter getFilter() {
	    if (postingFilter == null)
	        postingFilter = new PostingFilter();
	     
	    return (android.widget.Filter) postingFilter;
	}
	
	/*
	 * we are overriding the getView method here - this is what defines how each
	 * list item will look.
	 */
	public View getView(int position, View convertView, ViewGroup parent){

		// assign the view we are converting to a local variable
		View v = convertView;

		// first check to see if the view is null. if so, we have to inflate it.
		// to inflate it basically means to render, or show, the view.
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.item_list, null);
		}
		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 * 
		 * Therefore, i refers to the current Item object.
		 */
		Posting i = (Posting) object.get(position);
		if(i != null) {
			// This is how you obtain a reference to the TextViews.
			// These TextViews are created in the XML files we defined.

			TextView tt = (TextView) v.findViewById(R.id.toptext);
			TextView ttd = (TextView) v.findViewById(R.id.toptextdata);
			TextView mt = (TextView) v.findViewById(R.id.middletext);
			TextView mtd = (TextView) v.findViewById(R.id.middletextdata);
			TextView bt = (TextView) v.findViewById(R.id.longdesc);
			TextView btd = (TextView) v.findViewById(R.id.longdesctext);

			// check to see if each individual textview is null.
			// if not, assign some text!
			if (tt != null){

			}
			if (ttd != null){
				ttd.setText(i.getSchool());
			}
			if (mt != null){

			}
			if (mtd != null){
				mtd.setText(i.getQuickDesc());
			}
			if (bt != null && bt.getVisibility() == View.VISIBLE){
				bt.setText("Desc: ");
				//bt.setVisibility(View.GONE);
			}
			else {
				bt.setVisibility(View.GONE);
			}
			if (btd != null && bt.getVisibility() == View.VISIBLE){
				btd.setText(i.getDesc());
				//btd.setVisibility(View.GONE);
			}
			else {
				btd.setVisibility(View.GONE);
			}
		}
		return v;
	}

	@Override
	public boolean onLoadClass(Class clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void changeState(View v, int position) {
		
		Log.d(TAG, "Click for " + ((Posting) object.get(position)).getSchool());
		TextView bt = (TextView) v.findViewById(R.id.longdesc);
		TextView btd = (TextView) v.findViewById(R.id.longdesctext);
		if (bt.getVisibility() != View.VISIBLE){
			bt.setText("Full Desc: ");
			bt.setVisibility(View.VISIBLE);
			Log.d(TAG, "Set Visible");
		}
		else {
			bt.setText("Full Desc: ");
			bt.setVisibility(View.GONE);
			Log.d(TAG, "Set invisible");
		}
		if (btd.getVisibility() != View.VISIBLE){
			//btd.setText(((Posting) object.get(position)).getDesc());
			btd.setVisibility(View.VISIBLE);
			Log.d(TAG, "Set Visible");
		}
		else {
			//btd.setText(((Posting) object.get(position)).getDesc());
			btd.setVisibility(View.GONE);
			Log.d(TAG, "Set invisible");
		}
		notifyDataSetChanged();
	}

	private class PostingFilter extends android.widget.Filter{

		//ArrayList<Posting> pList;
		
		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			FilterResults results = new FilterResults();
		    // We implement here the filter logic
		    if (constraint == null || constraint.length() == 0) {
		        // No filter implemented we return all the list
		        results.values = allObjects;
		        results.count = allObjects.size();
		    }
		    else {
		        // We perform filtering operation
		        List<Posting> nPlanetList = new ArrayList<Posting>();
		         
		        for (T p : object) {
		            if (((Posting) p).getDesc().toUpperCase().contains(constraint.toString().toUpperCase()))
		                nPlanetList.add((Posting) p);
		        }
		         
		        results.values = nPlanetList;
		        results.count = nPlanetList.size();
		 
		    }
		    return results;
		}

		@SuppressWarnings("unchecked")
		@Override
		protected void publishResults(CharSequence constraint, FilterResults results) {
			// Now we have to inform the adapter about the new list filtered
		    if (results.count == 0)
		        notifyDataSetInvalidated();
		    else {
		        object = (List<T>) results.values;
		        notifyDataSetChanged();
		    }
			
		}

	}
	
}
	
