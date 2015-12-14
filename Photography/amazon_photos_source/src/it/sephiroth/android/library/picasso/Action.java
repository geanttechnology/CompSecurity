// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

// Referenced classes of package it.sephiroth.android.library.picasso:
//            RequestWeakReference, Picasso, Request

abstract class Action
{

    boolean cancelled;
    final Drawable errorDrawable;
    final int errorResId;
    long fadeTime;
    final String key;
    final Picasso picasso;
    final Request request;
    final boolean skipCache;
    final Object tag;
    final WeakReference target;
    boolean willReplay;

    Action(Picasso picasso1, Object obj, Request request1, boolean flag, long l, int i, 
            Drawable drawable, String s, Object obj1)
    {
        picasso = picasso1;
        request = request1;
        if (obj == null)
        {
            picasso1 = null;
        } else
        {
            picasso1 = new RequestWeakReference(this, obj, picasso1.referenceQueue);
        }
        target = picasso1;
        skipCache = flag;
        fadeTime = l;
        errorResId = i;
        errorDrawable = drawable;
        key = s;
        if (obj1 == null)
        {
            obj1 = this;
        }
        tag = obj1;
    }

    void cancel()
    {
        cancelled = true;
    }

    abstract void complete(Bitmap bitmap, Picasso.LoadedFrom loadedfrom);

    abstract void error();

    String getKey()
    {
        return key;
    }

    Picasso getPicasso()
    {
        return picasso;
    }

    Picasso.Priority getPriority()
    {
        return request.priority;
    }

    Request getRequest()
    {
        return request;
    }

    Object getTag()
    {
        return tag;
    }

    Object getTarget()
    {
        return target.get();
    }

    boolean isCancelled()
    {
        return cancelled;
    }

    boolean willReplay()
    {
        return willReplay;
    }
}
