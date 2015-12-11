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
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            ChannelsListFragment

private class this._cls0 extends CursorAdapter
{

    private final ArrayList mViewHolders = new ArrayList();
    final ChannelsListFragment this$0;

    private void setChannelImage(r r, Bitmap bitmap)
    {
        if (bitmap != null)
        {
            r.channelImage.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
            return;
        } else
        {
            r.channelImage.setImageBitmap(null);
            r.channelImage.setBackgroundColor(mContext.getResources().getColor(0x7f09007f));
            return;
        }
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        context = (r)view.getTag();
        ((r) (context)).channelTitle.setText(cursor.getString(2));
        context.channelId = cursor.getLong(1);
        if (((r) (context)).channelId == ChannelsListFragment.access$000(ChannelsListFragment.this))
        {
            view.setBackgroundColor(getResources().getColor(0x7f090055));
        } else
        {
            view.setBackgroundColor(getResources().getColor(0x7f090083));
        }
        if (getResources().getDisplayMetrics().densityDpi < 240)
        {
            view = cursor.getString(8);
        } else
        {
            view = cursor.getString(9);
        }
        if (!TextUtils.isEmpty(view))
        {
            view = new ImageKey(view);
            context.channelImageKey = view;
            setChannelImage(context, mAppController.getPhotoBitmap(view));
            return;
        } else
        {
            setChannelImage(context, null);
            return;
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context).inflate(0x7f030023, viewgroup, false);
        cursor = new r(ChannelsListFragment.this, context);
        mViewHolders.add(new WeakReference(cursor));
        context.setTag(cursor);
        return context;
    }

    public void setChannelImages(HashMap hashmap)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        obj = new ArrayList();
        iterator = mViewHolders.iterator();
_L1:
        r r;
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj1 = (WeakReference)iterator.next();
        r = (r)((WeakReference) (obj1)).get();
        if (r != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ((ArrayList) (obj)).add(obj1);
          goto _L1
        hashmap;
        throw hashmap;
        obj1 = (UrlImage)hashmap.get(r.channelImageKey);
        if (obj1 == null) goto _L1; else goto _L2
_L2:
        if (!((UrlImage) (obj1)).isValid()) goto _L1; else goto _L3
_L3:
        setChannelImage(r, ((UrlImage) (obj1)).bitmap);
          goto _L1
        for (hashmap = ((ArrayList) (obj)).iterator(); hashmap.hasNext(); mViewHolders.remove(obj))
        {
            obj = (WeakReference)hashmap.next();
        }

        this;
        JVM INSTR monitorexit ;
    }

    public r(Context context, AppController appcontroller, int i)
    {
        this$0 = ChannelsListFragment.this;
        super(context, null, i);
        mAppController = appcontroller;
    }
}
