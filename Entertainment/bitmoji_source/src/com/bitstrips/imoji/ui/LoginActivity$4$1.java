// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.DialogInterface;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.util.PreferenceUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            LoginActivity

class this._cls1
    implements android.content.ClickListener
{

    final is._cls0 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        LoginActivity.access$300(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/bitstrips/imoji/ui/LoginActivity$4

/* anonymous class */
    class LoginActivity._cls4
        implements Callback
    {

        final LoginActivity this$0;

        public void failure(RetrofitError retrofiterror)
        {
            LoginActivity.access$200(LoginActivity.this, true, new LoginActivity._cls4._cls1());
        }

        public void success(AvatarInfo avatarinfo, Response response)
        {
            preferenceUtils.putString(0x7f06002a, avatarinfo.getId());
            preferenceUtils.putBoolean(0x7f06008a, avatarinfo.hasBSAuthAccount());
            resolveNextActivityForUser();
        }

        public volatile void success(Object obj, Response response)
        {
            success((AvatarInfo)obj, response);
        }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
    }

}
