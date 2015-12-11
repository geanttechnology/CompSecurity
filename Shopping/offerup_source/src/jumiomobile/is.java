// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.RectF;
import com.jumio.clientlib.impl.livenessAndTM.LivenessDetectorCallback;
import com.jumio.clientlib.impl.livenessAndTM.LivenessDetectorResult;
import java.util.HashMap;

// Referenced classes of package jumiomobile:
//            in, mr, l, n, 
//            jh, iq, cs

class is extends LivenessDetectorCallback
{

    final in a;

    is(in in1)
    {
        a = in1;
        super();
    }

    private void a(LivenessDetectorResult livenessdetectorresult, RectF rectf, RectF rectf1)
    {
        if (in.p(a) != null)
        {
            in.p(a).setFaceRect(rectf1);
        }
    }

    private boolean a(RectF rectf)
    {
        int i = in.a(a).b.a;
        int j = in.a(a).b.b;
        float f2 = rectf.width();
        float f1 = rectf.height();
        float f;
        boolean flag;
        boolean flag1;
        boolean flag2;
        if ((float)i / (float)j < 0.7616F)
        {
            f = (float)i * 0.95F;
            f1 = f / 0.7616F;
            if (f2 < (float)i * 0.5F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (f2 > f)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            f2 = f;
            f = f1;
        } else
        {
            f = (float)j * 0.95F;
            if (f1 < (float)j * 0.5F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (f1 > (float)j)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            f2 = f * 0.7616F;
        }
        f1 = ((float)i - f2) / 2.0F;
        f = ((float)j - f) / 2.0F;
        if (rectf.left < f1 || rectf.right > (float)i - f1 || rectf.top < f || rectf.bottom > (float)j - f)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        return !flag2 && !flag1 && !flag;
    }

    public void onResult(LivenessDetectorResult livenessdetectorresult, int i)
    {
        if (in.g(a) != jh.c && in.h(a) != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        in.i(a);
        Object obj = livenessdetectorresult.getFaceRect();
        boolean flag1 = livenessdetectorresult.isTracking();
        boolean flag = false;
        RectF rectf;
        if (flag1)
        {
            rectf = in.a(a, ((com.jumio.clientlib.impl.livenessAndTM.FaceRect) (obj)));
            obj = new RectF();
            obj.top = rectf.top - rectf.height() * 0.55F;
            obj.bottom = rectf.bottom + rectf.height() * 0.15F;
            obj.left = rectf.left - rectf.width() * 0.05F;
            obj.right = rectf.right + rectf.width() * 0.05F;
            flag = a(((RectF) (obj)));
        } else
        {
            obj = null;
            rectf = null;
        }
        if (!flag1 || !flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (livenessdetectorresult.isSmiling())
        {
            in.j(a);
        }
        if (livenessdetectorresult.isLeftEyeBlinking() || livenessdetectorresult.isRightEyeBlinking())
        {
            in.k(a);
        }
        if (in.g(a) != jh.b)
        {
            in.a(a, jh.b);
            in.l(a);
        }
        if (in.e(a) == null && in.f(a) != null && in.f(a).size() > 0 && !livenessdetectorresult.isLeftEyeBlinking() && !livenessdetectorresult.isRightEyeBlinking())
        {
            in.a(a, (iq)in.f(a).get(Integer.valueOf(i)));
            in.m(a);
        }
        if (cs.a())
        {
            a(livenessdetectorresult, rectf, ((RectF) (obj)));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        in.n(a);
        if (in.f(a) != null)
        {
            in.f(a).put(Integer.valueOf(i), null);
            in.f(a).remove(Integer.valueOf(i));
        }
        if (in.o(a) >= 2 && in.g(a) != jh.a)
        {
            in.a(a, jh.a);
            in.b(a);
        }
        break MISSING_BLOCK_LABEL_304;
        if (true) goto _L1; else goto _L4
_L4:
    }
}
