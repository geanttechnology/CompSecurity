// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.ResourceManager;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            MobileRegisterActivity

class val.phoneNum
    implements RequestListener
{

    final MobileRegisterActivity this$0;
    private final String val$phoneNum;

    public void onComplete(String s)
    {
        dismiss();
        LogUtil.d(MobileRegisterActivity.access$9(), (new StringBuilder("get onComplete : ")).append(s).toString());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        s = new JSONObject(s);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("uid", s.optString("uid"));
        bundle.putString("phone_num", val$phoneNum);
        bundle.putString("access_token", s.optString("oauth_token"));
        bundle.putString("expires_in", s.optString("expires"));
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
        return;
        s;
        s.printStackTrace();
        return;
    }

    public void onWeiboException(WeiboException weiboexception)
    {
        String s;
        LogUtil.d(MobileRegisterActivity.access$9(), (new StringBuilder("get onWeiboException ")).append(weiboexception.getMessage()).toString());
        s = ResourceManager.getString(getApplicationContext(), "the server is busy, please  wait", "\u670D\u52A1\u5668\u5FD9,\u8BF7\u7A0D\u540E\u518D\u8BD5", "\u670D\u52D9\u5668\u5FD9,\u8ACB\u7A0D\u5F8C\u518D\u8A66");
        JSONObject jsonobject = new JSONObject(weiboexception.getMessage());
        weiboexception = s;
        try
        {
            if (!TextUtils.isEmpty(jsonobject.optString("error_description")))
            {
                weiboexception = jsonobject.optString("error_description");
            }
        }
        // Misplaced declaration of an exception variable
        catch (WeiboException weiboexception)
        {
            weiboexception.printStackTrace();
            weiboexception = s;
        }
        MobileRegisterActivity.access$11(MobileRegisterActivity.this).setVisibility(0);
        MobileRegisterActivity.access$11(MobileRegisterActivity.this).setText(weiboexception);
        dismiss();
        return;
    }

    A()
    {
        this$0 = final_mobileregisteractivity;
        val$phoneNum = String.this;
        super();
    }
}
