// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.a;

import cn.jpush.android.util.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{

    private static final String z;
    private int a;
    private int b;
    private int c;
    private int d;
    private String e;
    private double f;
    private double g;

    public a()
    {
    }

    public final int a()
    {
        return a;
    }

    public final void a(int i)
    {
        a = i;
    }

    public final void a(String s)
    {
        e = s;
    }

    public final JSONArray b()
    {
        JSONArray jsonarray = new JSONArray();
        try
        {
            jsonarray.put(new JSONObject(toString()));
        }
        catch (JSONException jsonexception)
        {
            cn/jpush/android/a/a.getSimpleName();
            jsonexception.getMessage();
            x.f();
            return null;
        }
        return jsonarray;
    }

    public final void b(int i)
    {
        b = i;
    }

    public final void c(int i)
    {
        c = i;
    }

    public final void d(int i)
    {
        d = i;
    }

    public String toString()
    {
        String s;
        try
        {
            s = String.format(z, new Object[] {
                Integer.valueOf(a), Integer.valueOf(b), Integer.valueOf(d), Integer.valueOf(c), e, Double.valueOf(f), Double.valueOf(g)
            });
        }
        catch (Exception exception)
        {
            return "";
        }
        return s;
    }

    static 
    {
        char ac[];
        char ac1[];
        int i;
        int j;
        int k;
        int l;
        ac = "~+\035/mi@\032h; mRhljk\027&dFf\013$uwp=%e`+Doe)+\022%bd}\027%oD{\033+Bjm\033h; mRhljk\027&dKl\n=nwb=%e`+Doe)+\f+elf*3q`+Dh$v+Rhmd}\\p$c%\\&ob+Dogx".toCharArray();
        j = ac.length;
        l = 0;
        i = 0;
        ac1 = ac;
        k = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        l = i;
        k = i;
_L9:
        char c1;
        ac1 = ac;
        c1 = ac1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 72
    //                   0 134
    //                   1 139
    //                   2 145
    //                   3 151;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_151;
_L3:
        i = 1;
_L10:
label0:
        {
            ac1[k] = (char)(i ^ c1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        k = j;
        ac1 = ac;
_L2:
        ac = ac1;
        j = k;
        i = l;
        if (k <= l)
        {
            z = (new String(ac1)).intern();
            return;
        }
          goto _L1
_L8:
        i = 5;
          goto _L10
_L5:
        i = 9;
          goto _L10
_L6:
        i = 126;
          goto _L10
        i = 74;
          goto _L10
    }
}
