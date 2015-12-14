// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

// Referenced classes of package com.socialin.android.util:
//            af

public abstract class AnimUtils
{

    public AnimUtils()
    {
    }

    public static void a(Context context, View view, int i, int j)
    {
        context = AnimationUtils.loadAnimation(context, i);
        i = view.getVisibility();
        switch (j)
        {
        default:
            throw new IllegalArgumentException();

        case 0: // '\0'
            if (i != 0)
            {
                view.setVisibility(0);
                view.startAnimation(context);
            }
            return;

        case 4: // '\004'
        case 8: // '\b'
            break;
        }
        if (i == 0 || i == 8)
        {
            view.setVisibility(j);
            return;
        } else
        {
            context.setAnimationListener(new af(view, j) {

                private View a;
                private int b;

                public final void onAnimationEnd(Animation animation)
                {
                    a.setVisibility(b);
                }

            
            {
                a = view;
                b = i;
                super();
            }
            });
            view.startAnimation(context);
            return;
        }
    }
}
