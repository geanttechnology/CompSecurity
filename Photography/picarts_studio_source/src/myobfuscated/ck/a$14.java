// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ListView;

// Referenced classes of package myobfuscated.ck:
//            a

final class t>
    implements android.view.OnClickListener
{

    private a a;

    public final void onClick(View view)
    {
        view = myobfuscated.ck.a.x(a);
        ImageButton imagebutton = myobfuscated.ck.a.C(a);
        android.app.Activity activity = a.getActivity();
        if (activity == null || view == null || imagebutton == null)
        {
            return;
        }
        if (view.getVisibility() == 8)
        {
            view.setVisibility(0);
            view.startAnimation(AnimationUtils.loadAnimation(activity, 0x7f04002e));
            imagebutton.startAnimation(AnimationUtils.loadAnimation(activity, 0x7f04003f));
            myobfuscated.ck.a.a(a, true);
            return;
        } else
        {
            Animation animation = AnimationUtils.loadAnimation(activity, 0x7f04002d);
            animation.setAnimationListener(myobfuscated.ck.a.D(a));
            view.startAnimation(animation);
            imagebutton.startAnimation(AnimationUtils.loadAnimation(activity, 0x7f04003e));
            myobfuscated.ck.a.a(a, false);
            return;
        }
    }

    n.Animation(a a1)
    {
        a = a1;
        super();
    }
}
