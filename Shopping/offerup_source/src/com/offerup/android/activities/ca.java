// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import android.support.v4.e.a;
import com.offerup.android.utils.n;

// Referenced classes of package com.offerup.android.activities:
//            cd, ExploreActivity

final class ca
    implements android.content.DialogInterface.OnClickListener
{

    private android.app.AlertDialog.Builder a;
    private ExploreActivity b;

    ca(ExploreActivity exploreactivity, android.app.AlertDialog.Builder builder)
    {
        b = exploreactivity;
        a = builder;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (android.support.v4.e.a.b(b))
        {
            (new cd(b, (byte)0)).execute(new Void[1]);
            return;
        } else
        {
            n.a(a);
            return;
        }
    }
}
