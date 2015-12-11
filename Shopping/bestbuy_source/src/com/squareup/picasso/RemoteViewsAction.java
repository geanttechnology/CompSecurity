// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.graphics.Bitmap;
import android.widget.RemoteViews;

// Referenced classes of package com.squareup.picasso:
//            Action, Picasso, Request

abstract class RemoteViewsAction extends Action
{

    final RemoteViews remoteViews;
    final int viewId;

    RemoteViewsAction(Picasso picasso, Request request, RemoteViews remoteviews, int i, int j, boolean flag, String s)
    {
        super(picasso, new RemoteViewsTarget(remoteviews, i), request, flag, false, j, null, s);
        remoteViews = remoteviews;
        viewId = i;
    }

    void complete(Bitmap bitmap, Picasso.LoadedFrom loadedfrom)
    {
        remoteViews.setImageViewBitmap(viewId, bitmap);
        update();
    }

    public void error()
    {
        if (errorResId != 0)
        {
            setImageResource(errorResId);
        }
    }

    void setImageResource(int i)
    {
        remoteViews.setImageViewResource(viewId, i);
        update();
    }

    abstract void update();

    private class RemoteViewsTarget
    {

        final RemoteViews remoteViews;
        final int viewId;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (RemoteViewsTarget)obj;
                if (viewId != ((RemoteViewsTarget) (obj)).viewId || !remoteViews.equals(((RemoteViewsTarget) (obj)).remoteViews))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return remoteViews.hashCode() * 31 + viewId;
        }

        RemoteViewsTarget(RemoteViews remoteviews, int i)
        {
            remoteViews = remoteviews;
            viewId = i;
        }
    }

}
