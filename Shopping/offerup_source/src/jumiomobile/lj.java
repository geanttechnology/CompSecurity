// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentType;
import com.jumio.netverify.sdk.enums.NVDocumentVariant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Referenced classes of package jumiomobile:
//            ki, lm, mk, mf, 
//            nu, bg, cv, mh, 
//            lk, cb

public class lj extends ki
{

    private LinearLayout b;

    public lj()
    {
    }

    static LinearLayout a(lj lj1)
    {
        return lj1.b;
    }

    public static lj a()
    {
        return new lj();
    }

    public void onActivityCreated(Bundle bundle)
    {
        int i = 0;
        super.onActivityCreated(bundle);
        a.checkOrientation();
        a(mk.a(getActivity(), "actionbar_title_documentvariant"));
        ModelTemplate modeltemplate = a.getModel();
        bundle = (Country)modeltemplate.d().get(modeltemplate.w);
        Object obj = (nu)getView().findViewById(mf.J);
        if (modeltemplate.L)
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int j = (int)Math.ceil((float)options.outWidth / bg.a(getActivity(), 40F));
            if (j > 1)
            {
                options.inSampleSize = j;
            }
            options.inJustDecodeBounds = false;
            ((nu) (obj)).setLeftImage(cv.a(bundle.b().toLowerCase(Locale.GERMAN), options));
        }
        b = (LinearLayout)getView().findViewById(mf.aB);
        obj = new ArrayList();
        ((List) (obj)).add(NVDocumentVariant.PLASTIC);
        ((List) (obj)).add(NVDocumentVariant.PAPER);
        int k = 0;
        int l = 0;
        while (l < ((List) (obj)).size()) 
        {
            bundle = (NVDocumentVariant)((List) (obj)).get(l);
            ViewGroup viewgroup;
            ImageView imageview;
            TextView textview;
            int i1;
            if (l == 0)
            {
                i = mh.H;
                k = mh.L;
            } else
            if (l == 1)
            {
                i = mh.J;
                k = mh.N;
            } else
            {
                int j1 = k;
                k = i;
                i = j1;
            }
            viewgroup = mf.b(getActivity(), i, k);
            imageview = (ImageView)viewgroup.findViewById(mf.aC);
            textview = (TextView)viewgroup.findViewById(mf.aD);
            viewgroup.setOnClickListener(new lk(this, bundle));
            if (bundle.equals(NVDocumentVariant.PAPER))
            {
                if (modeltemplate.v.getId().equals(NVDocumentType.DRIVER_LICENSE))
                {
                    i = mh.v;
                    bundle = "documentvariant_paper_driverlicense";
                } else
                {
                    i = mh.t;
                    bundle = "documentvariant_paper_idcard";
                }
            } else
            if (bundle.equals(NVDocumentVariant.PLASTIC))
            {
                if (modeltemplate.v.getId().equals(NVDocumentType.DRIVER_LICENSE))
                {
                    bundle = "documentvariant_plastic_driverlicense";
                } else
                {
                    bundle = "documentvariant_plastic_idcard";
                }
                i = mh.u;
            } else
            {
                bundle = "";
            }
            imageview.setImageBitmap(mh.a(getResources(), i));
            textview.setText(mk.a(getActivity(), bundle));
            b.addView(viewgroup);
            i1 = l + 1;
            l = k;
            k = i;
            i = l;
            l = i1;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return mf.e(getActivity(), a.getModel().H);
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        cb.d();
        super.onResume();
        b.setEnabled(true);
    }
}
