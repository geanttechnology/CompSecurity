// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.text.TextUtils;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Connector

public static class initCause extends initCause
{

    private static final long serialVersionUID = 1L;

    public static initCause create(Throwable throwable)
    {
        String s = throwable.getLocalizedMessage();
        if (TextUtils.isEmpty(s))
        {
            return new <init>(throwable);
        } else
        {
            return new <init>(s, throwable);
        }
    }

    public ()
    {
    }

    public (String s)
    {
        super(s);
    }

    public >(String s, Throwable throwable)
    {
        super(s);
        initCause(throwable);
    }

    public initCause(Throwable throwable)
    {
        initCause(throwable);
    }
}
