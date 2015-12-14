// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.view.View;
import android.widget.RadioButton;
import com.photo.morph.brushes.MoveBrush;
import com.photo.morph.brushes.RestoreBrush;
import com.photo.morph.brushes.SqueezeBrush;
import com.photo.morph.brushes.SwirlBrush;
import com.photo.morph.brushes.a;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;

// Referenced classes of package com.photo.morph:
//            StretchActivity, MorphGLSurfaceView

final class a
    implements android.view.r
{

    private StretchActivity a;

    public final void onClick(View view)
    {
        StretchActivity.r(a);
        if (view.getId() != 0x7f100154)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        StretchActivity stretchactivity = a;
        boolean flag;
        if (stretchactivity.a != null && stretchactivity.a.c == stretchactivity.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        StretchActivity.p(a);
_L4:
        return;
_L2:
        StretchActivity stretchactivity1 = a;
        if (stretchactivity1.a != null)
        {
            stretchactivity1.a.setBrush(stretchactivity1.b);
            stretchactivity1.b.a(158F);
            stretchactivity1.b.b(0.2F);
            stretchactivity1.a.setTouchMode(TouchMode.PAINT);
            stretchactivity1.h();
        }
        if (StretchActivity.o(a) != null)
        {
            StretchActivity.o(a).setVisibility(8);
        }
        com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f100156));
_L5:
        StretchActivity.e(a).c.a(StretchActivity.t(a));
        if (StretchActivity.n(a) != null)
        {
            StretchActivity.n(a).setChecked(false);
        }
        com.photo.morph.StretchActivity.a(a, (RadioButton)view);
        StretchActivity.n(a).setChecked(true);
        if (StretchActivity.o(a) == null) goto _L4; else goto _L3
_L3:
        StretchActivity.o(a).setVisibility(0);
        return;
        if (view.getId() == 0x7f100157)
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tretchTryEvent(StretchActivity.f(a).a, "ccw"));
            if (a.e() && StretchActivity.s(a).f == com.photo.morph.brushes.T)
            {
                StretchActivity.p(a);
                return;
            }
            a.f();
            a.a(com.photo.morph.brushes.T);
            if (StretchActivity.o(a) != null)
            {
                StretchActivity.o(a).setVisibility(8);
            }
            com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f100159));
        } else
        if (view.getId() == 0x7f10015a)
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tretchTryEvent(StretchActivity.f(a).a, "cw"));
            if (a.e() && StretchActivity.s(a).f == com.photo.morph.brushes.HT)
            {
                StretchActivity.p(a);
                return;
            }
            a.f();
            a.a(com.photo.morph.brushes.HT);
            if (StretchActivity.o(a) != null)
            {
                StretchActivity.o(a).setVisibility(8);
            }
            com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f10015c));
        } else
        if (view.getId() == 0x7f10015d)
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tretchTryEvent(StretchActivity.f(a).a, "center"));
            StretchActivity stretchactivity2 = a;
            boolean flag1;
            if (stretchactivity2.a != null && stretchactivity2.a.c == stretchactivity2.c)
            {
                if (stretchactivity2.c.f == com.photo.morph.brushes.N)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                StretchActivity.p(a);
                return;
            }
            stretchactivity2 = a;
            if (stretchactivity2.a != null)
            {
                stretchactivity2.a.setBrush(stretchactivity2.c);
                stretchactivity2.c.f = com.photo.morph.brushes.N;
                stretchactivity2.c.a(256F);
                stretchactivity2.c.b(0.5F);
                stretchactivity2.a.setTouchMode(TouchMode.PAINT);
                stretchactivity2.h();
            }
            if (StretchActivity.o(a) != null)
            {
                StretchActivity.o(a).setVisibility(8);
            }
            com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f10015f));
        } else
        if (view.getId() == 0x7f100160)
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tretchTryEvent(StretchActivity.f(a).a, "out"));
            StretchActivity stretchactivity3 = a;
            boolean flag2;
            if (stretchactivity3.a != null && stretchactivity3.a.c == stretchactivity3.c)
            {
                if (stretchactivity3.c.f == com.photo.morph.brushes.UT)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
            } else
            {
                flag2 = false;
            }
            if (flag2)
            {
                StretchActivity.p(a);
                return;
            }
            stretchactivity3 = a;
            if (stretchactivity3.a != null)
            {
                stretchactivity3.a.setBrush(stretchactivity3.c);
                stretchactivity3.c.f = com.photo.morph.brushes.UT;
                stretchactivity3.c.a(256F);
                stretchactivity3.c.b(0.5F);
                stretchactivity3.a.setTouchMode(TouchMode.PAINT);
                stretchactivity3.h();
            }
            if (StretchActivity.o(a) != null)
            {
                StretchActivity.o(a).setVisibility(8);
            }
            com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f100162));
        } else
        if (view.getId() == 0x7f100163)
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.tretchTryEvent(StretchActivity.f(a).a, "reverse"));
            StretchActivity stretchactivity4 = a;
            boolean flag3;
            if (stretchactivity4.a != null && stretchactivity4.a.c == stretchactivity4.d)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            if (flag3)
            {
                StretchActivity.p(a);
                return;
            }
            stretchactivity4 = a;
            if (stretchactivity4.a != null)
            {
                stretchactivity4.a.setBrush(stretchactivity4.d);
                stretchactivity4.d.a(200F);
                stretchactivity4.d.b(0.9F);
                stretchactivity4.a.setTouchMode(TouchMode.PAINT);
                stretchactivity4.h();
            }
            if (StretchActivity.o(a) != null)
            {
                StretchActivity.o(a).setVisibility(8);
            }
            com.photo.morph.StretchActivity.a(a, a.findViewById(0x7f100165));
        }
          goto _L5
    }

    h(StretchActivity stretchactivity)
    {
        a = stretchactivity;
        super();
    }
}
