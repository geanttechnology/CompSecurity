// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;

import com.amazon.mShop.platform.Platform;
import java.util.TimerTask;

// Referenced classes of package com.amazon.mShop.feature:
//            Features

class this._cls0 extends TimerTask
{

    final Features this$0;

    public void run()
    {
        Features.access$400(Features.this);
        com.amazon.mShop.platform.ctory.getInstance().invokeLater(new Runnable() {

            final Features._cls2 this$1;

            public void run()
            {
                Features.access$500(this$0);
            }

            
            {
                this$1 = Features._cls2.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = Features.this;
        super();
    }
}
