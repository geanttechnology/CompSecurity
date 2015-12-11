// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.widget.ProgressBar;
import com.groupon.db.models.Special;
import com.groupon.loader.BusinessSpecialLoaderCallback;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        BusinessSpecialPage.access$100(_fld0);
    }

    ack()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/BusinessSpecialPage$1

/* anonymous class */
    class BusinessSpecialPage._cls1 extends BusinessSpecialLoaderCallback
    {

        final BusinessSpecialPage this$0;

        public void onBusinessSpecialLoaded(Special special)
        {
            BusinessSpecialPage.access$002(BusinessSpecialPage.this, special);
            progressBar.postDelayed(new BusinessSpecialPage._cls1._cls1(), 500L);
            BusinessSpecialPage.access$200(BusinessSpecialPage.this);
        }

            
            {
                this$0 = BusinessSpecialPage.this;
                super(context, s);
            }
    }

}
