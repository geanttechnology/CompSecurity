// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import com.helpshift.i.o;

// Referenced classes of package com.helpshift:
//            HSAddIssueFragment, l

class a extends Handler
{

    final HSAddIssueFragment a;

    public void handleMessage(Message message)
    {
        HSAddIssueFragment.b(a).r();
        o.b();
    }

    (HSAddIssueFragment hsaddissuefragment)
    {
        a = hsaddissuefragment;
        super();
    }
}
