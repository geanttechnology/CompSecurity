// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.HashSet;

// Referenced classes of package com.paypal.android.sdk:
//            ct

final class cu extends HashSet
{

    cu()
    {
        ct act[] = ct.values();
        int j = act.length;
        for (int i = 0; i < j; i++)
        {
            add(act[i].a());
        }

    }
}
