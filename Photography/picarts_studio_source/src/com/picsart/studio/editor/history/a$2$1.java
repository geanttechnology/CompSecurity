// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.history;

import android.os.Handler;
import com.picsart.studio.editor.e;

// Referenced classes of package com.picsart.studio.editor.history:
//            a, EditorAction

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        com.picsart.studio.editor.history.a.a(a.a);
    }

    Action(Action action)
    {
        a = action;
        super();
    }

    // Unreferenced inner class com/picsart/studio/editor/history/a$2

/* anonymous class */
    public final class a._cls2
        implements Runnable
    {

        final a a;
        private e b;
        private EditorAction c;

        public final void run()
        {
            b.a(c.apply(b.b));
            a.d.post(new a._cls2._cls1(this));
        }

            public 
            {
                a = a1;
                b = e1;
                c = editoraction;
                super();
            }
    }

}
