// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import com.groupon.adapter.GiftThemeSelectorAdapter;
import com.groupon.db.models.DerivedGiftTheme;
import com.groupon.view.GiftThemeImageView;

// Referenced classes of package com.groupon.activity:
//            GiftingThemeSelection

private class <init>
    implements android.view.istener
{

    final GiftingThemeSelection this$0;

    public void onClick(View view)
    {
        GiftingThemeSelection.access$200(GiftingThemeSelection.this).selected = false;
        view = ((GiftThemeImageView)view).getTheme();
        view.selected = true;
        GiftingThemeSelection.access$202(GiftingThemeSelection.this, view);
        GiftingThemeSelection.access$302(GiftingThemeSelection.this, ((DerivedGiftTheme) (view)).categoryIndex);
        GiftingThemeSelection.access$402(GiftingThemeSelection.this, ((DerivedGiftTheme) (view)).subIndex);
        GiftingThemeSelection.access$502(GiftingThemeSelection.this, ((DerivedGiftTheme) (view)).id);
        GiftingThemeSelection.access$600(GiftingThemeSelection.this).notifyDataSetChanged();
        GiftingThemeSelection.access$800(GiftingThemeSelection.this).loadUrl(GiftingThemeSelection.access$700(GiftingThemeSelection.this));
    }

    private ()
    {
        this$0 = GiftingThemeSelection.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
