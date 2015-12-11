// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui;

import android.os.Handler;
import com.poshmark.ui.fragments.PMFragment;

// Referenced classes of package com.poshmark.ui:
//            PMContainerActivity

class this._cls0
    implements android.support.v4.app.StackChangedListener
{

    final PMContainerActivity this$0;

    public void onBackStackChanged()
    {
        (new Handler()).post(new Runnable() {

            final PMContainerActivity._cls1 this$1;

            public void run()
            {
                PMFragment pmfragment = PMContainerActivity.access$000(this$0);
                if (pmfragment != null)
                {
                    pmfragment.onLoadingComplete();
                }
            }

            
            {
                this$1 = PMContainerActivity._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = PMContainerActivity.this;
        super();
    }
}
