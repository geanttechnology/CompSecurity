// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.weather.commons.video2;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.weather.commons.video2.dsx.VideoAsset;
import com.weather.dal2.cache.FileCache;
import com.weather.dal2.net.Receiver;
import com.weather.util.parsing.ValidationException;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.weather.commons.video2:
//            VideoAssetConnection

class val.userData
    implements Runnable
{

    final val.userData this$1;
    final String val$result;
    final Object val$userData;

    public void run()
    {
        VideoAsset videoasset = VideoAsset.fromJson(new JSONObject(Files.toString(new File(val$result), Charsets.UTF_8)));
        cess._mth000(this._cls1.this).onCompletion(videoasset, val$userData);
        return;
        Object obj;
        obj;
_L2:
        VideoAssetConnection.access$200(_fld0).invalidate(cess._mth100(this._cls1.this));
        cess._mth000(this._cls1.this).onError(((Throwable) (obj)), val$userData);
        return;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
        this$1 = final_;
        val$result = s;
        val$userData = Object.this;
        super();
    }
}
