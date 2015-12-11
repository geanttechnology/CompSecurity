// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import org.xml.sax.Attributes;

public final class cbi extends bnt
{

    public cbi()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (ceb)bmz1.peek();
        if (!TextUtils.isEmpty(s))
        {
            bmz1.e = s;
        }
    }
}
