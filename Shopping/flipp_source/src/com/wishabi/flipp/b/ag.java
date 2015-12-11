// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.content.Context;
import android.location.Geocoder;
import com.google.android.gms.common.g;
import com.google.android.gms.internal.iu;
import com.google.android.gms.location.e;
import java.util.Locale;

// Referenced classes of package com.wishabi.flipp.b:
//            ah, aj

public abstract class ag
{

    private final Context a;
    e b;

    public ag(Context context)
    {
        a = context.getApplicationContext();
    }

    public final void a()
    {
        if (b != null || !Geocoder.isPresent() || g.a(a) != 0)
        {
            a(null);
            return;
        } else
        {
            Geocoder geocoder = new Geocoder(a, Locale.getDefault());
            b = new e(a, new ah(this, geocoder), new aj(this));
            b.a.d();
            return;
        }
    }

    public abstract void a(String s);
}
