// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.smule.android.c.aa;
import com.smule.pianoandroid.utils.SwipeView;
import com.smule.pianoandroid.utils.y;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            h, DailyChallengeActivity

class a
    implements y
{

    final List a;
    final h b;

    public void a(SwipeView swipeview, Integer integer, Integer integer1)
    {
        aa.a(DailyChallengeActivity.b(), (new StringBuilder()).append("swipeTo ").append(integer).append(" ").append(integer1).toString());
        if (integer.equals(integer1))
        {
            if (DailyChallengeActivity.d(b.a).findViewById(0x7f0a0129).getVisibility() != 4);
            return;
        } else
        {
            DailyChallengeActivity.a(b.a, a, integer.intValue());
            return;
        }
    }

    public void b(SwipeView swipeview, Integer integer, Integer integer1)
    {
        AnimationUtils.loadAnimation(b.a.getApplicationContext(), 0x7f040011).setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final h._cls2 a;

            public void onAnimationEnd(Animation animation)
            {
                DailyChallengeActivity.d(a.b.a).findViewById(0x7f0a0129).setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                a = h._cls2.this;
                super();
            }
        });
    }

    _cls1.a(h h1, List list)
    {
        b = h1;
        a = list;
        super();
    }
}
