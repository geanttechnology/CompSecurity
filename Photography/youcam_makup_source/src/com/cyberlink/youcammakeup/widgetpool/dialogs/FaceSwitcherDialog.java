// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.c.c;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.ch;
import com.cyberlink.youcammakeup.widgetpool.common.FaceSwitcherView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            j

public class FaceSwitcherDialog extends a
{

    public static final UUID a = UUID.randomUUID();
    protected j b;
    private View c;
    private View d;
    private View e;
    private View f;
    private c g;
    private com.cyberlink.youcammakeup.kernelctrl.status.a h;
    private FaceSwitcherView i;
    private int j;
    private int k;
    private boolean l;
    private android.content.DialogInterface.OnKeyListener m;
    private android.view.View.OnTouchListener n;

    public FaceSwitcherDialog()
    {
        m = new android.content.DialogInterface.OnKeyListener() {

            final FaceSwitcherDialog a;

            public boolean onKey(DialogInterface dialoginterface, int i1, KeyEvent keyevent)
            {
                if (i1 == 4 && keyevent.getAction() == 1)
                {
                    com.cyberlink.youcammakeup.widgetpool.dialogs.FaceSwitcherDialog.a(a, com.cyberlink.youcammakeup.widgetpool.dialogs.DismissType.a, com.cyberlink.youcammakeup.widgetpool.dialogs.FaceSwitcherDialog.a(a).e);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = FaceSwitcherDialog.this;
                super();
            }

            private class DismissType extends Enum
            {

                public static final DismissType a;
                public static final DismissType b;
                private static final DismissType c[];

                public static DismissType valueOf(String s)
                {
                    return (DismissType)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/dialogs/FaceSwitcherDialog$DismissType, s);
                }

                public static DismissType[] values()
                {
                    return (DismissType[])c.clone();
                }

                static 
                {
                    a = new DismissType("USER_CANCELLED", 0);
                    b = new DismissType("SELECT_FACE", 1);
                    c = (new DismissType[] {
                        a, b
                    });
                }

                private DismissType(String s, int i1)
                {
                    super(s, i1);
                }
            }

        };
        n = new android.view.View.OnTouchListener() {

            final FaceSwitcherDialog a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getActionMasked();
                JVM INSTR tableswitch 0 1: default 28
            //                           0 30
            //                           1 66;
                   goto _L1 _L2 _L3
_L1:
                int i1;
                return true;
_L2:
                if ((i1 = FaceSwitcherDialog.b(a).a(motionevent.getX(), motionevent.getY())) >= 0)
                {
                    FaceSwitcherDialog.b(a).setHoveredFacePosition(i1);
                    return true;
                }
                  goto _L1
_L3:
                int j1;
                i1 = FaceSwitcherDialog.b(a).a(motionevent.getX(), motionevent.getY());
                j1 = FaceSwitcherDialog.b(a).getHoveredFacePosition();
                motionevent = com.cyberlink.youcammakeup.widgetpool.dialogs.DismissType.a;
                if (i1 < 0 || i1 != j1) goto _L5; else goto _L4
_L4:
                FaceSwitcherDialog.b(a).setSeletectFacePosition(i1);
                view = DismissType.b;
_L7:
                FaceSwitcherDialog.b(a).post(new Runnable(this, view, i1) {

                    final DismissType a;
                    final int b;
                    final _cls7 c;

                    public void run()
                    {
                        com.cyberlink.youcammakeup.widgetpool.dialogs.FaceSwitcherDialog.a(c.a, a, b);
                    }

            
            {
                c = _pcls7;
                a = dismisstype;
                b = i1;
                super();
            }
                });
                return true;
_L5:
                view = motionevent;
                if (j1 >= 0)
                {
                    FaceSwitcherDialog.b(a).setHoveredFacePosition(-1);
                    view = motionevent;
                }
                if (true) goto _L7; else goto _L6
_L6:
            }

            
            {
                a = FaceSwitcherDialog.this;
                super();
            }
        };
    }

    static com.cyberlink.youcammakeup.kernelctrl.status.a a(FaceSwitcherDialog faceswitcherdialog)
    {
        return faceswitcherdialog.h;
    }

    static void a(FaceSwitcherDialog faceswitcherdialog, DismissType dismisstype, int i1)
    {
        faceswitcherdialog.b(dismisstype, i1);
    }

    static FaceSwitcherView b(FaceSwitcherDialog faceswitcherdialog)
    {
        return faceswitcherdialog.i;
    }

    private List b(View view, c c1)
    {
        ArrayList arraylist = new ArrayList();
        int ai1[] = new int[2];
        view.getLocationOnScreen(ai1);
        j = ai1[1] - k;
        if (c1 == null)
        {
            Globals.d().e("FaceSwitcherDialog::calculateFaceRects(), error. viewerInfo == null");
        }
        if (h == null)
        {
            Globals.d().e("FaceSwitcherDialog::calculateFaceRects(), error. mImageStateInfo == null");
        }
        List list = VenusHelper.a(c1.b, c1.c, h.d(), c1.d);
        float af[] = new float[9];
        c1.j.getValues(af);
        float f1 = af[0];
        float f2 = af[2] * f1 + (float)view.getWidth() / 2.0F;
        float f3 = af[5] * f1 + (float)view.getHeight() / 2.0F + (float)j;
        for (view = list.iterator(); view.hasNext(); arraylist.add(new RectF((float)((ar) (c1)).b.b() * f1 + f2, (float)((ar) (c1)).b.c() * f1 + f3, (float)((ar) (c1)).b.d() * f1 + f2, (float)((ar) (c1)).b.e() * f1 + f3)))
        {
            c1 = (ar)view.next();
        }

        return arraylist;
    }

    private void b(DismissType dismisstype, int i1)
    {
        if (e == null || !l)
        {
            a(dismisstype, i1);
            return;
        } else
        {
            ImageView imageview = new ImageView(getActivity());
            View view = getActivity().findViewById(0x1020002);
            ViewGroup viewgroup = (ViewGroup)getView();
            view.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
            viewgroup.draw(new Canvas(bitmap));
            viewgroup.addView(imageview, -1, -1);
            imageview.setImageBitmap(bitmap);
            view.setDrawingCacheEnabled(false);
            int ai1[] = new int[2];
            e.getLocationOnScreen(ai1);
            float f6 = ai1[0];
            float f3 = ai1[1] - k;
            float f7 = e.getWidth();
            float f4 = e.getHeight();
            float f8 = viewgroup.getWidth();
            float f5 = viewgroup.getHeight();
            float f1 = f7 / f8;
            float f2 = f4 / f5;
            f6 -= (f8 - f7) / 2.0F;
            f3 -= (f5 - f4) / 2.0F;
            dismisstype = new ch(f1, f2, f6, f3, viewgroup, new ch(viewgroup, new ch(viewgroup, new ch(dismisstype, i1, imageview, bitmap) {

                final DismissType a;
                final int b;
                final ImageView c;
                final Bitmap d;
                final FaceSwitcherDialog e;

                public void onAnimationEnd(Animator animator)
                {
                    e.a(a, b);
                    c.setImageBitmap(null);
                    d.recycle();
                }

            
            {
                e = FaceSwitcherDialog.this;
                a = dismisstype;
                b = i1;
                c = imageview;
                d = bitmap;
                super();
            }
            }) {

                final ViewGroup a;
                final ch b;
                final FaceSwitcherDialog c;

                public void onAnimationEnd(Animator animator)
                {
                    a.animate().setListener(b).setDuration(350L).setInterpolator(AnimationUtils.loadInterpolator(c.getActivity(), 0x10a0006)).alphaBy(1.0F).alpha(0.0F).start();
                }

            
            {
                c = FaceSwitcherDialog.this;
                a = viewgroup;
                b = ch1;
                super();
            }
            }, f1, f2, f6, f3) {

                final ViewGroup a;
                final ch b;
                final float c;
                final float d;
                final float e;
                final float f;
                final FaceSwitcherDialog g;

                public void onAnimationEnd(Animator animator)
                {
                    a.animate().setListener(b).setDuration(250L).setInterpolator(AnimationUtils.loadInterpolator(g.getActivity(), 0x10a0006)).scaleXBy(1.0F).scaleX(c).scaleYBy(1.0F).scaleY(d).rotationBy(70F).rotation(90F).x(e).y(f).start();
                }

            
            {
                g = FaceSwitcherDialog.this;
                a = viewgroup;
                b = ch1;
                c = f1;
                d = f2;
                e = f3;
                f = f4;
                super();
            }
            }) {

                final float a;
                final float b;
                final float c;
                final float d;
                final ViewGroup e;
                final ch f;
                final FaceSwitcherDialog g;

                public void onAnimationEnd(Animator animator)
                {
                    float f9 = a;
                    float f10 = b;
                    float f11 = c;
                    float f12 = d;
                    e.animate().setListener(f).setDuration(300L).setInterpolator(AnimationUtils.loadInterpolator(g.getActivity(), 0x10a0005)).scaleXBy(1.0F).scaleX((1.0F - f9) * 0.3F).scaleYBy(1.0F).scaleY((1.0F - f10) * 0.3F).rotationBy(0.0F).rotation(70F).x(f11 * 0.2F).y(f12).start();
                }

            
            {
                g = FaceSwitcherDialog.this;
                a = f1;
                b = f2;
                c = f3;
                d = f4;
                e = viewgroup;
                f = ch1;
                super();
            }
            };
            viewgroup.animate().setListener(dismisstype).setDuration(0L).start();
            i.setVisibility(4);
            return;
        }
    }

    private void c()
    {
        Rect rect = new Rect();
        ((ViewGroup)getActivity().findViewById(0x1020002)).getWindowVisibleDisplayFrame(rect);
        k = rect.top;
    }

    public void a(View view)
    {
        e = view;
    }

    public void a(View view, c c1)
    {
        d = view;
        g = c1;
    }

    public void a(DismissType dismisstype, int i1)
    {
        super.dismiss();
        if (b != null)
        {
            b.a(dismisstype, i1);
        }
    }

    public void a(j j1)
    {
        b = j1;
    }

    public void a(boolean flag)
    {
        l = flag;
    }

    public void b()
    {
        if (i == null)
        {
            Runnable runnable = new Runnable() {

                final FaceSwitcherDialog a;

                public void run()
                {
                    a.b();
                }

            
            {
                a = FaceSwitcherDialog.this;
                super();
            }
            };
            (new Handler()).post(runnable);
            return;
        } else
        {
            List list = b(d, g);
            i.a(list, h.e);
            i.setEnabled(true);
            f.animate().alpha(1.0F).setDuration(500L).start();
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        getDialog().getWindow().setWindowAnimations(0);
        f = c.findViewById(0x7f0c0595);
        i = (FaceSwitcherView)c.findViewById(0x7f0c0594);
        long l1 = StatusManager.j().l();
        h = StatusManager.j().f(l1);
        if (h == null)
        {
            Globals.d().e((new StringBuilder()).append("FaceSwitcherDialog::onActivityCreated(), error. mImageStateInfo == null, curImageID=").append(String.valueOf(l1)).toString());
        }
        i.setOnTouchListener(n);
        getDialog().setOnKeyListener(m);
        f.setAlpha(0.0F);
        i.setEnabled(false);
        c();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c = layoutinflater.inflate(0x7f030119, viewgroup);
        return c;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

}
