// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, n, z, t

public class y
{
    private class a
    {

        public String a;
        public String b;
        public int c;
        public String d[];
        public long e;
        public int f;
        final y g;

        public void a(n n1)
        {
            boolean flag = false;
            b = n1.h();
            f = 0;
            String as[] = n1.k();
            d = new String[as.length];
            for (int i = 0; i < d.length; i++)
            {
                d[i] = as[i];
            }

            e = 0L;
            for (int j = 0; j < as.length; j++)
            {
                e = e + (long)n1.d(j);
            }

            if (n1 instanceof t)
            {
                n1 = d;
                int l = n1.length;
                for (int k = ((flag) ? 1 : 0); k < l; k++)
                {
                    Object obj = n1[k];
                    obj = y.a(g, ((String) (obj)));
                    if (((File) (obj)).exists())
                    {
                        e = e + (long)(int)((File) (obj)).length();
                    }
                }

            }
        }

        public void a(File file)
            throws Exception
        {
            int i = 0;
            file = new JSONObject(ad.a(file));
            c = file.getInt("views");
            a = file.getString("base-file");
            b = file.getString("expiration-date");
            e = file.getLong("total-size");
            f = file.getInt("priority");
            if (!file.has("files"))
            {
                d = new String[0];
            } else
            {
                file = file.getJSONArray("files");
                d = new String[file.length()];
                while (i < file.length()) 
                {
                    d[i] = file.getString(i);
                    i++;
                }
            }
        }

        public void a(String s)
        {
            JSONObject jsonobject;
            JSONArray jsonarray;
            jsonobject = new JSONObject();
            jsonarray = new JSONArray();
            int i = 0;
_L2:
            if (i >= d.length)
            {
                break; /* Loop/switch isn't completed */
            }
            jsonarray.put(d[i]);
            i++;
            if (true) goto _L2; else goto _L1
_L1:
            try
            {
                jsonobject.put("files", jsonarray);
                jsonobject.put("views", c);
                jsonobject.put("expiration-date", b);
                jsonobject.put("base-file", a);
                jsonobject.put("total-size", e);
                jsonobject.put("priority", f);
                s = new FileOutputStream(new File(s));
                s.write(jsonobject.toString().getBytes());
                s.flush();
                s.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                ad.a(s);
            }
            return;
        }

        public a()
        {
            g = y.this;
            super();
        }

        public a(n n1, File file)
        {
            boolean flag = false;
            g = y.this;
            super();
            a = n1.i();
            c = 0;
            b = n1.h();
            f = 0;
            file = n1.k();
            d = new String[file.length];
            for (int i = 0; i < d.length; i++)
            {
                d[i] = file[i];
            }

            for (int j = 0; j < file.length; j++)
            {
                e = e + (long)n1.d(j);
            }

            if (n1 instanceof t)
            {
                n1 = d;
                int l = n1.length;
                for (int k = ((flag) ? 1 : 0); k < l; k++)
                {
                    file = y.a(y.this, n1[k]);
                    if (file.exists())
                    {
                        e = e + (long)(int)file.length();
                    }
                }

            }
        }
    }


    private static final String a[] = {
        ".theme", ".ad", ".cookies", ".savedata"
    };
    private static final String b[] = {
        ".dat", ".views"
    };
    private static List e = new ArrayList();
    private File c;
    private List d;

