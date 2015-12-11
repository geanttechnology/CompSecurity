// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.ArrayList;

// Referenced classes of package com.tapjoy.internal:
//            a

public static final class j
{

    Context a;
    public CharSequence b;
    public CharSequence c;
    public PendingIntent d;
    PendingIntent e;
    RemoteViews f;
    Bitmap g;
    CharSequence h;
    int i;
    int j;
    boolean k;
    ws l;
    CharSequence m;
    int n;
    int o;
    boolean p;
    ArrayList q;
    public Notification r;

    public final j a(j j1)
    {
        if (l != j1)
        {
            l = j1;
            if (l != null)
            {
                j1 = l;
                if (j1.d != this)
                {
                    j1.d = this;
                    if (j1.d != null)
                    {
                        j1.d.a(j1);
                    }
                }
            }
        }
        return this;
    }

    public (Context context)
    {
        q = new ArrayList();
        r = new Notification();
        a = context;
        r.when = System.currentTimeMillis();
        r.audioStreamType = -1;
        j = 0;
    }
}
