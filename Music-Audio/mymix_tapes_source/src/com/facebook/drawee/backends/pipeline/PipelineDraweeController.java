// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.concurrent.Executor;

public class PipelineDraweeController extends AbstractDraweeController
{

    private static final Class TAG = com/facebook/drawee/backends/pipeline/PipelineDraweeController;
    private final AnimatedDrawableFactory mAnimatedDrawableFactory;
    private Supplier mDataSourceSupplier;
    private final Resources mResources;

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredreleaser, AnimatedDrawableFactory animateddrawablefactory, Executor executor, Supplier supplier, String s, Object obj)
    {
        super(deferredreleaser, executor, s, obj);
        mResources = resources;
        mAnimatedDrawableFactory = animateddrawablefactory;
        init(supplier);
    }

    private void init(Supplier supplier)
    {
        mDataSourceSupplier = supplier;
    }

    protected Drawable createDrawable(CloseableReference closeablereference)
    {
        Preconditions.checkState(CloseableReference.isValid(closeablereference));
        closeablereference = (CloseableImage)closeablereference.get();
        if (closeablereference instanceof CloseableStaticBitmap)
        {
            closeablereference = (CloseableStaticBitmap)closeablereference;
            BitmapDrawable bitmapdrawable = new BitmapDrawable(mResources, closeablereference.getUnderlyingBitmap());
            if (closeablereference.getRotationAngle() == 0 || closeablereference.getRotationAngle() == -1)
            {
                return bitmapdrawable;
            } else
            {
                return new OrientedDrawable(bitmapdrawable, closeablereference.getRotationAngle());
            }
        }
        if (closeablereference instanceof CloseableAnimatedImage)
        {
            return mAnimatedDrawableFactory.create(((CloseableAnimatedImage)closeablereference).getImageResult());
        } else
        {
            throw new UnsupportedOperationException((new StringBuilder()).append("Unrecognized image class: ").append(closeablereference).toString());
        }
    }

    protected volatile Drawable createDrawable(Object obj)
    {
        return createDrawable((CloseableReference)obj);
    }

    protected DataSource getDataSource()
    {
        if (FLog.isLoggable(2))
        {
            FLog.v(TAG, "controller %x: getDataSource", Integer.valueOf(System.identityHashCode(this)));
        }
        return (DataSource)mDataSourceSupplier.get();
    }

    protected int getImageHash(CloseableReference closeablereference)
    {
        if (closeablereference != null)
        {
            return closeablereference.getValueHash();
        } else
        {
            return 0;
        }
    }

    protected volatile int getImageHash(Object obj)
    {
        return getImageHash((CloseableReference)obj);
    }

    protected ImageInfo getImageInfo(CloseableReference closeablereference)
    {
        Preconditions.checkState(CloseableReference.isValid(closeablereference));
        return (ImageInfo)closeablereference.get();
    }

    protected volatile Object getImageInfo(Object obj)
    {
        return getImageInfo((CloseableReference)obj);
    }

    protected Resources getResources()
    {
        return mResources;
    }

    public void initialize(Supplier supplier, String s, Object obj)
    {
        super.initialize(s, obj);
        init(supplier);
    }

    protected void releaseDrawable(Drawable drawable)
    {
        if (drawable instanceof DrawableWithCaches)
        {
            ((DrawableWithCaches)drawable).dropCaches();
        }
    }

    protected void releaseImage(CloseableReference closeablereference)
    {
        CloseableReference.closeSafely(closeablereference);
    }

    protected volatile void releaseImage(Object obj)
    {
        releaseImage((CloseableReference)obj);
    }

    public String toString()
    {
        return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", mDataSourceSupplier).toString();
    }

}
