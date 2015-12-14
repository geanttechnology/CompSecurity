// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.async;

import android.content.DialogInterface;

// Referenced classes of package com.amazon.gallery.foundation.utils.async:
//            CancellableBlockingProgressDialog

class this._cls0
    implements android.content.eBlockingProgressDialog._cls1
{

    final CancellableBlockingProgressDialog this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        cancel(true);
    }

    ()
    {
        this$0 = CancellableBlockingProgressDialog.this;
        super();
    }
}
