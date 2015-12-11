// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import java.util.List;

// Referenced classes of package jumiomobile:
//            ki, lm, mk, hr, 
//            ba, mf

public class lo extends ki
{

    public lo()
    {
    }

    public static lo a()
    {
        return new lo();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a.checkOrientation();
        a(mk.a(getActivity(), "actionbar_title_loading"));
        if (bundle == null) goto _L2; else goto _L1
_L1:
        ModelTemplate modeltemplate;
        return;
_L2:
        if (!(modeltemplate = a.getModel()).e) goto _L1; else goto _L3
_L3:
        if (modeltemplate.l == null || modeltemplate.m == null) goto _L5; else goto _L4
_L4:
        int i = 0;
_L8:
        if (i >= modeltemplate.d().size())
        {
            break MISSING_BLOCK_LABEL_239;
        }
        bundle = ((Country)modeltemplate.d().get(i)).b();
        if (!modeltemplate.p || !bundle.equals(modeltemplate.l)) goto _L7; else goto _L6
_L6:
        bundle = (Country)modeltemplate.d().get(i);
_L9:
        DocumentType documenttype;
        if (bundle != null)
        {
            documenttype = bundle.b(modeltemplate.m);
        } else
        {
            documenttype = null;
        }
        if (bundle != null && documenttype != null && (documenttype.isThirdPartyOcrDefined() && bundle.b(getActivity(), documenttype) || !documenttype.isThirdPartyOcrDefined()))
        {
            a.showFragment(hr.b);
            return;
        } else
        {
            ba.a(modeltemplate.a).a(new Intent("com.jumio.netverify.sdk.ACTION_CONTROLLER_LOADED"));
            return;
        }
_L7:
        i++;
          goto _L8
_L5:
        a.showFragment(hr.b);
        return;
        bundle = null;
          goto _L9
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return mf.a(getActivity(), a.getModel().H);
    }
}
