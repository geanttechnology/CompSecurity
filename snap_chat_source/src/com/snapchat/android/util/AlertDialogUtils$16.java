// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.snapchat.android.util;

import android.widget.Toast;

// Referenced classes of package com.snapchat.android.util:
//            AlertDialogUtils

static final class 
    implements Runnable
{

    public final void run()
    {
        if (AlertDialogUtils.b() != null)
        {
            AlertDialogUtils.b().cancel();
        }
    }

    ()
    {
    }
}
