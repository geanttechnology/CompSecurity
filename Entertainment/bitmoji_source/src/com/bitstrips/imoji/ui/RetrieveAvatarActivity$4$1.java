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

class val.fbToken
    implements Callback
{

    final success this$1;
    final String val$fbToken;

    public void failure(RetrofitError retrofiterror)
    {
        RetrieveAvatarActivity.access$000(_fld0);
    }

    public void success(LinkAccountsResult linkaccountsresult, Response response)
    {
        if (linkaccountsresult.success().booleanValue())
        {
            linkaccountsresult = context.getString(0x7f060017);
            bitstripsService.getAvatarInfo(val$fbToken, bsauthToken, linkaccountsresult, new Callback() {

                final RetrieveAvatarActivity._cls4._cls1 this$2;

                public void failure(RetrofitError retrofiterror)
                {
                    RetrieveAvatarActivity.access$000(this$0);
                }

                public void success(AvatarInfo avatarinfo, Response response1)
                {
                    preferenceUtils.putString(0x7f06002a, avatarinfo.getId());
                    RetrieveAvatarActivity.access$000(this$0);
                }

                public volatile void success(Object obj, Response response1)
                {
                    success((AvatarInfo)obj, response1);
                }

            
            {
                this$2 = RetrieveAvatarActivity._cls4._cls1.this;
                super();
            }
            });
            return;
        } else
        {
            RetrieveAvatarActivity.access$000(_fld0);
            return;
        }
    }

    public volatile void success(Object obj, Response response)
    {
        success((LinkAccountsResult)obj, response);
    }

    l.context()
    {
        this$1 = final_context;
        val$fbToken = String.this;
        super();
    }

    // Unreferenced inner class com/bitstrips/imoji/ui/RetrieveAvatarActivity$4

/* anonymous class */
    class RetrieveAvatarActivity._cls4
        implements com.bitstrips.imoji.auth.FacebookService.SessionOpenCallback
    {

        final RetrieveAvatarActivity this$0;
        final String val$bsauthToken;
        final Context val$context;
        final Button val$retrieveButton;
        final TextView val$skipText;

        public void onOpened()
        {
            retrieveButton.setEnabled(false);
            retrieveButton.setAlpha(0.3F);
            skipText.setEnabled(false);
            skipText.setAlpha(0.3F);
            String s = facebookService.getToken();
            String s1 = getString(0x7f060017);
            bitstripsService.linkAccounts(s, bsauthToken, s1, s. new RetrieveAvatarActivity._cls4._cls1());
        }

            
            {
                this$0 = final_retrieveavataractivity;
                retrieveButton = button;
                skipText = textview;
                bsauthToken = s;
                context = Context.this;
                super();
            }
    }

}
