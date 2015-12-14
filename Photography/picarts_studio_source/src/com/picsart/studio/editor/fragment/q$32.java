// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.EditorAction;
import com.picsart.studio.editor.item.ImageItem;
import com.picsart.studio.editor.view.ItemEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q, i

final class a
    implements c
{

    private q a;

    public final void a(i i)
    {
        a.getFragmentManager().beginTransaction().remove(i).commit();
    }

    public final void a(i i, Bitmap bitmap, EditorAction editoraction)
    {
        a.getFragmentManager().beginTransaction().remove(i).commit();
        if (q.a(a).h() instanceof ImageItem)
        {
            ((ImageItem)q.a(a).h()).a(bitmap, e.a().d.getTmpDirectory());
        }
    }

    Action(q q1)
    {
        a = q1;
        super();
    }
}
