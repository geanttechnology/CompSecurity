// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.aio.downloader.views.LImageButton;
import com.wjj.adapter.base.ApkSoftAdapter;
import com.wjj.adapter.base.JunkBoostAdapter;
import com.wjj.adapter.base.JunkCacheAdapter;
import com.wjj.adapter.base.JunkCanliuAdapter;
import com.wjj.eneity.Canliu;
import com.wjj.eneity.RubSoftware;
import com.wjj.eneity.RuningApp;
import com.wjj.eneity.SoftApk;
import com.wjj.manager.RubSoftwareManager;
import com.wjj.manager.RuningAppManager;
import com.wjj.manager.SoftApkManager;
import com.wjj.manager.UnloadingResidueManager;
import com.wjj.utils.CommonUtil;
import com.wjj.utils.MyListView;
import com.wjj.utils.StickyLayout;
import com.xiaos.adapter.PinnedHeaderExpandableAdapter;
import com.xiaos.view.PinnedHeaderExpandableListView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity1

public class JunkActivity extends Activity
    implements android.view.View.OnClickListener, com.wjj.utils.StickyLayout.OnGiveUpTouchEventListener
{
    class GroupClickListener
        implements android.widget.ExpandableListView.OnGroupClickListener
    {

        final JunkActivity this$0;

        public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l1)
        {
            if (expandFlag == -1)
            {
                explistview.expandGroup(i);
                explistview.setSelectedGroup(i);
                expandFlag = i;
            } else
            if (expandFlag == i)
            {
                explistview.collapseGroup(expandFlag);
                expandFlag = -1;
            } else
            {
                explistview.collapseGroup(expandFlag);
                explistview.expandGroup(i);
                explistview.setSelectedGroup(i);
                expandFlag = i;
            }
            return true;
        }

        GroupClickListener()
        {
            this$0 = JunkActivity.this;
            super();
        }
    }


    protected static final int APK_EVERY_COUNT = 7;
    protected static final int SEARCH_APK_SUCCESS = 954;
    private PinnedHeaderExpandableAdapter adapter;
    private long allapksize;
    private long allboostsize;
    private long allcachesize;
    private long allcanliusize;
    private int allok;
    private TextView apk_num;
    private ApkSoftAdapter apkadapter;
    private List apkdata;
    private List apkpath;
    private JunkBoostAdapter boostadapter;
    private TextView bost_num;
    private Button bt_clean;
    private Button bt_cleaning;
    private Button bt_stop;
    private TextView cache_num;
    private JunkCacheAdapter cacheadapter;
    private List cachelist;
    private com.wjj.manager.RubSoftwareManager.RubSoftwareManagerListener cachelistener;
    private JunkCanliuAdapter canliuAdapter;
    private TextView canliu_num;
    private List cllist;
    private LinearLayout content_one;
    private LinearLayout content_two;
    private List emptyfile;
    private int er;
    private int expandFlag;
    private PinnedHeaderExpandableListView explistview;
    private int four;
    private String groupData[];
    private String groupsize[];
    private Handler handler;
    private LImageButton header_left_back;
    private ImageView iv_apkall;
    private ImageView iv_cacheall;
    private ImageView iv_canliuall;
    private ImageView iv_ncall;
    private com.xiaos.adapter.PinnedHeaderExpandableAdapter.GroupCheckListener l;
    private List list;
    private MyListView lv_apk;
    private MyListView lv_canliu;
    private MyListView lv_huancun;
    private MyListView lv_neicun;
    private ProgressBar nc_pb;
    private List newapkpath;
    private int num2;
    private int one;
    private ProgressBar pb_apk;
    private ProgressBar pb_canliu;
    private ProgressBar progressBarcache;
    private TextView rub_center;
    private TextView rub_total;
    private RubSoftwareManager rubmamager;
    private RuningAppManager runappmana;
    private com.wjj.manager.RuningAppManager.RuningAppManagerListener runlistener;
    private SoftApkManager sm;
    private com.wjj.manager.SoftApkManager.SoftApkManagerListener2 smListener;
    private StickyLayout stickyLayout;
    ScrollView sticky_content;
    private RelativeLayout sticky_header;
    private int three;
    private TextView tv_scan;
    private int two;
    private UnloadingResidueManager urm;

    public JunkActivity()
    {
        handler = new Handler() {

            final JunkActivity this$0;

            public void handleMessage(Message message)
            {
                if (message.what == 1)
                {
                    list = (List)message.obj;
                    nc_pb.setVisibility(8);
                    iv_ncall.setVisibility(0);
                    message = JunkActivity.this;
                    message.allok = ((JunkActivity) (message)).allok + 1;
                    one = 1;
                } else
                if (message.what == 2)
                {
                    JunkActivity junkactivity = JunkActivity.this;
                    junkactivity.allboostsize = junkactivity.allboostsize + ((Long)message.obj).longValue();
                    bost_num.setText(CommonUtil.formatSize(allboostsize));
                    rub_total.setText(CommonUtil.formatSize(allboostsize + allcachesize + allcanliusize + allapksize));
                } else
                if (message.what == 22)
                {
                    message = (RuningApp)message.obj;
                    tv_scan.setText((new StringBuilder("Scanning:")).append(((RuningApp) (message)).runingsoftname).toString());
                } else
                if (message.what == 3)
                {
                    cachelist = (List)message.obj;
                    cacheadapter.addData(cachelist, true);
                    cacheadapter.notifyDataSetChanged();
                    progressBarcache.setVisibility(8);
                    iv_cacheall.setVisibility(0);
                    message = JunkActivity.this;
                    message.allok = ((JunkActivity) (message)).allok + 1;
                    two = 1;
                } else
                {
label0:
                    {
                        if (message.what != 4)
                        {
                            break label0;
                        }
                        JunkActivity junkactivity1 = JunkActivity.this;
                        junkactivity1.allcachesize = junkactivity1.allcachesize + ((Long)message.obj).longValue();
                        cache_num.setText(CommonUtil.formatSize(allcachesize));
                        rub_total.setText(CommonUtil.formatSize(allboostsize + allcachesize + allcanliusize + allapksize));
                    }
                }
_L1:
                if (allok == 4)
                {
                    bt_stop.setVisibility(8);
                    bt_clean.setVisibility(0);
                    tv_scan.setVisibility(8);
                    rub_center.setText((new StringBuilder("Selected junk:")).append(CommonUtil.formatSize(allboostsize + allcachesize + allcanliusize + allapksize)).toString());
                    groupsize[0] = CommonUtil.formatSize(allboostsize);
                    groupsize[1] = CommonUtil.formatSize(allcachesize);
                    groupsize[2] = CommonUtil.formatSize(allcanliusize);
                    groupsize[3] = CommonUtil.formatSize(allapksize);
                    sticky_content.setVisibility(8);
                    content_two.setVisibility(0);
                    adapter = new PinnedHeaderExpandableAdapter(list, cachelist, apkdata, cllist, groupData, getApplicationContext(), explistview, groupsize, l);
                    explistview.setAdapter(adapter);
                }
                return;
                int i;
                if (message.what != 5)
                {
                    break MISSING_BLOCK_LABEL_1030;
                }
                emptyfile = (List)message.obj;
                i = 0;
_L2:
label1:
                {
                    if (i < emptyfile.size())
                    {
                        break label1;
                    }
                    canliuAdapter.addData(cllist, true);
                    canliuAdapter.notifyDataSetChanged();
                    pb_canliu.setVisibility(8);
                    iv_canliuall.setVisibility(0);
                    rub_total.setText(CommonUtil.formatSize(allboostsize + allcachesize + allcanliusize + allapksize));
                    message = JunkActivity.this;
                    message.allok = ((JunkActivity) (message)).allok + 1;
                    three = 1;
                }
                  goto _L1
                message = JunkActivity.this;
                message.allcanliusize = ((JunkActivity) (message)).allcanliusize + ((File)emptyfile.get(i)).length();
                canliu_num.setText(CommonUtil.formatSize(allcanliusize));
                message = new Canliu();
                message.runingsoftname = ((File)emptyfile.get(i)).getName();
                message.memory = ((File)emptyfile.get(i)).length();
                message.ischecked = true;
                message.path = ((File)emptyfile.get(i)).getAbsolutePath();
                cllist.add(message);
                i++;
                  goto _L2
                if (message.what != 954) goto _L4; else goto _L3
_L3:
                i = 0;
_L9:
                int j = apkpath.size();
                if (i < j) goto _L6; else goto _L5
_L5:
                i = 0;
_L10:
                if (i < newapkpath.size()) goto _L8; else goto _L7
_L7:
                apkadapter.addData(apkdata, true);
                apkadapter.notifyDataSetChanged();
                pb_apk.setVisibility(8);
                iv_apkall.setVisibility(0);
                message = JunkActivity.this;
                message.allok = ((JunkActivity) (message)).allok + 1;
                four = 1;
                  goto _L1
_L6:
                if (getApplicationContext().getPackageManager().getPackageArchiveInfo((String)apkpath.get(i), 1) != null)
                {
                    newapkpath.add((String)apkpath.get(i));
                }
                i++;
                  goto _L9
_L8:
                apkdata.add(sm.GetAllApk2(smListener, (String)newapkpath.get(i)));
                i++;
                  goto _L10
_L4:
                if (message.what == 7)
                {
                    JunkActivity junkactivity2 = JunkActivity.this;
                    junkactivity2.allapksize = junkactivity2.allapksize + ((Long)message.obj).longValue();
                    apk_num.setText(CommonUtil.formatSize(allapksize));
                    rub_total.setText(CommonUtil.formatSize(allboostsize + allcachesize + allcanliusize + allapksize));
                }
                  goto _L1
                message;
                  goto _L5
            }

            
            {
                this$0 = JunkActivity.this;
                super();
            }
        };
        groupData = new String[4];
        groupsize = new String[4];
        expandFlag = -1;
        num2 = 0;
        l = new com.xiaos.adapter.PinnedHeaderExpandableAdapter.GroupCheckListener() {

            final JunkActivity this$0;

            public void ClickGroupCheckBox(int i)
            {
                num2 = i;
                Log.e("fff", (new StringBuilder("2num")).append(num2).toString());
                if (num2 != 0)
                {
                    adapter.notifyDataSetChanged();
                    num2 = 0;
                }
            }

            
            {
                this$0 = JunkActivity.this;
                super();
            }
        };
        smListener = new com.wjj.manager.SoftApkManager.SoftApkManagerListener2() {

            final JunkActivity this$0;

            public void DownCount(long l1)
            {
                Message message = handler.obtainMessage();
                message.obj = Long.valueOf(l1);
                message.what = 7;
                handler.sendMessage(message);
            }

            
            {
                this$0 = JunkActivity.this;
                super();
            }
        };
        runlistener = new com.wjj.manager.RuningAppManager.RuningAppManagerListener() {

            final JunkActivity this$0;

            public void DownCountSize(long l1, RuningApp runingapp)
            {
                Message message = new Message();
                message.obj = Long.valueOf(l1);
                message.what = 2;
                handler.sendMessage(message);
                message = new Message();
                message.obj = runingapp;
                message.what = 22;
                handler.sendMessage(message);
            }

            
            {
                this$0 = JunkActivity.this;
                super();
            }
        };
        cachelistener = new com.wjj.manager.RubSoftwareManager.RubSoftwareManagerListener() {

            final JunkActivity this$0;

            public void DownCount(List list1, long l1)
            {
                list1 = new Message();
                list1.obj = Long.valueOf(l1);
                list1.what = 4;
                handler.sendMessage(list1);
            }

            
            {
                this$0 = JunkActivity.this;
                super();
            }
        };
    }

    private void initData()
    {
        groupData[0] = "Memory boost";
        groupData[1] = "Cache junk";
        groupData[2] = "Residual fils";
        groupData[3] = "APK files";
        explistview.setHeaderView(getLayoutInflater().inflate(0x7f03003c, explistview, false));
    }

    private void initView()
    {
        explistview = (PinnedHeaderExpandableListView)findViewById(0x7f07004e);
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
                apkpath.add(file);
                return;
            }
            j++;
        }
          goto _L2
    }

    private void showNormal3()
    {
        (new com.aio.downloader.views.LAlertDialog.Builder(this)).setTitle("Notice").setMessage("Are you sure to stop scanning ?").setNegativeButton("Cancel", new android.content.DialogInterface.OnClickListener() {

            final JunkActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                this$0 = JunkActivity.this;
                super();
            }
        }).setPositiveButton("Stop", new android.content.DialogInterface.OnClickListener() {

            final JunkActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                bt_stop.setVisibility(8);
                bt_clean.setVisibility(0);
                nc_pb.setVisibility(8);
                iv_ncall.setVisibility(0);
                progressBarcache.setVisibility(8);
                iv_cacheall.setVisibility(0);
                pb_canliu.setVisibility(8);
                iv_canliuall.setVisibility(0);
                pb_apk.setVisibility(8);
                iv_apkall.setVisibility(0);
                sticky_content.setVisibility(8);
                content_two.setVisibility(0);
                adapter = new PinnedHeaderExpandableAdapter(list, cachelist, apkdata, cllist, groupData, getApplicationContext(), explistview, groupsize, l);
                explistview.setAdapter(adapter);
            }

            
            {
                this$0 = JunkActivity.this;
                super();
            }
        }).show();
    }

    public void AsncyApk()
    {
        (new Thread(new Runnable() {

            String ext[] = {
                ".apk"
            };
            File fi;
            final JunkActivity this$0;

            public void run()
            {
                search(fi, ext);
                handler.sendEmptyMessage(954);
            }

            
            {
                this$0 = JunkActivity.this;
                super();
                fi = Environment.getExternalStorageDirectory();
            }
        })).start();
    }

    public void AsyncDataEmpty()
    {
        (new Thread() {

            final JunkActivity this$0;

            public void run()
            {
                super.run();
                emptyfile = urm.GGGfile(new File(Environment.getExternalStorageDirectory().getPath()));
                Message message = handler.obtainMessage();
                message.obj = emptyfile;
                message.what = 5;
                handler.sendMessage(message);
            }

            
            {
                this$0 = JunkActivity.this;
                super();
            }
        }).start();
    }

    public boolean giveUpTouchEvent(MotionEvent motionevent)
    {
        return lv_neicun.getVisibility() == 8 && lv_huancun.getVisibility() == 8 && lv_canliu.getVisibility() == 8;
    }

    public void init()
    {
        rub_center = (TextView)findViewById(0x7f070033);
        bt_cleaning = (Button)findViewById(0x7f070051);
        bt_stop = (Button)findViewById(0x7f07004f);
        bt_stop.setOnClickListener(this);
        tv_scan = (TextView)findViewById(0x7f070032);
        cache_num = (TextView)findViewById(0x7f07003e);
        bost_num = (TextView)findViewById(0x7f070039);
        lv_huancun = (MyListView)findViewById(0x7f070041);
        cacheadapter = new JunkCacheAdapter(getApplicationContext());
        rubmamager = new RubSoftwareManager(getApplicationContext());
        lv_huancun.setAdapter(cacheadapter);
        header_left_back = (LImageButton)findViewById(0x7f07002f);
        header_left_back.setOnClickListener(this);
        bt_clean = (Button)findViewById(0x7f070050);
        bt_clean.setOnClickListener(this);
        list = new ArrayList();
        cachelist = new ArrayList();
        runappmana = new RuningAppManager(getApplicationContext());
        boostadapter = new JunkBoostAdapter(getApplicationContext());
        rub_total = (TextView)findViewById(0x7f070030);
        lv_neicun = (MyListView)findViewById(0x7f07003c);
        iv_ncall = (ImageView)findViewById(0x7f07003b);
        iv_cacheall = (ImageView)findViewById(0x7f070040);
        nc_pb = (ProgressBar)findViewById(0x7f07003a);
        progressBarcache = (ProgressBar)findViewById(0x7f07003f);
        lv_neicun.setAdapter(boostadapter);
    }

    public void initBoostData()
    {
        (new Thread() {

            final JunkActivity this$0;

            public void run()
            {
                super.run();
                list = runappmana.getRuningUserApp(runlistener);
                Message message = handler.obtainMessage();
                message.obj = list;
                message.what = 1;
                handler.sendMessage(message);
            }

            
            {
                this$0 = JunkActivity.this;
                super();
            }
        }).start();
    }

    public void initCache()
    {
        (new Thread() {

            final JunkActivity this$0;

            public void run()
            {
                super.run();
                cachelist = rubmamager.getApplicationInfo(cachelistener);
                Message message = handler.obtainMessage();
                message.obj = cachelist;
                message.what = 3;
                handler.sendMessage(message);
            }

            
            {
                this$0 = JunkActivity.this;
                super();
            }
        }).start();
    }

    public void initEmptyFile()
    {
        canliu_num = (TextView)findViewById(0x7f070043);
        iv_canliuall = (ImageView)findViewById(0x7f070045);
        pb_canliu = (ProgressBar)findViewById(0x7f070044);
        cllist = new ArrayList();
        lv_canliu = (MyListView)findViewById(0x7f070046);
        canliuAdapter = new JunkCanliuAdapter(getApplicationContext());
        lv_canliu.setAdapter(canliuAdapter);
        urm = new UnloadingResidueManager(this);
        emptyfile = new ArrayList();
        AsyncDataEmpty();
    }

    public void initapk()
    {
        content_two = (LinearLayout)findViewById(0x7f07004d);
        content_one = (LinearLayout)findViewById(0x7f070035);
        apkadapter = new ApkSoftAdapter(getApplicationContext());
        lv_apk = (MyListView)findViewById(0x7f07004c);
        lv_apk.setAdapter(apkadapter);
        iv_apkall = (ImageView)findViewById(0x7f07004a);
        pb_apk = (ProgressBar)findViewById(0x7f070049);
        apk_num = (TextView)findViewById(0x7f070048);
        apkdata = new ArrayList();
        sm = new SoftApkManager(getApplicationContext());
        apkpath = new ArrayList();
        newapkpath = new ArrayList();
        AsncyApk();
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 3: default 40
    //                   2131165231: 485
    //                   2131165263: 490
    //                   2131165264: 41;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L4:
        int i;
        bt_clean.setVisibility(8);
        bt_cleaning.setVisibility(0);
        i = 0;
_L6:
        if (i >= list.size() / 2)
        {
            i = 0;
            do
            {
                if (i >= cachelist.size())
                {
                    i = 0;
                    do
                    {
                        if (i >= cllist.size())
                        {
                            view = new ArrayList();
                            i = 0;
                            do
                            {
                                if (i >= apkdata.size())
                                {
                                    view = new Intent(getApplicationContext(), com/aio/downloader/cleaner/ShowCleanActivity1);
                                    view.putExtra("juti", (int)((allboostsize + allcachesize + allcanliusize + allapksize) / 1024L));
                                    view.putExtra("junk", 1);
                                    Log.e("fff", (new StringBuilder("====")).append(allboostsize + allcachesize + allcanliusize + allapksize).toString());
                                    startActivity(view);
                                    finish();
                                    return;
                                }
                                if (((SoftApk)apkdata.get(i)).ischecked)
                                {
                                    view.add((SoftApk)apkdata.get(i));
                                    allapksize = allapksize - ((SoftApk)apkdata.get(i)).apksize;
                                    (new File((String)newapkpath.get(i))).delete();
                                }
                                i++;
                            } while (true);
                        }
                        if (((Canliu)cllist.get(i)).ischecked)
                        {
                            (new File(((Canliu)cllist.get(i)).path)).delete();
                        }
                        i++;
                    } while (true);
                }
                if (((RubSoftware)cachelist.get(i)).ischecked)
                {
                    RubSoftwareManager.delFile(new File(((RubSoftware)cachelist.get(i)).cachepath));
                }
                i++;
            } while (true);
        } else
        {
            if (((RuningApp)list.get(i)).ischecked)
            {
                runappmana.Killprogress(((RuningApp)list.get(i)).packname);
            }
            i++;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        finish();
        return;
_L3:
        showNormal3();
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030006);
        init();
        initBoostData();
        initCache();
        sticky_content = (ScrollView)findViewById(0x7f070034);
        sticky_header = (RelativeLayout)findViewById(0x7f07002e);
        initEmptyFile();
        initapk();
        allok = 0;
        one = 0;
        two = 0;
        three = 0;
        four = 0;
        initView();
        initData();
    }
































































}
