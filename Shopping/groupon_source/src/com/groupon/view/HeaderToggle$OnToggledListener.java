// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.Switch;

// Referenced classes of package com.groupon.view:
//            HeaderToggle, HeaderTogglePresenter

private static class toggleView
    implements android.view.ner
{

    private HeaderTogglePresenter presenter;
    private Switch toggleView;

    public void onClick(View view)
    {
        toggleView.setChecked(presenter.toggle());
    }

    public (HeaderTogglePresenter headertogglepresenter, Switch switch1)
    {
        presenter = headertogglepresenter;
        toggleView = switch1;
    }
}
