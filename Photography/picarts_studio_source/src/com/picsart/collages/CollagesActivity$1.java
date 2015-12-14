// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.Button;

// Referenced classes of package com.picsart.collages:
//            CollagesActivity

final class a
    implements Runnable
{

    final Button a;
    final CollagesActivity b;

    public final void run()
    {
        if (a != null)
        {
            a.setVisibility(0);
            a.startAnimation(AnimationUtils.loadAnimation(b, 0x7f04000b));
            b.a.postDelayed(new Runnable() {

                private CollagesActivity._cls1 a;

                public final void run()
                {
                    a.a.startAnimation(AnimationUtils.loadAnimation(a.b, 0x7f04000a));
                    a.a.setVisibility(8);
                }

            
            {
                a = CollagesActivity._cls1.this;
                super();
            }
            }, 7000L);
        }
    }

    _cls1.a(CollagesActivity collagesactivity, Button button)
    {
        b = collagesactivity;
        a = button;
        super();
    }
}
