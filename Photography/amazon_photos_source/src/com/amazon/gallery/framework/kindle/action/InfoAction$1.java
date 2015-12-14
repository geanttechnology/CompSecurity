// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import com.amazon.gallery.framework.kindle.ui.PhotoInfoDialog;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            InfoAction

class val.photoInfoDialog
    implements Runnable
{

    final InfoAction this$0;
    final PhotoInfoDialog val$photoInfoDialog;

    public void run()
    {
        val$photoInfoDialog.show();
    }

    ()
    {
        this$0 = final_infoaction;
        val$photoInfoDialog = PhotoInfoDialog.this;
        super();
    }
}
