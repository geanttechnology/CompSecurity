// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import java.util.TimerTask;

// Referenced classes of package io.branch.referral:
//            Branch

class this._cls0 extends TimerTask
{

    final Branch this$0;

    public void run()
    {
        (new Thread(new Runnable() {

            final Branch._cls4 this$1;

            public void run()
            {
                Branch.access$902(this$0, false);
            }

            
            {
                this$1 = Branch._cls4.this;
                super();
            }
        })).start();
    }

    _cls1.this._cls1()
    {
        this$0 = Branch.this;
        super();
    }
}
