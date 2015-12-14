// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.livemixtapes.ImageLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.livemixtapes.profile:
//            SeeAllList

public class activity extends BaseAdapter
{

    private Activity activity;
    private LayoutInflater inflater;
    final SeeAllList this$0;

    public int getCount()
    {
        return playList.size();
    }

    public Object getItem(int i)
    {
        return playList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, final ViewGroup map)
    {
        if (inflater == null)
        {
            inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
        }
        view = inflater.inflate(0x7f030033, null);
        map = (Map)playList.get(i);
        ImageView imageview = (ImageView)view.findViewById(0x7f0800f1);
        Object obj = (TextView)view.findViewById(0x7f0800f3);
        TextView textview = (TextView)view.findViewById(0x7f0800f4);
        ((TextView) (obj)).setText(map.get("title").toString());
        obj = (ImageButton)view.findViewById(0x7f0800f0);
        if (flag == 1)
        {
            imageview.setVisibility(8);
            textview.setText((new StringBuilder(String.valueOf(((ArrayList)map.get("tracks")).size()))).append(" songs").toString());
            if (isEditableMode)
            {
                ((ImageButton) (obj)).setVisibility(0);
                ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final SeeAllList.PlayListAdapter this$1;
                    private final Map val$map;

                    public void onClick(View view1)
                    {
                        (new SeeAllList.DeletePlaylist(this$0)).execute(new String[] {
                            map.get("playlist_id").toString()
                        });
                    }

            
            {
                this$1 = SeeAllList.PlayListAdapter.this;
                map = map1;
                super();
            }
                });
                return view;
            } else
            {
                ((ImageButton) (obj)).setVisibility(8);
                return view;
            }
        }
        if (flag == 2)
        {
            imageview.setVisibility(0);
            if (isEditableMode)
            {
                ((ImageButton) (obj)).setVisibility(0);
                ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                    final SeeAllList.PlayListAdapter this$1;
                    private final Map val$map;

                    public void onClick(View view1)
                    {
                        deleteDownload(map.get("albumId").toString());
                    }

            
            {
                this$1 = SeeAllList.PlayListAdapter.this;
                map = map1;
                super();
            }
                });
            } else
            {
                ((ImageButton) (obj)).setVisibility(8);
            }
            if (map.get("image").toString().length() > 0)
            {
                imageLoader.DisplayImage((String)map.get("image"), imageview);
            }
            i = Math.round(Integer.parseInt(map.get("duration").toString()) / 60);
            textview.setText((new StringBuilder()).append(map.get("count")).append(" songs, ").append(i).append(" min").toString());
            return view;
        }
        imageview.setVisibility(0);
        if (map.get("thumbnail").toString().length() > 0)
        {
            imageLoader.DisplayImage((String)map.get("thumbnail"), imageview);
        }
        textview.setText("");
        return view;
    }


    public _cls2.val.map(Activity activity1)
    {
        this$0 = SeeAllList.this;
        super();
        activity = activity1;
    }
}
