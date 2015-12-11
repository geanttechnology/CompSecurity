// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.adobe.mobile:
//            TargetWorker

class this._cls0
    implements Callable
{

    final call this$0;

    public volatile Object call()
    {
        return call();
    }

    public Map call()
    {
        String s = TargetWorker.access$200("mboxPC");
        Object obj = TargetWorker.access$200("mboxSession");
        StringBuilder stringbuilder = (new StringBuilder()).append(s);
        if (s.length() > 0)
        {
            s = "; ";
        } else
        {
            s = "";
        }
        s = stringbuilder.append(s).append(((String) (obj))).toString();
        obj = new HashMap();
        ((Map) (obj)).put("Cookie", s);
        return ((Map) (obj));
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
