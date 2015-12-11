// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import android.database.DataSetObservable;
import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DeviceConfigurationManager

private static final class <init> extends DataSetObservable
    implements Runnable
{

    static final Handler handler = new Handler(Looper.getMainLooper());

    public void notifyChanged()
    {
        handler.post(this);
    }

    public void run()
    {
        super.notifyChanged();
    }


    private ()
    {
    }

    ( )
    {
        this();
    }
}
