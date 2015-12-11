// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzam, zzc, Command

public class zzab
{

    private final List zzPe;
    private final long zzPf;
    private final long zzPg;
    private final int zzPh;
    private final boolean zzPi;
    private final String zzPj;
    private final Map zzvS;

    public zzab(zzc zzc1, Map map, long l, boolean flag)
    {
        this(zzc1, map, l, flag, 0L, 0, null);
    }

    public zzab(zzc zzc1, Map map, long l, boolean flag, long l1, 
            int i)
    {
        this(zzc1, map, l, flag, l1, i, null);
    }

    public zzab(zzc zzc1, Map map, long l, boolean flag, long l1, 
            int i, List list)
    {
        zzx.zzw(zzc1);
        zzx.zzw(map);
        zzPg = l;
        zzPi = flag;
        zzPf = l1;
        zzPh = i;
        Object obj;
        if (list != null)
        {
            obj = list;
        } else
        {
            obj = Collections.EMPTY_LIST;
        }
        zzPe = ((List) (obj));
        zzPj = zzl(list);
        list = new HashMap();
        obj = map.entrySet().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            java.util.Map.Entry entry1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            if (zzj(entry1.getKey()))
            {
                String s1 = zza(zzc1, entry1.getKey());
                if (s1 != null)
                {
                    list.put(s1, zzb(zzc1, entry1.getValue()));
                }
            }
        } while (true);
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if (!zzj(entry.getKey()))
            {
                String s = zza(zzc1, entry.getKey());
                if (s != null)
                {
                    list.put(s, zzb(zzc1, entry.getValue()));
                }
            }
        } while (true);
        if (!TextUtils.isEmpty(zzPj))
        {
            zzam.zzc(list, "_v", zzPj);
            if (zzPj.equals("ma4.0.0") || zzPj.equals("ma4.0.1"))
            {
                list.remove("adid");
            }
        }
        zzvS = Collections.unmodifiableMap(list);
    }

    public static zzab zza(zzc zzc1, zzab zzab1, Map map)
    {
        return new zzab(zzc1, map, zzab1.zzkA(), zzab1.zzkC(), zzab1.zzkz(), zzab1.zzky(), zzab1.zzkB());
    }

    private static String zza(zzc zzc1, Object obj)
    {
        if (obj == null)
        {
            zzc1 = null;
        } else
        {
            Object obj1 = obj.toString();
            obj = obj1;
            if (((String) (obj1)).startsWith("&"))
            {
                obj = ((String) (obj1)).substring(1);
            }
            int i = ((String) (obj)).length();
            obj1 = obj;
            if (i > 256)
            {
                obj1 = ((String) (obj)).substring(0, 256);
                zzc1.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(i), obj1);
            }
            zzc1 = ((zzc) (obj1));
            if (TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                return null;
            }
        }
        return zzc1;
    }

    private static String zzb(zzc zzc1, Object obj)
    {
        Object obj1;
        int i;
        if (obj == null)
        {
            obj = "";
        } else
        {
            obj = obj.toString();
        }
        i = ((String) (obj)).length();
        obj1 = obj;
        if (i > 8192)
        {
            obj1 = ((String) (obj)).substring(0, 8192);
            zzc1.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(i), obj1);
        }
        return ((String) (obj1));
    }

    private static boolean zzj(Object obj)
    {
        if (obj == null)
        {
            return false;
        } else
        {
            return obj.toString().startsWith("&");
        }
    }

    private static String zzl(List list)
    {
        if (list == null) goto _L2; else goto _L1
_L1:
        list = list.iterator();
_L5:
        if (!list.hasNext()) goto _L2; else goto _L3
_L3:
        Command command = (Command)list.next();
        if (!"appendVersion".equals(command.getId())) goto _L5; else goto _L4
_L4:
        list = command.getValue();
_L7:
        if (TextUtils.isEmpty(list))
        {
            return null;
        } else
        {
            return list;
        }
_L2:
        list = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private String zzo(String s, String s1)
    {
        zzx.zzcr(s);
        boolean flag;
        if (!s.startsWith("&"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Short param name required");
        s = (String)zzvS.get(s);
        if (s != null)
        {
            return s;
        } else
        {
            return s1;
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("ht=").append(zzPg);
        if (zzPf != 0L)
        {
            stringbuffer.append(", dbId=").append(zzPf);
        }
        if ((long)zzPh != 0L)
        {
            stringbuffer.append(", appUID=").append(zzPh);
        }
        Object obj = new ArrayList(zzvS.keySet());
        Collections.sort(((List) (obj)));
        String s;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuffer.append((String)zzvS.get(s)))
        {
            s = (String)((Iterator) (obj)).next();
            stringbuffer.append(", ");
            stringbuffer.append(s);
            stringbuffer.append("=");
        }

        return stringbuffer.toString();
    }

    public long zzkA()
    {
        return zzPg;
    }

    public List zzkB()
    {
        return zzPe;
    }

    public boolean zzkC()
    {
        return zzPi;
    }

    public long zzkD()
    {
        return zzam.zzbq(zzo("_s", "0"));
    }

    public String zzkE()
    {
        return zzo("_m", "");
    }

    public int zzky()
    {
        return zzPh;
    }

    public long zzkz()
    {
        return zzPf;
    }

    public Map zzn()
    {
        return zzvS;
    }
}
