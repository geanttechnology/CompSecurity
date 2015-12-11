// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.os.Bundle;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialView1

public class ViewItTutorialActivity extends AmazonActivity
{

    public ViewItTutorialActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        pushView(new ViewItTutorialView1(this), true);
        RefMarkerObserver.logRefMarker("fl_tutor_show");
    }

    public void pushView(View view, boolean flag)
    {
        super.pushView(view, flag);
        setActionBarAndSeparatorDecoratorVisibility(8);
    }
}
