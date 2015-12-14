// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.keyboardsurfer.android.widget.crouton;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;

// Referenced classes of package de.keyboardsurfer.android.widget.crouton:
//            Manager, Crouton, Configuration

class val.crouton
    implements android.view.server.OnGlobalLayoutListener
{

    final Manager this$0;
    final Crouton val$crouton;
    final View val$croutonView;

    public void onGlobalLayout()
    {
        if (android.os.ION.SDK_INT < 16)
        {
            val$croutonView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else
        {
            val$croutonView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        val$croutonView.startAnimation(val$crouton.getInAnimation());
        Manager.announceForAccessibilityCompat(val$crouton.getActivity(), val$crouton.getText());
        if (-1 != val$crouton.getConfiguration().durationInMilliseconds)
        {
            Manager.access$000(Manager.this, val$crouton, 0xc2007de1, (long)val$crouton.getConfiguration().durationInMilliseconds + val$crouton.getInAnimation().getDuration());
        }
    }

    ion()
    {
        this$0 = final_manager;
        val$croutonView = view;
        val$crouton = Crouton.this;
        super();
    }
}
