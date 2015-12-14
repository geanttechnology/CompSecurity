// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.preference;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.preference:
//            e

final class a
    implements android.content.ogInterface.OnCancelListener
{

    private e a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.getActivity().finish();
    }

    ncelListener(e e1)
    {
        a = e1;
        super();
    }
}
