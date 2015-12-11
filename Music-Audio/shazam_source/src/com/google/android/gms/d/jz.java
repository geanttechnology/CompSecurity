// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.e.aj;
import com.google.android.gms.e.cj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            f

final class jz
{

    private static h.a a(int i, JSONArray jsonarray, h.a aa[], Set set)
    {
        boolean flag = false;
        int j = 0;
        if (set.contains(Integer.valueOf(i)))
        {
            b((new StringBuilder("Value cycle detected. Current value reference: ")).append(i).append(".  Previous value references: ").append(set).append(".").toString());
        }
        Object obj = a(jsonarray, i, "values");
        if (aa[i] != null)
        {
            return aa[i];
        }
        set.add(Integer.valueOf(i));
        h.a a1 = new h.a();
        if (obj instanceof JSONArray)
        {
            obj = (JSONArray)obj;
            a1.a = 2;
            a1.l = true;
            for (a1.c = new h.a[((JSONArray) (obj)).length()]; j < a1.c.length; j++)
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
                a1.f = cj.a(a(((JSONObject) (obj)).getInt("macro_reference"), jsonarray, aa, set));
            } else
            if (((JSONObject) (obj)).has("template_token"))
            {
                a1.a = 7;
                a1.l = true;
                obj = ((JSONObject) (obj)).getJSONArray("template_token");
                a1.j = new h.a[((JSONArray) (obj)).length()];
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
                a1.d = new h.a[i1];
                a1.e = new h.a[i1];
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
            b((new StringBuilder("Invalid value type: ")).append(obj).toString());
        }
        aa[i] = a1;
        set.remove(Integer.valueOf(i));
        return a1;
    }

    private static kf.a a(JSONObject jsonobject, JSONArray jsonarray, JSONArray jsonarray1, h.a aa[])
    {
        kf.b b1 = new kf.b((byte)0);
        jsonobject = jsonobject.getJSONArray("property");
        int i = 0;
        while (i < jsonobject.length()) 
        {
            Object obj = (JSONObject)a(jsonarray, jsonobject.getInt(i), "properties");
            String s = (String)a(jsonarray1, ((JSONObject) (obj)).getInt("key"), "key");
            int j = ((JSONObject) (obj)).getInt("value");
            if (j < 0 || j >= aa.length)
            {
                b((new StringBuilder("Index out of bounds detected: ")).append(j).append(" in ").append("value").toString());
            }
            obj = (h.a)aa[j];
            if (f.cl.toString().equals(s))
            {
                b1.b = ((h.a) (obj));
            } else
            {
                b1.a.put(s, obj);
            }
            i++;
        }
        return new kf.a(b1.a, b1.b, (byte)0);
    }

    static kf.c a(String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        s = ((String) (jsonobject.get("resource")));
        kf.d d;
        h.a aa[];
        List list1;
        List list2;
        JSONObject jsonobject1;
        List list3;
        if (s instanceof JSONObject)
        {
            jsonobject1 = (JSONObject)s;
            d = new kf.d((byte)0);
            aa = a(jsonobject1);
            s = jsonobject1.getJSONArray("properties");
            JSONArray jsonarray = jsonobject1.getJSONArray("key");
            list1 = a(jsonobject1.getJSONArray("tags"), ((JSONArray) (s)), jsonarray, aa);
            list2 = a(jsonobject1.getJSONArray("predicates"), ((JSONArray) (s)), jsonarray, aa);
            list3 = a(jsonobject1.getJSONArray("macros"), ((JSONArray) (s)), jsonarray, aa);
            kf.a a1;
            for (Iterator iterator = list3.iterator(); iterator.hasNext(); s.add(a1))
            {
                a1 = (kf.a)iterator.next();
                String s1 = cj.a((h.a)Collections.unmodifiableMap(a1.a).get(f.bk.toString()));
                List list = (List)d.b.get(s1);
                s = list;
                if (list == null)
                {
                    s = new ArrayList();
                    d.b.put(s1, s);
                }
            }

        } else
        {
            throw new kf.g("Resource map not found");
        }
        s = jsonobject1.getJSONArray("rules");
        for (int i = 0; i < s.length(); i++)
        {
            kf.e e = a(s.getJSONObject(i), list1, list3, list2, aa);
            d.a.add(e);
        }

        d.c = "1";
        d.d = 1;
        jsonobject.optJSONArray("runtime");
        return new kf.c(d.a, d.b, d.c, d.d, (byte)0);
    }

