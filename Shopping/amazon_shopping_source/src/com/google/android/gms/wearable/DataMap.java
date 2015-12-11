// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.lv;
import com.google.android.gms.internal.lw;
import com.google.android.gms.internal.md;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.android.gms.wearable:
//            Asset

public class DataMap
{

    private final HashMap alk = new HashMap();

    public DataMap()
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

    private static boolean a(Asset asset, Asset asset1)
    {
        if (asset == null || asset1 == null)
        {
            return asset == asset1;
        }
        if (!TextUtils.isEmpty(asset.getDigest()))
        {
            return asset.getDigest().equals(asset1.getDigest());
        } else
        {
            return Arrays.equals(asset.getData(), asset1.getData());
        }
    }

    private static boolean a(DataMap datamap, DataMap datamap1)
    {
        if (datamap.size() == datamap1.size()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Iterator iterator = datamap.keySet().iterator();
_L4:
        Object obj;
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_280;
        }
        obj1 = (String)iterator.next();
        obj = datamap.get(((String) (obj1)));
        obj1 = datamap1.get(((String) (obj1)));
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

    public static DataMap fromByteArray(byte abyte0[])
    {
        try
        {
            abyte0 = lv.a(new com.google.android.gms.internal.lv.a(lw.n(abyte0), new ArrayList()));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IllegalArgumentException("Unable to convert data", abyte0);
        }
        return abyte0;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof DataMap))
        {
            return false;
        } else
        {
            return a(this, (DataMap)obj);
        }
    }

    public Object get(String s)
    {
        return alk.get(s);
    }

    public byte[] getByteArray(String s)
    {
        Object obj = alk.get(s);
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

    public String getString(String s)
    {
        Object obj = alk.get(s);
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

    public int hashCode()
    {
        return alk.hashCode() * 29;
    }

    public Set keySet()
    {
        return alk.keySet();
    }

    public void putAsset(String s, Asset asset)
    {
        alk.put(s, asset);
    }

    public void putBoolean(String s, boolean flag)
    {
        alk.put(s, Boolean.valueOf(flag));
    }

    public void putByte(String s, byte byte0)
    {
        alk.put(s, Byte.valueOf(byte0));
    }

    public void putByteArray(String s, byte abyte0[])
    {
        alk.put(s, abyte0);
    }

    public void putDataMap(String s, DataMap datamap)
    {
        alk.put(s, datamap);
    }

    public void putDataMapArrayList(String s, ArrayList arraylist)
    {
        alk.put(s, arraylist);
    }

    public void putDouble(String s, double d)
    {
        alk.put(s, Double.valueOf(d));
    }

    public void putFloat(String s, float f)
    {
        alk.put(s, Float.valueOf(f));
    }

    public void putFloatArray(String s, float af[])
    {
        alk.put(s, af);
    }

    public void putInt(String s, int i)
    {
        alk.put(s, Integer.valueOf(i));
    }

    public void putIntegerArrayList(String s, ArrayList arraylist)
    {
        alk.put(s, arraylist);
    }

    public void putLong(String s, long l)
    {
        alk.put(s, Long.valueOf(l));
    }

    public void putLongArray(String s, long al[])
    {
        alk.put(s, al);
    }

    public void putString(String s, String s1)
    {
        alk.put(s, s1);
    }

    public void putStringArray(String s, String as[])
    {
        alk.put(s, as);
    }

    public void putStringArrayList(String s, ArrayList arraylist)
    {
        alk.put(s, arraylist);
    }

    public Object remove(String s)
    {
        return alk.remove(s);
    }

    public int size()
    {
        return alk.size();
    }

    public String toString()
    {
        return alk.toString();
    }
}
