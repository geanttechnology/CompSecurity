// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.helpshift:
//            HSSectionFragment, ab

class a extends Handler
{

    final HSSectionFragment a;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        message = (ab)message.obj;
        HSSectionFragment.a(a, message);
    }

    (HSSectionFragment hssectionfragment)
    {
        a = hssectionfragment;
        super();
    }
}
