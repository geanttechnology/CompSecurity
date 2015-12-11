// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.i;

import android.content.Intent;
import com.shazam.model.share.ShareData;

public final class a
    implements com.shazam.b.a.a
{

    public a()
    {
    }

    public final Object a(Object obj)
    {
        obj = (ShareData)obj;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", ((ShareData) (obj)).subject);
        intent.putExtra("android.intent.extra.TEXT", ((ShareData) (obj)).text);
        return intent;
    }
}
