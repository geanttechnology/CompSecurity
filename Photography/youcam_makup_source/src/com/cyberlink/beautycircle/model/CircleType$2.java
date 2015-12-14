// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            CircleType

final class  extends j
{

    protected d a(Void void1)
    {
        d d1 = (d)CircleType.a(Integer.valueOf(0), Integer.valueOf(20)).d();
        int i;
        i = 0;
        void1 = null;
_L9:
        Void void2 = void1;
        if (d1 == null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = d1.b;
        void2 = void1;
        if (arraylist == null) goto _L2; else goto _L3
_L3:
        if (void1 != null) goto _L5; else goto _L4
_L4:
        void1 = d1;
_L7:
        Exception exception;
        int k;
        int l;
        try
        {
            if (d1.b.size() < 20)
            {
                break; /* Loop/switch isn't completed */
            }
            k = ((d) (void1)).b.size();
            l = ((d) (void1)).a.intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k < l)
        {
            break; /* Loop/switch isn't completed */
        }
        void2 = void1;
_L2:
        return void2;
_L5:
        ((d) (void1)).b.addAll(d1.b);
        void1.a = d1.a;
        if (true) goto _L7; else goto _L6
_L6:
        i += 20;
        d1 = (d)CircleType.a(Integer.valueOf(i), Integer.valueOf(20)).d();
        if (true) goto _L9; else goto _L8
        exception;
        void1 = null;
_L10:
        exception.printStackTrace();
        return void1;
        exception;
        if (true) goto _L10; else goto _L8
_L8:
        return void1;
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    ()
    {
    }
}
