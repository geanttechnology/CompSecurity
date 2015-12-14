// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.fotoable.beautyui.ImageDetailView;
import com.fotoable.beautyui.newui.MNewFindFaceFragment;

public class tw
    implements android.view.View.OnTouchListener
{

    final MNewFindFaceFragment a;

    public tw(MNewFindFaceFragment mnewfindfacefragment)
    {
        a = mnewfindfacefragment;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        float f;
        PointF pointf;
        int i;
        int j;
        i = (int)motionevent.getRawX();
        j = (int)motionevent.getRawY();
        f = MNewFindFaceFragment.h(a).width() / (float)MNewFindFaceFragment.i(a).getWidth();
        pointf = a.a(MNewFindFaceFragment.d(a));
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 2: default 88
    //                   0 124
    //                   1 88
    //                   2 199;
           goto _L1 _L2 _L1 _L3
_L1:
        MNewFindFaceFragment.j(a).setVisibility(8);
_L5:
        MNewFindFaceFragment.a(a, a.a(MNewFindFaceFragment.d(a)));
        return true;
_L2:
        view = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
        MNewFindFaceFragment.a(a, i - ((android.widget.FrameLayout.LayoutParams) (view)).leftMargin);
        MNewFindFaceFragment.b(a, j - ((android.widget.FrameLayout.LayoutParams) (view)).topMargin);
        MNewFindFaceFragment.j(a).setVisibility(0);
        MNewFindFaceFragment.j(a).updateDetailViewPos(f, (int)pointf.x, (int)pointf.y);
        continue; /* Loop/switch isn't completed */
_L3:
        motionevent = (android.widget.FrameLayout.LayoutParams)view.getLayoutParams();
        motionevent.leftMargin = i - MNewFindFaceFragment.k(a);
        motionevent.topMargin = j - MNewFindFaceFragment.l(a);
        motionevent.gravity = 51;
        view.setLayoutParams(motionevent);
        MNewFindFaceFragment.j(a).updateDetailViewPos(f, (int)pointf.x, (int)pointf.y);
        if (true) goto _L5; else goto _L4
_L4:
    }
}
