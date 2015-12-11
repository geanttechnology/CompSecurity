// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import java.util.ArrayList;

public final class au
{

    Context a;
    public PendingIntent b;
    int c;
    boolean d;
    ArrayList e;
    boolean f;
    int g;
    public int h;
    public Notification i;
    public ArrayList j;

    public au(Context context)
    {
        d = true;
        e = new ArrayList();
        f = false;
        g = 0;
        h = 0;
        i = new Notification();
        a = context;
        i.when = System.currentTimeMillis();
        i.audioStreamType = -1;
        c = 0;
        j = new ArrayList();
    }

    public final au a(CharSequence charsequence)
    {
        Notification notification = i;
        CharSequence charsequence1 = charsequence;
        if (charsequence != null)
        {
            charsequence1 = charsequence;
            if (charsequence.length() > 5120)
            {
                charsequence1 = charsequence.subSequence(0, 5120);
            }
        }
        notification.tickerText = charsequence1;
        return this;
    }
}
