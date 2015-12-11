// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import com.fasterxml.jackson.core.JsonToken;

// Referenced classes of package co.vine.android.api:
//            VineParsers

static class n
{

    static final int $SwitchMap$com$fasterxml$jackson$core$JsonToken[];

    static 
    {
        $SwitchMap$com$fasterxml$jackson$core$JsonToken = new int[JsonToken.values().length];
        try
        {
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_OBJECT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.START_ARRAY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$fasterxml$jackson$core$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
