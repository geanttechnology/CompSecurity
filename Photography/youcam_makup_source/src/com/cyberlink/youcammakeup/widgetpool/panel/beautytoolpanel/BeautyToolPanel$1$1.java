// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.animation.Animator;
import android.view.View;
import com.cyberlink.youcammakeup.utility.ch;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a extends ch
{

    final Long a;
    final a b;

    public void onAnimationEnd(Animator animator)
    {
        b.b.c(a);
    }

    ( , Long long1)
    {
        b = ;
        a = long1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanel$1

/* anonymous class */
    class BeautyToolPanel._cls1
        implements android.view.View.OnClickListener
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
                a.a(false, new BeautyToolPanel._cls1._cls1(this, view));
                return;
            }
        }

            
            {
                a = beautytoolpanel;
                super();
            }
    }

}
