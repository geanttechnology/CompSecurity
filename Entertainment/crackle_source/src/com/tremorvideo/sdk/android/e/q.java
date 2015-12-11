// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.e;


// Referenced classes of package com.tremorvideo.sdk.android.e:
//            m

class q extends m
{

    private final boolean a;

    q(boolean flag)
    {
        a = flag;
    }

    public static q a(boolean flag)
    {
        return new q(flag);
    }

    public String a()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("viewable: ");
        String s;
        if (a)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        return stringbuilder.append(s).toString();
    }
}
