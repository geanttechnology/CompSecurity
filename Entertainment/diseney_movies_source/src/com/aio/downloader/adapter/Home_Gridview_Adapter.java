// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.LianwangDialog;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.LFrameLayout;
import com.aio.downloader.views.LImageButton;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;

public class Home_Gridview_Adapter extends BaseAdapter
    implements ContentValue
{
    class ViewHolder
    {

        private LImageButton gvdown;
        private ImageView gvimg;
        private RatingBar gvratingbar;
        private TextView gvtitle;
        final Home_Gridview_Adapter this$0;









        ViewHolder()
        {
            this$0 = Home_Gridview_Adapter.this;
            super();
        }
    }


    private MyApplcation app;
    private String apptag;
    private Context ctx;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private HashMap default_options;
    private android.content.SharedPreferences.Editor edit;
    Handler handler;
    private HashMap headers;
    ViewHolder holder;
    private Boolean istag;
    private List list;
    private Context mContext;
    private PopupWindow mWindow;
    private MyApplcation myApp;
    private publicTools publictools;
    private LFrameLayout rl_share;
    private SharedPreferences sp;
    private SharedPreferences sp2;
    private SharedPreferences spnetworkre;
    private Typeface typeFace;

    public Home_Gridview_Adapter(Context context, List list1, String s)
    {
        handler = new Handler() {

            final Home_Gridview_Adapter this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (message.what)
                {
                default:
                    return;

                case 1: // '\001'
                    Toast.makeText(ctx, "Failed to connect server.", 0).show();
                    return;

                case 2: // '\002'
                    try
                    {
                        Toast.makeText(ctx, "It has been in downloading list already.", 1).show();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Message message)
                    {
                        return;
                    }

                case 3: // '\003'
                    istag = Boolean.valueOf(true);
                    Toast.makeText(ctx, (new StringBuilder("'")).append(sp2.getString("appname", "this app")).append("' is added to download queue.").toString(), 0).show();
                    message = new Intent();
                    break;
                }
                if (!apptag.equals("appfeatured")) goto _L2; else goto _L1
_L1:
                message.setAction("appfeatured");
                message.setAction("app");
_L4:
                ctx.sendBroadcast(message);
                return;
_L2:
                if (apptag.equals("homefeatured"))
                {
                    message.setAction("homeapp");
                } else
                if (apptag.equals("gamefeatured"))
                {
                    message.setAction("gamefeatured");
                    message.setAction("game");
                } else
                if (apptag.equals("homefeatured"))
                {
                    message.setAction("homefeatured");
                } else
                if (apptag.equals("appdetail"))
                {
                    message.setAction("appdetail");
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = Home_Gridview_Adapter.this;
                super();
            }
        };
        istag = Boolean.valueOf(false);
        publictools = null;
        dbUtils = null;
        typeFace = null;
        holder = null;
        try
        {
            typeFace = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
        }
        catch (Exception exception) { }
        ctx = context;
        list = list1;
        apptag = s;
        try
        {
            app = (MyApplcation)context.getApplicationContext();
            initView();
            publictools = new publicTools(context);
            headers = new HashMap();
            headers.put("AIOD", "1");
            headers.put("Referer", publicTools.get_a_random_user_webview());
            default_options = new HashMap();
            default_options.put("save_cookie", Integer.valueOf(0));
            default_options.put("send_cookie", Integer.valueOf(0));
            default_options.put("show_header", Integer.valueOf(0));
            default_options.put("redirect", Integer.valueOf(1));
            if (dbUtils == null)
            {
                dbUtils = new TypeDbUtils(context);
            }
            spnetworkre = context.getSharedPreferences("network", 0);
            db = new FinalDBChen(getmContext(), context.getDatabasePath("download2.db").getAbsolutePath());
            sp2 = context.getSharedPreferences("name", 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    private void Mydialog()
    {
        (new android.app.AlertDialog.Builder(ctx)).setTitle(ctx.getString(0x7f0b0034)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final Home_Gridview_Adapter this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = Home_Gridview_Adapter.this;
                super();
            }
        }).show();
    }

    public static int dip2px(Context context, float f)
    {
        return (int)(f * context.getResources().getDisplayMetrics().density + 0.5F);
    }

    private void downwifi()
    {
        final LianwangDialog dialog = new LianwangDialog(ctx, 0x7f0c000e);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button = (Button)dialog.findViewById(0x7f070141);
        Button button1 = (Button)dialog.findViewById(0x7f070142);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_Gridview_Adapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = Home_Gridview_Adapter.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_Gridview_Adapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                ctx.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = Home_Gridview_Adapter.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    private void popuWindow(final int myPosition, final String mHas_apk)
    {
        View view = LayoutInflater.from(ctx).inflate(0x7f03009a, null);
        LFrameLayout lframelayout = (LFrameLayout)view.findViewById(0x7f070359);
        rl_share = (LFrameLayout)view.findViewById(0x7f07035a);
        LFrameLayout lframelayout1 = (LFrameLayout)view.findViewById(0x7f07035b);
        lframelayout.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_Gridview_Adapter this$0;
            private final String val$mHas_apk;
            private final int val$myPosition;

            public void onClick(View view1)
            {
                sp2.edit().putString("appname", ((DownloadMovieItem)list.get(myPosition)).getTitle()).commit();
                if (!mHas_apk.equals("1")) goto _L2; else goto _L1
_L1:
                (new Thread(myPosition. new Runnable() {

                    final _cls7 this$1;
                    private final int val$myPosition;

                    public void run()
                    {
                        Log.e("bbb", (new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(((DownloadMovieItem)list.get(myPosition)).getId()).append("&from=apk").toString());
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(((DownloadMovieItem)list.get(myPosition)).getId()).append("&from=apk").toString());
                    }

            
            {
                this$1 = final__pcls7;
                myPosition = I.this;
                super();
            }
                })).start();
                if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(ctx) != 1)
                {
                    downwifi();
                    return;
                }
                if (dbUtils.queryfile(((DownloadMovieItem)list.get(myPosition)).getId()) == null)
                {
                    MydownloadApk(((DownloadMovieItem)list.get(myPosition)).getId(), ((DownloadMovieItem)list.get(myPosition)).getTitle(), ((DownloadMovieItem)list.get(myPosition)).getIcon(), ((DownloadMovieItem)list.get(myPosition)).getSerial());
                } else
                {
                    try
                    {
                        Toast.makeText(ctx, "It has been in downloading list already.", 1).show();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view1) { }
                }
_L4:
                (new Handler()).post(new Runnable() {

                    final _cls7 this$1;

                    public void run()
                    {
                        mWindow.dismiss();
                    }

            
            {
                this$1 = _cls7.this;
                super();
            }
                });
                return;
_L2:
                if (mHas_apk.equals("0"))
                {
                    (new Thread(myPosition. new Runnable() {

                        final _cls7 this$1;
                        private final int val$myPosition;

                        public void run()
                        {
                            try
                            {
                                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(((DownloadMovieItem)list.get(myPosition)).getId()).append("&from=google").toString());
                                return;
                            }
                            catch (Exception exception)
                            {
                                return;
                            }
                        }

            
            {
                this$1 = final__pcls7;
                myPosition = I.this;
                super();
            }
                    })).start();
                    view1 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(((DownloadMovieItem)list.get(myPosition)).getId()).toString()));
                    ctx.startActivity(view1);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }


            
            {
                this$0 = Home_Gridview_Adapter.this;
                myPosition = i;
                mHas_apk = s;
                super();
            }
        });
        rl_share.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_Gridview_Adapter this$0;
            private final int val$myPosition;

            public void onClick(View view1)
            {
                MobclickAgent.onEvent(ctx, "share");
                view1 = (new StringBuilder("Share: http://android.downloadatoz.com/apps/")).append(((DownloadMovieItem)list.get(myPosition)).getId()).append(",").append(((DownloadMovieItem)list.get(myPosition)).getSerial()).append(".html").toString();
                Log.e("location", view1);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", view1);
                ctx.startActivity(Intent.createChooser(intent, "AIO Downloaded").addFlags(0x10000000));
                (new Handler()).post(new Runnable() {

                    final _cls8 this$1;

                    public void run()
                    {
                        mWindow.dismiss();
                    }

            
            {
                this$1 = _cls8.this;
                super();
            }
                });
            }


            
            {
                this$0 = Home_Gridview_Adapter.this;
                myPosition = i;
                super();
            }
        });
        lframelayout1.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_Gridview_Adapter this$0;
            private final int val$myPosition;

            public void onClick(View view1)
            {
                view1 = new Intent(ctx, com/aio/downloader/activity/AppDetailsActivity);
                view1.putExtra("myid", ((DownloadMovieItem)list.get(myPosition)).getId());
                view1.addFlags(0x10000000);
                ctx.startActivity(view1);
                (new Handler()).post(new Runnable() {

                    final _cls9 this$1;

                    public void run()
                    {
                        mWindow.dismiss();
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                });
            }


            
            {
                this$0 = Home_Gridview_Adapter.this;
                myPosition = i;
                super();
            }
        });
        mWindow = new PopupWindow(view);
        myPosition = dip2px(ctx, 168F);
        Log.e("qwer", (new StringBuilder("dip2px=")).append(myPosition).toString());
        mWindow.setWidth(-2);
        mWindow.setHeight(-2);
        mWindow.setFocusable(true);
        mHas_apk = new ColorDrawable(0);
        mWindow.setBackgroundDrawable(mHas_apk);
    }

    public static int px2dip(Context context, float f)
    {
        return (int)(f / context.getResources().getDisplayMetrics().density + 0.5F);
    }

    public void MydownloadApk(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(ctx, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, i) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final Home_Gridview_Adapter this$0;
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
                    Log.e("gae", (new StringBuilder("url=")).append(url).toString());
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
                        String s1 = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(ctx.getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl(avoid);
                        Log.e("qqq", (new StringBuilder("url=")).append(avoid).toString());
                        d.setFilePath(s1);
                        Log.v("fefe", avoid);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setType("app");
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 3;
                        handler.sendMessage(avoid);
                        istag = Boolean.valueOf(true);
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
                    void1 = new Intent();
                    if (!apptag.equals("appfeatured")) goto _L2; else goto _L1
_L1:
                    void1.setAction("hideappfeatured");
_L4:
                    ctx.sendBroadcast(void1);
                    return;
_L2:
                    if (apptag.equals("appgvhome"))
                    {
                        void1.setAction("hidehomeapp");
                    } else
                    if (apptag.equals("gamefeatured"))
                    {
                        void1.setAction("hidegamefeatured");
                    } else
                    if (apptag.equals("homefeatured"))
                    {
                        void1.setAction("hidehomefeatured");
                    } else
                    if (apptag.equals("appdetail"))
                    {
                        void1.setAction("appdetail");
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                protected void onPreExecute()
                {
                    Intent intent;
                    super.onPreExecute();
                    intent = new Intent();
                    if (!apptag.equals("appfeatured")) goto _L2; else goto _L1
_L1:
                    intent.setAction("showappfeatured");
_L4:
                    ctx.sendBroadcast(intent);
                    return;
_L2:
                    if (apptag.equals("appgvhome"))
                    {
                        intent.setAction("showhomeapp");
                    } else
                    if (apptag.equals("gamefeatured"))
                    {
                        intent.setAction("showgamefeatured");
                    } else
                    if (apptag.equals("homefeatured"))
                    {
                        intent.setAction("showhomefeatured");
                    } else
                    if (apptag.equals("appdetail"))
                    {
                        intent.setAction("appdetail");
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                this$0 = Home_Gridview_Adapter.this;
                id = s;
                title = s2;
                icon = s3;
                appserial = i;
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

    public void addItem(ArrayList arraylist)
    {
        list.addAll(arraylist);
        notifyDataSetChanged();
    }

    public boolean getBooleanValueByConfigFile(String s)
    {
        return getSp().getBoolean(s, false);
    }

    public int getCount()
    {
        if (list != null && list.size() > 0)
        {
            return list.size();
        } else
        {
            return 0;
        }
    }

    public android.content.SharedPreferences.Editor getEdit()
    {
        return edit;
    }

    public int getIntegerValueByConfigFile(String s)
    {
        return getSp().getInt(s, -1);
    }

    public Object getItem(int i)
    {
        return list.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public MyApplcation getMyApp()
    {
        return myApp;
    }

    public SharedPreferences getSp()
    {
        return sp;
    }

    public String getStringValueByConfigFile(String s)
    {
        return sp.getString(s, "");
    }

    public View getView(final int position, View view, final ViewGroup has_apk)
    {
        has_apk = (DownloadMovieItem)list.get(position);
        if (view == null)
        {
            holder = new ViewHolder();
            view = View.inflate(ctx, 0x7f030054, null);
            holder.gvimg = (ImageView)view.findViewById(0x7f07021c);
            holder.gvtitle = (TextView)view.findViewById(0x7f07021f);
            holder.gvdown = (LImageButton)view.findViewById(0x7f07021e);
            holder.gvratingbar = (RatingBar)view.findViewById(0x7f070221);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        holder.gvtitle.setText(((DownloadMovieItem)list.get(position)).getTitle());
        holder.gvratingbar.setRating(((DownloadMovieItem)list.get(position)).getRating().floatValue());
        try
        {
            app.asyncLoadImage(((DownloadMovieItem)list.get(position)).getIcon(), holder.gvimg);
        }
        catch (Exception exception) { }
        has_apk = has_apk.getHas_apk();
        holder.gvdown.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_Gridview_Adapter this$0;
            private final String val$has_apk;
            private final int val$position;

            public void onClick(View view1)
            {
                WindowManager windowmanager = (WindowManager)ctx.getSystemService("window");
                windowmanager.getDefaultDisplay().getWidth();
                int i = windowmanager.getDefaultDisplay().getHeight();
                int ai[] = new int[2];
                view1.getLocationOnScreen(ai);
                popuWindow(position, has_apk);
                if (i / 2 < ai[1])
                {
                    int j = Home_Gridview_Adapter.dip2px(ctx, 150F);
                    mWindow.showAtLocation(view1, 0, ai[0], ai[1] - j);
                    return;
                } else
                {
                    mWindow.showAtLocation(view1, 0, ai[0], ai[1] - mWindow.getHeight());
                    return;
                }
            }

            
            {
                this$0 = Home_Gridview_Adapter.this;
                position = i;
                has_apk = s;
                super();
            }
        });
        return view;
    }

    public Context getmContext()
    {
        return mContext;
    }

    public void initView()
    {
        try
        {
            MyApplcation myapplcation = (MyApplcation)ctx.getApplicationContext();
            setSp(ctx.getSharedPreferences("config", 0));
            edit = getSp().edit();
            setMyApp(myapplcation);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public boolean putBooleanValueToConfigFile(String s, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = getSp().edit();
        editor.putBoolean(s, flag);
        return editor.commit();
    }

    public boolean putStringValueToConfigFile(String s, int i)
    {
        android.content.SharedPreferences.Editor editor = getSp().edit();
        editor.putInt(s, i);
        return editor.commit();
    }

    public boolean putStringValueToConfigFile(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = getSp().edit();
        editor.putString(s, s1);
        return editor.commit();
    }

    public void setEdit(android.content.SharedPreferences.Editor editor)
    {
        edit = editor;
    }

    public void setMyApp(MyApplcation myapplcation)
    {
        myApp = myapplcation;
    }

    public void setSp(SharedPreferences sharedpreferences)
    {
        sp = sharedpreferences;
    }

    public void setmContext(Context context)
    {
        mContext = context;
    }

    public void toDownload(DownloadMovieItem downloadmovieitem)
    {
        downloadmovieitem.setDownloadState(Integer.valueOf(7));
        getMyApp().setStartDownloadMovieItem(downloadmovieitem);
        ctx.sendBroadcast((new Intent()).setAction("download_aio"));
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
