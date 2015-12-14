// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;

import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.UIUtils;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            MobileRegisterActivity

class this._cls0
    implements RequestListener
{

    final MobileRegisterActivity this$0;

    public void onComplete(String s)
    {
        LogUtil.d(MobileRegisterActivity.access$9(), (new StringBuilder("get onComplete : ")).append(s).toString());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        s = new JSONObject(s);
        MobileRegisterActivity.access$10(MobileRegisterActivity.this, (String)s.get("cfrom"));
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
        UIUtils.showToast(getApplicationContext(), weiboexception, 1);
        return;
    }

    A()
    {
        this$0 = MobileRegisterActivity.this;
        super();
    }
}
