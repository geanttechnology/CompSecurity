// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.aio.downloader.adapter.VideoDownloadedAdapter;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.DisplayUtil;
import com.aio.downloader.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends Fragment
{

    private VideoDownloadedAdapter adapter;
    private TextView appnotice;
    private TypeDbUtils dbUtils;
    private List listdd;
    private BroadcastReceiver mBroadcastReceiver_delete;
    private ListView video_lv;
    private BroadcastReceiver videosuccessful;
    private View view;

    public VideoFragment()
    {
        mBroadcastReceiver_delete = new BroadcastReceiver() {

            private int pos;
            final VideoFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                pos = intent.getIntExtra("position", 0);
                (new android.app.AlertDialog.Builder(getActivity())).setTitle(getString(0x7f0b0034)).setMessage((new StringBuilder(String.valueOf(getString(0x7f0b003c)))).append(((DownloadMovieItem)listdd.get(pos)).getFilePath()).append("?").toString()).setNegativeButton(getString(0x7f0b003b), new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }).setPositiveButton(getString(0x7f0b003c), new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dbUtils.deletefile(((DownloadMovieItem)listdd.get(pos)).getFile_id());
                        dialoginterface = new File(((DownloadMovieItem)listdd.get(pos)).getFilePath());
                        if (dialoginterface.exists())
                        {
                            dialoginterface.delete();
                        }
                        listdd.remove(pos);
                        adapter.notifyDataSetChanged();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }).show();
            }



            
            {
                this$0 = VideoFragment.this;
                super();
            }
        };
        videosuccessful = new BroadcastReceiver() {

            final VideoFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = listdd;
                Myutils.getInstance();
                context.add(Myutils.successItem);
                video_lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            
            {
                this$0 = VideoFragment.this;
                super();
            }
        };
        adapter = null;
        dbUtils = null;
    }

    private void ApppopulistViewbottom()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)video_lv.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(getActivity(), 50F));
        video_lv.setLayoutParams(layoutparams);
    }

    private void init(View view1)
    {
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(getActivity());
        }
        listdd = dbUtils.queryApk("video", "timesort");
        if (listdd == null)
        {
            listdd = new ArrayList();
        }
        appnotice = (TextView)view1.findViewById(0x7f0703f6);
        video_lv = (ListView)view1.findViewById(0x7f0703f5);
        adapter = new VideoDownloadedAdapter(getActivity(), listdd);
        video_lv.setAdapter(adapter);
    }

    public void VideoSort(String s)
    {
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(getActivity());
        }
        listdd = dbUtils.queryApk("video", s);
        if (listdd == null)
        {
            listdd = new ArrayList();
        }
        video_lv = (ListView)view.findViewById(0x7f0703f5);
        adapter = new VideoDownloadedAdapter(getActivity(), listdd);
        video_lv.setAdapter(adapter);
    }

    public void Videodeletall()
    {
        dbUtils.deleteallfile("video");
        int i = 0;
        do
        {
            if (i >= listdd.size())
            {
                listdd.removeAll(listdd);
                adapter.notifyDataSetChanged();
                return;
            }
            File file = new File(((DownloadMovieItem)listdd.get(i)).getFilePath());
            if (file.exists())
            {
                file.delete();
            }
            i++;
        } while (true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        view = layoutinflater.inflate(0x7f0300bc, null, false);
        layoutinflater = new IntentFilter();
        layoutinflater.addAction("videodelete");
        getActivity().registerReceiver(mBroadcastReceiver_delete, layoutinflater);
        layoutinflater = new IntentFilter();
        layoutinflater.addAction("videosuccessful");
        getActivity().registerReceiver(videosuccessful, layoutinflater);
        init(view);
        ApppopulistViewbottom();
        return view;
    }

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(getActivity());
    }

    public void onResume()
    {
        super.onResume();
        if (listdd.size() > 0)
        {
            appnotice.setVisibility(8);
        }
        adapter.notifyDataSetChanged();
        MobclickAgent.onResume(getActivity());
    }




}
