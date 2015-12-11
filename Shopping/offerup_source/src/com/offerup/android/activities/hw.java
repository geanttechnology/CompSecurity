// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;

// Referenced classes of package com.offerup.android.activities:
//            hv, TermsOfServiceActivity

final class hw
    implements android.content.DialogInterface.OnClickListener
{

    private hv a;

    hw(hv hv1)
    {
        a = hv1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        a.a.finish();
    }
}
