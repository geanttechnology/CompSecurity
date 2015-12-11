// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.cmasl.utils.container.LeftEither;
import com.comcast.cim.cmasl.utils.container.RightEither;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.Map;

public abstract class EitherJacksonMixIn
{
    public static abstract class LeftEitherMixIn
    {
    }

    public static abstract class RightEitherMixIn
    {
    }


    public static final Map MIX_IN_CONFIG;

    public EitherJacksonMixIn()
    {
    }

    static 
    {
        java.util.HashMap hashmap = Maps.newHashMap();
        hashmap.put(com/comcast/cim/cmasl/utils/container/Either, com/comcast/cim/utils/EitherJacksonMixIn);
        hashmap.put(com/comcast/cim/cmasl/utils/container/LeftEither, com/comcast/cim/utils/EitherJacksonMixIn$LeftEitherMixIn);
        hashmap.put(com/comcast/cim/cmasl/utils/container/RightEither, com/comcast/cim/utils/EitherJacksonMixIn$RightEitherMixIn);
        MIX_IN_CONFIG = Collections.unmodifiableMap(hashmap);
    }
}
