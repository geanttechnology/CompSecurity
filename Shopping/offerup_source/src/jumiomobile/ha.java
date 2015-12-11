// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.util.SparseArray;
import android.view.View;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.custom.NetverifyCountry;
import com.jumio.netverify.sdk.custom.NetverifyCustomSDKInterface;
import com.jumio.netverify.sdk.custom.NetverifyDocumentPart;
import com.jumio.netverify.sdk.custom.SDKNotConfiguredException;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentVariant;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package jumiomobile:
//            gz, jw, hc, hf, 
//            gl, hq, gs, hk, 
//            an, pk, pj, ju, 
//            jx, hh, hp, ba, 
//            ab, hb, he, ht, 
//            hd, lm

public class ha
    implements gz, jw
{

    private NetverifyCustomSDKInterface a;
    private ModelTemplate b;
    private ArrayList c;
    private hf d;
    private ht e;
    private gs f;
    private ju g;
    private int h;
    private BroadcastReceiver i;

    public ha(ModelTemplate modeltemplate, NetverifyCustomSDKInterface netverifycustomsdkinterface)
    {
        i = new hc(this);
        b = modeltemplate;
        a = netverifycustomsdkinterface;
        c = new ArrayList();
        modeltemplate.u = new SparseArray();
        d = hf.a;
    }

    static ht a(ha ha1, ht ht1)
    {
        ha1.e = ht1;
        return ht1;
    }

    static void a(ha ha1)
    {
        ha1.r();
    }

    static ModelTemplate b(ha ha1)
    {
        return ha1.b;
    }

    static NetverifyCustomSDKInterface c(ha ha1)
    {
        return ha1.a;
    }

    static hf d(ha ha1)
    {
        return ha1.d;
    }

    static gs e(ha ha1)
    {
        return ha1.f;
    }

    static ht f(ha ha1)
    {
        return ha1.e;
    }

    static int g(ha ha1)
    {
        return ha1.h;
    }

    private void r()
    {
        HashMap hashmap = new HashMap();
        for (int i1 = 0; i1 < b.d().size(); i1++)
        {
            Country country = (Country)b.d().get(i1);
            HashMap hashmap1 = new HashMap();
            DocumentType documenttype;
            for (Iterator iterator = country.e().iterator(); iterator.hasNext(); hashmap1.put(documenttype.getId(), Boolean.valueOf(documenttype.hasPaperVariant())))
            {
                documenttype = (DocumentType)iterator.next();
            }

            hashmap.put(country.b(), new NetverifyCountry(country.b(), Collections.unmodifiableMap(hashmap1)));
        }

        NetverifyCustomSDKInterface netverifycustomsdkinterface = a;
        String s;
        if (b.k != null)
        {
            s = b.k.b();
        } else
        {
            s = "";
        }
        netverifycustomsdkinterface.onNetverifyCountriesReceived(hashmap, s);
    }

    public gl a(lm lm)
    {
        return new gl(b, null, a, lm);
    }

    public gs a(NetverifyDocumentPart netverifydocumentpart)
    {
        if (b.w == -1 || b.v == null || b.F && b.v.getDocumentVariant() == null)
        {
            throw new SDKNotConfiguredException("Country, document type or document variant missing");
        }
        if (netverifydocumentpart == null)
        {
            throw new IllegalArgumentException("Document part is not set properly!");
        }
        if (b.f().b(b.a, b.v))
        {
            b.v.setDocumentScanMode(hq.m);
        }
        f = new gs(b, netverifydocumentpart, a);
        f.a(this);
        d = hf.b;
        return f;
    }

    public hq a(NVScanSide nvscanside)
    {
        if (b.v.getDocumentScanSide() == nvscanside)
        {
            return b.v.getDocumentScanMode();
        }
        if (NVScanSide.FACE == nvscanside)
        {
            boolean flag;
            if (((pk)hk.d().a(b.a, "BenchmarkService")).c() == pj.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return hq.j;
            } else
            {
                return hq.k;
            }
        }
        if (b.v.getDocumentVariant() == NVDocumentVariant.PAPER && (!"DEU".equals(b.f().b()) || b.v.getId() != NVDocumentType.IDENTITY_CARD))
        {
            return hq.l;
        } else
        {
            return hq.i;
        }
    }

    public void a()
    {
        if (b.F)
        {
            d = hf.c;
        } else
        {
            d = hf.a;
        }
        f = null;
    }

    public void a(int i1)
    {
        b.w = i1;
        b.v = null;
        if (b.f() == null)
        {
            throw new IllegalArgumentException("Unsupported country code");
        } else
        {
            return;
        }
    }

    public void a(View view, int i1, jw jw1, boolean flag)
    {
        if (!b.N) goto _L2; else goto _L1
_L1:
        if (jw1 != null)
        {
            jw1.l();
        }
_L4:
        return;
_L2:
        if (g == null || !g.b(b.f()) || !g.b(b.v) || g.b() == jx.b)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        g.a(view);
        g.a(i1);
        g.a(jw1);
        if (view == null || i1 == -1) goto _L4; else goto _L3
_L3:
        view.findViewById(i1).setVisibility(0);
        view.invalidate();
        return;
        if (jw1 == null) goto _L4; else goto _L5
_L5:
        jw1.l();
        return;
        g = new ju(b.a);
        g.a(b.f());
        if (b.v == null)
        {
            n();
        }
        g.a(b.v);
        if (!flag) goto _L7; else goto _L6
_L6:
        g.a(view);
        g.a(i1);
        g.a(jw1);
_L9:
        g.a();
        return;
_L7:
        if (jw1 != null)
        {
            jw1.l();
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void a(NetverifyCountry netverifycountry)
    {
        b.w = -1;
        b.v = null;
        if (netverifycountry == null)
        {
            throw new IllegalArgumentException("Unsupported country code");
        } else
        {
            a(netverifycountry.getIsoCode());
            return;
        }
    }

    public void a(NVDocumentType nvdocumenttype)
    {
        b.v = null;
        Country country = b.f();
        if (country == null)
        {
            throw new InvalidParameterException("Unsupported country code");
        }
        if (nvdocumenttype == null || !country.a(nvdocumenttype))
        {
            throw new InvalidParameterException("Unsupported document type");
        } else
        {
            b.v = country.b(nvdocumenttype);
            b.v.setDocumentVariant(null);
            return;
        }
    }

    public void a(NVDocumentVariant nvdocumentvariant)
    {
        b.v.setDocumentVariant(null);
        if (nvdocumentvariant == null || !b.v.isDocumentVariantAccepted(nvdocumentvariant))
        {
            throw new InvalidParameterException("Unsupported document variant");
        } else
        {
            b.v.setDocumentVariant(nvdocumentvariant);
            b.b.f();
            return;
        }
    }

    public void a(String s)
    {
        b.w = -1;
        b.v = null;
        int i1 = 0;
        do
        {
label0:
            {
                if (i1 < b.d().size())
                {
                    if (!((Country)b.d().get(i1)).b().equals(s))
                    {
                        break label0;
                    }
                    a(i1);
                }
                return;
            }
            i1++;
        } while (true);
    }

    public hp b(NetverifyDocumentPart netverifydocumentpart)
    {
        if (netverifydocumentpart.getScanSide() == NVScanSide.FACE)
        {
            return hp.a;
        } else
        {
            return b.v.getDocumentScanMode().a();
        }
    }

    public void b()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("com.jumio.netverify.sdk.ACTION_CONTROLLER_LOADED");
        intentfilter.addAction("com.jumio.netverify.sdk.ACTION_UPLOAD_FINISHED");
        intentfilter.addAction("com.jumio.netverify.sdk.ACTION_SHOW_ERROR");
        intentfilter.addAction("com.jumio.netverify.sdk.ACTION_SEND_DATA_FINISHED");
        if (b.e)
        {
            r();
        }
        ba.a(b.a).a(i, intentfilter);
    }

    public void c()
    {
        b.b.e();
    }

    public void d()
    {
        b.b.d();
        try
        {
            ((pk)hk.d().a(b.a, "BenchmarkService")).b();
            return;
        }
        catch (Exception exception)
        {
            ab.a(exception);
        }
    }

    public void e()
    {
        d();
        ba.a(b.a).a(i);
    }

    public List f()
    {
        c.clear();
        b.u.clear();
        if (b.F)
        {
            NVScanSide anvscanside[] = b.v.getScanParts(b.s);
            int j1 = anvscanside.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                NVScanSide nvscanside = anvscanside[i1];
                c.add(new NetverifyDocumentPart(nvscanside, a(nvscanside)));
                b.u.append(nvscanside.getPartNumber(), null);
            }

        } else
        {
            c.add(new NetverifyDocumentPart(b.v.getDocumentScanSide(), b.v.getDocumentScanMode()));
        }
        return c;
    }

    public void g()
    {
        a(null, -1, this, true);
    }

    public void h()
    {
        (new Thread(new hb(this))).start();
    }

    public boolean i()
    {
        return b.F;
    }

    public void j()
    {
        he.b[d.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 57
    //                   2 72
    //                   3 131;
           goto _L1 _L2 _L3 _L4
_L1:
        b.b.b();
        b.b.c();
_L6:
        return;
_L2:
        if (f == null) goto _L6; else goto _L5
_L5:
        f.F();
        return;
_L3:
        switch (he.a[e.ordinal()])
        {
        default:
            return;

        case 3: // '\003'
            break;

        case 1: // '\001'
            b.b.c();
            return;

        case 2: // '\002'
            b.b.f();
            break; /* Loop/switch isn't completed */
        }
        if (true) goto _L6; else goto _L7
_L7:
        return;
_L4:
        b.b.g();
        return;
    }

    public void k()
    {
        if (b.F)
        {
            if (!b.g())
            {
                throw new SDKNotConfiguredException("One or more NetverifyDocumentPart objects missing");
            } else
            {
                d = hf.d;
                b.b.g();
                return;
            }
        } else
        {
            h = (int)System.currentTimeMillis();
            ArrayList arraylist = new ArrayList();
            arraylist.add(b.J);
            b.b.a(arraylist, h);
            return;
        }
    }

    public void l()
    {
        this;
        JVM INSTR monitorenter ;
        q();
        b.a.runOnUiThread(new hd(this));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean m()
    {
        int i1;
        boolean flag1;
        flag1 = false;
        b.w = -1;
        i1 = 0;
_L7:
        boolean flag = flag1;
        if (i1 >= b.d().size()) goto _L2; else goto _L1
_L1:
        String s = ((Country)b.d().get(i1)).b();
        if (!b.p || !s.equals(b.l)) goto _L4; else goto _L3
_L3:
        a(i1);
        flag = true;
_L2:
        return flag;
_L4:
        if (!s.equals(b.k.b()))
        {
            break; /* Loop/switch isn't completed */
        }
        a(i1);
        flag = flag1;
        if (!b.p) goto _L2; else goto _L5
_L5:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void n()
    {
        b.v = null;
        if (b.w != -1)
        {
            Country country;
            if (b.q)
            {
                try
                {
                    a(b.m);
                }
                catch (IllegalArgumentException illegalargumentexception1)
                {
                    b.v = null;
                }
            }
            country = b.f();
            if (b.v == null && country.e().size() == 1)
            {
                try
                {
                    a(((DocumentType)country.e().get(0)).getId());
                    return;
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    b.v = null;
                }
                return;
            }
        }
    }

    public void o()
    {
        if (b.v != null)
        {
            b.v.setDocumentVariant(null);
            if (b.r)
            {
                try
                {
                    a(b.o);
                }
                catch (IllegalArgumentException illegalargumentexception1)
                {
                    b.v.setDocumentVariant(null);
                }
            }
            if (!b.v.hasPaperVariant())
            {
                try
                {
                    a(NVDocumentVariant.PLASTIC);
                    return;
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    b.v.setDocumentVariant(null);
                }
                return;
            }
        }
    }

    public boolean p()
    {
        while (b.f() == null || !"DEU".equals(b.f().b()) || b.v.getId() != NVDocumentType.IDENTITY_CARD) 
        {
            return false;
        }
        return true;
    }

    public void q()
    {
        if (b.w != -1 && b.v != null && b.f().b(b.a, b.v))
        {
            b.v.setDocumentScanMode(hq.m);
        }
    }
}
