// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BackedUpFragment extends Fragment
{
    class MusicListAdapter extends BaseAdapter
    {

        private String appName;
        private ImageView my_delete_movie;
        private TextView my_stop_download_bt;
        final BackedUpFragment this$0;
        private TextView tv_backupapksize;
        private TextView tv_backupapkversion;

        public int getCount()
        {
            return list.size();
        }

        public Object getItem(int i)
        {
            return list.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            Object obj;
            ImageView imageview;
            long l;
            viewgroup = view;
            if (view == null)
            {
                viewgroup = getActivity().getLayoutInflater().inflate(0x7f030069, null);
            }
            obj = (TextView)viewgroup.findViewById(0x7f0700f0);
            imageview = (ImageView)viewgroup.findViewById(0x7f0700ef);
            my_stop_download_bt = (TextView)viewgroup.findViewById(0x7f0700f2);
            final Object packageName = viewgroup.findViewById(0x7f07027e);
            my_delete_movie = (ImageView)viewgroup.findViewById(0x7f0700ee);
            tv_backupapkversion = (TextView)viewgroup.findViewById(0x7f07027f);
            tv_backupapksize = (TextView)viewgroup.findViewById(0x7f070280);
            view = (String)list.get(i);
            PackageManager packagemanager = getActivity().getPackageManager();
            PackageInfo packageinfo = packagemanager.getPackageArchiveInfo(view, 1);
            float f;
            ApplicationInfo applicationinfo;
            String s;
            if (i == 0)
            {
                ((View) (packageName)).setVisibility(0);
            } else
            {
                ((View) (packageName)).setVisibility(8);
            }
            if (packageinfo == null)
            {
                break MISSING_BLOCK_LABEL_467;
            }
            applicationinfo = packageinfo.applicationInfo;
            applicationinfo.sourceDir = view;
            applicationinfo.publicSourceDir = view;
            appName = packagemanager.getApplicationLabel(applicationinfo).toString();
            packageName = applicationinfo.packageName;
            s = packageinfo.versionName;
            imageview.setBackgroundDrawable(packagemanager.getApplicationIcon(applicationinfo));
            ((TextView) (obj)).setText(appName);
            tv_backupapkversion.setText((new StringBuilder("Version:")).append(s).toString());
            obj = getActivity().getPackageManager().getPackageInfo(((String) (packageName)), 0);
            if (obj != null) goto _L2; else goto _L1
_L1:
            try
            {
                my_stop_download_bt.setText("Install");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
            }
            my_stop_download_bt.setOnClickListener(view. new android.view.View.OnClickListener() {

                private PackageInfo pInfo;
                final MusicListAdapter this$1;
                private final String val$archiveFilePath;
                private final String val$packageName;

                public void onClick(View view)
                {
                    try
                    {
                        pInfo = getActivity().getPackageManager().getPackageInfo(packageName, 0);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view) { }
                    Log.e("backup", (new StringBuilder("packageinfo=")).append(pInfo).toString());
                    if (pInfo == null)
                    {
                        Log.e("backup", (new StringBuilder("click=")).append(archiveFilePath).toString());
                        view = new Intent("android.intent.action.VIEW");
                        view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(archiveFilePath).toString()), "application/vnd.android.package-archive");
                        view.setFlags(0x10000000);
                        getActivity().startActivity(view);
                        return;
                    } else
                    {
                        Toast.makeText(getActivity(), "App is already installed.", 0).show();
                        return;
                    }
                }

            
            {
                this$1 = final_musiclistadapter;
                packageName = s;
                archiveFilePath = String.this;
                super();
            }
            });
            l = (new File(packageinfo.applicationInfo.publicSourceDir)).length() / 1024L;
            f = (float)((double)(int)(((double)l / 1024D) * 100D) / 100D);
            if (l >= 1024L)
            {
                tv_backupapksize.setText((new StringBuilder(String.valueOf(f))).append("MB").toString());
            } else
            {
                tv_backupapksize.setText((new StringBuilder(String.valueOf(l))).append("KB").toString());
            }
_L4:
            my_delete_movie.setOnClickListener(i. new android.view.View.OnClickListener() {

                final MusicListAdapter this$1;
                private final int val$position;

                public void onClick(View view)
                {
                    view = new File((String)list.get(position));
                    if (view.exists())
                    {
                        view.delete();
                    }
                    list.remove(position);
                    ma.notifyDataSetChanged();
                    Toast.makeText(getActivity(), "Delete successfully", 0).show();
                }

            
            {
                this$1 = final_musiclistadapter;
                position = I.this;
                super();
            }
            });
            return viewgroup;
_L2:
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_284;
            }
            my_stop_download_bt.setText("Installed");
            break MISSING_BLOCK_LABEL_284;
            imageview.setBackgroundResource(0x7f02006f);
            ((TextView) (obj)).setText(appName);
            if (true) goto _L4; else goto _L3
