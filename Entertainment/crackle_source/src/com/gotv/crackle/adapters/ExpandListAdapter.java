// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gotv.crackle.Application;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.MediaListItem;
import com.gotv.crackle.util.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class ExpandListAdapter extends BaseExpandableListAdapter
{
    public static interface ExpandListListener
    {

        public abstract void onChildItemClicked(MediaListItem medialistitem);
    }


    private Context mContext;
    private ExpandListListener mListener;
    private List mPlaylist;
    private String mSelectedId;
    private View mSelectedView;

    public ExpandListAdapter(Context context, DetailsProvider detailsprovider)
    {
        mContext = context;
        mPlaylist = detailsprovider.getPlaylists();
    }

    public Object getChild(int i, int j)
    {
        return ((com.gotv.crackle.data.DetailsProvider.Playlist)mPlaylist.get(i)).mediaItemsList.get(j);
    }

    public long getChildId(int i, int j)
    {
        return (long)j;
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        final MediaListItem childItem = (MediaListItem)((com.gotv.crackle.data.DetailsProvider.Playlist)mPlaylist.get(i)).mediaItemsList.get(j);
        View view1 = view;
        if (view == null)
        {
            view1 = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x7f030049, null);
        }
        TextView textview;
        int k;
        if (mSelectedId != null)
        {
            if (childItem.getID().equalsIgnoreCase(mSelectedId))
            {
                if (Application.isFanhattan())
                {
                    view1.setBackgroundColor(mContext.getResources().getColor(0x7f070029));
                } else
                {
                    view1.setBackgroundColor(mContext.getResources().getColor(0x7f070021));
                }
            } else
            {
                view1.setBackgroundColor(mContext.getResources().getColor(0x106000d));
            }
        }
        textview = (TextView)view1.findViewById(0x7f0a0031);
        if (childItem.getSeason() == null || childItem.getSeason().equalsIgnoreCase("") || childItem.getEpisode() == null || childItem.getEpisode().equalsIgnoreCase(""))
        {
            view = childItem.getTitle();
        } else
        {
            view = (new StringBuilder()).append("S").append(childItem.getSeason()).append(" E").append(childItem.getEpisode()).append(": ").append(((MediaListItem)((com.gotv.crackle.data.DetailsProvider.Playlist)mPlaylist.get(i)).mediaItemsList.get(j)).getTitle()).toString();
        }
        textview.setText(view);
        view = (ProgressBar)view1.findViewById(0x7f0a00ee);
        view.getLayoutParams().width = viewgroup.getWidth() / 3;
        k = SharedPrefsManager.getPlayProgressForItem(childItem.getID());
        if (k > 0)
        {
            i = Integer.parseInt(DateTimeFormatter.getSecondsFromDurationString(((MediaListItem)((com.gotv.crackle.data.DetailsProvider.Playlist)mPlaylist.get(i)).mediaItemsList.get(j)).getDuration()));
            view.setProgress((int)Math.round(((double)k / (double)(i * 1000)) * 100D));
        }
        view = (ImageButton)view1.findViewById(0x7f0a007e);
        if (!Application.isLeanBack())
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final ExpandListAdapter this$0;
                final MediaListItem val$childItem;

                public void onClick(View view2)
                {
                    ((BaseActivity)mContext).playMediaItem(childItem.getID());
                }

            
            {
                this$0 = ExpandListAdapter.this;
                childItem = medialistitem;
                super();
            }
            });
            view1.setOnClickListener(new android.view.View.OnClickListener() {

                final ExpandListAdapter this$0;
                final MediaListItem val$childItem;

                public void onClick(View view2)
                {
                    mListener.onChildItemClicked(childItem);
                    if (Application.getInstance().isTablet())
                    {
                        if (mSelectedView != null)
                        {
                            mSelectedView.setBackgroundColor(mContext.getResources().getColor(0x7f07001b));
                        }
                        view2.setBackgroundColor(mContext.getResources().getColor(0x7f070021));
                        mSelectedView = view2;
                        mSelectedId = childItem.getID();
                    }
                }

            
            {
                this$0 = ExpandListAdapter.this;
                childItem = medialistitem;
                super();
            }
            });
            return view1;
        } else
        {
            view.setFocusable(false);
            return view1;
        }
    }

    public int getChildrenCount(int i)
    {
        return ((com.gotv.crackle.data.DetailsProvider.Playlist)mPlaylist.get(i)).mediaItemsList.size();
    }

    public Object getGroup(int i)
    {
        return ((com.gotv.crackle.data.DetailsProvider.Playlist)mPlaylist.get(i)).name;
    }

    public int getGroupCount()
    {
        return mPlaylist.size();
    }

    public long getGroupId(int i)
    {
        return (long)i;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view == null)
        {
            viewgroup = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x7f03004a, null);
        }
        view = (CheckedTextView)viewgroup.findViewById(0x7f0a00ef);
        view.setText(((com.gotv.crackle.data.DetailsProvider.Playlist)mPlaylist.get(i)).name.toUpperCase(Locale.getDefault()));
        view.setChecked(flag);
        return viewgroup;
    }

    public int getPlaylistSize()
    {
        return mPlaylist.size();
    }

    public boolean hasStableIds()
    {
        return true;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return true;
    }

    public void setOnChildItemClickedListener(ExpandListListener expandlistlistener)
    {
        mListener = expandlistlistener;
    }

    public void setSelectedId(String s)
    {
        mSelectedId = s;
    }





/*
    static View access$202(ExpandListAdapter expandlistadapter, View view)
    {
        expandlistadapter.mSelectedView = view;
        return view;
    }

*/


/*
    static String access$302(ExpandListAdapter expandlistadapter, String s)
    {
        expandlistadapter.mSelectedId = s;
        return s;
    }

*/
}
