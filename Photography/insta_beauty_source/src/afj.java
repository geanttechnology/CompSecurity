// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.fotoable.beautyui.other.TProEditCropScrollView;
import com.fotoable.fotoproedit.activity.ProEditCropActivity;
import com.fotoable.fotoproedit.view.ui.scroll.TProEditRotateBottomBar;

public class afj
    implements Runnable
{

    final Animation a;
    final ProEditCropActivity b;

    public afj(ProEditCropActivity proeditcropactivity, Animation animation)
    {
        b = proeditcropactivity;
        a = animation;
        super();
    }

    public void run()
    {
        b.b.setVisibility(4);
        ProEditCropActivity.i(b).setVisibility(4);
        ProEditCropActivity.j(b).setVisibility(0);
        b.e.startAnimation(a);
    }
}
