// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.json;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.boldchat.visitor.api.json:
//            JSONException, JSONTokener, JSONArray, JSONString

public class JSONObject
{
    private static final class Null
    {

        protected final Object clone()
        {
            return this;
        }

        public boolean equals(Object obj)
        {
            return obj == null || obj == this;
        }

        public String toString()
        {
            return "null";
        }

        private Null()
        {
        }

    }


    public static final Object NULL = new Null();
    private final Map map;

    public JSONObject()
    {
        map = new HashMap();
    }

    public JSONObject(JSONTokener jsontokener)
        throws JSONException
    {
        this();
        if (jsontokener.nextClean() != '{')
        {
            throw jsontokener.syntaxError("A JSONObject text must begin with '{'");
        }
          goto _L1
_L7:
        jsontokener.back();
_L1:
        jsontokener.nextClean();
        JVM INSTR lookupswitch 2: default 56
    //                   0: 84
    //                   125: 156;
           goto _L2 _L3 _L4
_L3:
        throw jsontokener.syntaxError("A JSONObject text must end with '}'");
_L2:
        jsontokener.back();
        String s = jsontokener.nextValue().toString();
        if (jsontokener.nextClean() != ':')
        {
            throw jsontokener.syntaxError("Expected a ':' after a key");
        }
        putOnce(s, jsontokener.nextValue());
        jsontokener.nextClean();
        JVM INSTR lookupswitch 3: default 140
    //                   44: 147
    //                   59: 147
    //                   125: 156;
           goto _L5 _L6 _L6 _L4
_L5:
        throw jsontokener.syntaxError("Expected a ',' or '}'");
_L6:
        if (jsontokener.nextClean() != '}') goto _L7; else goto _L4
_L4:
    }

    public JSONObject(Object obj)
    {
        this();
        populateMap(obj);
    }

    public JSONObject(String s)
        throws JSONException
    {
        this(new JSONTokener(s));
    }

    public JSONObject(Map map1)
    {
        map = new HashMap();
        if (map1 != null)
        {
            map1 = map1.entrySet().iterator();
            do
            {
                if (!map1.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)map1.next();
                Object obj = entry.getValue();
                if (obj != null)
                {
                    map.put(entry.getKey(), wrap(obj));
                }
            } while (true);
        }
    }

    static final void indent(Writer writer, int i)
        throws IOException
    {
        for (int j = 0; j < i; j++)
        {
            writer.write(32);
        }

    }

    public static String numberToString(Number number)
        throws JSONException
    {
        if (number == null)
        {
            throw new JSONException("Null pointer");
        }
        testValidity(number);
        String s = number.toString();
        number = s;
        if (s.indexOf('.') > 0)
        {
            number = s;
            if (s.indexOf('e') < 0)
            {
                number = s;
                if (s.indexOf('E') < 0)
                {
                    for (; s.endsWith("0"); s = s.substring(0, s.length() - 1)) { }
                    number = s;
                    if (s.endsWith("."))
                    {
                        number = s.substring(0, s.length() - 1);
                    }
                }
            }
        }
        return number;
    }

