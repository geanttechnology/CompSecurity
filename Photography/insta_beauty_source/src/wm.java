// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.fotoable.beautyui.ImageDetailView;
import com.fotoable.beautyui.NewOneBeautyToolBar;
import com.fotoable.beautyui.NewSecBeautyToolBar;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.SlimFaceLineView;
import com.fotoable.beautyui.newui.MSlimBodyFragment;
import com.instabeauty.application.InstaBeautyApplication;

public class wm
    implements android.view.View.OnTouchListener
{

    final MSlimBodyFragment a;

    public wm(MSlimBodyFragment mslimbodyfragment)
    {
        a = mslimbodyfragment;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        new Rect(0, 0, MSlimBodyFragment.v(a).getWidth(), MSlimBodyFragment.v(a).getHeight());
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 64
    //                   0 138
    //                   1 1555
    //                   2 859
    //                   3 2295;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        MSlimBodyFragment.a(a).setViewTouchEvent(motionevent);
        MSlimBodyFragment.x(a).setViewTouchEvent(motionevent);
_L7:
        Log.e(MSlimBodyFragment.a(), (new StringBuilder()).append("imageview zoomscale:").append(MSlimBodyFragment.a(a).getCurImageScale()).append("PenSize:").append(MSlimBodyFragment.I(a)).toString());
        return true;
_L2:
        MSlimBodyFragment.a(a, com.fotoable.beautyui.NewTouchImageView.TouchState.DRAG);
        MSlimBodyFragment.w(a).set((int)motionevent.getX(), (int)motionevent.getY());
        MSlimBodyFragment.a(a).setViewTouchEvent(motionevent);
        MSlimBodyFragment.x(a).setViewTouchEvent(motionevent);
        if (motionevent.getPointerCount() >= 2)
        {
            MSlimBodyFragment.a(a, com.fotoable.beautyui.NewTouchImageView.TouchState.ZOOM);
            MSlimBodyFragment.y(a).setVisibility(8);
            MSlimBodyFragment.c(a).setVisibility(8);
        } else
        {
            MSlimBodyFragment.c(a).setVisibility(8);
            if (MSlimBodyFragment.z(a))
            {
                MSlimBodyFragment.a(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.w(a)));
                float f = (float)MSlimBodyFragment.a(a).getDisplaySize().b() / (float)MSlimBodyFragment.f(a).getHeight();
                MSlimBodyFragment.y(a).setFirPt(MSlimBodyFragment.w(a));
                MSlimBodyFragment.y(a).setVisibility(0);
                MSlimBodyFragment.y(a).setLineType(com.fotoable.beautyui.SlimFaceLineView.LineType.QUBAN);
                MSlimBodyFragment.c(a).updateDetailViewPos(f, (int)MSlimBodyFragment.A(a).b(), (int)MSlimBodyFragment.A(a).c());
            } else
            if (MSlimBodyFragment.B(a))
            {
                MSlimBodyFragment.a(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.w(a)));
                MSlimBodyFragment.y(a).setVisibility(0);
                MSlimBodyFragment.y(a).setLineType(com.fotoable.beautyui.SlimFaceLineView.LineType.SLIMFACE);
                MSlimBodyFragment.y(a).setFirPt(MSlimBodyFragment.w(a));
                MSlimBodyFragment.C(a).b();
                MSlimBodyFragment.C(a).a(MSlimBodyFragment.A(a));
                float f1 = (float)MSlimBodyFragment.a(a).getDisplaySize().b() / (float)MSlimBodyFragment.f(a).getHeight();
                MSlimBodyFragment.c(a).updateDetailViewPos(f1, (int)MSlimBodyFragment.A(a).b(), (int)MSlimBodyFragment.A(a).c());
            } else
            if (MSlimBodyFragment.D(a))
            {
                MSlimBodyFragment.a(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.w(a)));
                float f2 = (float)MSlimBodyFragment.a(a).getDisplaySize().b() / (float)MSlimBodyFragment.f(a).getHeight();
                MSlimBodyFragment.c(a).updateDetailViewPos(f2, (int)MSlimBodyFragment.A(a).b(), (int)MSlimBodyFragment.A(a).c());
                MSlimBodyFragment.y(a).setFirPt(MSlimBodyFragment.w(a));
                MSlimBodyFragment.y(a).setVisibility(0);
                MSlimBodyFragment.y(a).setLineType(com.fotoable.beautyui.SlimFaceLineView.LineType.QUBAN);
            } else
            if (MSlimBodyFragment.E(a))
            {
                MSlimBodyFragment.a(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.w(a)));
                MSlimBodyFragment.y(a).setVisibility(0);
                MSlimBodyFragment.y(a).setLineType(com.fotoable.beautyui.SlimFaceLineView.LineType.EYEBAG);
                MSlimBodyFragment.y(a).setFirPt(MSlimBodyFragment.w(a));
                MSlimBodyFragment.C(a).b();
                MSlimBodyFragment.C(a).a(MSlimBodyFragment.A(a));
                float f3 = (float)MSlimBodyFragment.a(a).getDisplaySize().b() / (float)MSlimBodyFragment.f(a).getHeight();
                MSlimBodyFragment.c(a).updateDetailViewPos(f3, (int)MSlimBodyFragment.A(a).b(), (int)MSlimBodyFragment.A(a).c());
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        MSlimBodyFragment.F(a).set((int)motionevent.getX(), (int)motionevent.getY());
        if (motionevent.getPointerCount() >= 2)
        {
            MSlimBodyFragment.a(a, com.fotoable.beautyui.NewTouchImageView.TouchState.ZOOM);
            MSlimBodyFragment.a(a).setViewTouchEvent(motionevent);
            MSlimBodyFragment.x(a).setViewTouchEvent(motionevent);
            MSlimBodyFragment.y(a).setVisibility(8);
            MSlimBodyFragment.c(a).setVisibility(8);
        } else
        if (MSlimBodyFragment.G(a) == com.fotoable.beautyui.NewTouchImageView.TouchState.DRAG)
        {
            if (MSlimBodyFragment.z(a))
            {
                MSlimBodyFragment.b(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.F(a)));
                MSlimBodyFragment.y(a).setSecPt(MSlimBodyFragment.F(a));
                MSlimBodyFragment.c(a).setVisibility(0);
                float f4 = (float)MSlimBodyFragment.a(a).getDisplaySize().b() / (float)MSlimBodyFragment.f(a).getHeight();
                MSlimBodyFragment.c(a).updateDetailViewPos(f4, (int)MSlimBodyFragment.H(a).b(), (int)MSlimBodyFragment.H(a).c());
            } else
            if (MSlimBodyFragment.B(a))
            {
                MSlimBodyFragment.b(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.F(a)));
                MSlimBodyFragment.y(a).setSecPt(MSlimBodyFragment.F(a));
                MSlimBodyFragment.c(a).setVisibility(0);
                float f5 = (float)MSlimBodyFragment.a(a).getDisplaySize().b() / (float)MSlimBodyFragment.f(a).getHeight();
                MSlimBodyFragment.c(a).updateDetailViewPos(f5, (int)MSlimBodyFragment.H(a).b(), (int)MSlimBodyFragment.H(a).c());
            } else
            if (MSlimBodyFragment.D(a))
            {
                MSlimBodyFragment.b(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.F(a)));
                MSlimBodyFragment.y(a).setSecPt(MSlimBodyFragment.F(a));
                MSlimBodyFragment.c(a).setVisibility(0);
                float f6 = (float)MSlimBodyFragment.a(a).getDisplaySize().b() / (float)MSlimBodyFragment.f(a).getHeight();
                MSlimBodyFragment.c(a).updateDetailViewPos(f6, (int)MSlimBodyFragment.H(a).b(), (int)MSlimBodyFragment.H(a).c());
            } else
            if (MSlimBodyFragment.E(a))
            {
                MSlimBodyFragment.b(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.F(a)));
                MSlimBodyFragment.y(a).setSecPt(MSlimBodyFragment.F(a));
                MSlimBodyFragment.C(a).a(MSlimBodyFragment.H(a));
                MSlimBodyFragment.c(a).setVisibility(0);
                float f7 = (float)MSlimBodyFragment.a(a).getDisplaySize().b() / (float)MSlimBodyFragment.f(a).getHeight();
                MSlimBodyFragment.c(a).updateDetailViewPos(f7, (int)MSlimBodyFragment.H(a).b(), (int)MSlimBodyFragment.H(a).c());
            } else
            {
                MSlimBodyFragment.a(a).setViewTouchEvent(motionevent);
                MSlimBodyFragment.x(a).setViewTouchEvent(motionevent);
            }
        } else
        {
            MSlimBodyFragment.a(a).setViewTouchEvent(motionevent);
            MSlimBodyFragment.x(a).setViewTouchEvent(motionevent);
            MSlimBodyFragment.y(a).setVisibility(8);
            MSlimBodyFragment.c(a).setVisibility(8);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        MSlimBodyFragment.F(a).set((int)motionevent.getX(), (int)motionevent.getY());
        if (MSlimBodyFragment.G(a) == com.fotoable.beautyui.NewTouchImageView.TouchState.DRAG)
        {
            if (MSlimBodyFragment.z(a))
            {
                MSlimBodyFragment.b(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.F(a)));
                MSlimBodyFragment.i(a).updateUiUndo(true);
                view = new adm();
                view.a(MSlimBodyFragment.H(a).b());
                view.b(MSlimBodyFragment.H(a).c());
                view.c(((float)yp.a(InstaBeautyApplication.a, 20F) * 0.5F * MSlimBodyFragment.I(a)) / MSlimBodyFragment.a(a).getCurImageScale());
                MSlimBodyFragment.h(a).a(view);
                MSlimBodyFragment.g(a);
            } else
            if (MSlimBodyFragment.B(a))
            {
                MSlimBodyFragment.b(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.F(a)));
                MSlimBodyFragment.y(a).setSecPt(MSlimBodyFragment.F(a));
                view = new add();
                view.a((int)MSlimBodyFragment.A(a).b());
                view.b((int)MSlimBodyFragment.A(a).c());
                view.c((int)MSlimBodyFragment.H(a).b());
                view.d((int)MSlimBodyFragment.H(a).c());
                view.a(MSlimBodyFragment.I(a) * 1.2F);
                view.b(1.0F / MSlimBodyFragment.a(a).getCurImageScale());
                MSlimBodyFragment.j(a).a(view);
                MSlimBodyFragment.b(a, true);
                MSlimBodyFragment.g(a);
                MSlimBodyFragment.k(a).updateUiUndo(true);
            } else
            if (MSlimBodyFragment.D(a))
            {
                MSlimBodyFragment.b(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.F(a)));
                MSlimBodyFragment.k(a).updateUiUndo(true);
                view = new adc();
                view.a(MSlimBodyFragment.I(a));
                view.a((int)MSlimBodyFragment.H(a).b());
                view.b((int)MSlimBodyFragment.H(a).c());
                view.a(MSlimBodyFragment.I(a));
                view.b(1.0F / MSlimBodyFragment.a(a).getCurImageScale());
                MSlimBodyFragment.l(a).a(view);
                MSlimBodyFragment.g(a);
            } else
            if (MSlimBodyFragment.E(a))
            {
                MSlimBodyFragment.b(a, MSlimBodyFragment.a(a).getImagePt(MSlimBodyFragment.F(a)));
                MSlimBodyFragment.y(a).setSecPt(MSlimBodyFragment.F(a));
                MSlimBodyFragment.C(a).a(MSlimBodyFragment.H(a));
                MSlimBodyFragment.k(a).updateUiUndo(true);
                view = new adl();
                view.a(MSlimBodyFragment.C(a));
                view.a((int)(((float)yp.a(InstaBeautyApplication.a, 30F) * 0.5F * MSlimBodyFragment.I(a)) / MSlimBodyFragment.a(a).getCurImageScale()));
                MSlimBodyFragment.m(a).a(view);
                MSlimBodyFragment.g(a);
            } else
            {
                MSlimBodyFragment.a(a).setViewTouchEvent(motionevent);
                MSlimBodyFragment.x(a).setViewTouchEvent(motionevent);
            }
        } else
        {
            MSlimBodyFragment.a(a).setViewTouchEvent(motionevent);
            MSlimBodyFragment.x(a).setViewTouchEvent(motionevent);
        }
        MSlimBodyFragment.y(a).setVisibility(8);
        MSlimBodyFragment.c(a).setVisibility(8);
        continue; /* Loop/switch isn't completed */
_L5:
        MSlimBodyFragment.a(a).setViewTouchEvent(motionevent);
        MSlimBodyFragment.x(a).setViewTouchEvent(motionevent);
        MSlimBodyFragment.y(a).setVisibility(8);
        MSlimBodyFragment.c(a).setVisibility(8);
        if (true) goto _L7; else goto _L6
_L6:
    }
}
