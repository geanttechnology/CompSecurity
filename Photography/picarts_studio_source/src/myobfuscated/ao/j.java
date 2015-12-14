// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.internal.b;
import com.millennialmedia.google.gson.internal.k;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import myobfuscated.an.c;
import myobfuscated.ap.a;

// Referenced classes of package myobfuscated.ao:
//            l, k, o

public final class j
    implements com.millennialmedia.google.gson.j
{

    private final com.millennialmedia.google.gson.internal.a a;
    private final com.millennialmedia.google.gson.a b;
    private final b c;

    public j(com.millennialmedia.google.gson.internal.a a1, com.millennialmedia.google.gson.a a2, b b1)
    {
        a = a1;
        b = a2;
        c = b1;
    }

    private Map a(com.millennialmedia.google.gson.b b1, a a1, Class class1)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        if (class1.isInterface())
        {
            return linkedhashmap;
        }
        java.lang.reflect.Type type = a1.b;
        for (; class1 != java/lang/Object; class1 = a1.a)
        {
            Field afield[] = class1.getDeclaredFields();
            int i1 = afield.length;
            Object obj;
            for (int i = 0; i < i1; i++)
            {
                Field field = afield[i];
                boolean flag = a(field, true);
                boolean flag1 = a(field, false);
                if (!flag && !flag1)
                {
                    continue;
                }
                field.setAccessible(true);
                Object obj1 = com.millennialmedia.google.gson.internal..Gson.Types.a(a1.b, class1, field.getGenericType());
                obj = (myobfuscated.an.a)field.getAnnotation(myobfuscated/an/a);
                if (obj == null)
                {
                    obj = b.translateName(field);
                } else
                {
                    obj = ((myobfuscated.an.a) (obj)).a();
                }
                obj1 = myobfuscated.ap.a.a(((java.lang.reflect.Type) (obj1)));
                obj = new l(((String) (obj)), flag, flag1, b1, ((a) (obj1)), field, k.a(((a) (obj1)).a)) {

                    private i d;
                    private com.millennialmedia.google.gson.b e;
                    private a f;
                    private Field g;
                    private boolean h;

                    final void a(com.millennialmedia.google.gson.stream.a a2, Object obj2)
                    {
                        a2 = ((com.millennialmedia.google.gson.stream.a) (d.a(a2)));
                        if (a2 != null || !h)
                        {
                            g.set(obj2, a2);
                        }
                    }

                    final void a(com.millennialmedia.google.gson.stream.b b2, Object obj2)
                    {
                        obj2 = g.get(obj2);
                        (new o(e, d, f.b)).a(b2, obj2);
                    }

            
            {
                e = b1;
                f = a1;
                g = field;
                h = flag2;
                super(s, flag, flag1);
                d = e.a(f);
            }
                };
                obj = (l)linkedhashmap.put(((l) (obj)).a, obj);
                if (obj != null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append(type).append(" declares multiple JSON fields named ").append(((l) (obj)).a).toString());
                }
            }

            a1 = myobfuscated.ap.a.a(com.millennialmedia.google.gson.internal..Gson.Types.a(a1.b, class1, class1.getGenericSuperclass()));
        }

        return linkedhashmap;
    }

    private boolean a(Field field, boolean flag)
    {
        if (c.a(field.getType(), flag)) goto _L2; else goto _L1
_L1:
        Object obj = c;
        if ((((b) (obj)).c & field.getModifiers()) == 0) goto _L4; else goto _L3
_L3:
        boolean flag1 = true;
_L5:
        if (!flag1)
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
_L4:
label0:
        {
            if (((b) (obj)).b != -1D && !((b) (obj)).a((myobfuscated.an.b)field.getAnnotation(myobfuscated/an/b), (c)field.getAnnotation(myobfuscated/an/c)))
            {
                flag1 = true;
                continue; /* Loop/switch isn't completed */
            }
            if (field.isSynthetic())
            {
                flag1 = true;
                continue; /* Loop/switch isn't completed */
            }
            if (!((b) (obj)).d && com.millennialmedia.google.gson.internal.b.b(field.getType()))
            {
                flag1 = true;
                continue; /* Loop/switch isn't completed */
            }
            if (com.millennialmedia.google.gson.internal.b.a(field.getType()))
            {
                flag1 = true;
                continue; /* Loop/switch isn't completed */
            }
            if (flag)
            {
                obj = ((b) (obj)).e;
            } else
            {
                obj = ((b) (obj)).f;
            }
            if (((List) (obj)).isEmpty())
            {
                break label0;
            }
            new com.appboy.ui.inappmessage.a._cls8(field);
            field = ((List) (obj)).iterator();
            do
            {
                if (!field.hasNext())
                {
                    break label0;
                }
            } while (!((com.melnykov.fab.a)field.next()).a());
            flag1 = true;
            continue; /* Loop/switch isn't completed */
        }
        flag1 = false;
        if (true) goto _L5; else goto _L2
_L2:
        return false;
    }

    public final i a(com.millennialmedia.google.gson.b b1, a a1)
    {
        Class class1 = a1.a;
        if (!java/lang/Object.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            return new myobfuscated.ao.k(a.a(a1), a(b1, a1, class1), (byte)0);
        }
    }
}
