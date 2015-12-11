// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.Uri;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            kb

public static class d
{

    private String a;
    private String b;
    private Uri c;
    private int d[];

    static d a(JSONObject jsonobject)
    {
        return b(jsonobject);
    }

    private static int[] a(JSONArray jsonarray)
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
                    if (!kb.a(s))
                    {
                        try
                        {
                            i = Integer.parseInt(s);
                        }
                        catch (NumberFormatException numberformatexception)
                        {
                            kb.a("FacebookSDK", numberformatexception);
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

    private static nt b(JSONObject jsonobject)
    {
        Uri uri = null;
        String s = jsonobject.optString("name");
        String as[];
        if (!kb.a(s))
        {
            if ((as = s.split("\\|")).length == 2)
            {
                String s1 = as[0];
                String s2 = as[1];
                if (!kb.a(s1) && !kb.a(s2))
                {
                    String s3 = jsonobject.optString("url");
                    if (!kb.a(s3))
                    {
                        uri = Uri.parse(s3);
                    }
                    return new <init>(s1, s2, uri, a(jsonobject.optJSONArray("versions")));
                }
            }
        }
        return null;
    }

    public String a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public int[] c()
    {
        return d;
    }

    private ception(String s, String s1, Uri uri, int ai[])
    {
        a = s;
        b = s1;
        c = uri;
        d = ai;
    }
}
