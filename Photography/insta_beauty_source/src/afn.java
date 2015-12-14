// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;
import com.wantu.view.TFilterListScrollView;

public class afn
    implements Runnable
{

    final Animation a;
    final ProEditFilterActivity b;

    public afn(ProEditFilterActivity proeditfilteractivity, Animation animation)
    {
        b = proeditfilteractivity;
        a = animation;
        super();
    }

    public void run()
    {
        b.c.setVisibility(4);
        b.a.setVisibility(4);
        b.b.setVisibility(0);
        ProEditFilterActivity.r(b).startAnimation(a);
    }
}
