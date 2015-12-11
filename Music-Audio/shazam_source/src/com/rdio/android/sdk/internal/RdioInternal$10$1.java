// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import android.os.Handler;
import android.util.Log;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.pubsub.PubSubConnection;
import com.rdio.android.sdk.RdioListener;
import com.rdio.android.sdk.RdioResponseListener;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.sdk.internal:
//            RdioInternal, EventUploader, PlayerManagerInternal

class this._cls1
    implements Runnable
{

    final Playback this$1;

    public void run()
    {
        RdioInternal.access$100(_fld0).onRdioReadyForPlayback();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/rdio/android/sdk/internal/RdioInternal$10

/* anonymous class */
    class RdioInternal._cls10
        implements RdioResponseListener
    {

        final RdioInternal this$0;

        public void onResponse(RdioApiResponse rdioapiresponse)
        {
            if (!rdioapiresponse.isSuccess())
            {
                Log.e(RdioInternal.access$600(RdioInternal.this), "The playback token response failed");
                postOnError(com.rdio.android.sdk.Rdio.RdioError.PLAYBACK_TOKEN, "The playback token response failed");
                return;
            }
            try
            {
                RdioInternal.access$702(RdioInternal.this, ((JSONObject)rdioapiresponse.getResult()).getString("result"));
            }
            // Misplaced declaration of an exception variable
            catch (RdioApiResponse rdioapiresponse)
            {
                Log.e(RdioInternal.access$600(RdioInternal.this), (new StringBuilder("There was an error parsing the playbackToken ")).append(rdioapiresponse).toString());
                postOnError(com.rdio.android.sdk.Rdio.RdioError.PLAYBACK_TOKEN, "There was a problem parsing the playback token request");
                return;
            }
            RdioInternal.access$800(RdioInternal.this).setPlaybackToken(RdioInternal.access$700(RdioInternal.this));
            RdioInternal.access$900(RdioInternal.this).setPlaybackToken(RdioInternal.access$700(RdioInternal.this));
            RdioInternal.access$1000(RdioInternal.this).disconnect();
            RdioInternal.access$1000(RdioInternal.this).connect();
            RdioInternal.access$1100(RdioInternal.this).post(new RdioInternal._cls10._cls1());
        }

            
            {
                this$0 = RdioInternal.this;
                super();
            }
    }

}
