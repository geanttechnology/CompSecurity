// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.livemixtapes:
//            Mixtape, ImageLoader, Utils

public class LazyAdapterTracks extends BaseAdapter
{
    static class ViewHolder
    {

        ImageButton downloadBtn;
        TextView id;
        ProgressBar progressBar;
        View selectionView;
        TextView title;

        ViewHolder()
        {
        }
    }


    public ArrayList data;
    public ImageLoader imageLoader;
    private LayoutInflater inflater;
    public Mixtape mixTape;

    public LazyAdapterTracks(Mixtape mixtape, ArrayList arraylist)
    {
        inflater = null;
        data = arraylist;
        mixTape = mixtape;
        inflater = (LayoutInflater)mixtape.getActivity().getSystemService("layout_inflater");
        imageLoader = new ImageLoader(mixtape.getActivity().getApplicationContext());
    }

    public int getCount()
    {
        return data.size();
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        new ViewHolder();
        ViewHolder viewholder = new ViewHolder();
        viewgroup = inflater.inflate(0x7f03003f, viewgroup, false);
        viewholder.id = (TextView)viewgroup.findViewById(0x7f080136);
        viewholder.title = (TextView)viewgroup.findViewById(0x7f080139);
        viewholder.progressBar = (ProgressBar)viewgroup.findViewById(0x7f080138);
        viewholder.downloadBtn = (ImageButton)viewgroup.findViewById(0x7f0800df);
        viewholder.selectionView = viewgroup.findViewById(0x7f080134);
        view = (String)((HashMap)data.get(position)).get("track_id");
        if (mixTape.playlistMode.booleanValue())
        {
            viewholder.downloadBtn.setVisibility(8);
            viewholder.progressBar.setVisibility(8);
            viewholder.selectionView.setVisibility(0);
            TextView textview;
            if (mixTape.selectedPlayListTracks.contains(view))
            {
                viewholder.selectionView.setBackgroundColor(Color.parseColor("#000080"));
            } else
            {
                viewholder.selectionView.setBackgroundResource(0x7f020062);
            }
        } else
        {
            viewholder.selectionView.setVisibility(8);
            if (Utils.isFileExists(mixTape.getActivity(), view))
            {
                if (mixTape.downloadProgressList.containsKey(view))
                {
                    int i = mixTape.getIndividualFileProgress(view);
                    if (i == 100)
                    {
                        viewholder.downloadBtn.setVisibility(4);
                        viewholder.progressBar.setVisibility(4);
                    } else
                    {
                        viewholder.downloadBtn.setVisibility(0);
                        viewholder.progressBar.setVisibility(0);
                        viewholder.downloadBtn.setImageResource(0x7f0200bd);
                        viewholder.progressBar.setProgress(i);
                    }
                } else
                {
                    viewholder.downloadBtn.setVisibility(4);
                    viewholder.progressBar.setVisibility(4);
                }
            } else
            {
                viewholder.downloadBtn.setVisibility(0);
                viewholder.progressBar.setVisibility(0);
                viewholder.downloadBtn.setImageResource(0x7f020095);
            }
            viewholder.downloadBtn.setOnClickListener(new android.view.View.OnClickListener() {

                final LazyAdapterTracks this$0;
                private final int val$position;

                public void onClick(View view1)
                {
                    try
                    {
                        mixTape.download(position);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view1)
                    {
                        return;
                    }
                }

            
            {
                this$0 = LazyAdapterTracks.this;
                position = i;
                super();
            }
            });
        }
        textview = viewholder.id;
        if (position < 9)
        {
            view = "0";
        } else
        {
            view = "";
        }
        textview.setText((new StringBuilder(String.valueOf(view))).append(position + 1).append(".").toString());
        view = Utils.formatDuration(Double.valueOf((String)((HashMap)data.get(position)).get("track_duration")).doubleValue());
        viewholder.title.setText((new StringBuilder(String.valueOf((String)((HashMap)data.get(position)).get("track_title")))).append(" (").append(view).append(")").toString());
        return viewgroup;
    }

    public void setData(Mixtape mixtape, ArrayList arraylist)
    {
        mixTape = mixtape;
        data = arraylist;
        inflater = (LayoutInflater)mixtape.getActivity().getSystemService("layout_inflater");
        imageLoader = new ImageLoader(mixtape.getActivity());
    }
}
