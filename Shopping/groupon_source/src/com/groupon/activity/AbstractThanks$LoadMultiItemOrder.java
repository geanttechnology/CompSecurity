// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.MultiItemOrder;
import com.groupon.models.MultiItemOrderItem;
import com.groupon.util.Function1;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            AbstractThanks

protected class this._cls0
    implements Function1
{

    final AbstractThanks this$0;

    public void execute(MultiItemOrder multiitemorder)
    {
        if (multiitemorder != null && !multiitemorder.items.isEmpty())
        {
            multiitemorder = ((MultiItemOrderItem)multiitemorder.items.get(0)).legacyOrderId;
            if (Strings.notEmpty(multiitemorder))
            {
                AbstractThanks.access$000(AbstractThanks.this, multiitemorder);
            }
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((MultiItemOrder)obj);
    }

    protected ()
    {
        this$0 = AbstractThanks.this;
        super();
    }
}
