// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import com.smule.android.console.n;
import com.smule.android.console.o;
import com.smule.pianoandroid.magicpiano.b.j;

public class a
    implements n
{

    public a()
    {
    }

    public String a()
    {
        return "login";
    }

    public String a(String as[])
    {
        if (as != null && as.length == 3)
        {
            (new j(null, null, as[1], as[2])).execute(new Void[0]);
            return "done";
        } else
        {
            return o.a(this);
        }
    }
}
