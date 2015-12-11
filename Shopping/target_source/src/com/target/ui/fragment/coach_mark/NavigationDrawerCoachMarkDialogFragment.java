// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.coach_mark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.b.c;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.ui.fragment.coach_mark.a.a;
import com.target.ui.fragment.common.BaseFullScreenDialogFragment;
import com.target.ui.service.provider.j;
import com.target.ui.view.navigation.NavigationStoreSelectionView;
import java.util.ArrayList;
import java.util.List;

public class NavigationDrawerCoachMarkDialogFragment extends BaseFullScreenDialogFragment
    implements a
{
    static class Views extends com.target.ui.view.a
    {

        View coachMarkWrapper;
        View mockNavigationDrawer;
        NavigationStoreSelectionView navigationStoreSelectionView;
        View overlay;

        Views(View view)
        {
            super(view);
        }
    }


    private static final int ENTER_ANIMATION_DELAY_MS = 150;
    private static final int ENTER_ANIMATION_DURATION_MS = 500;
    private static final int EXIT_ANIMATION_DURATION_MS = 300;
    public static final String TAG = com/target/ui/fragment/coach_mark/NavigationDrawerCoachMarkDialogFragment.getSimpleName();
    private float mPeekAmount;
    private com.target.ui.fragment.coach_mark.b.a mPresenter;
    private Views mViews;

    public NavigationDrawerCoachMarkDialogFragment()
    {
    }

    private AnimatorSet a(float f1, float f2)
    {
        ArrayList arraylist = new ArrayList();
        float f3 = mViews.mockNavigationDrawer.getTranslationX();
        arraylist.add(ObjectAnimator.ofFloat(mViews.mockNavigationDrawer, View.TRANSLATION_X, new float[] {
            f3, f3 + f1
        }));
        f1 = mViews.coachMarkWrapper.getAlpha();
        arraylist.add(ObjectAnimator.ofFloat(mViews.coachMarkWrapper, View.ALPHA, new float[] {
            f1, f1 + f2
        }));
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(arraylist);
        return animatorset;
    }

    public static NavigationDrawerCoachMarkDialogFragment a()
    {
        return new NavigationDrawerCoachMarkDialogFragment();
    }

    static com.target.ui.fragment.coach_mark.b.a a(NavigationDrawerCoachMarkDialogFragment navigationdrawercoachmarkdialogfragment)
    {
        return navigationdrawercoachmarkdialogfragment.mPresenter;
    }

    static Views b(NavigationDrawerCoachMarkDialogFragment navigationdrawercoachmarkdialogfragment)
    {
        return navigationdrawercoachmarkdialogfragment.mViews;
    }

    private void f()
    {
        AnimatorSet animatorset = a(mPeekAmount, 1.0F);
        animatorset.setInterpolator(new c());
        animatorset.setDuration(500L);
        animatorset.setStartDelay(150L);
        animatorset.start();
    }

    private void g()
    {
        AnimatorSet animatorset = a(-mPeekAmount, -1F);
        animatorset.addListener(new AnimatorListenerAdapter() {

            final NavigationDrawerCoachMarkDialogFragment this$0;

            public void onAnimationEnd(Animator animator)
            {
                if (NavigationDrawerCoachMarkDialogFragment.b(NavigationDrawerCoachMarkDialogFragment.this) == null)
                {
                    return;
                } else
                {
                    dismiss();
                    return;
                }
            }

            
            {
                this$0 = NavigationDrawerCoachMarkDialogFragment.this;
                super();
            }
        });
        animatorset.setInterpolator(new android.support.v4.view.b.a());
        animatorset.setDuration(300L);
        animatorset.start();
    }

    public void a(float f1)
    {
        mViews.coachMarkWrapper.setAlpha(f1);
    }

    public void a(RelevantStoreSummary relevantstoresummary)
    {
        mViews.navigationStoreSelectionView.setCurrentStore(relevantstoresummary);
    }

    public void b()
    {
        f();
    }

    public void b(float f1)
    {
        mViews.mockNavigationDrawer.setTranslationX(f1);
    }

    public void c()
    {
        g();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        float f1 = getResources().getDimension(0x7f0a0206);
        mPeekAmount = getResources().getDimension(0x7f0a013f);
        mPresenter = new com.target.ui.fragment.coach_mark.b.a(new j(), f1);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        setCancelable(false);
        bundle.setOnKeyListener(new android.content.DialogInterface.OnKeyListener() {

            final NavigationDrawerCoachMarkDialogFragment this$0;

            public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
            {
                return com.target.ui.fragment.coach_mark.NavigationDrawerCoachMarkDialogFragment.a(NavigationDrawerCoachMarkDialogFragment.this).onKey(dialoginterface, i, keyevent);
            }

            
            {
                this$0 = NavigationDrawerCoachMarkDialogFragment.this;
                super();
            }
        });
        return bundle;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        mPresenter.a(menu, menuinflater);
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030067, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.overlay.setOnClickListener(new android.view.View.OnClickListener() {

            final NavigationDrawerCoachMarkDialogFragment this$0;

            public void onClick(View view)
            {
                com.target.ui.fragment.coach_mark.NavigationDrawerCoachMarkDialogFragment.a(NavigationDrawerCoachMarkDialogFragment.this).c();
            }

            
            {
                this$0 = NavigationDrawerCoachMarkDialogFragment.this;
                super();
            }
        });
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mPresenter.z_();
        mViews = null;
    }

}