    private void populateMap(Object obj)
    {
        Object obj1;
        Object obj2;
        boolean flag = false;
        obj1 = obj.getClass();
        if (((Class) (obj1)).getClassLoader() != null)
        {
            flag = true;
        }
        Method amethod[];
        Method method;
        int i;
        if (flag)
        {
            amethod = ((Class) (obj1)).getMethods();
        } else
        {
            amethod = ((Class) (obj1)).getDeclaredMethods();
        }
        i = 0;
        if (i >= amethod.length) goto _L2; else goto _L1
_L1:
        method = amethod[i];
        if (!Modifier.isPublic(method.getModifiers())) goto _L4; else goto _L3
_L3:
        obj2 = method.getName();
        obj1 = "";
        if (!((String) (obj2)).startsWith("get")) goto _L6; else goto _L5
_L5:
        if ("getClass".equals(obj2) || "getDeclaringClass".equals(obj2))
        {
            break MISSING_BLOCK_LABEL_264;
        }
          goto _L7
_L14:
        if (((String) (obj1)).length() <= 0 || !Character.isUpperCase(((String) (obj1)).charAt(0)) || method.getParameterTypes().length != 0) goto _L4; else goto _L8
_L8:
        if (((String) (obj1)).length() != 1) goto _L10; else goto _L9
_L9:
        obj2 = ((String) (obj1)).toLowerCase();
_L12:
        obj1 = method.invoke(obj, (Object[])null);
        if (obj1 != null)
        {
            try
            {
                map.put(obj2, wrap(obj1));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
_L4:
        i++;
        break MISSING_BLOCK_LABEL_32;
_L7:
        obj1 = ((String) (obj2)).substring(3);
        continue; /* Loop/switch isn't completed */
_L6:
        if (((String) (obj2)).startsWith("is"))
        {
            obj1 = ((String) (obj2)).substring(2);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        obj2 = obj1;
        if (Character.isUpperCase(((String) (obj1)).charAt(1))) goto _L12; else goto _L11
_L11:
        obj2 = (new StringBuilder()).append(((String) (obj1)).substring(0, 1).toLowerCase()).append(((String) (obj1)).substring(1)).toString();
          goto _L12
_L2:
        return;
        obj1 = "";
        if (true) goto _L14; else goto _L13
_L13:
    }

    public static Writer quote(String s, Writer writer)
        throws IOException
    {
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
label4:
                        {
label5:
                            {
label6:
                                {
                                    if (s == null || s.length() == 0)
                                    {
                                        writer.write("\"\"");
                                        return writer;
                                    }
                                    char c = '\0';
                                    int k = s.length();
                                    writer.write(34);
                                    int i = 0;
label7:
                                    do
                                    {
                                        {
                                            int j = c;
                                            if (i >= k)
                                            {
                                                break label0;
                                            }
                                            c = s.charAt(i);
                                            switch (c)
                                            {
                                            default:
                                                if (c < ' ' || c >= '\200' && c < '\240' || c >= '\u2000' && c < '\u2100')
                                                {
                                                    writer.write("\\u");
                                                    String s1 = Integer.toHexString(c);
                                                    writer.write("0000", 0, 4 - s1.length());
                                                    writer.write(s1);
                                                } else
                                                {
                                                    writer.write(c);
                                                }
                                                break;

                                            case 8: // '\b'
                                                break label5;

                                            case 9: // '\t'
                                                break label4;

                                            case 10: // '\n'
                                                break label3;

                                            case 12: // '\f'
                                                break label2;

                                            case 13: // '\r'
                                                break label1;

                                            case 34: // '"'
                                            case 92: // '\\'
                                                break label7;

                                            case 47: // '/'
                                                break label6;
                                            }
                                        }
                                        i++;
                                    } while (true);
                                    writer.write(92);
                                    writer.write(c);
                                    break MISSING_BLOCK_LABEL_191;
                                }
                                if (j == 60)
                                {
                                    writer.write(92);
                                }
                                writer.write(c);
                                break MISSING_BLOCK_LABEL_191;
                            }
                            writer.write("\\b");
                            break MISSING_BLOCK_LABEL_191;
                        }
                        writer.write("\\t");
                        break MISSING_BLOCK_LABEL_191;
                    }
                    writer.write("\\n");
                    break MISSING_BLOCK_LABEL_191;
                }
                writer.write("\\f");
                break MISSING_BLOCK_LABEL_191;
            }
            writer.write("\\r");
            break MISSING_BLOCK_LABEL_191;
        }
        writer.write(34);
        return writer;
    }

    public static String quote(String s)
    {
        StringWriter stringwriter = new StringWriter();
        if (true) goto _L2; else goto _L1
_L1:
        stringbuffer;
        JVM INSTR monitorenter ;
_L2:
        synchronized (stringwriter.getBuffer())
        {
            s = quote(s, ((Writer) (stringwriter))).toString();
        }
        return s;
        s;
        stringbuffer;
        JVM INSTR monitorexit ;
        return "";
        s;
        stringbuffer;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static Object stringToValue(String s)
    {
        if (!s.equals("")) goto _L2; else goto _L1
_L1:
        return s;
_L2:
        char c;
        if (s.equalsIgnoreCase("true"))
        {
            return Boolean.TRUE;
        }
        if (s.equalsIgnoreCase("false"))
        {
            return Boolean.FALSE;
        }
        if (s.equalsIgnoreCase("null"))
        {
            return NULL;
        }
        c = s.charAt(0);
        if ((c < '0' || c > '9') && c != '-') goto _L1; else goto _L3
_L3:
        Object obj;
        if (s.indexOf('.') <= -1 && s.indexOf('e') <= -1 && s.indexOf('E') <= -1)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        obj = Double.valueOf(s);
        if (((Double) (obj)).isInfinite() || ((Double) (obj)).isNaN()) goto _L1; else goto _L4
_L4:
        return obj;
        obj = new Long(s);
        if (!s.equals(((Long) (obj)).toString())) goto _L1; else goto _L5
_L5:
        if (((Long) (obj)).longValue() != (long)((Long) (obj)).intValue())
        {
            break MISSING_BLOCK_LABEL_175;
        }
        obj = new Integer(((Long) (obj)).intValue());
        return obj;
        return obj;
        Exception exception;
        exception;
        return s;
    }

    public static void testValidity(Object obj)
        throws JSONException
    {
        if (obj != null)
        {
            if (obj instanceof Double)
            {
                if (((Double)obj).isInfinite() || ((Double)obj).isNaN())
                {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            } else
            if ((obj instanceof Float) && (((Float)obj).isInfinite() || ((Float)obj).isNaN()))
            {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }

    public static Object wrap(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        Object obj1;
        try
        {
            return NULL;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj1 = null;
        }
          goto _L3
_L2:
        obj1 = obj;
        if (obj instanceof JSONObject) goto _L3; else goto _L4
_L4:
        obj1 = obj;
        if (obj instanceof JSONArray) goto _L3; else goto _L5
_L5:
        obj1 = obj;
        if (NULL.equals(obj)) goto _L3; else goto _L6
_L6:
        obj1 = obj;
        if (obj instanceof JSONString) goto _L3; else goto _L7
_L7:
        obj1 = obj;
        if (obj instanceof Byte) goto _L3; else goto _L8
_L8:
        obj1 = obj;
        if (obj instanceof Character) goto _L3; else goto _L9
_L9:
        obj1 = obj;
        if (obj instanceof Short) goto _L3; else goto _L10
_L10:
        obj1 = obj;
        if (obj instanceof Integer) goto _L3; else goto _L11
_L11:
        obj1 = obj;
        if (obj instanceof Long) goto _L3; else goto _L12
_L12:
        obj1 = obj;
        if (obj instanceof Boolean) goto _L3; else goto _L13
_L13:
        obj1 = obj;
        if (obj instanceof Float) goto _L3; else goto _L14
_L14:
        obj1 = obj;
        if (obj instanceof Double) goto _L3; else goto _L15
_L15:
        obj1 = obj;
        if (obj instanceof String) goto _L3; else goto _L16
_L16:
        if (obj instanceof Collection)
        {
            return new JSONArray((Collection)obj);
        }
        if (obj.getClass().isArray())
        {
            return new JSONArray(obj);
        }
        if (obj instanceof Map)
        {
            return new JSONObject((Map)obj);
        }
        obj1 = obj.getClass().getPackage();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_253;
        }
        obj1 = ((Package) (obj1)).getName();
_L17:
        if (((String) (obj1)).startsWith("java.") || ((String) (obj1)).startsWith("javax.") || obj.getClass().getClassLoader() == null)
        {
            return obj.toString();
        }
        obj = new JSONObject(obj);
        return obj;
_L3:
        return obj1;
        obj1 = "";
          goto _L17
    }

    static final Writer writeValue(Writer writer, Object obj, int i, int j)
        throws JSONException, IOException
    {
        if (obj == null || obj.equals(null))
        {
            writer.write("null");
            return writer;
        }
        if (obj instanceof JSONObject)
        {
            ((JSONObject)obj).write(writer, i, j);
            return writer;
        }
        if (obj instanceof JSONArray)
        {
            ((JSONArray)obj).write(writer, i, j);
            return writer;
        }
        if (obj instanceof Map)
        {
            (new JSONObject((Map)obj)).write(writer, i, j);
            return writer;
        }
        if (obj instanceof Collection)
        {
            (new JSONArray((Collection)obj)).write(writer, i, j);
            return writer;
        }
        if (obj.getClass().isArray())
        {
            (new JSONArray(obj)).write(writer, i, j);
            return writer;
        }
        if (obj instanceof Number)
        {
            writer.write(numberToString((Number)obj));
            return writer;
        }
        if (obj instanceof Boolean)
        {
            writer.write(obj.toString());
            return writer;
        }
        if (obj instanceof JSONString)
        {
            String s;
            try
            {
                s = ((JSONString)obj).toJSONString();
            }
            // Misplaced declaration of an exception variable
            catch (Writer writer)
            {
                throw new JSONException(writer);
            }
            if (s != null)
            {
                obj = s.toString();
            } else
            {
                obj = quote(obj.toString());
            }
            writer.write(((String) (obj)));
            return writer;
        } else
        {
            quote(obj.toString(), writer);
            return writer;
        }
    }

    public Object get(String s)
        throws JSONException
    {
        if (s == null)
        {
            throw new JSONException("Null key.");
        }
        Object obj = opt(s);
        if (obj == null)
        {
            throw new JSONException((new StringBuilder()).append("JSONObject[").append(quote(s)).append("] not found.").toString());
        } else
        {
            return obj;
        }
    }

    public boolean getBoolean(String s)
        throws JSONException
    {
        Object obj = get(s);
        if (obj.equals(Boolean.FALSE) || (obj instanceof String) && ((String)obj).equalsIgnoreCase("false"))
        {
            return false;
        }
        if (obj.equals(Boolean.TRUE) || (obj instanceof String) && ((String)obj).equalsIgnoreCase("true"))
        {
            return true;
        } else
        {
            throw new JSONException((new StringBuilder()).append("JSONObject[").append(quote(s)).append("] is not a Boolean.").toString());
        }
    }

    public int getInt(String s)
        throws JSONException
    {
        Object obj = get(s);
        int i;
        try
        {
            if (obj instanceof Number)
            {
                return ((Number)obj).intValue();
            }
            i = Integer.parseInt((String)obj);
        }
        catch (Exception exception)
        {
            throw new JSONException((new StringBuilder()).append("JSONObject[").append(quote(s)).append("] is not an int.").toString());
        }
        return i;
    }

    public long getLong(String s)
        throws JSONException
    {
        Object obj = get(s);
        long l;
        try
        {
            if (obj instanceof Number)
            {
                return ((Number)obj).longValue();
            }
            l = Long.parseLong((String)obj);
        }
        catch (Exception exception)
        {
            throw new JSONException((new StringBuilder()).append("JSONObject[").append(quote(s)).append("] is not a long.").toString());
        }
        return l;
    }

    public String getString(String s)
        throws JSONException
    {
        Object obj = get(s);
        if (obj instanceof String)
        {
            return (String)obj;
        } else
        {
            throw new JSONException((new StringBuilder()).append("JSONObject[").append(quote(s)).append("] not a string.").toString());
        }
    }

    public Set keySet()
    {
        return map.keySet();
    }

    public Iterator keys()
    {
        return keySet().iterator();
    }

    public int length()
    {
        return map.size();
    }

    public Object opt(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return map.get(s);
        }
    }

    public boolean optBoolean(String s, boolean flag)
    {
        boolean flag1;
        try
        {
            flag1 = getBoolean(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return flag;
        }
        return flag1;
    }

    public int optInt(String s, int i)
    {
        int j;
        try
        {
            j = getInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
    }

    public JSONArray optJSONArray(String s)
    {
        s = ((String) (opt(s)));
        if (s instanceof JSONArray)
        {
            return (JSONArray)s;
        } else
        {
            return null;
        }
    }

    public JSONObject optJSONObject(String s)
    {
        s = ((String) (opt(s)));
        if (s instanceof JSONObject)
        {
            return (JSONObject)s;
        } else
        {
            return null;
        }
    }

    public long optLong(String s)
    {
        return optLong(s, 0L);
    }

    public long optLong(String s, long l)
    {
        long l1;
        try
        {
            l1 = getLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return l;
        }
        return l1;
    }

    public String optString(String s)
    {
        return optString(s, "");
    }

    public String optString(String s, String s1)
    {
        s = ((String) (opt(s)));
        if (NULL.equals(s))
        {
            return s1;
        } else
        {
            return s.toString();
        }
    }

    public JSONObject put(String s, Object obj)
        throws JSONException
    {
        if (s == null)
        {
            throw new NullPointerException("Null key.");
        }
        if (obj != null)
        {
            testValidity(obj);
            map.put(s, obj);
            return this;
        } else
        {
            remove(s);
            return this;
        }
    }

    public JSONObject putOnce(String s, Object obj)
        throws JSONException
    {
        if (s != null && obj != null)
        {
            if (opt(s) != null)
            {
                throw new JSONException((new StringBuilder()).append("Duplicate key \"").append(s).append("\"").toString());
            }
            put(s, obj);
        }
        return this;
    }

    public Object remove(String s)
    {
        return map.remove(s);
    }

    public String toString()
    {
        String s;
        try
        {
            s = toString(0);
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    public String toString(int i)
        throws JSONException
    {
        Object obj = new StringWriter();
        synchronized (((StringWriter) (obj)).getBuffer())
        {
            obj = write(((Writer) (obj)), i, 0).toString();
        }
        return ((String) (obj));
        exception;
        stringbuffer;
        JVM INSTR monitorexit ;
        throw exception;
    }

    Writer write(Writer writer, int i, int j)
        throws JSONException
    {
        int k;
        boolean flag = false;
        Object obj;
        Object obj1;
        try
        {
            k = length();
            obj = keys();
            writer.write(123);
        }
        // Misplaced declaration of an exception variable
        catch (Writer writer)
        {
            throw new JSONException(writer);
        }
        if (k != 1) goto _L2; else goto _L1
_L1:
        obj = ((Iterator) (obj)).next();
        writer.write(quote(obj.toString()));
        writer.write(58);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        writer.write(32);
        writeValue(writer, map.get(obj), i, j);
_L4:
        writer.write(125);
        return writer;
_L3:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_189;
        }
        obj1 = ((Iterator) (obj)).next();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        writer.write(44);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        writer.write(10);
        indent(writer, k);
        writer.write(quote(obj1.toString()));
        writer.write(58);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        writer.write(32);
        writeValue(writer, map.get(obj1), i, k);
        flag = true;
          goto _L3
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        writer.write(10);
        indent(writer, j);
          goto _L4
_L2:
        if (k == 0) goto _L4; else goto _L5
_L5:
        k = j + i;
          goto _L3
    }

}