    private static kf.e a(JSONObject jsonobject, List list, List list1, List list2, h.a aa[])
    {
        kf.f f1 = new kf.f((byte)0);
        JSONArray jsonarray8 = jsonobject.optJSONArray("positive_predicate");
        JSONArray jsonarray7 = jsonobject.optJSONArray("negative_predicate");
        JSONArray jsonarray6 = jsonobject.optJSONArray("add_tag");
        JSONArray jsonarray5 = jsonobject.optJSONArray("remove_tag");
        JSONArray jsonarray4 = jsonobject.optJSONArray("add_tag_rule_name");
        JSONArray jsonarray3 = jsonobject.optJSONArray("remove_tag_rule_name");
        JSONArray jsonarray2 = jsonobject.optJSONArray("add_macro");
        JSONArray jsonarray1 = jsonobject.optJSONArray("remove_macro");
        JSONArray jsonarray = jsonobject.optJSONArray("add_macro_rule_name");
        jsonobject = jsonobject.optJSONArray("remove_macro_rule_name");
        if (jsonarray8 != null)
        {
            for (int i = 0; i < jsonarray8.length(); i++)
            {
                kf.a a2 = (kf.a)list2.get(jsonarray8.getInt(i));
                f1.a.add(a2);
            }

        }
        if (jsonarray7 != null)
        {
            for (int j = 0; j < jsonarray7.length(); j++)
            {
                kf.a a1 = (kf.a)list2.get(jsonarray7.getInt(j));
                f1.b.add(a1);
            }

        }
        if (jsonarray6 != null)
        {
            for (int k = 0; k < jsonarray6.length(); k++)
            {
                list2 = (kf.a)list.get(jsonarray6.getInt(k));
                f1.c.add(list2);
            }

        }
        if (jsonarray5 != null)
        {
            for (int l = 0; l < jsonarray5.length(); l++)
            {
                list2 = (kf.a)list.get(jsonarray5.getInt(l));
                f1.d.add(list2);
            }

        }
        if (jsonarray4 != null)
        {
            for (int i1 = 0; i1 < jsonarray4.length(); i1++)
            {
                list = aa[jsonarray4.getInt(i1)].b;
                f1.i.add(list);
            }

        }
        if (jsonarray3 != null)
        {
            for (int j1 = 0; j1 < jsonarray3.length(); j1++)
            {
                list = aa[jsonarray3.getInt(j1)].b;
                f1.j.add(list);
            }

        }
        if (jsonarray2 != null)
        {
            for (int k1 = 0; k1 < jsonarray2.length(); k1++)
            {
                list = (kf.a)list1.get(jsonarray2.getInt(k1));
                f1.e.add(list);
            }

        }
        if (jsonarray1 != null)
        {
            for (int l1 = 0; l1 < jsonarray1.length(); l1++)
            {
                list = (kf.a)list1.get(jsonarray1.getInt(l1));
                f1.f.add(list);
            }

        }
        if (jsonarray != null)
        {
            for (int i2 = 0; i2 < jsonarray.length(); i2++)
            {
                list = aa[jsonarray.getInt(i2)].b;
                f1.g.add(list);
            }

        }
        if (jsonobject != null)
        {
            for (int j2 = 0; j2 < jsonobject.length(); j2++)
            {
                list = aa[jsonobject.getInt(j2)].b;
                f1.h.add(list);
            }

        }
        return new kf.e(f1.a, f1.b, f1.c, f1.d, f1.e, f1.f, f1.g, f1.h, f1.i, f1.j, (byte)0);
    }

    private static Object a(JSONArray jsonarray, int i, String s)
    {
        if (i < 0 || i >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_21;
        }
        jsonarray = ((JSONArray) (jsonarray.get(i)));
        return jsonarray;
        jsonarray;
        b((new StringBuilder("Index out of bounds detected: ")).append(i).append(" in ").append(s).toString());
        return null;
    }

    private static List a(JSONArray jsonarray, JSONArray jsonarray1, JSONArray jsonarray2, h.a aa[])
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(a(jsonarray.getJSONObject(i), jsonarray1, jsonarray2, aa));
        }

        return arraylist;
    }

    private static h.a[] a(JSONObject jsonobject)
    {
        jsonobject = ((JSONObject) (jsonobject.opt("values")));
        h.a aa[];
        if (jsonobject instanceof JSONArray)
        {
            jsonobject = (JSONArray)jsonobject;
            aa = new h.a[jsonobject.length()];
            for (int i = 0; i < aa.length; i++)
            {
                a(i, ((JSONArray) (jsonobject)), aa, ((Set) (new HashSet(0))));
            }

        } else
        {
            throw new kf.g("Missing Values list");
        }
        return aa;
    }

    private static void b(String s)
    {
        aj.a(s);
        throw new kf.g(s);
    }
}
