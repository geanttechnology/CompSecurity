// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;

// Referenced classes of package com.offerup.android.activities:
//            ChatActivity

final class bi
    implements android.content.DialogInterface.OnClickListener
{

    private ChatActivity a;

    bi(ChatActivity chatactivity)
    {
        a = chatactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        ChatActivity.d(a);
    }
}
