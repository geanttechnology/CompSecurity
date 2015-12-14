// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.livemixtapes.profile.SelectedPlayList;
import com.livemixtapes.ui.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            ProfileFragment, ImageLoader, User

public class activity extends BaseAdapter
{

    private BaseActivity activity;
    private LayoutInflater inflater;
    final ProfileFragment this$0;

    public int getCount()
    {
        return profileList.size();
    }

    public Object getItem(int i)
    {
        return profileList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(final int position, final View map, final ViewGroup map)
    {
        View view;
        ImageView imageview;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        if (inflater == null)
        {
            inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
        }
        view = inflater.inflate(0x7f030032, null);
        imageview = (ImageView)view.findViewById(0x7f08004d);
        obj2 = (TextView)view.findViewById(0x7f08004e);
        obj = (LinearLayout)view.findViewById(0x7f0800ed);
        map = (HorizontalScrollView)((LinearLayout) (obj)).findViewById(0x7f0800ee);
        obj1 = (LinearLayout)map.findViewById(0x7f0800ef);
        ((Button)view.findViewById(0x7f0800ec)).setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileFragment.ProfileListAdapter this$1;
            private final int val$position;

            public void onClick(View view1)
            {
                if (position == 0)
                {
                    openSeeAllFragment(1);
                    return;
                }
                if (position == 1)
                {
                    openSeeAllFragment(2);
                    return;
                } else
                {
                    openSeeAllFragment(3);
                    return;
                }
            }

            
            {
                this$1 = ProfileFragment.ProfileListAdapter.this;
                position = i;
                super();
            }
        });
        obj3 = (String)profileList.get(position);
        map = "Playlists";
        map.setVisibility(8);
        if (!((String) (obj3)).equals("Playlists")) goto _L2; else goto _L1
_L1:
        int i;
        map = "profile_playlists";
        ((TextView) (obj2)).setText((new StringBuilder(String.valueOf(obj3))).append(" (").append(playlistList.size()).append(")").toString());
        if (playlistList.size() < 3)
        {
            position = playlistList.size();
        } else
        {
            position = 3;
        }
        i = 0;
_L5:
        if (i < position) goto _L4; else goto _L3
_L3:
        imageview.setImageResource(getResources().getIdentifier(map, "drawable", activity.getPackageName()));
        return view;
_L4:
        map = (Map)playlistList.get(i);
        obj1 = inflater.inflate(0x7f030033, null);
        ((View) (obj1)).setLayoutParams(new android.widget.r.inflater(-1, -2));
        obj2 = (ImageView)((View) (obj1)).findViewById(0x7f0800f1);
        obj3 = (TextView)((View) (obj1)).findViewById(0x7f0800f3);
        TextView textview = (TextView)((View) (obj1)).findViewById(0x7f0800f4);
        ((TextView) (obj3)).setText(map.get("title").toString());
        textview.setText((new StringBuilder(String.valueOf(((ArrayList)map.get("tracks")).size()))).append(" songs").toString());
        ((ImageView) (obj2)).setVisibility(8);
        ((View) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileFragment.ProfileListAdapter this$1;
            private final Map val$map;

            public void onClick(View view1)
            {
                SelectedPlayList.map = map;
                view1 = activity.getAnimatedFragmentTransaction();
                view1.replace(0x7f0800cc, new SelectedPlayList(), "SELECTED").addToBackStack(null);
                view1.commit();
            }

            
            {
                this$1 = ProfileFragment.ProfileListAdapter.this;
                map = map1;
                super();
            }
        });
        ((LinearLayout) (obj)).addView(((View) (obj1)));
        i++;
          goto _L5
_L2:
        if (!((String) (obj3)).equals("Downloads"))
        {
            continue; /* Loop/switch isn't completed */
        }
        map = "profile_downloads";
        ((TextView) (obj2)).setText((new StringBuilder(String.valueOf(obj3))).append(" (").append(downloadList.size()).append(")").toString());
        obj1 = downloadList.iterator();
_L7:
        map = map;
        if (!((Iterator) (obj1)).hasNext()) goto _L3; else goto _L6
_L6:
        map = (Map)((Iterator) (obj1)).next();
        obj2 = inflater.inflate(0x7f030033, null);
        ((View) (obj2)).setLayoutParams(new android.widget.r.inflater(-1, -2));
        obj3 = (ImageView)((View) (obj2)).findViewById(0x7f0800f1);
        TextView textview1 = (TextView)((View) (obj2)).findViewById(0x7f0800f3);
        TextView textview2 = (TextView)((View) (obj2)).findViewById(0x7f0800f4);
        textview1.setText(map.get("title").toString());
        position = Math.round(Integer.parseInt(map.get("duration").toString()) / 60);
        textview2.setText((new StringBuilder(String.valueOf(map.get("count").toString()))).append(" songs, ").append(position).append(" min").toString());
        ((ImageView) (obj3)).setVisibility(0);
        ((View) (obj2)).setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileFragment.ProfileListAdapter this$1;
            private final String val$albumId;

            public void onClick(View view1)
            {
                (new ProfileFragment.LoadDownloadData(this$0)).execute(new String[] {
                    albumId
                });
            }

            
            {
                this$1 = ProfileFragment.ProfileListAdapter.this;
                albumId = s;
                super();
            }
        });
        imageLoader.DisplayImage((String)map.get("image"), ((ImageView) (obj3)));
        ((LinearLayout) (obj)).addView(((View) (obj2)));
          goto _L7
        if (!User.isLogged().booleanValue()) goto _L3; else goto _L8
_L8:
        map.setVisibility(0);
        ((TextView) (obj2)).setText(((CharSequence) (obj3)));
        map = "profile_favorites";
        ((TextView) (obj2)).setText((new StringBuilder(String.valueOf(obj3))).append(" (").append(User.getData().albumId.size()).append(")").toString());
        obj = User.getData().albumId.iterator();
_L10:
        map = map;
        if (!((Iterator) (obj)).hasNext()) goto _L3; else goto _L9
_L9:
        map = (Map)((Iterator) (obj)).next();
        ImageView imageview1 = new ImageView(activity);
        position = (int)(50F * getResources().getDisplayMetrics().density + 0.5F);
        android.widget.r r = new android.widget.r.activity(position, position);
        r.s(10, 5, 10, 5);
        imageview1.setLayoutParams(r);
        imageview1.setImageResource(0x7f02005b);
        imageview1.setScaleType(android.widget.s);
        imageview1.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileFragment.ProfileListAdapter this$1;
            private final Map val$map;

            public void onClick(View view1)
            {
                showMixtapeFragment(activity, (HashMap)map);
            }

            
            {
                this$1 = ProfileFragment.ProfileListAdapter.this;
                map = map1;
                super();
            }
        });
        imageLoader.DisplayImage((String)map.get("thumbnail"), imageview1);
        ((LinearLayout) (obj1)).addView(imageview1);
          goto _L10
    }



    public _cls4.val.map(BaseActivity baseactivity)
    {
        this$0 = ProfileFragment.this;
        super();
        activity = baseactivity;
    }
}
