// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.dagger;

import android.content.Context;

public class ApplicationModule
{

    private final Context context;

    public ApplicationModule(Context context1)
    {
        context = context1.getApplicationContext();
    }

    Context provideContext()
    {
        return context;
    }
}
