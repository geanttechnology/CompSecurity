// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.util.Log;
import com.digidust.elokence.akinator.factories.AkLog;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

class this._cls0
    implements com.facebook.allback
{

    final AkActivity this$0;

    public void onCompleted(GraphResponse graphresponse)
    {
        graphresponse = graphresponse.getError();
        if (graphresponse != null)
        {
            Log.e("AkActivity", graphresponse.toString());
            signalScorePublished(false);
            return;
        } else
        {
            AkLog.d("AkActivity", "sendMyScore Ok !");
            signalScorePublished(true);
            return;
        }
    }

    ()
    {
        this$0 = AkActivity.this;
        super();
    }
}
