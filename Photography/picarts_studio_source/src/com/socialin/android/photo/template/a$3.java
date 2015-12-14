// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.app.Activity;
import android.content.DialogInterface;
import com.socialin.android.util.ModernAsyncTask;

// Referenced classes of package com.socialin.android.photo.template:
//            a

final class a
    implements android.content.ogInterface.OnCancelListener
{

    private ModernAsyncTask a;
    private a b;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.cancel(true);
        dialoginterface = b.getActivity();
        if (dialoginterface != null && !dialoginterface.isFinishing())
        {
            dialoginterface.setRequestedOrientation(2);
        }
    }

    k(a a1, ModernAsyncTask modernasynctask)
    {
        b = a1;
        a = modernasynctask;
        super();
    }
}
