// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import android.graphics.Bitmap;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.EditorAction;

// Referenced classes of package com.picsart.studio.editor.activity:
//            EditorActivity

final class b
    implements Runnable
{

    private Bitmap a;
    private EditorAction b;

    public final void run()
    {
        e.a().a(a);
        e.a().a(b);
    }

    _cls9(Bitmap bitmap, EditorAction editoraction)
    {
        a = bitmap;
        b = editoraction;
        super();
    }
}
