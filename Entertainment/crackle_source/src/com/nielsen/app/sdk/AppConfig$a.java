// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nielsen.app.sdk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.nielsen.app.sdk:
//            AppConfig, AppNative, c

class a
{

    Map a;
    Map b;
    String c;
    final AppConfig d;
    private long e;
    private boolean f;
    private int g;
    private String h;
    private Map i;
    private String j;
    private List k;
    private Map l;
    private boolean m;
    private List n;

    public long a(long l1, long l2, long l3, String s)
    {
        if (b())
        {
            return AppConfig.b(d).urlParserCalculatePosition(e, l1, l2, l3, s);
        } else
        {
            return -1L;
        }
    }

    public String a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (l == null) goto _L2; else goto _L1
_L1:
        s = (String)l.get(s);
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = "";
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public String a(String s, boolean aflag[])
    {
        String s1;
        String s2;
        String s3;
        s3 = "";
        s1 = s3;
        s2 = s3;
        if (!b())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        s2 = s3;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        s1 = s3;
        if (s.isEmpty())
        {
            return "";
        }
        s1 = s3;
        String as[] = new String[1];
        as[0] = "";
        s1 = s3;
        s3 = AppConfig.b(d).a(e, s, aflag, as);
        s2 = s3;
        if (aflag[0])
        {
            break MISSING_BLOCK_LABEL_138;
        }
        s1 = s3;
        com.nielsen.app.sdk.c.a(1, 'E', "Could not parse(%s). Error(%s)", new Object[] {
            s, as[0]
        });
        return s3;
        aflag;
        com.nielsen.app.sdk.c.a(aflag, true, 1, 'E', "Could not parse(%s)", new Object[] {
            s
        });
        s2 = s1;
        return s2;
    }

    public Map a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        Map map = (Map)n.get(i1);
        this;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        throw exception;
    }

    public Map a(HashMap hashmap)
    {
        if (e == 0L)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        if (hashmap.isEmpty())
        {
            break MISSING_BLOCK_LABEL_27;
        }
        a(((Map) (null)), ((Map) (hashmap)));
        if (j == null || j.isEmpty())
        {
            break MISSING_BLOCK_LABEL_143;
        }
        hashmap = new boolean[1];
        hashmap[0] = 0;
        String s = a(j, ((boolean []) (hashmap)));
        if (hashmap[0] != 0 && s != null)
        {
            try
            {
                if (!s.isEmpty())
                {
                    hashmap = new JSONObject(s);
                    String s1;
                    for (Iterator iterator = hashmap.keys(); iterator.hasNext(); a(s1, (String)hashmap.get(s1)))
                    {
                        s1 = (String)iterator.next();
                    }

                }
            }
            // Misplaced declaration of an exception variable
            catch (HashMap hashmap)
            {
                com.nielsen.app.sdk.c.a(hashmap, true, 1, 'E', "Could not parse the CMS data", new Object[0]);
            }
        }
        return l;
    }

    public Map a(Map map)
    {
        return a(((Map) (null)), map);
    }

    public Map a(Map map, Map map1)
    {
        if (map != null && !map.isEmpty())
        {
            String s1;
            String s3;
            for (Iterator iterator1 = map.keySet().iterator(); iterator1.hasNext(); i.put(s1, s3))
            {
                String s = (String)iterator1.next();
                s3 = (String)map.get(s);
                for (s = s.trim(); (s.startsWith("(") || s.startsWith("<")) && (s.endsWith(")") || s.endsWith(">")); s = s.substring(1, s.length() - 1)) { }
                for (s1 = s3.trim(); (s1.startsWith("(") || s1.startsWith("<")) && (s1.endsWith(")") || s1.endsWith(">")); s1 = s1.substring(1, s1.length() - 1)) { }
                i.put(s, s3);
            }

            j = (new JSONObject(i)).toString();
            j = j.replaceAll("\\s", "");
            j = j.replace(":\"", ":\"|![");
            j = j.replace("\",", "]!|\",");
            j = j.replace("\"}", "]!|\"}");
        }
        if (l == null || l.isEmpty())
        {
            m = true;
        }
        if (map1 == null || map1.isEmpty()) goto _L2; else goto _L1
_L1:
        Iterator iterator = map1.keySet().iterator();
_L3:
        String s2;
        Object obj;
        boolean flag;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (String)iterator.next();
        s2 = (String)map1.get(obj);
        map = "";
        Iterator iterator2 = i.keySet().iterator();
        String s5;
        do
        {
            if (!iterator2.hasNext())
            {
                break MISSING_BLOCK_LABEL_530;
            }
            s5 = (String)iterator2.next();
        } while (s5.compareToIgnoreCase(((String) (obj))) != 0);
        map = (String)i.get(s5);
        flag = true;
_L4:
        if (flag)
        {
            obj = i.keySet().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s4 = (String)((Iterator) (obj)).next();
                if (map.compareToIgnoreCase((String)i.get(s4)) == 0)
                {
                    a(s4, s2);
                }
            }
        } else
        {
            a(((String) (obj)), s2);
        }
        if (true) goto _L3; else goto _L2
