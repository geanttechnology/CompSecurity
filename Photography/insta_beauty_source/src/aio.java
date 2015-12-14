// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.fotoable.beautyui.ImageDetailView;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.SlimFaceLineView;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;
import java.util.ArrayList;

public class aio
    implements android.view.View.OnTouchListener
{

    final ProEditSlimBodyActivity a;

    public aio(ProEditSlimBodyActivity proeditslimbodyactivity)
    {
        a = proeditslimbodyactivity;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        new Rect(0, 0, ProEditSlimBodyActivity.r(a).getWidth(), ProEditSlimBodyActivity.r(a).getHeight());
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 64
    //                   0 137
    //                   1 643
    //                   2 377
    //                   3 961;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        ProEditSlimBodyActivity.c(a).setViewTouchEvent(motionevent);
        ProEditSlimBodyActivity.t(a).setViewTouchEvent(motionevent);
_L7:
        Log.e("ProEditSlimBodyActivity", (new StringBuilder()).append("imageview zoomscale:").append(ProEditSlimBodyActivity.c(a).getCurImageScale()).append("PenSize:").append(ProEditSlimBodyActivity.A(a)).toString());
        return true;
_L2:
        ProEditSlimBodyActivity.a(a, com.fotoable.beautyui.NewTouchImageView.TouchState.DRAG);
        ProEditSlimBodyActivity.s(a).set((int)motionevent.getX(), (int)motionevent.getY());
        ProEditSlimBodyActivity.c(a).setViewTouchEvent(motionevent);
        ProEditSlimBodyActivity.t(a).setViewTouchEvent(motionevent);
        if (motionevent.getPointerCount() >= 2)
        {
            ProEditSlimBodyActivity.a(a, com.fotoable.beautyui.NewTouchImageView.TouchState.ZOOM);
            ProEditSlimBodyActivity.u(a).setVisibility(8);
            ProEditSlimBodyActivity.v(a).setVisibility(8);
        } else
        {
            ProEditSlimBodyActivity.v(a).setVisibility(8);
            ProEditSlimBodyActivity.a(a, ProEditSlimBodyActivity.c(a).getImagePt(ProEditSlimBodyActivity.s(a)));
            ProEditSlimBodyActivity.u(a).setVisibility(0);
            ProEditSlimBodyActivity.u(a).setLineType(com.fotoable.beautyui.SlimFaceLineView.LineType.SLIMFACE);
            ProEditSlimBodyActivity.u(a).setFirPt(ProEditSlimBodyActivity.s(a));
            float f = (float)ProEditSlimBodyActivity.c(a).getDisplaySize().b() / (float)ProEditSlimBodyActivity.b(a).getHeight();
            ProEditSlimBodyActivity.v(a).updateDetailViewPos(f, (int)ProEditSlimBodyActivity.w(a).b(), (int)ProEditSlimBodyActivity.w(a).c());
        }
        continue; /* Loop/switch isn't completed */
_L4:
        ProEditSlimBodyActivity.x(a).set((int)motionevent.getX(), (int)motionevent.getY());
        if (motionevent.getPointerCount() >= 2)
        {
            ProEditSlimBodyActivity.a(a, com.fotoable.beautyui.NewTouchImageView.TouchState.ZOOM);
            ProEditSlimBodyActivity.c(a).setViewTouchEvent(motionevent);
            ProEditSlimBodyActivity.t(a).setViewTouchEvent(motionevent);
            ProEditSlimBodyActivity.u(a).setVisibility(8);
            ProEditSlimBodyActivity.v(a).setVisibility(8);
        } else
        if (ProEditSlimBodyActivity.y(a) == com.fotoable.beautyui.NewTouchImageView.TouchState.DRAG)
        {
            ProEditSlimBodyActivity.b(a, ProEditSlimBodyActivity.c(a).getImagePt(ProEditSlimBodyActivity.x(a)));
            ProEditSlimBodyActivity.u(a).setSecPt(ProEditSlimBodyActivity.x(a));
            ProEditSlimBodyActivity.v(a).setVisibility(0);
            float f1 = (float)ProEditSlimBodyActivity.c(a).getDisplaySize().b() / (float)ProEditSlimBodyActivity.b(a).getHeight();
            ProEditSlimBodyActivity.v(a).updateDetailViewPos(f1, (int)ProEditSlimBodyActivity.z(a).b(), (int)ProEditSlimBodyActivity.z(a).c());
        } else
        {
            ProEditSlimBodyActivity.c(a).setViewTouchEvent(motionevent);
            ProEditSlimBodyActivity.t(a).setViewTouchEvent(motionevent);
            ProEditSlimBodyActivity.u(a).setVisibility(8);
            ProEditSlimBodyActivity.v(a).setVisibility(8);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        ProEditSlimBodyActivity.x(a).set((int)motionevent.getX(), (int)motionevent.getY());
        if (ProEditSlimBodyActivity.y(a) == com.fotoable.beautyui.NewTouchImageView.TouchState.DRAG)
        {
            ProEditSlimBodyActivity.b(a, ProEditSlimBodyActivity.c(a).getImagePt(ProEditSlimBodyActivity.x(a)));
            ProEditSlimBodyActivity.u(a).setSecPt(ProEditSlimBodyActivity.x(a));
            view = new add();
            view.a((int)ProEditSlimBodyActivity.w(a).b());
            view.b((int)ProEditSlimBodyActivity.w(a).c());
            view.c((int)ProEditSlimBodyActivity.z(a).b());
            view.d((int)ProEditSlimBodyActivity.z(a).c());
            view.a(ProEditSlimBodyActivity.A(a) * 1.2F);
            view.b(1.0F / ProEditSlimBodyActivity.c(a).getCurImageScale());
            Log.e("ProEditSlimBodyActivity", (new StringBuilder()).append("slimface size:").append(ProEditSlimBodyActivity.a(a).b()).toString());
            ProEditSlimBodyActivity.a(a).a(view);
            ProEditSlimBodyActivity.k(a).setEnabled(true);
            ProEditSlimBodyActivity.l(a).setEnabled(false);
            a.d.clear();
            ProEditSlimBodyActivity.a(a, true);
            ProEditSlimBodyActivity.j(a);
        } else
        {
            ProEditSlimBodyActivity.c(a).setViewTouchEvent(motionevent);
            ProEditSlimBodyActivity.t(a).setViewTouchEvent(motionevent);
        }
        ProEditSlimBodyActivity.u(a).setVisibility(8);
        ProEditSlimBodyActivity.v(a).setVisibility(8);
        continue; /* Loop/switch isn't completed */
_L5:
        ProEditSlimBodyActivity.c(a).setViewTouchEvent(motionevent);
        ProEditSlimBodyActivity.t(a).setViewTouchEvent(motionevent);
        ProEditSlimBodyActivity.u(a).setVisibility(8);
        ProEditSlimBodyActivity.v(a).setVisibility(8);
        if (true) goto _L7; else goto _L6
_L6:
    }
}
