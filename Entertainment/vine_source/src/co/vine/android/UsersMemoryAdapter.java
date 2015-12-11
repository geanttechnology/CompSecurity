// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.widget.UserViewHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            Friendships, FollowButtonViewHolder

public class UsersMemoryAdapter extends BaseAdapter
{

    protected final AppController mAppController;
    private final Context mContext;
    private boolean mFollow;
    private Friendships mFriendships;
    private android.view.View.OnClickListener mListener;
    long mLoggedInUserId;
    private final int mProfileImageSize;
    private HashSet mSeenIds;
    private ArrayList mUsers;
    protected final ArrayList mViewHolders = new ArrayList();

    public UsersMemoryAdapter(Context context, AppController appcontroller, boolean flag, android.view.View.OnClickListener onclicklistener, Friendships friendships)
    {
        mContext = context;
        mAppController = appcontroller;
        mLoggedInUserId = appcontroller.getActiveId();
        mFollow = flag;
        mListener = onclicklistener;
        mFriendships = friendships;
        mProfileImageSize = context.getResources().getDimensionPixelOffset(0x7f0b0087);
    }

    private void setUserImage(UserViewHolder userviewholder, Bitmap bitmap)
    {
        userviewholder.image.setColorFilter(null);
        if (bitmap != null)
        {
            userviewholder.image.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
            return;
        } else
        {
            userviewholder.image.setImageResource(0x7f0200f7);
            return;
        }
    }

    public void bindView(View view, int i)
    {
        Object obj = (VineUser)mUsers.get(i);
        view = (UserViewHolder)view.getTag();
        ((UserViewHolder) (view)).username.setText(((VineUser) (obj)).username);
        view.userId = ((VineUser) (obj)).userId;
        Object obj1 = ((VineUser) (obj)).description;
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            ((UserViewHolder) (view)).bio.setText(((CharSequence) (obj1)));
            ((UserViewHolder) (view)).bio.setVisibility(0);
        } else
        {
            ((UserViewHolder) (view)).bio.setText("");
            ((UserViewHolder) (view)).bio.setVisibility(8);
        }
        obj1 = ((VineUser) (obj)).location;
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            ((UserViewHolder) (view)).location.setText(((CharSequence) (obj1)));
            ((UserViewHolder) (view)).location.setVisibility(0);
        } else
        {
            ((UserViewHolder) (view)).location.setText("");
            ((UserViewHolder) (view)).location.setVisibility(8);
        }
        if (((VineUser) (obj)).verified == 1)
        {
            ((UserViewHolder) (view)).verified.setVisibility(0);
        } else
        {
            ((UserViewHolder) (view)).verified.setVisibility(8);
        }
        obj1 = ((UserViewHolder) (view)).followButton;
        if (mFollow && ((UserViewHolder) (view)).userId != mAppController.getActiveId())
        {
            ((ImageButton) (obj1)).setVisibility(0);
            Friendships friendships = mFriendships;
            long l = ((VineUser) (obj)).userId;
            boolean flag;
            if (friendships != null)
            {
                if (friendships.contains(l))
                {
                    flag = friendships.isFollowing(l);
                } else
                {
                    flag = ((VineUser) (obj)).isFollowing();
                }
            } else
            {
                flag = ((VineUser) (obj)).isFollowing();
            }
            ((ImageButton) (obj1)).setTag(new FollowButtonViewHolder(l, flag));
            if (flag)
            {
                ((ImageButton) (obj1)).setBackgroundResource(0x7f020095);
            } else
            {
                ((ImageButton) (obj1)).setBackgroundResource(0x7f020094);
            }
        } else
        {
            ((ImageButton) (obj1)).setVisibility(8);
        }
        obj = ((VineUser) (obj)).avatarUrl;
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj1 = new ImageKey(((String) (obj)), mProfileImageSize, mProfileImageSize, true);
            if (Util.isDefaultAvatarUrl(((String) (obj))))
            {
                Util.safeSetDefaultAvatar(((UserViewHolder) (view)).image, co.vine.android.util.Util.ProfileImageSize.MEDIUM, 0xff000000 | mContext.getResources().getColor(0x7f090096));
                return;
            } else
            {
                view.avatarUrl = ((ImageKey) (obj1));
                setUserImage(view, mAppController.getPhotoBitmap(((ImageKey) (obj1))));
                return;
            }
        } else
        {
            setUserImage(view, null);
            return;
        }
    }

    public int getCount()
    {
        if (mUsers != null)
        {
            return mUsers.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        if (mUsers != null)
        {
            return mUsers.get(i);
        } else
        {
            return null;
        }
    }

    public long getItemId(int i)
    {
        if (mUsers != null && i < mUsers.size())
        {
            VineUser vineuser = (VineUser)mUsers.get(i);
            if (vineuser != null)
            {
                return vineuser.userId;
            }
        }
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = newView(viewgroup);
        }
        bindView(view, i);
        return view;
    }

    public void mergeData(ArrayList arraylist, boolean flag)
    {
        if (!flag)
        {
            mSeenIds = new HashSet();
            mUsers = new ArrayList();
        }
        if (arraylist != null)
        {
            Iterator iterator = arraylist.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                VineUser vineuser = (VineUser)iterator.next();
                if (!mSeenIds.contains(Long.valueOf(vineuser.userId)))
                {
                    mSeenIds.add(Long.valueOf(vineuser.userId));
                    mUsers.add(vineuser);
                }
            } while (true);
        }
        if (arraylist != null)
        {
            notifyDataSetChanged();
        }
    }

    public View newView(ViewGroup viewgroup)
    {
        viewgroup = LayoutInflater.from(mContext).inflate(0x7f0300a4, viewgroup, false);
        UserViewHolder userviewholder = new UserViewHolder(viewgroup);
        if (mFollow)
        {
            userviewholder.followButton.setOnClickListener(mListener);
        } else
        {
            userviewholder.followButton.setVisibility(8);
        }
        mViewHolders.add(new WeakReference(userviewholder));
        viewgroup.setTag(userviewholder);
        return viewgroup;
    }

    public void setUserImages(HashMap hashmap)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        obj = new ArrayList();
        iterator = mViewHolders.iterator();
_L1:
        UserViewHolder userviewholder;
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj1 = (WeakReference)iterator.next();
        userviewholder = (UserViewHolder)((WeakReference) (obj1)).get();
        if (userviewholder != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ((ArrayList) (obj)).add(obj1);
          goto _L1
        hashmap;
        throw hashmap;
        obj1 = (UrlImage)hashmap.get(userviewholder.avatarUrl);
        if (obj1 == null) goto _L1; else goto _L2
_L2:
        if (!((UrlImage) (obj1)).isValid()) goto _L1; else goto _L3
_L3:
        setUserImage(userviewholder, ((UrlImage) (obj1)).bitmap);
          goto _L1
        for (hashmap = ((ArrayList) (obj)).iterator(); hashmap.hasNext(); mViewHolders.remove(obj))
        {
            obj = (WeakReference)hashmap.next();
        }

        this;
        JVM INSTR monitorexit ;
    }
}
