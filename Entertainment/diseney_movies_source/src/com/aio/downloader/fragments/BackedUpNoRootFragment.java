// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.db.TypeDbUtilsBackup;
import com.aio.downloader.model.BackupModel;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BackedUpNoRootFragment extends Fragment
{
    class MusicListAdapter extends BaseAdapter
    {

        private String appName;
        private ImageView my_delete_movie;
        private TextView my_stop_download_bt;
        private String packageName;
        final BackedUpNoRootFragment this$0;
        private TextView tv_backupapksize;
        private TextView tv_backupapkversion;

        public int getCount()
        {
            return listdd.size();
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = getActivity().getLayoutInflater().inflate(0x7f030069, null);
            }
            TextView textview = (TextView)viewgroup.findViewById(0x7f0700f0);
            ImageView imageview = (ImageView)viewgroup.findViewById(0x7f0700ef);
            my_stop_download_bt = (TextView)viewgroup.findViewById(0x7f0700f2);
            view = viewgroup.findViewById(0x7f07027e);
            my_delete_movie = (ImageView)viewgroup.findViewById(0x7f0700ee);
            tv_backupapkversion = (TextView)viewgroup.findViewById(0x7f07027f);
            tv_backupapksize = (TextView)viewgroup.findViewById(0x7f070280);
            Object obj;
            String s;
            if (i == 0)
            {
                view.setVisibility(0);
            } else
            {
                view.setVisibility(8);
            }
            s = ((BackupModel)listdd.get(i)).getPackage_name();
            view = null;
            obj = getActivity().getPackageManager().getPackageInfo(s, 0);
            view = ((View) (obj));
_L1:
            textview.setText(((BackupModel)listdd.get(i)).getApp_name());
            tv_backupapkversion.setText((new StringBuilder("Version:")).append(((BackupModel)listdd.get(i)).getVersion()).toString());
            tv_backupapksize.setText(((BackupModel)listdd.get(i)).getSize());
            obj = BackedUpNoRootFragment.stringtoBitmap(((BackupModel)listdd.get(i)).getImg());
            imageview.setBackgroundDrawable(bitmap2Drawable(((Bitmap) (obj))));
            android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
            if (view == null)
            {
                my_stop_download_bt.setText("Install");
            } else
            if (view != null)
            {
                my_stop_download_bt.setText("Installed");
            }
            my_stop_download_bt.setOnClickListener(s. new android.view.View.OnClickListener() {

                final MusicListAdapter this$1;
                private final String val$archiveFilePath;

                public void onClick(View view)
                {
                    view = null;
                    android.content.pm.PackageInfo packageinfo = getActivity().getPackageManager().getPackageInfo(archiveFilePath, 0);
                    view = packageinfo;
_L2:
                    Log.e("backup", (new StringBuilder("packageInfo=")).append(view).toString());
                    if (view == null)
                    {
                        view = new Intent(getActivity(), com/aio/downloader/activity/AppDetailsActivity);
                        view.putExtra("myid", archiveFilePath);
                        view.putExtra("linkurl", "");
                        view.setFlags(0x10000000);
                        getActivity().startActivity(view);
                        return;
                    } else
                    {
                        Toast.makeText(getActivity(), "App is already installed.", 0).show();
                        return;
                    }
                    Exception exception;
                    exception;
                    if (true) goto _L2; else goto _L1
_L1:
                }

            
            {
                this$1 = final_musiclistadapter;
                archiveFilePath = String.this;
                super();
            }
            });
            my_delete_movie.setOnClickListener(i. new android.view.View.OnClickListener() {

                final MusicListAdapter this$1;
                private final int val$position;

                public void onClick(View view)
                {
                    dbUtils.deletefile(((BackupModel)listdd.get(position)).getPackage_name());
                    listdd = dbUtils.queryApk("game_app", "timesort");
                    if (listdd == null)
                    {
                        listdd = new ArrayList();
                    }
                    musicListAdapter = new MusicListAdapter();
                    lv_uninstall.setAdapter(musicListAdapter);
                    musicListAdapter.notifyDataSetChanged();
                    Toast.makeText(getActivity(), "Delete successfully", 0).show();
                }

            
            {
                this$1 = final_musiclistadapter;
                position = I.this;
                super();
            }
            });
            return viewgroup;
            namenotfoundexception;
            namenotfoundexception.printStackTrace();
              goto _L1
        }


        MusicListAdapter()
        {
            this$0 = BackedUpNoRootFragment.this;
            super();
        }
    }


    private TypeDbUtilsBackup dbUtils;
    private Handler handler;
    private List listdd;
    private LinearLayout ll_downnull;
    private ListView lv_uninstall;
    private MusicListAdapter musicListAdapter;

    public BackedUpNoRootFragment()
    {
        dbUtils = null;
        handler = new Handler() {

            final BackedUpNoRootFragment this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                if (message.what != 100)
                {
                    break MISSING_BLOCK_LABEL_158;
                }
                listdd = dbUtils.queryApk("game_app", "timesort");
                if (listdd == null)
                {
                    listdd = new ArrayList();
                }
                musicListAdapter = new MusicListAdapter();
                lv_uninstall.setAdapter(musicListAdapter);
                if (listdd.size() == 0)
                {
                    ll_downnull.setVisibility(0);
                    lv_uninstall.setVisibility(8);
                    return;
                }
                try
                {
                    ll_downnull.setVisibility(8);
                    lv_uninstall.setVisibility(0);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message) { }
            }

            
            {
                this$0 = BackedUpNoRootFragment.this;
                super();
            }
        };
    }

    public static Bitmap stringtoBitmap(String s)
    {
        try
        {
            s = Base64.decode(s, 0);
            s = BitmapFactory.decodeByteArray(s, 0, s.length);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    Drawable bitmap2Drawable(Bitmap bitmap)
    {
        return new BitmapDrawable(bitmap);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300b6, null, false);
        ((LinearLayout)layoutinflater.findViewById(0x7f0703d8)).setVisibility(8);
        lv_uninstall = (ListView)layoutinflater.findViewById(0x7f0703da);
        ll_downnull = (LinearLayout)layoutinflater.findViewById(0x7f07018b);
        viewgroup = (TextView)layoutinflater.findViewById(0x7f0703db);
        bundle = (ImageView)layoutinflater.findViewById(0x7f07018d);
        viewgroup.setVisibility(8);
        bundle.setVisibility(8);
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtilsBackup(getActivity());
        }
        (new Timer()).schedule(new TimerTask() {

            final BackedUpNoRootFragment this$0;

            public void run()
            {
                Message message = new Message();
                message.what = 100;
                handler.sendMessage(message);
            }

            
            {
                this$0 = BackedUpNoRootFragment.this;
                super();
            }
        }, 0L, 1000L);
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(getActivity());
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(getActivity());
    }








}
