// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.DocumentType;

// Referenced classes of package jumiomobile:
//            lp, lm, ma, ha, 
//            hq, kt

final class md
    implements android.view.View.OnClickListener
{

    final lp a;
    private ma b;

    public md(lp lp1, ma ma1)
    {
        a = lp1;
        super();
        b = ma1;
    }

    public final void onClick(View view)
    {
        a.a.showFragment(kt.a(a.a.getController().a(b.a), a.a.getModel().v.getDocumentScanMode().a(), b.a, true));
    }
}
