// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package netswipe:
//            df, dd

public class de extends JSONObject
{

    private df a;

    public de()
    {
        a = null;
    }

    public de(String s)
        throws JSONException
    {
        super(s);
        a = null;
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

    public void a()
    {
        Iterator iterator;
        if (a != null)
        {
            a.e();
        }
        iterator = keys();
_L2:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_98;
        }
        Object obj = opt((String)iterator.next());
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof StringBuilder)
        {
            a((StringBuilder)obj);
            continue; /* Loop/switch isn't completed */
        }
        if (obj instanceof dd)
        {
            ((dd)obj).a();
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            if (obj instanceof de)
            {
                ((de)obj).a();
            }
        }
        catch (Exception exception) { }
        continue; /* Loop/switch isn't completed */
        return;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void a(df df1)
        throws JSONException
    {
        df1.c();
        String s;
        for (Iterator iterator = keys(); iterator.hasNext(); df1.a(s).a(opt(s)))
        {
            s = (String)iterator.next();
        }

        df1.d();
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
