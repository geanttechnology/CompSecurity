// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.spongycastle.asn1.x500.style;

import org.spongycastle.asn1.x500.X500Name;

// Referenced classes of package org.spongycastle.asn1.x500.style:
//            BCStyle

public class BCStrictStyle extends BCStyle
{

    public BCStrictStyle()
    {
    }

    public final boolean a(X500Name x500name, X500Name x500name1)
    {
        x500name = x500name.c();
        x500name1 = x500name1.c();
        if (x500name.length == x500name1.length) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i == x500name.length)
                {
                    break label1;
                }
                if (a(x500name[i], x500name1[i]))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }
}
