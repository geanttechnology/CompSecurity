// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.instamag.activity.compose.MagComposeLinkFragement;

public class bbf
    implements android.view.View.OnTouchListener
{

    final MagComposeLinkFragement a;

    public bbf(MagComposeLinkFragement magcomposelinkfragement)
    {
        a = magcomposelinkfragement;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        MagComposeLinkFragement.b(a).setVisibility(4);
        return true;
    }
}
