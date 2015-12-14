// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import com.socialin.android.brushlib.input.gesture.j;

// Referenced classes of package com.picsart.collages:
//            CollageCreatorView

final class a
    implements j
{

    private CollageCreatorView a;

    public final void a_(float f, float f1)
    {
        if (!CollageCreatorView.i(a))
        {
            CollageCreatorView.b(a, f, f1);
        }
    }

    e.j(CollageCreatorView collagecreatorview)
    {
        a = collagecreatorview;
        super();
    }
}
