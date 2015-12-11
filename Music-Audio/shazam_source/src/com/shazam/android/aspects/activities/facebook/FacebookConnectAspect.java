// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities.facebook;

import android.content.Intent;
import android.os.Bundle;
import com.shazam.android.aspects.b.a.b;
import com.shazam.android.v.c.a;
import com.shazam.i.b.u.c;
import com.shazam.model.facebook.FacebookManager;

public class FacebookConnectAspect extends b
{

    private FacebookManager facebookManager;
    private final a facebookManagerFactory = c.a();

    public FacebookConnectAspect()
    {
    }

    public void onActivityResult(com.shazam.android.aspects.c.a.a a1, int i, int j, Intent intent)
    {
        super.onActivityResult(a1, i, j, intent);
        facebookManager.a(i, j, intent);
    }

    public void onCreate(com.shazam.android.aspects.c.a.a a1, Bundle bundle)
    {
        super.onCreate(a1, bundle);
        facebookManager = facebookManagerFactory.a(a1);
    }
}
