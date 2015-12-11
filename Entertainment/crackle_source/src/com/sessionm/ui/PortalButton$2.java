// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.ui;

import android.view.View;
import com.sessionm.api.Activity;
import com.sessionm.core.f;
import java.util.Locale;

// Referenced classes of package com.sessionm.ui:
//            PortalButton, ButtonManager

class this._cls0
    implements android.view.tener
{

    final PortalButton this$0;

    public void onClick(View view)
    {
        ButtonManager.getInstance().buttonPressed();
        view = f.E().F();
        view = String.format(Locale.US, "apps/%s/portal?origin=portal_button&z=%d", new Object[] {
            view, Long.valueOf(System.currentTimeMillis())
        });
        f.E().b(new Activity(com.sessionm.api.tyType.PORTAL), new Object[] {
            view
        });
    }

    ityType()
    {
        this$0 = PortalButton.this;
        super();
    }
}
