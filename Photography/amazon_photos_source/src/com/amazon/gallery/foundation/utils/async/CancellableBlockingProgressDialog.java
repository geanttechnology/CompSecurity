// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.async;

import android.content.Context;
import android.content.DialogInterface;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;

// Referenced classes of package com.amazon.gallery.foundation.utils.async:
//            BlockingProgressDialog

public abstract class CancellableBlockingProgressDialog extends BlockingProgressDialog
{

    public CancellableBlockingProgressDialog(Context context, int i)
    {
        this(context, i, false);
    }

    public CancellableBlockingProgressDialog(Context context, int i, boolean flag)
    {
        super(context, i, flag);
        dialog.setCancelable(true);
        dialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final CancellableBlockingProgressDialog this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                cancel(true);
            }

            
            {
                this$0 = CancellableBlockingProgressDialog.this;
                super();
            }
        });
    }
}
