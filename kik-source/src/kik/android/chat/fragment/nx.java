// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kik.android.chat.fragment;

import android.content.DialogInterface;

// Referenced classes of package kik.android.chat.fragment:
//            KikPreferenceLaunchpad

final class nx
    implements android.content.DialogInterface.OnCancelListener
{

    final kik.android.util.p.a a;
    final KikPreferenceLaunchpad b;

    nx(KikPreferenceLaunchpad kikpreferencelaunchpad, kik.android.util.p.a a1)
    {
        b = kikpreferencelaunchpad;
        a = a1;
        super();
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.cancel(true);
    }
}
