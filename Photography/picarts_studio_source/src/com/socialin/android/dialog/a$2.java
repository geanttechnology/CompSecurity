// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dialog;

import android.view.View;

// Referenced classes of package com.socialin.android.dialog:
//            a

final class a
    implements android.view..OnClickListener
{

    private a a;

    public final void onClick(View view)
    {
        try
        {
            a.dismiss();
        }
        catch (IllegalStateException illegalstateexception)
        {
            illegalstateexception.printStackTrace();
        }
        if (com.socialin.android.dialog.a.b(a) != null)
        {
            com.socialin.android.dialog.a.b(a).onClick(view);
        }
    }

    r(a a1)
    {
        a = a1;
        super();
    }
}
