// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;

public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber
{

    public BaseBitmapDataSubscriber()
    {
    }

    protected abstract void onNewResultImpl(Bitmap bitmap);

    public void onNewResultImpl(DataSource datasource)
    {
        CloseableReference closeablereference;
        if (!datasource.isFinished())
        {
            return;
        }
        closeablereference = (CloseableReference)datasource.getResult();
        Object obj = null;
        datasource = obj;
        if (closeablereference != null)
        {
            datasource = obj;
            if (closeablereference.get() instanceof CloseableBitmap)
            {
                datasource = ((CloseableBitmap)closeablereference.get()).getUnderlyingBitmap();
            }
        }
        onNewResultImpl(((Bitmap) (datasource)));
        CloseableReference.closeSafely(closeablereference);
        return;
        datasource;
        CloseableReference.closeSafely(closeablereference);
        throw datasource;
    }
}
