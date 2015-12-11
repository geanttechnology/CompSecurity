// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            ir, jz, ia, jx, 
//            jy, je, is, jw

public final class jq extends ir
{

    public static final is a = new is() {

        public ir a(ia ia1, jw jw1)
        {
            if (jw1.a() == java/lang/Object)
            {
                return new jq(ia1);
            } else
            {
                return null;
            }
        }

    };
    private final ia b;

    private jq(ia ia1)
    {
        b = ia1;
    }


    public void a(jz jz1, Object obj)
    {
        if (obj == null)
        {
            jz1.f();
            return;
        }
        ir ir1 = b.a(obj.getClass());
        if (ir1 instanceof jq)
        {
            jz1.d();
            jz1.e();
            return;
        } else
        {
            ir1.a(jz1, obj);
            return;
        }
    }

    public Object b(jx jx1)
    {
        jy jy1 = jx1.f();
        class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[jy.values().length];
                try
                {
                    a[jy.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[jy.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[jy.f.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[jy.g.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[jy.h.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[jy.i.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2.a[jy1.ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            ArrayList arraylist = new ArrayList();
            jx1.a();
            for (; jx1.e(); arraylist.add(b(jx1))) { }
            jx1.b();
            return arraylist;

        case 2: // '\002'
            je je1 = new je();
            jx1.c();
            for (; jx1.e(); je1.put(jx1.g(), b(jx1))) { }
            jx1.d();
            return je1;

        case 3: // '\003'
            return jx1.h();

        case 4: // '\004'
            return Double.valueOf(jx1.k());

        case 5: // '\005'
            return Boolean.valueOf(jx1.i());

        case 6: // '\006'
            jx1.j();
            return null;
        }
    }

}
