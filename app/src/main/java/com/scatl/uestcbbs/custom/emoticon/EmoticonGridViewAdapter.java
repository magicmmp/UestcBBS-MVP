package com.scatl.uestcbbs.custom.emoticon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.scatl.uestcbbs.R;
import com.scatl.uestcbbs.base.BaseEvent;
import com.scatl.uestcbbs.custom.imageview.RoundImageView;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

public class EmoticonGridViewAdapter extends BaseAdapter {
    private Context context;
    private List<String> img_path;

    private HashMap<Integer, View> viewMap;

    public EmoticonGridViewAdapter(Context context, List<String> img_path) {
        this.context = context;
        this.img_path = img_path;
        viewMap = new HashMap<>();
    }

    @Override
    public int getCount() {
        return img_path.size();
    }

    @Override
    public Object getItem(int i) {
        return img_path.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (!viewMap.containsKey(i) || viewMap.get(i) == null) {

            view = LayoutInflater.from(context).inflate(R.layout.item_emotion_gridview, new RelativeLayout(context));
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.item_emotion_gridview_img);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventBus.getDefault().post(new BaseEvent<>(BaseEvent.EventCode.INSERT_EMOTION, img_path.get(i)));
                }
            });

            view.setTag(holder);
            viewMap.put(i, view);

        } else {
            view = viewMap.get(i);
            holder = (ViewHolder) view.getTag();
        }

        Glide.with(context).load(img_path.get(i)).into(holder.imageView);

        return view;
    }

    public static class ViewHolder {
        RoundImageView imageView;
    }
}
