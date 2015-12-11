// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.util.PreferenceUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BSLoginActivity

class this._cls0
    implements Callback
{

    final BSLoginActivity this$0;

    public void failure(RetrofitError retrofiterror)
    {
        enableButtons();
    }

    public void success(AvatarInfo avatarinfo, Response response)
    {
        preferenceUtils.putString(0x7f06002a, avatarinfo.getId());
        setResult(-1);
        finish();
    }

    public volatile void success(Object obj, Response response)
    {
        success((AvatarInfo)obj, response);
    }

    ()
    {
        this$0 = BSLoginActivity.this;
        super();
    }
}
