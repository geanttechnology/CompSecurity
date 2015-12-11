// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.e;

import com.google.api.a.g.ac;
import com.google.api.a.g.h;
import com.google.api.a.g.k;
import com.google.api.a.g.l;
import com.google.api.a.g.w;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.google.api.a.e:
//            i, b, g, c, 
//            h, a

public abstract class f
{

    private static WeakHashMap a = new WeakHashMap();
    private static final Lock b = new ReentrantLock();

    public f()
    {
    }

    private final Object a(Field field, Type type, ArrayList arraylist, a a1, boolean flag)
    {
        Object obj1;
        Type type1;
        type1 = com.google.api.a.g.h.a(arraylist, type);
        if (type1 instanceof Class)
        {
            type = (Class)type1;
        } else
        {
            type = null;
        }
        obj1 = type;
        if (type1 instanceof ParameterizedType)
        {
            obj1 = ac.a((ParameterizedType)type1);
        }
        if (obj1 != java/lang/Void) goto _L2; else goto _L1
_L1:
        o();
        a1 = null;
_L22:
        return a1;
_L2:
        type = c();
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.google.api.a.e.i.values().length];
                try
                {
                    a[i.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[i.a.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[i.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[i.e.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[i.d.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[i.i.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[i.j.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.google.api.a.e.i.h.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[i.g.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[i.f.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.google.api.a.e.i.k.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[c().ordinal()];
        JVM INSTR tableswitch 1 11: default 1496
    //                   1 414
    //                   2 254
    //                   3 254
    //                   4 414
    //                   5 414
    //                   6 1032
    //                   7 1032
    //                   8 1096
    //                   9 1096
    //                   10 1343
    //                   11 1394;
           goto _L3 _L4 _L5 _L5 _L4 _L4 _L6 _L6 _L7 _L7 _L8 _L9
_L3:
        type = String.valueOf(String.valueOf(type));
        throw new IllegalArgumentException((new StringBuilder(type.length() + 27)).append("unexpected JSON node type: ").append(type).toString());
_L5:
        boolean flag1;
        try
        {
            flag1 = ac.a(type1);
        }
        // Misplaced declaration of an exception variable
        catch (Type type)
        {
            arraylist = new StringBuilder();
            a1 = b();
            if (a1 != null)
            {
                arraylist.append("key ").append(a1);
            }
            if (field != null)
            {
                if (a1 != null)
                {
                    arraylist.append(", ");
                }
                arraylist.append("field ").append(field);
            }
            throw new IllegalArgumentException(arraylist.toString(), type);
        }
        if (type1 == null || flag1) goto _L11; else goto _L10
_L10:
        if (obj1 == null) goto _L13; else goto _L12
_L12:
        if (!ac.a(((Class) (obj1)), java/util/Collection)) goto _L13; else goto _L11
_L102:
        Object obj;
        w.a(flag, "expected collection or array type but got %s", new Object[] {
            type1
        });
        obj = com.google.api.a.g.h.b(type1);
        if (!flag1) goto _L15; else goto _L14
_L14:
        type = ac.b(type1);
_L20:
        obj1 = com.google.api.a.g.h.a(arraylist, type);
        for (type = q(); type != i.b; type = n())
        {
            ((Collection) (obj)).add(a(field, ((Type) (obj1)), arraylist, a1, true));
        }

          goto _L16
_L15:
        if (obj1 == null) goto _L18; else goto _L17
_L17:
        if (!java/lang/Iterable.isAssignableFrom(((Class) (obj1)))) goto _L18; else goto _L19
_L19:
        type = ac.c(type1);
          goto _L20
_L16:
        a1 = ((a) (obj));
        if (!flag1) goto _L22; else goto _L21
_L21:
        return ac.a(((Collection) (obj)), ac.a(arraylist, ((Type) (obj1))));
_L4:
        Object obj2;
        g.a aa[];
        com.google.api.a.g.f f1;
        Class class1;
        int i1;
        int j1;
        if (!ac.a(type1))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        w.a(flag1, "expected object or map type but got %s", new Object[] {
            type1
        });
        if (!flag) goto _L24; else goto _L23
_L23:
        obj = b(((Class) (obj1)));
_L103:
        if (obj1 == null) goto _L26; else goto _L25
_L25:
        if (!ac.a(((Class) (obj1)), java/util/Map)) goto _L26; else goto _L27
_L27:
        i1 = 1;
_L104:
        if (obj == null) goto _L29; else goto _L28
_L28:
        type = new b();
_L38:
        j1 = arraylist.size();
        if (type1 == null) goto _L31; else goto _L30
_L30:
        arraylist.add(type1);
_L31:
        if (i1 == 0) goto _L33; else goto _L32
_L32:
        if (com/google/api/a/g/l.isAssignableFrom(((Class) (obj1)))) goto _L33; else goto _L34
_L34:
        if (!java/util/Map.isAssignableFrom(((Class) (obj1)))) goto _L36; else goto _L35
_L35:
        obj1 = ac.d(type1);
_L107:
        if (obj1 == null) goto _L33; else goto _L37
_L37:
        a(field, (Map)type, ((Type) (obj1)), arraylist, a1);
        return type;
_L105:
        type = com.google.api.a.g.h.b(((Class) (obj1)));
          goto _L38
_L106:
        type = ((Type) (ac.a(((Class) (obj1)))));
          goto _L38
_L33:
        if (type instanceof b)
        {
            ((b)type).setFactory(d());
        }
        obj2 = q();
        class1 = type.getClass();
        f1 = com.google.api.a.g.f.a(class1);
        flag = com/google/api/a/g/l.isAssignableFrom(class1);
        obj1 = obj2;
        if (flag) goto _L40; else goto _L39
_L39:
        obj1 = obj2;
        if (!java/util/Map.isAssignableFrom(class1)) goto _L40; else goto _L41
_L41:
        a(null, (Map)type, ac.d(class1), arraylist, a1);
_L52:
        if (type1 == null) goto _L43; else goto _L42
_L42:
        arraylist.remove(j1);
_L43:
        a1 = type;
        if (obj == null) goto _L22; else goto _L44
_L44:
        a1 = ((a) (((b)type).get(((Field) (obj)).getName())));
        if (a1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "No value specified for @JsonPolymorphicTypeMap field");
        obj1 = a1.toString();
        a1 = (g)((Field) (obj)).getAnnotation(com/google/api/a/e/g);
        obj = null;
        aa = a1.a();
        j1 = aa.length;
        i1 = 0;
_L109:
        a1 = ((a) (obj));
        if (i1 >= j1) goto _L46; else goto _L45
_L45:
        a1 = aa[i1];
        if (!a1.a().equals(obj1)) goto _L48; else goto _L47
_L47:
        a1 = a1.b();
          goto _L46
_L108:
        obj = String.valueOf(obj1);
        if (((String) (obj)).length() == 0) goto _L50; else goto _L49
_L49:
        obj = "No TypeDef annotation found with key: ".concat(((String) (obj)));
_L60:
        w.a(flag, obj);
        obj = d();
        type = ((c) (obj)).a(((c) (obj)).a(type, false));
        type.p();
        return type.a(field, ((Type) (a1)), arraylist, ((a) (null)), false);
_L56:
        aa = ((k) (obj1)).b;
        i1 = arraylist.size();
        arraylist.add(aa.getGenericType());
        aa = ((g.a []) (a(((Field) (aa)), ((k) (obj1)).b.getGenericType(), arraylist, a1, true)));
        arraylist.remove(i1);
        ((k) (obj1)).a(type, aa);
_L59:
        obj1 = n();
_L40:
        if (obj1 != i.e) goto _L52; else goto _L51
_L51:
        aa = m();
        n();
        obj1 = f1.a(aa);
        if (obj1 == null) goto _L54; else goto _L53
_L53:
        if (!((k) (obj1)).a() || ((k) (obj1)).a) goto _L56; else goto _L55
_L55:
        throw new IllegalArgumentException("final array/object fields are not supported");
_L54:
        if (!flag) goto _L58; else goto _L57
_L57:
        ((l)type).set(aa, a(null, ((Type) (null)), arraylist, a1, true));
          goto _L59
_L58:
        o();
          goto _L59
_L50:
        obj = new String("No TypeDef annotation found with key: ");
          goto _L60
_L6:
        if (type1 == null) goto _L62; else goto _L61
_L61:
        if (obj1 == Boolean.TYPE) goto _L62; else goto _L63
_L63:
        if (obj1 == null) goto _L65; else goto _L64
_L64:
        if (!((Class) (obj1)).isAssignableFrom(java/lang/Boolean)) goto _L65; else goto _L62
_L110:
        w.a(flag, "expected type Boolean or boolean but got %s", new Object[] {
            type1
        });
        if (type == i.i)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
_L7:
        if (field == null) goto _L67; else goto _L66
_L66:
        if (field.getAnnotation(com/google/api/a/e/h) != null) goto _L68; else goto _L67
_L111:
        w.a(flag, "number type formatted as a JSON number cannot use @JsonString annotation");
        if (obj1 == null) goto _L70; else goto _L69
_L69:
        if (!((Class) (obj1)).isAssignableFrom(java/math/BigDecimal)) goto _L71; else goto _L70
_L70:
        return j();
_L71:
        if (obj1 != java/math/BigInteger) goto _L73; else goto _L72
_L72:
        return i();
_L73:
        if (obj1 == java/lang/Double) goto _L75; else goto _L74
_L74:
        if (obj1 != Double.TYPE) goto _L76; else goto _L75
_L75:
        return Double.valueOf(k());
_L76:
        if (obj1 == java/lang/Long) goto _L78; else goto _L77
_L77:
        if (obj1 != Long.TYPE) goto _L79; else goto _L78
_L78:
        return Long.valueOf(l());
_L79:
        if (obj1 == java/lang/Float) goto _L81; else goto _L80
_L80:
        if (obj1 != Float.TYPE) goto _L82; else goto _L81
_L81:
        return Float.valueOf(h());
_L82:
        if (obj1 == java/lang/Integer) goto _L84; else goto _L83
_L83:
        if (obj1 != Integer.TYPE) goto _L85; else goto _L84
_L84:
        return Integer.valueOf(g());
_L85:
        if (obj1 == java/lang/Short) goto _L87; else goto _L86
_L86:
        if (obj1 != Short.TYPE) goto _L88; else goto _L87
_L87:
        return Short.valueOf(f());
_L88:
        if (obj1 == java/lang/Byte) goto _L90; else goto _L89
_L89:
        if (obj1 != Byte.TYPE) goto _L91; else goto _L90
_L90:
        return Byte.valueOf(e());
_L91:
        type = String.valueOf(String.valueOf(type1));
        throw new IllegalArgumentException((new StringBuilder(type.length() + 30)).append("expected numeric type but got ").append(type).toString());
_L8:
        if (obj1 == null) goto _L93; else goto _L92
_L92:
        if (!java/lang/Number.isAssignableFrom(((Class) (obj1)))) goto _L93; else goto _L94
_L94:
        if (field == null) goto _L96; else goto _L95
_L95:
        if (field.getAnnotation(com/google/api/a/e/h) == null) goto _L96; else goto _L93
_L112:
        w.a(flag, "number field formatted as a JSON string must use the @JsonString annotation");
        return com.google.api.a.g.h.a(type1, m());
_L9:
        if (obj1 == null) goto _L98; else goto _L97
_L97:
        if (((Class) (obj1)).isPrimitive()) goto _L99; else goto _L98
_L113:
        w.a(flag, "primitive number field but found a JSON null");
        if (obj1 == null) goto _L101; else goto _L100
_L100:
        if ((((Class) (obj1)).getModifiers() & 0x600) != 0)
        {
            if (ac.a(((Class) (obj1)), java/util/Collection))
            {
                return com.google.api.a.g.h.a(com.google.api.a.g.h.b(type1).getClass());
            }
            if (ac.a(((Class) (obj1)), java/util/Map))
            {
                return com.google.api.a.g.h.a(com.google.api.a.g.h.b(((Class) (obj1))).getClass());
            }
        }
_L101:
        type = ((Type) (com.google.api.a.g.h.a(ac.a(arraylist, type1))));
        return type;
_L18:
        type = null;
          goto _L20
_L11:
        flag = true;
          goto _L102
_L13:
        flag = false;
          goto _L102
_L24:
        obj = null;
          goto _L103
_L26:
        i1 = 0;
          goto _L104
_L29:
        if (i1 == 0 && obj1 != null) goto _L106; else goto _L105
_L36:
        obj1 = null;
          goto _L107
_L46:
        if (a1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L108
_L48:
        i1++;
          goto _L109
_L62:
        flag = true;
          goto _L110
_L65:
        flag = false;
          goto _L110
_L67:
        flag = true;
          goto _L111
_L68:
        flag = false;
          goto _L111
_L93:
        flag = true;
          goto _L112
_L96:
        flag = false;
          goto _L112
_L98:
        flag = true;
          goto _L113
_L99:
        flag = false;
          goto _L113
    }

    private void a(Field field, Map map, Type type, ArrayList arraylist, a a1)
    {
        for (Object obj = q(); obj == i.e; obj = n())
        {
            obj = m();
            n();
            map.put(obj, a(field, type, arraylist, a1, true));
        }

    }

    private static Field b(Class class1)
    {
        if (class1 == null)
        {
            return null;
        }
        b.lock();
        if (!a.containsKey(class1))
        {
            break MISSING_BLOCK_LABEL_45;
        }
        class1 = (Field)a.get(class1);
        b.unlock();
        return class1;
        Iterator iterator = Collections.unmodifiableCollection(com.google.api.a.g.f.a(class1).c.values()).iterator();
        Field field = null;
_L6:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Field field1;
        Object obj;
        field1 = ((k)iterator.next()).b;
        obj = (g)field1.getAnnotation(com/google/api/a/e/g);
        boolean flag;
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        g.a a1;
        int i1;
        int j1;
        if (field == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", new Object[] {
            class1
        });
        w.a(com.google.api.a.g.h.a(field1.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", new Object[] {
            class1, field1.getType()
        });
        field = ((g) (obj)).a();
        obj = new HashSet();
        if (field.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
        j1 = field.length;
        i1 = 0;
_L4:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        a1 = field[i1];
        w.a(((HashSet) (obj)).add(a1.a()), "Class contains two @TypeDef annotations with identical key: %s", new Object[] {
            a1.a()
        });
        i1++;
        if (true) goto _L4; else goto _L3
_L2:
        a.put(class1, field);
        b.unlock();
        return field;
        class1;
        b.unlock();
        throw class1;
_L3:
        field = field1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private i p()
    {
        i i1 = c();
        if (i1 == null)
        {
            i1 = n();
        }
        boolean flag;
        if (i1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "no JSON input found");
        return i1;
    }

    private i q()
    {
        i i1 = p();
        switch (_cls1.a[i1.ordinal()])
        {
        default:
            return i1;

        case 1: // '\001'
            i j1 = n();
            boolean flag;
            if (j1 == i.e || j1 == i.d)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.a(flag, j1);
            return j1;

        case 2: // '\002'
            return n();
        }
    }

    public final Object a(Class class1)
    {
        class1 = ((Class) (a(((Type) (class1)), false)));
        a();
        return class1;
        class1;
        a();
        throw class1;
    }

    public final Object a(Type type, boolean flag)
    {
        if (!java/lang/Void.equals(type))
        {
            p();
        }
        type = ((Type) (a(null, type, new ArrayList(), ((a) (null)), true)));
        if (flag)
        {
            a();
        }
        return type;
        type;
        if (flag)
        {
            a();
        }
        throw type;
    }

    public final String a(Set set)
    {
        for (Object obj = q(); obj == i.e; obj = n())
        {
            obj = m();
            n();
            if (set.contains(obj))
            {
                return ((String) (obj));
            }
            o();
        }

        return null;
    }

    public abstract void a();

    public abstract String b();

    public abstract i c();

    public abstract c d();

    public abstract byte e();

    public abstract short f();

    public abstract int g();

    public abstract float h();

    public abstract BigInteger i();

    public abstract BigDecimal j();

    public abstract double k();

    public abstract long l();

    public abstract String m();

    public abstract i n();

    public abstract f o();

}
