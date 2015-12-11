// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.gno.GNODrawer;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil, SigninPromptView

public class SigninPromptActivity extends AmazonActivity
{

    public SigninPromptActivity()
    {
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
        {
            SSOUtil.skipSigin(this);
        }
        return super.dispatchKeyEvent(keyevent);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 0 && -1 == j)
        {
            finish();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getGNODrawer().lock(false);
        pushView(new SigninPromptView(this), false);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        return false;
    }
}
