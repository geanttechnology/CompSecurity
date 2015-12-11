// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.app.Service;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.google.userfeedback.android.api:
//            SendUserFeedbackService, UserFeedbackReportBuilder, UserFeedbackReport

class val.thisService
    implements Runnable
{

    final SendUserFeedbackService this$0;
    final UserFeedbackReport val$report;
    final Service val$thisService;

    private void cleanup(File file)
    {
        if (file != null)
        {
            showToast(SendUserFeedbackService.access$000(SendUserFeedbackService.this));
            file.delete();
            val$thisService.stopSelf();
        }
    }

    public void run()
    {
        File file;
        File file1;
        Object obj;
        Object obj1;
        UserFeedbackReportBuilder userfeedbackreportbuilder;
        Looper.prepare();
        userfeedbackreportbuilder = new UserFeedbackReportBuilder(mSpec);
        obj1 = null;
        obj = null;
        file1 = ((File) (obj));
        file = obj1;
        val$report.setSubmitted(true);
        file1 = ((File) (obj));
        file = obj1;
        obj = userfeedbackreportbuilder.getFormattedFeedbackReport(val$report);
        int i = 0;
_L10:
        if (i >= 3) goto _L2; else goto _L1
_L1:
        file1 = ((File) (obj));
        file = ((File) (obj));
        int j = sendReport(((File) (obj))) / 100;
        if (j != 2) goto _L4; else goto _L3
_L3:
        file1 = ((File) (obj));
        file = ((File) (obj));
        SendUserFeedbackService.access$002(SendUserFeedbackService.this, ent);
_L2:
        file1 = ((File) (obj));
        file = ((File) (obj));
        cleanup(((File) (obj)));
        cleanup(((File) (obj)));
_L7:
        Looper.loop();
        return;
_L4:
        if (j == 5)
        {
            i++;
            continue; /* Loop/switch isn't completed */
        }
          goto _L2
        IOException ioexception;
        ioexception;
        file = file1;
        ioexception = String.valueOf(ioexception.getMessage());
        file = file1;
        if (ioexception.length() == 0) goto _L6; else goto _L5
_L5:
        file = file1;
        ioexception = "IOException: ".concat(ioexception);
_L8:
        file = file1;
        Log.e("GFEEDBACK", ioexception);
        cleanup(file1);
          goto _L7
_L6:
        file = file1;
        ioexception = new String("IOException: ");
          goto _L8
        Exception exception;
        exception;
        cleanup(file);
        throw exception;
        if (true) goto _L10; else goto _L9
_L9:
    }

    ()
    {
        this$0 = final_senduserfeedbackservice;
        val$report = userfeedbackreport;
        val$thisService = Service.this;
        super();
    }
}
