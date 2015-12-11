// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview;

import android.graphics.Matrix;
import android.graphics.RectF;

public interface IPhotoView
{

    public abstract boolean canZoom();

    public abstract Matrix getDisplayMatrix();

    public abstract RectF getDisplayRect();

    public abstract float getMaxScale();

    public abstract float getMaximumScale();

    public abstract float getMediumScale();

    public abstract float getMidScale();

    public abstract float getMinScale();

    public abstract float getMinimumScale();

    public abstract float getScale();

    public abstract android.widget.ImageView.ScaleType getScaleType();

    public abstract void setAllowParentInterceptOnEdge(boolean flag);

    public abstract boolean setDisplayMatrix(Matrix matrix);

    public abstract void setMaxScale(float f);

    public abstract void setMaximumScale(float f);

    public abstract void setMediumScale(float f);

    public abstract void setMidScale(float f);

    public abstract void setMinScale(float f);

    public abstract void setMinimumScale(float f);

    public abstract void setOnFlingListener(PhotoViewAttacher.OnFlingListener onflinglistener);

    public abstract void setOnLongClickListener(android.view.View.OnLongClickListener onlongclicklistener);

    public abstract void setOnMatrixChangeListener(PhotoViewAttacher.OnMatrixChangedListener onmatrixchangedlistener);

    public abstract void setOnPhotoTapListener(PhotoViewAttacher.OnPhotoTapListener onphototaplistener);

    public abstract void setOnViewTapListener(PhotoViewAttacher.OnViewTapListener onviewtaplistener);

    public abstract void setPhotoViewRotation(float f);

    public abstract void setScale(float f);

    public abstract void setScale(float f, float f1, float f2, boolean flag);

    public abstract void setScale(float f, boolean flag);

    public abstract void setScaleType(android.widget.ImageView.ScaleType scaletype);

    public abstract void setZoomable(boolean flag);
}
