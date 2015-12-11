// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;

import com.amazon.mShop.platform.Platform;
import java.util.TimerTask;

// Referenced classes of package com.amazon.mShop.feature:
//            Features

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        Features.access$500(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/feature/Features$2

/* anonymous class */
    class Features._cls2 extends TimerTask
    {

        final Features this$0;

        public void run()
        {
            Features.access$400(Features.this);
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Features._cls2._cls1());
        }

            
            {
                this$0 = Features.this;
                super();
            }
    }

}
