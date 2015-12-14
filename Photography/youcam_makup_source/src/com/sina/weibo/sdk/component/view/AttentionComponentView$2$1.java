// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;

import android.os.Handler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.component.view:
//            AttentionComponentView

class val.target
    implements Runnable
{

    final is._cls0 this$1;
    private final JSONObject val$target;

    public void run()
    {
        if (val$target != null)
        {
            AttentionComponentView.access$3(_fld0, val$target.optBoolean("followed_by", false));
        }
        AttentionComponentView.access$2(_fld0, false);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$target = JSONObject.this;
        super();
    }

    // Unreferenced inner class com/sina/weibo/sdk/component/view/AttentionComponentView$2

/* anonymous class */
    class AttentionComponentView._cls2
        implements RequestListener
    {

        final AttentionComponentView this$0;

        public void onComplete(String s)
        {
            LogUtil.d(AttentionComponentView.access$1(), (new StringBuilder("json : ")).append(s).toString());
            try
            {
                s = (new JSONObject(s)).optJSONObject("target");
                getHandler().post(s. new AttentionComponentView._cls2._cls1());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
        }

        public void onWeiboException(WeiboException weiboexception)
        {
            LogUtil.d(AttentionComponentView.access$1(), (new StringBuilder("error : ")).append(weiboexception.getMessage()).toString());
            AttentionComponentView.access$2(AttentionComponentView.this, false);
        }


            
            {
                this$0 = AttentionComponentView.this;
                super();
            }
    }

}
