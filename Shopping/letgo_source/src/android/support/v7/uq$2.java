// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.DialogInterface;
import android.webkit.JsResult;

// Referenced classes of package android.support.v7:
//            uq

static final class a
    implements android.content.gInterface.OnClickListener
{

    final JsResult a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        a.cancel();
    }

    terface(JsResult jsresult)
    {
        a = jsresult;
        super();
    }
}
