// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;


// Referenced classes of package com.ebay.mobile.common:
//            PhotoGalleryWidget

private class <init>
    implements Runnable
{

    private int mLastFlingX;
    final PhotoGalleryWidget this$0;

    private final void stop()
    {
        removeCallbacks(this);
        PhotoGalleryWidget.access$300(PhotoGalleryWidget.this).forceFinished(true);
    }

    public final void run()
    {
        PhotoGalleryWidget.access$402(PhotoGalleryWidget.this, false);
        boolean flag = PhotoGalleryWidget.access$300(PhotoGalleryWidget.this).computeScrollOffset();
        int i = PhotoGalleryWidget.access$300(PhotoGalleryWidget.this).getCurrX();
        int j = mLastFlingX;
        PhotoGalleryWidget.access$500(PhotoGalleryWidget.this, j - i);
        if (flag && !PhotoGalleryWidget.access$400(PhotoGalleryWidget.this))
        {
            mLastFlingX = i;
            post(this);
            return;
        } else
        {
            stop();
            PhotoGalleryWidget.access$600(PhotoGalleryWidget.this);
            return;
        }
    }

    public final void startUsingVelocity(int i)
    {
        if (i != 0)
        {
            removeCallbacks(this);
            int j;
            if (i < 0)
            {
                j = 0x7fffffff;
            } else
            {
                j = 0;
            }
            mLastFlingX = j;
            PhotoGalleryWidget.access$300(PhotoGalleryWidget.this).fling(j, i);
            post(this);
        }
    }


    private ()
    {
        this$0 = PhotoGalleryWidget.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
