// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Hashtable;
import java.util.Vector;

public class ff
    implements fa
{

    private static final bm a = d.a(ff);
    private Vector b;

    public ff(Vector vector)
    {
        if (a.b())
        {
            a.b((new StringBuilder("Received ")).append(vector.size()).append(" sentences constituting the dictation result.").toString());
        }
        b = vector;
        for (int i = 0; i < b.size(); i++)
        {
            fg fg1 = (fg)vector.elementAt(i);
            fg1.a(this);
            fg1.c();
        }

    }

    public final int a()
    {
        return b.size();
    }

    public final fc a(int i)
    {
        if (i < 0 || i >= b.size())
        {
            return null;
        } else
        {
            return (fc)b.elementAt(i);
        }
    }

    final Vector a(fg fg1, Vector vector)
    {
        int i = 0;
        if (vector.size() == 0)
        {
            return new Vector();
        }
        long l = ((fh)vector.elementAt(0)).c();
        long l1 = ((fh)vector.elementAt(vector.size() - 1)).d();
        if (a.b())
        {
            a.b((new StringBuilder("Getting alternatives of ")).append(fg1).append(" at times [").append(l).append(", ").append(l1).append("]").toString());
        }
        vector = new Vector();
        Hashtable hashtable = new Hashtable();
        Object obj = new Object();
        hashtable.put(fg1.a(l, l1).toString(), obj);
        while (i < b.size()) 
        {
            Object obj1 = (fg)b.elementAt(i);
            if (obj1 == fg1)
            {
                if (a.b())
                {
                    a.b((new StringBuilder("Found the same sentence at index ")).append(i).toString());
                }
            } else
            {
                obj1 = ((fg) (obj1)).a(l, l1);
                fe.b();
                if (a.b())
                {
                    a.b((new StringBuilder("Got alternative [")).append(obj1).append("] for sentence at index ").append(i).toString());
                }
                if (((fe) (obj1)).a() == 0)
                {
                    if (a.b())
                    {
                        a.b((new StringBuilder("Got no alternative for sentence at index ")).append(i).toString());
                    }
                } else
                {
                    String s = ((fe) (obj1)).toString();
                    if (hashtable.containsKey(s))
                    {
                        if (a.b())
                        {
                            a.b("That alternative has already been given by another sentence.");
                        }
                    } else
                    {
                        hashtable.put(s, obj);
                        vector.addElement(obj1);
                    }
                }
            }
            i++;
        }
        return vector;
    }

    public String toString()
    {
        if (b.size() > 0)
        {
            return b.elementAt(0).toString();
        } else
        {
            return "";
        }
    }

}
