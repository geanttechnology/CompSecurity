// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.view.Menu;
import com.amazon.mShop.gno.GNODrawer;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebActivity

public class MShopModalWebActivity extends MShopWebActivity
{

    private boolean mSupportGNO;
    private boolean mSupportMenu;

    public MShopModalWebActivity()
    {
        mSupportMenu = false;
        mSupportGNO = false;
    }

    public boolean isSupportGNO()
    {
        return mSupportGNO;
    }

    public boolean isSupportMenu()
    {
        return mSupportMenu;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if (isSupportMenu())
        {
            return super.onPrepareOptionsMenu(menu);
        } else
        {
            return false;
        }
    }

    public void setSupportGNO(boolean flag)
    {
        mSupportGNO = flag;
        if (flag)
        {
            getGNODrawer().unlock();
            return;
        } else
        {
            getGNODrawer().lock(false);
            return;
        }
    }

    public void setSupportMenu(boolean flag)
    {
        mSupportMenu = flag;
    }
}
