// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import android.app.AlarmManager;
import android.app.PendingIntent;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.e:
//            g, f, h

class a
    implements g
{

    final f a;

    public void a(AlarmManager alarmmanager, h h, PendingIntent pendingintent)
    {
        aa.a(f.d(), (new StringBuilder()).append("Remove alarm for ").append(h).toString());
        alarmmanager.cancel(pendingintent);
    }

    (f f1)
    {
        a = f1;
        super();
    }
}
