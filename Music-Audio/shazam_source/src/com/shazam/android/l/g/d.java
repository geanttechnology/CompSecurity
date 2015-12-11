// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.g;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.shazam.android.aq.l;
import com.shazam.android.k.f.t;
import com.shazam.b.a.a;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import java.util.Iterator;
import java.util.List;

public final class d
    implements a
{

    private final Context a;
    private final l b;
    private final t c;

    public d(Context context, l l1, t t1)
    {
        a = context;
        b = l1;
        c = t1;
    }

    public final Object a(Object obj)
    {
        Object obj2 = (List)obj;
        Object obj1 = new android.support.v4.app.u.f();
        obj = new android.support.v4.app.u.d(a);
        for (Iterator iterator = ((List) (obj2)).iterator(); iterator.hasNext(); ((android.support.v4.app.u.f) (obj1)).a(((Tag)iterator.next()).track.b())) { }
        int i = ((List) (obj2)).size();
        obj2 = new Intent("android.intent.action.VIEW", c.a());
        ((Intent) (obj2)).addFlags(0x10000000);
        obj2 = PendingIntent.getActivity(a, 0, ((Intent) (obj2)), 0x40000000);
        Object obj3 = a.getString(0x7f0900ad, new Object[] {
            Integer.valueOf(i)
        });
        obj3 = ((android.support.v4.app.u.d) (obj)).a(((CharSequence) (obj3))).e(((CharSequence) (obj3)));
        obj3.i = i;
        obj1 = ((android.support.v4.app.u.d) (obj3)).a(((Integer)b.a()).intValue()).a(((android.support.v4.app.u.p) (obj1)));
        obj1.y = a.getResources().getColor(0x7f0f007b);
        obj1.d = ((PendingIntent) (obj2));
        ((android.support.v4.app.u.d) (obj1)).a();
        return ((android.support.v4.app.u.d) (obj)).b();
    }
}
