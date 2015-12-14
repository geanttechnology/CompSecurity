// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.CameraCtrl;
import com.cyberlink.youcammakeup.camera.y;
import com.cyberlink.youcammakeup.clflurry.p;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.ao;
import com.cyberlink.youcammakeup.utility.as;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            x, p, g, d, 
//            e, b, c, h, 
//            i, a

class a extends AsyncTask
{

    final as a;
    final x b;

    protected transient Void a(Void avoid[])
    {
        BeautifierManager beautifiermanager;
        Log.d("LookEffectPanel", (new StringBuilder()).append("[applyEffect] GUID:").append(a.a()).toString());
        avoid = x.b(b).j();
        beautifiermanager = x.b(b).k().j();
        if (!(avoid instanceof CLMakeupLiveFilter)) goto _L2; else goto _L1
_L1:
        CLMakeupLiveFilter clmakeuplivefilter;
        List list;
        android.hardware.ra.Size size;
        Iterator iterator;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        clmakeuplivefilter = (CLMakeupLiveFilter)avoid;
        p.l(a.a());
        list = a.m();
        avoid = new android.graphics.apFactory.Options();
        avoid.inSampleSize = 2;
        avoid.inJustDecodeBounds = false;
        size = x.b(b).k().k();
        if (size == null)
        {
            return null;
        }
        avoid = p.a();
        avoid.a(BeautyMode.n, null);
        avoid.a(BeautyMode.m, null);
        avoid.a(BeautyMode.l, null);
        avoid.a(BeautyMode.a, null);
        avoid.a(BeautyMode.v, null);
        avoid.a(BeautyMode.r, null);
        avoid.a(a.f());
        iterator = list.iterator();
        flag4 = false;
        flag3 = false;
        flag2 = false;
        flag1 = false;
        flag = false;
_L10:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        int ai[] = (ao)iterator.next();
        if (ai.a() != BeautyMode.n) goto _L6; else goto _L5
_L5:
        int ai1[];
        int ai2[];
        int ai3[];
        byte abyte4[][];
        byte abyte5[];
        byte abyte6[];
        byte abyte7[];
        int k;
        int i1;
        int i2;
        int l2;
        int i3;
        List list1 = ai.f();
        MotionControlHelper.e().b(list1);
        avoid = p.a();
        avoid.a(BeautyMode.n, ai.b());
        avoid.a(new g(ai.c(), list1, false));
        avoid = d.a(ai.b());
        abyte4 = ((e) (avoid)).a;
        i2 = abyte4.length;
        ai = new int[((e) (avoid)).d * ((e) (avoid)).e];
        ai1 = new int[list1.size()];
        ai2 = new int[list1.size()];
        for (int j = 0; j < list1.size(); j++)
        {
            ai1[j] = ((at)list1.get(j)).e();
            ai2[j] = ((at)list1.get(j)).d();
        }

        l2 = Math.min(size.height, size.width) / 2;
        i3 = (l2 * 2) / 3;
        ai3 = new int[i2];
        k = 0;
        while (k < i2) 
        {
            if (k >= list1.size())
            {
                ai3[k] = 0;
            } else
            {
                int l;
                if (((at)list1.get(k)).k())
                {
                    l = ((at)list1.get(k)).j();
                } else
                {
                    l = 0;
                }
                ai3[k] = l;
            }
            k++;
        }
        i1 = 0;
        for (k = 0; k < 2; k++)
        {
            i1 += (l2 >> k) * (i3 >> k);
        }

        abyte5 = new byte[i1];
        abyte6 = new byte[i1];
        Bitmap bitmap = x.b(b).k().a("makeup/eyeshadow/bright.png");
        k = bitmap.getWidth();
        i1 = bitmap.getHeight();
        abyte7 = x.b(b).k().a(bitmap);
        if (beautifiermanager == null)
        {
            break MISSING_BLOCK_LABEL_692;
        }
        beautifiermanager;
        JVM INSTR monitorenter ;
        beautifiermanager.a(ai, abyte4, ai1, ai2, i2, ((e) (avoid)).d, ((e) (avoid)).e, l2, i3, ai3, 2, k, i1, abyte7, abyte5, abyte6);
        beautifiermanager;
        JVM INSTR monitorexit ;
        clmakeuplivefilter.a(true, ai, abyte5, abyte6);
        if (!((e) (avoid)).c) goto _L8; else goto _L7
_L7:
        abyte4 = ((e) (avoid)).b;
        i2 = abyte4.length;
        if (beautifiermanager == null) goto _L8; else goto _L9
_L9:
        beautifiermanager;
        JVM INSTR monitorenter ;
        beautifiermanager.a(ai, abyte4, ai1, ai2, i2, ((e) (avoid)).d, ((e) (avoid)).e, l2, i3, ai3, 2, k, i1, abyte7, abyte5, abyte6);
        beautifiermanager;
        JVM INSTR monitorexit ;
_L8:
        clmakeuplivefilter.a(false, ai, abyte5, abyte6);
        boolean flag5 = flag4;
        flag1 = flag3;
        flag3 = true;
        flag4 = flag;
        flag = flag5;
_L11:
        boolean flag6 = flag1;
        flag1 = flag3;
        boolean flag10 = flag4;
        flag4 = flag;
        flag3 = flag6;
        flag = flag10;
          goto _L10
        avoid;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw avoid;
        avoid;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw avoid;
_L6:
        if (ai.a() != BeautyMode.l)
        {
            break MISSING_BLOCK_LABEL_1107;
        }
        Globals.d().e((new StringBuilder()).append("LiveMakeup LookEffectPanel eyeline patternID = ").append(String.valueOf(ai.b())).toString());
        avoid = com.cyberlink.youcammakeup.widgetpool.panel.c.b.a(ai.b());
        byte abyte0[][] = ((c) (avoid)).a;
        int j2 = abyte0.length;
        k = ((c) (avoid)).b;
        byte abyte2[] = new byte[((c) (avoid)).c * k];
        com.cyberlink.youcammakeup.widgetpool.panel.c.p p3;
        int j1;
        boolean flag7;
        if (!ai.f().isEmpty())
        {
            avoid = (at)ai.f().get(0);
        } else
        {
            avoid = null;
        }
        k = 0;
        j1 = 0;
        if (avoid != null)
        {
            k = ((at)ai.f().get(0)).e();
            j1 = ((at)ai.f().get(0)).d();
        }
        p3 = p.a();
        p3.a(BeautyMode.l, ai.b());
        p3.b(BeautyMode.l, ai.c());
        p3.a(BeautyMode.l, avoid);
        if (beautifiermanager == null)
        {
            break MISSING_BLOCK_LABEL_1071;
        }
        beautifiermanager;
        JVM INSTR monitorenter ;
        beautifiermanager.a(abyte2, abyte0, k, j1, j2, 450, 300);
        beautifiermanager;
        JVM INSTR monitorexit ;
        clmakeuplivefilter.b(true, abyte2, k);
        clmakeuplivefilter.b(false, abyte2, k);
        flag = flag4;
        flag4 = flag1;
        flag7 = true;
        flag1 = flag3;
        flag3 = flag4;
        flag4 = flag7;
          goto _L11
        avoid;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw avoid;
        if (ai.a() != BeautyMode.m)
        {
            break MISSING_BLOCK_LABEL_1360;
        }
        avoid = h.a(ai.b());
        byte abyte1[][] = ((i) (avoid)).a;
        int k2 = abyte1.length;
        k = ((i) (avoid)).b;
        byte abyte3[] = new byte[((i) (avoid)).c * k];
        com.cyberlink.youcammakeup.widgetpool.panel.c.p p4;
        int k1;
        boolean flag8;
        boolean flag11;
        if (!ai.f().isEmpty())
        {
            avoid = (at)ai.f().get(0);
        } else
        {
            avoid = null;
        }
        k = 0;
        k1 = 0;
        if (avoid != null)
        {
            k = ((at)ai.f().get(0)).e();
            k1 = ((at)ai.f().get(0)).d();
        }
        p4 = p.a();
        p4.a(BeautyMode.m, ai.b());
        p4.b(BeautyMode.m, ai.c());
        p4.a(BeautyMode.m, avoid);
        if (beautifiermanager == null)
        {
            break MISSING_BLOCK_LABEL_1320;
        }
        beautifiermanager;
        JVM INSTR monitorenter ;
        beautifiermanager.b(abyte3, abyte1, k, k1, k2, 450, 300);
        beautifiermanager;
        JVM INSTR monitorexit ;
        clmakeuplivefilter.a(true, abyte3, k);
        clmakeuplivefilter.a(false, abyte3, k);
        flag11 = true;
        flag4 = flag1;
        flag8 = flag;
        flag = flag11;
        flag1 = flag3;
        flag3 = flag4;
        flag4 = flag8;
          goto _L11
        avoid;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw avoid;
        if (ai.a() != BeautyMode.v) goto _L13; else goto _L12
_L12:
        Object aobj[] = new int[3];
        com.cyberlink.youcammakeup.widgetpool.panel.c.p p1;
        com.cyberlink.youcammakeup.widgetpool.panel.c.p p2;
        int l1;
        boolean flag9;
        boolean flag12;
        if (!ai.f().isEmpty())
        {
            avoid = (at)ai.f().get(0);
        } else
        {
            avoid = null;
        }
        l1 = 0;
        if (avoid != null)
        {
            l1 = avoid.d();
            aobj[0] = avoid.f();
            aobj[1] = avoid.g();
            aobj[2] = avoid.e();
        }
        p2 = p.a();
        p2.a(BeautyMode.v, ai.b());
        p2.b(BeautyMode.v, ai.c());
        p2.a(BeautyMode.v, avoid);
        avoid = PanelDataCenter.a().b(BeautyMode.v, com.cyberlink.youcammakeup.utility.lDataCenter.SourceType.a);
        k = 0;
_L16:
        if (k < avoid.size())
        {
            if (!((String)avoid.get(k)).equals(ai.b()))
            {
                break MISSING_BLOCK_LABEL_1971;
            }
        } else
        {
            k = 0;
        }
        clmakeuplivefilter.a(aobj[2]);
        avoid = new com.cyberlink.clgpuimage.keupLiveLipStickFilter.LipStickProfile(com.cyberlink.clgpuimage.keupLiveLipStickFilter.BlendMode.values()[k], aobj[2], aobj[0], aobj[1]);
        if (beautifiermanager == null) goto _L15; else goto _L14
_L14:
        beautifiermanager;
        JVM INSTR monitorenter ;
        beautifiermanager.a(avoid);
        beautifiermanager.a(l1);
        beautifiermanager;
        JVM INSTR monitorexit ;
          goto _L15
        avoid;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw avoid;
_L13:
        if (ai.a() == BeautyMode.a)
        {
            aobj = com.cyberlink.youcammakeup.widgetpool.panel.c.a.a(ai.b());
            if (!ai.f().isEmpty())
            {
                avoid = (at)ai.f().get(0);
            } else
            {
                avoid = null;
            }
            l1 = 0;
            k = 0;
            if (avoid != null)
            {
                l1 = avoid.d();
                k = avoid.e();
            }
            p2 = p.a();
            p2.a(BeautyMode.a, ai.b());
            p2.b(BeautyMode.a, ai.c());
            p2.a(BeautyMode.a, avoid);
            clmakeuplivefilter.a(((Bitmap []) (aobj)));
            clmakeuplivefilter.a(l1);
            clmakeuplivefilter.b(k);
            flag9 = flag4;
            flag12 = true;
            flag3 = flag1;
            flag4 = flag;
            flag = flag9;
            flag1 = flag12;
        } else
        {
            if (ai.a() == BeautyMode.r)
            {
                if (!ai.f().isEmpty())
                {
                    avoid = (at)ai.f().get(0);
                } else
                {
                    avoid = null;
                }
                p1 = p.a();
                p1.a(BeautyMode.r, ai.b());
                p1.a(BeautyMode.r, avoid);
                p1.a(ai.h());
            }
            flag9 = flag1;
            flag12 = flag;
            flag = flag4;
            flag1 = flag3;
            flag3 = flag9;
            flag4 = flag12;
        }
          goto _L11
_L4:
        if (list.isEmpty())
        {
            p.a().b();
        }
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.keupLiveFilter.MakeupLiveFeatures.a, flag);
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.keupLiveFilter.MakeupLiveFeatures.b, flag1);
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.keupLiveFilter.MakeupLiveFeatures.c, flag2);
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.keupLiveFilter.MakeupLiveFeatures.e, flag3);
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.keupLiveFilter.MakeupLiveFeatures.f, flag4);
_L2:
        return null;
_L15:
        flag2 = flag4;
        flag9 = flag3;
        flag12 = true;
        flag3 = flag1;
        flag4 = flag;
        flag = flag2;
        flag1 = flag9;
        flag2 = flag12;
          goto _L11
        k++;
          goto _L16
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    LiveFeatures(x x1, as as1)
    {
        b = x1;
        a = as1;
        super();
    }
}
