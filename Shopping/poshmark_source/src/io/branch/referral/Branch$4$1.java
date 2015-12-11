// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import java.util.TimerTask;

// Referenced classes of package io.branch.referral:
//            Branch

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        Branch.access$902(_fld0, false);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class io/branch/referral/Branch$4

/* anonymous class */
    class Branch._cls4 extends TimerTask
    {

        final Branch this$0;

        public void run()
        {
            (new Thread(new Branch._cls4._cls1())).start();
        }

            
            {
                this$0 = Branch.this;
                super();
            }
    }

}
