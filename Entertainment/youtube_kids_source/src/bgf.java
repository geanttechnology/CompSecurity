// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bgf
{

    private static final Pattern a = Pattern.compile("^NO_MATCH_REGEX$");
    private final Pattern b;
    private final cpz c;
    private final cpz d;
    private final bmi e;

    public bgf(cpz cpz1, cpz cpz2, Pattern pattern, bmi bmi1)
    {
        c = (cpz)b.a(cpz1);
        d = (cpz)b.a(cpz2);
        cpz1 = pattern;
        if (pattern == null)
        {
            cpz1 = a;
        }
        b = cpz1;
        e = (bmi)b.a(bmi1);
    }

    public final cqd a(Uri uri, String s)
    {
        if (b.matcher(uri.toString()).find())
        {
            cpz cpz1 = c;
            s = cpz.a(s, 0x37046bc);
        } else
        {
            cpz cpz2 = d;
            s = cpz.a(s, 0x37046bc);
        }
        return s.a(uri);
    }

    public final void a(cqd cqd1, mj mj)
    {
        if (b.matcher(cqd1.c.toString()).find())
        {
            c.a(cqd1, mj);
            return;
        }
        Uri uri = cqd1.c;
        boolean flag;
        if (uri.getHost() != null && (uri.getHost().endsWith(".doubleclick.net") || TextUtils.equals(uri.getHost(), "doubleclick.net")))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && cqd1.d)
        {
            cqd1.a(cqd1.c.buildUpon().appendQueryParameter("ts", String.valueOf(e.a() / 1000L)).build());
        }
        d.a(cqd1, mj);
    }

}
