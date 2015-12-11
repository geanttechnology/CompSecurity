// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public final class bde
{

    final Context a;
    public volatile String b;

    public bde(Context context)
    {
        a = context;
    }

    public final void a()
    {
        (new Thread(new bdf(this), "AdvertisingIdProviderThread")).start();
    }
}
