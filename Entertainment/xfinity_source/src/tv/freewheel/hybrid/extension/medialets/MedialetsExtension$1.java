// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.extension.medialets;

import tv.freewheel.hybrid.ad.interfaces.IAdContext;
import tv.freewheel.hybrid.ad.interfaces.IConstants;

// Referenced classes of package tv.freewheel.hybrid.extension.medialets:
//            MedialetsExtension

class this._cls0
    implements Runnable
{

    final MedialetsExtension this$0;

    public void run()
    {
        MedialetsExtension.access$000(MedialetsExtension.this, false);
        boolean _tmp = MedialetsExtension.access$102(true);
        MedialetsExtension.access$200(MedialetsExtension.this);
        MedialetsExtension.access$500(MedialetsExtension.this).addEventListener(MedialetsExtension.access$300(MedialetsExtension.this).EVENT_ACTIVITY_STATE_CHANGED(), MedialetsExtension.access$400(MedialetsExtension.this));
    }

    ()
    {
        this$0 = MedialetsExtension.this;
        super();
    }
}
