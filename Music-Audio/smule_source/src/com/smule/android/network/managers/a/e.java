// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers.a;

import android.content.Context;
import com.smule.android.network.managers.n;
import java.lang.reflect.Field;

// Referenced classes of package com.smule.android.network.managers.a:
//            c, a, b

public class e
    implements c
{

    private n a;
    private Context b;

    public e()
    {
    }

    public Object a(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        Object obj1;
        return obj;
_L2:
        String s;
        Field afield1[];
        int i;
        int j;
        if ((obj1 = (a)obj.getClass().getAnnotation(com/smule/android/network/managers/a/a)) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = ((a) (obj1)).a();
        obj1 = null;
        afield1 = obj.getClass().getDeclaredFields();
        j = afield1.length;
        i = 0;
_L4:
        Object obj2;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = afield1[i];
        if ((b)((Field) (obj2)).getAnnotation(com/smule/android/network/managers/a/b) == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        obj2 = (String)((Field) (obj2)).get(obj);
        obj1 = obj2;
_L5:
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
          goto _L5
        if (obj1 == null) goto _L1; else goto _L6
_L6:
        Field afield[];
        afield = obj.getClass().getDeclaredFields();
        j = afield.length;
        i = 0;
_L8:
        Field field;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        field = afield[i];
        String s1 = a.a(s, ((String) (obj1)), field.getName());
        if (s1 != null)
        {
            try
            {
                field.set(obj, s1);
            }
            catch (IllegalAccessException illegalaccessexception1) { }
        }
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L1; else goto _L9
_L9:
    }

    public String a()
    {
        return "store";
    }

    public void a(Context context)
    {
        b = context;
    }

    public void a(n n1)
    {
        a = n1;
    }
}
