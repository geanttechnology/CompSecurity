// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzHA
    implements android.content.nterface.OnClickListener
{

    final JsResult zzHA;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        zzHA.confirm();
    }

    Listener(JsResult jsresult)
    {
        zzHA = jsresult;
        super();
    }
}
