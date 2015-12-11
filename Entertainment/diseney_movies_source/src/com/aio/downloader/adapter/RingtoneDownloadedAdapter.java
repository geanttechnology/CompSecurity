// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.media.RingtoneManager;
import android.os.Environment;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import java.util.List;

public class RingtoneDownloadedAdapter extends BaseAdapter
    implements android.view.View.OnClickListener
{
    class ViewHolder
    {

        ImageView my_delete_movie;
        TextView my_movie_name_item;
        Button my_stop_download_bt;
        ImageView my_test_head_image3;
        TextView my_totalsize;
        final RingtoneDownloadedAdapter this$0;

        ViewHolder()
        {
            this$0 = RingtoneDownloadedAdapter.this;
            super();
        }
    }


    private MyApplcation app;
    Context ctx;
    ViewHolder holder;
    boolean isAlarm;
    boolean isMusic;
    boolean isNotification;
    boolean isRingtone;
    private LinearLayout l1;
    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private List list;
    private PopupWindow mWindow;
    LinearLayout mystandard;
    private String new_file_path;
    private RelativeLayout popodismiss;
    SharedPreferences sp;
    private View view;

    public RingtoneDownloadedAdapter(Context context, List list1)
    {
        holder = null;
        isRingtone = false;
        isNotification = false;
        isAlarm = false;
        isMusic = false;
        sp = null;
        ctx = context;
        list = list1;
        try
        {
            app = (MyApplcation)context.getApplicationContext();
        }
        // Misplaced declaration of an exception variable
        catch (List list1) { }
        sp = context.getSharedPreferences("data", 0);
    }

    private void initPopuWindow1(View view1)
    {
        if (mWindow == null)
        {
            view = LayoutInflater.from(ctx).inflate(0x7f0300ab, null);
            mWindow = new PopupWindow(view, -1, -1);
            l1 = (LinearLayout)view.findViewById(0x7f070000);
            l2 = (LinearLayout)view.findViewById(0x7f07039f);
            l3 = (LinearLayout)view.findViewById(0x7f0703a0);
            l4 = (LinearLayout)view.findViewById(0x7f0703a1);
            popodismiss = (RelativeLayout)view.findViewById(0x7f07039e);
        }
        Object obj = new ColorDrawable(0);
        mWindow.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        obj = ((Activity)ctx).getWindow().getAttributes();
        obj.alpha = 0.1F;
        ((Activity)ctx).getWindow().setAttributes(((android.view.WindowManager.LayoutParams) (obj)));
        mWindow.setOutsideTouchable(true);
        mWindow.setFocusable(true);
        mWindow.showAtLocation((View)view1.getParent(), 17, 0, 0);
        mWindow.update();
        mWindow.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() {

            final RingtoneDownloadedAdapter this$0;

            public void onDismiss()
            {
                android.view.WindowManager.LayoutParams layoutparams = ((Activity)ctx).getWindow().getAttributes();
                layoutparams.alpha = 1.0F;
                ((Activity)ctx).getWindow().setAttributes(layoutparams);
            }

            
            {
                this$0 = RingtoneDownloadedAdapter.this;
                super();
            }
        });
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

    public Object getItem(int i)
    {
        return list.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(final int position, View view1, final ViewGroup in_fo)
    {
        in_fo = (DownloadMovieItem)list.get(position);
        if (view1 == null)
        {
            holder = new ViewHolder();
            view1 = View.inflate(ctx, 0x7f0300a8, null);
            holder.my_delete_movie = (ImageView)view1.findViewById(0x7f07038e);
            holder.my_test_head_image3 = (ImageView)view1.findViewById(0x7f07038f);
            holder.my_movie_name_item = (TextView)view1.findViewById(0x7f070390);
            holder.my_totalsize = (TextView)view1.findViewById(0x7f070391);
            holder.my_stop_download_bt = (Button)view1.findViewById(0x7f070392);
            view1.setTag(holder);
        } else
        {
            holder = (ViewHolder)view1.getTag();
        }
        try
        {
            holder.my_totalsize.setText(Formatter.formatFileSize(ctx, Long.parseLong(in_fo.getFileSize())));
        }
        catch (Exception exception) { }
        holder.my_movie_name_item.setText(in_fo.getMovieName());
        holder.my_stop_download_bt.setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneDownloadedAdapter this$0;
            private final DownloadMovieItem val$in_fo;

            public void onClick(View view2)
            {
                initPopuWindow1(view2);
                new_file_path = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).append("/").append("ringtone/").append(in_fo.getFile_id()).append(".mp3").toString();
                publicTools.make_path_ready((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).append("/").append("ringtone").toString());
                try
                {
                    publicTools.copyFile(in_fo.getFilePath(), new_file_path);
                }
                // Misplaced declaration of an exception variable
                catch (View view2)
                {
                    view2.printStackTrace();
                }
                sp.edit().putString("movivename", in_fo.getMovieName()).commit();
                l1.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(View view1)
                    {
                        setRingtone(7, new_file_path);
                        mWindow.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                l2.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(View view1)
                    {
                        setRingtone(1, new_file_path);
                        mWindow.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                l3.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(View view1)
                    {
                        setRingtone(2, new_file_path);
                        mWindow.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                l4.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(View view1)
                    {
                        setRingtone(4, new_file_path);
                        mWindow.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                popodismiss.setOnClickListener(new android.view.View.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(View view1)
                    {
                        mWindow.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }


            
            {
                this$0 = RingtoneDownloadedAdapter.this;
                in_fo = downloadmovieitem;
                super();
            }
        });
        holder.my_delete_movie.setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneDownloadedAdapter this$0;
            private final int val$position;

            public void onClick(View view2)
            {
                view2 = new Intent();
                view2.setAction("ringtonedelete");
                view2.putExtra("position", position);
                ctx.sendBroadcast(view2);
            }

            
            {
                this$0 = RingtoneDownloadedAdapter.this;
                position = i;
                super();
            }
        });
        holder.my_test_head_image3.setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneDownloadedAdapter this$0;
            private final DownloadMovieItem val$in_fo;

            public void onClick(View view2)
            {
                view2 = new Intent();
                view2.setAction("ringtoneplay");
                view2.putExtra("ringtoneposition", in_fo.getFilePath());
                view2.putExtra("ringtonepositiontitle", in_fo.getMovieName());
                Log.v("ringtoneposition", in_fo.getFilePath());
                ctx.sendBroadcast(view2);
            }

            
            {
                this$0 = RingtoneDownloadedAdapter.this;
                in_fo = downloadmovieitem;
                super();
            }
        });
        return view1;
    }

    public void onClick(View view1)
    {
    }

    public void setRingtone(int i, String s)
    {
        i;
        JVM INSTR tableswitch 1 7: default 44
    //                   1 236
    //                   2 244
    //                   3 44
    //                   4 252
    //                   5 44
    //                   6 44
    //                   7 260;
           goto _L1 _L2 _L3 _L1 _L4 _L1 _L1 _L5
_L1:
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("_data", s);
        contentvalues.put("title", sp.getString("movivename", "AAA"));
        contentvalues.put("mime_type", "audio/mp3");
        contentvalues.put("is_ringtone", Boolean.valueOf(isRingtone));
        contentvalues.put("is_notification", Boolean.valueOf(isNotification));
        contentvalues.put("is_alarm", Boolean.valueOf(isAlarm));
        contentvalues.put("is_music", Boolean.valueOf(isMusic));
        s = android.provider.MediaStore.Audio.Media.getContentUriForPath(s);
        ctx.getContentResolver().delete(s, (new StringBuilder("_data=\"")).append(new_file_path).append("\"").toString(), null);
        s = ctx.getContentResolver().insert(s, contentvalues);
        RingtoneManager.setActualDefaultRingtoneUri(ctx, i, s);
        Log.v("ringType", (new StringBuilder(String.valueOf(i))).toString());
        return;
_L2:
        isRingtone = true;
        continue; /* Loop/switch isn't completed */
_L3:
        isNotification = true;
        continue; /* Loop/switch isn't completed */
_L4:
        isAlarm = true;
        continue; /* Loop/switch isn't completed */
_L5:
        isMusic = true;
        if (true) goto _L1; else goto _L6
_L6:
    }









}
