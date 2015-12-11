// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.LianwangDialog;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.publicTools;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;

public class TodaypickListviewAdapter extends BaseAdapter
    implements ContentValue
{
    class ViewHolder
    {

        private ImageView iv_today_icon;
        private LinearLayout ll_today_top_title;
        final TodaypickListviewAdapter this$0;
        private Button todaydownload_bt;
        private TextView todayhits;
        private ImageView todayimg;
        private RatingBar todayratingbar;
        private TextView todaytime;
        private TextView todaytitletv;
        private TextView tv_desc;



















        ViewHolder()
        {
            this$0 = TodaypickListviewAdapter.this;
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
    private Boolean istag;
    private List list;
    private Context mContext;
    private MyApplcation myApp;
    private publicTools publictools;
    private SharedPreferences sp;
    private SharedPreferences sp2;
    private SharedPreferences spnetworkre;
    private Typeface typeFace;

    public TodaypickListviewAdapter(Context context, List list1, String s)
    {
        handler = new Handler() {

            final TodaypickListviewAdapter this$0;

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
                    Mydialog();
                    return;

                case 3: // '\003'
                    istag = Boolean.valueOf(true);
                    break;
                }
                Toast.makeText(ctx, (new StringBuilder("'")).append(sp2.getString("todayname", "this app")).append("' is added to download queue.").toString(), 0).show();
            }

            
            {
                this$0 = TodaypickListviewAdapter.this;
                super();
            }
        };
        istag = Boolean.valueOf(false);
        publictools = null;
        dbUtils = null;
        typeFace = null;
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
        }
        // Misplaced declaration of an exception variable
        catch (List list1) { }
        try
        {
            typeFace = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
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

            final TodaypickListviewAdapter this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = TodaypickListviewAdapter.this;
                super();
            }
        }).show();
    }

    private void downwifi()
    {
        final LianwangDialog dialog = new LianwangDialog(ctx, 0x7f0c000e);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button = (Button)dialog.findViewById(0x7f070141);
        Button button1 = (Button)dialog.findViewById(0x7f070142);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final TodaypickListviewAdapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = TodaypickListviewAdapter.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final TodaypickListviewAdapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                ctx.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = TodaypickListviewAdapter.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    public void MydownloadApk(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        Log.v("rfrf", (new StringBuilder("111111")).append(final_s1).toString());
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
                final TodaypickListviewAdapter this$0;
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
                    Log.v("rfrf", (new StringBuilder("22222")).append(avoid).toString());
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
                        d.setFilePath(s1);
                        Log.v("fefe", avoid);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        Log.v("rtrt", (new StringBuilder(String.valueOf(icon))).append("///").toString());
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
                    if (apptag.equals("todaypick"))
                    {
                        void1.setAction("hidetodayapp");
                    }
                    ctx.sendBroadcast(void1);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    Intent intent = new Intent();
                    if (apptag.equals("todaypick"))
                    {
                        intent.setAction("showtodayapp");
                    }
                    ctx.sendBroadcast(intent);
                }

            
            {
                this$0 = TodaypickListviewAdapter.this;
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

    public View getView(int i, final View has_apk, ViewGroup viewgroup)
    {
        final DownloadMovieItem in_fo = (DownloadMovieItem)list.get(i);
        View view;
        String s;
        long l;
        if (has_apk == null)
        {
            viewgroup = new ViewHolder();
            view = View.inflate(ctx, 0x7f0300b4, null);
            viewgroup.todaytime = (TextView)view.findViewById(0x7f0703d7);
            viewgroup.todaytitletv = (TextView)view.findViewById(0x7f0703d2);
            viewgroup.todayhits = (TextView)view.findViewById(0x7f0703d4);
            viewgroup.todayimg = (ImageView)view.findViewById(0x7f0703d0);
            viewgroup.todayratingbar = (RatingBar)view.findViewById(0x7f0703d3);
            viewgroup.todaydownload_bt = (Button)view.findViewById(0x7f0703d5);
            viewgroup.tv_desc = (TextView)view.findViewById(0x7f0703d6);
            viewgroup.iv_today_icon = (ImageView)view.findViewById(0x7f0703d1);
            viewgroup.ll_today_top_title = (LinearLayout)view.findViewById(0x7f0703cf);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)has_apk.getTag();
            view = has_apk;
        }
        if (i == 0)
        {
            ((ViewHolder) (viewgroup)).ll_today_top_title.setVisibility(0);
        } else
        {
            ((ViewHolder) (viewgroup)).ll_today_top_title.setVisibility(8);
        }
        l = in_fo.getCreate_time().longValue() * 1000L;
        s = (String)DateFormat.format("MM", l);
        if (s.equals("01"))
        {
            has_apk = "Jan";
        } else
        if (s.equals("02"))
        {
            has_apk = "Feb";
        } else
        if (s.equals("03"))
        {
            has_apk = "March";
        } else
        if (s.equals("04"))
        {
            has_apk = "Apr";
        } else
        if (s.equals("05"))
        {
            has_apk = "May";
        } else
        if (s.equals("06"))
        {
            has_apk = "June";
        } else
        if (s.equals("07"))
        {
            has_apk = "July";
        } else
        if (s.equals("08"))
        {
            has_apk = "Aug";
        } else
        if (s.equals("09"))
        {
            has_apk = "Sept";
        } else
        if (s.equals("10"))
        {
            has_apk = "Oct";
        } else
        if (s.equals("11"))
        {
            has_apk = "Nov";
        } else
        {
            has_apk = s;
            if (s.equals("12"))
            {
                has_apk = "Dec";
            }
        }
        try
        {
            ((ViewHolder) (viewgroup)).todaytime.setText((new StringBuilder(String.valueOf(has_apk))).append(DateFormat.format(" dd, yyyy", l)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (final View has_apk) { }
        ((ViewHolder) (viewgroup)).todaytitletv.setText(in_fo.getTitle());
        ((ViewHolder) (viewgroup)).tv_desc.setText(in_fo.getPpshort_desc());
        ((ViewHolder) (viewgroup)).todaytitletv.setTypeface(typeFace);
        ((ViewHolder) (viewgroup)).todayhits.setText((new StringBuilder("(")).append(in_fo.getSetCount()).append(")").toString());
        ((ViewHolder) (viewgroup)).todayratingbar.setRating(in_fo.getRating().floatValue());
        try
        {
            app.asyncLoadImage1(in_fo.getMovieHeadImagePath(), ((ViewHolder) (viewgroup)).todayimg);
            app.asyncLoadImage(in_fo.getIcon(), ((ViewHolder) (viewgroup)).iv_today_icon);
        }
        // Misplaced declaration of an exception variable
        catch (final View has_apk) { }
        has_apk = in_fo.getHas_apk();
        if (has_apk.equals("1"))
        {
            ((ViewHolder) (viewgroup)).todaydownload_bt.setBackgroundResource(0x7f020006);
        } else
        if (has_apk.equals("0"))
        {
            ((ViewHolder) (viewgroup)).todaydownload_bt.setBackgroundResource(0x7f0200b4);
        }
        ((ViewHolder) (viewgroup)).todaydownload_bt.setOnClickListener(new android.view.View.OnClickListener() {

            final TodaypickListviewAdapter this$0;
            private final String val$has_apk;
            private final DownloadMovieItem val$in_fo;

            public void onClick(View view1)
            {
                sp2.edit().putString("todayname", in_fo.getTitle()).commit();
                if (!has_apk.equals("1")) goto _L2; else goto _L1
_L1:
                (new Thread(in_fo. new Runnable() {

                    final _cls2 this$1;
                    private final DownloadMovieItem val$in_fo;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(in_fo.getId()).append("&from=apk").toString());
                    }

            
            {
                this$1 = final__pcls2;
                in_fo = DownloadMovieItem.this;
                super();
            }
                })).start();
                if (!spnetworkre.getBoolean("isopen", false) || NetWorkUtil.getAPNType(ctx) == 1) goto _L4; else goto _L3
_L3:
                downwifi();
_L6:
                return;
_L4:
                if (dbUtils.queryfile(in_fo.getId()) == null)
                {
                    MydownloadApk(in_fo.getId(), in_fo.getTitle(), in_fo.getIcon(), in_fo.getSerial());
                    return;
                } else
                {
                    Mydialog();
                    return;
                }
_L2:
                if (has_apk.equals("0"))
                {
                    (new Thread(in_fo. new Runnable() {

                        final _cls2 this$1;
                        private final DownloadMovieItem val$in_fo;

                        public void run()
                        {
                            try
                            {
                                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(in_fo.getId()).append("&from=google").toString());
                                return;
                            }
                            catch (Exception exception)
                            {
                                return;
                            }
                        }

            
            {
                this$1 = final__pcls2;
                in_fo = DownloadMovieItem.this;
                super();
            }
                    })).start();
                    view1 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(in_fo.getId()).toString()));
                    ctx.startActivity(view1);
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                this$0 = TodaypickListviewAdapter.this;
                in_fo = downloadmovieitem;
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
