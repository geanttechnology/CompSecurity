// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Resources;

// Referenced classes of package com.google.ads.conversiontracking:
//            d

static class <init> extends ContextWrapper
{

    private final b a;
    private final b b;

    public PackageManager getPackageManager()
    {
        return a;
    }

    public Resources getResources()
    {
        return b;
    }

    public (Context context)
    {
        super(context);
        a = new <init>(context);
        b = new <init>(context.getResources());
    }
}
