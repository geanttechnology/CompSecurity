// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import myobfuscated.aj.j;

// Referenced classes of package myobfuscated.s:
//            r, v, k, u

public final class t
    implements r
{

    private static final android.graphics.Bitmap.Config a[];
    private static final android.graphics.Bitmap.Config b[];
    private static final android.graphics.Bitmap.Config c[];
    private static final android.graphics.Bitmap.Config d[];
    private final v e = new v();
    private final k f = new k();
    private final Map g = new HashMap();

    public t()
    {
    }

    static String a(int i, android.graphics.Bitmap.Config config)
    {
        return b(i, config);
    }

    private NavigableMap a(android.graphics.Bitmap.Config config)
    {
        NavigableMap navigablemap = (NavigableMap)g.get(config);
        Object obj = navigablemap;
        if (navigablemap == null)
        {
            obj = new TreeMap();
            g.put(config, obj);
        }
        return ((NavigableMap) (obj));
    }

    private void a(Integer integer, Bitmap bitmap)
    {
        NavigableMap navigablemap = a(bitmap.getConfig());
        Integer integer1 = (Integer)navigablemap.get(integer);
        if (integer1 == null)
        {
            throw new NullPointerException((new StringBuilder("Tried to decrement empty size, size: ")).append(integer).append(", removed: ").append(b(bitmap)).append(", this: ").append(this).toString());
        }
        if (integer1.intValue() == 1)
        {
            navigablemap.remove(integer);
            return;
        } else
        {
            navigablemap.put(integer, Integer.valueOf(integer1.intValue() - 1));
            return;
        }
    }

    private static String b(int i, android.graphics.Bitmap.Config config)
    {
        return (new StringBuilder("[")).append(i).append("](").append(config).append(")").toString();
    }

    public final Bitmap a()
    {
        Bitmap bitmap = (Bitmap)f.a();
        if (bitmap != null)
        {
            a(Integer.valueOf(j.a(bitmap)), bitmap);
        }
        return bitmap;
    }

    public final Bitmap a(int i, int l, android.graphics.Bitmap.Config config)
    {
        u u1;
        int i1;
        int j1;
        i1 = 0;
        j1 = j.a(i, l, config);
        u1 = e.a(j1, config);
        final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[android.graphics.Bitmap.Config.values().length];
                try
                {
                    a[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[config.ordinal()];
        JVM INSTR tableswitch 1 4: default 60
    //                   1 227
    //                   2 235
    //                   3 243
    //                   4 251;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        Object obj = {
            config
        };
_L9:
        int k1 = obj.length;
_L11:
        if (i1 >= k1) goto _L7; else goto _L6
_L6:
        android.graphics.Bitmap.Config config1;
        Integer integer;
        config1 = obj[i1];
        integer = (Integer)a(config1).ceilingKey(Integer.valueOf(j1));
        if (integer == null || integer.intValue() > j1 * 8)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        if (integer.intValue() != j1 || (config1 != null ? !config1.equals(config) : config != null)) goto _L8; else goto _L7
_L8:
        e.a(u1);
        config = e.a(integer.intValue(), config1);
_L10:
        obj = (Bitmap)f.a(config);
        if (obj != null)
        {
            a(Integer.valueOf(((u) (config)).a), ((Bitmap) (obj)));
            if (((Bitmap) (obj)).getConfig() != null)
            {
                config = ((Bitmap) (obj)).getConfig();
            } else
            {
                config = android.graphics.Bitmap.Config.ARGB_8888;
            }
            ((Bitmap) (obj)).reconfigure(i, l, config);
        }
        return ((Bitmap) (obj));
_L2:
        obj = a;
          goto _L9
_L3:
        obj = b;
          goto _L9
_L4:
        obj = c;
          goto _L9
_L5:
        obj = d;
          goto _L9
_L7:
        config = u1;
          goto _L10
        i1++;
          goto _L11
    }

    public final void a(Bitmap bitmap)
    {
        int i = j.a(bitmap);
        u u1 = e.a(i, bitmap.getConfig());
        f.a(u1, bitmap);
        bitmap = a(bitmap.getConfig());
        Integer integer = (Integer)bitmap.get(Integer.valueOf(u1.a));
        int l = u1.a;
        if (integer == null)
        {
            i = 1;
        } else
        {
            i = integer.intValue() + 1;
        }
        bitmap.put(Integer.valueOf(l), Integer.valueOf(i));
    }

    public final String b(int i, int l, android.graphics.Bitmap.Config config)
    {
        return b(j.a(i, l, config), config);
    }

    public final String b(Bitmap bitmap)
    {
        return b(j.a(bitmap), bitmap.getConfig());
    }

    public final int c(Bitmap bitmap)
    {
        return j.a(bitmap);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder("SizeConfigStrategy{groupedMap=")).append(f).append(", sortedSizes=(");
        java.util.Map.Entry entry;
        for (Iterator iterator = g.entrySet().iterator(); iterator.hasNext(); stringbuilder.append(entry.getKey()).append('[').append(entry.getValue()).append("], "))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        if (!g.isEmpty())
        {
            stringbuilder.replace(stringbuilder.length() - 2, stringbuilder.length(), "");
        }
        return stringbuilder.append(")}").toString();
    }

    static 
    {
        a = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.ARGB_8888, null
        });
        b = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.RGB_565
        });
        c = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.ARGB_4444
        });
        d = (new android.graphics.Bitmap.Config[] {
            android.graphics.Bitmap.Config.ALPHA_8
        });
    }
}
