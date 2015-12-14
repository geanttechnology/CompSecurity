// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.badge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Badge;
import my.googlemusic.play.model.User;

public class BadgeAdapter extends BaseAdapter
{
    public static interface OnBadgeListener
    {

        public abstract void onBadgeClick(Badge badge);
    }


    static final boolean $assertionsDisabled;
    private List mBadgeList;
    private OnBadgeListener mBadgeListener;
    private Context mContext;
    private LayoutInflater mInflater;
    private Server mServer;

    public BadgeAdapter(Context context, List list, Server server, OnBadgeListener onbadgelistener)
    {
        mServer = server;
        mBadgeList = list;
        mBadgeListener = onbadgelistener;
        mInflater = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public int getCount()
    {
        return mBadgeList.size();
    }

    public Object getItem(int i)
    {
        return mBadgeList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class BadgeListener {}

    /* block-local class not found */
    class ViewHolder {}

        Badge badge;
        BadgeListener badgelistener;
        View view1;
        if (view == null)
        {
            ViewHolder viewholder = new ViewHolder(null);
            view = mInflater.inflate(0x7f03007d, viewgroup, false);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            viewholder.item = view.findViewById(0x7f0d0298);
            viewholder.available = view.findViewById(0x7f0d029b);
            viewholder.check = (ImageView)view.findViewById(0x7f0d029a);
            viewholder.image = (ImageView)view.findViewById(0x7f0d0299);
            view.setTag(viewholder);
            viewgroup = viewholder;
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        badge = (Badge)mBadgeList.get(i);
        badgelistener = new BadgeListener(badge);
        view1 = ((ViewHolder) (viewgroup)).item;
        if (badge.isAvailable())
        {
            i = 0x7f020040;
        } else
        {
            i = 0x7f020041;
        }
        view1.setBackgroundResource(i);
        Picasso.with(mContext).load(mServer.getLinkBadge(mServer.getUser().getId(), badge.getId())).fit().centerCrop().into(((ViewHolder) (viewgroup)).image);
        ((ViewHolder) (viewgroup)).item.setOnClickListener(badgelistener);
        if (badge.isAvailable())
        {
            ((ViewHolder) (viewgroup)).available.setVisibility(4);
        } else
        {
            ((ViewHolder) (viewgroup)).available.setVisibility(0);
        }
        viewgroup = ((ViewHolder) (viewgroup)).check;
        if (badge.getIdUsed() == badge.getId())
        {
            i = 0;
        } else
        {
            i = 4;
        }
        viewgroup.setVisibility(i);
        return view;
    }

    public void setGrid(List list)
    {
        mBadgeList = list;
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/adapters/badge/BadgeAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }

}
