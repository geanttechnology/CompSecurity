// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package android.support.design.widget:
//            FloatingActionButtonEclairMr1

class Adapter extends Adapter
{

    final FloatingActionButtonEclairMr1 this$0;

    public void onAnimationEnd(Animation animation)
    {
        FloatingActionButtonEclairMr1.access$202(FloatingActionButtonEclairMr1.this, false);
        mView.setVisibility(8);
    }

    public void onAnimationStart(Animation animation)
    {
        FloatingActionButtonEclairMr1.access$202(FloatingActionButtonEclairMr1.this, true);
    }

    Adapter()
    {
        this$0 = FloatingActionButtonEclairMr1.this;
        super();
    }
}
