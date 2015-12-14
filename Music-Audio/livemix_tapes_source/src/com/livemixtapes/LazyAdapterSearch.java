// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.livemixtapes.ui.widgets.SearchView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            SearchFragment, ImageLoader, Utils, MainActivity, 
//            NowPlayingActivity

public class LazyAdapterSearch extends BaseAdapter
{

    private static final int isSimpleSearch = 1;
    private static final int isTextBasedSearch = 2;
    public ArrayList data;
    private SearchFragment fragment;
    private ImageLoader imageLoader;
    private LayoutInflater inflater;
    private int isSimpleSearchOrComplexSearch;
    public boolean shouldShowTracks;
    private int targetHeight;
    public ArrayList trackResults;

    public LazyAdapterSearch(SearchFragment searchfragment)
    {
        shouldShowTracks = true;
        Object obj = searchfragment.getActivity().getApplicationContext();
        data = new ArrayList();
        trackResults = new ArrayList();
        inflater = (LayoutInflater)((Context) (obj)).getSystemService("layout_inflater");
        imageLoader = new ImageLoader(((Context) (obj)).getApplicationContext());
        obj = ((WindowManager)((Context) (obj)).getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((Display) (obj)).getMetrics(displaymetrics);
        targetHeight = (int)(0.15F * (float)displaymetrics.widthPixels);
        fragment = searchfragment;
    }

    private String getDurationString(String s)
    {
        int i = Integer.parseInt(s);
        return (new StringBuilder(String.valueOf(twoDigitString(i / 60)))).append(":").append(twoDigitString(i % 60)).toString();
    }

    private String twoDigitString(int i)
    {
        if (i == 0)
        {
            return "00";
        }
        if (i / 10 == 0)
        {
            return (new StringBuilder("0")).append(i).toString();
        } else
        {
            return String.valueOf(i);
        }
    }

    public void appendSearchResults(ArrayList arraylist, ArrayList arraylist1)
    {
        isSimpleSearchOrComplexSearch = 2;
        data.addAll(arraylist);
        trackResults.addAll(arraylist1);
        notifyDataSetChanged();
    }

    public void clear()
    {
        data.clear();
        trackResults.clear();
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

    public HashMap getResult(int i)
    {
        return (HashMap)data.get(i);
    }

    public View getView(final int position, final View obj, ViewGroup viewgroup)
    {
        if (isSimpleSearchOrComplexSearch != 1) goto _L2; else goto _L1
_L1:
        TextView textview;
        obj = inflater.inflate(0x7f03003a, null);
        viewgroup = (TextView)obj.findViewById(0x7f080104);
        textview = (TextView)obj.findViewById(0x7f080105);
        viewgroup.setText(((HashMap)data.get(position)).get("artist").toString());
        position = Integer.parseInt(((HashMap)data.get(position)).get("change").toString());
        if (position != 0) goto _L4; else goto _L3
_L3:
        textview.setText("");
_L6:
        return obj;
_L4:
        if (position > 0)
        {
            textview.setText((new StringBuilder("+")).append(position).toString());
            textview.setTextColor(Color.parseColor("#00A100"));
            return obj;
        } else
        {
            textview.setText((new StringBuilder(String.valueOf(position))).toString());
            textview.setTextColor(Color.parseColor("#F2003C"));
            return obj;
        }
_L2:
        viewgroup = inflater.inflate(0x7f030039, null);
        obj = (TextView)viewgroup.findViewById(0x7f0800bb);
        Object obj1 = (ImageView)viewgroup.findViewById(0x7f0800ba);
        LinearLayout linearlayout = (LinearLayout)viewgroup.findViewById(0x7f080103);
        ((ImageView) (obj1)).getLayoutParams().height = targetHeight;
        String s1 = Utils.getArtistAndTitle((Map)data.get(position));
        String s = fragment.searchView.getQuery().toString();
        Object obj2 = new SpannableString(s1);
        int i = s1.indexOf(s);
        if (i == -1)
        {
            obj.setText(s1);
        } else
        {
            ((Spannable) (obj2)).setSpan(new BackgroundColorSpan(-256), i, s.length() + i, 33);
            obj.setText(((CharSequence) (obj2)));
        }
        obj.bringToFront();
        imageLoader.DisplayImage(((HashMap)data.get(position)).get("thumbnail").toString(), ((ImageView) (obj1)));
        obj = viewgroup;
        if (!shouldShowTracks)
        {
            continue;
        }
        obj1 = ((ArrayList)((HashMap)data.get(position)).get("tracks")).iterator();
        do
        {
            obj = viewgroup;
            if (!((Iterator) (obj1)).hasNext())
            {
                continue;
            }
            obj = (HashMap)((Iterator) (obj1)).next();
            if (isTrackPresent((String)obj.get("track_id")))
            {
                TextView textview1 = new TextView(fragment.getActivity().getApplicationContext());
                textview1.setTextColor(0xff000000);
                obj2 = (new StringBuilder(String.valueOf(twoDigitString(Integer.parseInt((String)obj.get("track_number")))))).append(". ").append((String)obj.get("track_artist")).append(" - ").append((String)obj.get("track_title")).append(" (").append(getDurationString((String)obj.get("track_duration"))).append(")").toString();
                if (((String) (obj2)).contains(s))
                {
                    SpannableString spannablestring = new SpannableString(((CharSequence) (obj2)));
                    spannablestring.setSpan(new BackgroundColorSpan(-256), ((String) (obj2)).indexOf(s), s.length() + ((String) (obj2)).indexOf(s), 33);
                    textview1.setText(spannablestring);
                } else
                {
                    textview1.setText(((CharSequence) (obj2)));
                }
                textview1.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
                textview1.setClickable(true);
                textview1.setPadding(2, 8, 8, 5);
                textview1.setMaxLines(2);
                textview1.setTextSize(14F);
                textview1.setOnClickListener(new android.view.View.OnClickListener() {

                    final LazyAdapterSearch this$0;
                    private final HashMap val$obj;
                    private final int val$position;

                    public void onClick(View view)
                    {
                        Log.d("Nithin", "Clicked");
                        openNowPlaying((HashMap)data.get(position), position, obj);
                    }

            
            {
                this$0 = LazyAdapterSearch.this;
                position = i;
                obj = hashmap;
                super();
            }
                });
                linearlayout.addView(textview1);
            }
        } while (true);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean isTopArtistSearch()
    {
        return isSimpleSearchOrComplexSearch == 1;
    }

    public boolean isTrackPresent(String s)
    {
        if (trackResults == null || trackResults.size() == 0)
        {
            return true;
        }
        Iterator iterator = trackResults.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }
        } while (!((String)((HashMap)iterator.next()).get("track_id")).equals(s));
        return true;
    }

    void openNowPlaying(HashMap hashmap, int i, HashMap hashmap1)
    {
        fragment.shake(fragment.getActivity(), MainActivity.nowplayingbutton, null);
        NowPlayingActivity.mixtape = hashmap;
        NowPlayingActivity.flag = 2;
        hashmap = new ArrayList();
        hashmap.add(hashmap1);
        NowPlayingActivity.tracksList = hashmap;
        NowPlayingActivity.position = 0;
        NowPlayingActivity.flag = 2;
        MainActivity.isPlaying = true;
        NowPlayingActivity.initializeAndReload();
        MainActivity.nowplayingbutton.setImageResource(0x7f0200f8);
    }

    public void setTopArtists(ArrayList arraylist)
    {
        isSimpleSearchOrComplexSearch = 1;
        clear();
        data.addAll(arraylist);
        notifyDataSetChanged();
    }
}
