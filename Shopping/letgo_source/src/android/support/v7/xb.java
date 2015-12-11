// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            ado, lt, abo

final class xb
{

    static lv.a a(int i, JSONArray jsonarray, lv.a aa[], Set set)
        throws xh.g, JSONException
    {
        boolean flag = false;
        int j = 0;
        if (set.contains(Integer.valueOf(i)))
        {
            b((new StringBuilder()).append("Value cycle detected. Current value reference: ").append(i).append(".").append("  Previous value references: ").append(set).append(".").toString());
        }
        Object obj = a(jsonarray, i, "values");
        if (aa[i] != null)
        {
            return aa[i];
        }
        set.add(Integer.valueOf(i));
        lv.a a1 = new lv.a();
        if (obj instanceof JSONArray)
        {
            obj = (JSONArray)obj;
            a1.a = 2;
            a1.l = true;
            for (a1.c = new lv.a[((JSONArray) (obj)).length()]; j < a1.c.length; j++)
            {
                a1.c[j] = a(((JSONArray) (obj)).getInt(j), jsonarray, aa, set);
            }

        } else
        if (obj instanceof JSONObject)
        {
            obj = (JSONObject)obj;
            JSONArray jsonarray1 = ((JSONObject) (obj)).optJSONArray("escaping");
            if (jsonarray1 != null)
            {
                a1.k = new int[jsonarray1.length()];
                for (int k = 0; k < a1.k.length; k++)
                {
                    a1.k[k] = jsonarray1.getInt(k);
                }

            }
            if (((JSONObject) (obj)).has("function_id"))
            {
                a1.a = 5;
                a1.g = ((JSONObject) (obj)).getString("function_id");
            } else
            if (((JSONObject) (obj)).has("macro_reference"))
            {
                a1.a = 4;
                a1.l = true;
                a1.f = ado.a(a(((JSONObject) (obj)).getInt("macro_reference"), jsonarray, aa, set));
            } else
            if (((JSONObject) (obj)).has("template_token"))
            {
                a1.a = 7;
                a1.l = true;
                obj = ((JSONObject) (obj)).getJSONArray("template_token");
                a1.j = new lv.a[((JSONArray) (obj)).length()];
                int l = ((flag) ? 1 : 0);
                while (l < a1.j.length) 
                {
                    a1.j[l] = a(((JSONArray) (obj)).getInt(l), jsonarray, aa, set);
                    l++;
                }
            } else
            {
                a1.a = 3;
                a1.l = true;
                int i1 = ((JSONObject) (obj)).length();
                a1.d = new lv.a[i1];
                a1.e = new lv.a[i1];
                Iterator iterator = ((JSONObject) (obj)).keys();
                i1 = 0;
                while (iterator.hasNext()) 
                {
                    String s = (String)iterator.next();
                    a1.d[i1] = a((new Integer(s)).intValue(), jsonarray, aa, set);
                    a1.e[i1] = a(((JSONObject) (obj)).getInt(s), jsonarray, aa, set);
                    i1++;
                }
            }
        } else
        if (obj instanceof String)
        {
            a1.b = (String)obj;
            a1.a = 1;
        } else
        if (obj instanceof Boolean)
        {
            a1.i = ((Boolean)obj).booleanValue();
            a1.a = 8;
        } else
        if (obj instanceof Integer)
        {
            a1.h = ((Integer)obj).intValue();
            a1.a = 6;
        } else
        {
            b((new StringBuilder()).append("Invalid value type: ").append(obj).toString());
        }
        aa[i] = a1;
        set.remove(Integer.valueOf(i));
        return a1;
    }

    static xh.a a(JSONObject jsonobject, JSONArray jsonarray, JSONArray jsonarray1, lv.a aa[], int i)
        throws xh.g, JSONException
    {
        xh.b b1 = xh.a.a();
        jsonobject = jsonobject.getJSONArray("property");
        i = 0;
        while (i < jsonobject.length()) 
        {
            Object obj = (JSONObject)a(jsonarray, jsonobject.getInt(i), "properties");
            String s = (String)a(jsonarray1, ((JSONObject) (obj)).getInt("key"), "key");
            obj = (lv.a)a(((Object []) (aa)), ((JSONObject) (obj)).getInt("value"), "value");
            if (lt.cl.toString().equals(s))
            {
                b1.a(((lv.a) (obj)));
            } else
            {
                b1.a(s, ((lv.a) (obj)));
            }
            i++;
        }
        return b1.a();
    }

    static xh.c a(String s)
        throws JSONException, xh.g
    {
        s = new JSONObject(s);
        Object obj = s.get("resource");
        lv.a aa[];
        List list;
        List list1;
        Object obj1;
        Object obj2;
        if (obj instanceof JSONObject)
        {
            obj1 = (JSONObject)obj;
            obj = xh.c.a();
            aa = a(((JSONObject) (obj1)));
            obj2 = ((JSONObject) (obj1)).getJSONArray("properties");
            JSONArray jsonarray = ((JSONObject) (obj1)).getJSONArray("key");
            list = a(((JSONObject) (obj1)).getJSONArray("tags"), ((JSONArray) (obj2)), jsonarray, aa);
            list1 = a(((JSONObject) (obj1)).getJSONArray("predicates"), ((JSONArray) (obj2)), jsonarray, aa);
            obj2 = a(((JSONObject) (obj1)).getJSONArray("macros"), ((JSONArray) (obj2)), jsonarray, aa);
            for (Iterator iterator = ((List) (obj2)).iterator(); iterator.hasNext(); ((xh.d) (obj)).a((xh.a)iterator.next())) { }
        } else
        {
            throw new xh.g("Resource map not found");
        }
        obj1 = ((JSONObject) (obj1)).getJSONArray("rules");
        for (int i = 0; i < ((JSONArray) (obj1)).length(); i++)
        {
            ((xh.d) (obj)).a(a(((JSONArray) (obj1)).getJSONObject(i), list, ((List) (obj2)), list1, aa));
        }

        ((xh.d) (obj)).a("1");
        ((xh.d) (obj)).a(1);
        if (s.optJSONArray("runtime") == null);
        return ((xh.d) (obj)).a();
    }

