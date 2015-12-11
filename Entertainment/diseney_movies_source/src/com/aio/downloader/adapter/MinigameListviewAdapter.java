// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.aio.downloader.activity.MiniGamePlayActivity;
import com.aio.downloader.model.MiniGameModel;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;
import java.util.List;

public class MinigameListviewAdapter extends BaseAdapter
{
    class ViewHolder
    {

        private RatingBar minigame_ratingbar;
        private TextView minigamehints;
        private ImageView minigameicon;
        private Button minigameplaybt;
        private TextView minigametitle;
        final MinigameListviewAdapter this$0;











        ViewHolder()
        {
            this$0 = MinigameListviewAdapter.this;
            super();
        }
    }


    private MyApplcation app;
    private Context ctx;
    private ViewHolder holder;
    private List list;

    public MinigameListviewAdapter(Context context, List list1)
    {
        holder = null;
        ctx = context;
        list = list1;
        try
        {
            app = (MyApplcation)context.getApplicationContext();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    public void addItem(ArrayList arraylist)
    {
        list.addAll(arraylist);
        notifyDataSetChanged();
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

    public View getView(int i, View view, final ViewGroup in_fo)
    {
        in_fo = (MiniGameModel)list.get(i);
        if (view == null)
        {
            holder = new ViewHolder();
            view = View.inflate(ctx, 0x7f030074, null);
            holder.minigameicon = (ImageView)view.findViewById(0x7f0702c9);
            holder.minigametitle = (TextView)view.findViewById(0x7f0702ca);
            holder.minigamehints = (TextView)view.findViewById(0x7f0702cc);
            holder.minigame_ratingbar = (RatingBar)view.findViewById(0x7f0702cb);
            holder.minigameplaybt = (Button)view.findViewById(0x7f0702cd);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        holder.minigametitle.setText(in_fo.getTitle());
        holder.minigamehints.setText((new StringBuilder("More than ")).append(in_fo.getHits()).append(" plays").toString());
        try
        {
            app.asyncLoadImage(in_fo.getIcon(), holder.minigameicon);
        }
        catch (Exception exception) { }
        if (i % 2 == 0)
        {
            holder.minigame_ratingbar.setRating(4F);
        } else
        {
            holder.minigame_ratingbar.setRating(5F);
        }
        holder.minigameplaybt.setOnClickListener(new android.view.View.OnClickListener() {

            final MinigameListviewAdapter this$0;
            private final MiniGameModel val$in_fo;

            public void onClick(View view1)
            {
                (new Thread(in_fo. new Runnable() {

                    final _cls1 this$1;
                    private final MiniGameModel val$in_fo;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=minigame&id=")).append(in_fo.getSerial()).append("&title=").append(in_fo.getTitle()).toString());
                    }

            
            {
                this$1 = final__pcls1;
                in_fo = MiniGameModel.this;
                super();
            }
                })).start();
                view1 = new Intent(ctx, com/aio/downloader/activity/MiniGamePlayActivity);
                view1.putExtra("playurl", in_fo.getPlay_url());
                view1.putExtra("proc", in_fo.getProc());
                view1.putExtra("sound", in_fo.getSound());
                ctx.startActivity(view1);
            }

            
            {
                this$0 = MinigameListviewAdapter.this;
                in_fo = minigamemodel;
                super();
            }
        });
        return view;
    }

}
