// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.app.AlertDialog;
import android.view.View;

// Referenced classes of package com.poshmark.utils:
//            ReportUserDialog

class this._cls0
    implements android.view.r
{

    final ReportUserDialog this$0;

    public void onClick(View view)
    {
        listener.reasonPicked((String)view.getTag());
        dialog.hide();
    }

    portReasonListener()
    {
        this$0 = ReportUserDialog.this;
        super();
    }
}
