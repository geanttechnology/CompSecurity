// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.ProgressDialog;

// Referenced classes of package com.groupon.util:
//            Function0, ShareHelper

class val.dialog
    implements Function0
{

    final ShareHelper this$0;
    final ProgressDialog val$dialog;

    public void execute()
    {
        val$dialog.show();
    }

    ()
    {
        this$0 = final_sharehelper;
        val$dialog = ProgressDialog.this;
        super();
    }
}
