// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

// Referenced classes of package com.google.android.gms.d:
//            hj

static final class a
    implements android.content.gInterface.OnCancelListener
{

    final JsPromptResult a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        a.cancel();
    }

    e(JsPromptResult jspromptresult)
    {
        a = jspromptresult;
        super();
    }
}
