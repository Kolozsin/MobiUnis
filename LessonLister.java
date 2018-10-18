package kono.mobiuni.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import kono.mobiuni.R;
import kono.mobiuni.View.Classes.Lesson;

public class LessonLister extends Fragment {


    //TODO: Kiadni a MainActivity-nek az utsaítást, hogy nyissa meg a LessonViewer Activity-t az innen kapott ID-val


    ArrayList<Lesson> ListedItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mockingTheList();
        View view = inflater.inflate(R.layout.lister_fragment, container, false);
        ListedItemAdapter adapter = new ListedItemAdapter(this.getContext(), R.layout.lister_fragment_item, ListedItems);
        ListView lw = view.findViewById(R.id.listView);
        lw.setAdapter(adapter);
        final LessonLister that = this;
        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String fullLessonContent="";
                //fullLessonContent  =  getFullLesson(ListedItems.get(position).getLessonId());

            }
        });

        return view;


    }



    //only for test purposes
    private void mockingTheList() {
        ListedItems.add(new Lesson(2.3, "lesson1", "Math"));
        ListedItems.add(new Lesson(4.3, "lesson2", "Biology"));
        ListedItems.add(new Lesson(3.3, "lesson3", "Math"));
        ListedItems.add(new Lesson(5.0, "lesson4", "Chemistry"));
        ListedItems.add(new Lesson(3.2, "lesson5", "Math"));
        ListedItems.add(new Lesson(1.3, "lesson6", "Informatics"));
        ListedItems.add(new Lesson(2.3, "lesson7", "Physics"));


    }
}

