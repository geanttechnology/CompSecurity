// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.g;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.shazam.android.aq.l;
import com.shazam.android.service.gcm.b;
import com.shazam.b.a.a;
import com.shazam.o.e;

public final class c
    implements a
{

    private final l a;
    private final a b;

    public c(l l1, a a1)
    {
        a = l1;
        b = a1;
    }

    private static String a(com.shazam.android.service.gcm.a a1, Bundle bundle)
    {
        if (bundle != null)
        {
            return bundle.getString(a1.l);
        } else
        {
            return null;
        }
    }

    private static void a(Object obj, String s)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }

    public final Object a(Object obj)
    {
        Object obj1 = (b)obj;
        obj = ((b) (obj1)).b;
        Context context = ((b) (obj1)).a;
        Bundle bundle = ((Intent) (obj)).getExtras();
        a(bundle, "Intent extras can not be null");
        obj = (Intent)b.a(bundle);
        a(obj, "IntentUri extra (uri) in notification payload was empty");
        PendingIntent pendingintent = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0x8000000);
        String s = a(com.shazam.android.service.gcm.a.g, bundle);
        obj = a(com.shazam.android.service.gcm.a.b, bundle);
        Object obj2 = a(com.shazam.android.service.gcm.a.c, bundle);
        String s1 = a(com.shazam.android.service.gcm.a.d, bundle);
        int i;
        long l1;
        if (com.shazam.b.e.a.a(((String) (obj2))))
        {
            obj1 = context.getString(0x7f090110);
        } else
        {
            obj1 = obj;
            obj = obj2;
        }
        l1 = e.a(a(com.shazam.android.service.gcm.a.f, bundle), System.currentTimeMillis());
        i = e.a(a(com.shazam.android.service.gcm.a.e, bundle), 0);
        obj2 = new android.support.v4.app.u.d(context);
        obj2.i = i;
        obj2 = ((android.support.v4.app.u.d) (obj2)).d(s1).a(l1).e(s).b(((CharSequence) (obj))).a(((CharSequence) (obj1))).a(((Integer)a.a()).intValue()).a();
        obj2.y = context.getResources().getColor(0x7f0f007b);
        obj = ((android.support.v4.app.u.d) (obj2)).a((new android.support.v4.app.u.c()).b(((CharSequence) (obj))).a(((CharSequence) (obj1))));
        obj.d = pendingintent;
        return ((android.support.v4.app.u.d) (obj)).b();
    }
}
