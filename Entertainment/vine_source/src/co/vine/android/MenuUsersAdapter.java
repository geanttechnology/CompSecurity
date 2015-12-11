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
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.api.VineRecipient;
import co.vine.android.client.AppController;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            MessageBoxAdapter

public class MenuUsersAdapter extends CursorAdapter
{
    public static class FriendsViewHolder
    {

        public ImageKey avatarKey;
        public View divider;
        public TextView friendName;
        public ImageView image;
        public int position;
        public VineRecipient recipient;
        public View sectionIndicator;
        public TextView sectionSort;
        public TextView sectionTitle;

        public FriendsViewHolder(Context context, View view)
        {
            friendName = (TextView)view.findViewById(0x7f0a0125);
            image = (ImageView)view.findViewById(0x7f0a0063);
            sectionIndicator = view.findViewById(0x7f0a0120);
            sectionTitle = (TextView)view.findViewById(0x7f0a01ab);
            sectionSort = (TextView)view.findViewById(0x7f0a01aa);
            divider = view.findViewById(0x7f0a0060);
            Util.styleSectionHeader(context, sectionTitle, sectionSort);
        }
    }


    protected final AppController mAppController;
    private final HashMap mAvatars = new HashMap();
    private MessageBoxAdapter mInboxAdapter;
    private long mLatestRefreshTime;
    private final int mProfileImageSize;
    protected final ArrayList mViewHolders = new ArrayList();
    private WeakReference mZeroHolder;

    public MenuUsersAdapter(Context context, AppController appcontroller, int i)
    {
        super(context, null, i);
        mAppController = appcontroller;
        mProfileImageSize = context.getResources().getDimensionPixelOffset(0x7f0b0087);
    }

