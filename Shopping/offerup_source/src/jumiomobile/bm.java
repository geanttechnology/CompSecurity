// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bm
    implements Serializable
{

    private final Pattern a[];

    public bm(String s)
    {
        this(s, true);
    }

    public bm(String s, boolean flag)
    {
        this(new String[] {
            s
        }, flag);
    }

    public bm(String as[], boolean flag)
    {
        int i = 0;
        super();
        if (as == null || as.length == 0)
        {
            throw new IllegalArgumentException("Regular expressions are missing");
        }
        a = new Pattern[as.length];
        byte byte0;
        if (flag)
        {
            byte0 = 0;
        } else
        {
            byte0 = 2;
        }
        for (; i < as.length; i++)
        {
            if (as[i] == null || as[i].length() == 0)
            {
                throw new IllegalArgumentException((new StringBuilder("Regular expression[")).append(i).append("] is missing").toString());
            }
            a[i] = Pattern.compile(as[i], byte0);
        }

    }

    public boolean a(String s)
    {
        if (s != null)
        {
            int i = 0;
            while (i < a.length) 
            {
                if (a[i].matcher(s).matches())
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public String[] b(String s)
    {
        boolean flag;
        flag = false;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_11;
        }
        s = null;
        return s;
        String as[];
        Matcher matcher;
        int j;
        int i = 0;
          goto _L1
        continue; /* Loop/switch isn't completed */
        i++;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("RegexValidator{");
        for (int i = 0; i < a.length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(",");
            }
            stringbuffer.append(a[i].pattern());
        }

        stringbuffer.append("}");
        return stringbuffer.toString();
    }
}
