// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import com.b.a.a.h;

// Referenced classes of package com.offerup.android.activities:
//            ChatActivity, a

final class bq
    implements android.view.View.OnClickListener
{

    private ChatActivity a;

    bq(ChatActivity chatactivity)
    {
        a = chatactivity;
        super();
    }

    public final void onClick(View view)
    {
        ChatActivity.b(a);
        a.l.a();
        a.f.i();
    }
}