    public y(File file)
    {
        c = file;
        d = new ArrayList();
        a();
        file = file.list();
        ad.d("Loading Cache...");
        int j = file.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                break;
            }
            Object obj = file[i];
            if (((String) (obj)).startsWith("tremor-cache-1105352-") && ((String) (obj)).endsWith(".ad"))
            {
                ad.d((new StringBuilder()).append("Loading cache data: ").append(((String) (obj))).toString());
                a a1 = new a();
                obj = new File(c, ((String) (obj)));
                try
                {
                    a1.a(((File) (obj)));
                    d.add(a1);
                }
                catch (Exception exception)
                {
                    ad.a((new StringBuilder()).append("Error loading cache file: ").append(((File) (obj)).getAbsolutePath()).toString(), exception);
                    ((File) (obj)).delete();
                }
            }
            i++;
        } while (true);
        ad.d((new StringBuilder()).append("Cache Loaded: ").append(c() / 1024L).append("KB").toString());
    }

    static File a(y y1, String s)
    {
        return y1.e(s);
    }

    public static File a(File file, String s)
    {
        return new File((new StringBuilder()).append(file.getAbsolutePath()).append(File.separator).append("tremor-cache-1105352-").append(s).toString());
    }

    public static void a(n n1)
    {
        e.add(n1);
    }

    private boolean a(String s)
    {
        boolean flag1 = false;
        String as[] = a;
        int j = as.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    String s1 = as[i];
                    if (!s.toLowerCase().endsWith(s1))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public static void b(n n1)
    {
        e.remove(n1);
    }

    private boolean b(String s)
    {
        boolean flag1 = false;
        String as[] = b;
        int j = as.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!s.endsWith(as[i]))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    private boolean c(String s)
    {
        s = s.replace((new StringBuilder()).append(c.getAbsolutePath()).append(File.separator).toString(), "").replace("tremor-cache-1105352-", "");
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            a a1 = (a)iterator.next();
            int i = 0;
            while (i < a1.d.length) 
            {
                if (s.equals(a1.d[i]))
                {
                    return false;
                }
                i++;
            }
        }

        return true;
    }

    private String d(String s)
    {
        return (new StringBuilder()).append(c.getAbsolutePath()).append(File.separator).append("tremor-cache-1105352-").append(s).toString();
    }

    private File e(String s)
    {
        return new File(c.getAbsolutePath(), (new StringBuilder()).append("tremor-cache-1105352-").append(s).toString());
    }

    private void e(n n1)
    {
        long l;
        l = 0L;
        for (int i = 0; i < n1.j(); i++)
        {
            l += n1.d(i);
        }

        if (c() + l <= 0x1400000L) goto _L2; else goto _L1
_L1:
        ad.d((new StringBuilder()).append("Freeing space in cache: Current Size: ").append(c()).append(" Ad size: ").append(l).toString());
_L6:
        if (c() + l <= 0x1400000L || d.size() <= 0) goto _L2; else goto _L3
_L3:
        a a1 = a((c() + l) - 0x1400000L);
        if (a1 != null) goto _L4; else goto _L2
_L2:
        return;
_L4:
        a(a1, n1.k());
        if (true) goto _L6; else goto _L5
_L5:
    }

    private File f(n n1)
    {
        return new File(c.getAbsolutePath(), (new StringBuilder()).append("tremor-cache-1105352-").append(n1.i()).append(".ad").toString());
    }

    private void f()
    {
        ad.d("Checking for expired files...");
        Object obj = new ArrayList();
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a a2 = (a)iterator.next();
            if (!a(a2) && gregoriancalendar.after(n.a(a2.b)))
            {
                ((List) (obj)).add(a2);
            }
        } while (true);
        a a1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); d.remove(a1))
        {
            a1 = (a)((Iterator) (obj)).next();
            b(a1);
        }

        ad.d("Done checking for expired files.");
    }

    public a a(long l)
    {
        Iterator iterator = d.iterator();
        a a4 = null;
        a a1 = null;
        do
        {
            if (iterator.hasNext())
            {
                a a2 = (a)iterator.next();
                if (a(a2))
                {
                    continue;
                }
                a a3 = a4;
                if (a2.e >= l)
                {
                    if (a4 == null)
                    {
                        a3 = a2;
                    } else
                    {
                        a3 = a4;
                        if (a4.e > a2.e)
                        {
                            a3 = a2;
                        }
                    }
                }
                if (a1 == null)
                {
                    a4 = a2;
                } else
                {
                    a4 = a2;
                    if (a1.f <= a2.f)
                    {
                        a4 = a1;
                    }
                }
                a1 = a4;
                a4 = a3;
                continue;
            }
            if (a1 != null && a4 != null && a1.f == a4.f)
            {
                return a4;
            }
            return a1;
        } while (true);
    }

    public void a()
    {
        if (ad.d())
        {
            String as[] = c.list();
            ad.d("Displaing Cache...");
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                if (s.startsWith("tremor-cache-1105352-"))
                {
                    ad.d((new StringBuilder()).append("File: ").append(s.replace("tremor-cache-1105352-", "")).toString());
                }
            }

        }
    }

    public void a(a a1, String s)
    {
        Iterator iterator = d.iterator();
_L10:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        a a2;
        int i;
        a2 = (a)iterator.next();
        if (a2 == a1)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = 0;
_L8:
        if (i >= a2.d.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!a2.d[i].equals(s)) goto _L4; else goto _L3
_L3:
        ad.d((new StringBuilder()).append("Keep shared cache File: ").append(s).toString());
_L6:
        return;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        a1 = e(s);
        if (!a1.exists()) goto _L6; else goto _L5
_L5:
        ad.d((new StringBuilder()).append("Removing Cache File: ").append(a1.getAbsolutePath()).toString());
        a1.delete();
        return;
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void a(a a1, String as[])
    {
        int i;
        boolean flag;
        flag = false;
        i = 0;
_L5:
        if (i >= a1.d.length) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        l = as.length;
        k = 0;
_L6:
        if (k >= l)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        if (!as[k].equals(a1.d[i])) goto _L4; else goto _L3
_L3:
        k = 1;
_L7:
        if (k == 0)
        {
            a(a1, a1.d[i]);
        } else
        {
            ad.d((new StringBuilder()).append("Keeping future shared cache file: ").append(a1.d[i]).toString());
        }
        i++;
          goto _L5
_L4:
        k++;
          goto _L6
_L2:
        as = a;
        k = as.length;
        for (int j = ((flag) ? 1 : 0); j < k; j++)
        {
            String s = as[j];
            s = d((new StringBuilder()).append(a1.a).append(s).toString());
            File file = new File(s);
            if (file.exists())
            {
                ad.d((new StringBuilder()).append("Removing Cache File: ").append(s).toString());
                file.delete();
            }
        }

        d.remove(a1);
        return;
        k = 0;
          goto _L7
    }

    public boolean a(a a1)
    {
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            n n1 = (n)iterator.next();
            if (a1.a.compareTo(n1.i()) == 0)
            {
                return true;
            }
        }

        return false;
    }

    public void b()
    {
        d();
        f();
        String as[] = c.list();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            if (s.startsWith("tremor-cache-1105352-"))
            {
                ad.d((new StringBuilder()).append("Cache file: ").append(s).toString());
            }
        }

    }

    public void b(a a1)
    {
        a(a1, ((String []) (null)));
    }

    public long c()
    {
        Iterator iterator = d.iterator();
        long l;
        for (l = 0L; iterator.hasNext(); l = ((a)iterator.next()).e + l) { }
        return l;
    }

    public void c(n n1)
    {
        File file = f(n1);
        if (!file.exists())
        {
            ad.d((new StringBuilder()).append("Error Cannot increment views for: ").append(n1.i()).toString());
            return;
        }
        try
        {
            a a1 = new a();
            a1.a(file);
            a1.c = a1.c + 1;
            a1.a(file.getAbsolutePath());
            ad.d((new StringBuilder()).append("Incrementing View Count For: ").append(n1.i()).append(": ").append(a1.c).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (n n1)
        {
            ad.a(n1);
        }
    }

    public void d()
    {
        String as[];
        int i;
        int j;
        ad.d("Checking for orphaned files...");
        as = c.list();
        j = as.length;
        i = 0;
_L9:
        if (i >= j) goto _L2; else goto _L1
_L1:
        String s = as[i];
        if (!s.startsWith("transpera-cache-1105352")) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L7:
        if (flag)
        {
            (new File(c, s)).delete();
        }
_L6:
        i++;
        continue; /* Loop/switch isn't completed */
_L4:
        if (!s.startsWith("tremor-cache-1105352-") || a(s)) goto _L6; else goto _L5
_L5:
        if (b(s))
        {
            ad.d((new StringBuilder()).append("Removing legacy file: ").append(s).toString());
            flag = true;
        } else
        if (c(s))
        {
            ad.d((new StringBuilder()).append("Removing orphaned file: ").append(s).toString());
            flag = true;
        } else
        {
            flag = false;
        }
        if (true) goto _L7; else goto _L2
_L2:
        ad.d("Done checking for orphaned files.");
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void d(n n1)
    {
        Object obj = f(n1);
        if (!((File) (obj)).exists())
        {
            ad.d((new StringBuilder()).append("Adding ad to cache: ").append(n1.i()).append("...").toString());
            e(n1);
            (new a(n1, c)).a(((File) (obj)).getAbsolutePath());
        } else
        {
            ad.d((new StringBuilder()).append("Updating cached ad: ").append(n1.i()).append("...").toString());
            ad.d((new StringBuilder()).append("Cache Usage: ").append(c()).append("/").append(0x1400000L).toString());
            try
            {
                a a1 = new a();
                a1.a(((File) (obj)));
                a1.a(n1);
                a1.a(((File) (obj)).getAbsolutePath());
            }
            // Misplaced declaration of an exception variable
            catch (n n1)
            {
                ad.a(n1);
            }
        }
        ad.d("Cache info: ");
        for (n1 = d.iterator(); n1.hasNext(); ad.d((new StringBuilder()).append(((a) (obj)).a).append(" : ").append(((a) (obj)).e).toString()))
        {
            obj = (a)n1.next();
        }

    }

    public z e()
    {
        z z1 = new z();
        a a1;
        for (Iterator iterator = d.iterator(); iterator.hasNext(); z1.a(a1.a, a1.c))
        {
            a1 = (a)iterator.next();
        }

        return z1;
    }

}
