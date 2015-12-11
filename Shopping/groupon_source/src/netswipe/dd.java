// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package netswipe:
//            df, de

public class dd extends JSONArray
{

    private df a;

    public dd()
    {
    }

    private void a(StringBuilder stringbuilder)
    {
        if (stringbuilder != null)
        {
            int i = 0;
            while (i < stringbuilder.length()) 
            {
                stringbuilder.setCharAt(i, '\0');
                i++;
            }
        }
    }

    private void a(char ac[])
    {
        if (ac != null)
        {
            int i = 0;
            while (i < ac.length) 
            {
                Arrays.fill(ac, '\0');
                i++;
            }
        }
    }

    public void a()
    {
        if (a != null)
        {
            a.e();
        }
        int i = 0;
        while (i < length()) 
        {
            Object obj = opt(i);
            if (obj != null)
            {
                if (obj instanceof StringBuilder)
                {
                    a((StringBuilder)obj);
                } else
                if (obj instanceof char[])
                {
                    a((char[])(char[])obj);
                } else
                if (obj instanceof dd)
                {
                    ((dd)obj).a();
                } else
                if (obj instanceof de)
                {
                    ((de)obj).a();
                }
            }
            i++;
        }
    }

    public void a(df df1)
        throws JSONException
    {
        df1.a();
        for (int i = 0; i < length(); i++)
        {
            df1.a(opt(i));
        }

        df1.b();
    }

    public String toString()
    {
        String s;
        try
        {
            if (a != null)
            {
                a.e();
            }
            a = new df();
            a(a);
            s = a.toString();
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return s;
    }

    public String toString(int i)
        throws JSONException
    {
        if (a != null)
        {
            a.e();
        }
        a = new df(i);
        a(a);
        return a.toString();
    }
}
