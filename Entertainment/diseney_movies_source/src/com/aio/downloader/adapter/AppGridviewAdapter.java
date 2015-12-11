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
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
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

public class AppGridviewAdapter extends BaseAdapter
    implements ContentValue
{
    class ViewHolder
    {

        private ImageView gvdown;
        private ImageView gvimg;
        private RatingBar gvratingbar;
        private TextView gvtitle;
        final AppGridviewAdapter this$0;









        ViewHolder()
        {
            this$0 = AppGridviewAdapter.this;
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

    public AppGridviewAdapter(Context context, List list1, String s)
    {
        handler = new Handler() {

            final AppGridviewAdapter this$0;

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
                if (!apptag.equals("appgvdetail")) goto _L2; else goto _L1
_L1:
                message.setAction("appdetail");
_L4:
                ctx.sendBroadcast(message);
                return;
_L2:
                if (apptag.equals("appgvhome"))
                {
                    message.setAction("homeapp");
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = AppGridviewAdapter.this;
                super();
            }
        };
        istag = Boolean.valueOf(false);
        publictools = null;
        dbUtils = null;
        typeFace = null;
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

            final AppGridviewAdapter this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = AppGridviewAdapter.this;
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

            final AppGridviewAdapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = AppGridviewAdapter.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final AppGridviewAdapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                ctx.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = AppGridviewAdapter.this;
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
                final AppGridviewAdapter this$0;
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
                        String s1 = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(ctx.getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl(avoid);
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
                    if (!apptag.equals("appgvdetail")) goto _L2; else goto _L1
_L1:
                    void1.setAction("hidegvappdetail");
_L4:
                    ctx.sendBroadcast(void1);
                    return;
_L2:
                    if (apptag.equals("appgvhome"))
                    {
                        void1.setAction("hidehomeapp");
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                protected void onPreExecute()
                {
                    Intent intent;
                    super.onPreExecute();
                    intent = new Intent();
                    if (!apptag.equals("appgvdetail")) goto _L2; else goto _L1
_L1:
                    intent.setAction("showgvappdetail");
_L4:
                    ctx.sendBroadcast(intent);
                    return;
_L2:
                    if (apptag.equals("appgvhome"))
                    {
                        intent.setAction("showhomeapp");
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                this$0 = AppGridviewAdapter.this;
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

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        final DownloadMovieItem in_fo = (DownloadMovieItem)list.get(i);
        final String has_apk;
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = View.inflate(ctx, 0x7f030054, null);
            viewgroup.gvimg = (ImageView)view.findViewById(0x7f07021c);
            viewgroup.gvtitle = (TextView)view.findViewById(0x7f07021f);
            viewgroup.gvdown = (ImageView)view.findViewById(0x7f07021e);
            viewgroup.gvratingbar = (RatingBar)view.findViewById(0x7f070221);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).gvtitle.setText(in_fo.getTitle());
        ((ViewHolder) (viewgroup)).gvtitle.setTypeface(typeFace);
        ((ViewHolder) (viewgroup)).gvratingbar.setRating(in_fo.getRating().floatValue());
        try
        {
            app.asyncLoadImage(in_fo.getIcon(), ((ViewHolder) (viewgroup)).gvimg);
        }
        catch (Exception exception) { }
        has_apk = in_fo.getHas_apk();
        if (!has_apk.equals("1")) goto _L2; else goto _L1
_L1:
        ((ViewHolder) (viewgroup)).gvdown.setBackgroundResource(0x7f020006);
_L4:
        ((ViewHolder) (viewgroup)).gvdown.setOnClickListener(new android.view.View.OnClickListener() {

            final AppGridviewAdapter this$0;
            private final String val$has_apk;
            private final DownloadMovieItem val$in_fo;

            public void onClick(View view1)
            {
                sp2.edit().putString("appname", in_fo.getTitle()).commit();
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
                }
                try
                {
                    Toast.makeText(ctx, "It has been in downloading list already.", 1).show();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (View view1)
                {
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
                this$0 = AppGridviewAdapter.this;
                in_fo = downloadmovieitem;
                has_apk = s;
                super();
            }
        });
        return view;
_L2:
        if (has_apk.equals("0"))
        {
            ((ViewHolder) (viewgroup)).gvdown.setBackgroundResource(0x7f0200b4);
        }
        if (true) goto _L4; else goto _L3
_L3:
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
