// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.content.DialogInterface;

// Referenced classes of package net.hockeyapp.android:
//            UpdateActivity

final class u
    implements android.content.DialogInterface.OnClickListener
{

    final UpdateActivity a;

    u(UpdateActivity updateactivity)
    {
        a = updateactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        UpdateActivity.a(a);
        dialoginterface.cancel();
    }
}
