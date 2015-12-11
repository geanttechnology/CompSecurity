// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;


// Referenced classes of package com.amazon.ansel.fetch:
//            ResourceLoader, LoaderContext, ResourceListener

class val.result
    implements Runnable
{

    final ResourceLoader this$0;
    final Object val$key;
    final Object val$result;

    public void run()
    {
        ResourceListener resourcelistener = getResourceListener();
        if (resourcelistener != null)
        {
            ResourceLoader.access$200(ResourceLoader.this).addReference(val$key, ResourceLoader.access$100(ResourceLoader.this));
            resourcelistener.result(val$result);
        }
    }

    ()
    {
        this$0 = final_resourceloader;
        val$key = obj;
        val$result = Object.this;
        super();
    }
}
