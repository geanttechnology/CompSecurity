// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class zzKE
    implements android.content.nterface.OnCancelListener
{

    final JsPromptResult zzKE;

    public final void onCancel(DialogInterface dialoginterface)
    {
        zzKE.cancel();
    }

    lListener(JsPromptResult jspromptresult)
    {
        zzKE = jspromptresult;
        super();
    }
}
