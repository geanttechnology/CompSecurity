// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.models.AvatarInfo;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            InviteActivity

class this._cls0
    implements Callback
{

    final InviteActivity this$0;

    public void failure(RetrofitError retrofiterror)
    {
        retrofiterror.printStackTrace();
    }

    public void success(AvatarInfo avatarinfo, Response response)
    {
        InviteActivity.access$000(InviteActivity.this, avatarinfo.getId());
    }

    public volatile void success(Object obj, Response response)
    {
        success((AvatarInfo)obj, response);
    }

    ()
    {
        this$0 = InviteActivity.this;
        super();
    }
}
