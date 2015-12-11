// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.kc;

// Referenced classes of package com.facebook.login:
//            h, f

private static class a
    implements h
{

    private final Fragment a;

    public Activity a()
    {
        return a.j();
    }

    public void a(Intent intent, int i)
    {
        a.a(intent, i);
    }

    Fragment(Fragment fragment)
    {
        kc.a(fragment, "fragment");
        a = fragment;
    }
}
