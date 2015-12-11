// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;


// Referenced classes of package com.amazon.ansel.fetch:
//            ResourceLoader, LoaderContext, ResourceListener

class val.result
    implements Runnable
{

    final val.result this$1;
    final Object val$result;

    public void run()
    {
        ResourceListener resourcelistener = getResourceListener();
        if (resourcelistener == null)
        {
            ResourceLoader.access$500(_fld0, "Result listener reference is stale");
            return;
        } else
        {
            ResourceLoader.access$200(_fld0).addReference(getResourceKey(), ResourceLoader.access$100(_fld0));
            ResourceLoader.access$500(_fld0, "Invoking result callback");
            resourcelistener.result(val$result);
            return;
        }
    }

    ()
    {
        this$1 = final_;
        val$result = Object.this;
        super();
    }
}
