// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private final class nit> extends com.ebay.nautilus.kernel.util.
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 40
    //                   -1803461041: 97
    //                   -1534621073: 83
    //                   -1072845520: 69;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_97;
_L5:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            this._cls1.this.<init>._fld1 = 1;
            return;

        case 1: // '\001'
            _fld1._fld1 = 2;
            return;

        case 2: // '\002'
            _fld1._fld1 = 3;
            break;
        }
        break MISSING_BLOCK_LABEL_146;
_L4:
        if (s.equals("Application"))
        {
            byte0 = 0;
        }
          goto _L5
_L3:
        if (s.equals("Request"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("System"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    private ()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
