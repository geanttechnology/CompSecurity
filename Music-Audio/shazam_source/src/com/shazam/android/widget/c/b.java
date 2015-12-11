// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.c;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.shazam.android.k.f.i;
import com.shazam.android.k.f.j;

// Referenced classes of package com.shazam.android.widget.c:
//            d

public final class b
    implements d
{

    private final j a;
    private final PackageManager b;
    private final String c;

    public b(j j1, PackageManager packagemanager, String s)
    {
        a = j1;
        b = packagemanager;
        c = s;
    }

    public final void a(Context context, Intent intent)
    {
        a(context, intent, (new com.shazam.android.k.f.i.a()).a());
    }

    public final void a(Context context, Intent intent, i i)
    {
        a(context, intent, i, null);
    }

    public final void a(Context context, Intent intent, i i, Bundle bundle)
    {
        Object obj = intent.resolveActivity(b);
        String s = c;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((ComponentName) (obj)).getPackageName();
        }
        if (s.equals(obj))
        {
            j.a(i, intent);
        }
        if (!(context instanceof Activity))
        {
            intent.addFlags(0x10000000);
        }
        context.startActivity(intent, bundle);
    }
}
