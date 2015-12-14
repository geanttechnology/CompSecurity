// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import com.picsart.studio.editor.e;

// Referenced classes of package com.picsart.studio.editor.activity:
//            EditorActivity

final class a
    implements Runnable
{

    private EditorActivity a;

    public final void run()
    {
        if (!EditorActivity.c(a) && a == EditorActivity.g())
        {
            e.a().d();
        }
    }

    (EditorActivity editoractivity)
    {
        a = editoractivity;
        super();
    }
}
