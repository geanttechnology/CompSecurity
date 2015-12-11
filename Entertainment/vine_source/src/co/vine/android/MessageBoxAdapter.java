// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
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
//            Settings, InboxFragment

public class MessageBoxAdapter extends CursorAdapter
{
    private class ConversationViewHolder
    {

        public ImageKey avatarUrl;
        public int color;
        public View divider;
        public ImageView failedUpload;
        public ImageView image;
        public FrameLayout loadMore;
        public View loadMoreContent;
        public View loadMoreProgress;
        public View retryProgress;
        public TextView tapToRetry;
        final MessageBoxAdapter this$0;
        public TextView timestamp;
        public TextView unreadCount;
        public TextView username;

        public ConversationViewHolder(View view)
        {
            this$0 = MessageBoxAdapter.this;
            super();
            failedUpload = (ImageView)view.findViewById(0x7f0a010a);
            image = (ImageView)view.findViewById(0x7f0a0105);
            timestamp = (TextView)view.findViewById(0x7f0a007b);
            username = (TextView)view.findViewById(0x7f0a0107);
            unreadCount = (TextView)view.findViewById(0x7f0a0109);
            loadMore = (FrameLayout)view.findViewById(0x7f0a010c);
            divider = view.findViewById(0x7f0a0060);
            tapToRetry = (TextView)view.findViewById(0x7f0a0108);
            retryProgress = view.findViewById(0x7f0a010b);
            loadMoreContent = view.findViewById(0x7f0a010d);
            loadMoreProgress = view.findViewById(0x7f0a00b2);
        }
    }


    private AppController mAppController;
    private final HashMap mAvatars = new HashMap();
    private Context mContext;
    private final ColorDrawable mDefaultBg;
    private InboxFragment mFragment;
    private ArrayList mIdsToNotifyFail;
    private ArrayList mViewHolders;

    public MessageBoxAdapter(Context context, AppController appcontroller, InboxFragment inboxfragment, int i)
    {
        super(context, null, i);
        mAppController = appcontroller;
        mContext = context;
        mViewHolders = new ArrayList();
        mFragment = inboxfragment;
        mDefaultBg = new ColorDrawable(mContext.getResources().getColor(0x7f090039));
    }

