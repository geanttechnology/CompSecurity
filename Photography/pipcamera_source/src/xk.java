// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class xk
    implements xj
{

    protected xj a;
    protected float b;
    protected float c;
    protected wf d;
    private String e;
    private List f;

    public xk()
    {
    }

    public void a()
    {
        for (int i = 0; i < f.size(); i++)
        {
            ((xj)f.get(i)).a();
        }

        a.a();
    }

    public void a(float f1, float f2)
    {
        c = f2;
        b = f1;
        for (int i = 0; i < f.size(); i++)
        {
            ((xj)f.get(i)).a(f1, f2);
        }

        a.a(f1, f2);
    }

    public void a(int i, int j)
    {
        j = c(j);
        a.a(i, j);
    }

    public void a(Context context, HashMap hashmap)
    {
        f = new ArrayList();
        a = ImageFilterFactory.a(context, com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE, null);
    }

    public void a(String s)
    {
        e = s;
    }

    public void a(wf wf)
    {
        d = wf;
        for (int i = 0; i < f.size(); i++)
        {
            ((xj)f.get(i)).a(wf);
        }

    }

    public void a(xj xj1)
    {
        f.add(xj1);
    }

    public void b(int i)
    {
        a(0, i);
    }

    public int c(int i)
    {
        d(i);
        boolean flag = false;
        int j = i;
        for (i = ((flag) ? 1 : 0); i < f.size(); i++)
        {
            j = ((xj)f.get(i)).c(j);
        }

        return j;
    }

    public void d(int i)
    {
        for (int j = 0; j < f.size(); j++)
        {
            ((xj)f.get(j)).d(i);
        }

        a.d(i);
    }
}
