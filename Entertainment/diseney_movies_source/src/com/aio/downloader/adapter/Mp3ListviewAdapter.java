// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.LianwangDialog;
import com.aio.downloader.model.Model;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.publicTools;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONException;
import org.json.JSONObject;

public class Mp3ListviewAdapter extends BaseAdapter
    implements ContentValue
{
    class ViewHolder
    {

        private RelativeLayout list_bg;
        private Button mp3_download_bt;
        private TextView mp3album_title;
        private TextView mp3artist_title;
        private TextView mp3size;
        private TextView mp3title;
        final Mp3ListviewAdapter this$0;













        ViewHolder()
        {
            this$0 = Mp3ListviewAdapter.this;
            super();
        }
    }


    private MyApplcation app;
    private Context ctx;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private HashMap default_options;
    private android.content.SharedPreferences.Editor edit;
    private List list;
    private Context mContext;
    private Model model;
    private String mp3tag;
    private MyApplcation myApp;
    private publicTools publictools;
    private SharedPreferences sp;
    private SharedPreferences sp2;
    private SharedPreferences spnetworkre;

    public Mp3ListviewAdapter(Context context, List list1, String s)
    {
        publictools = null;
        dbUtils = null;
        ctx = context;
        list = list1;
        mp3tag = s;
        try
        {
            app = (MyApplcation)context.getApplicationContext();
            initView();
            publictools = new publicTools(context);
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
            sp2 = context.getSharedPreferences("name", 0);
            db = new FinalDBChen(getmContext(), context.getDatabasePath("download2.db").getAbsolutePath());
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

            final Mp3ListviewAdapter this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = Mp3ListviewAdapter.this;
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

            final Mp3ListviewAdapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = Mp3ListviewAdapter.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final Mp3ListviewAdapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                ctx.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = Mp3ListviewAdapter.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    public void MydownloadMp3(String s, String s1, String s2)
    {
        DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
        if (db.findItemsByWhereAndWhereValue("file_id", s, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
        {
            Mydialog();
            return;
        } else
        {
            String s3 = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(ctx.getPackageName()).toString(), (new StringBuilder(String.valueOf(s))).append(".mp3").toString())).getAbsolutePath();
            downloadmovieitem.setDownloadUrl(s2);
            Log.e("olol", s2);
            downloadmovieitem.setFilePath(s3);
            downloadmovieitem.setDownloadState(Integer.valueOf(4));
            downloadmovieitem.setMovieName(s1);
            downloadmovieitem.setFile_id(s);
            downloadmovieitem.setMovieHeadImagePath("http://android.downloadatoz.com/_201409/market/img/mp3.png");
            downloadmovieitem.setType("mp3");
            downloadmovieitem.setCreate_time(Long.valueOf(System.currentTimeMillis()));
            toDownload(downloadmovieitem);
            Myutils.getInstance();
            Myutils.list.add(downloadmovieitem);
            Toast.makeText(ctx, (new StringBuilder("'")).append(downloadmovieitem.getMovieName()).append("' is added to download queue.").toString(), 0).show();
            return;
        }
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
        int j;
        int k;
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = View.inflate(ctx, 0x7f03007c, null);
            viewgroup.mp3title = (TextView)view.findViewById(0x7f0702ee);
            viewgroup.mp3album_title = (TextView)view.findViewById(0x7f0702ef);
            viewgroup.mp3artist_title = (TextView)view.findViewById(0x7f0702f0);
            viewgroup.mp3size = (TextView)view.findViewById(0x7f0702f1);
            viewgroup.mp3_download_bt = (Button)view.findViewById(0x7f0702f2);
            viewgroup.list_bg = (RelativeLayout)view.findViewById(0x7f0702ed);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        j = -1;
        k = ctx.getSharedPreferences("mp3_recent_data", 0).getInt("mp3_recent_selector", -1);
        j = k;
_L2:
        if (j == i)
        {
            ((ViewHolder) (viewgroup)).list_bg.setBackgroundResource(0x7f020106);
        } else
        {
            ((ViewHolder) (viewgroup)).list_bg.setBackgroundResource(0x7f020105);
        }
        ((ViewHolder) (viewgroup)).mp3title.setText(in_fo.getTitle());
        ((ViewHolder) (viewgroup)).mp3album_title.setText(in_fo.getAlbum_title());
        ((ViewHolder) (viewgroup)).mp3artist_title.setText(in_fo.getArtist_title());
        ((ViewHolder) (viewgroup)).mp3size.setText(in_fo.getSize());
        ((ViewHolder) (viewgroup)).mp3_download_bt.setOnClickListener(new android.view.View.OnClickListener() {

            final Mp3ListviewAdapter this$0;
            private final DownloadMovieItem val$in_fo;

            public void onClick(View view1)
            {
                sp2.edit().putString("appname", in_fo.getTitle()).commit();
                (new Thread(in_fo. new Runnable() {

                    final _cls1 this$1;
                    private final DownloadMovieItem val$in_fo;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=mp3&id=")).append(in_fo.getId()).append("&title=").append(in_fo.getTitle()).append("&album_title=").append(in_fo.getAlbum_title()).append("&artist_title=").append(in_fo.getArtist_title()).append("&size=").append(in_fo.getSize()).toString());
                    }

            
            {
                this$1 = final__pcls1;
                in_fo = DownloadMovieItem.this;
                super();
            }
                })).start();
                if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(ctx) != 1)
                {
                    downwifi();
                    return;
                }
                if (dbUtils.queryfile(in_fo.getId()) == null)
                {
                    (in_fo. new AsyncTask() {

                        final _cls1 this$1;
                        private final DownloadMovieItem val$in_fo;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            avoid = publicTools.getUrl((new StringBuilder("http://mp3box.to/user/download/?song=")).append(in_fo.getId()).toString());
                            HashMap hashmap = new HashMap();
                            hashmap.put("content", avoid);
                            avoid = publicTools.doHttpPost((new StringBuilder("http://android.downloadatoz.com/_201409/market/mp3_pdt_parser.php?id=")).append(in_fo.getId()).toString(), hashmap);
                            getmp3json(avoid);
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            try
                            {
                                MydownloadMp3(in_fo.getId(), in_fo.getTitle(), model.getMp3url());
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void void1)
                            {
                                Toast.makeText(ctx, ctx.getString(0x7f0b0064), 1).show();
                            }
                            void1 = new Intent();
                            if (!mp3tag.equals("mp3recent")) goto _L2; else goto _L1
_L1:
                            void1.setAction("hiderecentmp3");
_L4:
                            ctx.sendBroadcast(void1);
                            return;
_L2:
                            if (mp3tag.equals("mp3popular"))
                            {
                                void1.setAction("hidepopularmp3");
                            } else
                            if (mp3tag.equals("mp3search"))
                            {
                                void1.setAction("hidesearchmp3");
                            }
                            if (true) goto _L4; else goto _L3
_L3:
                        }

                        protected void onPreExecute()
                        {
                            Intent intent;
                            super.onPreExecute();
                            intent = new Intent();
                            if (!mp3tag.equals("mp3recent")) goto _L2; else goto _L1
_L1:
                            intent.setAction("showrecentmp3");
_L4:
                            ctx.sendBroadcast(intent);
                            return;
_L2:
                            if (mp3tag.equals("mp3popular"))
                            {
                                intent.setAction("showpopularmp3");
                            } else
                            if (mp3tag.equals("mp3search"))
                            {
                                intent.setAction("showsearchmp3");
                            }
                            if (true) goto _L4; else goto _L3
_L3:
                        }

            
            {
                this$1 = final__pcls1;
                in_fo = DownloadMovieItem.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                } else
                {
                    Mydialog();
                    return;
                }
            }


            
            {
                this$0 = Mp3ListviewAdapter.this;
                in_fo = downloadmovieitem;
                super();
            }
        });
        return view;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Context getmContext()
    {
        return mContext;
    }

    public void getmp3json(String s)
    {
        try
        {
            s = new JSONObject(s);
            if (s.getInt("status") == 1)
            {
                model = new Model();
                model.setMp3url(s.getString("url"));
                Log.e("olol", (new StringBuilder("utl=")).append(s.getString("url")).toString());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
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
