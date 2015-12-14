// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import android.content.Intent;

// Referenced classes of package com.picsart.studio.editor.activity:
//            EditorActivity

final class a
    implements Runnable
{

    private EditorActivity a;

    public final void run()
    {
        EditorActivity.b(a);
        a.e();
        if ("action.photo.for.collage".equals(a.getIntent().getAction()))
        {
            a.a(null, 0);
        }
    }

    _cls9(EditorActivity editoractivity)
    {
        a = editoractivity;
        super();
    }
}
