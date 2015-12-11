// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;

public final class qv
{

    public static final qv a = new qv();

    private qv()
    {
        new SpannableStringBuilder();
    }

    public qv(String s, dlb dlb, btu btu1, btu btu2)
    {
        b.a(s);
        b.a(dlb);
        byf.a(dlb);
    }

    public qv(String s, String s1, Uri uri)
    {
        if (TextUtils.isEmpty(s))
        {
            new SpannableStringBuilder(s);
        }
        if (uri != null)
        {
            new btu(uri);
        }
    }

}
