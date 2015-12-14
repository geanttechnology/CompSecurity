// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;
import my.googlemusic.play.internet.Response;

// Referenced classes of package my.googlemusic.play.activities:
//            UpcomingActivity

class this._cls0
    implements my.googlemusic.play.interfaces.this._cls0
{

    final UpcomingActivity this$0;

    public void onFailure(Response response)
    {
        if (response.getStatus() == 6)
        {
            UpcomingActivity.access$300(UpcomingActivity.this).offline.setVisibility(0);
            ((TextView)findViewById(0x7f0d01a6)).setText("Upcoming are not available offline");
    /* block-local class not found */
    class _cls1 {}

            UpcomingActivity.access$300(UpcomingActivity.this).goToLibrary.setOnClickListener(new _cls1());
        }
        UpcomingActivity.access$200(UpcomingActivity.this, false);
    }

    public void onProgress(int i)
    {
    }

    public void onSuccess(Object obj)
    {
        if (obj instanceof List)
        {
            UpcomingActivity.access$100(UpcomingActivity.this, (List)obj);
        }
        UpcomingActivity.access$200(UpcomingActivity.this, false);
    }

    _cls1()
    {
        this$0 = UpcomingActivity.this;
        super();
    }
}
