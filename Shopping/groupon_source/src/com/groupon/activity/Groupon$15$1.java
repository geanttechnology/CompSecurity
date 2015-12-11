// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.Function2;
import com.groupon.util.LoaderCallbacksUtil;

// Referenced classes of package com.groupon.activity:
//            Groupon, IntentFactory

class this._cls1
    implements Function2
{

    final h this$1;

    public volatile void execute(Object obj, Object obj1)
        throws Exception
    {
        execute((Runnable)obj, (Exception)obj1);
    }

    public void execute(Runnable runnable, Exception exception)
    {
        startActivity(Groupon.access$500(_fld0).newMyGrouponsIntent(myGrouponsTabPosition));
        finish();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/Groupon$15

/* anonymous class */
    class Groupon._cls15
        implements Function2
    {

        final Groupon this$0;

        public volatile void execute(Object obj, Object obj1)
            throws Exception
        {
            execute((Runnable)obj, (Exception)obj1);
        }

        public void execute(Runnable runnable, Exception exception)
        {
            LoaderCallbacksUtil.showGenericErrorMessage(runnable, exception, Groupon.access$1000(Groupon.this), Groupon.access$800(Groupon.this), universalSyncManager, null, new Groupon._cls15._cls1());
        }

            
            {
                this$0 = Groupon.this;
                super();
            }
    }

}
