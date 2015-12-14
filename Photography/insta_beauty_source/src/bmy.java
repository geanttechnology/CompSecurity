// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.wantu.piprender.renderengine.filters.ImageFilterFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bmy
    implements bmx
{

    protected bmx a;
    protected float b;
    protected float c;
    protected blu d;
    private String e;
    private List f;

    public bmy()
    {
    }

    public void a()
    {
        for (int i = 0; i < f.size(); i++)
        {
            ((bmx)f.get(i)).a();
        }

        a.a();
    }

    public void a(float f1, float f2)
    {
        c = f2;
        b = f1;
        for (int i = 0; i < f.size(); i++)
        {
            ((bmx)f.get(i)).a(f1, f2);
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

    public void a(blu blu)
    {
        d = blu;
        for (int i = 0; i < f.size(); i++)
        {
            ((bmx)f.get(i)).a(blu);
        }

    }

    public void a(bmx bmx1)
    {
        f.add(bmx1);
    }

    public void a(String s)
    {
        e = s;
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
            j = ((bmx)f.get(i)).c(j);
        }

        return j;
    }

    public void d(int i)
    {
        for (int j = 0; j < f.size(); j++)
        {
            ((bmx)f.get(j)).d(i);
        }

        a.d(i);
    }
}
