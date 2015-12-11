// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.widget.Toast;
import com.facebook.FacebookRequestError;
import com.facebook.Response;
import com.facebook.model.GraphObject;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle:
//            FacebookHelperActivity

class this._cls0
    implements com.facebook.y._cls1
{

    final FacebookHelperActivity this$0;

    public void onCompleted(Response response)
    {
        JSONObject jsonobject = response.getGraphObject().getInnerJSONObject();
        try
        {
            jsonobject.getString("id");
        }
        catch (JSONException jsonexception)
        {
            Toast.makeText(getThis().getApplicationContext(), jsonexception.getLocalizedMessage(), 1).show();
            getThis().finish();
        }
        response = response.getError();
        if (response != null)
        {
            Toast.makeText(getThis().getApplicationContext(), response.getErrorMessage(), 1).show();
            getThis().finish();
            return;
        } else
        {
            Toast.makeText(getThis(), getThis().getString(0x7f0b00c7), 0).show();
            getThis().finish();
            return;
        }
    }

    ()
    {
        this$0 = FacebookHelperActivity.this;
        super();
    }
}
