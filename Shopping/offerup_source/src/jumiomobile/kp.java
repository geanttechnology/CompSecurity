// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;

// Referenced classes of package jumiomobile:
//            ki, jw, lm, ha, 
//            hr, mk, mf, kq, 
//            kr, cb, cv

public class kp extends ki
    implements jw
{

    private ViewGroup b;
    private TextView c;
    private ViewGroup d;
    private ImageView e;
    private TextView f;

    public kp()
    {
    }

    public static kp a()
    {
        return new kp();
    }

    public void l()
    {
        a.getController().q();
        a.showFragment(hr.d);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a.checkOrientation();
        a(mk.a(getActivity(), "actionbar_title_country"));
        d = (ViewGroup)getView().findViewById(mf.f);
        d.setOnClickListener(new kq(this));
        e = (ImageView)getView().findViewById(mf.g);
        f = (TextView)getView().findViewById(mf.i);
        c = (TextView)getView().findViewById(mf.l);
        b = (ViewGroup)getView().findViewById(mf.k);
        b.setOnClickListener(new kr(this));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return mf.b(getActivity(), a.getModel().H);
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        cb.c();
        super.onResume();
        b.setEnabled(true);
        Object obj = a.getModel();
        if (((ModelTemplate) (obj)).w != -1)
        {
            obj = ((ModelTemplate) (obj)).f();
            android.graphics.Bitmap bitmap = cv.a(((Country) (obj)).b());
            if (bitmap != null)
            {
                e.setImageBitmap(bitmap);
            }
            f.setVisibility(0);
            f.setText(((Country) (obj)).c());
            c.setText(mk.a(getActivity(), "button_select_another_country"));
            return;
        } else
        {
            f.setVisibility(8);
            c.setText(mk.a(getActivity(), "button_select_country"));
            return;
        }
    }
}
