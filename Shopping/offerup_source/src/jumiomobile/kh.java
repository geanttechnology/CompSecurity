// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.jumio.netverify.barcode.enums.BarcodeFormat;
import com.jumio.netverify.sdk.core.ModelTemplate;

// Referenced classes of package jumiomobile:
//            kj, hq, mk, gl, 
//            mt, lm, ha, mf, 
//            cs, gm

public final class kh extends kj
{

    private gl j;

    public kh()
    {
    }

    public static kh a()
    {
        kh kh1 = new kh();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Mode", hq.g);
        bundle.putBoolean("SaveImage", false);
        kh1.setArguments(bundle);
        return kh1;
    }

    protected final gm b()
    {
        return j;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a(mk.a(getActivity(), "actionbar_title_barcode"));
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        flag = false;
        super.onConfigurationChanged(configuration);
        if (j.q()) goto _L2; else goto _L1
_L1:
        int i;
        boolean flag2;
        if (configuration.orientation == 1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        j.x().a(flag2);
        if (!a.getModel().H)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        i = ((flag1) ? 1 : 0);
        if (!flag2)
        {
            if (!j.q())
            {
                break MISSING_BLOCK_LABEL_104;
            }
            i = ((flag1) ? 1 : 0);
        }
_L3:
        configuration = e;
        if (i != 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        configuration.setVisibility(i);
_L2:
        return;
        i = 0;
          goto _L3
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        j = a.getController().a(a);
        j.z();
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (RelativeLayout)super.onCreateView(layoutinflater, viewgroup, bundle);
        mf.a(getActivity(), layoutinflater);
        j.a(layoutinflater);
        cs.a(a.getModel().K.name());
        return layoutinflater;
    }

    public final void onNetverifyNoUSAddressFound()
    {
    }

    public final void onNetverifyPresentConfirmationView()
    {
    }
}