    private void invalidateDividerVisibility(FriendsViewHolder friendsviewholder, Cursor cursor)
    {
        byte byte0 = 0;
        if (cursor.moveToNext())
        {
            VineRecipient vinerecipient = friendsviewholder.recipient;
            VineRecipient vinerecipient1 = co.vine.android.provider.VineDatabaseSQL.UsersQuery.getVineRecipient(cursor);
            int i = vinerecipient.sectionIndex;
            boolean flag;
            if (vinerecipient1.sectionIndex != i || vinerecipient1.sectionIndex != 0 && !vinerecipient1.getTextSortKey().equals(vinerecipient.getTextSortKey()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            friendsviewholder = friendsviewholder.divider;
            if (flag)
            {
                byte0 = 8;
            }
            friendsviewholder.setVisibility(byte0);
            cursor.moveToPrevious();
            return;
        } else
        {
            friendsviewholder.divider.setVisibility(8);
            return;
        }
    }

    private void setUserImage(FriendsViewHolder friendsviewholder, Bitmap bitmap)
    {
        friendsviewholder.image.setColorFilter(null);
        if (bitmap != null)
        {
            friendsviewholder.image.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
            return;
        } else
        {
            friendsviewholder.image.setImageResource(0x7f0200f7);
            return;
        }
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        FriendsViewHolder friendsviewholder = (FriendsViewHolder)view.getTag();
        friendsviewholder.recipient = co.vine.android.provider.VineDatabaseSQL.UsersQuery.getVineRecipient(cursor);
        friendsviewholder.friendName.setText(friendsviewholder.recipient.display);
        if (!TextUtils.isEmpty(friendsviewholder.recipient.avatarUrl))
        {
            ImageKey imagekey = new ImageKey(friendsviewholder.recipient.avatarUrl, mProfileImageSize, mProfileImageSize, true);
            int i;
            if (Util.isDefaultAvatarUrl(friendsviewholder.recipient.avatarUrl))
            {
                Util.safeSetDefaultAvatar(friendsviewholder.image, co.vine.android.util.Util.ProfileImageSize.MEDIUM, 0xff000000 | friendsviewholder.recipient.color);
            } else
            {
                friendsviewholder.avatarKey = imagekey;
                context = (WeakReference)mAvatars.get(imagekey);
                view = null;
                if (context != null)
                {
                    view = (Bitmap)context.get();
                }
                context = view;
                if (view == null)
                {
                    view = mAppController.getPhotoBitmap(imagekey);
                    context = view;
                    if (view != null)
                    {
                        mAvatars.put(imagekey, new WeakReference(view));
                        context = view;
                    }
                }
                setUserImage(friendsviewholder, context);
            }
        } else
        {
            setUserImage(friendsviewholder, null);
        }
        i = cursor.getPosition();
        friendsviewholder.position = i;
        if (i == 0)
        {
            mZeroHolder = new WeakReference(friendsviewholder);
            mLatestRefreshTime = friendsviewholder.recipient.lastFriendRefresh;
            friendsviewholder.sectionIndicator.setVisibility(0);
            friendsviewholder.sectionTitle.setVisibility(0);
            friendsviewholder.sectionTitle.setText(friendsviewholder.recipient.sectionTitle);
            friendsviewholder.sectionSort.setVisibility(0);
            friendsviewholder.sectionSort.setText(friendsviewholder.recipient.getTextSortKey());
        } else
        {
            cursor.moveToPrevious();
            view = co.vine.android.provider.VineDatabaseSQL.UsersQuery.getVineRecipient(cursor);
            cursor.moveToNext();
            int k = ((VineRecipient) (view)).sectionIndex;
            int j = 0;
            boolean flag;
            if (friendsviewholder.recipient.sectionIndex != k)
            {
                j = 1;
                friendsviewholder.sectionTitle.setText(friendsviewholder.recipient.sectionTitle);
                friendsviewholder.sectionTitle.setVisibility(0);
            } else
            {
                friendsviewholder.sectionTitle.setVisibility(8);
            }
            flag = j;
            if (friendsviewholder.recipient.sectionIndex != 0)
            {
                flag = j;
                if (!friendsviewholder.recipient.getTextSortKey().equals(view.getTextSortKey()))
                {
                    flag = true;
                    friendsviewholder.sectionSort.setVisibility(0);
                    friendsviewholder.sectionSort.setText(friendsviewholder.recipient.getTextSortKey());
                }
            }
            view = friendsviewholder.sectionIndicator;
            if (flag)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            view.setVisibility(j);
        }
        invalidateDividerVisibility(friendsviewholder, cursor);
    }

    public long getItemId(int i)
    {
        Cursor cursor = (Cursor)super.getItem(i);
        if (cursor != null)
        {
            return cursor.getLong(1);
        } else
        {
            return 0L;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null && !(view.getTag() instanceof FriendsViewHolder))
        {
            return super.getView(i, null, viewgroup);
        } else
        {
            return super.getView(i, view, viewgroup);
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        cursor = LayoutInflater.from(context).inflate(0x7f030057, viewgroup, false);
        context = new FriendsViewHolder(context, cursor);
        mViewHolders.add(new WeakReference(context));
        cursor.setTag(context);
        return cursor;
    }

    public void setInboxAdapter(MessageBoxAdapter messageboxadapter)
    {
        mInboxAdapter = messageboxadapter;
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
        FriendsViewHolder friendsviewholder;
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_134;
        }
        obj1 = (WeakReference)iterator.next();
        friendsviewholder = (FriendsViewHolder)((WeakReference) (obj1)).get();
        if (friendsviewholder != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ((ArrayList) (obj)).add(obj1);
          goto _L1
        hashmap;
        throw hashmap;
        obj1 = (UrlImage)hashmap.get(friendsviewholder.avatarKey);
        if (obj1 == null) goto _L1; else goto _L2
_L2:
        if (!((UrlImage) (obj1)).isValid()) goto _L1; else goto _L3
_L3:
        mAvatars.put(friendsviewholder.avatarKey, new WeakReference(((UrlImage) (obj1)).bitmap));
        setUserImage(friendsviewholder, ((UrlImage) (obj1)).bitmap);
          goto _L1
        for (hashmap = ((ArrayList) (obj)).iterator(); hashmap.hasNext(); mViewHolders.remove(obj))
        {
            obj = (WeakReference)hashmap.next();
        }

        this;
        JVM INSTR monitorexit ;
    }
}
