// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.facebook.share.internal:
//            VideoUploader

class init> extends init>
{

    static final Set transientErrorCodes = new _cls1();

    protected void enqueueRetry(int i)
    {
        VideoUploader.access$500(uploadContext, i);
    }

    public Bundle getParameters()
    {
        Bundle bundle = new Bundle();
        bundle.putString("upload_phase", "start");
        bundle.putLong("file_size", uploadContext.ize);
        return bundle;
    }

    protected Set getTransientErrorCodes()
    {
        return transientErrorCodes;
    }

    protected void handleError(FacebookException facebookexception)
    {
        VideoUploader.access$400(facebookexception, "Error starting video upload", new Object[0]);
        endUploadWithFailure(facebookexception);
    }

    protected void handleSuccess(JSONObject jsonobject)
    {
        uploadContext.nId = jsonobject.getString("upload_session_id");
        uploadContext.d = jsonobject.getString("video_id");
        String s = jsonobject.getString("start_offset");
        jsonobject = jsonobject.getString("end_offset");
        VideoUploader.access$300(uploadContext, s, jsonobject, 0);
    }


    public _cls1(_cls1 _pcls1, int i)
    {
        super(_pcls1, i);
    }

    class _cls1 extends HashSet
    {

            _cls1()
            {
                add(Integer.valueOf(6000));
            }
    }

}
