// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            kb, lh, jv, kg, 
//            ka

class it>
    implements kb
{

    final lh a;

    public void a(jv jv1)
    {
        switch (a[jv1.b.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            kg.a(3, lh.h(), (new StringBuilder()).append("Automatic onStartSession for context:").append(jv1.a).toString());
            lh.a(a, jv1.a);
            return;

        case 2: // '\002'
            kg.a(3, lh.h(), (new StringBuilder()).append("Automatic onEndSession for context:").append(jv1.a).toString());
            a.d(jv1.a);
            return;

        case 3: // '\003'
            kg.a(3, lh.h(), (new StringBuilder()).append("Automatic onEndSession (destroyed) for context:").append(jv1.a).toString());
            break;
        }
        a.d(jv1.a);
    }

    public volatile void a(ka ka)
    {
        a((jv)ka);
    }

    der(lh lh1)
    {
        a = lh1;
        super();
    }
}
