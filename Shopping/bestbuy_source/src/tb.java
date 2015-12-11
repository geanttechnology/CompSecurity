// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public class tb
{

    private final int a = 6;
    private final int b;
    private final ta c = new td();
    private Base64OutputStream d;
    private ByteArrayOutputStream e;

    public tb(int i)
    {
        b = i;
    }

    private String b(String s)
    {
        s = s.split("\n");
        if (s == null || s.length == 0)
        {
            return "";
        }
        e = new ByteArrayOutputStream();
        d = new Base64OutputStream(e, 10);
        Arrays.sort(s, new Comparator() {

            final tb a;

            public int a(String s1, String s2)
            {
                return s2.length() - s1.length();
            }

            public int compare(Object obj, Object obj1)
            {
                return a((String)obj, (String)obj1);
            }

            
            {
                a = tb.this;
                super();
            }
        });
        int i = 0;
        while (i < s.length && i < b) 
        {
            if (s[i].trim().length() != 0)
            {
                try
                {
                    d.write(c.a(s[i]));
                }
                catch (IOException ioexception)
                {
                    acb.b("Error while writing hash to byteStream", ioexception);
                }
            }
            i++;
        }
        try
        {
            d.flush();
            d.close();
            s = e.toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            acb.b("HashManager: Unable to convert to base 64", s);
            return "";
        }
        return s;
    }

    String a(String s)
    {
        s = s.split("\n");
        if (s == null || s.length == 0)
        {
            return "";
        }
        e = new ByteArrayOutputStream();
        d = new Base64OutputStream(e, 10);
        PriorityQueue priorityqueue = new PriorityQueue(b, new Comparator() {

            final tb a;

            public int a(tf tf2, tf tf3)
            {
                return (int)(tf2.a - tf3.a);
            }

            public int compare(Object obj, Object obj1)
            {
                return a((tf)obj, (tf)obj1);
            }

            
            {
                a = tb.this;
                super();
            }
        });
        int i = 0;
        while (i < s.length) 
        {
            String as[] = tc.b(s[i]);
            if (as.length >= a)
            {
                te.a(as, b, a, priorityqueue);
            }
            i++;
        }
        for (s = priorityqueue.iterator(); s.hasNext();)
        {
            tf tf1 = (tf)s.next();
            try
            {
                d.write(c.a(tf1.b));
            }
            catch (IOException ioexception)
            {
                acb.b("Error while writing hash to byteStream", ioexception);
            }
        }

        try
        {
            d.flush();
            d.close();
            s = e.toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            acb.b("HashManager: unable to convert to base 64", s);
            return "";
        }
        return s;
    }

    public String a(ArrayList arraylist)
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); stringbuffer.append('\n'))
        {
            stringbuffer.append(((String)arraylist.next()).toLowerCase(Locale.US));
        }

        switch (0)
        {
        default:
            return "";

        case 0: // '\0'
            return a(stringbuffer.toString());

        case 1: // '\001'
            return b(stringbuffer.toString());
        }
    }
}
