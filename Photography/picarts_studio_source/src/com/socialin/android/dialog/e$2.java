// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dialog;

import android.view.View;

// Referenced classes of package com.socialin.android.dialog:
//            e

final class a
    implements android.view..OnClickListener
{

    private e a;

    public final void onClick(View view)
    {
        if (e.b(a) != null)
        {
            e.b(a).onClick(view);
        }
        a.dismiss();
    }

    r(e e1)
    {
        a = e1;
        super();
    }
}
