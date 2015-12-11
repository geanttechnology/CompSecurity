// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.registry;

import com.target.ui.fragment.registry.presenter.RegistrySearchLandingPagePresenter;
import com.target.ui.view.registry.RegistryNameView;

// Referenced classes of package com.target.ui.fragment.registry:
//            RegistryLandingPageFragment

private final class <init>
    implements com.target.ui.view.registry.
{

    final RegistryLandingPageFragment this$0;

    public void a()
    {
        if (RegistryLandingPageFragment.b(RegistryLandingPageFragment.this) == null)
        {
            return;
        } else
        {
            String s = RegistryLandingPageFragment.c(RegistryLandingPageFragment.this).nameView.getFirstName();
            String s1 = RegistryLandingPageFragment.c(RegistryLandingPageFragment.this).nameView.getLastName();
            RegistryLandingPageFragment.b(RegistryLandingPageFragment.this).b(s, s1);
            return;
        }
    }

    private gPagePresenter()
    {
        this$0 = RegistryLandingPageFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
