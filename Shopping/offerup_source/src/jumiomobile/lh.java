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
import java.util.Collections;
import java.util.List;
import java.util.Locale;

// Referenced classes of package jumiomobile:
//            ki, lm, mk, mf, 
//            nu, bg, cv, mh, 
//            li, cb

public class lh extends ki
{

    private LinearLayout b;

    public lh()
    {
    }

    static LinearLayout a(lh lh1)
    {
        return lh1.b;
    }

    public static lh a()
    {
        return new lh();
    }

    public void onActivityCreated(Bundle bundle)
    {
        Object obj;
        int l;
        int i1;
        super.onActivityCreated(bundle);
        a.checkOrientation();
        a(mk.a(getActivity(), "actionbar_title_documenttype"));
        ModelTemplate modeltemplate = a.getModel();
        bundle = (Country)modeltemplate.d().get(modeltemplate.w);
        obj = (nu)getView().findViewById(mf.J);
        if (modeltemplate.L)
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int i = (int)Math.ceil((float)options.outWidth / bg.a(getActivity(), 40F));
            if (i > 1)
            {
                options.inSampleSize = i;
            }
            options.inJustDecodeBounds = false;
            ((nu) (obj)).setLeftImage(cv.a(bundle.b().toLowerCase(Locale.GERMAN), options));
        }
        b = (LinearLayout)getView().findViewById(mf.n);
        obj = bundle.e();
        i1 = ((List) (obj)).size();
        Collections.sort(((List) (obj)));
        l = 0;
_L7:
        if (l >= i1) goto _L2; else goto _L1
_L1:
        DocumentType documenttype;
        int j;
        documenttype = (DocumentType)((List) (obj)).get(l);
        int k;
        if (l == 0)
        {
            ViewGroup viewgroup;
            ImageView imageview;
            TextView textview;
            if (i1 > 1)
            {
                j = mh.H;
            } else
            {
                j = mh.G;
            }
            if (i1 > 1)
            {
                k = mh.L;
            } else
            {
                k = mh.K;
            }
        } else
        if (l == i1 - 1)
        {
            j = mh.J;
            k = mh.N;
        } else
        {
            j = mh.I;
            k = mh.M;
        }
        viewgroup = mf.a(getActivity(), j, k);
        imageview = (ImageView)viewgroup.findViewById(mf.o);
        textview = (TextView)viewgroup.findViewById(mf.p);
        viewgroup.setOnClickListener(new li(this, bundle, documenttype.getId()));
        if (!documenttype.getId().equals(NVDocumentType.PASSPORT)) goto _L4; else goto _L3
_L3:
        if (bundle.b().equals("USA"))
        {
            j = mh.l;
        } else
        if (bundle.b().equals("RUS"))
        {
            j = mh.m;
        } else
        {
            j = mh.k;
        }
_L5:
        imageview.setImageBitmap(mh.a(getResources(), j));
        textview.setText(documenttype.getName(getActivity()));
        b.addView(viewgroup);
        l++;
        continue; /* Loop/switch isn't completed */
_L4:
        if (documenttype.getId().equals(NVDocumentType.VISA))
        {
            j = mh.n;
        } else
        if (documenttype.getId().equals(NVDocumentType.IDENTITY_CARD))
        {
            if (bundle.b().equals("USA"))
            {
                j = mh.p;
            } else
            if (bundle.b().equals("MEX"))
            {
                j = mh.q;
            } else
            {
                j = mh.o;
            }
        } else
        if (documenttype.getId().equals(NVDocumentType.DRIVER_LICENSE))
        {
            if (bundle.b().equals("USA"))
            {
                j = mh.s;
            } else
            {
                j = mh.r;
            }
        }
        if (true) goto _L5; else goto _L2
_L2:
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return mf.d(getActivity(), a.getModel().H);
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
