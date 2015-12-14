// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import uk.co.senab.photoview.log.LogManager;
import uk.co.senab.photoview.log.Logger;
import uk.co.senab.photoview.scrollerproxy.ScrollerProxy;

// Referenced classes of package uk.co.senab.photoview:
//            PhotoViewAttacher, Compat

private class croller
    implements Runnable
{

    private int mCurrentX;
    private int mCurrentY;
    private final ScrollerProxy mScroller;
    final PhotoViewAttacher this$0;

    public void cancelFling()
    {
        if (PhotoViewAttacher.access$300())
        {
            LogManager.getLogger().d("PhotoViewAttacher", "Cancel Fling");
        }
        mScroller.forceFinished(true);
    }

    public void fling(int i, int j, int k, int l)
    {
        RectF rectf = getDisplayRect();
        if (rectf != null)
        {
            int i1 = Math.round(-rectf.left);
            int j1;
            int k1;
            int l1;
            if ((float)i < rectf.width())
            {
                i = (int)(-PhotoViewAttacher.access$400(PhotoViewAttacher.this).left);
                j1 = Math.round(rectf.width() - PhotoViewAttacher.access$400(PhotoViewAttacher.this).right);
            } else
            {
                j1 = i1;
                i = i1;
            }
            k1 = Math.round(-rectf.top);
            if ((float)j < rectf.height())
            {
                j = (int)(-PhotoViewAttacher.access$400(PhotoViewAttacher.this).top);
                l1 = Math.round(rectf.height() - PhotoViewAttacher.access$400(PhotoViewAttacher.this).bottom);
            } else
            {
                l1 = k1;
                j = k1;
            }
            mCurrentX = i1;
            mCurrentY = k1;
            if (PhotoViewAttacher.access$300())
            {
                LogManager.getLogger().d("PhotoViewAttacher", (new StringBuilder()).append("fling. StartX:").append(i1).append(" StartY:").append(k1).append(" MaxX:").append(j1).append(" MaxY:").append(l1).toString());
            }
            if (i1 != j1 || k1 != l1)
            {
                mScroller.fling(i1, k1, k, l, i, j1, j, l1, 0, 0);
                return;
            }
        }
    }

    public void run()
    {
        android.widget.ImageView imageview;
        if (!mScroller.isFinished())
        {
            if ((imageview = getImageView()) != null && mScroller.computeScrollOffset())
            {
                int i = mScroller.getCurrX();
                int j = mScroller.getCurrY();
                if (PhotoViewAttacher.access$300())
                {
                    LogManager.getLogger().d("PhotoViewAttacher", (new StringBuilder()).append("fling run(). CurrentX:").append(mCurrentX).append(" CurrentY:").append(mCurrentY).append(" NewX:").append(i).append(" NewY:").append(j).toString());
                }
                PhotoViewAttacher.access$100(PhotoViewAttacher.this).postTranslate(mCurrentX - i, mCurrentY - j);
                PhotoViewAttacher.access$500(PhotoViewAttacher.this, getDrawMatrix());
                mCurrentX = i;
                mCurrentY = j;
                Compat.postOnAnimation(imageview, this);
                return;
            }
        }
    }

    public (Context context)
    {
        this$0 = PhotoViewAttacher.this;
        super();
        mScroller = ScrollerProxy.getScroller(context);
    }
}
