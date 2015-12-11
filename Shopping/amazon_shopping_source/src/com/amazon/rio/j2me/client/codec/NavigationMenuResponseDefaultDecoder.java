// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.NavigationMenuResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, NavMenuItemDefaultDecoder, DefaultDecoder, StreamedResponseListener

public class NavigationMenuResponseDefaultDecoder
    implements Decoder
{

    public NavigationMenuResponseDefaultDecoder()
    {
    }

    public NavigationMenuResponse decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new NavigationMenuResponse();
        streamedresponselistener.setMenuItems((List)DefaultDecoder.getArrayInstance(new NavMenuItemDefaultDecoder()).decode(datainputstream, null));
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
