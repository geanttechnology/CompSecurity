// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            a, dd, dy, dr, 
//            ew, cx, dv, de

public final class cv
{

    private static boolean c;
    private a a;
    private String b;

    public cv(a a1, String s)
    {
        if (!c && a1 == null)
        {
            throw new AssertionError();
        } else
        {
            a = a1;
            b = (new StringBuilder("com.paypal.android.sdk.encr.")).append(s).append(".").toString();
            return;
        }
    }

    public final dy a(String s)
    {
        Object obj = a.a((new StringBuilder()).append(b).append("tokenizedRedactedCardNumber").toString());
        String s1 = a.a((new StringBuilder()).append(b).append("token").toString());
        String s2 = a.a((new StringBuilder()).append(b).append("tokenPayerID").toString());
        String s3 = a.a((new StringBuilder()).append(b).append("tokenValidUntil").toString());
        String s4 = a.a((new StringBuilder()).append(b).append("tokenizedCardType").toString());
        String s5 = a.a((new StringBuilder()).append(b).append("tokenizedCardExpiryMonth").toString());
        int i;
        int j;
        if (s5 != null)
        {
            i = Integer.parseInt(s5);
        } else
        {
            i = 0;
        }
        s5 = a.a((new StringBuilder()).append(b).append("tokenizedCardExpiryYear").toString());
        if (s5 != null)
        {
            j = Integer.parseInt(s5);
        } else
        {
            j = 0;
        }
        s5 = a.c(a.a((new StringBuilder()).append(b).append("tokenClientId").toString()));
        if (dd.b(s5) || !s5.equals(s))
        {
            s = null;
        } else
        {
            obj = new dy(s1, s2, s3, ((String) (obj)), s4, i, j);
            s = ((String) (obj));
            if (!((dy) (obj)).b())
            {
                return null;
            }
        }
        return s;
    }

    public final void a()
    {
        Object obj = null;
        dr dr1 = new dr();
        String s;
        if (dr1.a() != null)
        {
            s = dr1.a().b();
        } else
        {
            s = null;
        }
        a.a((new StringBuilder()).append(b).append("loginPhoneNumber").toString(), s);
        a.a((new StringBuilder()).append(b).append("loginEmail").toString(), dr1.b());
        s = obj;
        if (dr1.c() != null)
        {
            s = dr1.c().toString();
        }
        a.a((new StringBuilder()).append(b).append("loginTypePrevious").toString(), s);
    }

    public final void a(dy dy1, String s)
    {
        Object obj = null;
        a.a((new StringBuilder()).append(b).append("token").toString(), dy1.e());
        a.a((new StringBuilder()).append(b).append("tokenPayerID").toString(), dy1.a());
        String s1;
        if (dy1.c() != null)
        {
            s1 = (new dv()).format(dy1.c());
        } else
        {
            s1 = null;
        }
        a.a((new StringBuilder()).append(b).append("tokenValidUntil").toString(), s1);
        a.a((new StringBuilder()).append(b).append("tokenizedRedactedCardNumber").toString(), dy1.d());
        s1 = obj;
        if (dy1.h() != null)
        {
            s1 = dy1.h().toString();
        }
        a.a((new StringBuilder()).append(b).append("tokenizedCardType").toString(), s1);
        a.a((new StringBuilder()).append(b).append("tokenizedCardExpiryMonth").toString(), String.valueOf(dy1.f()));
        a.a((new StringBuilder()).append(b).append("tokenizedCardExpiryYear").toString(), String.valueOf(dy1.g()));
        a.a((new StringBuilder()).append(b).append("tokenClientId").toString(), a.b(s));
    }

    public final void b()
    {
        a(new dy(), null);
    }

    static 
    {
        boolean flag;
        if (!com/paypal/android/sdk/cv.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
    }
}
