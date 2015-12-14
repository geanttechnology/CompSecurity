// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.newui.MNewBeautyMainFragment;

public class tl
    implements android.view.View.OnTouchListener
{

    final MNewBeautyMainFragment a;

    public tl(MNewBeautyMainFragment mnewbeautymainfragment)
    {
        a = mnewbeautymainfragment;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 56
    //                   1 32
    //                   2 54;
           goto _L1 _L2 _L1 _L3
_L1:
        (new Handler()).postDelayed(new tm(this), 300L);
_L3:
        return true;
_L2:
        view = uv.c().j();
        if (view != null)
        {
            MNewBeautyMainFragment.e(a).setImageBitmap(view);
        }
        if (true) goto _L3; else goto _L4
_L4:
    }
}
