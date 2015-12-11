// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import android.content.DialogInterface;

// Referenced classes of package com.comcast.cim.android.authentication:
//            AuthenticationAsyncTask, AuthenticationActivity

static final class val.activity
    implements android.content.stener
{

    final AuthenticationActivity val$activity;

    public void onCancel(DialogInterface dialoginterface)
    {
        val$activity.hideSigningInSpinner();
    }

    (AuthenticationActivity authenticationactivity)
    {
        val$activity = authenticationactivity;
        super();
    }
}
