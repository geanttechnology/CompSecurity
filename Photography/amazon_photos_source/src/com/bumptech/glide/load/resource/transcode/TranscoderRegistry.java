// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.util.MultiClassKey;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.bumptech.glide.load.resource.transcode:
//            UnitTranscoder, ResourceTranscoder

public class TranscoderRegistry
{

    private static final MultiClassKey GET_KEY = new MultiClassKey();
    private final Map factories = new HashMap();

    public TranscoderRegistry()
    {
    }

    public ResourceTranscoder get(Class class1, Class class2)
    {
        if (!class1.equals(class2)) goto _L2; else goto _L1
_L1:
        obj = UnitTranscoder.get();
_L4:
        return ((ResourceTranscoder) (obj));
_L2:
        ResourceTranscoder resourcetranscoder;
        synchronized (GET_KEY)
        {
            GET_KEY.set(class1, class2);
            resourcetranscoder = (ResourceTranscoder)factories.get(GET_KEY);
        }
        obj = resourcetranscoder;
        if (resourcetranscoder != null) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No transcoder registered for ").append(class1).append(" and ").append(class2).toString());
        class1;
        obj;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public void register(Class class1, Class class2, ResourceTranscoder resourcetranscoder)
    {
        factories.put(new MultiClassKey(class1, class2), resourcetranscoder);
    }

}
