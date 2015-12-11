// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;
import android.widget.LinearLayout;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentVariant;

// Referenced classes of package jumiomobile:
//            jw, lj, lm, ha, 
//            hr, hq, kt, mf

class lk
    implements android.view.View.OnClickListener, jw
{

    NVDocumentVariant a;
    final lj b;

    public lk(lj lj1, NVDocumentVariant nvdocumentvariant)
    {
        b = lj1;
        super();
        a = nvdocumentvariant;
    }

    public void l()
    {
        b.a.getController().q();
        DocumentType documenttype = b.a.getModel().v;
        if (b.a.getModel().F)
        {
            b.a.showFragment(hr.g);
            return;
        } else
        {
            b.a.showFragment(kt.a(documenttype.getDocumentScanMode(), documenttype.getDocumentScanMode().a(), documenttype.getDocumentScanSide(), false));
            return;
        }
    }

    public void onClick(View view)
    {
        lj.a(b).setEnabled(false);
        b.a.getController().a(a);
        ha ha1 = b.a.getController();
        int i = mf.aE;
        lm lm1 = b.a;
        hr hr1;
        if (b.a.getModel().F)
        {
            hr1 = hr.g;
        } else
        {
            hr1 = hr.f;
        }
        ha1.a(view, i, this, lm1.isScanViewNext(hr1));
    }
}
