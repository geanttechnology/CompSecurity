// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.fotoable.beautyui.newui.MNewSofterFragment;

public class vd
    implements android.view.View.OnTouchListener
{

    final MNewSofterFragment a;

    public vd(MNewSofterFragment mnewsofterfragment)
    {
        a = mnewsofterfragment;
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
        MNewSofterFragment.a(a).setImageBitmap(MNewSofterFragment.d(a));
_L3:
        return true;
_L2:
        if (MNewSofterFragment.c(a) != null && MNewSofterFragment.c(a).a() != null)
        {
            MNewSofterFragment.a(a).setImageBitmap(MNewSofterFragment.c(a).a());
        }
        if (true) goto _L3; else goto _L4
_L4:
    }
}
