// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import android.animation.Animator;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            a, CollageDateHighlightView

class a extends a
{

    final CollageDateHighlightView a;

    public void onAnimationEnd(Animator animator)
    {
        CollageDateHighlightView.a(a, true);
        a.invalidate();
    }

    (CollageDateHighlightView collagedatehighlightview)
    {
        a = collagedatehighlightview;
        super(collagedatehighlightview, null);
    }
}
