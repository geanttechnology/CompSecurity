// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ba;

import android.content.ContentValues;
import com.shazam.i.b.ah.f.f;
import com.shazam.i.b.c;
import com.shazam.model.TrackLayoutType;

// Referenced classes of package com.shazam.android.ba:
//            f

public final class b
    implements com.shazam.android.ba.f
{

    private final com.shazam.android.persistence.r.b a;

    public b()
    {
        this(f.a(c.a()));
    }

    private b(com.shazam.android.persistence.r.b b1)
    {
        a = b1;
    }

    public final void a()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("full", Boolean.valueOf(false));
        int i = TrackLayoutType.LOCAL_WEB.getDatabaseID();
        a.a(contentvalues, "id_track_type!=?", new String[] {
            String.valueOf(i)
        });
    }
}
