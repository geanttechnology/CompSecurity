// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.flurry.android.FlurryAgent;
import com.fotoable.sketch.activity.TTieZhiActivity;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;
import com.loopj.android.http.JsonHttpResponseHandler;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.json.JSONObject;

public class avi extends JsonHttpResponseHandler
{

    final TTieZhiActivity a;

    public avi(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONObject jsonobject)
    {
        if (!a.E)
        {
            a.t = true;
            a.n.setIsFinishLoad(a.t);
            a.n.jumpToIndex(4);
            aheader = new HashMap();
            aheader.put("errorcode", (new StringBuilder()).append("").append(i).toString());
            FlurryAgent.logEvent("TieZhiRequestFailed", aheader);
            if (jsonobject != null)
            {
                Log.v("TTieZhiActivity", (new StringBuilder()).append("TTieZhiActivityonFailure errorResponse:").append(jsonobject.toString()).toString());
                return;
            }
        }
    }

    public void onSuccess(int i, Header aheader[], JSONObject jsonobject)
    {
        a.t = true;
        if (i == 200 && jsonobject != null)
        {
            TTieZhiActivity.a(a, jsonobject, false);
        }
    }
}
