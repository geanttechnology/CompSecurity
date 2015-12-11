// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

// Referenced classes of package com.amazon.device.ads:
//            MraidView, MraidCommandRegistry, MraidCommand

class this._cls0
    implements tor
{

    final MraidView this$0;

    public boolean execute(String s)
    {
        Object obj = URI.create(s);
        s = ((URI) (obj)).getHost();
        Object obj1 = URLEncodedUtils.parse(((URI) (obj)), "UTF-8");
        obj = new HashMap();
        NameValuePair namevaluepair;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((Map) (obj)).put(namevaluepair.getName(), namevaluepair.getValue()))
        {
            namevaluepair = (NameValuePair)((Iterator) (obj1)).next();
        }

        obj = MraidCommandRegistry.createCommand(s, ((Map) (obj)), MraidView.this);
        if (obj == null)
        {
            fireNativeCommandCompleteEvent(s);
            return false;
        } else
        {
            ((MraidCommand) (obj)).execute();
            fireNativeCommandCompleteEvent(s);
            return true;
        }
    }

    tor()
    {
        this$0 = MraidView.this;
        super();
    }
}
