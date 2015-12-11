// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.content.DialogInterface;

// Referenced classes of package com.shazam.android.activities.account:
//            SignUpActivity

final class a
    implements android.content.nCancelListener
{

    final SignUpActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.finish();
    }

    (SignUpActivity signupactivity)
    {
        a = signupactivity;
        super();
    }
}
