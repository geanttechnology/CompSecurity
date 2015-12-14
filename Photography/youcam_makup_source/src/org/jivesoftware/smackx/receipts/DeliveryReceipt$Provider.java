// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.receipts;

import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smack.provider.EmbeddedExtensionProvider;

// Referenced classes of package org.jivesoftware.smackx.receipts:
//            DeliveryReceipt

public class  extends EmbeddedExtensionProvider
{

    protected f a(String s, String s1, Map map, List list)
    {
        return new DeliveryReceipt((String)map.get("id"));
    }

    public ()
    {
    }
}
