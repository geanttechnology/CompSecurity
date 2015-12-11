// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.extension.medialets;

import java.util.HashMap;
import tv.freewheel.hybrid.ad.interfaces.IAdContext;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.ad.interfaces.IEventListener;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.extension.medialets:
//            MedialetsExtension

class this._cls0
    implements IEventListener
{

    final MedialetsExtension this$0;

    public void run(IEvent ievent)
    {
        MedialetsExtension.access$600(MedialetsExtension.this).debug("EVENT_REQUEST_COMPLETE");
        if ("false".equalsIgnoreCase((String)(String)ievent.getData().get(MedialetsExtension.access$300(MedialetsExtension.this).INFO_KEY_SUCCESS())))
        {
            MedialetsExtension.access$600(MedialetsExtension.this).error("The Request failed.");
            return;
        }
        if (MedialetsExtension.access$500(MedialetsExtension.this).getActivity() == null)
        {
            MedialetsExtension.access$600(MedialetsExtension.this).error("The activity is not set in the ad context.");
            return;
        }
        if (!MedialetsExtension.access$1000(MedialetsExtension.this))
        {
            MedialetsExtension.access$600(MedialetsExtension.this).info("There is NO any Medialets ad found, The extension will NOT start Medialets AdManager Service.");
            return;
        } else
        {
            MedialetsExtension.access$000(MedialetsExtension.this, true);
            MedialetsExtension.access$800(MedialetsExtension.this, dialetsAdmanagerState.START);
            return;
        }
    }

    dialetsAdmanagerState()
    {
        this$0 = MedialetsExtension.this;
        super();
    }
}
