// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.util.w;

// Referenced classes of package com.picsart.studio.editor.view:
//            EditorView

final class a
    implements android.view.istener
{

    private EditorView a;

    public final void onClick(View view)
    {
        try
        {
            a.f = w.f(a.e, 1024);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view = new b();
        }
        view.b = a.getResources().getString(0x7f08094e);
        view.h = false;
        view.a().show(((Activity)a.getContext()).getFragmentManager(), null);
        a.f = a.e;
        System.gc();
    }

    (EditorView editorview)
    {
        a = editorview;
        super();
    }
}