    private void setUserImage(ConversationViewHolder conversationviewholder, Bitmap bitmap, boolean flag)
    {
        conversationviewholder.image.setColorFilter(null);
        if (bitmap != null)
        {
            conversationviewholder.image.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
            return;
        }
        if (flag)
        {
            conversationviewholder.image.setImageBitmap(null);
            conversationviewholder.image.setBackgroundColor(mContext.getResources().getColor(0x106000d));
            return;
        } else
        {
            conversationviewholder.image.setImageDrawable(null);
            Util.safeSetDefaultAvatar(conversationviewholder.image, co.vine.android.util.Util.ProfileImageSize.MEDIUM, 0xff000000 | conversationviewholder.color);
            return;
        }
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        ConversationViewHolder conversationviewholder;
        int l;
        conversationviewholder = (ConversationViewHolder)view.getTag();
        l = cursor.getInt(14);
        view = cursor.getString(8);
        if (l != 1) goto _L2; else goto _L1
_L1:
        conversationviewholder.username.setText(view);
        conversationviewholder.image.setVisibility(0);
_L4:
        int i;
label0:
        {
            conversationviewholder.loadMoreContent.setVisibility(0);
            conversationviewholder.loadMoreProgress.findViewById(0x7f0a00b2).setVisibility(8);
            conversationviewholder.loadMore.setVisibility(8);
            conversationviewholder.retryProgress.setVisibility(8);
            view = Util.getRelativeTimeString(context, cursor.getLong(2), true);
            conversationviewholder.timestamp.setText(view);
            int j = cursor.getInt(13);
            if (j != Settings.DEFAULT_PROFILE_COLOR)
            {
                i = j;
                if (j > 0)
                {
                    break label0;
                }
            }
            i = 0xffffff & mContext.getResources().getColor(0x7f090096);
        }
        conversationviewholder.color = i;
        int k = cursor.getInt(4);
        if (k > 0)
        {
            conversationviewholder.unreadCount.setVisibility(0);
            conversationviewholder.unreadCount.setText(String.valueOf(k));
            conversationviewholder.unreadCount.getBackground().setColorFilter(new PorterDuffColorFilter(0xff000000 | i, android.graphics.PorterDuff.Mode.SRC_IN));
        } else
        {
            conversationviewholder.unreadCount.setVisibility(8);
        }
        view = cursor.getString(15);
        if (l == 1 || TextUtils.isEmpty(view))
        {
            conversationviewholder.username.setTextColor(0xff000000 | i);
            conversationviewholder.failedUpload.setVisibility(8);
            conversationviewholder.timestamp.setVisibility(0);
            conversationviewholder.tapToRetry.setVisibility(8);
        } else
        {
            conversationviewholder.username.setTextColor(mContext.getResources().getColor(0x7f09003f));
            conversationviewholder.unreadCount.setVisibility(8);
            conversationviewholder.failedUpload.setVisibility(0);
            conversationviewholder.timestamp.setVisibility(8);
            conversationviewholder.tapToRetry.setText(0x7f0e013b);
            conversationviewholder.tapToRetry.setVisibility(0);
        }
        view = cursor.getString(12);
        if (!TextUtils.isEmpty(view))
        {
            ImageKey imagekey = new ImageKey(view, true);
            if (Util.isDefaultAvatarUrl(view))
            {
                setUserImage(conversationviewholder, null, false);
            } else
            {
                conversationviewholder.avatarUrl = imagekey;
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
                setUserImage(conversationviewholder, context, true);
            }
        } else
        {
            setUserImage(conversationviewholder, null, false);
        }
        if (cursor.isLast())
        {
            conversationviewholder.divider.setVisibility(8);
            if (cursor.getInt(7) != 1)
            {
                conversationviewholder.divider.setVisibility(0);
                conversationviewholder.loadMore.setVisibility(0);
                if (mFragment.isLoadingMore())
                {
                    conversationviewholder.loadMoreContent.setVisibility(8);
                    conversationviewholder.loadMoreProgress.setVisibility(0);
                }
                conversationviewholder.loadMore.setOnClickListener(mFragment);
            }
            return;
        } else
        {
            conversationviewholder.divider.setVisibility(0);
            conversationviewholder.loadMore.setVisibility(8);
            return;
        }
_L2:
        if (l != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        view = (new StringBuilder()).append(view).append(" ").append(mContext.getString(0x7f0e004d)).toString();
        conversationviewholder.username.setText(view);
_L6:
        conversationviewholder.image.setVisibility(8);
        if (true) goto _L4; else goto _L3
_L3:
        if (l <= 2) goto _L6; else goto _L5
_L5:
        view = (new StringBuilder()).append(view).append(" ").append(String.format(mContext.getString(0x7f0e004c), new Object[] {
            Integer.valueOf(l - 1)
        })).toString();
        conversationviewholder.username.setText(view);
          goto _L6
    }

    public long getItemId(int i)
    {
        Cursor cursor = getCursor();
        if (cursor != null && !cursor.isClosed() && cursor.moveToPosition(i))
        {
            return cursor.getLong(3);
        } else
        {
            return super.getItemId(i);
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context).inflate(0x7f03004c, viewgroup, false);
        cursor = new ConversationViewHolder(context);
        context.setTag(cursor);
        mViewHolders.add(new WeakReference(cursor));
        return context;
    }

    public void setIdsToNotifyFailed(ArrayList arraylist)
    {
        mIdsToNotifyFail = arraylist;
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
        ConversationViewHolder conversationviewholder;
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_135;
        }
        obj1 = (WeakReference)iterator.next();
        conversationviewholder = (ConversationViewHolder)((WeakReference) (obj1)).get();
        if (conversationviewholder != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ((ArrayList) (obj)).add(obj1);
          goto _L1
        hashmap;
        throw hashmap;
        obj1 = (UrlImage)hashmap.get(conversationviewholder.avatarUrl);
        if (obj1 == null) goto _L1; else goto _L2
_L2:
        if (!((UrlImage) (obj1)).isValid()) goto _L1; else goto _L3
_L3:
        mAvatars.put(conversationviewholder.avatarUrl, new WeakReference(((UrlImage) (obj1)).bitmap));
        setUserImage(conversationviewholder, ((UrlImage) (obj1)).bitmap, true);
          goto _L1
        for (hashmap = ((ArrayList) (obj)).iterator(); hashmap.hasNext(); mViewHolders.remove(obj))
        {
            obj = (WeakReference)hashmap.next();
        }

        this;
        JVM INSTR monitorexit ;
    }
}
