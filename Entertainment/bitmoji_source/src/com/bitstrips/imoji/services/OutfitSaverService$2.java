// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import com.bitstrips.imoji.models.AvatarInfo;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.services:
//            OutfitSaverService

class this._cls0
    implements Callback
{

    final OutfitSaverService this$0;

    public void failure(RetrofitError retrofiterror)
    {
        OutfitSaverService.access$100(OutfitSaverService.this);
    }

    public void success(AvatarInfo avatarinfo, Response response)
    {
        avatarinfo.saveToPreferences(preferenceUtils);
        OutfitSaverService.access$000(OutfitSaverService.this, avatarinfo);
    }

    public volatile void success(Object obj, Response response)
    {
        success((AvatarInfo)obj, response);
    }

    ()
    {
        this$0 = OutfitSaverService.this;
        super();
    }
}
