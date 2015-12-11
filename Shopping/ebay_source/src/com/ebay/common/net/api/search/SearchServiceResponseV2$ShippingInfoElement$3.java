// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

class this._cls1 extends com.ebay.nautilus.kernel.util.
{

    final em this$1;

    public void text(String s)
        throws SAXException
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 40
    //                   -287833887: 83
    //                   -256988515: 69
    //                   1000546144: 97;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_97;
_L5:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            em.isInStorePickup = true;
            return;

        case 1: // '\001'
            em.isEbn = true;
            return;

        case 2: // '\002'
            em.isPickupAndDropOff = true;
            break;
        }
        break MISSING_BLOCK_LABEL_146;
_L3:
        if (s.equals("StorePickup"))
        {
            byte0 = 0;
        }
          goto _L5
_L2:
        if (s.equals("EbayNow"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("LockerPickupOptionAvailable"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