_L3:
        }


        MusicListAdapter()
        {
            this$0 = BackedUpFragment.this;
            super();
        }
    }


    protected static final int SEARCH_MUSIC_SUCCESS = 0;
    private final String BACKUP = "backup";
    private Handler hander;
    private List list;
    private LinearLayout ll_downnull;
    private ListView lv_uninstall;
    private MusicListAdapter ma;
    BroadcastReceiver onClickReceiver;

    public BackedUpFragment()
    {
        hander = new Handler() {

            final BackedUpFragment this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    return;

                case 0: // '\0'
                    ma = new MusicListAdapter();
                    lv_uninstall.setAdapter(ma);
                    return;

                case 100: // 'd'
                    break;
                }
                if (list.size() == 0)
                {
                    ll_downnull.setVisibility(0);
                    return;
                } else
                {
                    ll_downnull.setVisibility(8);
                    return;
                }
            }

            
            {
                this$0 = BackedUpFragment.this;
                super();
            }
        };
        onClickReceiver = new BroadcastReceiver() {

            final BackedUpFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                Log.e("backup", "onClickReceiver");
                list = new ArrayList();
                if (Environment.getExternalStorageState().equals("mounted"))
                {
                    if (list.size() == 0)
                    {
                        (new Thread(new Runnable() {

                            String ext[] = {
                                ".apk"
                            };
                            File file;
                            final _cls2 this$1;

                            public void run()
                            {
                                search(file, ext);
                                hander.sendEmptyMessage(0);
                            }

            
            {
                this$1 = _cls2.this;
                super();
                file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIO_BACKUPAPP").toString());
            }
                        })).start();
                    }
                    return;
                } else
                {
                    Toast.makeText(getActivity(), "Please insert an external storage device..", 1).show();
                    return;
                }
            }


            
            {
                this$0 = BackedUpFragment.this;
                super();
            }
        };
    }

    private void search(File file, String as[])
    {
        if (file == null) goto _L2; else goto _L1
_L1:
        if (!file.isDirectory())
        {
            break MISSING_BLOCK_LABEL_44;
        }
        file = file.listFiles();
        if (file == null) goto _L2; else goto _L3
_L3:
        int i = 0;
_L5:
        if (i < file.length) goto _L4; else goto _L2
_L2:
        return;
_L4:
        search(file[i], as);
        i++;
          goto _L5
        file = file.getAbsolutePath();
        int j = 0;
        while (j < as.length) 
        {
            if (file.endsWith(as[j]))
            {
                list.add(file);
                return;
            }
            j++;
        }
          goto _L2
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
        list = new ArrayList();
        (new Timer()).schedule(new TimerTask() {

            final BackedUpFragment this$0;

            public void run()
            {
                Message message = new Message();
                message.what = 100;
                hander.sendMessage(message);
            }

            
            {
                this$0 = BackedUpFragment.this;
                super();
            }
        }, 0L, 1000L);
        viewgroup = new IntentFilter();
        viewgroup.addAction("backup");
        getActivity().registerReceiver(onClickReceiver, viewgroup);
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            if (list.size() == 0)
            {
                (new Thread(new Runnable() {

                    String ext[] = {
                        ".apk"
                    };
                    File file;
                    final BackedUpFragment this$0;

                    public void run()
                    {
                        search(file, ext);
                        hander.sendEmptyMessage(0);
                    }

            
            {
                this$0 = BackedUpFragment.this;
                super();
                file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIO_BACKUPAPP").toString());
            }
                })).start();
            }
            return layoutinflater;
        } else
        {
            Toast.makeText(getActivity(), "Please insert an external storage device..", 1).show();
            return layoutinflater;
        }
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
