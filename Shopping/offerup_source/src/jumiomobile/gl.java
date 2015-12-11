// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.custom.NetverifyCustomSDKInterface;
import com.jumio.netverify.sdk.custom.NetverifyDocumentPart;

// Referenced classes of package jumiomobile:
//            gm, mf, mt, lm

public class gl extends gm
{

    private String t;
    private lm u;

    public gl(ModelTemplate modeltemplate, NetverifyDocumentPart netverifydocumentpart, NetverifyCustomSDKInterface netverifycustomsdkinterface, lm lm1)
    {
        super(modeltemplate, netverifydocumentpart, netverifycustomsdkinterface);
        u = lm1;
    }

    public void a(RelativeLayout relativelayout)
    {
        a = (mt)relativelayout.findViewById(mf.U);
    }

    public void a(String s)
    {
        t = s;
    }

    public void b()
    {
        super.b();
        c();
    }

    public void c()
    {
        Intent intent = new Intent();
        intent.putExtra("barcodeFormat", m.K);
        intent.putExtra("barcodeData", t);
        u.finishSDK(intent, 100);
    }
}
