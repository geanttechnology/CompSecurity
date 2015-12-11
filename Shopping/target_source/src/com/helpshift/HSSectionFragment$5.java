// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import com.helpshift.i.g;
import java.util.HashMap;

// Referenced classes of package com.helpshift:
//            HSSectionFragment

class a extends Handler
{

    final HSSectionFragment a;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        g.a(((Integer)((HashMap)message.obj).get("status")).intValue(), null, HSSectionFragment.d(a));
    }

    (HSSectionFragment hssectionfragment)
    {
        a = hssectionfragment;
        super();
    }
}
