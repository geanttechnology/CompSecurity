// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.Animator;
import android.view.View;
import com.socialin.android.util.ag;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a extends ag
{

    private q a;

    public final void onAnimationEnd(Animator animator)
    {
        super.onAnimationEnd(animator);
        q.z(a).setVisibility(8);
    }

    (q q1)
    {
        a = q1;
        super();
    }
}
