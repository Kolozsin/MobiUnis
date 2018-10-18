package kono.mobiuni.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import kono.mobiuni.R;
import kono.mobiuni.View.Classes.Lesson;

class ListedItemAdapter extends ArrayAdapter<Lesson> {

    private Context mContext;
    int mresource;

    public ListedItemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Lesson> lessons) {
        super(context, resource, lessons);
        mContext = context;
        mresource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String lessonName = getItem(position).getName();
        String imgName = getItem(position).getCategoryImg();
        double rating = getItem(position).getRating();

        Lesson lesson = new Lesson(rating,lessonName,imgName);


        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mresource,parent,false);

        TextView tvname = convertView.findViewById(R.id.AdapterItemName);
        TextView tvrating = convertView.findViewById(R.id.AdapterItemRating);
        ImageView imageView = convertView.findViewById(R.id.AdapterItemImage);
        tvname.setText(lessonName);
        tvrating.setText(Double.toString(rating));
        imageView.setImageResource(R.mipmap.ic_launcher);
        return convertView;
    }
}
