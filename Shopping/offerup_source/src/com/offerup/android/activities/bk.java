// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import android.support.v4.e.a;
import com.offerup.android.utils.n;

// Referenced classes of package com.offerup.android.activities:
//            br, ChatActivity

final class bk
    implements android.content.DialogInterface.OnClickListener
{

    private android.app.AlertDialog.Builder a;
    private ChatActivity b;

    bk(ChatActivity chatactivity, android.app.AlertDialog.Builder builder)
    {
        b = chatactivity;
        a = builder;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (android.support.v4.e.a.b(b))
        {
            b.a(new br(b, b), new Object[0]);
            return;
        } else
        {
            n.a(a);
            return;
        }
    }
}
