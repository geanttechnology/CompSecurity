// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import com.socialin.android.d;
import com.socialin.android.photo.freecrop.b;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.socialin.android.photo.select:
//            SelectionDrawController, h

public abstract class g extends ModernAsyncTask
{

    private static final String l = com/socialin/android/photo/select/g.getSimpleName();
    public int a;
    public h b;
    public String c;
    public int d;
    public HashMap e;
    public int f;
    public b g;
    public Bitmap h;
    public SelectionDrawController i;
    public Point j;
    public boolean k;
    private Runnable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private RectF q;

    public g()
    {
        k = true;
        n = true;
        o = false;
        p = false;
    }

    private static Bitmap a(HashMap hashmap, String s, int i1, int j1)
    {
        Object obj = null;
        if (hashmap == null) goto _L2; else goto _L1
_L1:
        ((Integer)hashmap.get("width")).intValue();
        ((Integer)hashmap.get("height")).intValue();
        hashmap = w.a(hashmap, j1, 0);
_L3:
        if (hashmap != null && !hashmap.isMutable())
        {
            s = com.socialin.android.util.c.b(hashmap, android.graphics.Bitmap.Config.ARGB_8888);
            com.socialin.android.util.c.a(hashmap);
            return s;
        } else
        {
            return hashmap;
        }
_L2:
        hashmap = obj;
        s = w.b(s, j1, i1);
        hashmap = s;
        s.getWidth();
        hashmap = s;
        s.getHeight();
        hashmap = s;
          goto _L3
        s;
        com.socialin.android.d.b(l, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s.getMessage()).toString()
        });
          goto _L3
    }

    public static void a(Runnable runnable, boolean flag, ThreadPoolExecutor threadpoolexecutor)
    {
        g g1 = new g() {

        };
        g1.m = runnable;
        g1.n = flag;
        g1.a = 5;
        g1.executeOnExecutor(threadpoolexecutor, new Void[] {
            null
        });
    }

    protected transient Object doInBackground(Object aobj[])
    {
        aobj = null;
        a;
        JVM INSTR tableswitch 0 5: default 44
    //                   0 46
    //                   1 60
    //                   2 153
    //                   3 243
    //                   4 300
    //                   5 275;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return null;
_L2:
        return a(e, null, 0, f);
_L3:
        aobj = i.l;
        if (i.n())
        {
            Bitmap bitmap = ((b) (aobj)).a(h, i.b);
            o = ((b) (aobj)).c;
            q = new RectF(((b) (aobj)).d);
            return bitmap;
        } else
        {
            Bitmap bitmap1 = ((b) (aobj)).a(h);
            o = ((b) (aobj)).c;
            q = new RectF(((b) (aobj)).d);
            return bitmap1;
        }
_L4:
        aobj = i;
        if (((SelectionDrawController) (aobj)).l.a())
        {
            b b1 = ((SelectionDrawController) (aobj)).l;
            if (b1.a != null && b1.a.size() > 0 && ((com.socialin.android.photo.freecrop.c)b1.a.remove(b1.a.size() - 1)).d == 3)
            {
                boolean flag;
                if (!b1.b)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                b1.b = flag;
            }
            return ((SelectionDrawController) (aobj)).p();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (k)
        {
            aobj = g.a(j);
            p = g.c;
            return ((Object) (aobj));
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (m != null && n)
        {
            m.run();
            return null;
        }
        if (true) goto _L1; else goto _L6
_L6:
        ArrayList arraylist = new ArrayList(2);
        b b2 = i.l;
        if (k)
        {
            Bitmap bitmap2 = b2.a(h);
            o = b2.c;
            q = new RectF(b2.d);
            arraylist.add(bitmap2);
            if (bitmap2 != null)
            {
                aobj = b2.a(j);
                p = b2.c;
            }
            arraylist.add(((Object) (aobj)));
        } else
        {
            aobj = b2.a(h, i.b);
            o = b2.c;
            q = new RectF(b2.d);
            arraylist.add(((Object) (aobj)));
            arraylist.add(null);
        }
        return arraylist;
    }

    protected void onPostExecute(Object obj)
    {
        a;
        JVM INSTR tableswitch 0 5: default 44
    //                   0 45
    //                   1 66
    //                   2 96
    //                   3 119
    //                   4 145
    //                   5 195;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return;
_L2:
        if (b != null)
        {
            b.a((Bitmap)obj);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (b != null)
        {
            b.a((Bitmap)obj, o, q);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (b != null)
        {
            obj = (com.socialin.android.photo.freecrop.d)obj;
            b.a(((com.socialin.android.photo.freecrop.d) (obj)));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (b != null)
        {
            b.a((Bitmap)obj, p);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (b != null)
        {
            obj = (ArrayList)obj;
            b.a((Bitmap)((ArrayList) (obj)).get(0), o, (Bitmap)((ArrayList) (obj)).get(1), p, q);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (m != null && !n)
        {
            m.run();
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

}
