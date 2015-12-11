// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;

// Referenced classes of package com.offerup.android.activities:
//            bs, ChatActivity

final class bt
    implements android.content.DialogInterface.OnClickListener
{

    private bs a;

    bt(bs bs1)
    {
        a = bs1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        ChatActivity.a(a.a);
    }
}
