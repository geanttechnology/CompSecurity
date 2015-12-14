// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.socialin.android.util.af;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            s

final class a
    implements android.view.OnClickListener
{

    final RecyclerView a;
    private s b;

    public final void onClick(View view)
    {
        af af = new af() {

            private s._cls11 a;

            public final void onAnimationEnd(Animation animation2)
            {
                if (a.a.isShown())
                {
                    a.a.setVisibility(8);
                    return;
                } else
                {
                    a.a.setVisibility(0);
                    return;
                }
            }

            
            {
                a = s._cls11.this;
                super();
            }
        };
        Animation animation;
        Animation animation1;
        if (a.isShown())
        {
            animation1 = AnimationUtils.loadAnimation(b.getActivity(), 0x7f04002d);
            animation = AnimationUtils.loadAnimation(b.getActivity(), 0x7f04003e);
        } else
        {
            animation1 = AnimationUtils.loadAnimation(b.getActivity(), 0x7f04002e);
            animation = AnimationUtils.loadAnimation(b.getActivity(), 0x7f04003f);
        }
        animation1.setAnimationListener(af);
        a.startAnimation(animation1);
        view.startAnimation(animation);
    }

    _cls1.a(s s1, RecyclerView recyclerview)
    {
        b = s1;
        a = recyclerview;
        super();
    }
}
