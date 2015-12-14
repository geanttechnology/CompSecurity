// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.upcoming;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.model.Album;
import my.googlemusic.play.model.Artist;

public class UpcomingAdapter extends BaseAdapter
{

    static final boolean $assertionsDisabled;
    private static final int DRAWABLE_NUMBERS[] = {
        0x7f020201, 0x7f020202, 0x7f020203, 0x7f020204, 0x7f020205, 0x7f020206, 0x7f020207, 0x7f020208, 0x7f020209, 0x7f02020a
    };
    private Context mContext;
    private Handler mHandler;
    private LayoutInflater mLayoutInflater;
    private List mUpcomingList;

    public UpcomingAdapter(Context context, List list)
    {
        mContext = context;
        mHandler = new Handler();
        mUpcomingList = list;
        mLayoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    private ViewHolder createViewHolder(View view, ViewHolder viewholder)
    {
    /* block-local class not found */
    class ViewHolder {}

        viewholder.days1 = (ImageView)view.findViewById(0x7f0d02f6);
        viewholder.days2 = (ImageView)view.findViewById(0x7f0d02f7);
        viewholder.hours1 = (ImageView)view.findViewById(0x7f0d02f9);
        viewholder.hours2 = (ImageView)view.findViewById(0x7f0d02fa);
        viewholder.minutes1 = (ImageView)view.findViewById(0x7f0d02fc);
        viewholder.minutes2 = (ImageView)view.findViewById(0x7f0d02fd);
        viewholder.seconds1 = (ImageView)view.findViewById(0x7f0d02ff);
        viewholder.seconds2 = (ImageView)view.findViewById(0x7f0d0300);
        return viewholder;
    }

    public int getCount()
    {
        return mUpcomingList.size();
    }

    public Object getItem(int i)
    {
        return mUpcomingList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ViewHolder viewholder = new ViewHolder();
        Album album = (Album)mUpcomingList.get(i);
    /* block-local class not found */
    class TimerRunnable {}

        if (view == null)
        {
            view = mLayoutInflater.inflate(0x7f03008d, viewgroup, false);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            viewgroup = createViewHolder(view, viewholder);
            viewgroup.soon = view.findViewById(0x7f0d02f3);
            viewgroup.time = view.findViewById(0x7f0d02f4);
            viewgroup.name = (TextView)view.findViewById(0x7f0d02f2);
            viewgroup.thumb = (ImageView)view.findViewById(0x7f0d02f0);
            viewgroup.artist = (TextView)view.findViewById(0x7f0d02f1);
            viewgroup.timer = new TimerRunnable(viewgroup);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).name.setText(album.getName());
        ((ViewHolder) (viewgroup)).artist.setText(album.getArtist().getName());
        Picasso.with(mContext).load(album.getImage()).placeholder(0x7f0201dc).fit().centerCrop().skipMemoryCache().into(((ViewHolder) (viewgroup)).thumb);
        if (album.getReleaseDate() != null)
        {
            ((ViewHolder) (viewgroup)).timer.setTime(album.getReleaseDate());
        }
        if (TimerRunnable.access._mth000(((ViewHolder) (viewgroup)).timer))
        {
            ((ViewHolder) (viewgroup)).time.setVisibility(8);
            ((ViewHolder) (viewgroup)).soon.setVisibility(0);
            return view;
        } else
        {
            ((ViewHolder) (viewgroup)).time.setVisibility(0);
            ((ViewHolder) (viewgroup)).soon.setVisibility(8);
            return view;
        }
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/adapters/upcoming/UpcomingAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }


}
