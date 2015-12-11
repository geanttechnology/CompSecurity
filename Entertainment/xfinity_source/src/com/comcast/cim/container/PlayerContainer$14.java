// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.container;

import com.comcast.cim.cmasl.cachelib.Normalizer;
import com.comcast.cim.cmasl.cachelib.NormalizerFactory;

// Referenced classes of package com.comcast.cim.container:
//            PlayerContainer

class this._cls0
    implements NormalizerFactory
{

    final PlayerContainer this$0;

    public Normalizer get(String s)
    {
        return new acyNormalizer(s, null);
    }

    acyNormalizer()
    {
        this$0 = PlayerContainer.this;
        super();
    }
}
