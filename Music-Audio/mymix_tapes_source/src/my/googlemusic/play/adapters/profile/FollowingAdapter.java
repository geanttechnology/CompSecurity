// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.Following;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;

public class FollowingAdapter extends BaseAdapter
{
    public static interface OnFollowingListener
    {

        public abstract void onAddFriend(long l);

        public abstract void onRemoveFriend(long l);

        public abstract void onUserProfile(long l);
    }


    static final boolean $assertionsDisabled;
    private Context mContext;
    private ViewHolder mHolder;
    private Long mIdUser;
    private LayoutInflater mInflater;
    private List mList;
    private OnFollowingListener mListener;
    private Server mServer;

    public FollowingAdapter(Context context, List list, Long long1, OnFollowingListener onfollowinglistener, Server server)
    {
        if (context == null)
        {
            return;
        } else
        {
            mList = list;
            mIdUser = long1;
            mContext = context;
            mListener = onfollowinglistener;
            mServer = server;
            mInflater = LayoutInflater.from(context);
            return;
        }
    }

    public void addList(List list)
    {
        mList.addAll(list);
    }

    public int getCount()
    {
        return mList.size();
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class FollowingListener {}

    /* block-local class not found */
    class ViewHolder {}

        Object obj;
        if (view == null)
        {
            mHolder = new ViewHolder(null);
            view = mInflater.inflate(0x7f030085, viewgroup, false);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            mHolder.profile = (Button)view.findViewById(0x7f0d02ca);
            mHolder.name = (TextView)view.findViewById(0x7f0d02cc);
            mHolder.username = (TextView)view.findViewById(0x7f0d02cd);
            mHolder.photo = (ImageView)view.findViewById(0x7f0d02cb);
            mHolder.loading = (ProgressBar)view.findViewById(0x7f0d02ce);
            mHolder.addFriend = (ImageView)view.findViewById(0x7f0d02cf);
            view.setTag(mHolder);
        } else
        {
            mHolder = (ViewHolder)view.getTag();
        }
        viewgroup = (Following)mList.get(i);
        obj = new FollowingListener(viewgroup.getUser());
        mHolder.name.setText(viewgroup.getUser().getName());
        mHolder.username.setText(viewgroup.getUser().getUsername());
        mHolder.profile.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        Picasso.with(mContext).load(mServer.getLinkUserImage(viewgroup.getUser().getId())).placeholder(0x7f0201db).transform(new CropSquareTransformation()).into(mHolder.photo);
        if (mIdUser.longValue() == viewgroup.getUser().getId())
        {
            mHolder.addFriend.setVisibility(8);
            return view;
        }
        obj = mHolder.addFriend;
        if (viewgroup.getUser().isFollowing())
        {
            i = 0x7f020079;
        } else
        {
            i = 0x7f02005a;
        }
        ((ImageView) (obj)).setImageResource(i);
        if (viewgroup.isLoading())
        {
            mHolder.loading.setVisibility(0);
            mHolder.addFriend.setVisibility(8);
            return view;
        } else
        {
            mHolder.loading.setVisibility(8);
    /* block-local class not found */
    class FriendRequestListener {}

            mHolder.addFriend.setOnClickListener(new FriendRequestListener(mHolder.addFriend, mHolder.loading, viewgroup));
            mHolder.addFriend.setVisibility(0);
            return view;
        }
    }

    public void setFollowing(long l)
    {
        int i = 0;
        while (i < mList.size()) 
        {
            if (((Following)mList.get(i)).getUser().getId() == l)
            {
                User user = ((Following)mList.get(i)).getUser();
                boolean flag;
                if (!user.isFollowing())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                user.setFollowing(flag);
            }
            i++;
        }
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/adapters/profile/FollowingAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }



}
