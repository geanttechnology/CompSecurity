// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import com.groupon.models.inappmessage.InAppMessage;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.view:
//            InAppToast

class this._cls0
    implements android.view.istener
{

    final InAppToast this$0;

    public void onClick(View view)
    {
        try
        {
            InAppToast.access$100(InAppToast.this).logClick("", "in_app_message", "close", InAppToast.access$000(InAppToast.this).getId());
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Ln.e(view);
        }
        InAppToast.access$000(InAppToast.this).onDismissed();
        InAppToast.access$800(InAppToast.this, 0);
    }

    k.Logger()
    {
        this$0 = InAppToast.this;
        super();
    }
}
