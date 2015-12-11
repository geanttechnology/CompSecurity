// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.models.LinkAccountsResult;
import com.bitstrips.imoji.util.PreferenceUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            RetrieveAvatarActivity

class val.context
    implements com.bitstrips.imoji.auth.enCallback
{

    final RetrieveAvatarActivity this$0;
    final String val$bsauthToken;
    final Context val$context;
    final Button val$retrieveButton;
    final TextView val$skipText;

    public void onOpened()
    {
        val$retrieveButton.setEnabled(false);
        val$retrieveButton.setAlpha(0.3F);
        val$skipText.setEnabled(false);
        val$skipText.setAlpha(0.3F);
        final String fbToken = facebookService.getToken();
        String s = getString(0x7f060017);
        bitstripsService.linkAccounts(fbToken, val$bsauthToken, s, new Callback() {

            final RetrieveAvatarActivity._cls4 this$1;
            final String val$fbToken;

            public void failure(RetrofitError retrofiterror)
            {
                RetrieveAvatarActivity.access$000(this$0);
            }

            public void success(LinkAccountsResult linkaccountsresult, Response response)
            {
                if (linkaccountsresult.success().booleanValue())
                {
                    linkaccountsresult = context.getString(0x7f060017);
                    bitstripsService.getAvatarInfo(fbToken, bsauthToken, linkaccountsresult, new Callback() {

                        final _cls1 this$2;

                        public void failure(RetrofitError retrofiterror)
                        {
                            RetrieveAvatarActivity.access$000(this$0);
                        }

                        public void success(AvatarInfo avatarinfo, Response response)
                        {
                            preferenceUtils.putString(0x7f06002a, avatarinfo.getId());
                            RetrieveAvatarActivity.access$000(this$0);
                        }

                        public volatile void success(Object obj, Response response)
                        {
                            success((AvatarInfo)obj, response);
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    return;
                } else
                {
                    RetrieveAvatarActivity.access$000(this$0);
                    return;
                }
            }

            public volatile void success(Object obj, Response response)
            {
                success((LinkAccountsResult)obj, response);
            }

            
            {
                this$1 = RetrieveAvatarActivity._cls4.this;
                fbToken = s;
                super();
            }
        });
    }

    _cls1.val.fbToken()
    {
        this$0 = final_retrieveavataractivity;
        val$retrieveButton = button;
        val$skipText = textview;
        val$bsauthToken = s;
        val$context = Context.this;
        super();
    }
}
