// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            SelectCountryActivity, Country

class this._cls0
    implements android.widget.istener
{

    final SelectCountryActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (Country)SelectCountryActivity.access$2(SelectCountryActivity.this).getItem(i);
        if (adapterview == null)
        {
            return;
        } else
        {
            view = new Intent();
            view.putExtra("code", adapterview.getCode());
            view.putExtra("name", adapterview.getName());
            setResult(-1, view);
            finish();
            return;
        }
    }

    untryAdapter()
    {
        this$0 = SelectCountryActivity.this;
        super();
    }
}
