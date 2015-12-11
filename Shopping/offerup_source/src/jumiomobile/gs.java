// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.OrientationEventListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.jumio.commons.camera.ImageData;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netverify.sdk.NetverifyDocumentData;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.custom.NetverifyCustomConfirmationView;
import com.jumio.netverify.sdk.custom.NetverifyCustomSDKInterface;
import com.jumio.netverify.sdk.custom.NetverifyCustomScanView;
import com.jumio.netverify.sdk.custom.NetverifyCustomScanViewInterface;
import com.jumio.netverify.sdk.custom.NetverifyDocumentPart;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package jumiomobile:
//            gm, hq, id, hp, 
//            mf, oo, mr, ht, 
//            hv, hu, hz, jk, 
//            gt, hh, g, mk, 
//            gu, q, ab, mt, 
//            mp, gy, gw, gx, 
//            gv, gz, nu

public final class gs extends gm
{

    private Bitmap A;
    private gz B;
    private ht C;
    private NetverifyCustomConfirmationView t;
    private RelativeLayout u;
    private NVScanSide v;
    private ArrayList w;
    private boolean x;
    private nu y;
    private Runnable z;

    public gs(ModelTemplate modeltemplate, NetverifyDocumentPart netverifydocumentpart, NetverifyCustomSDKInterface netverifycustomsdkinterface)
    {
        super(modeltemplate, netverifydocumentpart, netverifycustomsdkinterface);
        v = null;
        x = false;
        y = null;
        z = null;
        A = null;
        C = null;
        v = netverifydocumentpart.getScanSide();
        w = new ArrayList();
    }

    static NetverifyCustomConfirmationView a(gs gs1)
    {
        return gs1.t;
    }

    static Bitmap b(gs gs1)
    {
        return gs1.A;
    }

    public final void B()
    {
        if (A != null && !A.isRecycled())
        {
            A.recycle();
            A = null;
        }
    }

    public final void C()
    {
        if (z != null)
        {
            a(z);
            return;
        } else
        {
            c();
            return;
        }
    }

