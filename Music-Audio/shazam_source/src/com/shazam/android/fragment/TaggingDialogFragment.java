// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment;

import android.animation.AnimatorSet;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v4.app.h;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import at.markushi.ui.RevealColorView;
import com.shazam.android.analytics.TaggingOutcome;
import com.shazam.android.aspects.c.b.a;
import com.shazam.android.ay.a.q;
import com.shazam.android.f.b;
import com.shazam.android.view.tagging.BlueCircleProtectionView;
import com.shazam.android.view.tagging.TaggingButtonView;
import com.shazam.android.view.tagging.TaggingShardsView;
import com.shazam.android.widget.tagging.i;
import com.shazam.i.b.ar.a.e;
import com.shazam.i.b.c;

// Referenced classes of package com.shazam.android.fragment:
//            h, TransitionParams, i

public class TaggingDialogFragment extends a
    implements com.shazam.android.fragment.h, i
{

    public static final String aj = (new StringBuilder()).append(com/shazam/android/fragment/TaggingDialogFragment.getName()).append(".TAG").toString();
    private final q ak = com.shazam.i.b.ar.a.e.a();
    private final android.support.v4.a.e al = android.support.v4.a.e.a(com.shazam.i.b.c.a());
    private final com.shazam.android.widget.d.a am = com.shazam.i.b.ay.b.a.a();
    private int an;
    private RevealColorView ao;
    private com.shazam.android.widget.tagging.a ap;
    private TaggingShardsView aq;
    private com.shazam.android.fragment.i ar;
    private TaggingButtonView as;
    private BlueCircleProtectionView at;
    private Resources au;

    public TaggingDialogFragment()
    {
        ap = com.shazam.android.widget.tagging.a.a;
    }

    public static h a(TransitionParams transitionparams)
    {
        return a(null, transitionparams);
    }

    public static h a(com.shazam.android.view.tagging.TaggingButtonView.VisualState visualstate, TransitionParams transitionparams)
    {
        com.shazam.android.view.tagging.TaggingButtonView.VisualState visualstate1 = visualstate;
        if (visualstate == null)
        {
            visualstate1 = new com.shazam.android.view.tagging.TaggingButtonView.VisualState(com.shazam.i.b.c.a().getResources());
        }
        if (transitionparams != null)
        {
            visualstate1.c = transitionparams.a.x - visualstate1.e / 2.0F;
            visualstate1.d = transitionparams.a.y - visualstate1.f / 2.0F;
        }
        TaggingDialogFragment taggingdialogfragment = new TaggingDialogFragment();
        taggingdialogfragment.setArguments(new Bundle());
        taggingdialogfragment.getArguments().putParcelable("param_tagging_state", visualstate1);
        visualstate = transitionparams;
        if (transitionparams == null)
        {
            visualstate = com.shazam.android.fragment.TransitionParams.a(visualstate1);
        }
        taggingdialogfragment.getArguments().putParcelable("param_transition_params", visualstate);
        taggingdialogfragment.d(false);
        return taggingdialogfragment;
    }

    static com.shazam.android.widget.d.a a(TaggingDialogFragment taggingdialogfragment)
    {
        return taggingdialogfragment.am;
    }

    static TaggingButtonView b(TaggingDialogFragment taggingdialogfragment)
    {
        return taggingdialogfragment.as;
    }

    static PointF c(TaggingDialogFragment taggingdialogfragment)
    {
        PointF pointf;
label0:
        {
            pointf = taggingdialogfragment.h().a;
            if (taggingdialogfragment.i())
            {
                View view = taggingdialogfragment.getView();
                if (view == null)
                {
                    break label0;
                }
                pointf.set((float)view.getWidth() / 2.0F, (float)view.getHeight() / 2.0F);
            }
            return pointf;
        }
        taggingdialogfragment = taggingdialogfragment.au.getDisplayMetrics();
        pointf.set(((DisplayMetrics) (taggingdialogfragment)).widthPixels / 2, ((DisplayMetrics) (taggingdialogfragment)).heightPixels / 2);
        return pointf;
    }

    private void c(boolean flag)
    {
        if (getActivity() != null && !getActivity().isFinishing())
        {
            if (aq != null)
            {
                aq.setVisibility(8);
            }
            if (ar != null)
            {
                m m1 = getChildFragmentManager().a().a(ar);
                if (flag)
                {
                    m1.a();
                    return;
                } else
                {
                    m1.b();
                    return;
                }
            }
        }
    }

    static Resources d(TaggingDialogFragment taggingdialogfragment)
    {
        return taggingdialogfragment.au;
    }

    public static h d()
    {
        return a(null, null);
    }

    private void d(boolean flag)
    {
        getArguments().putBoolean("param_dismiss_on_resume", flag);
    }

    static RevealColorView e(TaggingDialogFragment taggingdialogfragment)
    {
        return taggingdialogfragment.ao;
    }

    private void e()
    {
        f();
        TaggingShardsView taggingshardsview = aq;
        if (taggingshardsview.d)
        {
            taggingshardsview.c.a(com.shazam.android.view.tagging.k.a);
            if (taggingshardsview.getResources().getConfiguration().orientation == taggingshardsview.b)
            {
                taggingshardsview.a(taggingshardsview.a, 300L);
            } else
            {
                taggingshardsview.animate().alpha(0.0F).setDuration(300L).start();
                taggingshardsview.e.animate().alpha(0.0F).setDuration(300L).start();
            }
        }
        as.setForceDrawCircleBackground(true);
        ao.post(new _cls3());
    }

    static com.shazam.android.view.tagging.TaggingButtonView.VisualState f(TaggingDialogFragment taggingdialogfragment)
    {
        return taggingdialogfragment.g();
    }

    private void f()
    {
        ak.a(TaggingOutcome.CANCELED);
    }

    private com.shazam.android.view.tagging.TaggingButtonView.VisualState g()
    {
        return (com.shazam.android.view.tagging.TaggingButtonView.VisualState)getArguments().getParcelable("param_tagging_state");
    }

    static boolean g(TaggingDialogFragment taggingdialogfragment)
    {
        return taggingdialogfragment.i();
    }

    private TransitionParams h()
    {
        return (TransitionParams)getArguments().getParcelable("param_transition_params");
    }

    static com.shazam.android.widget.tagging.a h(TaggingDialogFragment taggingdialogfragment)
    {
        return taggingdialogfragment.ap;
    }

    static TransitionParams i(TaggingDialogFragment taggingdialogfragment)
    {
        return taggingdialogfragment.h();
    }

    private boolean i()
    {
        return an != au.getConfiguration().orientation;
    }

    static BlueCircleProtectionView j(TaggingDialogFragment taggingdialogfragment)
    {
        return taggingdialogfragment.at;
    }

    static void k(TaggingDialogFragment taggingdialogfragment)
    {
        if (taggingdialogfragment.getActivity() == null)
        {
            taggingdialogfragment.e();
        } else
        {
            taggingdialogfragment.aq.e();
            taggingdialogfragment.aq.c.b();
            k k1 = taggingdialogfragment.getChildFragmentManager();
            k1.b();
            taggingdialogfragment.ar = (com.shazam.android.fragment.i)k1.a("taggingFragmentDialog");
            if (taggingdialogfragment.ar == null)
            {
                taggingdialogfragment.ar = com.shazam.android.fragment.i.d();
                k1.a().a(0x7f1101a4, taggingdialogfragment.ar, "taggingFragmentDialog").a();
                return;
            }
        }
    }

    static void l(TaggingDialogFragment taggingdialogfragment)
    {
        taggingdialogfragment.c(true);
    }

    static void m(TaggingDialogFragment taggingdialogfragment)
    {
        taggingdialogfragment.e();
    }

    public final void a(com.shazam.android.widget.tagging.a a1)
    {
        ap = a1;
    }

    public final void n_()
    {
        e();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a(0x103000f);
        b(false);
        au = getResources();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03005c, viewgroup, false);
        ao = (RevealColorView)layoutinflater.findViewById(0x7f1101a2);
        as = (TaggingButtonView)layoutinflater.findViewById(0x7f11015a);
        aq = (TaggingShardsView)layoutinflater.findViewById(0x7f110159);
        at = (BlueCircleProtectionView)layoutinflater.findViewById(0x7f1101a3);
        layoutinflater.setOnTouchListener(new _cls1());
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        am.a();
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        ap.c();
    }

    public void onPause()
    {
        super.onPause();
        d(true);
        aq.c.a();
    }

    public void onResume()
    {
        super.onResume();
        if (!ak.c())
        {
            Bundle bundle = getArguments();
            boolean flag;
            if (bundle == null || bundle.getBoolean("param_dismiss_on_resume", true))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                f();
                c(false);
                a(true);
                return;
            }
        }
    /* block-local class not found */
    class a {}

        super.f.setOnKeyListener(new a((byte)0));
        ao.post(new _cls2());
    }

    public void onStop()
    {
        super.onStop();
        al.a(com.shazam.android.f.b.c());
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        an = view.getResources().getConfiguration().orientation;
        view = g();
        at.a = h().a;
        bundle = as;
        ((TaggingButtonView) (bundle)).c.cancel();
        ((TaggingButtonView) (bundle)).a.setRotation(((com.shazam.android.view.tagging.TaggingButtonView.VisualState) (view)).a);
        ((TaggingButtonView) (bundle)).b.setRotation(((com.shazam.android.view.tagging.TaggingButtonView.VisualState) (view)).b);
        bundle.setX((int)((com.shazam.android.view.tagging.TaggingButtonView.VisualState) (view)).c);
        bundle.setY((int)((com.shazam.android.view.tagging.TaggingButtonView.VisualState) (view)).d);
        bundle.getLayoutParams().height = (int)((com.shazam.android.view.tagging.TaggingButtonView.VisualState) (view)).f;
        bundle.getLayoutParams().width = (int)((com.shazam.android.view.tagging.TaggingButtonView.VisualState) (view)).e;
        float f1;
        if (((com.shazam.android.view.tagging.TaggingButtonView.VisualState) (view)).g)
        {
            f1 = 1.0F;
        } else
        {
            f1 = 0.8F;
        }
        ((TaggingButtonView) (bundle)).a.setScaleX(f1);
        ((TaggingButtonView) (bundle)).a.setScaleY(f1);
        ((TaggingButtonView) (bundle)).b.setScaleX(f1);
        ((TaggingButtonView) (bundle)).b.setScaleY(f1);
        bundle.a();
        aq.a(view);
    }


    // Unreferenced inner class com/shazam/android/fragment/TaggingDialogFragment$b
    /* block-local class not found */
    class b {}


    // Unreferenced inner class com/shazam/android/fragment/TaggingDialogFragment$c
    /* block-local class not found */
    class c {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
