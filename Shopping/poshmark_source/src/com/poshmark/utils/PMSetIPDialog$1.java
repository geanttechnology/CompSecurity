// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.view.View;
import android.widget.EditText;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.EnvConfig;

// Referenced classes of package com.poshmark.utils:
//            PMSetIPDialog

class this._cls0
    implements android.view.ener
{

    final PMSetIPDialog this$0;

    public void onClick(View view)
    {
        Object obj = (EditText)dialoglayout.findViewById(0x7f0c02a0);
        Object obj2 = (EditText)dialoglayout.findViewById(0x7f0c02a1);
        Object obj1 = (EditText)dialoglayout.findViewById(0x7f0c02a2);
        view = (EditText)dialoglayout.findViewById(0x7f0c02a3);
        obj = ((EditText) (obj)).getText().toString();
        obj2 = ((EditText) (obj2)).getText().toString();
        obj1 = ((EditText) (obj1)).getText().toString();
        view = view.getText().toString();
        if (obj != null && obj2 != null && obj1 != null)
        {
            view = (new StringBuilder()).append("http://").append(((String) (obj))).append(".").append(((String) (obj2))).append(".").append(((String) (obj1))).append(".").append(view).append(":9292").toString();
            EnvConfig.setupDevIP(view);
            PMApplicationSession.GetPMSession().setDevIP(view);
            dismiss();
        }
    }

    ionSession()
    {
        this$0 = PMSetIPDialog.this;
        super();
    }
}
