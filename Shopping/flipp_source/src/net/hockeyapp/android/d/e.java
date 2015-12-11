// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.d;

import android.content.DialogInterface;
import net.hockeyapp.android.b.a;

// Referenced classes of package net.hockeyapp.android.d:
//            d

final class e
    implements android.content.DialogInterface.OnClickListener
{

    final d a;

    e(d d1)
    {
        a = d1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        net.hockeyapp.android.d.d.a(a).a(Boolean.valueOf(false));
    }
}
