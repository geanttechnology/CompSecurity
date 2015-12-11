// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;


// Referenced classes of package com.target.ui.fragment.mcoupons:
//            CouponAcceptTermsFragment

private static class A
{

    private static final String PRIVACY = "file:///android_asset/htmls/privacy.html";
    private static final String TERMS = "file:///android_asset/htmls/terms.html";

    static String a(int i)
    {
        return b(i);
    }

    private static String b(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("No URL found for key: ").append(i).toString());

        case 2131296930: 
            return "file:///android_asset/htmls/privacy.html";

        case 2131296931: 
            return "file:///android_asset/htmls/terms.html";
        }
    }
}
