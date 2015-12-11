// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;

// Referenced classes of package com.offerup.android.activities:
//            hn, SendMessageActivity

final class ho
    implements android.content.DialogInterface.OnClickListener
{

    private hn a;

    ho(hn hn1)
    {
        a = hn1;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        SendMessageActivity.a(a.a);
    }
}
