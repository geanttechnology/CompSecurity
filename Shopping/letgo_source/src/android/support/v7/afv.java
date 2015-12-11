// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            afm, afq, afr, agq, 
//            aeq, afn, aer, aeu, 
//            afl

public final class afv
    implements afm, Cloneable
{

    public static final afv a = new afv();
    private double b;
    private int c;
    private boolean d;
    private boolean e;
    private List f;
    private List g;

    public afv()
    {
        b = -1D;
        c = 136;
        d = true;
        f = Collections.emptyList();
        g = Collections.emptyList();
    }

    private boolean a(afq afq1)
    {
        return afq1 == null || afq1.a() <= b;
    }

    private boolean a(afq afq1, afr afr1)
    {
        return a(afq1) && a(afr1);
    }

    private boolean a(afr afr1)
    {
        return afr1 == null || afr1.a() > b;
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

    public afl a(aeu aeu, agq agq1)
    {
        Class class1 = agq1.a();
        boolean flag = a(class1, true);
        boolean flag1 = a(class1, false);
        if (!flag && !flag1)
        {
            return null;
        } else
        {
            return new afl(flag1, flag, aeu, agq1) {

                final boolean a;
                final boolean b;
                final aeu c;
                final agq d;
                final afv e;
                private afl f;

                private afl a()
                {
                    afl afl1 = f;
                    if (afl1 != null)
                    {
                        return afl1;
                    } else
                    {
                        afl afl2 = c.a(e, d);
                        f = afl2;
                        return afl2;
                    }
                }

                public void a(JsonWriter jsonwriter, Object obj)
                    throws IOException
                {
                    if (b)
                    {
                        jsonwriter.nullValue();
                        return;
                    } else
                    {
                        a().a(jsonwriter, obj);
                        return;
                    }
                }

                public Object b(JsonReader jsonreader)
                    throws IOException
                {
                    if (a)
                    {
                        jsonreader.skipValue();
                        return null;
                    } else
                    {
                        return a().b(jsonreader);
                    }
                }

            
            {
                e = afv.this;
                a = flag;
                b = flag1;
                c = aeu1;
                d = agq1;
                super();
            }
            };
        }
    }

    protected afv a()
    {
        afv afv1;
        try
        {
            afv1 = (afv)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return afv1;
    }

    public boolean a(Class class1, boolean flag)
    {
        if (b != -1D && !a((afq)class1.getAnnotation(android/support/v7/afq), (afr)class1.getAnnotation(android/support/v7/afr)))
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
            if (((aeq)((Iterator) (obj)).next()).a(class1))
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
            if (b != -1D && !a((afq)field.getAnnotation(android/support/v7/afq), (afr)field.getAnnotation(android/support/v7/afr)))
            {
                return true;
            }
            if (field.isSynthetic())
            {
                return true;
            }
            if (e)
            {
                afn afn1 = (afn)field.getAnnotation(android/support/v7/afn);
                if (afn1 == null || (flag ? !afn1.a() : !afn1.b()))
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
            field = new aer(field);
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!((aeq)((Iterator) (obj)).next()).a(field));
            return true;
        }
        return false;
    }

    protected Object clone()
        throws CloneNotSupportedException
    {
        return a();
    }

}
