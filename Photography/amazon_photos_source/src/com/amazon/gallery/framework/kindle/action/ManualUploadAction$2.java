// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.widget.Toast;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            ManualUploadAction

class val.messageId
    implements Runnable
{

    final ManualUploadAction this$0;
    final int val$messageId;

    public void run()
    {
        Toast.makeText(ManualUploadAction.access$400(ManualUploadAction.this), val$messageId, 0).show();
    }

    ()
    {
        this$0 = final_manualuploadaction;
        val$messageId = I.this;
        super();
    }
}
