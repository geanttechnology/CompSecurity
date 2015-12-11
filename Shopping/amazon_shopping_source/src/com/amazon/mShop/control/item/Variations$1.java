// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.rio.j2me.client.services.mShop.Dimension;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.item:
//            Variations

class this._cls0
    implements tributeFetcher
{

    final Variations this$0;

    public List getAttributes(int i)
    {
        return Variations.access$100(Variations.this)[i].getSwatches();
    }

    imension()
    {
        this$0 = Variations.this;
        super();
    }
}
