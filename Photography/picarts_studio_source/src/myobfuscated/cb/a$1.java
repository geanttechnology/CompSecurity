// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cb;

import android.content.Context;
import android.content.res.Resources;
import java.util.Comparator;

// Referenced classes of package myobfuscated.cb:
//            a, c

final class it>
    implements Comparator
{

    private a a;

    public final int compare(Object obj, Object obj1)
    {
        obj = (c)obj;
        obj1 = (c)obj1;
        if (!((c) (obj)).e.equals(myobfuscated.cb.a.a(a).getResources().getString(0x7f0800ae))) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        if (((c) (obj1)).e.equals(myobfuscated.cb.a.a(a).getResources().getString(0x7f0800ae)))
        {
            return 1;
        }
        if (((c) (obj)).e.equals(myobfuscated.cb.a.a(a).getResources().getString(0x7f0800b5))) goto _L1; else goto _L3
_L3:
        if (((c) (obj1)).e.equals(myobfuscated.cb.a.a(a).getResources().getString(0x7f0800b5)))
        {
            return 1;
        }
        if (!((c) (obj)).o || !((c) (obj1)).o)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((c) (obj)).k == null && ((c) (obj1)).k == null || ((c) (obj)).k != null && ((c) (obj1)).k != null)
        {
            return 0;
        }
        if (((c) (obj)).k != null) goto _L1; else goto _L4
_L4:
        return 1;
        if (((c) (obj)).o) goto _L1; else goto _L5
_L5:
        return !((c) (obj1)).o ? 0 : 1;
    }

    Resources(a a1)
    {
        a = a1;
        super();
    }
}
