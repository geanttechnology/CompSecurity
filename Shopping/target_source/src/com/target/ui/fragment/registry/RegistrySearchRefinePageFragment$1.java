// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.target.ui.fragment.registry.presenter.RegistryRefinePagePresenter;

// Referenced classes of package com.target.ui.fragment.registry:
//            RegistrySearchRefinePageFragment

class this._cls0 extends AnimatorListenerAdapter
{

    final RegistrySearchRefinePageFragment this$0;

    public void onAnimationEnd(Animator animator)
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

    public void onAnimationStart(Animator animator)
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

    er()
    {
        this$0 = RegistrySearchRefinePageFragment.this;
        super();
    }
}
