// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.p;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.shazam.android.persistence.c;
import com.shazam.model.Identifiable;

// Referenced classes of package com.shazam.android.persistence.p:
//            j

public final class o
    implements j
{

    private final Context a;
    private final c b;
    private final String c;

    public o(Context context, c c1, String s)
    {
        a = context;
        b = c1;
        c = s;
    }

    public final void a(Object obj)
    {
        Object obj1 = (Identifiable)obj;
        obj = b.a(c, new String[0]);
        obj1 = ((Uri) (obj)).buildUpon().appendPath(((Identifiable) (obj1)).a()).build();
        a.getContentResolver().notifyChange(((Uri) (obj1)), null);
        a.getContentResolver().notifyChange(((Uri) (obj)), null);
    }
}
