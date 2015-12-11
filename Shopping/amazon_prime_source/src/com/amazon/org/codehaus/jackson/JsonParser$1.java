// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.org.codehaus.jackson;


// Referenced classes of package com.amazon.org.codehaus.jackson:
//            JsonParser, JsonToken

static class 
{

    static final int $SwitchMap$com$amazon$org$codehaus$jackson$JsonToken[];

    static 
    {
        $SwitchMap$com$amazon$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];
        try
        {
            $SwitchMap$com$amazon$org$codehaus$jackson$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$org$codehaus$jackson$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
