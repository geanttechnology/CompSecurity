// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.newui.MSlimBodyFragment;

public class wu
    implements android.view.View.OnTouchListener
{

    final MSlimBodyFragment a;

    public wu(MSlimBodyFragment mslimbodyfragment)
    {
        a = mslimbodyfragment;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 51
    //                   1 32
    //                   2 49;
           goto _L1 _L2 _L1 _L3
_L1:
        MSlimBodyFragment.a(a).setImageBitmap(MSlimBodyFragment.f(a));
_L3:
        return true;
_L2:
        if (MSlimBodyFragment.d(a) != null && MSlimBodyFragment.d(a).a() != null)
        {
            MSlimBodyFragment.a(a).setImageBitmap(MSlimBodyFragment.d(a).a());
            FlurryAgent.logEvent((new StringBuilder()).append("CompareClicked").append(MSlimBodyFragment.e(a).toString()).toString());
        }
        if (true) goto _L3; else goto _L4
_L4:
    }
}
