// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.os.Handler;
import com.picsart.studio.editor.e;
import java.util.List;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.picsart.studio.editor.history:
//            a, EditorAction

public final class b
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
        a.d.post(new Runnable() {

            private a._cls3 a;

            public final void run()
            {
                com.picsart.studio.editor.history.a.a(a.a);
            }

            
            {
                a = a._cls3.this;
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
        com.picsart.studio.editor.history.a.a(a, b, i, a.b - 1);
          goto _L5
        obj;
        a.f.release();
        throw obj;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        b.a(b.a.a());
        com.picsart.studio.editor.history.a.a(a, b, 0, a.b - 1);
        i--;
          goto _L7
    }

    public _cls1.a(a a1, e e1)
    {
        a = a1;
        b = e1;
        super();
    }
}
