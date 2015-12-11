// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.bitstrips.imoji.api.BSAuthResponse;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.models.BSAuthEmailLookup;
import com.bitstrips.imoji.models.LinkAccountsResult;
import com.bitstrips.imoji.ui.tasks.GetImageTask;
import com.bitstrips.imoji.util.PreferenceUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            SignUpActivity, RetrieveAvatarActivity, ImageLoader

class this._cls1
    implements Callback
{

    final up this$1;

    public void failure(RetrofitError retrofiterror)
    {
        finish();
    }

    public void success(BSAuthEmailLookup bsauthemaillookup, Response response)
    {
        if (bsauthemaillookup.matchFound().booleanValue())
        {
            try
            {
                (new GetImageTask(self, imageLoader) {

                    final SignUpActivity._cls4._cls2 this$2;

                    protected void onPostExecute(Bitmap bitmap)
                    {
                        RetrieveAvatarActivity.avatarBitmap = bitmap;
                        finish();
                    }

                    protected volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((Bitmap)obj);
                    }

            
            {
                this$2 = SignUpActivity._cls4._cls2.this;
                super(activity, imageloader);
            }
                }).execute(new String[] {
                    bsauthemaillookup.getURL()
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Response response)
            {
                Log.e("SignUpActivity", (new StringBuilder()).append("Failed to load image [").append(bsauthemaillookup.getURL()).append("]").toString(), response);
            }
            finish();
            return;
        } else
        {
            finish();
            return;
        }
    }

    public volatile void success(Object obj, Response response)
    {
        success((BSAuthEmailLookup)obj, response);
    }

    l.self()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/bitstrips/imoji/ui/SignUpActivity$4

/* anonymous class */
    class SignUpActivity._cls4
        implements Callback
    {

        final SignUpActivity this$0;
        final Activity val$self;

        public void failure(RetrofitError retrofiterror)
        {
        }

        public void success(BSAuthResponse bsauthresponse, Response response)
        {
            bsauthresponse = bsauthresponse.getAccessToken();
            preferenceUtils.putString(0x7f06003a, bsauthresponse);
            setResult(-1);
            response = facebookService.getToken();
            if (!TextUtils.isEmpty(response))
            {
                String s = getString(0x7f060017);
                bitstripsService.linkAccounts(response, bsauthresponse, s, new SignUpActivity._cls4._cls1());
                finish();
                return;
            } else
            {
                preferenceUtils.putBoolean(0x7f06009e, true);
                bitstripsService.bsAuthEmailLookup(bsauthresponse, new SignUpActivity._cls4._cls2());
                return;
            }
        }

        public volatile void success(Object obj, Response response)
        {
            success((BSAuthResponse)obj, response);
        }

            
            {
                this$0 = final_signupactivity;
                self = Activity.this;
                super();
            }

        // Unreferenced inner class com/bitstrips/imoji/ui/SignUpActivity$4$1

/* anonymous class */
        class SignUpActivity._cls4._cls1
            implements Callback
        {

            final SignUpActivity._cls4 this$1;

            public void failure(RetrofitError retrofiterror)
            {
            }

            public void success(LinkAccountsResult linkaccountsresult, Response response)
            {
            }

            public volatile void success(Object obj, Response response)
            {
                success((LinkAccountsResult)obj, response);
            }

                    
                    {
                        this$1 = SignUpActivity._cls4.this;
                        super();
                    }
        }

    }

}
