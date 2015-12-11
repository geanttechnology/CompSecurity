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

class lback extends BusinessSpecialLoaderCallback
{

    final BusinessSpecialPage this$0;

    public void onBusinessSpecialLoaded(Special special)
    {
        BusinessSpecialPage.access$002(BusinessSpecialPage.this, special);
        progressBar.postDelayed(new Runnable() {

            final BusinessSpecialPage._cls1 this$1;

            public void run()
            {
                BusinessSpecialPage.access$100(this$0);
            }

            
            {
                this$1 = BusinessSpecialPage._cls1.this;
                super();
            }
        }, 500L);
        BusinessSpecialPage.access$200(BusinessSpecialPage.this);
    }

    _cls1.this._cls1(Context context, String s)
    {
        this$0 = BusinessSpecialPage.this;
        super(context, s);
    }
}
