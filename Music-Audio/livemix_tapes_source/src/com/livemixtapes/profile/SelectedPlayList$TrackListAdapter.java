// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.livemixtapes.Utils;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.livemixtapes.profile:
//            SelectedPlayList

public class activity extends BaseAdapter
{

    private Activity activity;
    private LayoutInflater inflater;
    final SelectedPlayList this$0;

    private void insert(Object obj, int i)
    {
        trackList.add(i, (Map)obj);
    }

    private void remove(Object obj)
    {
        trackList.remove(obj);
    }

    public int getCount()
    {
        return trackList.size();
    }

    public Object getItem(int i)
    {
        return trackList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (inflater == null)
        {
            inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
        }
        viewgroup = inflater.inflate(0x7f030040, null);
        final Map trackMap = (Map)trackList.get(i);
        TextView textview = (TextView)viewgroup.findViewById(0x7f080136);
        TextView textview1 = (TextView)viewgroup.findViewById(0x7f080139);
        ImageButton imagebutton = (ImageButton)viewgroup.findViewById(0x7f0800f0);
        LinearLayout linearlayout = (LinearLayout)viewgroup.findViewById(0x7f08013a);
        FrameLayout framelayout = (FrameLayout)viewgroup.findViewById(0x7f080137);
        if (i < 9)
        {
            view = "0";
        } else
        {
            view = "";
        }
        textview.setText((new StringBuilder(String.valueOf(view))).append(i + 1).append(".").toString());
        view = Utils.formatDuration(Double.valueOf(trackMap.get("track_duration").toString()).doubleValue());
        textview1.setText((new StringBuilder(String.valueOf(trackMap.get("track_title").toString()))).append(" (").append(view).append(")").toString());
        if (isEditMode)
        {
            imagebutton.setVisibility(0);
            linearlayout.setVisibility(0);
            framelayout.setVisibility(8);
            textview.setText("");
            imagebutton.setOnClickListener(new android.view.View.OnClickListener() {

                final SelectedPlayList.TrackListAdapter this$1;
                private final Map val$trackMap;

                public void onClick(View view1)
                {
                    adapter.remove(trackMap);
                    adapter.notifyDataSetChanged();
                    (new SelectedPlayList.ReorderOrDeleteTracks(this$0, 2)).execute(new String[] {
                        trackMap.get("track_dbid").toString()
                    });
                }

            
            {
                this$1 = SelectedPlayList.TrackListAdapter.this;
                trackMap = map;
                super();
            }
            });
            return viewgroup;
        } else
        {
            textview.setVisibility(0);
            imagebutton.setVisibility(8);
            linearlayout.setVisibility(8);
            framelayout.setVisibility(0);
            return viewgroup;
        }
    }




    public _cls1.val.trackMap(Activity activity1)
    {
        this$0 = SelectedPlayList.this;
        super();
        activity = activity1;
    }
}
