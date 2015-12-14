// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.MoPubView;

public class MoPubViewFactory
{

    protected static MoPubViewFactory instance = new MoPubViewFactory();

    public MoPubViewFactory()
    {
    }

    public static MoPubView create(Context context)
    {
        return instance.internalCreate(context);
    }

    public static void setInstance(MoPubViewFactory mopubviewfactory)
    {
        instance = mopubviewfactory;
    }

    protected MoPubView internalCreate(Context context)
    {
        return new MoPubView(context);
    }

}
