// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.model;

import android.net.Uri;
import com.perfectcorp.utility.e;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.perfectcorp.model:
//            a

public abstract class Model extends a
{

    public Model()
    {
    }

    public static Model a(Class class1, String s)
    {
        Object obj = null;
        if (class1 != null && s != null) goto _L2; else goto _L1
_L1:
        if (class1 == null) goto _L4; else goto _L3
_L3:
        class1 = (Model)class1.newInstance();
_L6:
        return class1;
        class1;
        e.e(new Object[] {
            class1
        });
_L4:
        class1 = null;
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        class1 = a(class1, new JSONObject(s));
        return class1;
        Exception exception;
        exception;
        class1 = obj;
        if (e.a)
        {
            e.a(new Object[] {
                exception, "; (", s, ")"
            });
            return null;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Model a(Class class1, JSONObject jsonobject)
    {
        Model model;
        try
        {
            model = (Model)class1.newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            e.e(new Object[] {
                class1
            });
            return null;
        }
        if (jsonobject != null && class1 != null) goto _L2; else goto _L1
_L1:
        return model;
_L2:
        Field afield[];
        int i;
        int j;
        afield = class1.getFields();
        j = afield.length;
        i = 0;
_L6:
        if (i >= j) goto _L1; else goto _L3
_L3:
        Field field;
        int k;
        field = afield[i];
        k = field.getModifiers();
        if (Modifier.isPublic(k) && !Modifier.isStatic(k) && !Modifier.isTransient(k)) goto _L5; else goto _L4
_L4:
        i++;
          goto _L6
_L5:
        String s;
        Class class2;
        s = field.getName();
        class2 = field.getType();
label0:
        {
            if (!class2.equals(java/lang/Long) && !class2.equals(Long.TYPE))
            {
                break label0;
            }
            field.set(model, Long.valueOf(jsonobject.getLong(s)));
        }
          goto _L4
label1:
        {
            if (!class2.equals(java/lang/Integer) && !class2.equals(Integer.TYPE))
            {
                break label1;
            }
            field.set(model, Integer.valueOf(jsonobject.getInt(s)));
        }
          goto _L4
label2:
        {
            if (!class2.equals(java/lang/Boolean) && !class2.equals(Boolean.TYPE))
            {
                break label2;
            }
            field.set(model, Boolean.valueOf(jsonobject.getBoolean(s)));
        }
          goto _L4
label3:
        {
            if (!class2.equals(java/lang/Float) && !class2.equals(Float.TYPE))
            {
                break label3;
            }
            field.set(model, Float.valueOf((float)jsonobject.getDouble(s)));
        }
          goto _L4
label4:
        {
            if (!class2.equals(java/lang/Double) && !class2.equals(Double.TYPE))
            {
                break label4;
            }
            field.set(model, Double.valueOf(jsonobject.getDouble(s)));
        }
          goto _L4
label5:
        {
            if (!class2.equals(java/util/Date))
            {
                break label5;
            }
            field.set(model, new Date(jsonobject.getLong(s)));
        }
          goto _L4
        if (!class2.equals(java/lang/String))
        {
            break MISSING_BLOCK_LABEL_429;
        }
        if (!jsonobject.isNull(s))
        {
            break MISSING_BLOCK_LABEL_419;
        }
        class1 = null;
_L7:
        try
        {
            field.set(model, class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            if (e.a)
            {
                e.a(new Object[] {
                    "Parse fail:", class1, " fieldType: ", class2, "; fieldName:", s
                });
            }
        }
          goto _L4
        class1 = jsonobject.getString(s);
          goto _L7
        if (!class2.equals(android/net/Uri))
        {
            break MISSING_BLOCK_LABEL_473;
        }
        if (!jsonobject.isNull(s))
        {
            break MISSING_BLOCK_LABEL_460;
        }
        class1 = null;
_L8:
        field.set(model, class1);
          goto _L4
        class1 = Uri.parse(jsonobject.getString(s));
          goto _L8
label6:
        {
            if (!com/perfectcorp/model/Model.isAssignableFrom(class2))
            {
                break label6;
            }
            field.set(model, a(class2, jsonobject.getJSONObject(s)));
        }
          goto _L4
label7:
        {
            if (!class2.equals(java/util/ArrayList))
            {
                break label7;
            }
            field.set(model, a((Class)((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0], jsonobject.getJSONArray(s)));
        }
          goto _L4
label8:
        {
            if (!class2.equals(com/perfectcorp/model/Model$JSONMap))
            {
                break label8;
            }
            field.set(model, b((Class)((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0], jsonobject.getJSONObject(s)));
        }
          goto _L4
        throw new Exception((new StringBuilder()).append("Unsupported type: ").append(class2.getName()).toString());
    }

    public static String a(Model model)
    {
        return b(model).toString();
    }

    public static ArrayList a(Class class1, JSONArray jsonarray)
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        if (jsonarray == null || class1 == null)
        {
            return arraylist;
        }
        i = 0;
_L29:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        if (!class1.equals(java/lang/Long) && !class1.equals(Long.TYPE)) goto _L4; else goto _L3
_L3:
        arraylist.add(class1.cast(Long.valueOf(jsonarray.getLong(i))));
          goto _L5
_L4:
        if (!class1.equals(java/lang/Integer) && !class1.equals(Integer.TYPE)) goto _L7; else goto _L6
_L6:
        Exception exception;
        arraylist.add(class1.cast(Integer.valueOf(jsonarray.getInt(i))));
          goto _L5
_L7:
        if (!class1.equals(java/lang/Boolean) && !class1.equals(Boolean.TYPE)) goto _L9; else goto _L8
_L8:
        arraylist.add(class1.cast(Boolean.valueOf(jsonarray.getBoolean(i))));
          goto _L5
_L9:
        if (!class1.equals(java/lang/Float) && !class1.equals(Float.TYPE)) goto _L11; else goto _L10
_L10:
        arraylist.add(class1.cast(Double.valueOf(jsonarray.getDouble(i))));
          goto _L5
_L11:
        if (!class1.equals(java/lang/Double) && !class1.equals(Double.TYPE)) goto _L13; else goto _L12
_L12:
        arraylist.add(class1.cast(Double.valueOf(jsonarray.getDouble(i))));
          goto _L5
_L13:
        if (!class1.equals(java/util/Date)) goto _L15; else goto _L14
_L14:
        arraylist.add(class1.cast(Long.valueOf(jsonarray.getLong(i))));
          goto _L5
_L15:
        if (!class1.equals(java/lang/String)) goto _L17; else goto _L16
_L16:
        if (!jsonarray.isNull(i)) goto _L19; else goto _L18
_L18:
        Object obj = null;
_L20:
        try
        {
            arraylist.add(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            if (e.a)
            {
                e.a(new Object[] {
                    exception, "; ", Integer.valueOf(i)
                });
            }
        }
        break; /* Loop/switch isn't completed */
_L19:
        obj = class1.cast(jsonarray.getString(i));
        if (true) goto _L20; else goto _L5
_L17:
        if (!class1.equals(android/net/Uri)) goto _L22; else goto _L21
_L21:
        if (!jsonarray.isNull(i)) goto _L24; else goto _L23
_L23:
        obj = null;
_L25:
        arraylist.add(obj);
          goto _L5
_L24:
        obj = class1.cast(Uri.parse(jsonarray.getString(i)));
          goto _L25
_L22:
        if (!com/perfectcorp/model/Model.isAssignableFrom(class1)) goto _L27; else goto _L26
_L26:
        arraylist.add(a(class1, jsonarray.getJSONObject(i)));
          goto _L5
_L27:
        throw new Exception((new StringBuilder()).append("Unsupported type: ").append(class1.getName()).toString());
_L2:
        return arraylist;
_L5:
        i++;
        if (true) goto _L29; else goto _L28
_L28:
    }

    public static JSONObject a(JSONMap jsonmap)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        jsonmap = jsonmap.entrySet().iterator();
_L2:
        Object obj;
        Object obj1;
        Class class1;
        if (!jsonmap.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (java.util.Map.Entry)jsonmap.next();
        obj = (String)((java.util.Map.Entry) (obj1)).getKey();
        obj1 = ((java.util.Map.Entry) (obj1)).getValue();
        if (obj == null || obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        class1 = obj1.getClass();
        if (class1.equals(java/lang/Long) || class1.equals(Long.TYPE))
        {
            jsonobject.put(((String) (obj)), obj1);
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/Integer) || class1.equals(Integer.TYPE))
        {
            jsonobject.put(((String) (obj)), obj1);
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/Boolean) || class1.equals(Boolean.TYPE))
        {
            jsonobject.put(((String) (obj)), obj1);
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/Float) || class1.equals(Float.TYPE))
        {
            jsonobject.put(((String) (obj)), obj1);
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/Double) || class1.equals(Double.TYPE))
        {
            jsonobject.put(((String) (obj)), obj1);
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/util/Date))
        {
            jsonobject.put(((String) (obj)), ((Date)java/util/Date.cast(obj1)).getTime());
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/String))
        {
            jsonobject.put(((String) (obj)), obj1);
            continue; /* Loop/switch isn't completed */
        }
        if (android/net/Uri.isAssignableFrom(class1))
        {
            jsonobject.put(((String) (obj)), obj1);
            continue; /* Loop/switch isn't completed */
        }
        if (com/perfectcorp/model/Model.isAssignableFrom(class1))
        {
            jsonobject.put(((String) (obj)), b((Model)obj1));
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            throw new Exception((new StringBuilder()).append("Unsupported type: ").append(class1.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        if (true) goto _L2; else goto _L1
_L1:
        return jsonobject;
    }

    public static JSONMap b(Class class1, JSONObject jsonobject)
    {
        JSONMap jsonmap;
        Iterator iterator;
        jsonmap = new JSONMap();
        if (jsonobject == null || class1 == null)
        {
            return jsonmap;
        }
        iterator = jsonobject.keys();
_L13:
        if (iterator == null || !iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s = (String)iterator.next();
        if (!class1.equals(java/lang/Long) && !class1.equals(Long.TYPE)) goto _L4; else goto _L3
_L3:
        Object obj = class1.cast(Long.valueOf(jsonobject.getLong(s)));
_L11:
        if (obj != null)
        {
            jsonmap.put(s, obj);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (class1.equals(java/lang/Integer) || class1.equals(Integer.TYPE))
        {
            obj = class1.cast(Integer.valueOf(jsonobject.getInt(s)));
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/Boolean) || class1.equals(Boolean.TYPE))
        {
            obj = class1.cast(Boolean.valueOf(jsonobject.getBoolean(s)));
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/Float) || class1.equals(Float.TYPE))
        {
            obj = class1.cast(Double.valueOf(jsonobject.getDouble(s)));
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/Double) || class1.equals(Double.TYPE))
        {
            obj = class1.cast(Double.valueOf(jsonobject.getDouble(s)));
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/util/Date))
        {
            obj = class1.cast(new Date(jsonobject.getLong(s)));
            continue; /* Loop/switch isn't completed */
        }
        if (!class1.equals(java/lang/String))
        {
            break MISSING_BLOCK_LABEL_312;
        }
        if (!jsonobject.isNull(s))
        {
            break MISSING_BLOCK_LABEL_302;
        }
        obj = null;
_L5:
        obj = class1.cast(obj);
        continue; /* Loop/switch isn't completed */
        obj = jsonobject.getString(s);
          goto _L5
        if (!class1.equals(android/net/Uri)) goto _L7; else goto _L6
_L6:
        if (!jsonobject.isNull(s)) goto _L9; else goto _L8
_L8:
        obj = null;
_L10:
        obj = class1.cast(obj);
        continue; /* Loop/switch isn't completed */
_L9:
        obj = Uri.parse(jsonobject.getString(s));
        if (true) goto _L10; else goto _L7
_L7:
        if (com/perfectcorp/model/Model.isAssignableFrom(class1))
        {
            obj = a(class1, jsonobject.getJSONObject(s));
            continue; /* Loop/switch isn't completed */
        }
        Exception exception;
        try
        {
            throw new Exception((new StringBuilder()).append("Unsupported type: ").append(class1.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        if (e.a)
        {
            e.a(new Object[] {
                "Parse fail: fieldType: ", class1, "; reason", exception
            });
        }
        exception = null;
        if (true) goto _L11; else goto _L2
_L2:
        return jsonmap;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public static ArrayList b(Class class1, String s)
    {
        if (class1 == null || s == null)
        {
            return new ArrayList();
        }
        try
        {
            class1 = a(class1, new JSONArray(s));
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            if (e.a)
            {
                e.a(new Object[] {
                    class1, "; (", s, ")"
                });
            }
            return new ArrayList();
        }
        return class1;
    }

    public static JSONArray b(ArrayList arraylist)
    {
        JSONArray jsonarray;
        Class class1;
        jsonarray = new JSONArray();
        if (arraylist == null || arraylist.isEmpty())
        {
            return jsonarray;
        }
        class1 = arraylist.get(0).getClass();
        arraylist = arraylist.iterator();
_L2:
        Object obj;
        if (!arraylist.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = arraylist.next();
        if (class1.equals(java/lang/Long) || class1.equals(Long.TYPE))
        {
            jsonarray.put(obj);
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/Integer) || class1.equals(Integer.TYPE))
        {
            jsonarray.put(obj);
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/Boolean) || class1.equals(Boolean.TYPE))
        {
            jsonarray.put(obj);
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/Float) || class1.equals(Float.TYPE))
        {
            jsonarray.put(obj);
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/Double) || class1.equals(Double.TYPE))
        {
            jsonarray.put(obj);
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/util/Date))
        {
            jsonarray.put(((Date)java/util/Date.cast(obj)).getTime());
            continue; /* Loop/switch isn't completed */
        }
        if (class1.equals(java/lang/String))
        {
            jsonarray.put(obj);
            continue; /* Loop/switch isn't completed */
        }
        if (android/net/Uri.isAssignableFrom(class1))
        {
            jsonarray.put(obj);
            continue; /* Loop/switch isn't completed */
        }
        if (com/perfectcorp/model/Model.isAssignableFrom(class1))
        {
            jsonarray.put(b((Model)obj));
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            jsonarray.put(obj);
            throw new Exception((new StringBuilder()).append("Unsupported type: ").append(class1.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        if (true) goto _L2; else goto _L1
_L1:
        return jsonarray;
    }

    public static JSONObject b(Model model)
    {
        JSONObject jsonobject;
        Class class1;
        Field afield[];
        int i;
        int j;
        jsonobject = new JSONObject();
        class1 = model.getClass();
        if (class1 == null || model == null)
        {
            return jsonobject;
        }
        afield = class1.getFields();
        if (afield == null)
        {
            return jsonobject;
        }
        j = afield.length;
        i = 0;
_L2:
        Object obj;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_590;
        }
        obj = afield[i];
        int k = ((Field) (obj)).getModifiers();
        if (Modifier.isPublic(k) && !Modifier.isStatic(k) && !Modifier.isTransient(k))
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        String s;
        Class class2;
        s = ((Field) (obj)).getName();
        class2 = ((Field) (obj)).getType();
        if (((Field) (obj)).get(model) == null) goto _L4; else goto _L3
_L3:
        if (!class2.equals(java/lang/Long) && !class2.equals(Long.TYPE))
        {
            break MISSING_BLOCK_LABEL_210;
        }
        jsonobject.put(s, ((Field) (obj)).get(model));
          goto _L4
        try
        {
            throw new Exception((new StringBuilder()).append("Unsupported type: ").append(class2.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (e.a)
        {
            e.a(new Object[] {
                obj, "; ", class1, "; ", class2, " ", s
            });
        }
          goto _L4
label0:
        {
            if (!class2.equals(java/lang/Integer) && !class2.equals(Integer.TYPE))
            {
                break label0;
            }
            jsonobject.put(s, ((Field) (obj)).get(model));
        }
          goto _L4
label1:
        {
            if (!class2.equals(java/lang/Boolean) && !class2.equals(Boolean.TYPE))
            {
                break label1;
            }
            jsonobject.put(s, ((Field) (obj)).get(model));
        }
          goto _L4
label2:
        {
            if (!class2.equals(java/lang/Float) && !class2.equals(Float.TYPE))
            {
                break label2;
            }
            jsonobject.put(s, ((Field) (obj)).get(model));
        }
          goto _L4
label3:
        {
            if (!class2.equals(java/lang/Double) && !class2.equals(Double.TYPE))
            {
                break label3;
            }
            jsonobject.put(s, ((Field) (obj)).get(model));
        }
          goto _L4
label4:
        {
            if (!class2.equals(java/util/Date))
            {
                break label4;
            }
            jsonobject.put(s, ((Date)java/util/Date.cast(((Field) (obj)).get(model))).getTime());
        }
          goto _L4
label5:
        {
            if (!class2.equals(java/lang/String))
            {
                break label5;
            }
            jsonobject.put(s, java/lang/String.cast(((Field) (obj)).get(model)));
        }
          goto _L4
label6:
        {
            if (!class2.equals(android/net/Uri))
            {
                break label6;
            }
            jsonobject.put(s, ((Uri)android/net/Uri.cast(((Field) (obj)).get(model))).toString());
        }
          goto _L4
label7:
        {
            if (!com/perfectcorp/model/Model.isAssignableFrom(class2))
            {
                break label7;
            }
            jsonobject.put(s, b((Model)((Field) (obj)).get(model)));
        }
          goto _L4
label8:
        {
            if (!class2.equals(java/util/ArrayList))
            {
                break label8;
            }
            jsonobject.put(s, b((ArrayList)((Field) (obj)).get(model)));
        }
          goto _L4
label9:
        {
            if (!class2.equals(com/perfectcorp/model/Model$JSONMap))
            {
                break label9;
            }
            jsonobject.put(s, a((JSONMap)((Field) (obj)).get(model)));
        }
          goto _L4
        return jsonobject;
          goto _L4
    }

    public Long b_()
    {
        return null;
    }

    public String toString()
    {
        return a(this);
    }

    private class JSONMap extends LinkedHashMap
    {

        private static final long serialVersionUID = 0x44a8b56c4a587307L;

        public String toString()
        {
            return Model.a(this).toString();
        }

        public JSONMap()
        {
        }
    }

}
