// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.jumio.netverify.sdk.core.ModelTemplate;
import com.jumio.netverify.sdk.core.vo.Country;
import com.jumio.netverify.sdk.core.vo.DocumentType;
import com.jumio.netverify.sdk.custom.NetverifyCustomConfirmationView;
import com.jumio.netverify.sdk.custom.NetverifyDocumentPart;
import com.jumio.netverify.sdk.custom.SDKNotConfiguredException;
import com.jumio.netverify.sdk.enums.NVScanSide;
import java.util.List;

// Referenced classes of package jumiomobile:
//            kj, gs, lm, id, 
//            nu, hq, mf, ky, 
//            kz, la, lb, bq, 
//            gm, mt, ha, ab, 
//            lc, le, bg, cv, 
//            ku, kx, kv, hp

public final class kt extends kj
{

    private nu j;
    private ScrollView k;
    private RelativeLayout l;
    private RelativeLayout m;
    private boolean n;
    private Runnable o;
    private boolean p;
    private gs q;

    public kt()
    {
        n = false;
        o = null;
    }

    public static Fragment a(hq hq1, hp hp, NVScanSide nvscanside, boolean flag)
    {
        kt kt1 = new kt();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Mode", hq1);
        bundle.putSerializable("Side", nvscanside);
        bundle.putSerializable("Format", hp);
        bundle.putBoolean("SaveImage", flag);
        kt1.setArguments(bundle);
        return kt1;
    }

    static Runnable a(kt kt1, Runnable runnable)
    {
        kt1.o = runnable;
        return runnable;
    }

    static nu a(kt kt1)
    {
        return kt1.j;
    }

    private void a()
    {
        NVScanSide nvscanside = q.I();
        j.setText(Html.fromHtml(q.y().a(a.getModel().v.getId(), nvscanside)));
    }

    private void a(View view, int i)
    {
        if (i < 50)
        {
            view.setAlpha(0.0F);
            return;
        } else
        {
            view.animate().alpha(0.0F).setDuration(i).setListener(null);
            return;
        }
    }

    private void a(hq hq1)
    {
        if (hq1.equals(hq.k) && !q.q())
        {
            getActivity().setRequestedOrientation(1);
            return;
        } else
        {
            q.z();
            return;
        }
    }

    static void a(kt kt1, View view, int i)
    {
        kt1.a(view, i);
    }

    static void a(kt kt1, hq hq1)
    {
        kt1.a(hq1);
    }

    static void a(kt kt1, boolean flag)
    {
        kt1.g(flag);
    }

    static gs b(kt kt1)
    {
        return kt1.q;
    }

    private void b(View view, int i)
    {
        if (i < 50)
        {
            view.setAlpha(1.0F);
            return;
        } else
        {
            view.animate().alpha(1.0F).setDuration(i).setListener(null);
            return;
        }
    }

    static void b(kt kt1, View view, int i)
    {
        kt1.b(view, i);
    }

    static boolean b(kt kt1, boolean flag)
    {
        kt1.n = flag;
        return flag;
    }

    static RelativeLayout c(kt kt1)
    {
        return kt1.m;
    }

    static boolean d(kt kt1)
    {
        return kt1.n;
    }

    static ScrollView e(kt kt1)
    {
        return kt1.k;
    }

    private void e(boolean flag)
    {
        q.y().a(getActivity(), k, flag);
    }

