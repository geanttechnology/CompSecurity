// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.RectF;
import android.view.View;
import com.picsart.studio.editor.view.CropEditorView;
import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            f

final class a
    implements android.view.TreeObserver.OnGlobalLayoutListener
{

    private View a;
    private f b;

    public final void onGlobalLayout()
    {
        if (f.e(b) != null)
        {
            Utils.a(a, this);
            f.e(b).setScreenRectF(new RectF(a.getTop(), a.getLeft(), a.getRight(), a.getBottom()));
        }
    }

    orView(f f1, View view)
    {
        b = f1;
        a = view;
        super();
    }
}
