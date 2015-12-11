// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            bg, bm, bp, bn, 
//            bx, bh

public final class bl
{

    public Context a;
    public CharSequence b;
    public CharSequence c;
    PendingIntent d;
    public Bitmap e;
    int f;
    boolean g;
    public bx h;
    public CharSequence i;
    public ArrayList j;
    boolean k;
    String l;
    Bundle m;
    int n;
    int o;
    Notification p;
    public Notification q;
    public ArrayList r;

    public bl(Context context)
    {
        g = true;
        j = new ArrayList();
        k = false;
        n = 0;
        o = 0;
        q = new Notification();
        a = context;
        q.when = System.currentTimeMillis();
        q.audioStreamType = -1;
        f = 0;
        r = new ArrayList();
    }

    protected static CharSequence e(CharSequence charsequence)
    {
        while (charsequence == null || charsequence.length() <= 5120) 
        {
            return charsequence;
        }
        return charsequence.subSequence(0, 5120);
    }

    public final Notification a()
    {
        return bg.a().a(this, new bm());
    }

    public final bl a(int i1)
    {
        q.icon = i1;
        return this;
    }

    public final bl a(Notification notification)
    {
        p = notification;
        return this;
    }

    public final bl a(PendingIntent pendingintent)
    {
        d = pendingintent;
        return this;
    }

    public final bl a(Uri uri)
    {
        q.sound = uri;
        q.audioStreamType = -1;
        return this;
    }

    public final bl a(bh bh)
    {
        j.add(bh);
        return this;
    }

    public final bl a(bn bn1)
    {
        bn1.extend(this);
        return this;
    }

    public final bl a(bx bx1)
    {
        if (h != bx1)
        {
            h = bx1;
            if (h != null)
            {
                bx1 = h;
                if (bx1.b != this)
                {
                    bx1.b = this;
                    if (bx1.b != null)
                    {
                        bx1.b.a(bx1);
                    }
                }
            }
        }
        return this;
    }

    public final bl a(CharSequence charsequence)
    {
        b = e(charsequence);
        return this;
    }

    public final bl a(String s)
    {
        l = s;
        return this;
    }

    public final bl a(boolean flag)
    {
        Notification notification = q;
        notification.flags = notification.flags | 0x10;
        return this;
    }

    public final bl b(int i1)
    {
        q.defaults = i1;
        if ((i1 & 4) != 0)
        {
            Notification notification = q;
            notification.flags = notification.flags | 1;
        }
        return this;
    }

    public final bl b(CharSequence charsequence)
    {
        c = e(charsequence);
        return this;
    }

    public final bl b(boolean flag)
    {
        k = flag;
        return this;
    }

    public final bl c(int i1)
    {
        f = i1;
        return this;
    }

    public final bl c(CharSequence charsequence)
    {
        i = e(charsequence);
        return this;
    }

    public final bl d(int i1)
    {
        n = i1;
        return this;
    }

    public final bl d(CharSequence charsequence)
    {
        q.tickerText = e(charsequence);
        return this;
    }

    public final bl e(int i1)
    {
        o = i1;
        return this;
    }
}
