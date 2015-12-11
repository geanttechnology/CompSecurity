// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.aio.downloader.adapter.RingtoneListviewAdapter;
import com.aio.downloader.model.Model;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.refresh.PullableListView;
import com.aio.downloader.utils.DisplayUtil;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.Player;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class Ringtone_Recent_Fragment extends Fragment
    implements com.aio.downloader.refresh.PullableListView.OnLoadListener, OnDismissCallback, android.view.View.OnClickListener
{
    class Mya1 extends AsyncTask
    {

        final Ringtone_Recent_Fragment this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/ringtone_list_more.php?tab=recent&page=")).append(page).toString());
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            if (s == null)
            {
                return;
            } else
            {
                ShowResult(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }

        Mya1()
        {
            this$0 = Ringtone_Recent_Fragment.this;
            super();
        }
    }

    class SeekBarChangeEvent
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        int progress;
        final Ringtone_Recent_Fragment this$0;

        public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            try
            {
                progress = (player.mediaPlayer.getDuration() * i) / seekbar.getMax();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (SeekBar seekbar)
            {
                return;
            }
        }

        public void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public void onStopTrackingTouch(SeekBar seekbar)
        {
            player.mediaPlayer.seekTo(progress);
        }

        SeekBarChangeEvent()
        {
            this$0 = Ringtone_Recent_Fragment.this;
            super();
        }
    }


    private RingtoneListviewAdapter adapter;
    private ImageView cha;
    private TextView currenttime;
    Handler handler;
    private BroadcastReceiver hiderecentringtone;
    private Boolean istag;
    private ArrayList list;
    private PullableListView listView;
    private Model model;
    private SeekBar musicProgress;
    int mytotaltime;
    private int next;
    private int page;
    private RelativeLayout playbar;
    private Player player;
    private ImageView playpause;
    private ProgressWheel progressWheel;
    private publicTools publictools;
    BroadcastReceiver showBroadcast;
    private BroadcastReceiver showrecentringtone;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;
    private TimerTask task;
    private Timer timer;
    private TextView title;
    private TextView totaltime;

    public Ringtone_Recent_Fragment()
    {
        showrecentringtone = new BroadcastReceiver() {

            final Ringtone_Recent_Fragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = Ringtone_Recent_Fragment.this;
                super();
            }
        };
        hiderecentringtone = new BroadcastReceiver() {

            final Ringtone_Recent_Fragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
            }

            
            {
                this$0 = Ringtone_Recent_Fragment.this;
                super();
            }
        };
        handler = new Handler() {

            final Ringtone_Recent_Fragment this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (message.what)
                {
                default:
                    return;

                case 400: 
                    break;
                }
                try
                {
                    currenttime.setText((new StringBuilder(String.valueOf(Player.formatTime(player.mediaPlayer.getCurrentPosition())))).toString());
                    if (playbar.getVisibility() == 8)
                    {
                        player.pause();
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    return;
                }
            }

            
            {
                this$0 = Ringtone_Recent_Fragment.this;
                super();
            }
        };
        showBroadcast = new BroadcastReceiver() {

            final Ringtone_Recent_Fragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                totaltime.setText((new StringBuilder(String.valueOf(Player.formatTime(player.mediaPlayer.getDuration())))).toString());
                mytotaltime = player.mediaPlayer.getDuration();
                getActivity().unregisterReceiver(this);
            }

            
            {
                this$0 = Ringtone_Recent_Fragment.this;
                super();
            }
        };
        list = new ArrayList();
        progressWheel = null;
        page = 1;
        next = 1;
        istag = Boolean.valueOf(true);
        mytotaltime = 0;
        publictools = null;
    }

    private void RingtonerecentlistViewbottom()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)listView.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(getActivity(), 50F));
        listView.setLayoutParams(layoutparams);
    }

    private void Ringtonerexentplaybarbottom()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)listView.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(getActivity(), 50F));
        listView.setLayoutParams(layoutparams);
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parseRingtonelist(s));
        if (page == 1)
        {
            adapter = new RingtoneListviewAdapter(getActivity(), list, "ringtonerecent");
            listView.setAdapter(adapter);
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapter);
            swingBottomInAnimationAdapter.setListView(listView);
            listView.setAdapter(swingBottomInAnimationAdapter);
        }
        listView.setHasMoreData(true);
        progressWheel.setVisibility(8);
        adapter.notifyDataSetChanged();
    }

    private void failfile()
    {
        publicTools.ringtone_recent_handler = new Handler() {

            private String id;
            final Ringtone_Recent_Fragment this$0;
            private String type;

            public void handleMessage(Message message)
            {
                type = message.getData().getString("type");
                id = message.getData().getString("id");
                message.what;
                JVM INSTR tableswitch 1212 1212: default 48
            //                           1212 54;
                   goto _L1 _L2
_L1:
                super.handleMessage(message);
                return;
_L2:
                (new Thread(new Runnable() {

                    final _cls5 this$1;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/report_fail.php?type=")).append(type).append("&id=").append(id).toString());
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                })).start();
                if (true) goto _L1; else goto _L3
_L3:
            }



            
            {
                this$0 = Ringtone_Recent_Fragment.this;
                super();
            }
        };
    }

    private void init(View view)
    {
        publictools = new publicTools(getActivity());
        progressWheel = (ProgressWheel)view.findViewById(0x7f070072);
        listView = (PullableListView)view.findViewById(0x7f07006f);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
        (new Mya1()).execute(new Void[0]);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Ringtone_Recent_Fragment this$0;

            public void onItemClick(AdapterView adapterview, View view1, int i, long l)
            {
                adapterview = getActivity().getSharedPreferences("ringtone_recent_data", 0).edit();
                adapterview.putInt("ringtone_recent_selector", i);
                adapterview.commit();
                playbar.setVisibility(0);
                title.setText(((DownloadMovieItem)list.get(i)).getTitle());
                playpause.setBackgroundResource(0x7f02015e);
                (i. new AsyncTask() {

                    final _cls6 this$1;
                    private final int val$arg2;

                    protected volatile transient Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        avoid = publicTools.getUrl((new StringBuilder("http://t.zedge.net/ringtone/")).append(((DownloadMovieItem)list.get(arg2)).getId()).append("/?page=1").toString());
                        HashMap hashmap = new HashMap();
                        hashmap.put("content", avoid);
                        avoid = publicTools.doHttpPost((new StringBuilder("http://android.downloadatoz.com/_201409/market/ringtone_pdt_parser.php?content=")).append(((DownloadMovieItem)list.get(arg2)).getId()).toString(), hashmap);
                        Log.e("olol", (new StringBuilder("rrrrjsondata=")).append(avoid).toString());
                        try
                        {
                            avoid = new JSONObject(avoid);
                            if (avoid.getInt("status") == 1)
                            {
                                model = new Model();
                                model.setRingtoneurl(avoid.getString("url"));
                            }
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void avoid[])
                        {
                            avoid.printStackTrace();
                        }
                        try
                        {
                            player.playUrl(model.getRingtoneurl());
                            timer = new Timer();
                            task = new TimerTask() {

                                final _cls1 this$2;

                                public void run()
                                {
                                    Message message = new Message();
                                    message.what = 400;
                                    handler.sendMessage(message);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            };
                            timer.schedule(task, 0L, 1000L);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Void avoid[]) { }
                        return null;
                    }

                    protected volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((Void)obj);
                    }

                    protected void onPostExecute(Void void1)
                    {
                        super.onPostExecute(void1);
                        progressWheel.setVisibility(8);
                        if (void1 != null);
                    }

                    protected void onPreExecute()
                    {
                        super.onPreExecute();
                        progressWheel.setVisibility(0);
                    }


            
            {
                this$1 = final__pcls6;
                arg2 = I.this;
                super();
            }
                }).execute(new Void[0]);
                adapter.notifyDataSetChanged();
            }


            
            {
                this$0 = Ringtone_Recent_Fragment.this;
                super();
            }
        });
    }

    private void init2(View view)
    {
        playpause = (ImageView)view.findViewById(0x7f0700e5);
        cha = (ImageView)view.findViewById(0x7f0700e8);
        playbar = (RelativeLayout)view.findViewById(0x7f0700e4);
        totaltime = (TextView)view.findViewById(0x7f0700ec);
        currenttime = (TextView)view.findViewById(0x7f0700ea);
        title = (TextView)view.findViewById(0x7f0700e7);
        musicProgress = (SeekBar)view.findViewById(0x7f0700eb);
        playpause.setOnClickListener(this);
        cha.setOnClickListener(this);
        musicProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
        player = new Player(getActivity(), musicProgress);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131165414: 
        case 2131165415: 
        default:
            return;

        case 2131165413: 
            if (istag.booleanValue())
            {
                player.pause();
                playpause.setBackgroundResource(0x7f02015a);
                istag = Boolean.valueOf(false);
                return;
            } else
            {
                player.play();
                playpause.setBackgroundResource(0x7f02015e);
                istag = Boolean.valueOf(true);
                return;
            }

        case 2131165416: 
            player.pause();
            playpause.setBackgroundResource(0x7f02015e);
            istag = Boolean.valueOf(true);
            playbar.setVisibility(8);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030012, null, false);
        Myutils.getInstance();
        Myutils.type_current = "ringtone_recent";
        init(layoutinflater);
        init2(layoutinflater);
        failfile();
        viewgroup = new IntentFilter();
        viewgroup.addAction("showrecentringtone");
        getActivity().registerReceiver(showrecentringtone, viewgroup);
        viewgroup = new IntentFilter();
        viewgroup.addAction("hiderecentringtone");
        getActivity().registerReceiver(hiderecentringtone, viewgroup);
        viewgroup = new IntentFilter();
        viewgroup.addAction("show");
        getActivity().registerReceiver(showBroadcast, viewgroup);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (timer != null)
        {
            timer.cancel();
            timer = null;
        }
        if (task != null)
        {
            task.cancel();
            task = null;
        }
        try
        {
            player.pause();
            player.stop();
        }
        catch (Exception exception) { }
        if (player != null)
        {
            player = null;
        }
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onLoad(PullableListView pullablelistview)
    {
        if (list.size() > 0)
        {
            next = ((DownloadMovieItem)list.get(list.size() - 1)).getHas_next_page();
        }
        if (next == 1)
        {
            page = page + 1;
            (new Mya1()).execute(new Void[0]);
            return;
        } else
        {
            listView.setHasMoreData(false);
            return;
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
