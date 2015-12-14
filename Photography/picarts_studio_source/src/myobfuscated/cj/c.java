// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cj;

import java.util.ArrayList;
import java.util.HashMap;

public final class c
{

    public String a;
    public int b;
    public HashMap c;
    public ArrayList d;

    public c(String s, int i, HashMap hashmap)
    {
        d = new ArrayList();
        a = s;
        b = i;
        c = hashmap;
    }

    public final ArrayList a()
    {
        ArrayList arraylist = new ArrayList();
        if (d != null)
        {
            for (int i = 0; i < d.size(); i++)
            {
                arraylist.add(d.get(i));
            }

        }
        return arraylist;
    }
}
