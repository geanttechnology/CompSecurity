// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.whatsapp;

import com.whatsapp.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.whatsapp:
//            _l, DialogToastActivity

public class ad0
{

    private static final String z[];
    private String a;
    private String b;
    private String c;

    public ad0(String s)
    {
        int i = _l.a;
        super();
        try
        {
            a = s;
            JSONObject jsonobject = new JSONObject(a);
            c = jsonobject.optString(z[2]);
            b = jsonobject.optString(z[1]);
        }
        catch (JSONException jsonexception)
        {
            Log.e((new StringBuilder()).append(z[0]).append(s).toString());
            throw new RuntimeException(jsonexception);
        }
        try
        {
            if (DialogToastActivity.g != 0)
            {
                _l.a = i + 1;
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw s;
        }
    }

    public String a()
    {
        return c;
    }

    public String b()
    {
        return b;
    }

    public String toString()
    {
        return (new StringBuilder()).append(z[3]).append(a).toString();
    }

    static 
    {
        Object obj;
        String as[];
        byte byte1;
        int i;
        as = new String[4];
        obj = "{*{n\036m5o*\026{nd0\025flk;\031m1z*\025fad0\025f|";
        byte1 = -1;
        i = 0;
_L2:
        String as1[];
        int j;
        int k;
        as1 = as;
        obj = ((String) (obj)).toCharArray();
        k = obj.length;
        j = 0;
_L8:
label0:
        {
            if (k > j)
            {
                break label0;
            }
            obj = (new String(((char []) (obj)))).intern();
            switch (byte1)
            {
            default:
                as1[i] = ((String) (obj));
                obj = "x3g \037";
                i = 1;
                byte1 = 0;
                break;

            case 0: // '\0'
                as1[i] = ((String) (obj));
                obj = "x3a'\017k5G'";
                i = 2;
                byte1 = 1;
                break;

            case 1: // '\001'
                as1[i] = ((String) (obj));
                i = 3;
                obj = "{*{n\036m5o*\026{|";
                byte1 = 2;
                break;

            case 2: // '\002'
                as1[i] = ((String) (obj));
                z = as;
                return;
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        char c1 = obj[j];
        j % 5;
        JVM INSTR tableswitch 0 3: default 176
    //                   0 197
    //                   1 203
    //                   2 209
    //                   3 215;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_215;
_L3:
        byte byte0 = 122;
_L9:
        obj[j] = (char)(byte0 ^ c1);
        j++;
          goto _L8
_L4:
        byte0 = 8;
          goto _L9
_L5:
        byte0 = 65;
          goto _L9
_L6:
        byte0 = 14;
          goto _L9
        byte0 = 67;
          goto _L9
    }
}
