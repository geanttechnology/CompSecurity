// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.instamag.activity.library.model.TResTypeManager;
import com.loopj.android.http.JsonHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONObject;

public class bdi extends JsonHttpResponseHandler
{

    final TResTypeManager a;

    public bdi(TResTypeManager trestypemanager)
    {
        a = trestypemanager;
        super();
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONObject jsonobject)
    {
    }

    public void onSuccess(int i, Header aheader[], JSONObject jsonobject)
    {
        if (jsonobject != null && TResTypeManager.access$000(a, jsonobject))
        {
            TResTypeManager.access$100(a).c("json_magResTypeManagerUrl");
            TResTypeManager.access$100(a).a("json_magResTypeManagerUrl", jsonobject, 300);
        }
    }
}
