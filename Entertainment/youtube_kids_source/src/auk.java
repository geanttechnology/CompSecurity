// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

final class auk extends auq
{

    private String a;

    auk(aug aug, String s)
    {
        a = s;
        super();
    }

    protected final void a(awb awb)
    {
        awb = (azh)awb;
        if (TextUtils.isEmpty(a))
        {
            a(2001, "IllegalArgument: sessionId cannot be null or empty");
            return;
        }
        try
        {
            awb.a(a, this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (awb awb)
        {
            a(2001);
        }
    }
}
