// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            ChatActivity

final class bj
    implements android.view.View.OnClickListener
{

    private ChatActivity a;

    bj(ChatActivity chatactivity)
    {
        a = chatactivity;
        super();
    }

    public final void onClick(View view)
    {
        ChatActivity.a(a);
    }
}
