// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ac;
import android.view.View;
import android.view.ViewGroup;
import com.j.a.d.ab;
import java.lang.reflect.Method;

// Referenced classes of package com.j.a.g:
//            a, w

final class x
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final ViewPager a;
    final ac b;
    final ViewGroup c;

    x(ViewPager viewpager, ac ac, ViewGroup viewgroup)
    {
        a = viewpager;
        b = ac;
        c = viewgroup;
        super();
    }

    public void onGlobalLayout()
    {
        int l = a.getCurrentItem();
        if (!(b instanceof j)) goto _L2; else goto _L1
_L1:
        Object obj = (j)b;
_L13:
        String s = "";
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((j) (obj)).a(l).getClass().getSimpleName();
_L8:
        s = (new StringBuilder()).append(((String) (obj))).append("_viewpager_").append(l).toString();
        if (c.findViewById(com.j.a.g.a.b()) != null) goto _L6; else goto _L5
_L5:
        com.j.a.g.a.a(com.j.a.g.a.b(), c, s);
        com.j.a.g.a.a(c.getId(), s, ((String) (obj)));
        com.j.a.g.a.a(a, s);
_L11:
        return;
_L4:
        obj = s;
        if (ab.a().f() != null) goto _L8; else goto _L7
_L7:
        int i1;
        obj = b.getClass().getDeclaredMethods();
        i1 = obj.length;
        Method method;
        Class aclass[];
        int k;
        int j1;
        for (int i = 0; i >= i1; i++)
        {
            break MISSING_BLOCK_LABEL_224;
        }

        method = obj[i];
        if (!method.getReturnType().equals(android/support/v4/app/Fragment) || method.getParameterTypes().length != 1)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        aclass = method.getParameterTypes();
        j1 = aclass.length;
        for (k = 0; k < j1; k++)
        {
            try
            {
                if (aclass[k].equals(Integer.TYPE))
                {
                    ab.a().a(method);
                }
                continue;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            try
            {
                w.b("problem getting viewpager", ((Exception) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                w.b("frg", ((Exception) (obj)));
            }
            return;
        }

        break MISSING_BLOCK_LABEL_365;
        obj = s;
        if (ab.a().f() == null) goto _L8; else goto _L9
_L9:
        obj = ab.a().f().invoke(b, new Object[] {
            Integer.valueOf(l)
        }).getClass().getSimpleName();
          goto _L8
_L6:
        if (c.findViewById(com.j.a.g.a.b()).getTag().equals(s)) goto _L11; else goto _L10
_L10:
        c.findViewById(com.j.a.g.a.b()).setTag(s);
        com.j.a.g.a.a(c.getId());
        com.j.a.g.a.a(c.getId(), s, ((String) (obj)));
        com.j.a.g.a.a(a, s);
        return;
_L2:
        obj = null;
        if (true) goto _L13; else goto _L12
_L12:
    }
}