    static xh.e a(JSONObject jsonobject, List list, List list1, List list2, lv.a aa[])
        throws JSONException
    {
        xh.f f = xh.e.a();
        JSONArray jsonarray = jsonobject.optJSONArray("positive_predicate");
        JSONArray jsonarray1 = jsonobject.optJSONArray("negative_predicate");
        JSONArray jsonarray2 = jsonobject.optJSONArray("add_tag");
        JSONArray jsonarray3 = jsonobject.optJSONArray("remove_tag");
        JSONArray jsonarray4 = jsonobject.optJSONArray("add_tag_rule_name");
        JSONArray jsonarray5 = jsonobject.optJSONArray("remove_tag_rule_name");
        JSONArray jsonarray6 = jsonobject.optJSONArray("add_macro");
        JSONArray jsonarray7 = jsonobject.optJSONArray("remove_macro");
        JSONArray jsonarray8 = jsonobject.optJSONArray("add_macro_rule_name");
        jsonobject = jsonobject.optJSONArray("remove_macro_rule_name");
        if (jsonarray != null)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                f.a((xh.a)list2.get(jsonarray.getInt(i)));
            }

        }
        if (jsonarray1 != null)
        {
            for (int j = 0; j < jsonarray1.length(); j++)
            {
                f.b((xh.a)list2.get(jsonarray1.getInt(j)));
            }

        }
        if (jsonarray2 != null)
        {
            for (int k = 0; k < jsonarray2.length(); k++)
            {
                f.c((xh.a)list.get(jsonarray2.getInt(k)));
            }

        }
        if (jsonarray3 != null)
        {
            for (int l = 0; l < jsonarray3.length(); l++)
            {
                f.d((xh.a)list.get(jsonarray3.getInt(l)));
            }

        }
        if (jsonarray4 != null)
        {
            for (int i1 = 0; i1 < jsonarray4.length(); i1++)
            {
                f.a(aa[jsonarray4.getInt(i1)].b);
            }

        }
        if (jsonarray5 != null)
        {
            for (int j1 = 0; j1 < jsonarray5.length(); j1++)
            {
                f.b(aa[jsonarray5.getInt(j1)].b);
            }

        }
        if (jsonarray6 != null)
        {
            for (int k1 = 0; k1 < jsonarray6.length(); k1++)
            {
                f.e((xh.a)list1.get(jsonarray6.getInt(k1)));
            }

        }
        if (jsonarray7 != null)
        {
            for (int l1 = 0; l1 < jsonarray7.length(); l1++)
            {
                f.f((xh.a)list1.get(jsonarray7.getInt(l1)));
            }

        }
        if (jsonarray8 != null)
        {
            for (int i2 = 0; i2 < jsonarray8.length(); i2++)
            {
                f.c(aa[jsonarray8.getInt(i2)].b);
            }

        }
        if (jsonobject != null)
        {
            for (int j2 = 0; j2 < jsonobject.length(); j2++)
            {
                f.d(aa[jsonobject.getInt(j2)].b);
            }

        }
        return f.a();
    }

    private static Object a(JSONArray jsonarray, int i, String s)
        throws xh.g
    {
        if (i < 0 || i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_21;
        }
        jsonarray = ((JSONArray) (jsonarray.get(i)));
        return jsonarray;
        jsonarray;
        b((new StringBuilder()).append("Index out of bounds detected: ").append(i).append(" in ").append(s).toString());
        return null;
    }

    private static Object a(Object aobj[], int i, String s)
        throws xh.g
    {
        if (i < 0 || i >= aobj.length)
        {
            b((new StringBuilder()).append("Index out of bounds detected: ").append(i).append(" in ").append(s).toString());
        }
        return aobj[i];
    }

    static List a(JSONArray jsonarray, JSONArray jsonarray1, JSONArray jsonarray2, lv.a aa[])
        throws JSONException, xh.g
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(a(jsonarray.getJSONObject(i), jsonarray1, jsonarray2, aa, i));
        }

        return arraylist;
    }

    static lv.a[] a(JSONObject jsonobject)
        throws JSONException, xh.g
    {
        jsonobject = ((JSONObject) (jsonobject.opt("values")));
        lv.a aa[];
        if (jsonobject instanceof JSONArray)
        {
            jsonobject = (JSONArray)jsonobject;
            aa = new lv.a[jsonobject.length()];
            for (int i = 0; i < aa.length; i++)
            {
                a(i, ((JSONArray) (jsonobject)), aa, ((Set) (new HashSet(0))));
            }

        } else
        {
            throw new xh.g("Missing Values list");
        }
        return aa;
    }

    private static void b(String s)
        throws xh.g
    {
        abo.a(s);
        throw new xh.g(s);
    }
}
