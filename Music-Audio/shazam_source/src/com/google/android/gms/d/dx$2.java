// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.DialogInterface;

// Referenced classes of package com.google.android.gms.d:
//            dx

final class a
    implements android.content.gInterface.OnClickListener
{

    final dx a;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        a.a("User canceled the download.");
    }

    e(dx dx1)
    {
        a = dx1;
        super();
    }
}
