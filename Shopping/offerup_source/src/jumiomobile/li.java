// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;
import android.widget.LinearLayout;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.enums.NVDocumentType;

// Referenced classes of package jumiomobile:
//            jw, lh, lm, ha, 
//            hr, mf

class li
    implements android.view.View.OnClickListener, jw
{

    Country a;
    NVDocumentType b;
    final lh c;

    public li(lh lh1, Country country, NVDocumentType nvdocumenttype)
    {
        c = lh1;
        super();
        a = country;
        b = nvdocumenttype;
    }

    public void l()
    {
        c.a.getController().q();
        c.a.showFragment(hr.e);
    }

    public void onClick(View view)
    {
        lh.a(c).setEnabled(false);
        c.a.getController().a(b);
        c.a.getController().a(view, mf.q, this, c.a.isScanViewNext(hr.e));
    }
}
