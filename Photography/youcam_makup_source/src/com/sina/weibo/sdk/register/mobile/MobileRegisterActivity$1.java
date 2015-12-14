// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.os.CountDownTimer;
import android.widget.Button;
import com.sina.weibo.sdk.utils.ResourceManager;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            MobileRegisterActivity

class this._cls0 extends CountDownTimer
{

    final MobileRegisterActivity this$0;

    public void onFinish()
    {
        MobileRegisterActivity.access$7(MobileRegisterActivity.this).setText(ResourceManager.getString(getApplicationContext(), "Get code", "\u83B7\u53D6\u9A8C\u8BC1\u7801", "\u7372\u53D6\u9A57\u8B49\u78BC"));
        MobileRegisterActivity.access$8(MobileRegisterActivity.this);
    }

    public void onTick(long l)
    {
        MobileRegisterActivity.access$7(MobileRegisterActivity.this).setText((new StringBuilder(String.valueOf(ResourceManager.getString(getApplicationContext(), "Get code", "\u83B7\u53D6\u9A8C\u8BC1\u7801", "\u7372\u53D6\u9A57\u8B49\u78BC")))).append("(").append(l / 1000L).append("s)").toString());
    }

    A(long l, long l1)
    {
        this$0 = MobileRegisterActivity.this;
        super(l, l1);
    }
}
