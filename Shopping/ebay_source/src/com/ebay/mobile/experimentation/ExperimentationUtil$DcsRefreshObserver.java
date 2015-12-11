// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.experimentation;

import android.database.DataSetObserver;

// Referenced classes of package com.ebay.mobile.experimentation:
//            ExperimentationUtil

private static final class <init> extends DataSetObserver
{

    public void onChanged()
    {
        synchronized (ExperimentationUtil.access$100())
        {
            if (ExperimentationUtil.access$200() != null)
            {
                ExperimentationUtil.access$300(ExperimentationUtil.access$200());
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
