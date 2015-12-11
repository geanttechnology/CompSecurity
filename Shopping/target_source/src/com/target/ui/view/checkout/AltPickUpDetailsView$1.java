// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.target.ui.view.checkout:
//            AltPickUpDetailsView

class this._cls0
    implements android.view.ner
{

    final AltPickUpDetailsView this$0;

    public void onFocusChange(View view, boolean flag)
    {
        while (view.getId() != AltPickUpDetailsView.a(AltPickUpDetailsView.this).emailId.getId() || flag) 
        {
            return;
        }
        AltPickUpDetailsView.a(AltPickUpDetailsView.this, AltPickUpDetailsView.b(AltPickUpDetailsView.this));
    }

    ews()
    {
        this$0 = AltPickUpDetailsView.this;
        super();
    }
}
