// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.widget.UserViewHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            Friendships, FollowButtonViewHolder

public class UsersAdapter extends CursorAdapter
{

    protected final AppController mAppController;
    private boolean mFollow;
    private Friendships mFriendships;
    private android.view.View.OnClickListener mListener;
    long mLoggedInUserId;
    private final int mProfileImageSize;
    protected final ArrayList mViewHolders = new ArrayList();

    public UsersAdapter(Context context, AppController appcontroller, boolean flag, android.view.View.OnClickListener onclicklistener, Friendships friendships, int i)
    {
        super(context, null, i);
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

    public void bindView(View view, Context context, Cursor cursor)
    {
        view = (UserViewHolder)view.getTag();
        ((UserViewHolder) (view)).username.setText(cursor.getString(13));
        view.userId = cursor.getLong(1);
        context = cursor.getString(5);
        if (!TextUtils.isEmpty(context))
        {
            ((UserViewHolder) (view)).bio.setText(context);
            ((UserViewHolder) (view)).bio.setVisibility(0);
        } else
        {
            ((UserViewHolder) (view)).bio.setText("");
            ((UserViewHolder) (view)).bio.setVisibility(8);
        }
        context = cursor.getString(6);
        if (!TextUtils.isEmpty(context))
        {
            ((UserViewHolder) (view)).location.setText(context);
            ((UserViewHolder) (view)).location.setVisibility(0);
        } else
        {
            ((UserViewHolder) (view)).location.setText("");
            ((UserViewHolder) (view)).location.setVisibility(8);
        }
        if (cursor.getInt(14) == 1)
        {
            ((UserViewHolder) (view)).verified.setVisibility(0);
        } else
        {
            ((UserViewHolder) (view)).verified.setVisibility(8);
        }
        context = ((UserViewHolder) (view)).followButton;
        if (mFollow && ((UserViewHolder) (view)).userId != mAppController.getActiveId())
        {
            context.setVisibility(0);
            Friendships friendships = mFriendships;
            long l = cursor.getLong(1);
            boolean flag;
            if (friendships != null)
            {
                if (friendships.contains(l))
                {
                    flag = friendships.isFollowing(l);
                } else
                if ((cursor.getInt(10) & 1) > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if ((cursor.getInt(10) & 1) > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            context.setTag(new FollowButtonViewHolder(l, flag));
            if (flag)
            {
                context.setBackgroundResource(0x7f020095);
            } else
            {
                context.setBackgroundResource(0x7f020094);
            }
        } else
        {
            context.setVisibility(8);
        }
        context = cursor.getString(2);
        if (!TextUtils.isEmpty(context))
        {
            cursor = new ImageKey(context, mProfileImageSize, mProfileImageSize, true);
            if (Util.isDefaultAvatarUrl(context))
            {
                Util.safeSetDefaultAvatar(((UserViewHolder) (view)).image, co.vine.android.util.Util.ProfileImageSize.MEDIUM, 0xff000000 | mContext.getResources().getColor(0x7f090096));
                return;
            } else
            {
                view.avatarUrl = cursor;
                setUserImage(view, mAppController.getPhotoBitmap(cursor));
                return;
            }
        } else
        {
            setUserImage(view, null);
            return;
        }
    }

    public long getItemId(int i)
    {
        long l1 = 0L;
        Cursor cursor = (Cursor)super.getItem(i);
        long l = l1;
        if (cursor != null)
        {
            l = l1;
            if (cursor.moveToPosition(i))
            {
                l = cursor.getLong(1);
            }
        }
        return l;
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context).inflate(0x7f0300a4, viewgroup, false);
        cursor = new UserViewHolder(context);
        if (mFollow)
        {
            ((UserViewHolder) (cursor)).followButton.setOnClickListener(mListener);
        } else
        {
            ((UserViewHolder) (cursor)).followButton.setVisibility(8);
        }
        mViewHolders.add(new WeakReference(cursor));
        context.setTag(cursor);
        return context;
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
