// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.content.Context;
import android.os.Handler;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.IDisposable;

// Referenced classes of package com.aviary.android.feather.library.services:
//            IAviaryController

public abstract class BaseContextService
    implements IDisposable
{

    protected com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private IAviaryController mContext;
    protected boolean mDisposed;
    protected Handler mHandler;

    protected BaseContextService(Context context)
    {
    }

    protected BaseContextService(IAviaryController iaviarycontroller)
    {
        mContext = iaviarycontroller;
        mHandler = new Handler(iaviarycontroller.getBaseContext().getMainLooper());
        logger = LoggerFactory.getLogger(getClass().getSimpleName(), com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }

    public abstract void dispose();

    public IAviaryController getContext()
    {
        return mContext;
    }

    public Object getService(Class class1)
    {
        if (mContext != null)
        {
            return mContext.getService(class1);
        } else
        {
            return null;
        }
    }

    public void internalDispose()
    {
        logger.info("internalDispose");
        dispose();
        mDisposed = true;
        mHandler = null;
        mContext = null;
    }

    public boolean isActive()
    {
        return !mDisposed;
    }
}
