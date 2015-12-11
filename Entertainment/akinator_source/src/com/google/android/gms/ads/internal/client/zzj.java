// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;

public final class zzj extends zzu.zza
{

    private final AppEventListener zztj;

    public zzj(AppEventListener appeventlistener)
    {
        zztj = appeventlistener;
    }

    public void onAppEvent(String s, String s1)
    {
        zztj.onAppEvent(s, s1);
    }
}
