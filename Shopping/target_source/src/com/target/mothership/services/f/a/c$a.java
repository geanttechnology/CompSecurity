// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.f.a;

import com.target.mothership.services.f.b.a;
import com.target.mothership.util.o;

// Referenced classes of package com.target.mothership.services.f.a:
//            c

public static class <init>
{

    private static final String AMPERSAND = "&";
    private static final String EQUALS = "=";
    private static final String QUESTION_MARK = "?";
    private final StringBuilder mUrlBuilder;

    private void c(String s, String s1)
    {
        StringBuilder stringbuilder = mUrlBuilder;
        String s2;
        if (mUrlBuilder.indexOf("?") == -1)
        {
            s2 = "?";
        } else
        {
            s2 = "&";
        }
        stringbuilder.append(s2);
        mUrlBuilder.append(s);
        mUrlBuilder.append("=");
        mUrlBuilder.append(s1);
    }

    public mUrlBuilder a(String s, String s1)
    {
        if (mUrlBuilder.length() != 0)
        {
            int i = s.length();
            int j = mUrlBuilder.indexOf(s);
            if (j != -1)
            {
                s = s1;
                if (s1 == null)
                {
                    s = "";
                }
                mUrlBuilder.replace(j, i + j, s);
                return this;
            }
        }
        return this;
    }

    public mUrlBuilder b(String s, String s1)
    {
        if (mUrlBuilder.length() == 0 || s == null || s1 == null || !o.g(s1))
        {
            return this;
        } else
        {
            c(s, s1);
            return this;
        }
    }

    public String toString()
    {
        return mUrlBuilder.toString();
    }

    private (c c1, a a1)
    {
        c1 = (new StringBuilder()).append(a1.a(c1.host)).append(c1.path).toString();
        if (c1 == null)
        {
            c1 = "";
        }
        mUrlBuilder = new StringBuilder(c1);
    }

    mUrlBuilder(c c1, a a1, mUrlBuilder murlbuilder)
    {
        this(c1, a1);
    }

    private <init>(String s)
    {
        if (s == null)
        {
            s = "";
        }
        mUrlBuilder = new StringBuilder(s);
    }

    mUrlBuilder(String s, mUrlBuilder murlbuilder)
    {
        this(s);
    }
}