    private void f()
    {
        float f3 = 1.0F;
        Object obj = k;
        float f1;
        float f2;
        Object obj1;
        Object obj2;
        AnimatorSet animatorset;
        int i;
        int i1;
        if (n)
        {
            f1 = -b.getHeight() + j.getCurrentHeight();
        } else
        {
            f1 = 0.0F;
        }
        if (n)
        {
            f2 = 0.0F;
        } else
        {
            f2 = -b.getHeight() + j.getCurrentHeight();
        }
        obj = ObjectAnimator.ofFloat(obj, "translationY", new float[] {
            f1, f2
        });
        ((ObjectAnimator) (obj)).setDuration(400L);
        ((ObjectAnimator) (obj)).setInterpolator(new AccelerateDecelerateInterpolator());
        obj1 = l;
        if (n)
        {
            f1 = 0.0F;
        } else
        {
            f1 = 1.0F;
        }
        if (n)
        {
            f2 = f3;
        } else
        {
            f2 = 0.0F;
        }
        obj1 = ObjectAnimator.ofFloat(obj1, "alpha", new float[] {
            f1, f2
        });
        ((ObjectAnimator) (obj1)).setDuration(200L);
        ((ObjectAnimator) (obj1)).setInterpolator(new AccelerateDecelerateInterpolator());
        obj2 = new ArgbEvaluator();
        if (n)
        {
            i = mf.a;
        } else
        {
            i = mf.b;
        }
        if (n)
        {
            i1 = mf.b;
        } else
        {
            i1 = mf.a;
        }
        obj2 = ValueAnimator.ofObject(((android.animation.TypeEvaluator) (obj2)), new Object[] {
            Integer.valueOf(i), Integer.valueOf(i1)
        });
        ((ValueAnimator) (obj2)).setDuration(400L);
        ((ValueAnimator) (obj2)).setInterpolator(new AccelerateDecelerateInterpolator());
        ((ValueAnimator) (obj2)).addUpdateListener(new ky(this));
        animatorset = new AnimatorSet();
        animatorset.addListener(new kz(this));
        if (n)
        {
            animatorset.play(((android.animation.Animator) (obj))).with(((android.animation.Animator) (obj2))).before(((android.animation.Animator) (obj1)));
        } else
        {
            animatorset.play(((android.animation.Animator) (obj))).with(((android.animation.Animator) (obj2))).after(((android.animation.Animator) (obj1)));
        }
        animatorset.start();
    }

    static void f(kt kt1)
    {
        kt1.f();
    }

    private void f(boolean flag)
    {
        int i = 0;
        boolean flag2 = p;
        boolean flag1 = flag2;
        if (flag)
        {
            flag1 = flag2;
            if (!q.q())
            {
                flag1 = false;
            }
        }
        if (!a.getModel().H)
        {
            flag1 = false;
        }
        if (e != null)
        {
            ImageView imageview = e;
            if (!flag1)
            {
                i = 8;
            }
            imageview.setVisibility(i);
        }
    }

    static Runnable g(kt kt1)
    {
        return kt1.o;
    }

