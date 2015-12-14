// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.view.View;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a
    implements android.view.er
{

    final BeautyToolPanel a;

    public void onClick(View view)
    {
        if (a.m)
        {
            return;
        } else
        {
            view = (Long)view.getTag();
            a.a(false, new ch(view) {

                final Long a;
                final BeautyToolPanel._cls1 b;

                public void onAnimationEnd(Animator animator)
                {
                    b.a.c(a);
                }

            
            {
                b = BeautyToolPanel._cls1.this;
                a = long1;
                super();
            }
            });
            return;
        }
    }

    _cls1.a(BeautyToolPanel beautytoolpanel)
    {
        a = beautytoolpanel;
        super();
    }
}
