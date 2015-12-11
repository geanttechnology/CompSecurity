// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.rio.j2me.client.services.ServiceCall;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.account:
//            OneClickController, OneClickListener

class val.value
    implements Runnable
{

    final OneClickController this$0;
    final ServiceCall val$sc;
    final Boolean val$value;

    public void run()
    {
        if (OneClickController.access$700(OneClickController.this, val$sc))
        {
            OneClickController.access$800(OneClickController.this);
            OneClickController.access$900(OneClickController.this, val$value);
            OneClickController.access$300(OneClickController.this).onSaveOneClickStatus(val$value.booleanValue());
            for (Iterator iterator = (new ArrayList(OneClickController.access$1000())).iterator(); iterator.hasNext(); ((OneClickListener)iterator.next()).oneClickStatusChanged(val$value.booleanValue())) { }
        }
    }

    eClickSubscriber()
    {
        this$0 = final_oneclickcontroller;
        val$sc = servicecall;
        val$value = Boolean.this;
        super();
    }
}
