// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googleplus;

import android.content.DialogInterface;
import com.socialin.android.d;

// Referenced classes of package com.socialin.android.googleplus:
//            GooglePlusSignInActivity

final class a
    implements android.content.ener
{

    private int a;
    private GooglePlusSignInActivity b;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        d.c(new Object[] {
            GooglePlusSignInActivity.a, (new StringBuilder("Google Play services error could not be resolved: ")).append(a).toString()
        });
        GooglePlusSignInActivity.a(b);
    }

    (GooglePlusSignInActivity googleplussigninactivity, int i)
    {
        b = googleplussigninactivity;
        a = i;
        super();
    }
}
