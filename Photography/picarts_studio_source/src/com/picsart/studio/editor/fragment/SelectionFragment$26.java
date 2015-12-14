// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.animation.Animation;
import android.widget.RelativeLayout;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements android.view.animation.stener
{

    private RelativeLayout a;

    public final void onAnimationEnd(Animation animation)
    {
        a.clearAnimation();
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    (RelativeLayout relativelayout)
    {
        a = relativelayout;
        super();
    }
}
