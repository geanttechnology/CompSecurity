// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.graphics.RectF;
import android.view.MotionEvent;

// Referenced classes of package uk.co.senab.photoview:
//            PhotoViewAttacher

public class DefaultOnDoubleTapListener
    implements android.view.GestureDetector.OnDoubleTapListener
{

    private PhotoViewAttacher photoViewAttacher;

    public DefaultOnDoubleTapListener(PhotoViewAttacher photoviewattacher)
    {
        setPhotoViewAttacher(photoviewattacher);
    }

    public boolean onDoubleTap(MotionEvent motionevent)
    {
        if (photoViewAttacher == null)
        {
            return false;
        }
        float f;
        float f1;
        float f2;
        f = photoViewAttacher.getScale();
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        if (f >= photoViewAttacher.getMediumScale())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        photoViewAttacher.setScale(photoViewAttacher.getMediumScale(), f1, f2, true);
        return true;
        if (f < photoViewAttacher.getMediumScale() || f >= photoViewAttacher.getMaximumScale())
        {
            break MISSING_BLOCK_LABEL_104;
        }
        photoViewAttacher.setScale(photoViewAttacher.getMaximumScale(), f1, f2, true);
        return true;
        try
        {
            photoViewAttacher.setScale(photoViewAttacher.getMinimumScale(), f1, f2, true);
        }
        // Misplaced declaration of an exception variable
        catch (MotionEvent motionevent)
        {
            return true;
        }
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        if (photoViewAttacher != null)
        {
            android.widget.ImageView imageview = photoViewAttacher.getImageView();
            if (photoViewAttacher.getOnPhotoTapListener() != null)
            {
                RectF rectf = photoViewAttacher.getDisplayRect();
                if (rectf != null)
                {
                    float f1 = motionevent.getX();
                    float f = motionevent.getY();
                    if (rectf.contains(f1, f))
                    {
                        f1 = (f1 - rectf.left) / rectf.width();
                        f = (f - rectf.top) / rectf.height();
                        photoViewAttacher.getOnPhotoTapListener().onPhotoTap(imageview, f1, f);
                        return true;
                    }
                }
            }
            if (photoViewAttacher.getOnViewTapListener() != null)
            {
                photoViewAttacher.getOnViewTapListener().onViewTap(imageview, motionevent.getX(), motionevent.getY());
                return false;
            }
        }
        return false;
    }

    public void setPhotoViewAttacher(PhotoViewAttacher photoviewattacher)
    {
        photoViewAttacher = photoviewattacher;
    }
}
