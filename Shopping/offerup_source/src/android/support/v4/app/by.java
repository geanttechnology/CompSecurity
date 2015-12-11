// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v4.app:
//            bn, bg, bh, bp, 
//            bl

public final class by
    implements bn
{

    private ArrayList a;
    private int b;
    private PendingIntent c;
    private ArrayList d;
    private Bitmap e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;

    public by()
    {
        a = new ArrayList();
        b = 1;
        d = new ArrayList();
        g = 0x800005;
        h = -1;
        i = 0;
        k = 80;
    }

    public final by a(Notification notification)
    {
        d.add(notification);
        return this;
    }

    public final by a(Bitmap bitmap)
    {
        e = bitmap;
        return this;
    }

    public final by a(List list)
    {
        a.addAll(list);
        return this;
    }

    public final Object clone()
    {
        by by1 = new by();
        by1.a = new ArrayList(a);
        by1.b = b;
        by1.c = c;
        by1.d = new ArrayList(d);
        by1.e = e;
        by1.f = f;
        by1.g = g;
        by1.h = h;
        by1.i = i;
        by1.j = j;
        by1.k = k;
        by1.l = l;
        return by1;
    }

    public final bl extend(bl bl1)
    {
        Bundle bundle = new Bundle();
        if (!a.isEmpty())
        {
            bundle.putParcelableArrayList("actions", bg.a().a((bh[])a.toArray(new bh[a.size()])));
        }
        if (b != 1)
        {
            bundle.putInt("flags", b);
        }
        if (c != null)
        {
            bundle.putParcelable("displayIntent", c);
        }
        if (!d.isEmpty())
        {
            bundle.putParcelableArray("pages", (android.os.Parcelable[])d.toArray(new Notification[d.size()]));
        }
        if (e != null)
        {
            bundle.putParcelable("background", e);
        }
        if (f != 0)
        {
            bundle.putInt("contentIcon", f);
        }
        if (g != 0x800005)
        {
            bundle.putInt("contentIconGravity", g);
        }
        if (h != -1)
        {
            bundle.putInt("contentActionIndex", h);
        }
        if (i != 0)
        {
            bundle.putInt("customSizePreset", i);
        }
        if (j != 0)
        {
            bundle.putInt("customContentHeight", j);
        }
        if (k != 80)
        {
            bundle.putInt("gravity", k);
        }
        if (l != 0)
        {
            bundle.putInt("hintScreenTimeout", l);
        }
        if (bl1.m == null)
        {
            bl1.m = new Bundle();
        }
        bl1.m.putBundle("android.wearable.EXTENSIONS", bundle);
        return bl1;
    }
}
