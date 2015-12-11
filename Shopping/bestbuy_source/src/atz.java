// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.wearable.Asset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class atz
{

    private final HashMap a = new HashMap();

    public atz()
    {
    }

    private void a(String s, Object obj, String s1, ClassCastException classcastexception)
    {
        a(s, obj, s1, "<null>", classcastexception);
    }

    private void a(String s, Object obj, String s1, Object obj1, ClassCastException classcastexception)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Key ");
        stringbuilder.append(s);
        stringbuilder.append(" expected ");
        stringbuilder.append(s1);
        stringbuilder.append(" but value was a ");
        stringbuilder.append(obj.getClass().getName());
        stringbuilder.append(".  The default value ");
        stringbuilder.append(obj1);
        stringbuilder.append(" was returned.");
        Log.w("DataMap", stringbuilder.toString());
        Log.w("DataMap", "Attempt to cast generated internal exception:", classcastexception);
    }

    private static boolean a(atz atz1, atz atz2)
    {
        if (atz1.a() == atz2.a()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Iterator iterator = atz1.b().iterator();
_L4:
        Object obj;
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_280;
        }
        obj1 = (String)iterator.next();
        obj = atz1.b(((String) (obj1)));
        obj1 = atz2.b(((String) (obj1)));
        if (!(obj instanceof Asset))
        {
            break MISSING_BLOCK_LABEL_90;
        }
        if (!(obj1 instanceof Asset)) goto _L1; else goto _L3
_L3:
        if (!a((Asset)obj, (Asset)obj1))
        {
            return false;
        }
          goto _L4
        if (!(obj instanceof String[]))
        {
            break MISSING_BLOCK_LABEL_128;
        }
        if (!(obj1 instanceof String[])) goto _L1; else goto _L5
_L5:
        if (!Arrays.equals((String[])(String[])obj, (String[])(String[])obj1))
        {
            return false;
        }
          goto _L4
        if (!(obj instanceof long[]))
        {
            break MISSING_BLOCK_LABEL_166;
        }
        if (!(obj1 instanceof long[])) goto _L1; else goto _L6
_L6:
        if (!Arrays.equals((long[])(long[])obj, (long[])(long[])obj1))
        {
            return false;
        }
          goto _L4
        if (!(obj instanceof float[]))
        {
            break MISSING_BLOCK_LABEL_204;
        }
        if (!(obj1 instanceof float[])) goto _L1; else goto _L7
_L7:
        if (!Arrays.equals((float[])(float[])obj, (float[])(float[])obj1))
        {
            return false;
        }
          goto _L4
        if (!(obj instanceof byte[]))
        {
            break MISSING_BLOCK_LABEL_242;
        }
        if (!(obj1 instanceof byte[])) goto _L1; else goto _L8
_L8:
        if (!Arrays.equals((byte[])(byte[])obj, (byte[])(byte[])obj1))
        {
            return false;
        }
          goto _L4
        if (obj == null || obj1 == null)
        {
            boolean flag;
            if (obj == obj1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return flag;
        }
        if (!obj.equals(obj1))
        {
            return false;
        }
          goto _L4
        return true;
    }

    private static boolean a(Asset asset, Asset asset1)
    {
        if (asset == null || asset1 == null)
        {
            return asset == asset1;
        }
        if (!TextUtils.isEmpty(asset.b()))
        {
            return asset.b().equals(asset1.b());
        } else
        {
            return Arrays.equals(asset.a(), asset1.a());
        }
    }

    public int a()
    {
        return a.size();
    }

    public void a(atz atz1)
    {
        String s;
        for (Iterator iterator = atz1.b().iterator(); iterator.hasNext(); a.put(s, atz1.b(s)))
        {
            s = (String)iterator.next();
        }

    }

    public void a(String s, byte byte0)
    {
        a.put(s, Byte.valueOf(byte0));
    }

    public void a(String s, double d1)
    {
        a.put(s, Double.valueOf(d1));
    }

    public void a(String s, float f1)
    {
        a.put(s, Float.valueOf(f1));
    }

    public void a(String s, int i)
    {
        a.put(s, Integer.valueOf(i));
    }

    public void a(String s, long l)
    {
        a.put(s, Long.valueOf(l));
    }

    public void a(String s, atz atz1)
    {
        a.put(s, atz1);
    }

    public void a(String s, Asset asset)
    {
        a.put(s, asset);
    }

    public void a(String s, String s1)
    {
        a.put(s, s1);
    }

    public void a(String s, ArrayList arraylist)
    {
        a.put(s, arraylist);
    }

    public void a(String s, boolean flag)
    {
        a.put(s, Boolean.valueOf(flag));
    }

    public void a(String s, byte abyte0[])
    {
        a.put(s, abyte0);
    }

    public void a(String s, float af[])
    {
        a.put(s, af);
    }

    public void a(String s, long al[])
    {
        a.put(s, al);
    }

    public void a(String s, String as[])
    {
        a.put(s, as);
    }

    public boolean a(String s)
    {
        return a.containsKey(s);
    }

    public int b(String s, int i)
    {
        Object obj = a.get(s);
        if (obj == null)
        {
            return i;
        }
        int j;
        try
        {
            j = ((Integer)obj).intValue();
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "Integer", classcastexception);
            return i;
        }
        return j;
    }

    public long b(String s, long l)
    {
        Object obj = a.get(s);
        if (obj == null)
        {
            return l;
        }
        long l1;
        try
        {
            l1 = ((Long)obj).longValue();
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "long", classcastexception);
            return l;
        }
        return l1;
    }

    public Object b(String s)
    {
        return a.get(s);
    }

    public Set b()
    {
        return a.keySet();
    }

    public void b(String s, ArrayList arraylist)
    {
        a.put(s, arraylist);
    }

    public boolean b(String s, boolean flag)
    {
        Object obj = a.get(s);
        if (obj == null)
        {
            return flag;
        }
        boolean flag1;
        try
        {
            flag1 = ((Boolean)obj).booleanValue();
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "Boolean", Boolean.valueOf(flag), classcastexception);
            return flag;
        }
        return flag1;
    }

    public void c(String s, ArrayList arraylist)
    {
        a.put(s, arraylist);
    }

    public boolean c(String s)
    {
        return b(s, false);
    }

    public int d(String s)
    {
        return b(s, 0);
    }

    public long e(String s)
    {
        return b(s, 0L);
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof atz))
        {
            return false;
        } else
        {
            return a(this, (atz)obj);
        }
    }

    public String f(String s)
    {
        Object obj = a.get(s);
        if (obj == null)
        {
            return null;
        }
        String s1;
        try
        {
            s1 = (String)obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "String", classcastexception);
            return null;
        }
        return s1;
    }

    public Asset g(String s)
    {
        Object obj = a.get(s);
        if (obj == null)
        {
            return null;
        }
        Asset asset;
        try
        {
            asset = (Asset)obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "Asset", classcastexception);
            return null;
        }
        return asset;
    }

    public byte[] h(String s)
    {
        Object obj = a.get(s);
        if (obj == null)
        {
            return null;
        }
        byte abyte0[];
        try
        {
            abyte0 = (byte[])(byte[])obj;
        }
        catch (ClassCastException classcastexception)
        {
            a(s, obj, "byte[]", classcastexception);
            return null;
        }
        return abyte0;
    }

    public int hashCode()
    {
        return a.hashCode() * 29;
    }

    public String toString()
    {
        return a.toString();
    }
}
