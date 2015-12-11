// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.content.DialogInterface;
import java.lang.ref.WeakReference;

// Referenced classes of package net.hockeyapp.android:
//            b, g

final class d
    implements android.content.DialogInterface.OnClickListener
{

    final WeakReference a;
    final g b;
    final boolean c;

    d(WeakReference weakreference, g g, boolean flag)
    {
        a = weakreference;
        b = g;
        c = flag;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        net.hockeyapp.android.b.a(a, b, c);
    }
}
