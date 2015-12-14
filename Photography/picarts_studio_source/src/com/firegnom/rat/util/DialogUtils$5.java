// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.firegnom.rat.util;

import android.app.Dialog;

// Referenced classes of package com.firegnom.rat.util:
//            DialogUtils

final class val.dialog
    implements Runnable
{

    final Dialog val$dialog;

    public final void run()
    {
        try
        {
            val$dialog.dismiss();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    ()
    {
        val$dialog = dialog1;
        super();
    }
}
