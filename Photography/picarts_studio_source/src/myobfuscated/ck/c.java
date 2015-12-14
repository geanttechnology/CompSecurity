// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.util.Log;
import android.util.TypedValue;
import com.photo.effect.Effect;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.h;
import com.picsart.studio.EditingData;
import com.socialin.android.photo.effects.draw.a;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import myobfuscated.cj.b;

public final class c
{

    public Point a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public String g;
    public myobfuscated.ci.c h;
    public Effect i;
    public a j;
    public com.socialin.android.photo.effects.factory.b k;
    public b l;
    public boolean m;
    public boolean n;
    public HashMap o;
    String p;
    EditingData q;
    Bitmap r;

    public c()
    {
        a = new Point();
        b = 0;
        c = false;
        d = false;
        e = false;
        f = false;
        g = "None";
        j = null;
        m = false;
        n = false;
        q = null;
    }

    public final Bitmap a(Context context)
    {
        if (l != null)
        {
            int i1 = (int)TypedValue.applyDimension(1, 170F, context.getResources().getDisplayMetrics());
            context = l.c;
            if (context == null)
            {
                if (r != null)
                {
                    return w.a(new Matrix(), r, i1, i1, false);
                }
            } else
            {
                HashMap hashmap = ((myobfuscated.cj.c) (context)).c;
                String s = ((myobfuscated.cj.c) (context)).a;
                int j1 = ((myobfuscated.cj.c) (context)).b;
                if (hashmap != null)
                {
                    return w.a(hashmap, i1, i1, 0);
                }
                try
                {
                    context = w.a(s, i1, i1, j1);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return null;
                }
                return context;
            }
        }
        return null;
    }

    public final boolean a()
    {
        return g == null || g.compareTo("None") == 0;
    }

    public final boolean b()
    {
        if (k != null && g != null)
        {
            return k.b(g);
        } else
        {
            return false;
        }
    }

    public final boolean c()
    {
        return i != null;
    }

    public final boolean d()
    {
        return j == null || j.c.m == com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH;
    }

    public final boolean e()
    {
        return l.d != null;
    }

    public final boolean f()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (j != null)
        {
            flag = flag1;
            if (j.c.m == com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.SHAPE)
            {
                flag = true;
            }
        }
        return flag;
    }

    public final boolean g()
    {
        if (j != null)
        {
            return j.c.p;
        } else
        {
            return false;
        }
    }

    public final h h()
    {
        if (j != null)
        {
            return j.c.l;
        } else
        {
            return null;
        }
    }

    public final ArrayList i()
    {
        ArrayList arraylist = null;
        Object obj = l.a();
        if (obj != null)
        {
            arraylist = ((myobfuscated.cj.c) (obj)).a();
        }
        obj = arraylist;
        if (arraylist == null)
        {
            obj = new ArrayList();
        }
        if (g != null && g.compareTo("None") != 0)
        {
            ((ArrayList) (obj)).add(g);
        }
        return ((ArrayList) (obj));
    }

    public final String j()
    {
        String s;
        if (q != null)
        {
            s = q.a;
        } else
        {
            s = "";
            String s2 = k();
            Log.e("ex1", (new StringBuilder("trying to get uid from: ")).append(s2).toString());
            if (s2 != null)
            {
                Log.e("ex1", "path isnt null");
                String s1 = x.b(s2);
                Log.e("ex1", (new StringBuilder("uid: ")).append(s1).toString());
                return s1;
            }
        }
        return s;
    }

    public final String k()
    {
        String s = null;
        if (l != null)
        {
            myobfuscated.cj.c c1 = l.c;
            String s1 = c1.a;
            s = s1;
            if (s1 == null)
            {
                s = (String)c1.c.get("Path");
            }
        }
        return s;
    }
}
