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
//            cb

public final class bq
{

    Notification A;
    public Notification B;
    public ArrayList C;
    Context a;
    CharSequence b;
    CharSequence c;
    public PendingIntent d;
    PendingIntent e;
    RemoteViews f;
    Bitmap g;
    CharSequence h;
    int i;
    public int j;
    boolean k;
    boolean l;
    cb m;
    CharSequence n;
    int o;
    int p;
    boolean q;
    String r;
    boolean s;
    String t;
    ArrayList u;
    boolean v;
    String w;
    Bundle x;
    public int y;
    int z;

    public bq(Context context)
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

    protected static CharSequence c(CharSequence charsequence)
    {
        while (charsequence == null || charsequence.length() <= 5120) 
        {
            return charsequence;
        }
        return charsequence.subSequence(0, 5120);
    }

    public final bq a()
    {
        Notification notification = B;
        notification.flags = notification.flags | 0x10;
        return this;
    }

    public final bq a(int i1)
    {
        B.icon = i1;
        return this;
    }

    public final bq a(cb cb1)
    {
        if (m != cb1)
        {
            m = cb1;
            if (m != null)
            {
                cb1 = m;
                if (cb1.d != this)
                {
                    cb1.d = this;
                    if (cb1.d != null)
                    {
                        cb1.d.a(cb1);
                    }
                }
            }
        }
        return this;
    }

    public final bq a(CharSequence charsequence)
    {
        b = c(charsequence);
        return this;
    }

    public final bq b(CharSequence charsequence)
    {
        c = c(charsequence);
        return this;
    }
}
