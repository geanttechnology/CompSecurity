// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import android.app.PendingIntent;
import android.content.Intent;
import com.shazam.i.b.c;

// Referenced classes of package com.shazam.android.service.player:
//            MusicPlayerService

public final class i
{

    public static PendingIntent a(String s)
    {
        return PendingIntent.getService(c.a(), 0, b(s), 0x10000000);
    }

    public static Intent b(String s)
    {
        Intent intent = new Intent(c.a(), com/shazam/android/service/player/MusicPlayerService);
        intent.setAction(s);
        return intent;
    }
}
