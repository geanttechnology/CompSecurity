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

class this._cls0
    implements RequestListener
{

    final AttentionComponentView this$0;

    public void onComplete(final String target)
    {
        LogUtil.d(AttentionComponentView.access$1(), (new StringBuilder("json : ")).append(target).toString());
        try
        {
            target = (new JSONObject(target)).optJSONObject("target");
            getHandler().post(new Runnable() {

                final AttentionComponentView._cls2 this$1;
                private final JSONObject val$target;

                public void run()
                {
                    if (target != null)
                    {
                        AttentionComponentView.access$3(this$0, target.optBoolean("followed_by", false));
                    }
                    AttentionComponentView.access$2(this$0, false);
                }

            
            {
                this$1 = AttentionComponentView._cls2.this;
                target = jsonobject;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final String target)
        {
            return;
        }
    }

    public void onWeiboException(WeiboException weiboexception)
    {
        LogUtil.d(AttentionComponentView.access$1(), (new StringBuilder("error : ")).append(weiboexception.getMessage()).toString());
        AttentionComponentView.access$2(AttentionComponentView.this, false);
    }


    _cls1.val.target()
    {
        this$0 = AttentionComponentView.this;
        super();
    }
}
