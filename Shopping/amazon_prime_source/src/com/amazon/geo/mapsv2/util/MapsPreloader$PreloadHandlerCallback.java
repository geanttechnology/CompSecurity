// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.os.Message;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            MapsPreloader

class Controller
    implements android.os.HandlerCallback
{
    class Controller
        implements MapsInitializerInternal.PreloadController
    {

        public MapsInitializerInternal.PreloadResult result;
        final MapsPreloader.PreloadHandlerCallback this$1;

        public void cancel()
        {
            result = MapsInitializerInternal.PreloadResult.CANCELED;
        }

        Controller()
        {
            this$1 = MapsPreloader.PreloadHandlerCallback.this;
            super();
            result = MapsInitializerInternal.PreloadResult.OK;
        }
    }


    Controller mController;
    final MapsPreloader this$0;

    public boolean handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return false;

        case 1: // '\001'
            MapsPreloader.access$000(MapsPreloader.this).onPreloadStart(mController);
            break;
        }
        MapsPreloader.access$000(MapsPreloader.this).onPreloadEnd(mController.result);
        return true;
    }

    .OK()
    {
        this$0 = MapsPreloader.this;
        super();
        mController = new Controller();
    }
}
