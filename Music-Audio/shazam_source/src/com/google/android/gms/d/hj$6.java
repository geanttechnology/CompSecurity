// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

// Referenced classes of package com.google.android.gms.d:
//            hj

static final class b
    implements android.content.gInterface.OnClickListener
{

    final JsPromptResult a;
    final EditText b;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        a.confirm(b.getText().toString());
    }

    e(JsPromptResult jspromptresult, EditText edittext)
    {
        a = jspromptresult;
        b = edittext;
        super();
    }
}
