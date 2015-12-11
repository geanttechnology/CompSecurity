// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            afm, afo, agg, aeu, 
//            agq, aga, afp, aet, 
//            aft, afv, afu, afl, 
//            afz, afi, ago

public final class agl
    implements afm
{
    public static final class a extends afl
    {

        private final afz a;
        private final Map b;

        public void a(JsonWriter jsonwriter, Object obj)
            throws IOException
        {
            if (obj == null)
            {
                jsonwriter.nullValue();
                return;
            }
            jsonwriter.beginObject();
            try
            {
                Iterator iterator = b.values().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    b b1 = (b)iterator.next();
                    if (b1.a(obj))
                    {
                        jsonwriter.name(b1.g);
                        b1.a(jsonwriter, obj);
                    }
                } while (true);
            }
            // Misplaced declaration of an exception variable
            catch (JsonWriter jsonwriter)
            {
                throw new AssertionError();
            }
            jsonwriter.endObject();
        }

        public Object b(JsonReader jsonreader)
            throws IOException
        {
            Object obj;
            if (jsonreader.peek() == JsonToken.NULL)
            {
                jsonreader.nextNull();
                return null;
            }
            obj = a.a();
            jsonreader.beginObject();
_L1:
            Object obj1;
            if (!jsonreader.hasNext())
            {
                break MISSING_BLOCK_LABEL_103;
            }
            obj1 = jsonreader.nextName();
            obj1 = (b)b.get(obj1);
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            if (((b) (obj1)).i)
            {
                break MISSING_BLOCK_LABEL_84;
            }
            jsonreader.skipValue();
              goto _L1
            try
            {
                ((b) (obj1)).a(jsonreader, obj);
            }
            // Misplaced declaration of an exception variable
            catch (JsonReader jsonreader)
            {
                throw new afi(jsonreader);
            }
            // Misplaced declaration of an exception variable
            catch (JsonReader jsonreader)
            {
                throw new AssertionError(jsonreader);
            }
              goto _L1
            jsonreader.endObject();
            return obj;
        }

        private a(afz afz1, Map map)
        {
            a = afz1;
            b = map;
        }

    }

    static abstract class b
    {

        final String g;
        final boolean h;
        final boolean i;

        abstract void a(JsonReader jsonreader, Object obj)
            throws IOException, IllegalAccessException;

        abstract void a(JsonWriter jsonwriter, Object obj)
            throws IOException, IllegalAccessException;

        abstract boolean a(Object obj)
            throws IOException, IllegalAccessException;

        protected b(String s, boolean flag, boolean flag1)
        {
            g = s;
            h = flag;
            i = flag1;
        }
    }


    private final afu a;
    private final aet b;
    private final afv c;

    public agl(afu afu1, aet aet1, afv afv1)
    {
        a = afu1;
        b = aet1;
        c = afv1;
    }

    private afl a(aeu aeu1, Field field, agq agq1)
    {
        field = (afo)field.getAnnotation(android/support/v7/afo);
        if (field != null)
        {
            field = agg.a(a, aeu1, agq1, field);
            if (field != null)
            {
                return field;
            }
        }
        return aeu1.a(agq1);
    }

    static afl a(agl agl1, aeu aeu1, Field field, agq agq1)
    {
        return agl1.a(aeu1, field, agq1);
    }

    private b a(aeu aeu1, Field field, String s, agq agq1, boolean flag, boolean flag1)
    {
        return new b(s, flag, flag1, aeu1, field, agq1, aga.a(agq1.a())) {

            final afl a;
            final aeu b;
            final Field c;
            final agq d;
            final boolean e;
            final agl f;

            void a(JsonReader jsonreader, Object obj)
                throws IOException, IllegalAccessException
            {
                jsonreader = ((JsonReader) (a.b(jsonreader)));
                if (jsonreader != null || !e)
                {
                    c.set(obj, jsonreader);
                }
            }

            void a(JsonWriter jsonwriter, Object obj)
                throws IOException, IllegalAccessException
            {
                obj = c.get(obj);
                (new ago(b, a, d.b())).a(jsonwriter, obj);
            }

            public boolean a(Object obj)
                throws IOException, IllegalAccessException
            {
                while (!h || c.get(obj) == obj) 
                {
                    return false;
                }
                return true;
            }

            
            {
                f = agl.this;
                b = aeu1;
                c = field;
                d = agq1;
                e = flag2;
                super(s, flag, flag1);
                a = agl.a(f, b, c, d);
            }
        };
    }

    static String a(aet aet1, Field field)
    {
        afp afp1 = (afp)field.getAnnotation(android/support/v7/afp);
        if (afp1 == null)
        {
            return aet1.a(field);
        } else
        {
            return afp1.a();
        }
    }

    private String a(Field field)
    {
        return a(b, field);
    }

    private Map a(aeu aeu1, agq agq1, Class class1)
    {
        LinkedHashMap linkedhashmap;
        java.lang.reflect.Type type;
        linkedhashmap = new LinkedHashMap();
        if (class1.isInterface())
        {
            return linkedhashmap;
        }
        type = agq1.b();
_L6:
        Field afield[];
        int i;
        int j;
        if (class1 == java/lang/Object)
        {
            break; /* Loop/switch isn't completed */
        }
        afield = class1.getDeclaredFields();
        j = afield.length;
        i = 0;
_L2:
        Object obj;
        boolean flag;
        boolean flag1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        obj = afield[i];
        flag = a(((Field) (obj)), true);
        flag1 = a(((Field) (obj)), false);
        if (flag || flag1)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        ((Field) (obj)).setAccessible(true);
        java.lang.reflect.Type type1 = aft.a(agq1.b(), class1, ((Field) (obj)).getGenericType());
        obj = a(aeu1, ((Field) (obj)), a(((Field) (obj))), agq.a(type1), flag, flag1);
        obj = (b)linkedhashmap.put(((b) (obj)).g, obj);
        if (obj == null) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append(type).append(" declares multiple JSON fields named ").append(((b) (obj)).g).toString());
        agq1 = agq.a(aft.a(agq1.b(), class1, class1.getGenericSuperclass()));
        class1 = agq1.a();
        if (true) goto _L6; else goto _L5
_L5:
        return linkedhashmap;
    }

    static boolean a(Field field, boolean flag, afv afv1)
    {
        return !afv1.a(field.getType(), flag) && !afv1.a(field, flag);
    }

    public afl a(aeu aeu1, agq agq1)
    {
        Class class1 = agq1.a();
        if (!java/lang/Object.isAssignableFrom(class1))
        {
            return null;
        } else
        {
            return new a(a.a(agq1), a(aeu1, agq1, class1));
        }
    }

    public boolean a(Field field, boolean flag)
    {
        return a(field, flag, c);
    }
}
