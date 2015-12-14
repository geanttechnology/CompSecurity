// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.widget.FrameLayout;
import com.instamag.activity.library.activity.NewMagCountListActivity;
import com.loopj.android.http.JsonHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONObject;

public class bch extends JsonHttpResponseHandler
{

    final NewMagCountListActivity a;

    public bch(NewMagCountListActivity newmagcountlistactivity)
    {
        a = newmagcountlistactivity;
        super();
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONObject jsonobject)
    {
        if (jsonobject != null)
        {
            Log.v("NewMagCountListActivity", (new StringBuilder()).append("NewMagCountListActivityonFailure errorResponse:").append(jsonobject.toString()).toString());
        }
        NewMagCountListActivity.d(a).setVisibility(8);
    }

    public void onSuccess(int i, Header aheader[], JSONObject jsonobject)
    {
        if (i == 200 && jsonobject != null && NewMagCountListActivity.a(a, jsonobject))
        {
            NewMagCountListActivity.b(a).c("json_newMagLibrary_count");
            NewMagCountListActivity.b(a).a("json_newMagLibrary_count", jsonobject, 1800);
            NewMagCountListActivity.c(a);
        }
        NewMagCountListActivity.d(a).setVisibility(8);
    }
}
