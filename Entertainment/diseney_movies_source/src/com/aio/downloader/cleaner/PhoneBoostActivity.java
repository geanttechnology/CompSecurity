// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.views.LImageButton;
import com.wjj.adapter.base.BoostPhoneAdapter;
import com.wjj.eneity.RuningApp;
import com.wjj.manager.BoostRuningAppManager;
import com.wjj.manager.CommonUtil;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity1

public class PhoneBoostActivity extends Activity
    implements android.view.View.OnClickListener
{

    private BoostPhoneAdapter adapter;
    private long allsize;
    private RuningApp app;
    private LImageButton back;
    private Button bt_clean;
    private Button bt_ing;
    private Button bt_stop;
    private Button deep_bt;
    private Handler handler;
    private int isover;
    private List listdata;
    private ListView lv_boost_list;
    private View mainview;
    private BoostRuningAppManager manager;
    private com.wjj.manager.BoostRuningAppManager.BoostRuningAppManagerListener mlistener;
    private int num;
    private ProgressBar pb_clean_cache;
    private ProgressBar pb_new;
    private PopupWindow pop;
    private TextView pop_baimingdan;
    private TextView pop_kuaijie;
    private TextView pop_xuanfu;
    private RelativeLayout rl_top;
    private TextView total_memory;
    private TextView tv_clean_cache_status;
    private TextView tv_danwei;
    private TextView tv_neicun;

    public PhoneBoostActivity()
    {
        handler = new Handler() {

            final PhoneBoostActivity this$0;

            public void handleMessage(Message message)
            {
                if (message.what != 6)
                {
                    if (message.what == 2)
                    {
                        listdata = (List)message.obj;
                        Log.e("toggletag", (new StringBuilder("listdata=")).append(listdata.size()).toString());
                        adapter.addData(listdata, true);
                        adapter.notifyDataSetChanged();
                    } else
                    if (message.what == 1)
                    {
                        PhoneBoostActivity phoneboostactivity = PhoneBoostActivity.this;
                        phoneboostactivity.allsize = phoneboostactivity.allsize + ((Long)message.obj).longValue();
                        tv_neicun.setText(CommonUtil.formatSize(allsize));
                        tv_danwei.setText(CommonUtil.formatSizeDanweiTwo(allsize));
                    } else
                    if (message.what == 3)
                    {
                        PhoneBoostActivity phoneboostactivity1 = PhoneBoostActivity.this;
                        phoneboostactivity1.num = phoneboostactivity1.num + 1;
                        pb_new.setProgress(num);
                        app = (RuningApp)message.obj;
                        tv_clean_cache_status.setText((new StringBuilder("Scan:")).append(app.runingsoftname).toString());
                    } else
                    if (message.what == 0 && isover == 1)
                    {
                        bt_stop.setVisibility(8);
                        bt_clean.setVisibility(0);
                        tv_clean_cache_status.setVisibility(4);
                        total_memory.setText((new StringBuilder("Selected memory:")).append(CommonUtil.formatSize(allsize)).append(CommonUtil.formatSizeDanweiTwo(allsize)).toString());
                    }
                }
                switch (message.what)
                {
                default:
                    return;

                case 10: // '\n'
                    rl_top.setBackgroundColor(Color.parseColor("#3E56B1"));
                    return;

                case 20: // '\024'
                    rl_top.setBackgroundColor(Color.parseColor("#3B62A8"));
                    return;

                case 30: // '\036'
                    rl_top.setBackgroundColor(Color.parseColor("#3967A4"));
                    return;

                case 40: // '('
                    rl_top.setBackgroundColor(Color.parseColor("#386BA1"));
                    return;

                case 50: // '2'
                    rl_top.setBackgroundColor(Color.parseColor("#376F9E"));
                    return;

                case 60: // '<'
                    rl_top.setBackgroundColor(Color.parseColor("#36739B"));
                    return;

                case 70: // 'F'
                    rl_top.setBackgroundColor(Color.parseColor("#357699"));
                    return;

                case 80: // 'P'
                    rl_top.setBackgroundColor(Color.parseColor("#347A96"));
                    return;

                case 90: // 'Z'
                    rl_top.setBackgroundColor(Color.parseColor("#337C94"));
                    return;

                case 100: // 'd'
                    rl_top.setBackgroundColor(Color.parseColor("#337F92"));
                    return;

                case 110: // 'n'
                    rl_top.setBackgroundColor(Color.parseColor("#31848E"));
                    return;

                case 120: // 'x'
                    rl_top.setBackgroundColor(Color.parseColor("#30878C"));
                    return;

                case 130: 
                    rl_top.setBackgroundColor(Color.parseColor("#2F8B89"));
                    return;

                case 140: 
                    rl_top.setBackgroundColor(Color.parseColor("#2E9085"));
                    return;

                case 150: 
                    rl_top.setBackgroundColor(Color.parseColor("#2D9482"));
                    return;

                case 160: 
                    rl_top.setBackgroundColor(Color.parseColor("#2C997E"));
                    return;

                case 170: 
                    rl_top.setBackgroundColor(Color.parseColor("#2C9E7A"));
                    return;

                case 180: 
                    rl_top.setBackgroundColor(Color.parseColor("#2CA277"));
                    return;

                case 190: 
                    rl_top.setBackgroundColor(Color.parseColor("#2CA574"));
                    return;

                case 200: 
                    rl_top.setBackgroundColor(Color.parseColor("#2CA971"));
                    break;
                }
            }

            
            {
                this$0 = PhoneBoostActivity.this;
                super();
            }
        };
        mlistener = new com.wjj.manager.BoostRuningAppManager.BoostRuningAppManagerListener() {

            final PhoneBoostActivity this$0;

            public void DownCountSize(long l, RuningApp runingapp)
            {
                Message message = new Message();
                message.obj = Long.valueOf(l);
                message.what = 1;
                handler.sendMessage(message);
                message = new Message();
                listdata.add(runingapp);
                message.obj = listdata;
                message.what = 2;
                handler.sendMessage(message);
                message = new Message();
                message.obj = runingapp;
                message.what = 3;
                handler.sendMessage(message);
            }

            
            {
                this$0 = PhoneBoostActivity.this;
                super();
            }
        };
    }

    private void AsyncData()
    {
        (new Thread() {

            final PhoneBoostActivity this$0;

            public void run()
            {
                isover = manager.getRuningUserApp(mlistener);
                handler.sendEmptyMessage(0);
                super.run();
            }

            
            {
                this$0 = PhoneBoostActivity.this;
                super();
            }
        }).start();
    }

    private void asyPb()
    {
        (new Thread() {

            final PhoneBoostActivity this$0;

            public void run()
            {
                int i = 0;
                do
                {
                    if (i >= 101)
                    {
                        return;
                    }
                    try
                    {
                        sleep(15L);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                    pb_clean_cache.setProgress(i);
                    if (pb_clean_cache.getProgress() == 5)
                    {
                        handler.sendEmptyMessage(10);
                    }
                    if (pb_clean_cache.getProgress() == 10)
                    {
                        handler.sendEmptyMessage(20);
                    }
                    if (pb_clean_cache.getProgress() == 15)
                    {
                        handler.sendEmptyMessage(30);
                    }
                    if (pb_clean_cache.getProgress() == 20)
                    {
                        handler.sendEmptyMessage(40);
                    }
                    if (pb_clean_cache.getProgress() == 25)
                    {
                        handler.sendEmptyMessage(50);
                    }
                    if (pb_clean_cache.getProgress() == 30)
                    {
                        handler.sendEmptyMessage(60);
                    }
                    if (pb_clean_cache.getProgress() == 35)
                    {
                        handler.sendEmptyMessage(70);
                    }
                    if (pb_clean_cache.getProgress() == 40)
                    {
                        handler.sendEmptyMessage(80);
                    }
                    if (pb_clean_cache.getProgress() == 45)
                    {
                        handler.sendEmptyMessage(90);
                    }
                    if (pb_clean_cache.getProgress() == 50)
                    {
                        handler.sendEmptyMessage(100);
                    }
                    if (pb_clean_cache.getProgress() == 55)
                    {
                        handler.sendEmptyMessage(110);
                    }
                    if (pb_clean_cache.getProgress() == 60)
                    {
                        handler.sendEmptyMessage(120);
                    }
                    if (pb_clean_cache.getProgress() == 65)
                    {
                        handler.sendEmptyMessage(130);
                    }
                    if (pb_clean_cache.getProgress() == 70)
                    {
                        handler.sendEmptyMessage(140);
                    }
                    if (pb_clean_cache.getProgress() == 75)
                    {
                        handler.sendEmptyMessage(150);
                    }
                    if (pb_clean_cache.getProgress() == 80)
                    {
                        handler.sendEmptyMessage(160);
                    }
                    if (pb_clean_cache.getProgress() == 85)
                    {
                        handler.sendEmptyMessage(170);
                    }
                    if (pb_clean_cache.getProgress() == 90)
                    {
                        handler.sendEmptyMessage(180);
                    }
                    if (pb_clean_cache.getProgress() == 95)
                    {
                        handler.sendEmptyMessage(190);
                    }
                    if (pb_clean_cache.getProgress() == 100)
                    {
                        handler.sendEmptyMessage(200);
                    }
                    i++;
                } while (true);
            }

            
            {
                this$0 = PhoneBoostActivity.this;
                super();
            }
        }).start();
    }

    private void initView()
    {
        deep_bt = (Button)findViewById(0x7f07007f);
        deep_bt.setOnClickListener(new android.view.View.OnClickListener() {

            final PhoneBoostActivity this$0;

            public void onClick(View view)
            {
            }

            
            {
                this$0 = PhoneBoostActivity.this;
                super();
            }
        });
        rl_top = (RelativeLayout)findViewById(0x7f070076);
        pb_clean_cache = (ProgressBar)findViewById(0x7f07007b);
        pb_new = (ProgressBar)findViewById(0x7f07007c);
        bt_clean = (Button)findViewById(0x7f070081);
        bt_ing = (Button)findViewById(0x7f070082);
        bt_stop = (Button)findViewById(0x7f07004f);
        back = (LImageButton)findViewById(0x7f070077);
        bt_clean.setOnClickListener(this);
        bt_ing.setOnClickListener(this);
        bt_stop.setOnClickListener(this);
        back.setOnClickListener(this);
        total_memory = (TextView)findViewById(0x7f07007e);
        tv_clean_cache_status = (TextView)findViewById(0x7f07007d);
        tv_danwei = (TextView)findViewById(0x7f070079);
        tv_neicun = (TextView)findViewById(0x7f070078);
        listdata = new ArrayList();
        lv_boost_list = (ListView)findViewById(0x7f070080);
        manager = new BoostRuningAppManager(getApplicationContext());
        adapter = new BoostPhoneAdapter(getApplicationContext());
        lv_boost_list.setAdapter(adapter);
        lv_boost_list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PhoneBoostActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (((RuningApp)listdata.get(i)).ischecked)
                {
                    ((RuningApp)listdata.get(i)).ischecked = false;
                    adapter.notifyDataSetChanged();
                    return;
                } else
                {
                    ((RuningApp)listdata.get(i)).ischecked = true;
                    adapter.notifyDataSetChanged();
                    return;
                }
            }

            
            {
                this$0 = PhoneBoostActivity.this;
                super();
            }
        });
    }

    private void showNorma()
    {
        (new com.aio.downloader.views.LAlertDialog.Builder(this)).setTitle("Notice").setMessage("Are you sure to stop scanning ?").setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {

            final PhoneBoostActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = PhoneBoostActivity.this;
                super();
            }
        }).setPositiveButton("Stop", new android.content.DialogInterface.OnClickListener() {

            final PhoneBoostActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                bt_stop.setVisibility(8);
                bt_clean.setVisibility(0);
            }

            
            {
                this$0 = PhoneBoostActivity.this;
                super();
            }
        }).show();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131165263: 
        default:
            return;

        case 2131165303: 
            finish();
            return;

        case 2131165313: 
            bt_clean.setVisibility(8);
            break;
        }
        bt_ing.setVisibility(0);
        int i = 0;
        do
        {
            if (i >= listdata.size())
            {
                view = new Intent(getApplicationContext(), com/aio/downloader/cleaner/ShowCleanActivity1);
                view.putExtra("juti", (int)(allsize / 1024L));
                startActivity(view);
                finish();
                return;
            }
            manager.Killprogress(((RuningApp)listdata.get(i)).packname);
            i++;
        } while (true);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03000b);
        initView();
        AsyncData();
        asyPb();
    }























}
