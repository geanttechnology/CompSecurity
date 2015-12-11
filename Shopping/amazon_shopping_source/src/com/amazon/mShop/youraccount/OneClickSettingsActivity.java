// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.youraccount;

import android.os.Bundle;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.youraccount:
//            OneClickSettingsView

public class OneClickSettingsActivity extends AmazonActivity
{

    public OneClickSettingsActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        pushView(new OneClickSettingsView(this, false));
    }
}
