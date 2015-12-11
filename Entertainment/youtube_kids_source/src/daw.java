// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class daw
{

    private static final ArrayList a;

    public static String a(eug eug1)
    {
        if (eug1 == null)
        {
            return "null";
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            a(stringbuffer, "", eug1.getClass().getSimpleName(), eug1);
            return stringbuffer.toString();
        }
    }

    private static String a(Class class1, String s)
    {
        return (new StringBuilder()).append(class1.getName()).append("#").append(s).toString();
    }

    private static String a(Field field)
    {
        field = field.getName();
        return field.substring(0, field.length() - 1);
    }

    private static void a(StringBuffer stringbuffer, eug eug1, String s, Object obj)
    {
        if (obj == null)
        {
            obj = "null";
        } else
        if (obj instanceof euc)
        {
            obj = (new StringBuilder("bytes[")).append(((euc)obj).a()).append("]").toString();
        } else
        if (obj instanceof Integer)
        {
            if ((eug1 instanceof evm) && s.equals("eventType"))
            {
                obj = a.c(((Integer)obj).intValue());
            } else
            if ((eug1 instanceof evw) && s.equals("event"))
            {
                obj = a.d(((Integer)obj).intValue());
            } else
            {
                obj = obj.toString();
            }
        } else
        {
            obj = obj.toString();
        }
        if (a.contains(a(eug1.getClass(), s)))
        {
            stringbuffer.append(((String) (obj)).substring(0, Math.min(4, ((String) (obj)).length())));
            stringbuffer.append("XXXXXXXX");
            return;
        } else
        {
            stringbuffer.append(((String) (obj)));
            return;
        }
    }

    private static void a(StringBuffer stringbuffer, String s, eug eug1, Field field, List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = list.next();
            if (obj instanceof eug)
            {
                a(stringbuffer, s, a(field), (eug)obj);
            } else
            {
                stringbuffer.append(s);
                stringbuffer.append(a(field));
                stringbuffer.append(":");
                a(stringbuffer, eug1, a(field), obj);
                stringbuffer.append("\n");
            }
        }

    }

    private static void a(StringBuffer stringbuffer, String s, String s1, eug eug1)
    {
        Field field;
        Object obj;
        String s2;
        int i;
        Field afield[];
        int j;
        try
        {
            stringbuffer.append(s);
            stringbuffer.append(s1);
            stringbuffer.append(" {");
            stringbuffer.append("\n");
            s1 = new ArrayList();
            afield = eug1.getClass().getDeclaredFields();
            j = afield.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            stringbuffer.append((new StringBuilder("Unable to print proto buffer ")).append(s).toString());
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            stringbuffer.append((new StringBuilder("Unable to print proto buffer ")).append(s).toString());
            s.printStackTrace();
            return;
        }
        i = 0;
_L8:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        obj = afield[i];
        if (((Field) (obj)).getName().endsWith("_"))
        {
            ((Field) (obj)).setAccessible(true);
            s1.add(obj);
        }
        break MISSING_BLOCK_LABEL_332;
        s1 = s1.iterator();
_L3:
        if (!s1.hasNext())
        {
            break MISSING_BLOCK_LABEL_318;
        }
        field = (Field)s1.next();
        obj = field.get(eug1);
        s2 = (new StringBuilder()).append(s).append(" ").toString();
        if (!(obj instanceof eug)) goto _L2; else goto _L1
_L1:
        if (a(eug1, field))
        {
            a(stringbuffer, s2, a(field), (eug)obj);
        }
          goto _L3
_L2:
        if (!(obj instanceof List)) goto _L5; else goto _L4
_L4:
        a(stringbuffer, s2, eug1, field, (List)obj);
          goto _L3
_L5:
        if (!a(eug1, field)) goto _L3; else goto _L6
_L6:
        stringbuffer.append(s2);
        stringbuffer.append(a(field));
        stringbuffer.append(":");
        a(stringbuffer, eug1, a(field), obj);
        stringbuffer.append("\n");
          goto _L3
        stringbuffer.append(s);
        stringbuffer.append("}\n");
        return;
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static boolean a(eug eug1, Field field)
    {
        boolean flag;
        try
        {
            field = field.getName();
            field = (new StringBuilder("has")).append(Character.toUpperCase(field.charAt(0))).append(field.substring(1, field.length() - 1)).toString();
            field = eug1.getClass().getDeclaredField(field);
            field.setAccessible(true);
            flag = ((Boolean)field.get(eug1)).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (eug eug1)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (eug eug1)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (eug eug1)
        {
            return false;
        }
        return flag;
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        a = arraylist;
        arraylist.add(a(ewy, "token"));
    }
}
