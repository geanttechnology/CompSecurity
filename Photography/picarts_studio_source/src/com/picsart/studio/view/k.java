// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Intent;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import com.socialin.android.picsart.profile.activity.SliderActivity;

// Referenced classes of package com.picsart.studio.view:
//            SlidingUpPanelLayout

public class k
{

    public SliderActivity a;

    public k(SliderActivity slideractivity)
    {
        a = slideractivity;
        super();
    }

    public k(SliderActivity slideractivity, byte byte0)
    {
        this(slideractivity);
    }

    public void a()
    {
        Log.i("ItemDetailsActivity", "onPanelHidden");
        ((InputMethodManager)a.getSystemService("input_method")).hideSoftInputFromWindow(SliderActivity.a(a).getWindowToken(), 0);
        if (a.getIntent().hasExtra("dataChanged"))
        {
            a.setResult(4551, a.getIntent());
        }
        a.finish();
        a.overridePendingTransition(0, 0);
    }
}
