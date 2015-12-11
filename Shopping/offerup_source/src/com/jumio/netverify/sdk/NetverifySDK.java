// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.jumio.mobile.sdk.enums.JumioCameraPosition;
import com.jumio.mobile.sdk.enums.JumioDataCenter;
import com.jumio.mobile.sdk.environment.Environment;
import com.jumio.netverify.sdk.activity.NetverifyActivity;
import com.jumio.netverify.sdk.core.NetverifyModel;
import com.jumio.netverify.sdk.custom.NetverifyCustomSDKController;
import com.jumio.netverify.sdk.custom.NetverifyCustomSDKInterface;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentVariant;
import java.util.ArrayList;
import jumiomobile.ba;
import jumiomobile.cc;
import jumiomobile.ch;
import jumiomobile.cj;
import jumiomobile.cl;
import jumiomobile.cn;
import jumiomobile.cs;
import jumiomobile.g;
import jumiomobile.ge;
import jumiomobile.ha;
import jumiomobile.hh;
import jumiomobile.hk;
import jumiomobile.on;

public final class NetverifySDK extends cc
{

    public static int REQUEST_CODE = 0;
    public static final int RESULT_CODE_BACK_WITH_SUCCESS = 102;
    public static final int RESULT_CODE_CANCEL = 101;
    public static final int RESULT_CODE_SUCCESS = 100;
    public static final String RESULT_DATA_ERROR_CODE = "errorCode";
    public static final String RESULT_DATA_ERROR_MESSAGE = "errorMessage";
    public static final String RESULT_DATA_SCAN_DATA = "scanData";
    public static final String RESULT_DATA_SCAN_REFERENCE = "scanReference";
    private static NetverifySDK a;
    private NetverifyModel b;
    private Activity c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private ArrayList i;
    private NVDocumentVariant j;
    private String k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private String r;
    private String s;

    private NetverifySDK(Activity activity, String s1, String s2, JumioDataCenter jumiodatacenter)
    {
        d = "";
        e = "";
        f = "";
        g = "";
        h = "";
        i = null;
        j = null;
        k = "";
        l = false;
        m = false;
        n = false;
        o = true;
        p = false;
        q = false;
        r = "";
        if (activity == null)
        {
            throw new NullPointerException("rootActivity is null");
        } else
        {
            checkSDKRequirements();
            checkResource(activity, "com.jumio.netverify.resources.NVImageResources", "NetverifyResources");
            hk.b(activity);
            c = activity;
            b = NetverifyModel.a(new ge(this, null));
            b.a = activity;
            b.g = s1;
            b.h = s2;
            b.O = jumiodatacenter;
            b.b = new hh(b);
            b.e = false;
            Environment.checkOcrVersion(activity);
            return;
        }
    }

