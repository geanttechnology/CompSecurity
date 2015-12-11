// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.activity.DownloadAppManager;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.CleanerDialog1;
import com.aio.downloader.dialog.LianwangDialog;
import com.aio.downloader.mydownload.BaseActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.RoundProgressBar;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.cleaner:
//            TextFormater, TaskInfo, Bean, TaskInfoProvider

public class RubActivity extends BaseActivity
    implements android.view.View.OnClickListener
{
    private class TaskInfoAdapter extends BaseAdapter
    {

        final RubActivity this$0;

        private TextView newTextView(String s)
        {
            TextView textview = new TextView(RubActivity.this);
            textview.setText(s);
            return textview;
        }

        public int getCount()
        {
            if (sp.getBoolean("showSystemProcess", false))
            {
                return taskInfos.size() + 2;
            } else
            {
                return userTaskInfos.size() + 1;
            }
        }

        public Object getItem(int j)
        {
            if (j == 0)
            {
                return Integer.valueOf(0);
            }
            if (j <= userTaskInfos.size())
            {
                return userTaskInfos.get(j - 1);
            }
            if (j == userTaskInfos.size() + 1)
            {
                return Integer.valueOf(j);
            }
            if (j <= taskInfos.size() + 2)
            {
                return systemTaskInfos.get(j - userTaskInfos.size() - 2);
            } else
            {
                return Integer.valueOf(j);
            }
        }

        public long getItemId(int j)
        {
            return (long)j;
        }

        public View getView(int j, View view, ViewGroup viewgroup)
        {
            TaskInfoViews taskinfoviews;
            Iterator iterator;
            if (j == 0)
            {
                return newTextView((new StringBuilder("  User Process(")).append(userTaskInfos.size()).append(")").toString());
            }
            if (j <= userTaskInfos.size())
            {
                viewgroup = (TaskInfo)userTaskInfos.get(j - 1);
            } else
            {
                if (j == userTaskInfos.size() + 1)
                {
                    return newTextView((new StringBuilder("System process(")).append(systemTaskInfos.size()).append(")").toString());
                }
                if (j <= taskInfos.size() + 2)
                {
                    viewgroup = (TaskInfo)systemTaskInfos.get(j - userTaskInfos.size() - 2);
                } else
                {
                    viewgroup = new TaskInfo();
                }
            }
            if (view != null && !(view instanceof TextView))
            {
                break MISSING_BLOCK_LABEL_580;
            }
            view = View.inflate(RubActivity.this, 0x7f0300a1, null);
            taskinfoviews = new TaskInfoViews(null);
            taskinfoviews.iv_process_icon = (ImageView)view.findViewById(0x7f07037a);
            taskinfoviews.tv_process_name = (TextView)view.findViewById(0x7f07037b);
            taskinfoviews.tv_process_memory = (TextView)view.findViewById(0x7f07037c);
            taskinfoviews.cb_process_state = (CheckBox)view.findViewById(0x7f070131);
            view.setTag(taskinfoviews);
            iterator = userTaskInfos.iterator();
_L3:
            if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
            Log.e("www", (new StringBuilder("getview_memory=")).append(MymemorySize).toString());
_L4:
            taskinfoviews.iv_process_icon.setImageDrawable(viewgroup.getIcon());
            taskinfoviews.tv_process_name.setText(viewgroup.getName());
            taskinfoviews.tv_process_memory.setText((new StringBuilder("Junk File:")).append(TextFormater.getSizeFromKB(viewgroup.getMemory())).toString());
            bt_process_clear.setText((new StringBuilder("Junk File")).append(userTaskInfos.size()).toString());
            TaskInfo taskinfo;
            RubActivity rubactivity;
            if ("com.allinone.free".equals(viewgroup.getPackageName()) || "system".equals(viewgroup.getPackageName()) || "android.process.media".equals(viewgroup.getPackageName()))
            {
                taskinfoviews.cb_process_state.setVisibility(4);
                taskinfoviews.tv_process_memory.setText((new StringBuilder("Junk File:")).append(String.valueOf((int)(Math.random() * 10D + 1.0D))).append("MB").toString());
            } else
            {
                taskinfoviews.cb_process_state.setVisibility(0);
            }
            taskinfoviews.cb_process_state.setChecked(viewgroup.isCheck());
            viewgroup.isCheck();
            return view;
_L2:
            taskinfo = (TaskInfo)iterator.next();
            rubactivity = RubActivity.this;
            rubactivity.MymemorySize = rubactivity.MymemorySize + taskinfo.getMemory();
              goto _L3
            taskinfoviews = (TaskInfoViews)view.getTag();
              goto _L4
        }

        public TaskInfoAdapter()
        {
            this$0 = RubActivity.this;
            super();
            userTaskInfos = new ArrayList();
            systemTaskInfos = new ArrayList();
            Iterator iterator = taskInfos.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                TaskInfo taskinfo = (TaskInfo)iterator.next();
                if (taskinfo.isSystemProcess())
                {
                    systemTaskInfos.add(taskinfo);
                } else
                if (!taskinfo.getName().contains("Google") && !taskinfo.getPackageName().equals("com.allinone.free") && !taskinfo.getName().contains("google") && !taskinfo.getPackageName().contains("google"))
                {
                    userTaskInfos.add(taskinfo);
                }
            } while (true);
        }
    }

    private class TaskInfoViews
    {

        CheckBox cb_process_state;
        ImageView iv_process_icon;
        final RubActivity this$0;
        TextView tv_process_memory;
        TextView tv_process_name;

        private TaskInfoViews()
        {
            this$0 = RubActivity.this;
            super();
        }

        TaskInfoViews(TaskInfoViews taskinfoviews)
        {
            this();
        }
    }

    public class memInfo
    {

        final RubActivity this$0;

        public long getmem_UNUSED(Context context)
        {
            context = (ActivityManager)context.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
            context.getMemoryInfo(memoryinfo);
            return memoryinfo.availMem / 1024L;
        }

        public memInfo()
        {
            this$0 = RubActivity.this;
            super();
        }
    }


    private static final int LOAD_FINISH = 1;
    private static double cont = 0.0D;
    private static boolean flag = true;
    int MymemorySize;
    private File PRO_DIR;
    private ActivityManager activityManager;
    private TaskInfoAdapter adapter;
    private String availMemory;
    Bean bean;
    private Button bt_process_clear;
    private Button bt_process_finish_rub;
    private Button bt_process_ing;
    private Button btnfinish;
    private Map cacheMap;
    private CheckBox cb_process_state;
    private int cishu;
    private String cleanSize;
    private double cont_clean;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private HashMap default_options;
    private List ds;
    android.content.SharedPreferences.Editor editor;
    private boolean flag_cilcle;
    private boolean flag_clean;
    private long getmem_SY;
    Handler handler;
    private Handler handler2;
    private ImageView header_left_fanghui1;
    private ImageView header_left_showclean2_rub;
    int i;
    private ImageView iv_bg;
    private ImageView iv_ok1;
    ArrayList list;
    private ListView lv_process_list;
    private String memory;
    private int memorySize;
    private ProgressBar pb;
    private PackageManager pm;
    private int pos;
    private ProgressWheel progress_wheel;
    private ProgressWheel progress_wheel_wyc;
    private ProgressWheel progress_wheel_wyc_rub1;
    private publicTools publictools;
    private TextView releasedtime;
    private Double roundDouble;
    private RoundProgressBar rp_chuang1;
    private List runningAppProcessInfos;
    private TextView scanningtv;
    SharedPreferences sharedPreferences;
    private SharedPreferences sp;
    private SharedPreferences spnetworkre;
    private List systemTaskInfos;
    private TaskInfoProvider taskInfoProvider;
    private List taskInfos;
    private String totalMemory;
    long total_show;
    long total_wyc;
    private TextView tv_best;
    private TextView tv_danwei;
    private TextView tv_jieguo_rub;
    private TextView tv_neicun;
    private TextView tv_status;
    private TextView tv_zhuantai;
    private List userTaskInfos;
    private boolean widgetdetailfan;

    public RubActivity()
    {
        list = new ArrayList();
        bean = null;
        i = 0;
        cishu = 0;
        MymemorySize = 0;
        total_show = 0L;
        total_wyc = 0L;
        handler2 = new Handler() {

            final RubActivity this$0;

            public void handleMessage(Message message)
            {
                progress_wheel_wyc.setVisibility(8);
                scanningtv.setVisibility(8);
                bt_process_clear.setVisibility(0);
                bt_process_clear.performClick();
                switch (message.what)
                {
                case 2: // '\002'
                case 3: // '\003'
                default:
                    return;

                case 1: // '\001'
                    adapter = new TaskInfoAdapter();
                    message = new SwingBottomInAnimationAdapter(adapter);
                    message.setListView(lv_process_list);
                    lv_process_list.setAdapter(message);
                    message = new memInfo();
                    long l = RubActivity.getmem_TOLAL();
                    long l1 = message.getmem_UNUSED(getApplicationContext());
                    getmem_SY = l - l1;
                    Log.e("www", (new StringBuilder("getmem_UNUSED=")).append(l1).append("getmem_TOLAL=").append(l).toString());
                    Log.e("www", (new StringBuilder("handler=")).append(total_wyc).toString());
                    RubActivity.cont = (double)((int)total_wyc / 1024);
                    if (total_wyc / 1024L / 1024L >= 1L)
                    {
                        tv_danwei.setText("GB");
                        roundDouble = RubActivity.roundDouble((double)total_wyc / 1024D / 1024D, 2);
                        tv_neicun.setText((new StringBuilder()).append(roundDouble).toString());
                        return;
                    } else
                    {
                        tv_danwei.setText("MB");
                        roundDouble = RubActivity.roundDouble((double)total_wyc / 1024D, 2);
                        tv_neicun.setText((new StringBuilder()).append(roundDouble).toString());
                        return;
                    }

                case 200: 
                    iv_ok1.setVisibility(0);
                    iv_ok1.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), 0x7f040021));
                    releasedtime.setVisibility(0);
                    (new AsyncTask() {

                        final _cls1 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            try
                            {
                                Thread.sleep(1000L);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void avoid[])
                            {
                                avoid.printStackTrace();
                            }
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            getAssetFile();
                            (new Thread() {

                                final _cls1 this$2;

                                public void run()
                                {
                                    super.run();
                                    publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=install");
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            }).start();
                            void1 = new CleanerDialog1(_fld0, 0x7f0c000e);
                            void1.setCanceledOnTouchOutside(false);
                            void1.show();
                            Button button = (Button)void1.findViewById(0x7f070154);
                            Button button1 = (Button)void1.findViewById(0x7f070155);
                            ((TextView)void1.findViewById(0x7f070093)).setText(Html.fromHtml("Boost your phone up to 50% by<font color='#3261b4'> <b>AIO Cleaner</b></font> , Continue? "));
                            button.setOnClickListener(void1. new android.view.View.OnClickListener() {

                                final _cls1 this$2;
                                private final CleanerDialog1 val$dialog1;

                                public void onClick(View view)
                                {
                                    dialog1.dismiss();
                                }

            
            {
                this$2 = final__pcls1;
                dialog1 = CleanerDialog1.this;
                super();
            }
                            });
                            button1.setOnClickListener(void1. new android.view.View.OnClickListener() {

                                final _cls1 this$2;
                                private final CleanerDialog1 val$dialog1;

                                public void onClick(View view)
                                {
                                    publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=pop&action=install_click");
                                    view = null;
                                    PackageInfo packageinfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                                    view = packageinfo;
_L1:
                                    android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                                    if (view == null)
                                    {
                                        installApk();
                                    } else
                                    {
                                        view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                                        startActivity(view);
                                    }
                                    dialog1.dismiss();
                                    return;
                                    namenotfoundexception;
                                    namenotfoundexception.printStackTrace();
                                      goto _L1
                                }

            
            {
                this$2 = final__pcls1;
                dialog1 = CleanerDialog1.this;
                super();
            }
                            });
                        }


            
            {
                this$1 = _cls1.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
            }


            
            {
                this$0 = RubActivity.this;
                super();
            }
        };
        flag_clean = true;
        cont_clean = 0.0D;
        flag_cilcle = true;
        pos = 0;
        handler = new Handler() {

            final RubActivity this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    Toast.makeText(RubActivity.this, "Failed to connect server.", 0).show();
                    return;

                case 2: // '\002'
                    Mydialog();
                    return;

                case 3: // '\003'
                    Toast.makeText(RubActivity.this, "'AIO Cleaner' is added to download queue.", 0).show();
                    break;
                }
                message = new Intent(RubActivity.this, com/aio/downloader/activity/AppDetailsActivity);
                message.putExtra("myid", "com.evzapp.cleanmaster");
                message.putExtra("widgetdetailfan", true);
                startActivity(message);
                publicTools.cleanertag = false;
                finish();
            }

            
            {
                this$0 = RubActivity.this;
                super();
            }
        };
        dbUtils = null;
        publictools = null;
        widgetdetailfan = false;
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
    }

    private void Mydialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b0034)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final RubActivity this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = RubActivity.this;
                super();
            }
        }).show();
    }

    private void downwifi()
    {
        final LianwangDialog dialog = new LianwangDialog(this, 0x7f0c000e);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button = (Button)dialog.findViewById(0x7f070141);
        Button button1 = (Button)dialog.findViewById(0x7f070142);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final RubActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = RubActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final RubActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = RubActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    private File getAssetFile()
    {
        Object obj = getAssets();
        File file;
        PRO_DIR.mkdirs();
        obj = ((AssetManager) (obj)).open("cleaner.apk");
        file = new File(PRO_DIR, "cleaner.apk");
        FileOutputStream fileoutputstream;
        byte abyte0[];
        file.createNewFile();
        fileoutputstream = new FileOutputStream(file);
        abyte0 = new byte[1024];
_L1:
        int j = ((InputStream) (obj)).read(abyte0);
        if (j != -1)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        fileoutputstream.flush();
        ((InputStream) (obj)).close();
        fileoutputstream.close();
        return file;
        fileoutputstream.write(abyte0, 0, j);
          goto _L1
        IOException ioexception;
        ioexception;
_L3:
        ioexception.printStackTrace();
        return null;
        ioexception;
        if (true) goto _L3; else goto _L2
_L2:
    }

    private String getAvailMemory()
    {
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryinfo);
        return TextFormater.dataSizeFormat(memoryinfo.availMem);
    }

    private int getRunningAppCount()
    {
        runningAppProcessInfos = activityManager.getRunningAppProcesses();
        return runningAppProcessInfos.size();
    }

    public static long getmem_TOLAL()
    {
        Object obj;
        Object obj2;
        Object obj4;
        String s;
        Object obj5;
        obj4 = null;
        obj2 = null;
        obj5 = null;
        obj = null;
        s = null;
        Object obj1 = new BufferedReader(new FileReader("/proc/meminfo"), 8);
        s = ((BufferedReader) (obj1)).readLine();
        Object obj3;
        obj = obj2;
        if (s != null)
        {
            obj = s;
        }
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((IOException) (obj1)).printStackTrace();
            }
        }
        return (long)Integer.parseInt(((String) (obj)).substring(((String) (obj)).indexOf(':') + 1, ((String) (obj)).indexOf('k')).trim());
        obj3;
        obj1 = s;
