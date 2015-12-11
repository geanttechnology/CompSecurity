// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.gotv.crackle.adapters.ExpandListAdapter;
import com.gotv.crackle.model.MediaListItem;

public class SeasonEpisodeFragment extends Fragment
    implements com.gotv.crackle.adapters.ExpandListAdapter.ExpandListListener
{
    public static interface ShowDetailsSeasonEpisodeListener
    {

        public abstract void onEpisodeClicked(MediaListItem medialistitem);
    }


    private ExpandableListView mExpandList;
    private ExpandListAdapter mListAdapter;
    private ShowDetailsSeasonEpisodeListener mListener;
    private View mPlaylistGradient;

    public SeasonEpisodeFragment()
    {
    }

    public void displayPlaylistGradient()
    {
        mPlaylistGradient.setVisibility(0);
    }

    public void expandList(int i)
    {
        mExpandList.expandGroup(i);
    }

    public void hidePlaylistGradient()
    {
        mPlaylistGradient.setVisibility(4);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mListener = (ShowDetailsSeasonEpisodeListener)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement ShowDetailsSeasonEpisodeListener.").toString());
        }
    }

    public void onChildItemClicked(MediaListItem medialistitem)
    {
        mListener.onEpisodeClicked(medialistitem);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030069, viewgroup, false);
        mPlaylistGradient = layoutinflater.findViewById(0x7f0a0163);
        mExpandList = (ExpandableListView)layoutinflater.findViewById(0x7f0a0162);
        return layoutinflater;
    }

    public void setPlaylistAdapter(final ExpandListAdapter listAdapter)
    {
        mListAdapter = listAdapter;
        mExpandList.setAdapter(mListAdapter);
        if (mListAdapter.getPlaylistSize() == 1)
        {
            mExpandList.expandGroup(0);
        }
        mListAdapter.setOnChildItemClickedListener(this);
        mExpandList.setOnChildClickListener(new android.widget.ExpandableListView.OnChildClickListener() {

            final SeasonEpisodeFragment this$0;
            final ExpandListAdapter val$listAdapter;

            public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
            {
                expandablelistview = (MediaListItem)listAdapter.getChild(i, j);
                mListener.onEpisodeClicked(expandablelistview);
                return true;
            }

            
            {
                this$0 = SeasonEpisodeFragment.this;
                listAdapter = expandlistadapter;
                super();
            }
        });
    }

}
