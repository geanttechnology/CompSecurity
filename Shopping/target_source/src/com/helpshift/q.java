// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import com.helpshift.d.a;
import com.helpshift.i.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.helpshift:
//            aa, g

public final class q
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a d[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/helpshift/q$a, s);
        }

        public static a[] values()
        {
            return (a[])d.clone();
        }

        static 
        {
            a = new a("FULL_SEARCH", 0);
            b = new a("METAPHONE_SEARCH", 1);
            c = new a("KEYWORD_SEARCH", 2);
            d = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static com.helpshift.d.a a = new com.helpshift.d.a();
    private static boolean b = false;
    private static boolean c = false;

    private static int a(int i, int j)
    {
        if (j < i)
        {
            return j;
        } else
        {
            return i;
        }
    }

    private static int a(int i, int j, int k)
    {
        if (j >= i)
        {
            j = i;
        }
        if (k < j)
        {
            return k;
        } else
        {
            return j;
        }
    }

    public static String a(String s)
    {
        return s.replaceAll("<[^>]+>", "");
    }

    public static ArrayList a(int i, int j, String s)
    {
        ArrayList arraylist = new ArrayList();
        for (; i < s.length() && i <= j; i++)
        {
            arraylist.add(s.substring(0, i));
        }

        return arraylist;
    }

    public static ArrayList a(String s, String s1)
    {
        HashSet hashset = new HashSet();
        hashset.add(new HashMap(s, s1) {

            final String a;
            final String b;

            
            {
                a = s;
                b = s1;
                super();
                put("value", a);
                put("type", b);
            }
        });
        for (s1 = a(2, 10, s).iterator(); s1.hasNext(); hashset.add(new HashMap((String)s1.next()) {

        final String a;

            
            {
                a = s;
                super();
                put("value", a);
                put("type", "ngram");
            }
    })) { }
        hashset.add(new HashMap(s) {

            final String a;

            
            {
                a = s;
                super();
                put("value", q.c().b(a).toLowerCase());
                put("type", "metaphone");
            }
        });
        return new ArrayList(hashset);
    }

    public static ArrayList a(String s, HashMap hashmap)
    {
        ArrayList arraylist2 = new ArrayList();
        if (hashmap != null)
        {
            HashMap hashmap2 = new HashMap();
            for (Iterator iterator = b(e(s)).iterator(); iterator.hasNext();)
            {
                String s1 = (String)iterator.next();
                s = s1.substring(0, 1);
                ArrayList arraylist = new ArrayList(f(s));
                arraylist.add(s);
                Iterator iterator1 = arraylist.iterator();
                while (iterator1.hasNext()) 
                {
                    s = (ArrayList)hashmap.get((String)iterator1.next());
                    if (s != null)
                    {
                        Iterator iterator2 = s.iterator();
                        while (iterator2.hasNext()) 
                        {
                            s = (HashMap)iterator2.next();
                            String s2 = (String)s.get("w");
                            if ((double)c(s2, s1) > 0.5D)
                            {
                                String s3 = (String)s.get("id");
                                ArrayList arraylist1 = (ArrayList)hashmap2.get(s3);
                                s = arraylist1;
                                if (arraylist1 == null)
                                {
                                    s = new ArrayList();
                                }
                                s.add(s2);
                                hashmap2.put(s3, s);
                            }
                        }
                    }
                }
            }

            HashMap hashmap1;
            for (s = hashmap2.keySet().iterator(); s.hasNext(); arraylist2.add(hashmap1))
            {
                hashmap = (String)s.next();
                hashmap1 = new HashMap();
                hashmap1.put("f", hashmap);
                hashmap1.put("t", hashmap2.get(hashmap));
            }

        }
        return arraylist2;
    }

    public static ArrayList a(String s, HashMap hashmap, a a1)
    {
        HashMap hashmap2 = new HashMap();
        Object obj2 = null;
        Object obj = null;
        HashMap hashmap1 = new HashMap();
        ArrayList arraylist = new ArrayList();
        for (s = c(e(s)).iterator(); s.hasNext(); arraylist.addAll(a(d((String)s.next()), a1))) { }
        a1 = obj2;
        if (hashmap != null)
        {
            Iterator iterator = arraylist.iterator();
            s = obj;
            do
            {
                a1 = s;
                if (!iterator.hasNext())
                {
                    break;
                }
                a1 = (HashMap)iterator.next();
                String s1 = (String)a1.get("value");
                String s2 = (String)a1.get("type");
                HashMap hashmap3 = (HashMap)hashmap.get(s1);
                if (hashmap3 != null && hashmap3.keySet().size() > 0)
                {
                    for (Iterator iterator1 = hashmap3.keySet().iterator(); iterator1.hasNext();)
                    {
                        String s3 = (String)iterator1.next();
                        Object obj1 = (ArrayList)hashmap1.get(s3);
                        a1 = ((a) (obj1));
                        if (obj1 == null)
                        {
                            a1 = new ArrayList();
                        }
                        if (s1.length() > 0)
                        {
                            a1.add(s1);
                        }
                        hashmap1.put(s3, a1);
                        obj1 = (Double)hashmap3.get(s3);
                        a1 = (Double)hashmap2.get(s3);
                        obj1 = Double.valueOf(((Double) (obj1)).doubleValue() * (double)b(s2, s1));
                        if (a1 != null)
                        {
                            double d1 = a1.doubleValue();
                            hashmap2.put(s3, Double.valueOf(((Double) (obj1)).doubleValue() + d1));
                        } else
                        {
                            hashmap2.put(s3, obj1);
                        }
                    }

                    a1 = new HashSet();
                    a1.addAll(hashmap3.keySet());
                    if (s != null && !s.isEmpty())
                    {
                        s.addAll(a1);
                    } else
                    {
                        s = new HashSet(a1);
                    }
                }
            } while (true);
        }
        if (a1 == null || a1.isEmpty())
        {
            s = new TreeMap(new aa(hashmap2));
            s.putAll(hashmap2);
            return a(((TreeMap) (s)), hashmap1);
        }
        if (a1.size() == 1)
        {
            s = new HashMap();
            hashmap = new ArrayList();
            a1 = (String)a1.iterator().next();
            s.put("f", a1);
            s.put("t", hashmap1.get(a1));
            hashmap.add(s);
            return hashmap;
        }
        s = new HashMap();
        for (hashmap = a1.iterator(); hashmap.hasNext(); s.put(a1, hashmap2.get(a1)))
        {
            a1 = (String)hashmap.next();
        }

        hashmap = new TreeMap(new aa(s));
        hashmap.putAll(s);
        return a(((TreeMap) (hashmap)), hashmap1);
    }

    protected static ArrayList a(ArrayList arraylist, a a1)
    {
        ArrayList arraylist1 = new ArrayList();
        arraylist = arraylist.iterator();
        do
        {
            if (!arraylist.hasNext())
            {
                break;
            }
            HashMap hashmap = (HashMap)arraylist.next();
            String s = (String)hashmap.get("type");
            if (a1 == com.helpshift.a.a)
            {
                arraylist1.add(hashmap);
            } else
            if (a1 == a.b && s.equals("metaphone"))
            {
                arraylist1.add(hashmap);
            } else
            if (a1 == a.c && (s.equals("word") || s.equals("ngram")))
            {
                arraylist1.add(hashmap);
            }
        } while (true);
        return arraylist1;
    }

    private static ArrayList a(TreeMap treemap, HashMap hashmap)
    {
        ArrayList arraylist = new ArrayList();
        HashMap hashmap1;
        for (treemap = treemap.keySet().iterator(); treemap.hasNext(); arraylist.add(hashmap1))
        {
            String s = (String)treemap.next();
            hashmap1 = new HashMap();
            hashmap1.put("f", s);
            hashmap1.put("t", hashmap.get(s));
        }

        return arraylist;
    }

    public static HashMap a(String s, String s1, List list)
    {
        Object obj = new ArrayList();
        for (s1 = b(e(s1)).iterator(); s1.hasNext(); ((ArrayList) (obj)).addAll(a((String)s1.next(), "word"))) { }
        for (s = b(e(s)).iterator(); s.hasNext(); ((ArrayList) (obj)).addAll(a((String)s.next(), "imp_word"))) { }
        for (s = list.iterator(); s.hasNext(); ((ArrayList) (obj)).addAll(a(e((String)s.next()), "tag_word"))) { }
        s = new HashMap();
        int i;
        for (s1 = ((ArrayList) (obj)).iterator(); s1.hasNext(); s.put(obj, Integer.valueOf(b((String)list.get("type"), ((String) (obj))) + i)))
        {
            list = (HashMap)s1.next();
            obj = (String)list.get("value");
            i = 0;
            if (s.containsKey(obj))
            {
                i = ((Integer)s.get(obj)).intValue();
            }
        }

        return s;
    }

    public static HashMap a(ArrayList arraylist)
    {
        HashMap hashmap = new HashMap();
        if (b)
        {
            arraylist = null;
        } else
        {
            if (!o.a())
            {
                o.b();
                c = true;
            }
            b = true;
            HashMap hashmap1 = b(arraylist);
            arraylist = c(arraylist);
            hashmap.put("i", hashmap1);
            hashmap.put("f", arraylist);
            b = false;
            arraylist = hashmap;
            if (c)
            {
                b();
                c = false;
                return hashmap;
            }
        }
        return arraylist;
    }

    public static void a()
    {
        if (!b)
        {
            Thread thread = new Thread(new Runnable() {

                public void run()
                {
                    o.b();
                }

            });
            thread.setDaemon(true);
            thread.start();
        }
    }

    public static int b(String s, String s1)
    {
        boolean flag = true;
        byte byte0;
        if (s1.length() == 1)
        {
            byte0 = 5;
        } else
        {
            if (s == "ngram")
            {
                return s1.length();
            }
            if (s == "word")
            {
                return 30;
            }
            byte0 = flag;
            if (s != "metaphone")
            {
                if (s == "imp_word")
                {
                    return 300;
                }
                byte0 = flag;
                if (s == "tag_word")
                {
                    return 150;
                }
            }
        }
        return byte0;
    }

    public static ArrayList b(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = Pattern.compile("\\w+").matcher(s);
        do
        {
            if (!s.find())
            {
                break;
            }
            if (s.group(0).length() > 2)
            {
                arraylist.add(s.group(0));
            }
        } while (true);
        return arraylist;
    }

    protected static HashMap b(ArrayList arraylist)
    {
        int i = arraylist.size();
        Object obj1 = new ArrayList();
        Object obj = arraylist.iterator();
        int j;
        for (arraylist = Integer.valueOf(0); ((Iterator) (obj)).hasNext(); arraylist = Integer.valueOf(j + 1))
        {
            g g1 = (g)((Iterator) (obj)).next();
            HashMap hashmap1 = new HashMap();
            hashmap1.put("terms", a(g1.e(), g1.f(), g1.h()));
            hashmap1.put("id", (new StringBuilder()).append(arraylist).append("").toString());
            j = arraylist.intValue();
            ((ArrayList) (obj1)).add(hashmap1);
        }

        HashMap hashmap = new HashMap();
        for (Iterator iterator = ((ArrayList) (obj1)).iterator(); iterator.hasNext();)
        {
            arraylist = (HashMap)iterator.next();
            obj = (String)arraylist.get("id");
            HashMap hashmap2 = (HashMap)arraylist.get("terms");
            Iterator iterator1 = hashmap2.keySet().iterator();
            while (iterator1.hasNext()) 
            {
                String s1 = (String)iterator1.next();
                int k = ((Integer)hashmap2.get(s1)).intValue();
                if (hashmap.containsKey(s1))
                {
                    HashMap hashmap4 = (HashMap)hashmap.get(s1);
                    arraylist = (Integer)hashmap4.get("maxFreq");
                    if (arraylist == null)
                    {
                        arraylist = Integer.valueOf(0);
                    }
                    obj = (Integer)hashmap4.get("docFreq");
                    if (obj == null)
                    {
                        obj = Integer.valueOf(0);
                    } else
                    {
                        obj = Integer.valueOf(((Integer) (obj)).intValue() + 1);
                    }
                    if (arraylist.intValue() < k)
                    {
                        hashmap4.put("maxFreq", Integer.valueOf(k));
                    }
                    hashmap4.put("docFreq", obj);
                    hashmap.put(s1, hashmap4);
                } else
                {
                    arraylist = new HashMap();
                    arraylist.put("maxFreq", Integer.valueOf(k));
                    arraylist.put("docFreq", Integer.valueOf(1));
                    hashmap.put(s1, arraylist);
                }
            }
        }

        obj = new HashMap();
        for (obj1 = ((ArrayList) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            arraylist = (HashMap)((Iterator) (obj1)).next();
            String s = (String)arraylist.get("id");
            HashMap hashmap3 = (HashMap)arraylist.get("terms");
            Iterator iterator2 = hashmap3.keySet().iterator();
            while (iterator2.hasNext()) 
            {
                String s2 = (String)iterator2.next();
                arraylist = (HashMap)((HashMap) (obj)).get(s2);
                if (arraylist == null)
                {
                    arraylist = new HashMap();
                }
                Integer integer = (Integer)hashmap3.get(s2);
                Object obj2 = (HashMap)hashmap.get(s2);
                Integer integer1 = (Integer)((HashMap) (obj2)).get("maxFreq");
                obj2 = (Integer)((HashMap) (obj2)).get("docFreq");
                double d2 = integer.intValue() / integer1.intValue();
                double d1 = Math.log10(Integer.valueOf(i).intValue() / ((Integer) (obj2)).intValue());
                d2 = Double.valueOf(d2).doubleValue();
                arraylist.put(s, Double.valueOf(Double.valueOf(d1).doubleValue() * d2));
                ((HashMap) (obj)).put(s2, arraylist);
            }
        }

        return ((HashMap) (obj));
    }

    public static void b()
    {
        if (!b)
        {
            o.c();
            return;
        } else
        {
            c = true;
            return;
        }
    }

    private static float c(String s, String s1)
    {
        s = s.trim();
        s1 = s1.trim();
        s = s.toLowerCase();
        s1 = s1.toLowerCase();
        int j1 = s.length();
        int i = s1.length();
        int j2 = j1 + 1;
        if (j1 != 0)
        {
            int k2 = i + 1;
            if (i != 0)
            {
                int ai[] = new int[j2 * k2];
                for (int j = 0; j < j2; j++)
                {
                    ai[j] = j;
                }

                for (int k = 0; k < k2; k++)
                {
                    ai[k * j2] = k;
                }

                for (int l = 1; l < j2; l++)
                {
                    int k1 = 1;
                    while (k1 < k2) 
                    {
                        int i2;
                        if (s.charAt(l - 1) == s1.charAt(k1 - 1))
                        {
                            i2 = 0;
                        } else
                        {
                            i2 = 1;
                        }
                        ai[k1 * j2 + l] = a(ai[(k1 - 1) * j2 + l] + 1, ai[(k1 * j2 + l) - 1] + 1, ai[((k1 - 1) * j2 + l) - 1] + i2);
                        if (l > 1 && k1 > 1 && s.charAt(l - 1) == s1.charAt(k1 - 2) && s.charAt(l - 2) == s1.charAt(k1 - 1))
                        {
                            ai[k1 * j2 + l] = a(ai[k1 * j2 + l], i2 + ai[((k1 - 2) * j2 + l) - 2]);
                        }
                        k1++;
                    }
                }

                int l1 = ai[j2 * k2 - 1];
                int i1;
                if (j2 > k2)
                {
                    i1 = j2;
                } else
                {
                    i1 = k2;
                }
                return 1.0F - (float)l1 / (float)i1;
            }
        }
        return 0.0F;
    }

    static com.helpshift.d.a c()
    {
        return a;
    }

    public static ArrayList c(String s)
    {
        ArrayList arraylist = new ArrayList();
        Matcher matcher = Pattern.compile("\\w+").matcher(s);
        do
        {
            if (!matcher.find())
            {
                break;
            }
            if (matcher.group(0).length() > 2 || s.length() > 2)
            {
                arraylist.add(matcher.group(0));
            }
        } while (true);
        return arraylist;
    }

    protected static HashMap c(ArrayList arraylist)
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = arraylist.iterator();
label0:
        for (int i = 0; iterator.hasNext(); i++)
        {
            Iterator iterator1 = b(e(((g)iterator.next()).e())).iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    continue label0;
                }
                String s = ((String)iterator1.next()).toLowerCase();
                if (s.length() > 3)
                {
                    HashMap hashmap1 = new HashMap();
                    hashmap1.put("w", s);
                    hashmap1.put("id", (new StringBuilder()).append(i).append("").toString());
                    String s1 = s.substring(0, 1);
                    ArrayList arraylist1 = (ArrayList)hashmap.get(s1);
                    arraylist = arraylist1;
                    if (arraylist1 == null)
                    {
                        arraylist = new ArrayList();
                    }
                    arraylist.add(hashmap1);
                    hashmap.put(s1, arraylist);
                    s = s.substring(1, 2);
                    arraylist1 = (ArrayList)hashmap.get(s);
                    arraylist = arraylist1;
                    if (arraylist1 == null)
                    {
                        arraylist = new ArrayList();
                    }
                    arraylist.add(hashmap1);
                    hashmap.put(s, arraylist);
                }
            } while (true);
        }

        return hashmap;
    }

    public static ArrayList d(String s)
    {
        HashSet hashset = new HashSet();
        hashset.add(new HashMap(s) {

            final String a;

            
            {
                a = s;
                super();
                put("value", a);
                put("type", "word");
            }
        });
        hashset.add(new HashMap(s) {

            final String a;

            
            {
                a = s;
                super();
                put("value", q.c().b(a).toLowerCase());
                put("type", "metaphone");
            }
        });
        return new ArrayList(hashset);
    }

    public static String e(String s)
    {
        return o.a(a(s).toLowerCase());
    }

    private static List f(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("a", new String[] {
            "q", "w", "s", "z"
        });
        hashmap.put("b", new String[] {
            "v", "h", "n"
        });
        hashmap.put("c", new String[] {
            "x", "f", "v"
        });
        hashmap.put("d", new String[] {
            "s", "z", "x"
        });
        hashmap.put("e", new String[] {
            "w", "s", "d", "r"
        });
        hashmap.put("f", new String[] {
            "d", "g", "c", "x"
        });
        hashmap.put("g", new String[] {
            "h", "f", "v", "b"
        });
        hashmap.put("h", new String[] {
            "g", "j", "b", "n"
        });
        hashmap.put("i", new String[] {
            "u", "o", "k", "j"
        });
        hashmap.put("j", new String[] {
            "m", "n", "h", "k"
        });
        hashmap.put("k", new String[] {
            "j", "l", "m"
        });
        hashmap.put("l", new String[] {
            "k", "p", "m"
        });
        hashmap.put("m", new String[] {
            "n", "b", "l"
        });
        hashmap.put("n", new String[] {
            "b", "j", "m"
        });
        hashmap.put("o", new String[] {
            "l", "k", "p"
        });
        hashmap.put("p", new String[] {
            "l", "o"
        });
        hashmap.put("q", new String[] {
            "w", "a"
        });
        hashmap.put("r", new String[] {
            "s", "d", "e", "f"
        });
        hashmap.put("s", new String[] {
            "a", "z", "d"
        });
        hashmap.put("t", new String[] {
            "r", "f", "g", "y"
        });
        hashmap.put("u", new String[] {
            "j", "h", "i", "y"
        });
        hashmap.put("v", new String[] {
            "c", "g", "b"
        });
        hashmap.put("w", new String[] {
            "q", "a", "s"
        });
        hashmap.put("x", new String[] {
            "z", "s", "c"
        });
        hashmap.put("y", new String[] {
            "g", "h", "t", "u"
        });
        hashmap.put("z", new String[] {
            "a", "s", "x"
        });
        if (hashmap.containsKey(s))
        {
            return Arrays.asList((Object[])hashmap.get(s));
        } else
        {
            return new ArrayList();
        }
    }

}
