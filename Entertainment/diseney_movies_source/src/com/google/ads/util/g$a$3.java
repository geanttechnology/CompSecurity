// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;

import android.content.DialogInterface;
import android.webkit.JsResult;

// Referenced classes of package com.google.ads.util:
//            g

static final class a
    implements android.content.Interface.OnClickListener
{

    final JsResult a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        a.confirm();
    }

    rface(JsResult jsresult)
    {
        a = jsresult;
        super();
    }
}
