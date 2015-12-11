// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package jumiomobile:
//            x, aa

public class z extends JSONArray
{

    private x a;

    public z()
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
                    a((char[])obj);
                } else
                if (obj instanceof z)
                {
                    ((z)obj).a();
                } else
                if (obj instanceof aa)
                {
                    ((aa)obj).a();
                }
            }
            i++;
        }
    }

    public void a(x x1)
    {
        x1.a();
        for (int i = 0; i < length(); i++)
        {
            x1.a(opt(i));
        }

        x1.b();
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
            a = new x();
            a(a);
            s = a.toString();
        }
        catch (JSONException jsonexception)
        {
            return super.toString();
        }
        return s;
    }

    public String toString(int i)
    {
        if (a != null)
        {
            a.e();
        }
        a = new x(i);
        a(a);
        return a.toString();
    }
}
