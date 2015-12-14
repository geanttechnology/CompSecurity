// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dialog;

import android.app.DialogFragment;
import com.socialin.android.apiv3.util.UserSession;

public class d extends DialogFragment
{

    public d()
    {
    }

    public void onPause()
    {
        super.onPause();
        UserSession.getInstance(getActivity()).stopSession();
    }

    public void onResume()
    {
        super.onResume();
        UserSession.getInstance(getActivity()).startSession();
    }
}
