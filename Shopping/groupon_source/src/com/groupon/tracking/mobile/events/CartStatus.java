// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.events;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.msgpack.Packer;

// Referenced classes of package com.groupon.tracking.mobile.events:
//            MobileFunnelEvent

public class CartStatus extends MobileFunnelEvent
{

    public static int STATUS_LENGTH = 3072;
    public String cartUUID;
    public String extraInfo;
    public int numItems;
    public String status;
    public float totalPrice;

    public CartStatus()
    {
        cartUUID = "";
        status = "";
        numItems = 0;
        totalPrice = 0.0F;
        extraInfo = "";
        eventType = "GRP42";
    }

    public CartStatus(String s, String s1, String s2, int i, float f, EncodedNSTField encodednstfield)
    {
        super("GRP42", s);
        cartUUID = "";
        status = "";
        numItems = 0;
        totalPrice = 0.0F;
        extraInfo = "";
        cartUUID = s1;
        status = s2;
        numItems = i;
        totalPrice = f;
        if (encodednstfield != null)
        {
            extraInfo = encodednstfield.toEncodedString();
        }
    }

    public void pack(int i, Packer packer)
        throws IOException
    {
        int j = i;
        if (i == -1)
        {
            j = 11;
        }
        super.pack(j, packer);
        packer.pack(cartUUID);
        packer.pack(status);
        packer.pack(numItems);
        packer.pack(totalPrice);
        packer.pack(extraInfo);
    }

    public void reset()
    {
        super.reset();
        cartUUID = "";
        status = "";
        numItems = 0;
        totalPrice = 0.0F;
        extraInfo = "";
    }

    public String toString()
    {
        return (new StringBuilder("CartStatus")).append("[").append(cartUUID).append(",").append(status).append(",").append(numItems).append(",").append(totalPrice).append(",").append(extraInfo).append(",").append("]").toString();
    }

}
