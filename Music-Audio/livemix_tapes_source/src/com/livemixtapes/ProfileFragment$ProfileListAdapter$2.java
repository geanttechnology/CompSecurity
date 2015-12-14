// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.FragmentTransaction;
import android.view.View;
import com.livemixtapes.profile.SelectedPlayList;
import com.livemixtapes.ui.BaseActivity;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            ProfileFragment

class val.map
    implements android.view.r._cls2
{

    final ansaction this$1;
    private final Map val$map;

    public void onClick(View view)
    {
        SelectedPlayList.map = val$map;
        view = cess._mth0(this._cls1.this).getAnimatedFragmentTransaction();
        view.replace(0x7f0800cc, new SelectedPlayList(), "SELECTED").addToBackStack(null);
        view.commit();
    }

    ()
    {
        this$1 = final_;
        val$map = Map.this;
        super();
    }
}
