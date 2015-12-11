// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
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
import co.vine.android.api.VineTypeAhead;
import co.vine.android.client.AppController;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class UsersAutoCompleteAdapter extends CursorAdapter
{
    private class UserDropDownViewHolder
    {

        public ImageKey avatarUrl;
        public final ImageView image;
        final UsersAutoCompleteAdapter this$0;
        public long userId;
        public final TextView userNameView;

        public UserDropDownViewHolder(View view)
        {
            this$0 = UsersAutoCompleteAdapter.this;
            super();
            image = (ImageView)view.findViewById(0x7f0a0063);
            userNameView = (TextView)view.findViewById(0x7f0a00c4);
        }
    }


    private AppController mAppController;
    private final int mProfileImageSize;
    protected final ArrayList mViewHolders = new ArrayList();

    public UsersAutoCompleteAdapter(Activity activity, AppController appcontroller)
    {
        super(activity, null, true);
        mAppController = appcontroller;
        mProfileImageSize = activity.getResources().getDimensionPixelOffset(0x7f0b0087);
    }

    private void setUserImage(UserDropDownViewHolder userdropdownviewholder, Bitmap bitmap)
    {
        userdropdownviewholder.image.setColorFilter(null);
        if (bitmap != null)
        {
            userdropdownviewholder.image.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
            return;
        } else
        {
            userdropdownviewholder.image.setImageResource(0x7f0200f7);
            return;
        }
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        view = (UserDropDownViewHolder)view.getTag();
        view.userId = cursor.getLong(1);
        context = cursor.getString(3);
        if (!TextUtils.isEmpty(context))
        {
            ImageKey imagekey = new ImageKey(context, mProfileImageSize, mProfileImageSize, true);
            if (Util.isDefaultAvatarUrl(context))
            {
                Util.safeSetDefaultAvatar(((UserDropDownViewHolder) (view)).image, co.vine.android.util.Util.ProfileImageSize.MEDIUM, 0xff000000 | mContext.getResources().getColor(0x7f090096));
            } else
            {
                view.avatarUrl = imagekey;
                setUserImage(view, mAppController.getPhotoBitmap(imagekey));
            }
        } else
        {
            setUserImage(view, null);
        }
        ((UserDropDownViewHolder) (view)).userNameView.setText((new StringBuilder()).append("@").append(cursor.getString(2)).toString());
    }

    public Object getItem(int i)
    {
        Object obj = (Cursor)super.getItem(i);
        long l;
        if (obj != null)
        {
            l = ((Cursor) (obj)).getLong(1);
            obj = ((Cursor) (obj)).getString(2);
        } else
        {
            l = 0L;
            obj = "";
        }
        return new VineTypeAhead("mention", ((String) (obj)), l);
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

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context).inflate(0x7f0300a0, viewgroup, false);
        cursor = new UserDropDownViewHolder(context);
        ((UserDropDownViewHolder) (cursor)).image.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
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
        UserDropDownViewHolder userdropdownviewholder;
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj1 = (WeakReference)iterator.next();
        userdropdownviewholder = (UserDropDownViewHolder)((WeakReference) (obj1)).get();
        if (userdropdownviewholder != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ((ArrayList) (obj)).add(obj1);
          goto _L1
        hashmap;
        throw hashmap;
        obj1 = (UrlImage)hashmap.get(userdropdownviewholder.avatarUrl);
        if (obj1 == null) goto _L1; else goto _L2
_L2:
        if (!((UrlImage) (obj1)).isValid()) goto _L1; else goto _L3
_L3:
        setUserImage(userdropdownviewholder, ((UrlImage) (obj1)).bitmap);
          goto _L1
        for (hashmap = ((ArrayList) (obj)).iterator(); hashmap.hasNext(); mViewHolders.remove(obj))
        {
            obj = (WeakReference)hashmap.next();
        }

        this;
        JVM INSTR monitorexit ;
    }
}
