// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.jumio.netverify.sdk.custom.NetverifyCustomScanView;
import com.jumio.netverify.sdk.custom.NetverifyCustomScanViewInterface;

// Referenced classes of package jumiomobile:
//            ki, ll, gm, kl, 
//            bq, lm, hq, hp, 
//            mf, ko, km, by, 
//            kk, ht

public abstract class kj extends ki
    implements NetverifyCustomScanViewInterface, ll
{

    protected RelativeLayout b;
    protected bq c;
    protected bq d;
    protected ImageView e;
    protected ImageView f;
    protected by g;
    protected int h;
    protected boolean i;

    public kj()
    {
        h = 0;
    }

    public void a(Runnable runnable)
    {
        if (isResumed())
        {
            getActivity().runOnUiThread(runnable);
        }
    }

    protected void a(boolean flag)
    {
        ActionBar actionbar;
label0:
        {
            if (getActivity() instanceof AppCompatActivity)
            {
                getActivity();
                actionbar = ((AppCompatActivity)getActivity()).getSupportActionBar();
                if (actionbar != null)
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    actionbar.show();
                }
            }
            return;
        }
        actionbar.hide();
    }

    public boolean a(ht ht)
    {
        return false;
    }

    protected abstract gm b();

    public boolean c()
    {
        return false;
    }

    public boolean d()
    {
        return false;
    }

    public void e()
    {
        if (b().o() && f != null)
        {
            a(new kl(this));
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        boolean flag = true;
        super.onActivityCreated(bundle);
        if (!b().q())
        {
            if (getResources().getConfiguration().orientation != 1)
            {
                flag = false;
            }
            a(flag);
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        boolean flag = true;
        super.onConfigurationChanged(configuration);
        if (!b().q())
        {
            if (configuration.orientation != 1)
            {
                flag = false;
            }
            a(flag);
        }
        if (b().i())
        {
            d.performClick();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a.registerActivityCallback(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a.getModel();
        layoutinflater = (hq)getArguments().getSerializable("Mode");
        viewgroup = (hp)getArguments().getSerializable("Format");
        boolean flag = getArguments().getBoolean("SaveImage", false);
        bundle = mf.b(getActivity());
        b = (RelativeLayout)bundle.findViewById(mf.d);
        c = (bq)bundle.findViewById(mf.Z);
        c.setOnImageSwitchedListener(new ko(this, null));
        d = (bq)bundle.findViewById(mf.aa);
        d.setOnImageSwitchedListener(new km(this, null));
        g = new by(d);
        f = (ImageView)bundle.findViewById(mf.Y);
        b().a((NetverifyCustomScanView)b.findViewById(mf.S), layoutinflater, viewgroup, this, flag);
        e = (ImageView)bundle.findViewById(mf.m);
        return bundle;
    }

    public void onDestroyView()
    {
        b().g();
        super.onDestroyView();
    }

    public void onNetverifyCameraAvailable()
    {
        byte byte0 = 8;
        boolean flag = true;
        if (b().h() && g != null)
        {
            b().a(g);
        }
        e();
        Object obj = b().s();
        int j;
        boolean flag1;
        if (obj != hq.j && obj != hq.k && obj != hq.g && b().l())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj = c;
        if (flag1)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((bq) (obj)).setVisibility(j);
        c.setEnabled(flag1);
        obj = c;
        if (b().m())
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        ((bq) (obj)).a(j);
        obj = d;
        j = byte0;
        if (b().h())
        {
            j = 0;
        }
        ((bq) (obj)).setVisibility(j);
        d.a(0);
    }

    public void onNetverifyExtractionStarted()
    {
        a(new kk(this));
    }

    public void onPause()
    {
        b().f();
        d.a(0);
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        b().e();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        b().d();
    }
}
