// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.e;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.registry.a.d;
import com.target.ui.fragment.registry.presenter.RegistryRefinePagePresenter;
import com.target.ui.model.registry.RegistryRefineModel;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import com.target.ui.util.z;
import com.target.ui.view.common.TargetBottomButton;
import com.target.ui.view.registry.RegistryRefineView;

public class RegistrySearchRefinePageFragment extends BaseNavigationFragment
    implements d
{
    static class Views extends com.target.ui.view.a
    {

        TargetBottomButton bottomButton;
        RegistryRefineView refineListView;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(RegistrySearchParam registrysearchparam, RegistryRefineModel registryrefinemodel);
    }

    private class b
        implements com.target.ui.view.common.TargetBottomButton.b
    {

        final RegistrySearchRefinePageFragment this$0;

        public void a()
        {
            RegistrySearchRefinePageFragment.a(RegistrySearchRefinePageFragment.this).d();
        }

        public void b()
        {
        }

        public void c()
        {
            RegistrySearchRefinePageFragment.a(RegistrySearchRefinePageFragment.this).c();
        }

        private b()
        {
            this$0 = RegistrySearchRefinePageFragment.this;
            super();
        }

    }

    private class c
        implements com.target.ui.view.registry.RegistryRefineView.a
    {

        final RegistrySearchRefinePageFragment this$0;

        public void a(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
        {
            RegistrySearchRefinePageFragment.a(RegistrySearchRefinePageFragment.this).a(registryeventlabel);
        }

        public void a(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
        {
            RegistrySearchRefinePageFragment.a(RegistrySearchRefinePageFragment.this).a(registrysortlabel);
        }

        public void b(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
        {
            RegistrySearchRefinePageFragment.a(RegistrySearchRefinePageFragment.this).a(null);
        }

        public void b(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
        {
            RegistrySearchRefinePageFragment.a(RegistrySearchRefinePageFragment.this).a(null);
        }

        private c()
        {
            this$0 = RegistrySearchRefinePageFragment.this;
            super();
        }

    }


    private static final String ARG_REGISTRY_REFINE_MODEL_PARAM = "registryRefineModelArg";
    private static final String ARG_REGISTRY_SEARCH_SUMMARY_PARAM = "registrySearchSummaryParamArg";
    private static final String ARG_SAVED_STATE_PRESENTER = "registryRefineSavedStateArg";
    private RegistryRefinePagePresenter mPresenter;
    private a mRegistryRefineListener;
    private RegistryRefineModel mSavedOriginalRefineModel;
    private Parcelable mSavedState;
    private Views mViews;

    public RegistrySearchRefinePageFragment()
    {
    }

    public static RegistrySearchRefinePageFragment a(RegistrySearchParam registrysearchparam, RegistryRefineModel registryrefinemodel, a a1)
    {
        RegistrySearchRefinePageFragment registrysearchrefinepagefragment = new RegistrySearchRefinePageFragment();
        a(((Fragment) (registrysearchrefinepagefragment)), a1);
        a1 = new Bundle();
        a1.putParcelable("registrySearchSummaryParamArg", registrysearchparam);
        a1.putParcelable("registryRefineModelArg", registryrefinemodel);
        registrysearchrefinepagefragment.setArguments(a1);
        return registrysearchrefinepagefragment;
    }

    static RegistryRefinePagePresenter a(RegistrySearchRefinePageFragment registrysearchrefinepagefragment)
    {
        return registrysearchrefinepagefragment.mPresenter;
    }

    private static void a(Fragment fragment, a a1)
        throws IllegalArgumentException
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("OnSearchRefineListener cannot be null");
        }
        if (!(a1 instanceof Fragment))
        {
            throw new IllegalArgumentException("Must implement OnSearchRefineListener");
        } else
        {
            fragment.setTargetFragment((Fragment)a1, 0);
            return;
        }
    }

    private RegistryRefineModel e()
    {
        return (RegistryRefineModel)getArguments().getParcelable("registryRefineModelArg");
    }

    private RegistrySearchParam f()
    {
        return (RegistrySearchParam)getArguments().getParcelable("registrySearchSummaryParamArg");
    }

    private void g()
    {
        mViews.refineListView.setClickListener(new c());
        mViews.bottomButton.setClickListener(new b());
    }

    private void h()
    {
        mViews.refineListView.setClickListener(null);
        mViews.bottomButton.setClickListener(null);
    }

    private void i()
    {
        Animator animator = aj.e(mViews.bottomButton);
        animator.addListener(new AnimatorListenerAdapter() {

            final RegistrySearchRefinePageFragment this$0;

            public void onAnimationEnd(Animator animator1)
            {
                if (RegistrySearchRefinePageFragment.a(RegistrySearchRefinePageFragment.this) == null)
                {
                    return;
                } else
                {
                    RegistrySearchRefinePageFragment.a(RegistrySearchRefinePageFragment.this).f();
                    return;
                }
            }

            public void onAnimationStart(Animator animator1)
            {
                if (RegistrySearchRefinePageFragment.a(RegistrySearchRefinePageFragment.this) == null)
                {
                    return;
                } else
                {
                    RegistrySearchRefinePageFragment.a(RegistrySearchRefinePageFragment.this).e();
                    return;
                }
            }

            
            {
                this$0 = RegistrySearchRefinePageFragment.this;
                super();
            }
        });
        animator.start();
    }

    private RegistryRefineModel j()
    {
        return (RegistryRefineModel)z.a(e(), com/target/ui/model/registry/RegistryRefineModel.getClassLoader());
    }

    public void a()
    {
        al.b(mViews.bottomButton);
    }

    public void a(int k)
    {
        j(getString(k));
    }

    public void a(RegistryRefineModel registryrefinemodel)
    {
        mViews.refineListView.a(registryrefinemodel);
        al.b(mViews.refineListView);
    }

    public void b()
    {
        mViews.refineListView.a();
    }

    public void b(RegistryRefineModel registryrefinemodel)
    {
        com.target.mothership.common.registries.c c1;
        for (c1 = null; mRegistryRefineListener == null || mSavedOriginalRefineModel.equals(registryrefinemodel);)
        {
            return;
        }

        RegistrySearchParam registrysearchparam = f();
        com.target.mothership.common.registries.e e1;
        com.target.mothership.common.registries.f f1;
        if (registryrefinemodel.c().b())
        {
            e1 = ((com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel)registryrefinemodel.c().c()).b();
        } else
        {
            e1 = null;
        }
        if (registryrefinemodel.c().b())
        {
            f1 = ((com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel)registryrefinemodel.c().c()).c();
        } else
        {
            f1 = null;
        }
        if (registryrefinemodel.d().b())
        {
            c1 = ((com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel)registryrefinemodel.d().c()).b();
        }
        registrysearchparam.a(e1);
        registrysearchparam.a(f1);
        registrysearchparam.a(c1);
        mRegistryRefineListener.a(registrysearchparam, registryrefinemodel);
    }

    public void c()
    {
        i();
    }

    public void d()
    {
        if (Z())
        {
            return;
        } else
        {
            getFragmentManager().d();
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getTargetFragment() instanceof a)
        {
            mRegistryRefineListener = (a)getTargetFragment();
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement OnRegistrySearchRefineListener");
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            mSavedState = bundle.getParcelable("registryRefineSavedStateArg");
        }
        mPresenter = new RegistryRefinePagePresenter(f(), e(), mSavedState);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            mPresenter.a(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030078, viewgroup, false);
        mViews = new Views(layoutinflater);
        mSavedOriginalRefineModel = j();
        mPresenter.a(this);
        g();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mSavedState = null;
        mPresenter.v_();
        mPresenter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        h();
        mPresenter.z_();
        mViews = null;
        mSavedOriginalRefineModel = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mRegistryRefineListener = null;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("registryRefineSavedStateArg", mSavedState);
        super.onSaveInstanceState(bundle);
    }
}
