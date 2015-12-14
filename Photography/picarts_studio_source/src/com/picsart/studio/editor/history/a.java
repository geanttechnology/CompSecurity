// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.h;
import com.socialin.android.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.history:
//            EditorAction, RasterAction, CropAction, EnhanceAction, 
//            ResizeAction, TransformAction, CurveAction, ResetAction, 
//            PerspectiveAction

public final class a
{

    List a;
    volatile int b;
    public final ExecutorService c = Executors.newSingleThreadExecutor();
    Handler d;
    public Set e;
    Semaphore f;

    public a()
    {
        d = new Handler(Looper.getMainLooper());
        f = new Semaphore(1);
        a = new ArrayList();
        b = -1;
        e = new HashSet();
    }

    static void a(a a1)
    {
        for (a1 = a1.e.iterator(); a1.hasNext(); ((h)a1.next()).a()) { }
    }

    static void a(a a1, e e1, int i, int j)
    {
        for (; i <= j; i++)
        {
            e1.a(((EditorAction)a1.a.get(i)).apply(e1.b));
        }

    }

    public final void a(e e1, EditorAction editoraction)
    {
        f.acquire();
        if (b != a.size() - 1)
        {
            a = a.subList(0, b + 1);
        }
        a.add(editoraction);
        b = b + 1;
        editoraction = e1.d;
        e1 = new ArrayList();
        Iterator iterator = (new ArrayList(a)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            EditorAction editoraction1 = (EditorAction)iterator.next();
            if (editoraction1 instanceof RasterAction)
            {
                e1.add(((RasterAction)editoraction1).getUsingFilePath());
            }
        } while (true);
          goto _L1
_L3:
        int i;
        try
        {
            d.post(new Runnable() {

                private a a;

                public final void run()
                {
                    a.a(a);
                }

            
            {
                a = a.this;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            e1.printStackTrace();
        }
        f.release();
        return;
_L1:
        if ((editoraction = (new File(editoraction.getHistoryDataDirectory())).listFiles()) == null) goto _L3; else goto _L2
_L2:
        if (editoraction.length <= 0) goto _L3; else goto _L4
_L4:
        j = editoraction.length;
        i = 0;
_L6:
        if (i >= j) goto _L3; else goto _L5
_L5:
        file = editoraction[i];
        if (!e1.contains(file.getPath()))
        {
            file.delete();
        }
        break MISSING_BLOCK_LABEL_236;
        i++;
          goto _L6
    }

    public final void a(h h1)
    {
        e.add(h1);
    }

    public final void a(String s)
    {
        JSONObject jsonobject;
        f.acquire();
        jsonobject = new JSONObject();
        JSONArray jsonarray;
        jsonarray = new JSONArray();
        JSONObject jsonobject1;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); jsonarray.put(jsonobject1))
        {
            EditorAction editoraction = (EditorAction)iterator.next();
            jsonobject1 = editoraction.getJSONRepresentation();
            jsonobject1.put("type", editoraction.getClass().getSimpleName());
        }

          goto _L1
        s;
        s.printStackTrace();
_L3:
        f.release();
        return;
_L1:
        jsonobject.put("pointer", b);
        jsonobject.put("actions", jsonarray);
        FileUtils.a(new File(s), jsonobject.toString());
        continue; /* Loop/switch isn't completed */
        s;
        s.printStackTrace();
        f.release();
        return;
        s;
        f.release();
        throw s;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final boolean a()
    {
        return b == -1;
    }

    public final void b(h h1)
    {
        e.remove(h1);
    }

    public final void b(String s)
    {
        f.acquire();
        boolean flag;
        s = FileUtils.d(new File(s));
        flag = TextUtils.isEmpty(s);
        if (flag)
        {
            f.release();
            return;
        }
        int j;
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject.getJSONArray("actions");
        b = jsonobject.getInt("pointer");
        j = s.length();
        int i = 0;
_L23:
        if (i >= j) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject1;
        String s1;
        jsonobject1 = s.getJSONObject(i);
        s1 = jsonobject1.getString("type");
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 8: default 506
    //                   -1763048406: 262
    //                   -1717381882: 214
    //                   -864005581: 246
    //                   -652647451: 294
    //                   -649584028: 230
    //                   364296261: 310
    //                   1533036402: 327
    //                   2102021282: 278;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L13:
        throw new IllegalStateException((new StringBuilder("Unknown type : ")).append(s1).toString());
        s;
        s.printStackTrace();
_L2:
        f.release();
        return;
_L5:
        if (s1.equals("CropAction"))
        {
            byte0 = 0;
        }
          goto _L3
_L8:
        if (s1.equals("EnhanceAction"))
        {
            byte0 = 1;
        }
          goto _L3
_L6:
        if (s1.equals("RasterAction"))
        {
            byte0 = 2;
        }
          goto _L3
_L4:
        if (s1.equals("ResizeAction"))
        {
            byte0 = 3;
        }
          goto _L3
_L11:
        if (s1.equals("TransformAction"))
        {
            byte0 = 4;
        }
          goto _L3
_L7:
        if (s1.equals("CurveAction"))
        {
            byte0 = 5;
        }
          goto _L3
_L9:
        if (s1.equals("ResetAction"))
        {
            byte0 = 6;
        }
          goto _L3
_L10:
        if (s1.equals("PerspectiveAction"))
        {
            byte0 = 7;
        }
          goto _L3
_L14:
        a.add(CropAction.createFromJSON(jsonobject1));
          goto _L12
_L15:
        a.add(EnhanceAction.createFromJSON(jsonobject1));
          goto _L12
        s;
        s.printStackTrace();
        f.release();
        return;
_L16:
        a.add(RasterAction.createFromJSON(jsonobject1));
          goto _L12
        s;
        f.release();
        throw s;
_L17:
        a.add(ResizeAction.createFromJSON(jsonobject1));
          goto _L12
_L18:
        a.add(TransformAction.createFromJSON(jsonobject1));
          goto _L12
_L19:
        a.add(CurveAction.createFromJSON(jsonobject1));
          goto _L12
_L20:
        a.add(new ResetAction());
          goto _L12
_L21:
        a.add(PerspectiveAction.createFromJSON(jsonobject1));
          goto _L12
_L3:
        byte0;
        JVM INSTR tableswitch 0 7: default 556
    //                   0 344
    //                   1 361
    //                   2 391
    //                   3 418
    //                   4 435
    //                   5 452
    //                   6 469
    //                   7 489;
           goto _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L12:
        i++;
        if (true) goto _L23; else goto _L22
_L22:
    }

    public final boolean b()
    {
        boolean flag1 = false;
        f.acquire();
        boolean flag = flag1;
        boolean flag2;
        if (b < 0)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        flag2 = a.get(b) instanceof ResetAction;
        flag = flag1;
        if (!flag2)
        {
            flag = true;
        }
        f.release();
        return flag;
        Object obj;
        obj;
        ((InterruptedException) (obj)).printStackTrace();
        f.release();
        return false;
        obj;
        f.release();
        throw obj;
    }

    public final boolean c()
    {
        boolean flag;
        f.acquire();
        flag = d();
        f.release();
        return flag;
        Object obj;
        obj;
        ((InterruptedException) (obj)).printStackTrace();
        f.release();
        return false;
        obj;
        f.release();
        throw obj;
    }

    final boolean d()
    {
        return b >= 0;
    }

    public final List e()
    {
        if (b >= 0)
        {
            return a.subList(0, b + 1);
        } else
        {
            return Collections.emptyList();
        }
    }

    // Unreferenced inner class com/picsart/studio/editor/history/a$2

/* anonymous class */
    public final class _cls2
        implements Runnable
    {

        final a a;
        private e b;
        private EditorAction c;

        public final void run()
        {
            b.a(c.apply(b.b));
            a.d.post(new Runnable(this) {

                private _cls2 a;

                public final void run()
                {
    public final class _cls2
        implements Runnable
    {
                    a.a(a.a);
                }

            
            {
                a = _pcls2;
                super();
            }
            });
        }

            public 
            {
                a = a.this;
                b = e1;
                c = editoraction;
                super();
            }
    }


    // Unreferenced inner class com/picsart/studio/editor/history/a$3

/* anonymous class */
    public final class _cls3
        implements Runnable
    {

        final a a;
        private e b;

        public final void run()
        {
            a.f.acquire();
            if (!a.d()) goto _L2; else goto _L1
_L1:
            EditorAction editoraction = (EditorAction)a.a.get(a.b);
            if (!editoraction.isReversible()) goto _L4; else goto _L3
_L3:
            b.a(editoraction.reverseApply(b.b));
_L5:
            a a1 = a;
            a1.b = a1.b - 1;
_L2:
            a.d.post(new Runnable(this) {

                private _cls3 a;

                public final void run()
                {
    public final class _cls3
        implements Runnable
    {
                    a.a(a.a);
                }

            
            {
                a = _pcls3;
                super();
            }
            });
            a.f.release();
            return;
_L4:
            if (a.b != 0)
            {
                break MISSING_BLOCK_LABEL_159;
            }
            b.a(b.a.a());
              goto _L5
            Object obj;
            obj;
            ((InterruptedException) (obj)).printStackTrace();
            a.f.release();
            return;
            int i = a.b - 1;
_L7:
            if (i < 0) goto _L5; else goto _L6
_L6:
            if (((EditorAction)a.a.get(i)).isSourceDependent())
            {
                break MISSING_BLOCK_LABEL_232;
            }
            a.a(a, b, i, a.b - 1);
              goto _L5
            obj;
            a.f.release();
            throw obj;
            if (i != 0)
            {
                break MISSING_BLOCK_LABEL_274;
            }
            b.a(b.a.a());
            a.a(a, b, 0, a.b - 1);
            i--;
              goto _L7
        }

            public 
            {
                a = a.this;
                b = e1;
                super();
            }
    }

}
