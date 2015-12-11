// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.account;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import com.amazon.mShop.DelayedInitView;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.UIUtils;

// Referenced classes of package com.amazon.mShop.account:
//            LoginActivity

public class LoginView extends ScrollView
    implements DelayedInitView, TitleProvider
{

    public LoginView(Context context)
    {
        super(context);
        context = View.inflate(context, com.amazon.mShop.android.lib.R.layout.login, null);
        ((EditText)context.findViewById(com.amazon.mShop.android.lib.R.id.login_password_edit)).setTypeface(Typeface.DEFAULT);
        addView(context);
    }

    private void updateSoftKeyboard()
    {
        EditText edittext = (EditText)findViewById(com.amazon.mShop.android.lib.R.id.login_password_edit);
        if (edittext.isFocused())
        {
            UIUtils.showSoftKeyboard(edittext);
        }
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        return null;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (!((LoginActivity)getContext()).hasSignedIn())
        {
            RefMarkerObserver.logRefMarker("si_not_done");
        }
    }

    public void onPushViewCompleted()
    {
        updateSoftKeyboard();
    }
}