    public final boolean D()
    {
        boolean flag;
        if (m.v.getDocumentScanSide() == v && m.v.hasFallbackScan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (m.v.getId() == NVDocumentType.VISA)
        {
            flag = m.F;
        }
        return flag;
    }

    public final void E()
    {
        if (g != hq.h)
        {
            Object obj = g;
            hp hp1 = g.a();
            i.d();
            if (g == hq.b)
            {
                g = hq.l;
            } else
            {
                g = hq.h;
            }
            m.J = g;
            w.clear();
            w.add(m.J);
            if (m.F && obj == hq.f && D() && v != NVScanSide.FRONT)
            {
                k.a("SKIPPED");
                c();
                return;
            }
            if (!m.F)
            {
                v = NVScanSide.FRONT;
            }
            obj = hp1;
            if (hp1 == hp.a)
            {
                obj = hp.b;
            }
            a = mf.a(m.a, g, ((hp) (obj)), v, u, false, y);
            i = id.a(m.a, m, d, this, a, b, g, ((hp) (obj)));
            i.a(c);
            if (oo.a())
            {
                i.a((mr)u.findViewById(mf.ab));
                return;
            }
        }
    }

    public final void F()
    {
        if (C != null && !C.b())
        {
            throw new UnsupportedOperationException((new StringBuilder("Retry not possible after receiving error: ")).append(C.a()).toString());
        }
        s = hv.c;
        if (g != hq.h && g != hq.m || m.c != hu.m && m.c != hu.k)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (!(i instanceof hz)) goto _L2; else goto _L1
_L1:
        ((hz)i).a();
_L4:
        return;
_L2:
        if (!(i instanceof jk)) goto _L4; else goto _L3
_L3:
        ((jk)i).k();
        return;
        if (x)
        {
            c();
            return;
        } else
        {
            gt gt1 = new gt(this);
            m.b.a(gt1);
            m.b.f();
            return;
        }
    }

    public final void G()
    {
        if (g == hq.h || s != hv.f)
        {
            return;
        }
        hp hp2 = g.a();
        i.d();
        g = hq.h;
        m.J = g;
        w.add(g);
        if (!m.F)
        {
            v = NVScanSide.FRONT;
        }
        hp hp1 = hp2;
        if (hp2 == hp.a)
        {
            hp1 = hp.b;
        }
        a = mf.a(m.a, g, hp1, v, u, false, y);
        i = id.a(m.a, m, d, this, a, b, g, hp1);
        i.a(c);
        i.c();
        if (oo.a())
        {
            i.a((mr)u.findViewById(mf.ab));
        }
        b.k();
        s = hv.d;
    }

    public final nu H()
    {
        return y;
    }

    public final NVScanSide I()
    {
        return v;
    }

    public final boolean J()
    {
        return z != null;
    }

    public final String a(Context context)
    {
        if (i != null)
        {
            return i.j();
        } else
        {
            return mk.a(context, "actionbar_title_scan");
        }
    }

    public final void a(Bitmap bitmap, float f, Runnable runnable)
    {
        e.enable();
        i.d();
        B();
        A = bitmap;
        z = runnable;
        a(((Runnable) (new gu(this, f))));
    }

    public final void a(Bitmap bitmap, Bitmap bitmap1, boolean flag)
    {
        if (j)
        {
            File file = new File(Environment.getDataDirectory(m.a), String.format("tmp_%d", new Object[] {
                Long.valueOf(System.currentTimeMillis())
            }));
            try
            {
                q.a(bitmap, file, android.graphics.Bitmap.CompressFormat.WEBP, 70);
            }
            catch (IOException ioexception)
            {
                ab.a(ioexception);
            }
            k.a(file.getAbsolutePath());
            if (bitmap1 != null)
            {
                File file1 = new File(Environment.getDataDirectory(m.a), String.format("tmp_%d", new Object[] {
                    Long.valueOf(System.currentTimeMillis())
                }));
                try
                {
                    q.a(bitmap1, file1, android.graphics.Bitmap.CompressFormat.JPEG, 80);
                }
                catch (IOException ioexception1)
                {
                    ab.a(ioexception1);
                }
                k.b(file1.getAbsolutePath());
            }
        }
        if (flag)
        {
            bitmap.recycle();
            if (bitmap1 != null)
            {
                bitmap1.recycle();
            }
        }
    }

    public final void a(RelativeLayout relativelayout)
    {
        u = relativelayout;
        mf.a(u, g, h, v, b.c(), y);
        a = (mt)u.findViewById(mf.U);
        if (a instanceof mp)
        {
            mp mp1 = (mp)a;
            android.app.Activity activity = m.a;
            if (v == NVScanSide.FRONT)
            {
                relativelayout = "use_front_side_of_card";
            } else
            {
                relativelayout = "use_back_side_of_card";
            }
            mp1.setOverlayText(mk.a(activity, relativelayout));
        }
    }

    public final void a(NetverifyCustomConfirmationView netverifycustomconfirmationview)
    {
        t = netverifycustomconfirmationview;
        mf.a(netverifycustomconfirmationview);
    }

    public final void a(NetverifyCustomScanView netverifycustomscanview, hq hq1, hp hp1, NetverifyCustomScanViewInterface netverifycustomscanviewinterface, boolean flag)
    {
        super.a(netverifycustomscanview, hq1, hp1, netverifycustomscanviewinterface, flag);
        if (hq1 == hq.j || hq1 == hq.k)
        {
            b.a(true);
        }
        w.add(hq1);
    }

    public final void a(gz gz1)
    {
        B = gz1;
    }

    public final void a(nu nu)
    {
        y = nu;
    }

    public final boolean a(ht ht1)
    {
        boolean flag;
        boolean flag1;
        flag1 = x;
        flag = flag1;
        if (x) goto _L2; else goto _L1
_L1:
        gy.a[ht1.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 63
    //                   2 78;
           goto _L3 _L4 _L5
_L3:
        flag = true;
_L2:
        if (flag)
        {
            super.a(ht1);
            C = ht1;
        }
        return true;
_L4:
        m.b.c();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
_L5:
        m.b.f();
        flag = flag1;
        if (true) goto _L2; else goto _L6
_L6:
    }

    public final void b()
    {
        NetverifyDocumentData netverifydocumentdata = m.I;
        String s = netverifydocumentdata.getStreet();
        String s1 = netverifydocumentdata.getCity();
        Country country = (Country)m.d().get(m.w);
        if (!m.F && !m.N && country.b().equals("USA") && g == hq.f && (s == null || s.length() == 0 || s1 == null || s1.length() == 0))
        {
            super.b();
            this.s = hv.f;
            z = null;
            a(new gw(this));
        } else
        {
            if (!m.F && !m.N && country.b().equals("USA") && w.contains(hq.f) && w.contains(hq.h))
            {
                netverifydocumentdata.setCity(netverifydocumentdata.getCity());
                netverifydocumentdata.setStreet(netverifydocumentdata.getStreet());
                netverifydocumentdata.setPostalCode(netverifydocumentdata.getPostalCode());
                netverifydocumentdata.setState(netverifydocumentdata.getState());
            } else
            {
                super.b();
            }
            if (!m.F)
            {
                x = true;
                a(new gx(this));
                return;
            }
        }
    }

    public final void c()
    {
        if (m.F)
        {
            m.u.put(v.getPartNumber(), k);
        }
        if (m.v.getDocumentScanSide() == v)
        {
            m.J = g;
        }
        super.c();
    }

    public final void c(boolean flag)
    {
        super.c(flag);
        a(new gv(this));
    }

    public final void d()
    {
        super.d();
        if (oo.a())
        {
            i.a((mr)u.findViewById(mf.ab));
        }
    }

    public final void d(boolean flag)
    {
        ImageView imageview;
        if (u != null)
        {
            if ((imageview = (ImageView)u.findViewById(mf.m)) != null)
            {
                int i;
                if (flag)
                {
                    i = 0;
                } else
                {
                    i = 4;
                }
                imageview.setVisibility(i);
                return;
            }
        }
    }

    public final void g()
    {
        B();
        if (B != null)
        {
            B.a();
        }
        super.g();
    }

    public final boolean l()
    {
        if (g != hq.j && g != hq.k)
        {
            return super.l();
        } else
        {
            return false;
        }
    }

    public final void n()
    {
        if (g != hq.j && g != hq.k)
        {
            super.n();
        }
    }
}
