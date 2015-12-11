// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.target.ui.view.common.ExpandView;
import com.target.ui.view.common.i;

// Referenced classes of package com.target.ui.view.registry:
//            BaseRegistryRefineChildView

public abstract class BaseRegistryExpandView extends ExpandView
{

    public static final String TAG = com/target/ui/view/registry/BaseRegistryExpandView.getSimpleName();
    BaseRegistryRefineChildView mChildBaseRefineView;

    public BaseRegistryExpandView(Context context)
    {
        super(context);
    }

    public BaseRegistryExpandView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public BaseRegistryExpandView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void a(boolean flag)
    {
        if (flag)
        {
            setTitleColor(getResources().getColor(0x7f0f00e3));
            return;
        } else
        {
            setTitleColor(getResources().getColor(0x7f0f00f3));
            return;
        }
    }

    protected void b()
    {
        a(false);
        if (mChildBaseRefineView != null)
        {
            mChildBaseRefineView.a();
        }
    }

    protected volatile void setChildView(i i)
    {
        setChildView((BaseRegistryRefineChildView)i);
    }

    protected void setChildView(BaseRegistryRefineChildView baseregistryrefinechildview)
    {
        super.setChildView(baseregistryrefinechildview);
        mChildBaseRefineView = baseregistryrefinechildview;
    }

}
