// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            u

public static class C
{

    Notification A;
    public Notification B;
    public ArrayList C;
    public Context a;
    public CharSequence b;
    public CharSequence c;
    public PendingIntent d;
    PendingIntent e;
    RemoteViews f;
    public Bitmap g;
    public CharSequence h;
    public int i;
    int j;
    boolean k;
    public boolean l;
    public f m;
    public CharSequence n;
    int o;
    int p;
    boolean q;
    String r;
    boolean s;
    String t;
    public ArrayList u;
    boolean v;
    String w;
    Bundle x;
    public int y;
    int z;

    protected static CharSequence f(CharSequence charsequence)
    {
        while (charsequence == null || charsequence.length() <= 5120) 
        {
            return charsequence;
        }
        return charsequence.subSequence(0, 5120);
    }

    public final equence a()
    {
        a(16, true);
        return this;
    }

    public final a a(int i1)
    {
        B.icon = i1;
        return this;
    }

    public final on a(int i1, CharSequence charsequence, PendingIntent pendingintent)
    {
        u.add(new <init>(i1, charsequence, pendingintent));
        return this;
    }

    public final <init> a(long l1)
    {
        B.when = l1;
        return this;
    }

    public final en a(en en)
    {
        if (m != en)
        {
            m = en;
            if (m != null)
            {
                en = m;
                if (en.d != this)
                {
                    en.d = this;
                    if (en.d != null)
                    {
                        en.d.a(en);
                    }
                }
            }
        }
        return this;
    }

    public final a a(CharSequence charsequence)
    {
        b = f(charsequence);
        return this;
    }

    public final void a(int i1, boolean flag)
    {
        if (flag)
        {
            Notification notification = B;
            notification.flags = notification.flags | i1;
            return;
        } else
        {
            Notification notification1 = B;
            notification1.flags = notification1.flags & ~i1;
            return;
        }
    }

    public final Notification b()
    {
        return android.support.v4.app.u.a().a(this, c());
    }

    public final c b(CharSequence charsequence)
    {
        c = f(charsequence);
        return this;
    }

    public final f c(CharSequence charsequence)
    {
        n = f(charsequence);
        return this;
    }

    public f c()
    {
        return new <init>();
    }

    public final <init> d(CharSequence charsequence)
    {
        h = f(charsequence);
        return this;
    }

    public final f e(CharSequence charsequence)
    {
        B.tickerText = f(charsequence);
        return this;
    }

    public (Context context)
    {
        k = true;
        u = new ArrayList();
        v = false;
        y = 0;
        z = 0;
        B = new Notification();
        a = context;
        B.when = System.currentTimeMillis();
        B.audioStreamType = -1;
        j = 0;
        C = new ArrayList();
    }
}
