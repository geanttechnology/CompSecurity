// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;

public final class SettableDataSource extends AbstractDataSource
{

    private SettableDataSource()
    {
    }

    public static SettableDataSource create()
    {
        return new SettableDataSource();
    }

    protected void closeResult(CloseableReference closeablereference)
    {
        CloseableReference.closeSafely(closeablereference);
    }

    protected volatile void closeResult(Object obj)
    {
        closeResult((CloseableReference)obj);
    }

    public CloseableReference getResult()
    {
        return CloseableReference.cloneOrNull((CloseableReference)super.getResult());
    }

    public volatile Object getResult()
    {
        return getResult();
    }

    public boolean set(CloseableReference closeablereference)
    {
        return super.setResult(CloseableReference.cloneOrNull(closeablereference), true);
    }

    public boolean setException(Throwable throwable)
    {
        return super.setFailure(throwable);
    }

    public boolean setProgress(float f)
    {
        return super.setProgress(f);
    }
}
