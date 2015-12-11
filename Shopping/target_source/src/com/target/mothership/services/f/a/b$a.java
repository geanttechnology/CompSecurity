// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.f.a;


// Referenced classes of package com.target.mothership.services.f.a:
//            b

protected static class mValue
{

    private String mValue;

    public String a()
    {
        return mValue;
    }

    public String b()
    {
        return String.format("{%s}", new Object[] {
            mValue
        });
    }

    public (String s)
    {
        mValue = s;
    }
}