_L6:
        obj = obj1;
        ((FileNotFoundException) (obj3)).printStackTrace();
        obj = obj4;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = obj4;
            break MISSING_BLOCK_LABEL_56;
        }
        obj = obj4;
        break MISSING_BLOCK_LABEL_56;
        obj3;
        obj1 = obj5;
_L4:
        obj = obj1;
        ((IOException) (obj3)).printStackTrace();
        obj = obj4;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = obj4;
            break MISSING_BLOCK_LABEL_56;
        }
        obj = obj4;
        break MISSING_BLOCK_LABEL_56;
        obj1;
_L2:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw obj1;
        obj3;
        obj = obj1;
        obj1 = obj3;
        if (true) goto _L2; else goto _L1
_L1:
        obj3;
        if (true) goto _L4; else goto _L3
_L3:
        obj3;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void init()
    {
        progress_wheel = (ProgressWheel)findViewById(0x7f070072);
        publictools = new publicTools(this);
        default_options = new HashMap();
        default_options.put("save_cookie", Integer.valueOf(0));
        default_options.put("send_cookie", Integer.valueOf(0));
        default_options.put("show_header", Integer.valueOf(0));
        default_options.put("redirect", Integer.valueOf(1));
        try
        {
            db = new FinalDBChen(getmContext(), getDatabasePath("download2.db").getAbsolutePath());
            ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
        }
        catch (Exception exception1) { }
        spnetworkre = getSharedPreferences("network", 0);
        try
        {
            if (dbUtils == null)
            {
                dbUtils = new TypeDbUtils(this);
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void initData()
    {
        runningAppProcessInfos = activityManager.getRunningAppProcesses();
        Log.v("qwe", (new StringBuilder("runningAppProcessInfos=")).append(runningAppProcessInfos).toString());
        (new Thread(new Runnable() {

            final RubActivity this$0;

            public void run()
            {
                taskInfoProvider = new TaskInfoProvider(RubActivity.this);
                taskInfos = taskInfoProvider.getAllTask(runningAppProcessInfos);
                Object obj = taskInfos.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        total_wyc = total_show;
                        obj = new android.app.ActivityManager.MemoryInfo();
                        activityManager.getMemoryInfo(((android.app.ActivityManager.MemoryInfo) (obj)));
                        long l = ((android.app.ActivityManager.MemoryInfo) (obj)).availMem;
                        obj = RubActivity.this;
                        obj.total_show = ((RubActivity) (obj)).total_show << 10;
                        obj = RubActivity.this;
                        obj.total_show = ((RubActivity) (obj)).total_show + l;
                        totalMemory = TextFormater.dataSizeFormat(total_show);
                        obj = new Message();
                        obj.what = 1;
                        handler2.sendMessage(((Message) (obj)));
                        return;
                    }
                    TaskInfo taskinfo = (TaskInfo)((Iterator) (obj)).next();
                    RubActivity rubactivity = RubActivity.this;
                    rubactivity.total_show = rubactivity.total_show + (long)taskinfo.getMemory();
                } while (true);
            }

            
            {
                this$0 = RubActivity.this;
                super();
            }
        })).start();
    }

    private void initTitle()
    {
        availMemory = getAvailMemory();
    }

    private void installApk()
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    private void killTask()
    {
        Object obj;
        int j;
        j = 0;
        memorySize = 0;
        obj = systemTaskInfos.iterator();
_L3:
        if (((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        obj = userTaskInfos.iterator();
_L4:
        if (!((Iterator) (obj)).hasNext())
        {
            Log.e("eee", (new StringBuilder("memorySize=")).append(memorySize).toString());
            tv_neicun.setTextSize(30F);
            tv_neicun.setText((new StringBuilder("Released:")).append(TextFormater.getSizeFromKB(memorySize)).toString());
            memory = TextFormater.getSizeFromKB(memorySize);
            Log.e("www", (new StringBuilder("memory=")).append(memory).toString());
            tv_danwei.setVisibility(8);
            tv_zhuantai.setVisibility(8);
            bt_process_clear.setVisibility(8);
            rp_chuang1.setVisibility(0);
            adapter = new TaskInfoAdapter();
            obj = new SwingBottomInAnimationAdapter(adapter);
            ((SwingBottomInAnimationAdapter) (obj)).setListView(lv_process_list);
            lv_process_list.setAdapter(((android.widget.ListAdapter) (obj)));
            return;
        }
        break MISSING_BLOCK_LABEL_287;
_L2:
        TaskInfo taskinfo = (TaskInfo)((Iterator) (obj)).next();
        if (taskinfo.isCheck())
        {
            activityManager.killBackgroundProcesses(taskinfo.getPackageName());
            j++;
            memorySize = memorySize + taskinfo.getMemory();
            taskInfos.remove(taskinfo);
        }
          goto _L3
        TaskInfo taskinfo1 = (TaskInfo)((Iterator) (obj)).next();
        if (taskinfo1.isCheck())
        {
            activityManager.killBackgroundProcesses(taskinfo1.getPackageName());
            j++;
            memorySize = memorySize + taskinfo1.getMemory();
            taskInfos.remove(taskinfo1);
        }
          goto _L4
    }

    public static Double roundDouble(double d, int j)
    {
        double d1 = j;
        try
        {
            d1 = Math.pow(10D, d1);
            d = Math.floor(d * d1 + 0.5D) / d1;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return Double.valueOf(d);
    }

    public void MydownloadApk(final String id, final String title, String s, int j)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, j) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final RubActivity this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    if (TextUtils.isEmpty(avoid))
                    {
                        avoid = new Message();
                        avoid.what = 1;
                        handler.sendMessage(avoid);
                        if (content.length() > 100)
                        {
                            avoid = content.substring(0, 100);
                        } else
                        {
                            avoid = content;
                        }
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id=")).append(id).append("&status=fail_get_url&version=").append("3.3.9").append("&content=").append(avoid).toString());
                    } else
                    if (db.findItemsByWhereAndWhereValue("downloadUrl", avoid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                    } else
                    {
                        String s1 = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl(avoid);
                        d.setFilePath(s1);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setType("app");
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 3;
                        handler.sendMessage(avoid);
                    }
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    progress_wheel.setVisibility(8);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progress_wheel.setVisibility(0);
                }

            
            {
                this$0 = RubActivity.this;
                id = s;
                title = s2;
                icon = s3;
                appserial = j;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void getCacheInfo(String s)
    {
    }

    public void initView()
    {
        super.initView();
        try
        {
            new FinalDBChen(getmContext(), "download2.db", new DownloadMovieItem(), "downloadtask2", null);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    protected void onActivityResult(int j, int k, Intent intent)
    {
        super.onActivityResult(j, k, intent);
        if (k == 200)
        {
            initData();
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131166124: 
            Toast.makeText(getApplicationContext(), "Cleaning...", 1).show();
            return;

        case 2131166123: 
            i = i + 1;
            bt_process_clear.setVisibility(8);
            bt_process_ing.setVisibility(0);
            tv_danwei.setText("MB");
            flag = true;
            (new Thread() {

                final RubActivity this$0;

                public void run()
                {
                    super.run();
                    do
                    {
                        do
                        {
                            if (!RubActivity.flag)
                            {
                                return;
                            }
                            RubActivity.cont -= 1.1000000000000001D;
                            RubActivity.cont = RubActivity.roundDouble(RubActivity.cont, 2).doubleValue();
                            tv_neicun.post(new Runnable() {

                                final _cls7 this$1;

                                public void run()
                                {
                                    if (RubActivity.cont < 0.0D)
                                    {
                                        tv_neicun.setTextSize(50F);
                                        tv_neicun.setText("0");
                                        return;
                                    } else
                                    {
                                        tv_neicun.setTextSize(50F);
                                        tv_neicun.setText((new StringBuilder()).append(RubActivity.cont).toString());
                                        return;
                                    }
                                }

            
            {
                this$1 = _cls7.this;
                super();
            }
                            });
                            try
                            {
                                sleep(10L);
                            }
                            catch (InterruptedException interruptedexception)
                            {
                                interruptedexception.printStackTrace();
                            }
                        } while (RubActivity.cont > 0.0D);
                        RubActivity.flag = false;
                    } while (true);
                }


            
            {
                this$0 = RubActivity.this;
                super();
            }
            }).start();
            (new AsyncTask() {

                final RubActivity this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Thread.sleep(100L);
                    avoid = pm.getInstalledPackages(0);
                    pb.setMax(avoid.size());
                    int j = 0;
                    avoid = avoid.iterator();
_L2:
                    if (!avoid.hasNext())
                    {
                        break MISSING_BLOCK_LABEL_117;
                    }
                    PackageInfo packageinfo;
                    packageinfo = (PackageInfo)avoid.next();
                    String s = packageinfo.packageName;
                    getCacheInfo(s);
                    j++;
                    pb.setProgress(j);
                    publishProgress(new Object[] {
                        packageinfo
                    });
                    if (true) goto _L2; else goto _L1
_L1:
                    avoid;
                    avoid.printStackTrace();
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    tv_status.setText("Complete");
                    killTask();
                    bt_process_ing.setVisibility(8);
                    bt_process_finish_rub.setVisibility(0);
                    progress_wheel_wyc_rub1.setVisibility(8);
                    tv_jieguo_rub.setText((new StringBuilder()).append(memorySize).toString());
                    roundDouble = RubActivity.roundDouble((double)memorySize / 1024D, 2);
                    flag_cilcle = true;
                    (new Thread() {

                        final _cls8 this$1;

                        public void run()
                        {
                            super.run();
                            do
                            {
                                do
                                {
                                    if (!flag_cilcle)
                                    {
                                        return;
                                    }
                                    Object obj = _fld0;
                                    obj.pos = ((RubActivity) (obj)).pos + 1;
                                    rp_chuang1.post(new Runnable() {

                                        final _cls1 this$2;

                                        public void run()
                                        {
                                            rp_chuang1.setProgress(pos);
                                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                                    });
                                    try
                                    {
                                        sleep(35L);
                                    }
                                    catch (InterruptedException interruptedexception)
                                    {
                                        interruptedexception.printStackTrace();
                                    }
                                    if (pos > 80)
                                    {
                                        try
                                        {
                                            sleep(45L);
                                        }
                                        catch (InterruptedException interruptedexception1)
                                        {
                                            interruptedexception1.printStackTrace();
                                        }
                                    }
                                } while (pos != 100);
                                flag_cilcle = false;
                                obj = new Message();
                                obj.what = 200;
                                handler2.sendMessage(((Message) (obj)));
                            } while (true);
                        }


            
            {
                this$1 = _cls8.this;
                super();
            }
                    }).start();
                    flag_clean = true;
                    (new Thread() {

                        final _cls8 this$1;

                        public void run()
                        {
                            super.run();
                            do
                            {
                                do
                                {
                                    if (!flag_clean)
                                    {
                                        return;
                                    }
                                    RubActivity rubactivity = _fld0;
                                    rubactivity.cont_clean = rubactivity.cont_clean + 1.1000000000000001D;
                                    tv_jieguo_rub.post(new Runnable() {

                                        final _cls2 this$2;

                                        public void run()
                                        {
                                            tv_jieguo_rub.setText((new StringBuilder("This time released: ")).append(RubActivity.roundDouble(cont_clean, 2)).append("MB").toString());
                                        }

            
            {
                this$2 = _cls2.this;
                super();
            }
                                    });
                                    try
                                    {
                                        sleep(20L);
                                    }
                                    catch (Exception exception) { }
                                } while (cont_clean < roundDouble.doubleValue());
                                flag_clean = false;
                            } while (true);
                        }


            
            {
                this$1 = _cls8.this;
                super();
            }
                    }).start();
                    super.onPostExecute(void1);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                }

                protected transient void onProgressUpdate(Object aobj[])
                {
                    PackageInfo packageinfo = (PackageInfo)aobj[0];
                    tv_status.setText((new StringBuilder("Scanning:")).append(packageinfo.applicationInfo.loadLabel(pm)).toString());
                    cleanSize = (String)packageinfo.applicationInfo.loadLabel(pm);
                    super.onProgressUpdate(aobj);
                }


            
            {
                this$0 = RubActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setmContext(this);
        sp = getSharedPreferences("config", 0);
        activityManager = (ActivityManager)getSystemService("activity");
        setContentView(0x7f0300ac);
        header_left_showclean2_rub = (ImageView)findViewById(0x7f0703b0);
        btnfinish = (Button)findViewById(0x7f0703b5);
        releasedtime = (TextView)findViewById(0x7f0703b3);
        btnfinish.setOnClickListener(new android.view.View.OnClickListener() {

            final RubActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager);
                startActivity(view);
                finish();
                publicTools.cleanertag = false;
            }

            
            {
                this$0 = RubActivity.this;
                super();
            }
        });
        header_left_showclean2_rub.setOnClickListener(new android.view.View.OnClickListener() {

            final RubActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager);
                startActivity(view);
                finish();
                publicTools.cleanertag = false;
            }

            
            {
                this$0 = RubActivity.this;
                super();
            }
        });
        header_left_fanghui1 = (ImageView)findViewById(0x7f0703a3);
        header_left_fanghui1.setOnClickListener(new android.view.View.OnClickListener() {

            final RubActivity this$0;

            public void onClick(View view)
            {
                if (i == 0)
                {
                    startActivity(new Intent(RubActivity.this, com/aio/downloader/activity/DownloadAppManager));
                    return;
                } else
                {
                    Toast.makeText(getApplicationContext(), "Cleaning...", 1).show();
                    return;
                }
            }

            
            {
                this$0 = RubActivity.this;
                super();
            }
        });
        availMemory = getAvailMemory();
        bean = new Bean();
        pm = getPackageManager();
        pb = (ProgressBar)findViewById(0x7f070031);
        lv_process_list = (ListView)findViewById(0x7f0703a8);
        bt_process_clear = (Button)findViewById(0x7f0703ab);
        tv_status = (TextView)findViewById(0x7f0703a7);
        tv_neicun = (TextView)findViewById(0x7f0703a4);
        tv_danwei = (TextView)findViewById(0x7f0703a5);
        tv_zhuantai = (TextView)findViewById(0x7f0703a6);
        tv_jieguo_rub = (TextView)findViewById(0x7f0703b4);
        progress_wheel_wyc = (ProgressWheel)findViewById(0x7f0703aa);
        progress_wheel_wyc_rub1 = (ProgressWheel)findViewById(0x7f0703ae);
        scanningtv = (TextView)findViewById(0x7f0703b6);
        rp_chuang1 = (RoundProgressBar)findViewById(0x7f0703b1);
        iv_ok1 = (ImageView)findViewById(0x7f0703b2);
        iv_bg = (ImageView)findViewById(0x7f0703a2);
        bt_process_ing = (Button)findViewById(0x7f0703ac);
        bt_process_finish_rub = (Button)findViewById(0x7f0703ad);
        tv_best = (TextView)findViewById(0x7f0703a9);
        progress_wheel_wyc.setVisibility(0);
        scanningtv.setVisibility(0);
        bt_process_clear.setVisibility(8);
        Log.e("eee", (new StringBuilder("\u5185\u5B58")).append(getAvailMemory()).toString());
        bt_process_clear.setOnClickListener(this);
        bt_process_ing.setOnClickListener(this);
        initData();
        lv_process_list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RubActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int j, long l)
            {
label0:
                {
                    adapterview = ((AdapterView) (lv_process_list.getItemAtPosition(j)));
                    if (adapterview instanceof TaskInfo)
                    {
                        cb_process_state = (CheckBox)view.findViewById(0x7f070131);
                        adapterview = (TaskInfo)adapterview;
                        if (!"com.allinone.free".equals(adapterview.getPackageName()) && !"system".equals(adapterview.getPackageName()) && !"android.process.media".equals(adapterview.getPackageName()))
                        {
                            break label0;
                        }
                        cb_process_state.setVisibility(4);
                    }
                    return;
                }
                if (adapterview.isCheck())
                {
                    adapterview.setCheck(false);
                    cb_process_state.setChecked(false);
                    return;
                } else
                {
                    adapterview.setCheck(true);
                    cb_process_state.setChecked(true);
                    return;
                }
            }

            
            {
                this$0 = RubActivity.this;
                super();
            }
        });
        init();
        initView();
        widgetdetailfan = getIntent().getBooleanExtra("widgetdetailfan", false);
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void toDownload(DownloadMovieItem downloadmovieitem)
    {
        downloadmovieitem.setDownloadState(Integer.valueOf(7));
        getMyApp().setStartDownloadMovieItem(downloadmovieitem);
        sendBroadcast((new Intent()).setAction("download"));
        if (db.findItemsByWhereAndWhereValue("movieName", downloadmovieitem.getMovieName(), com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() == 0)
        {
            db.insertObject(downloadmovieitem, "downloadtask2");
            return;
        } else
        {
            db.updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                downloadmovieitem.getMovieName()
            }, downloadmovieitem);
            return;
        }
    }



























































}
