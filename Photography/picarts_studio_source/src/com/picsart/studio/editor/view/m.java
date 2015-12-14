// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import com.socialin.android.brushlib.input.gesture.j;

// Referenced classes of package com.picsart.studio.editor.view:
//            PerspectiveView

final class m
    implements j
{

    private PerspectiveView a;

    private m(PerspectiveView perspectiveview)
    {
        a = perspectiveview;
        super();
    }

    m(PerspectiveView perspectiveview, byte byte0)
    {
        this(perspectiveview);
    }

    public final void a_(float f, float f1)
    {
        PerspectiveView perspectiveview = a;
        boolean flag;
        if (!PerspectiveView.g(a))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        PerspectiveView.b(perspectiveview, flag);
        a.invalidate();
    }
}
