// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.fragments.player;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import my.googlemusic.play.application.App;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Song;

public class CoverFragment extends Fragment
    implements android.view.View.OnClickListener
{

    private ViewHolder mHolder;
    private Song mSong;

    public CoverFragment()
    {
    }

    private void initData()
    {
        mSong = (Song)App.getGson().fromJson(getArguments().getString("song"), my/googlemusic/play/model/Song);
    }

    private void initView(View view)
    {
    /* block-local class not found */
    class ViewHolder {}

        mHolder = new ViewHolder(null);
        mHolder.container = view.findViewById(0x7f0d01df);
        mHolder.hits = (TextView)view.findViewById(0x7f0d01e0);
        mHolder.likes = (TextView)view.findViewById(0x7f0d01e1);
        mHolder.cover = (ImageView)view.findViewById(0x7f0d01de);
        mHolder.comments = (TextView)view.findViewById(0x7f0d01e2);
        Picasso.with(getActivity()).load(mSong.getAlbum().getImage()).fit().centerCrop().placeholder(0x7f0201dc).into(mHolder.cover);
        mHolder.hits.setText(String.valueOf(mSong.getAlbum().getHits()));
        mHolder.likes.setText(String.valueOf(mSong.getAlbum().getLikes()));
        mHolder.comments.setText(String.valueOf(mSong.getAlbum().getCommentsCount()));
        view = mHolder.container;
        byte byte0;
        if (mSong.getId() == 0L)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
        if (mSong.getId() == 0L)
        {
            mHolder.cover.setOnClickListener(this);
        }
    }

    public static CoverFragment newInstance(Song song)
    {
        CoverFragment coverfragment = new CoverFragment();
        Bundle bundle = new Bundle();
        bundle.putString("song", App.getGson().toJson(song));
        coverfragment.setArguments(bundle);
        return coverfragment;
    }

    public void onClick(View view)
    {
        if (mHolder.cover == view)
        {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(mSong.getAlbum().getLink())));
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03005a, viewgroup, false);
        initData();
        initView(layoutinflater);
        return layoutinflater;
    }
}