    private static void a()
    {
        com/jumio/netverify/sdk/NetverifySDK;
        JVM INSTR monitorenter ;
        a = null;
        com/jumio/netverify/sdk/NetverifySDK;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void b()
    {
        boolean flag1 = false;
        b.c();
        if (i == null)
        {
            i = new ArrayList();
        }
        if (i.size() == 0)
        {
            i.add(NVDocumentType.PASSPORT);
            i.add(NVDocumentType.VISA);
            i.add(NVDocumentType.IDENTITY_CARD);
            i.add(NVDocumentType.DRIVER_LICENSE);
        }
        b.l = h;
        NetverifyModel netverifymodel = b;
        boolean flag;
        if (h.length() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        netverifymodel.p = flag;
        if (i.size() == 1)
        {
            b.m = (NVDocumentType)i.get(0);
        }
        b.n = i;
        netverifymodel = b;
        if (b.m != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        netverifymodel.q = flag;
        b.o = j;
        netverifymodel = b;
        if (j != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        netverifymodel.r = flag;
        netverifymodel = b;
        if (l && jumiomobile.g.a(c))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        netverifymodel.s = flag;
        b.t = m;
        b.x = k;
        b.y = d;
        b.z = e;
        b.A = f;
        b.B = g;
        b.f = true;
        b.b.a();
        b.F = n;
        b.E = s;
        b.L = o;
        b.M = p;
        b.i = r;
        netverifymodel = b;
        if (n)
        {
            flag = flag1;
        } else
        {
            flag = q;
        }
        netverifymodel.N = flag;
        hk.b(c);
    }

    public static NetverifySDK create(Activity activity, String s1, String s2, JumioDataCenter jumiodatacenter)
    {
        com/jumio/netverify/sdk/NetverifySDK;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new NetverifySDK(activity, s1, s2, jumiodatacenter);
        }
        NetverifySDK netverifysdk = a;
        netverifysdk.getClass();
        if (NetverifyModel.a(new ge(netverifysdk, null)).a == null)
        {
            a();
            a = new NetverifySDK(activity, s1, s2, jumiodatacenter);
        }
        activity = a;
        com/jumio/netverify/sdk/NetverifySDK;
        JVM INSTR monitorexit ;
        return activity;
        activity;
        throw activity;
    }

    public final void destroy()
    {
        this;
        JVM INSTR monitorenter ;
        ba.a();
        NetverifyModel.a();
        a();
        super.destroy();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final Intent getIntent()
    {
        b();
        return new Intent(c, com/jumio/netverify/sdk/activity/NetverifyActivity);
    }

    public final void setCallbackUrl(String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        if (!(new on(new String[] {
    "https"
}, false, false, false, false)).a(s2) || s2.length() > 255)
        {
            Log.w("NetverifySDK", "The provided callback url is not valid!");
            return;
        } else
        {
            r = s2;
            return;
        }
    }

    public final void setCameraPosition(JumioCameraPosition jumiocameraposition)
    {
        boolean flag;
        if (jumiocameraposition == JumioCameraPosition.FRONT)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        p = flag;
    }

    public final void setCustomerId(String s1)
    {
        if (s1 != null) goto _L2; else goto _L1
_L1:
        String s2 = "";
_L4:
        g = s2;
        return;
_L2:
        s2 = s1;
        if (s1.length() > 100)
        {
            s2 = s1.substring(0, 100);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void setDataExtractionOnMobileOnly(boolean flag)
    {
        q = flag;
    }

    public final void setFirstAndLastName(String s1, String s2)
    {
        String s3;
        boolean flag;
        boolean flag1;
        if (s1 == null)
        {
            s3 = "";
        } else
        {
            s3 = s1;
            if (s1.length() > 100)
            {
                s3 = s1.substring(0, 100);
            }
        }
        if (s2 == null)
        {
            s1 = "";
        } else
        {
            s1 = s2;
            if (s2.length() > 100)
            {
                s1 = s2.substring(0, 100);
            }
        }
        s2 = s3.trim();
        s1 = s1.trim();
        flag = s2.equals("");
        flag1 = s1.equals("");
        if (!flag && !flag1)
        {
            e = s2;
            f = s1;
            return;
        } else
        {
            e = "";
            f = "";
            return;
        }
    }

    public final void setMerchantReportingCriteria(String s1)
    {
        if (s1 != null) goto _L2; else goto _L1
_L1:
        String s2 = "";
_L4:
        d = s2;
        return;
_L2:
        s2 = s1;
        if (s1.length() > 100)
        {
            s2 = s1.substring(0, 100);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void setMerchantScanReference(String s1)
    {
        if (s1 != null) goto _L2; else goto _L1
_L1:
        String s2 = "";
_L4:
        k = s2;
        return;
_L2:
        s2 = s1;
        if (s1.length() > 100)
        {
            s2 = s1.substring(0, 100);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void setName(String s1)
    {
        s = s1;
    }

    public final void setPreselectedCountry(String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        h = s2;
    }

    public final void setPreselectedDocumentTypes(ArrayList arraylist)
    {
        i = new ArrayList();
        if (arraylist != null && arraylist.size() != 0)
        {
            i.addAll(arraylist);
        }
    }

    public final void setPreselectedDocumentVariant(NVDocumentVariant nvdocumentvariant)
    {
        j = nvdocumentvariant;
    }

    public final void setRequireFaceMatch(boolean flag)
    {
        m = true;
        l = flag;
    }

    public final void setRequireVerification(boolean flag)
    {
        n = flag;
    }

    public final void setShowFlagOnInfoBar(boolean flag)
    {
        o = flag;
    }

    public final NetverifyCustomSDKController start(NetverifyCustomSDKInterface netverifycustomsdkinterface)
    {
        b();
        ch.a(new cj());
        cl.a(new cn());
        netverifycustomsdkinterface = new ha(b, netverifycustomsdkinterface);
        netverifycustomsdkinterface.b();
        return new NetverifyCustomSDKController(netverifycustomsdkinterface);
    }

    public final void start()
    {
        if (cs.a())
        {
            cs.a(cs.a(c, ""), String.format("logcat_nv_%d.log", new Object[] {
                Long.valueOf(System.currentTimeMillis())
            }));
        }
        c.startActivityForResult(getIntent(), REQUEST_CODE);
    }

    static 
    {
        REQUEST_CODE = 200;
    }
}
