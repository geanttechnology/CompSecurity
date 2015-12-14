// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.fotoable.fotoproedit.activity.ProEditFontActivity;
import com.fotoable.fotoproedit.activity.font.FontSldeLineView;
import com.fotoable.fotoproedit.activity.font.FontTextLabelView;
import com.fotoable.fotoproedit.view.ui.scroll.TProEditTextBottomBar;

public class ahb
    implements akr
{

    final ProEditFontActivity a;

    public ahb(ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }

    public PointF a()
    {
        if (ProEditFontActivity.n(a) != null)
        {
            Rect rect = ProEditFontActivity.b(a, ProEditFontActivity.q(a));
            return new PointF((float)rect.left + ProEditFontActivity.n(a).centerPt().x, (float)rect.top + ProEditFontActivity.n(a).centerPt().y);
        } else
        {
            return new PointF();
        }
    }

    public void a(float f)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setImageScale(f);
            ProEditFontActivity.n(a).updateLabelView();
            ProEditFontActivity.a(a, ProEditFontActivity.n(a));
        }
        ProEditFontActivity.o(a);
        ProEditFontActivity.p(a);
        ProEditFontActivity.h(a);
    }

    public void a(float f, float f1)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setImageRotate(f);
            ProEditFontActivity.n(a).setImageScale(f1);
            ProEditFontActivity.n(a).updateLabelView();
            ProEditFontActivity.a(a, ProEditFontActivity.n(a));
        }
        ProEditFontActivity.o(a);
        ProEditFontActivity.p(a);
        ProEditFontActivity.h(a);
    }

    public void a(int i, int j)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setCPointD(i, j);
            ProEditFontActivity.a(a, ProEditFontActivity.n(a));
        }
        ProEditFontActivity.o(a);
        ProEditFontActivity.p(a);
        ProEditFontActivity.h(a);
    }

    public void a(MotionEvent motionevent)
    {
        int i = (int)motionevent.getX();
        int j = (int)motionevent.getY();
        if (ProEditFontActivity.r(a).getVisibility() == 0 && ProEditFontActivity.b(a, ProEditFontActivity.r(a)).contains(i, j))
        {
            ProEditFontActivity.s(a);
        } else
        {
            if (ProEditFontActivity.t(a).getVisibility() == 0 && ProEditFontActivity.b(a, ProEditFontActivity.t(a)).contains(i, j))
            {
                ProEditFontActivity.u(a);
                return;
            }
            if (ProEditFontActivity.n(a) != null)
            {
                boolean flag = ProEditFontActivity.a(a, motionevent);
                if (ProEditFontActivity.i(a))
                {
                    if (!flag)
                    {
                        ProEditFontActivity.p(a);
                        return;
                    }
                    if (ProEditFontActivity.n(a).getText().length() == 0)
                    {
                        ProEditFontActivity.n(a).setLabelTextStr("");
                        ProEditFontActivity.n(a).onTextCreate();
                        ProEditFontActivity.a(a, ProEditFontActivity.n(a));
                        ProEditFontActivity.h(a);
                        return;
                    }
                } else
                {
                    if (flag)
                    {
                        ProEditFontActivity.b(a, true);
                        ProEditFontActivity.j(a);
                        ProEditFontActivity.c(a, true);
                        ProEditFontActivity.v(a).setKeyBoardBtnSelected();
                        ProEditFontActivity.k(a);
                        return;
                    }
                    if (ProEditFontActivity.n(a) != null)
                    {
                        ProEditFontActivity.w(a).setVisibility(4);
                    }
                    ProEditFontActivity.b(a, null);
                    ProEditFontActivity.d(a, false);
                    return;
                }
            } else
            {
                ProEditFontActivity.a(a, motionevent);
                return;
            }
        }
    }

    public void b()
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).storeTransform();
        }
    }

    public void b(float f)
    {
        if (ProEditFontActivity.n(a) != null)
        {
            ProEditFontActivity.n(a).setImageRotate(f);
            ProEditFontActivity.n(a).updateLabelView();
            ProEditFontActivity.a(a, ProEditFontActivity.n(a));
        }
        ProEditFontActivity.o(a);
        ProEditFontActivity.p(a);
        ProEditFontActivity.h(a);
    }

    public boolean b(MotionEvent motionevent)
    {
        return ProEditFontActivity.b(a, ProEditFontActivity.x(a)).contains((int)motionevent.getX(), (int)motionevent.getY());
    }

    public void c(MotionEvent motionevent)
    {
        while (ProEditFontActivity.n(a) != null || !ProEditFontActivity.a(a, motionevent) || ProEditFontActivity.y(a)) 
        {
            return;
        }
        ProEditFontActivity.d(a, true);
    }
}
