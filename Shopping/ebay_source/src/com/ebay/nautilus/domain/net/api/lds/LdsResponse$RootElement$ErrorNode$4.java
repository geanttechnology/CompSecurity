// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.LdsError;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

class this._cls2 extends com.ebay.nautilus.kernel.util.Node._cls4
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        if (cess._mth1600(this._cls2.this).inputRefId == null)
        {
            cess._mth1600(this._cls2.this).inputRefId = s;
        }
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}
