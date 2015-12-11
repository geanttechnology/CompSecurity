// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.util.ArrayList;

// Referenced classes of package com.apprupt.sdk:
//            Q

class it>
    implements Runnable
{

    final Q this$0;
    final ilureHandler val$handler;

    public void run()
    {
        if (Q.access$400(Q.this))
        {
            val$handler.onFailure(Q.access$700(Q.this), Q.access$600(Q.this));
            return;
        } else
        {
            Q.access$800(Q.this).add(val$handler);
            return;
        }
    }

    ilureHandler()
    {
        this$0 = final_q;
        val$handler = ilureHandler.this;
        super();
    }
}
