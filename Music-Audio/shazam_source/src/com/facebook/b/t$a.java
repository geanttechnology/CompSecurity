// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.net.Uri;
import org.json.JSONArray;

// Referenced classes of package com.facebook.b:
//            t

public static final class d
{

    String a;
    String b;
    Uri c;
    int d[];

    static int[] a(JSONArray jsonarray)
    {
        int ai[] = null;
        if (jsonarray != null)
        {
            int l = jsonarray.length();
            ai = new int[l];
            int j = 0;
            do
            {
                if (j >= l)
                {
                    break;
                }
                int k = jsonarray.optInt(j, -1);
                int i = k;
                if (k == -1)
                {
                    String s = jsonarray.optString(j);
                    i = k;
                    if (!t.a(s))
                    {
                        try
                        {
                            i = Integer.parseInt(s);
                        }
                        catch (NumberFormatException numberformatexception)
                        {
                            t.a(numberformatexception);
                            i = -1;
                        }
                    }
                }
                ai[j] = i;
                j++;
            } while (true);
        }
        return ai;
    }

    matException(String s, String s1, Uri uri, int ai[])
    {
        a = s;
        b = s1;
        c = uri;
        d = ai;
    }
}
