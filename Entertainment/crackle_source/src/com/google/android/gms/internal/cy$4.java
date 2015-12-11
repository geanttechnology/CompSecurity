// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

// Referenced classes of package com.google.android.gms.internal:
//            cy

static final class je
    implements android.content.gInterface.OnCancelListener
{

    final JsPromptResult je;

    public void onCancel(DialogInterface dialoginterface)
    {
        je.cancel();
    }

    celListener(JsPromptResult jspromptresult)
    {
        je = jspromptresult;
        super();
    }
}
