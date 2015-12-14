// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.animation.Animation;
import com.fotoable.beautyui.other.ArcMenu;

public class xg
    implements android.view.animation.Animation.AnimationListener
{

    final View a;
    final ArcMenu b;

    public xg(ArcMenu arcmenu, View view)
    {
        b = arcmenu;
        a = view;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        if (ArcMenu.access$000(b) == com.fotoable.beautyui.other.ArcMenu.Status.CLOSE)
        {
            a.setVisibility(8);
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
