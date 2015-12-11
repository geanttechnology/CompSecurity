// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;


// Referenced classes of package com.groupon:
//            RedirectTracking

public static class nameValue
{

    private String fragment;
    private String nameValue[];
    private String type;

    public String getFragment()
    {
        return fragment;
    }

    public String[] getNameValue()
    {
        return nameValue;
    }

    public String getType()
    {
        return type;
    }

    public transient (String s, String s1, String as[])
    {
        fragment = s;
        type = s1;
        nameValue = as;
    }
}
