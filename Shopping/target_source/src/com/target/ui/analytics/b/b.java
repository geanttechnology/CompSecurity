// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.b;

import java.util.Arrays;

// Referenced classes of package com.target.ui.analytics.b:
//            a

public class b extends a
{

    public final String mEventName;
    public final String mExtraInfoField1;
    public final String mExtraInfoField2;
    public final String mExtraInfoField3;
    public final String mExtraInfoField4;
    public final String mExtraInfoField5;
    public final String mStackTrace = c();

    b(String s, String s1, String s2, String s3, String s4, String s5)
    {
        mEventName = s;
        mExtraInfoField1 = s1;
        mExtraInfoField2 = s2;
        mExtraInfoField3 = s3;
        mExtraInfoField4 = s4;
        mExtraInfoField5 = s5;
    }

    public static b b()
    {
        return new b("GUEST_IS_NULL", null, null, null, null, null);
    }

    private static String c()
    {
        return Arrays.toString(Thread.currentThread().getStackTrace());
    }
}
