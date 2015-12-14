// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.firegnom.rat;

import android.app.DialogFragment;
import android.view.View;
import android.widget.TextView;
import com.socialin.android.apiv3.exception.CrashLog;
import com.socialin.android.dialog.c;

// Referenced classes of package com.firegnom.rat:
//            ExceptionActivity

class this._cls0
    implements c
{

    final ExceptionActivity this$0;

    public void onViewCreated(View view, DialogFragment dialogfragment)
    {
        ((TextView)view.findViewById(0x7f1004cb)).setText(ExceptionActivity.access$000(ExceptionActivity.this).appVersion);
        ((TextView)view.findViewById(0x7f1004cc)).setText(ExceptionActivity.access$000(ExceptionActivity.this).osVersion);
        ((TextView)view.findViewById(0x7f1004cd)).setText(ExceptionActivity.access$000(ExceptionActivity.this).appPackage);
        ((TextView)view.findViewById(0x7f1004ce)).setText(ExceptionActivity.access$000(ExceptionActivity.this).phoneModel);
        ((TextView)view.findViewById(0x7f1004cf)).setText(ExceptionActivity.access$000(ExceptionActivity.this).crashId);
        ((TextView)view.findViewById(0x7f1004d0)).setText(ExceptionActivity.access$000(ExceptionActivity.this).stacktrace);
    }

    CrashLog()
    {
        this$0 = ExceptionActivity.this;
        super();
    }
}
