// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.PrintStream;
import java.util.List;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;

public class SearchUserAdapter extends BaseAdapter
{
    public static interface OnItemSearchUserClickListener
    {

        public abstract void onAddSearchUserClick(User user);

        public abstract void onItemSearchUserClick(User user);
    }


    static final boolean $assertionsDisabled;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private OnItemSearchUserClickListener mListener;
    private Server mServer;
    private User mUser;
    private List mUserList;

    public SearchUserAdapter(Context context, List list, User user, OnItemSearchUserClickListener onitemsearchuserclicklistener, Server server)
    {
        if (context == null)
        {
            System.out.println("Loucura total contexto nulo");
            return;
        } else
        {
            mUser = user;
            mServer = server;
            mUserList = list;
            mContext = context;
            mListener = onitemsearchuserclicklistener;
            mLayoutInflater = (LayoutInflater)context.getSystemService("layout_inflater");
            return;
        }
    }

    public void addSearchList(List list)
    {
        if (list != null)
        {
            mUserList.addAll(list);
        }
    }

    public int getCount()
    {
        if (mUserList == null)
        {
            return 0;
        } else
        {
            return mUserList.size();
        }
    }

    public Object getItem(int i)
    {
        return mUserList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
    /* block-local class not found */
    class ItemSearchUserClickListener {}

    /* block-local class not found */
    class ViewHolder {}

        User user;
        if (view == null)
        {
            view = mLayoutInflater.inflate(0x7f03008a, viewgroup, false);
            viewgroup = new ViewHolder(null);
            if (!$assertionsDisabled && view == null)
            {
                throw new AssertionError();
            }
            viewgroup.add = (ImageButton)view.findViewById(0x7f0d02e9);
            viewgroup.image = (ImageView)view.findViewById(0x7f0d02ea);
            viewgroup.loading = (ProgressBar)view.findViewById(0x7f0d02eb);
            viewgroup.username = (TextView)view.findViewById(0x7f0d02ec);
            viewgroup.container = (Button)view.findViewById(0x7f0d02e8);
            viewgroup.loading = (ProgressBar)view.findViewById(0x7f0d02eb);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        user = (User)mUserList.get(i);
        if (mUser.getId() == user.getId() || mUser.isSkip())
        {
            ((ViewHolder) (viewgroup)).add.setVisibility(8);
        } else
        {
            ImageButton imagebutton = ((ViewHolder) (viewgroup)).add;
    /* block-local class not found */
    class FriendRequestListener {}

            if (user.isFollowing())
            {
                i = 0x7f020079;
            } else
            {
                i = 0x7f02005a;
            }
            imagebutton.setImageResource(i);
            ((ViewHolder) (viewgroup)).add.setOnClickListener(new FriendRequestListener(((ViewHolder) (viewgroup)).add, ((ViewHolder) (viewgroup)).loading, user));
            ((ViewHolder) (viewgroup)).add.setVisibility(0);
        }
        ((ViewHolder) (viewgroup)).container.setOnClickListener(new ItemSearchUserClickListener(user));
        ((ViewHolder) (viewgroup)).username.setText(user.getUsername());
        Picasso.with(mContext).load(mServer.getLinkUserImage(user.getId())).placeholder(0x7f0201db).fit().centerCrop().transform(new CropSquareTransformation()).skipMemoryCache().into(((ViewHolder) (viewgroup)).image);
        return view;
    }

    public void setFollowing(User user)
    {
        int i = 0;
        while (i < mUserList.size()) 
        {
            if (mUserList.get(i) == user)
            {
                User user1 = (User)mUserList.get(i);
                boolean flag;
                if (!user1.isFollowing())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                user1.setFollowing(flag);
            }
            i++;
        }
    }

    public void setSearchList(List list)
    {
        mUserList = list;
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/adapters/search/SearchUserAdapter.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }



}
