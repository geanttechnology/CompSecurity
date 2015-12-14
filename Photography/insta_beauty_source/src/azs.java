// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import com.instamag.activity.commonview.TStyleCollectionView;
import com.instamag.activity.compose.MagComposeActivity;

public class azs
    implements android.view.View.OnTouchListener
{

    final MagComposeActivity a;

    public azs(MagComposeActivity magcomposeactivity)
    {
        a = magcomposeactivity;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (a.a.getVisibility() == 0)
        {
            MagComposeActivity.a(a);
        }
        return false;
    }
}
