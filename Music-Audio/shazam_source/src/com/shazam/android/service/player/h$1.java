// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.player;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.g.c.ad;

// Referenced classes of package com.shazam.android.service.player:
//            h, MusicPlayerService

final class a
    implements ad
{

    final h a;

    public final void a()
    {
        if (a.f.equals(a.b.b()))
        {
            Bitmap bitmap = BitmapFactory.decodeResource(a.b.getResources(), 0x7f0200c3);
            a.c.g = bitmap;
            a.d.a("android.media.metadata.ART", bitmap);
            a.d.a("android.media.metadata.ALBUM_ART", bitmap);
            h.a(a);
        }
    }

    public final void a(Bitmap bitmap)
    {
        if (a.f.equals(a.b.b()) && !bitmap.isRecycled())
        {
            a.c.g = bitmap;
            a.d.a("android.media.metadata.ART", bitmap);
            a.d.a("android.media.metadata.ALBUM_ART", bitmap);
            h.a(a);
        }
    }

    Compat.a(h h1)
    {
        a = h1;
        super();
    }
}