_L2:
        return l;
        flag = false;
          goto _L4
    }

    public Map a(JSONObject jsonobject)
        throws JSONException
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s, (String)jsonobject.get(s)))
        {
            s = (String)iterator.next();
        }

        return a(hashmap);
    }

    public void a()
    {
        e = 0L;
    }

    public void a(int i1, String s, String s1, String s2, String s3, Map map)
        throws JSONException
    {
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap;
        hashmap = new HashMap();
        hashmap.put("nol_comment", s);
        hashmap.put("nol_product", s1);
        hashmap.put("nol_cadence", s2);
        hashmap.put("nol_url", s3);
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        for (s = map.keySet().iterator(); s.hasNext(); hashmap.put(s1, (String)map.get(s1)))
        {
            s1 = (String)s.next();
        }

        break MISSING_BLOCK_LABEL_115;
        s;
        throw s;
        if (i1 >= n.size())
        {
            break MISSING_BLOCK_LABEL_154;
        }
        n.remove(i1);
        n.add(i1, hashmap);
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        n.add(hashmap);
          goto _L1
    }

    public void a(long l1)
    {
        e = l1;
        m = true;
    }

    public void a(String s, int i1)
    {
        g = i1;
        h = s;
    }

    public void a(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        String s2;
        if (l == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        s2 = (String)l.put(s, s1);
        if (m || s1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        if (s2.compareTo(s1) == 0)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        k.add(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public boolean a(List list, Map map, boolean flag)
    {
        Object obj2;
        Map map1;
        pRule prule;
        if (list == null)
        {
            return false;
        }
        int i1;
        int k1;
        if (map != null && !map.isEmpty() && !flag)
        {
            obj2 = new HashMap(l);
            String s;
            for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); ((Map) (obj2)).put(s, (String)map.get(s)))
            {
                s = (String)iterator.next();
            }

            map1 = l;
        } else
        {
            if (map != null && !map.isEmpty())
            {
                String s1;
                for (Iterator iterator1 = map.keySet().iterator(); iterator1.hasNext(); a(s1, (String)map.get(s1)))
                {
                    s1 = (String)iterator1.next();
                }

            }
            obj2 = l;
            map1 = l;
        }
        k1 = list.size();
        i1 = 0;
        if (i1 >= k1) goto _L2; else goto _L1
_L1:
        prule = (pRule)list.get(i1);
        if (prule != null) goto _L4; else goto _L3
_L3:
        com.nielsen.app.sdk.c.a(3, 'E', "Could not parse filter(%i) on (%s)", new Object[] {
            Integer.valueOf(i1), list.toString()
        });
_L6:
        i1++;
        break MISSING_BLOCK_LABEL_112;
_L4:
        Object obj;
        Object obj1;
        obj1 = prule.getTagVarName();
        obj = prule.getTagVarValue();
        obj1 = (String)map1.get(obj1);
        if (obj1 == null || ((String) (obj1)).isEmpty() || ((String) (obj1)).compareToIgnoreCase(((String) (obj))) != 0) goto _L6; else goto _L5
_L5:
        String s3;
        s3 = prule.getIsType();
        obj = prule.getIsValue();
        obj1 = (String)map1.get(obj);
        if (obj1 != null && !((String) (obj1)).isEmpty())
        {
            obj = obj1;
        }
        int l1 = prule.getConditionSize();
        boolean flag1;
        int j1;
        boolean flag4;
        j1 = 0;
        flag4 = false;
        flag1 = true;
_L70:
        if (j1 >= l1) goto _L8; else goto _L7
_L7:
        Object obj4 = prule.getCondition(j1);
        obj1 = obj;
        if (obj4 == null) goto _L10; else goto _L9
_L9:
        obj1 = obj;
        if (((String) (obj4)).isEmpty()) goto _L10; else goto _L11
_L11:
        if (((String) (obj4)).startsWith("nol_")) goto _L13; else goto _L12
_L13:
        Object obj3 = (String)map1.get(obj4);
        if (obj3 == null) goto _L15; else goto _L14
_L14:
        obj1 = obj3;
        if (!((String) (obj3)).isEmpty()) goto _L16; else goto _L15
_L16:
        obj3 = obj1;
        if (!((String) (obj1)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_498;
        }
        if (((String) (obj4)).compareToIgnoreCase("nol_fdcid") == 0)
        {
            break MISSING_BLOCK_LABEL_492;
        }
        obj3 = obj1;
        if (((String) (obj4)).compareToIgnoreCase("nol_pccid") != 0)
        {
            break MISSING_BLOCK_LABEL_498;
        }
        obj3 = h;
        String s5;
        obj = ((String) (obj)).trim();
        obj3 = ((String) (obj3)).trim();
        obj4 = Pattern.compile((new StringBuilder()).append("\\b").append(((String) (obj))).append("\\b").toString());
        s5 = (new StringBuilder()).append("\\b").append(((String) (obj3))).append("\\b").toString();
        obj1 = Pattern.compile(s5);
        if (s3.compareToIgnoreCase("+") != 0) goto _L18; else goto _L17
_L17:
        if (!flag1) goto _L20; else goto _L19
_L19:
        flag1 = false;
        if (((String) (obj)).isEmpty() || ((String) (obj3)).isEmpty()) goto _L22; else goto _L21
_L21:
        if (((String) (obj)).compareTo(((String) (obj3))) != 0) goto _L24; else goto _L23
_L23:
        flag4 = true;
          goto _L12
_L24:
        flag4 = ((Pattern) (obj1)).matcher(((CharSequence) (obj))).find();
          goto _L12
_L20:
        boolean flag5;
        boolean flag6;
        flag6 = false;
        flag5 = flag6;
        if (((String) (obj)).isEmpty()) goto _L26; else goto _L25
_L25:
        flag5 = flag6;
        if (((String) (obj3)).isEmpty()) goto _L26; else goto _L27
_L27:
        if (((String) (obj)).compareTo(((String) (obj3))) != 0) goto _L29; else goto _L28
_L28:
        flag5 = true;
          goto _L26
_L29:
        flag5 = ((Pattern) (obj1)).matcher(((CharSequence) (obj))).find();
          goto _L26
_L18:
        if (s3.compareToIgnoreCase("-") != 0) goto _L31; else goto _L30
_L30:
        if (!flag1) goto _L33; else goto _L32
_L32:
        flag1 = false;
        if (((String) (obj)).isEmpty() || ((String) (obj3)).isEmpty()) goto _L22; else goto _L34
_L34:
        if (((String) (obj)).compareTo(((String) (obj3))) != 0) goto _L36; else goto _L35
_L35:
        flag4 = false;
          goto _L12
_L36:
        boolean flag2;
        boolean flag3;
        if (!((Pattern) (obj1)).matcher(((CharSequence) (obj))).find())
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
          goto _L12
_L33:
        flag3 = false;
        flag2 = flag3;
        if (((String) (obj)).isEmpty()) goto _L38; else goto _L37
_L37:
        flag2 = flag3;
        if (((String) (obj3)).isEmpty()) goto _L38; else goto _L39
_L39:
        if (((String) (obj)).compareTo(((String) (obj3))) != 0) goto _L41; else goto _L40
_L40:
        flag2 = false;
          goto _L38
_L41:
        if (!((Pattern) (obj1)).matcher(((CharSequence) (obj))).find())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
          goto _L38
_L31:
        if (s3.compareToIgnoreCase("++") != 0) goto _L43; else goto _L42
_L42:
        if (!flag1) goto _L45; else goto _L44
_L44:
        flag1 = false;
        if (((String) (obj)).isEmpty() || ((String) (obj3)).isEmpty()) goto _L22; else goto _L46
_L46:
        if (((String) (obj)).compareTo(((String) (obj3))) != 0) goto _L48; else goto _L47
_L47:
        flag4 = true;
          goto _L12
_L48:
        flag4 = ((Pattern) (obj4)).matcher(s5).find();
          goto _L12
_L45:
        flag6 = false;
        flag5 = flag6;
        if (((String) (obj)).isEmpty()) goto _L50; else goto _L49
_L49:
        flag5 = flag6;
        if (((String) (obj3)).isEmpty()) goto _L50; else goto _L51
_L51:
        if (((String) (obj)).compareTo(((String) (obj3))) != 0) goto _L53; else goto _L52
_L52:
        flag5 = true;
          goto _L50
_L53:
        flag5 = ((Pattern) (obj4)).matcher(s5).find();
          goto _L50
_L43:
        obj1 = obj;
        if (s3.compareToIgnoreCase("--") != 0) goto _L10; else goto _L54
_L54:
        if (!flag1) goto _L56; else goto _L55
_L55:
        flag1 = false;
        if (((String) (obj)).isEmpty() || ((String) (obj3)).isEmpty()) goto _L22; else goto _L57
_L57:
        if (((String) (obj)).compareTo(((String) (obj3))) != 0) goto _L59; else goto _L58
_L58:
        flag4 = false;
          goto _L12
_L59:
        if (!((Pattern) (obj4)).matcher(s5).find())
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
          goto _L12
_L56:
        flag3 = false;
        flag2 = flag3;
        if (((String) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_1551;
        }
        flag2 = flag3;
        if (((String) (obj3)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_1551;
        }
        if (((String) (obj)).compareTo(((String) (obj3))) == 0)
        {
            flag2 = false;
            break MISSING_BLOCK_LABEL_1551;
        }
        String s2;
        String s4;
        if (!((Pattern) (obj4)).matcher(s5).find())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        break MISSING_BLOCK_LABEL_1551;
_L8:
        if (flag1) goto _L6; else goto _L60
_L60:
        if (!flag4) goto _L62; else goto _L61
_L61:
        if (prule.getResultSize() <= 0) goto _L64; else goto _L63
_L63:
        obj = prule.getResults();
_L69:
        if (obj == null) goto _L6; else goto _L65
_L65:
        if (((Map) (obj)).isEmpty()) goto _L6; else goto _L66
_L66:
        obj4 = ((Map) (obj)).keySet().iterator();
_L68:
        if (!((Iterator) (obj4)).hasNext()) goto _L6; else goto _L67
_L67:
        s5 = (String)((Iterator) (obj4)).next();
        s2 = (String)((Map) (obj)).get(s5);
        obj1 = s2;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_1261;
        }
        obj1 = s2;
        if (s2.isEmpty())
        {
            break MISSING_BLOCK_LABEL_1261;
        }
        obj1 = s2;
        if (!s2.startsWith("nol_"))
        {
            break MISSING_BLOCK_LABEL_1261;
        }
        s4 = (String)map1.get(s2);
        obj1 = s2;
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_1261;
        }
        obj1 = s2;
        if (!s4.isEmpty())
        {
            obj1 = s4;
        }
        if (s5.compareToIgnoreCase("nol_disabled") != 0 || obj1 == null)
        {
            break MISSING_BLOCK_LABEL_1318;
        }
        if (((String) (obj1)).compareToIgnoreCase(Boolean.TRUE.toString()) == 0)
        {
            com.nielsen.app.sdk.c.a('I', "(%s) disabled by rule: %s", new Object[] {
                g(), prule.toString()
            });
        }
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_1388;
        }
        if (map.isEmpty() || flag)
        {
            break MISSING_BLOCK_LABEL_1388;
        }
        ((Map) (obj2)).put(s5, obj1);
          goto _L68
        obj;
        com.nielsen.app.sdk.c.a(3, 'E', "Cound not evaluate conditions on rule", new Object[0]);
          goto _L6
_L64:
        obj = prule.getThen();
          goto _L69
_L62:
        obj = prule.getElse();
          goto _L69
        a(s5, ((String) (obj1)));
          goto _L68
_L2:
        if (map != null && !map.isEmpty() && !flag)
        {
            l.putAll(((Map) (obj2)));
        }
        return true;
_L22:
        flag1 = false;
        flag4 = false;
          goto _L12
_L10:
        obj = obj1;
_L12:
        j1++;
          goto _L70
_L15:
        obj1 = "";
          goto _L16
_L26:
        if (flag4 && flag5)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
          goto _L12
_L38:
        if (flag4 && flag2)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
          goto _L12
_L50:
        if (flag4 && flag5)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
          goto _L12
        if (flag4 && flag2)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
          goto _L12
    }

    public String b(String s)
    {
        String s1;
        String s2;
        s2 = "";
        s1 = s2;
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.startsWith("nol_")) goto _L4; else goto _L3
_L3:
        s1 = s2;
_L2:
        return s1;
_L4:
        s1 = (String)i.get(s);
        s = s1;
        if (s1 == null)
        {
            return "";
        }
_L7:
        if (s.startsWith("("))
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        if (!s.startsWith("<")) goto _L2; else goto _L5
_L5:
        if (s.endsWith(")"))
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        if (!s.endsWith(">")) goto _L2; else goto _L6
_L6:
        s = s.substring(1, s.length() - 1);
          goto _L7
    }

    public Map b(JSONObject jsonobject)
        throws JSONException
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s, (String)jsonobject.get(s)))
        {
            s = (String)iterator.next();
        }

        return a(((Map) (null)), hashmap);
    }

    public void b(Map map)
    {
        a.putAll(map);
    }

    public boolean b()
    {
        if (e == 0L)
        {
            com.nielsen.app.sdk.c.a('W', "updateDictionary() failed. No native URL parser object.", new Object[0]);
            return false;
        }
        if (!m) goto _L2; else goto _L1
_L1:
        AppConfig.b(d).a(e, (HashMap)l);
        m = false;
        k.clear();
_L4:
        return true;
_L2:
        if (!k.isEmpty())
        {
            HashMap hashmap = new HashMap();
            String s;
            for (Iterator iterator = k.iterator(); iterator.hasNext(); hashmap.put(s, (String)l.get(s)))
            {
                s = (String)iterator.next();
            }

            AppConfig.b(d).a(e, hashmap);
            k.clear();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean b(long l1, long l2, long l3, String s)
    {
        long l5 = (l1 - l3) + l2;
        String s1 = a("nol_weekEndUTC");
        long l4;
        if (s1 != null && !s1.isEmpty())
        {
            l4 = Long.parseLong(s1);
        } else
        {
            l4 = l5;
        }
        if (!f && l5 > l4 && g == 6)
        {
            List list = f("onWeekEndUTC");
            if (list != null)
            {
                a(list, null, true);
            }
            com.nielsen.app.sdk.c.a('I', "Applying Week End filter : name(%s) period(%s) end(%s) start(%s)", new Object[] {
                a("nol_week"), a("nol_period"), a("nol_weekEndUTC"), a("nol_weekStartUTC")
            });
            f = true;
        }
        if (b())
        {
            return AppConfig.b(d).urlParserCalculateVariable(e, l1, l2, l3, s);
        } else
        {
            return false;
        }
    }

    public String c()
    {
        String s;
        if (!b())
        {
            break MISSING_BLOCK_LABEL_40;
        }
        s = AppConfig.b(d).urlParserProcessIagData(e);
        return s;
        Exception exception;
        exception;
        com.nielsen.app.sdk.c.a(exception, true, 1, 'E', "Could not parse IAG string", new Object[0]);
        return "";
    }

    public void c(String s)
    {
        this;
        JVM INSTR monitorenter ;
        l.remove(s);
        k.remove(s);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void c(Map map)
    {
        b.putAll(map);
    }

    public Map d()
    {
        return l;
    }

    public boolean d(String s)
    {
        s = (String)l.get(s);
        return d.a(s);
    }

    public int e()
    {
        return n.size();
    }

    public Map e(String s)
    {
        return (Map)a.get(s);
    }

    public List f(String s)
    {
        return (List)b.get(s);
    }

    public void f()
    {
        n.clear();
    }

    public String g()
    {
        return c;
    }

    public void g(String s)
    {
        c = s;
    }

    public pRule(AppConfig appconfig, pRule prule)
    {
        d = appconfig;
        super();
        e = 0L;
        f = false;
        g = 0;
        h = "X100zdCIGeIlgZnkYj6UvQ==";
        i = new HashMap();
        j = "";
        k = new LinkedList();
        l = new HashMap();
        m = true;
        n = new LinkedList();
        a = new HashMap();
        b = new HashMap();
        c = "";
        a.putAll(prule.a);
        b.putAll(prule.b);
        l.putAll(prule.l);
        j = prule.j;
        i.putAll(prule.i);
    }

    public i(AppConfig appconfig, Map map, Map map1)
    {
        d = appconfig;
        super();
        e = 0L;
        f = false;
        g = 0;
        h = "X100zdCIGeIlgZnkYj6UvQ==";
        i = new HashMap();
        j = "";
        k = new LinkedList();
        l = new HashMap();
        m = true;
        n = new LinkedList();
        a = new HashMap();
        b = new HashMap();
        c = "";
        a(map, map1);
    }
}
