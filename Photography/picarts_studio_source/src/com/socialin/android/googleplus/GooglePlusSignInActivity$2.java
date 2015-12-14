// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googleplus;

import android.content.DialogInterface;
import com.socialin.android.d;

// Referenced classes of package com.socialin.android.googleplus:
//            GooglePlusSignInActivity

final class a
    implements android.content.tener
{

    private GooglePlusSignInActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        d.c(new Object[] {
            GooglePlusSignInActivity.a, "Google Play services resolution cancelled"
        });
        GooglePlusSignInActivity.a(a);
    }

    (GooglePlusSignInActivity googleplussigninactivity)
    {
        a = googleplussigninactivity;
        super();
    }
}
