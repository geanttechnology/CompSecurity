// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            is, iw, ix, jw, 
//            hw, it, hx, ia, 
//            ir, jz, jx

public final class jb
    implements is, Cloneable
{

    public static final jb a = new jb();
    private double b;
    private int c;
    private boolean d;
    private boolean e;
    private List f;
    private List g;

    public jb()
    {
        b = -1D;
        c = 136;
        d = true;
        f = Collections.emptyList();
        g = Collections.emptyList();
    }

    private boolean a(iw iw1)
    {
        return iw1 == null || iw1.a() <= b;
    }

    private boolean a(iw iw1, ix ix1)
    {
        return a(iw1) && a(ix1);
    }

    private boolean a(ix ix1)
    {
        return ix1 == null || ix1.a() > b;
    }

    private boolean a(Class class1)
    {
        return !java/lang/Enum.isAssignableFrom(class1) && (class1.isAnonymousClass() || class1.isLocalClass());
    }

    private boolean b(Class class1)
    {
        return class1.isMemberClass() && !c(class1);
    }

    private boolean c(Class class1)
    {
        return (class1.getModifiers() & 8) != 0;
    }

    public ir a(ia ia, jw jw1)
    {
        Class class1 = jw1.a();
        boolean flag = a(class1, true);
        boolean flag1 = a(class1, false);
        if (!flag && !flag1)
        {
            return null;
        } else
        {
            return new ir(flag1, flag, ia, jw1) {

                final boolean a;
                final boolean b;
                final ia c;
                final jw d;
                final jb e;
                private ir f;

                private ir a()
                {
                    ir ir1 = f;
                    if (ir1 != null)
                    {
                        return ir1;
                    } else
                    {
                        ir ir2 = c.a(e, d);
                        f = ir2;
                        return ir2;
                    }
                }

                public void a(jz jz1, Object obj)
                {
                    if (b)
                    {
                        jz1.f();
                        return;
                    } else
                    {
                        a().a(jz1, obj);
                        return;
                    }
                }

                public Object b(jx jx1)
                {
                    if (a)
                    {
                        jx1.n();
                        return null;
                    } else
                    {
                        return a().b(jx1);
                    }
                }

            
            {
                e = jb.this;
                a = flag;
                b = flag1;
                c = ia1;
                d = jw1;
                super();
            }
            };
        }
    }

    protected jb a()
    {
        jb jb1;
        try
        {
            jb1 = (jb)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return jb1;
    }

    public boolean a(Class class1, boolean flag)
    {
        if (b != -1D && !a((iw)class1.getAnnotation(com/flurry/sdk/iw), (ix)class1.getAnnotation(com/flurry/sdk/ix)))
        {
            return true;
        }
        if (!d && b(class1))
        {
            return true;
        }
        if (a(class1))
        {
            return true;
        }
        Object obj;
        if (flag)
        {
            obj = f;
        } else
        {
            obj = g;
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            if (((hw)((Iterator) (obj)).next()).a(class1))
            {
                return true;
            }
        }

        return false;
    }

    public boolean a(Field field, boolean flag)
    {
label0:
        {
            if ((c & field.getModifiers()) != 0)
            {
                return true;
            }
            if (b != -1D && !a((iw)field.getAnnotation(com/flurry/sdk/iw), (ix)field.getAnnotation(com/flurry/sdk/ix)))
            {
                return true;
            }
            if (field.isSynthetic())
            {
                return true;
            }
            if (e)
            {
                it it1 = (it)field.getAnnotation(com/flurry/sdk/it);
                if (it1 == null || (flag ? !it1.a() : !it1.b()))
                {
                    return true;
                }
            }
            if (!d && b(field.getType()))
            {
                return true;
            }
            if (a(field.getType()))
            {
                return true;
            }
            Object obj;
            if (flag)
            {
                obj = f;
            } else
            {
                obj = g;
            }
            if (((List) (obj)).isEmpty())
            {
                break label0;
            }
            field = new hx(field);
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!((hw)((Iterator) (obj)).next()).a(field));
            return true;
        }
        return false;
    }

    protected Object clone()
    {
        return a();
    }

}
