// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import com.helpshift.f.c;
import com.helpshift.k.a;

// Referenced classes of package com.helpshift:
//            HSAddIssueFragment

class a extends Handler
{

    final HSAddIssueFragment a;

    public void handleMessage(Message message)
    {
        c.b(HSAddIssueFragment.k(a).g, false);
        HSAddIssueFragment.o(a);
        HSAddIssueFragment.m(a);
    }

    (HSAddIssueFragment hsaddissuefragment)
    {
        a = hsaddissuefragment;
        super();
    }
}
