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
import my.googlemusic.play.model.Follower;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;

public class FollowerAdapter extends BaseAdapter
{
    public static interface OnFollowListener
    {

        public abstract void onAddFriend(long l);

        public abstract void onRemoveFriend(long l);

        public abstract void onUserProfile(long l);
    }


    static final boolean $assertionsDisabled;
    private Context mContext;
    private ViewHolder mHolder;
    private long mIdUser;
    private LayoutInflater mInflater;
    private List mList;
    private OnFollowListener mListener;
    private Server mServer;

    public FollowerAdapter(Context context, List list, long l, OnFollowListener onfollowlistener, Server server)
    {
        if (context == null)
        {
            return;
        } else
        {
            mList = list;
            mIdUser = l;
            mContext = context;
            mListener = onfollowlistener;
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
    class FollowListener {}

    /* block-local class not found */
    class ViewHolder {}

        Object obj;
        if (view == null)
        {
            mHolder = new ViewHolder(null);
            view = mInflater.inflate(0x7f030084, viewgroup, false);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            mHolder.follower = (Button)view.findViewById(0x7f0d02c4);
            mHolder.name = (TextView)view.findViewById(0x7f0d02c8);
            mHolder.username = (TextView)view.findViewById(0x7f0d02c9);
            mHolder.image = (ImageView)view.findViewById(0x7f0d02c5);
            mHolder.loading = (ProgressBar)view.findViewById(0x7f0d02c6);
            mHolder.addFriend = (ImageView)view.findViewById(0x7f0d02c7);
            view.setTag(mHolder);
        } else
        {
            mHolder = (ViewHolder)view.getTag();
        }
        viewgroup = (Follower)mList.get(i);
        obj = new FollowListener(viewgroup.getUser());
        mHolder.name.setText(viewgroup.getUser().getName());
        mHolder.username.setText(viewgroup.getUser().getUsername());
        mHolder.image.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        mHolder.username.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        mHolder.follower.setOnClickListener(((android.view.View.OnClickListener) (obj)));
        Picasso.with(mContext).load(mServer.getLinkUserImage(viewgroup.getUser().getId())).placeholder(0x7f0201db).transform(new CropSquareTransformation()).into(mHolder.image);
        if (mIdUser == viewgroup.getUser().getId())
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
            if (((Follower)mList.get(i)).getUser().getId() == l)
            {
                User user = ((Follower)mList.get(i)).getUser();
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
        if (!my/googlemusic/play/adapters/profile/FollowerAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }



}
