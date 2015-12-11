// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;

// Referenced classes of package com.target.ui.view.product:
//            PdpDvmView

class es.DvmDataResponse
    implements android.view.istener
{

    final PdpDvmView this$0;
    final DvmDataResponse val$dvmDataResponse;

    public void onClick(View view)
    {
        if (PdpDvmView.a(PdpDvmView.this) == null)
        {
            return;
        } else
        {
            PdpDvmView.a(PdpDvmView.this).a(val$dvmDataResponse);
            return;
        }
    }

    es.DvmDataResponse()
    {
        this$0 = final_pdpdvmview;
        val$dvmDataResponse = DvmDataResponse.this;
        super();
    }
}
