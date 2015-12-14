// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.googleplus;

import android.content.DialogInterface;

// Referenced classes of package com.socialin.android.googleplus:
//            GooglePlusSignInActivity

final class a
    implements android.content.tener
{

    private GooglePlusSignInActivity a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.finish();
    }

    (GooglePlusSignInActivity googleplussigninactivity)
    {
        a = googleplussigninactivity;
        super();
    }
}
