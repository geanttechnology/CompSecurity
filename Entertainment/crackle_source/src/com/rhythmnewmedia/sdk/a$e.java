// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;


// Referenced classes of package com.rhythmnewmedia.sdk:
//            a

public static final class c
{

    public String a;
    boolean b;
    public boolean c;

    public static c a(String s)
    {
        return new <init>(s, false, true);
    }

    public (String s, boolean flag, boolean flag1)
    {
        b = true;
        c = true;
        a = s;
        b = flag;
        c = flag1;
    }
}
