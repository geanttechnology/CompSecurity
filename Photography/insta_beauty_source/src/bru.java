// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class bru
{

    private Bundle a;
    private List b;

    public bru()
    {
        a = new Bundle();
        b = new ArrayList();
    }

    public int a()
    {
        return b.size();
    }

    public String a(int i)
    {
        if (i >= 0 && i < b.size())
        {
            return (String)b.get(i);
        } else
        {
            return "";
        }
    }

    public void a(bru bru1)
    {
        for (int i = 0; i < bru1.a(); i++)
        {
            a(bru1.a(i), bru1.b(i));
        }

    }

    public void a(String s)
    {
        b.remove(s);
        a.remove(s);
    }

    public void a(String s, String s1)
    {
        if (b.contains(s))
        {
            a.putString(s, s1);
            return;
        } else
        {
            b.add(s);
            a.putString(s, s1);
            return;
        }
    }

    public String b(int i)
    {
        String s = (String)b.get(i);
        return a.getString(s);
    }

    public String b(String s)
    {
        return a.getString(s);
    }
}
