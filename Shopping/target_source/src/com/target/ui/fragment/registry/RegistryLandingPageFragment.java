// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.analytics.a.ba;
import com.target.ui.f.c;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.registry.a.e;
import com.target.ui.fragment.registry.presenter.RegistrySearchLandingPagePresenter;
import com.target.ui.util.SpannableStringUtils;
import com.target.ui.util.n;
import com.target.ui.util.validation.validator.RegistryFirstNameValidator;
import com.target.ui.util.validation.validator.RegistryLastNameValidator;
import com.target.ui.view.registry.RegistryAdvancedSearchButton;
import com.target.ui.view.registry.RegistryNameView;

// Referenced classes of package com.target.ui.fragment.registry:
//            RegistrySearchSummaryPageFragment, RegistryAdvancedSearchPageFragment

public class RegistryLandingPageFragment extends BaseNavigationFragment
    implements e
{
    static class Views extends com.target.ui.view.a
    {

        RegistryAdvancedSearchButton advancedSearchButtonView;
        TextView createAndManageRegistry;
        RegistryNameView nameView;
        Button searchButtonView;

        Views(View view)
        {
            super(view);
        }
    }

    private final class a
        implements com.target.ui.view.registry.RegistryAdvancedSearchButton.b
    {

        final RegistryLandingPageFragment this$0;

        public void a()
        {
            if (RegistryLandingPageFragment.b(RegistryLandingPageFragment.this) == null)
            {
                return;
            } else
            {
                String s = com.target.ui.fragment.registry.RegistryLandingPageFragment.c(RegistryLandingPageFragment.this).nameView.getFirstName();
                String s1 = com.target.ui.fragment.registry.RegistryLandingPageFragment.c(RegistryLandingPageFragment.this).nameView.getLastName();
                RegistryLandingPageFragment.b(RegistryLandingPageFragment.this).b(s, s1);
                return;
            }
        }

        private a()
        {
            this$0 = RegistryLandingPageFragment.this;
            super();
        }

    }

    private final class b
        implements com.target.ui.view.registry.RegistryNameView.e
    {

        final RegistryLandingPageFragment this$0;

        public void a(String s)
        {
            RegistryLandingPageFragment.b(RegistryLandingPageFragment.this).a(s);
        }

        public void a(String s, boolean flag)
        {
            RegistryLandingPageFragment.b(RegistryLandingPageFragment.this).a(s, flag);
        }

        public void b(String s)
        {
            RegistryLandingPageFragment.b(RegistryLandingPageFragment.this).b(s);
        }

        public void b(String s, boolean flag)
        {
            RegistryLandingPageFragment.b(RegistryLandingPageFragment.this).b(s, flag);
        }

        private b()
        {
            this$0 = RegistryLandingPageFragment.this;
            super();
        }

    }

    private class c
        implements android.view.View.OnClickListener
    {

        final RegistryLandingPageFragment this$0;

        public void onClick(View view)
        {
            RegistryLandingPageFragment.a(RegistryLandingPageFragment.this);
        }

        private c()
        {
            this$0 = RegistryLandingPageFragment.this;
            super();
        }

    }


    private static final String ARG_SAVED_STATE_PRESENTER = "registryLandingSavedStateArg";
    private static final String GIFT_REGISTRY_URL = "http://www.target.com/gift-registry/";
    private static final String STORE_ARG = "storeArg";
    private static final String TAG = com/target/ui/fragment/registry/RegistryLandingPageFragment.getSimpleName();
    private RegistryFirstNameValidator mFirstNameValidator;
    private RegistryLastNameValidator mLastNameValidator;
    private RegistrySearchLandingPagePresenter mPresenter;
    private ClickableSpan mRegistryManageAndCreate;
    private Views mViews;

    public RegistryLandingPageFragment()
    {
        mRegistryManageAndCreate = new ClickableSpan() {

            final RegistryLandingPageFragment this$0;

            public void onClick(View view)
            {
                n.a(getActivity(), Uri.parse("http://www.target.com/gift-registry/"), null);
            }

            public void updateDrawState(TextPaint textpaint)
            {
                textpaint.setUnderlineText(false);
            }

            
            {
                this$0 = RegistryLandingPageFragment.this;
                super();
            }
        };
    }

    public static RegistryLandingPageFragment a(Store store)
    {
        RegistryLandingPageFragment registrylandingpagefragment = new RegistryLandingPageFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeArg", store);
        registrylandingpagefragment.setArguments(bundle);
        return registrylandingpagefragment;
    }

    static void a(RegistryLandingPageFragment registrylandingpagefragment)
    {
        registrylandingpagefragment.g();
    }

    static RegistrySearchLandingPagePresenter b(RegistryLandingPageFragment registrylandingpagefragment)
    {
        return registrylandingpagefragment.mPresenter;
    }

    private void b(RegistrySearchParam registrysearchparam)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(RegistrySearchSummaryPageFragment.a(registrysearchparam, h()));
            return;
        }
    }

    static Views c(RegistryLandingPageFragment registrylandingpagefragment)
    {
        return registrylandingpagefragment.mViews;
    }

    private void c(String s, String s1)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(RegistryAdvancedSearchPageFragment.a(s, s1, h()));
            return;
        }
    }

    private void c(boolean flag)
    {
        mViews.searchButtonView.setEnabled(flag);
    }

    private void e()
    {
        mViews.nameView.setClickListener(new b());
        mViews.advancedSearchButtonView.setClickListener(new a());
        mViews.searchButtonView.setOnClickListener(new c());
    }

    private void f()
    {
        mViews.nameView.setClickListener(null);
        mViews.searchButtonView.setOnClickListener(null);
    }

    private void g()
    {
        String s = mViews.nameView.getFirstName();
        String s1 = mViews.nameView.getLastName();
        mPresenter.a(s, s1);
    }

    private Store h()
    {
        return (Store)getArguments().getParcelable("storeArg");
    }

    private SpannableStringBuilder i()
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(getString(0x7f0904a1));
        SpannableStringUtils.a(spannablestringbuilder, getString(0x7f0904a1), getString(0x7f0904a2), mRegistryManageAndCreate);
        SpannableStringUtils.a(spannablestringbuilder, getString(0x7f0904a1), getString(0x7f0904a2), new ForegroundColorSpan(getResources().getColor(0x7f0f00e2)));
        return spannablestringbuilder;
    }

    public void a()
    {
        ba.a(this).e();
    }

    public void a(int j)
    {
        j(getString(j));
    }

    public void a(RegistrySearchParam registrysearchparam)
    {
        b(registrysearchparam);
    }

    public void a(String s)
    {
        mViews.nameView.a(s);
    }

    public void a(String s, String s1)
    {
        c(s, s1);
    }

    public void a(boolean flag)
    {
        c(flag);
    }

    public void b()
    {
        mViews.nameView.a();
    }

    public void b(String s)
    {
        mViews.nameView.b(s);
    }

    public void b(String s, String s1)
    {
        mViews.nameView.a(s, s1);
    }

    public void c()
    {
        mViews.nameView.b();
    }

    public void d()
    {
        mViews.createAndManageRegistry.setText(i());
        mViews.createAndManageRegistry.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        android.os.Parcelable parcelable = null;
        if (bundle != null)
        {
            parcelable = bundle.getParcelable("registryLandingSavedStateArg");
        }
        mFirstNameValidator = new RegistryFirstNameValidator(getActivity());
        mLastNameValidator = new RegistryLastNameValidator(getActivity());
        mPresenter = new RegistrySearchLandingPagePresenter(mFirstNameValidator, mLastNameValidator, parcelable);
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
        layoutinflater = layoutinflater.inflate(0x7f030077, viewgroup, false);
        mViews = new Views(layoutinflater);
        mPresenter.a(this);
        e();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
        mFirstNameValidator = null;
        mLastNameValidator = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        f();
        mPresenter.z_();
        mViews = null;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("registryLandingSavedStateArg", mPresenter.c());
        super.onSaveInstanceState(bundle);
    }

}
