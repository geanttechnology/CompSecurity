// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.g;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.shazam.android.aq.l;
import com.shazam.android.k.f.t;
import com.shazam.model.Factory;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public final class a
    implements com.shazam.b.a.a
{

    private final Context a;
    private final t b;
    private final com.shazam.b.a.a c;
    private final l d;
    private final ExecutorService e;
    private final Factory f;

    public a(Context context, l l1, t t1, com.shazam.b.a.a a1, ExecutorService executorservice, Factory factory)
    {
        a = context;
        d = l1;
        b = t1;
        c = a1;
        e = executorservice;
        f = factory;
    }

    private Notification a(List list)
    {
        android.support.v4.app.u.d d1;
        Object obj;
        Tag tag;
        obj = new android.support.v4.app.u.b();
        d1 = new android.support.v4.app.u.d(a);
        tag = (Tag)list.get(0);
        list = tag.b();
        list = (Bitmap)e.submit((Callable)f.create(list)).get();
_L2:
        obj.a = list;
        list = new Intent("android.intent.action.VIEW", b.a(tag));
        list.addFlags(0x10000000);
        list = PendingIntent.getActivity(a, 0, list, 0x40000000);
        Track track = tag.track;
        String s = a.getString(0x7f090095);
        obj = d1.a(s).e(s).a(((Integer)d.a()).intValue()).c(track.b()).a(((android.support.v4.app.u.p) (obj)));
        obj.y = a.getResources().getColor(0x7f0f007b);
        obj.d = list;
        ((android.support.v4.app.u.d) (obj)).a();
        a(d1, tag);
        return d1.b();
        list;
_L3:
        list = null;
        if (true) goto _L2; else goto _L1
_L1:
        list;
          goto _L3
    }

    private void a(android.support.v4.app.u.d d1, Tag tag)
    {
        android.support.v4.app.u.a a1;
        for (tag = ((List)c.a(tag)).iterator(); tag.hasNext(); d1.a(a1.a, a1.b, a1.c))
        {
            a1 = (android.support.v4.app.u.a)tag.next();
        }

    }

    public final volatile Object a(Object obj)
    {
        return a((List)obj);
    }
}
