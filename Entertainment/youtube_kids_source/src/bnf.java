// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashSet;

public final class bnf
{

    public final android.net.Uri.Builder a;
    private final HashSet b;

    private bnf(Uri uri)
    {
        a = ((Uri)b.a(uri)).buildUpon();
        b = new HashSet(uri.getQueryParameterNames());
    }

    public static bnf a(Uri uri)
    {
        return new bnf(uri);
    }

    public final bnf a(String s, int i)
    {
        return a(s, String.valueOf(i));
    }

    public final bnf a(String s, String s1)
    {
        if (!b.contains(s))
        {
            b.add(s);
            a.appendQueryParameter(s, s1);
        }
        return this;
    }

    public final bnf a(String s, String s1, String s2)
    {
label0:
        {
            if (!b.contains(s))
            {
                b.add(s);
                s = String.valueOf(Uri.encode(s, null));
                s1 = String.valueOf(Uri.encode(s1, s2));
                s = (new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(s1).length())).append(s).append("=").append(s1).toString();
                s1 = a.build().getEncodedQuery();
                if (TextUtils.isEmpty(s1))
                {
                    break label0;
                }
                a.encodedQuery((new StringBuilder(String.valueOf(s1).length() + 1 + String.valueOf(s).length())).append(s1).append("&").append(s).toString());
            }
            return this;
        }
        a.encodedQuery(s);
        return this;
    }
}
