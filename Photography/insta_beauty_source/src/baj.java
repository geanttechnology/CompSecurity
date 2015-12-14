// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.instamag.activity.compose.MagComposeFragement;

public class baj
    implements android.view.View.OnTouchListener
{

    final MagComposeFragement a;

    public baj(MagComposeFragement magcomposefragement)
    {
        a = magcomposefragement;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        MagComposeFragement.access$500(a).setVisibility(4);
        return true;
    }
}
