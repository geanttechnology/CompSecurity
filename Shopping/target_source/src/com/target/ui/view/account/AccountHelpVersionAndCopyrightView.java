// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.ui.span.a;
import com.target.ui.util.ah;
import com.target.ui.util.al;

public class AccountHelpVersionAndCopyrightView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        TextView copyrightTargetBrand;
        TextView helpAppVersion;

        Views(View view)
        {
            super(view);
        }
    }


    private Views mViews;

    public AccountHelpVersionAndCopyrightView(Context context)
    {
        super(context);
        a();
    }

    public AccountHelpVersionAndCopyrightView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    private void a()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f0300f0, this);
        mViews = new Views(this);
        String s;
        String s1;
        SpannableStringBuilder spannablestringbuilder;
        try
        {
            PackageInfo packageinfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            mViews.helpAppVersion.setText(packageinfo.versionName);
            al.b(mViews.helpAppVersion);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            al.c(mViews.helpAppVersion);
        }
        s = getResources().getString(0x7f090312);
        s1 = getResources().getString(0x7f090311);
        spannablestringbuilder = new SpannableStringBuilder(s);
        spannablestringbuilder.setSpan(new a(ah.a(getContext(), com.target.ui.util.ah.a.LIGHT)), s.indexOf(s1), s.length(), 33);
        mViews.copyrightTargetBrand.setText(spannablestringbuilder);
    }
}
