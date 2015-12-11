// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities.facebook;

import android.os.Bundle;
import com.shazam.android.aspects.b.a.b;
import com.shazam.android.u.e;
import com.shazam.i.b.ap.a;

public class FacebookAccessTokenRefreshAspect extends b
{

    private final e facebookTokenRefresher = new com.shazam.android.u.b(com.shazam.i.b.n.b.c(), a.c());

    public FacebookAccessTokenRefreshAspect()
    {
    }

    public void onCreate(com.shazam.android.aspects.c.a.a a1, Bundle bundle)
    {
        super.onCreate(a1, bundle);
        facebookTokenRefresher.a();
    }
}
