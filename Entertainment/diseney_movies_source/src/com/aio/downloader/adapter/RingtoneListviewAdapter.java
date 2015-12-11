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
import android.widget.RatingBar;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONException;
import org.json.JSONObject;

public class RingtoneListviewAdapter extends BaseAdapter
    implements ContentValue
{
    class ViewHolder
    {

        private RelativeLayout list_bg;
        private Button ringtone_download_bt;
        private RatingBar ringtone_ratingbar;
        private TextView ringtonecat;
        private TextView ringtonetitle;
        final RingtoneListviewAdapter this$0;











        ViewHolder()
        {
            this$0 = RingtoneListviewAdapter.this;
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
    private MyApplcation myApp;
    private publicTools publictools;
    private String ringtonetag;
    private SharedPreferences sp;
    private SharedPreferences sp2;
    private SharedPreferences spnetworkre;

    public RingtoneListviewAdapter(Context context, List list1, String s)
    {
        publictools = null;
        dbUtils = null;
        ctx = context;
        list = list1;
        ringtonetag = s;
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

            final RingtoneListviewAdapter this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = RingtoneListviewAdapter.this;
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

            final RingtoneListviewAdapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = RingtoneListviewAdapter.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneListviewAdapter this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                ctx.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = RingtoneListviewAdapter.this;
                dialog = lianwangdialog;
                super();
            }
        });
    }

    public void MydownloadMp3AndRingtone(String s, String s1, String s2)
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
            Log.e("olol", (new StringBuilder("ringtone=")).append(s2).toString());
            downloadmovieitem.setFilePath(s3);
            downloadmovieitem.setDownloadState(Integer.valueOf(4));
            downloadmovieitem.setMovieName(s1);
            downloadmovieitem.setFile_id(s);
            downloadmovieitem.setMovieHeadImagePath("http://android.downloadatoz.com/_201409/market/img/ringtone.png");
            downloadmovieitem.setType("app");
            downloadmovieitem.setCat("mp3");
            downloadmovieitem.setCreate_time(Long.valueOf(System.currentTimeMillis()));
            toDownload(downloadmovieitem);
            Myutils.getInstance();
            Myutils.list.add(downloadmovieitem);
            Toast.makeText(ctx, (new StringBuilder("'")).append(downloadmovieitem.getMovieName()).append("' is added to download queue.").toString(), 0).show();
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
        int j;
        int k;
        if (view == null)
        {
            viewgroup = new ViewHolder();
            view = View.inflate(ctx, 0x7f0300a9, null);
            viewgroup.ringtonetitle = (TextView)view.findViewById(0x7f070393);
            viewgroup.ringtonecat = (TextView)view.findViewById(0x7f070394);
            viewgroup.ringtone_ratingbar = (RatingBar)view.findViewById(0x7f070395);
            viewgroup.ringtone_download_bt = (Button)view.findViewById(0x7f070396);
            viewgroup.list_bg = (RelativeLayout)view.findViewById(0x7f0702ed);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        j = -1;
        k = ctx.getSharedPreferences("ringtone_recent_data", 0).getInt("ringtone_recent_selector", -1);
        j = k;
_L2:
        if (j == i)
        {
            ((ViewHolder) (viewgroup)).list_bg.setBackgroundResource(0x7f020106);
        } else
        {
            ((ViewHolder) (viewgroup)).list_bg.setBackgroundResource(0x7f020106);
        }
        ((ViewHolder) (viewgroup)).ringtonetitle.setText(in_fo.getTitle());
        ((ViewHolder) (viewgroup)).ringtonecat.setText(in_fo.getCat());
        ((ViewHolder) (viewgroup)).ringtone_ratingbar.setRating(in_fo.getRating().floatValue());
        ((ViewHolder) (viewgroup)).ringtone_download_bt.setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneListviewAdapter this$0;
            private final DownloadMovieItem val$in_fo;

            public void onClick(View view1)
            {
                (new Thread(in_fo. new Runnable() {

                    final _cls1 this$1;
                    private final DownloadMovieItem val$in_fo;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=ringtone&id=")).append(in_fo.getId()).append("&title=").append(in_fo.getTitle()).append("&cat=").append(in_fo.getCat()).append("&downloads=").append(in_fo.getDownloads()).toString());
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

                        private Model model;
                        final _cls1 this$1;
                        private final DownloadMovieItem val$in_fo;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            avoid = publicTools.getUrl((new StringBuilder("http://t.zedge.net/ringtone/")).append(in_fo.getId()).append("/?page=1").toString());
                            HashMap hashmap = new HashMap();
                            hashmap.put("content", avoid);
                            avoid = publicTools.doHttpPost((new StringBuilder("http://android.downloadatoz.com/_201409/market/ringtone_pdt_parser.php?content=")).append(in_fo.getId()).toString(), hashmap);
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
                                MydownloadMp3AndRingtone(in_fo.getId(), in_fo.getTitle(), model.getRingtoneurl());
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void void1)
                            {
                                Toast.makeText(ctx, ctx.getString(0x7f0b0064), 1).show();
                            }
                            void1 = new Intent();
                            if (!ringtonetag.equals("ringtonerecent")) goto _L2; else goto _L1
_L1:
                            void1.setAction("hiderecentringtone");
_L4:
                            ctx.sendBroadcast(void1);
                            return;
_L2:
                            if (ringtonetag.equals("ringtonepopular"))
                            {
                                void1.setAction("hidepopularringtone");
                            } else
                            if (ringtonetag.equals("ringtonesearch"))
                            {
                                void1.setAction("hidesearchringtone");
                            }
                            if (true) goto _L4; else goto _L3
_L3:
                        }

                        protected void onPreExecute()
                        {
                            Intent intent;
                            super.onPreExecute();
                            intent = new Intent();
                            if (!ringtonetag.equals("ringtonerecent")) goto _L2; else goto _L1
_L1:
                            intent.setAction("showrecentringtone");
_L4:
                            ctx.sendBroadcast(intent);
                            return;
_L2:
                            if (ringtonetag.equals("ringtonepopular"))
                            {
                                intent.setAction("showpopularringtone");
                            } else
                            if (ringtonetag.equals("ringtonesearch"))
                            {
                                intent.setAction("showsearchringtone");
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
                this$0 = RingtoneListviewAdapter.this;
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
