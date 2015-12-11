// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.models.MarkUsedData;
import com.groupon.util.Function1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            Redeem

class this._cls0
    implements Function1
{

    final Redeem this$0;

    public void execute(MarkUsedData markuseddata)
    {
        Ln.d("BARCODE: mark used success, got %s", new Object[] {
            markuseddata.toString()
        });
        Redeem.access$000(Redeem.this).barcodeImageUrl = markuseddata.barcodeImageUrl;
        Redeem.access$000(Redeem.this).redemptionCode = markuseddata.redemptionCode;
        Redeem.access$000(Redeem.this).remoteId = markuseddata.id;
        Redeem.access$000(Redeem.this).printedAt = markuseddata.printedAt;
        Redeem.access$1600(Redeem.this);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((MarkUsedData)obj);
    }

    a()
    {
        this$0 = Redeem.this;
        super();
    }
}
