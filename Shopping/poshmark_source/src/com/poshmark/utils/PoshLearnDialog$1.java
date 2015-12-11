// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.view.View;
import com.poshmark.controllers.GlobalPartiesController;

// Referenced classes of package com.poshmark.utils:
//            PoshLearnDialog

class this._cls0
    implements android.view.er
{

    final PoshLearnDialog this$0;

    public void onClick(View view)
    {
        GlobalPartiesController.getGlobalPartiesController().enablePartyAlerts();
        dismiss();
    }

    sController()
    {
        this$0 = PoshLearnDialog.this;
        super();
    }
}
