// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

public class bec
{

    public int a;
    public bec b;
    public int c;
    public int d;
    public int e;
    public int f;
    public bec g;
    public View h;

    public bec()
    {
    }

    public final void a()
    {
        d = 0;
        a = 0;
        e = 0;
        a = 0;
        g = null;
        b = null;
        h = null;
        c = 0;
    }

    public boolean a(int i, int j, int k)
    {
        return i <= a + k && i + j + k >= f;
    }

    public String toString()
    {
        return (new StringBuilder()).append("top:").append(f).append("&bottom:").append(a).toString();
    }
}
