// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.os.Handler;
import com.picsart.studio.editor.e;

// Referenced classes of package com.picsart.studio.editor.history:
//            a, EditorAction

public final class c
    implements Runnable
{

    final a a;
    private e b;
    private EditorAction c;

    public final void run()
    {
        b.a(c.apply(b.b));
        a.d.post(new Runnable() {

            private a._cls2 a;

            public final void run()
            {
                com.picsart.studio.editor.history.a.a(a.a);
            }

            
            {
                a = a._cls2.this;
                super();
            }
        });
    }

    public orAction(a a1, e e1, EditorAction editoraction)
    {
        a = a1;
        b = e1;
        c = editoraction;
        super();
    }
}
