// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.sina.weibo.sdk.component.WeiboSdkBrowser;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            MobileRegisterActivity

class url extends ClickableSpan
{

    private Context context;
    final MobileRegisterActivity this$0;
    private String url;

    public void onClick(View view)
    {
        view = new Intent(context, com/sina/weibo/sdk/component/WeiboSdkBrowser);
        Bundle bundle = new Bundle();
        bundle.putString("key_url", url);
        view.putExtras(bundle);
        startActivity(view);
    }

    public void updateDrawState(TextPaint textpaint)
    {
        textpaint.setColor(0xff507daf);
        textpaint.setUnderlineText(false);
    }

    public Q(Context context1, String s)
    {
        this$0 = MobileRegisterActivity.this;
        super();
        context = context1;
        url = s;
    }
}