    private void g(boolean flag)
    {
        float f2 = 0.0F;
        float f1;
        ObjectAnimator objectanimator;
        ValueAnimator valueanimator;
        AnimatorSet animatorset;
        int i;
        int i1;
        if (flag)
        {
            f1 = -b.getHeight() + j.getCurrentHeight();
        } else
        {
            f1 = 0.0F;
        }
        if (!flag)
        {
            f2 = -b.getHeight() + j.getCurrentHeight();
        }
        objectanimator = ObjectAnimator.ofFloat(m, "translationY", new float[] {
            f1, f2
        });
        objectanimator.setDuration(400L);
        objectanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        if (flag)
        {
            i = mf.a;
        } else
        {
            i = mf.c;
        }
        if (flag)
        {
            i1 = mf.c;
        } else
        {
            i1 = mf.a;
        }
        valueanimator = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[] {
            Integer.valueOf(i), Integer.valueOf(i1)
        });
        valueanimator.setDuration(400L);
        valueanimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueanimator.addUpdateListener(new la(this));
        animatorset = new AnimatorSet();
        if (!flag)
        {
            animatorset.addListener(new lb(this));
        }
        animatorset.play(objectanimator).with(valueanimator);
        animatorset.start();
    }

    static void h(kt kt1)
    {
        kt1.a();
    }

    protected final void a(boolean flag)
    {
        j.b(flag);
        super.a(flag);
    }

    protected final gm b()
    {
        return q;
    }

    public final void b(boolean flag)
    {
label0:
        {
            int i = 0;
            if (!q.h())
            {
                flag = false;
            }
            if (d != null)
            {
                bq bq1 = d;
                if (!flag)
                {
                    i = 8;
                }
                bq1.setVisibility(i);
                d.setEnabled(flag);
                if (!flag)
                {
                    break label0;
                }
                b().a(g);
            }
            return;
        }
        b().k();
    }

    public final void c(boolean flag)
    {
        boolean flag1 = false;
        hq hq1 = q.s();
        int i;
        if (flag && hq1 != hq.j && hq1 != hq.k && hq1 != hq.g && q.l())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (c != null)
        {
            bq bq1 = c;
            if (i != 0)
            {
                i = ((flag1) ? 1 : 0);
            } else
            {
                i = 8;
            }
            bq1.setVisibility(i);
            c.setEnabled(flag);
        }
    }

    public final void d(boolean flag)
    {
        p = flag;
        f(q.r());
    }

    public final void onActivityCreated(Bundle bundle)
    {
        boolean flag = true;
        super.onActivityCreated(bundle);
        if (getActivity() instanceof AppCompatActivity)
        {
            a(q.a(getActivity()));
        }
        if (!q.q())
        {
            if (getResources().getConfiguration().orientation != 1)
            {
                flag = false;
            }
            e(flag);
        }
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        boolean flag1 = true;
        super.onConfigurationChanged(configuration);
        boolean flag;
        if (configuration.orientation == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!q.q())
        {
            e(flag);
            mf.a(getActivity(), m, flag);
            if (flag)
            {
                flag1 = false;
            }
            f(flag1);
            if (q.x() != null)
            {
                q.x().a(flag);
            }
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (a.getModel() == null)
        {
            return;
        }
        bundle = (hq)getArguments().getSerializable("Mode");
        NetverifyDocumentPart netverifydocumentpart = new NetverifyDocumentPart((NVScanSide)getArguments().getSerializable("Side"), bundle);
        try
        {
            q = a.getController().a(netverifydocumentpart);
            a(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            ab.a(bundle);
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (RelativeLayout)super.onCreateView(layoutinflater, viewgroup, bundle);
        viewgroup = a.getModel();
        bundle = q.s();
        mf.a(getActivity(), layoutinflater, ((ModelTemplate) (viewgroup)).v.getId(), bundle);
        m = (RelativeLayout)layoutinflater.findViewById(mf.an);
        q.a((NetverifyCustomConfirmationView)m.findViewById(mf.av));
        q.I();
        j = (nu)layoutinflater.findViewById(mf.J);
        q.a(j);
        q.a((RelativeLayout)layoutinflater.findViewById(mf.V));
        k = (ScrollView)layoutinflater.findViewById(mf.ac);
        l = (RelativeLayout)layoutinflater.findViewById(mf.ad);
        bundle = (Button)layoutinflater.findViewById(mf.al);
        if (q.D())
        {
            bundle.setVisibility(0);
            bundle.setOnClickListener(new lc(this, null));
        }
        j.setHelpButtonClickListener(new le(this, null));
        if (((ModelTemplate) (viewgroup)).L)
        {
            viewgroup = (Country)viewgroup.d().get(((ModelTemplate) (viewgroup)).w);
            bundle = new android.graphics.BitmapFactory.Options();
            bundle.inJustDecodeBounds = true;
            int i = (int)Math.ceil((float)((android.graphics.BitmapFactory.Options) (bundle)).outWidth / bg.a(getActivity(), 40F));
            if (i > 1)
            {
                bundle.inSampleSize = i;
            }
            bundle.inJustDecodeBounds = false;
            viewgroup = cv.a(viewgroup.b(), bundle);
            j.setLeftImage(viewgroup);
        }
        if (c != null)
        {
            c.bringToFront();
        }
        if (d != null)
        {
            d.bringToFront();
        }
        if (e != null)
        {
            e.bringToFront();
        }
        return layoutinflater;
    }

    public final void onDestroyView()
    {
        super.onDestroyView();
    }

    public final void onNetverifyExtractionStarted()
    {
        super.onNetverifyExtractionStarted();
        q.A();
        a(new ku(this));
    }

    public final void onNetverifyNoUSAddressFound()
    {
        a(new kx(this));
    }

    public final void onNetverifyPresentConfirmationView()
    {
        q.z();
        a(new kv(this));
    }

    public final void onPause()
    {
        if (j != null)
        {
            j.a(false);
        }
        if (q != null)
        {
            q.z();
        }
        super.onPause();
    }

    public final void onResume()
    {
        super.onResume();
        if (j != null)
        {
            j.a(true);
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        a();
    }
}
