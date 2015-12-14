// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.content.DialogInterface;
import com.socialin.android.util.an;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements android.content.ogInterface.OnCancelListener
{

    private a a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        if (com.socialin.android.share.a.a(a) != null)
        {
            com.socialin.android.share.a.a(a).cancel(true);
        }
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
