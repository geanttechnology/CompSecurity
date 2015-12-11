// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.util;

import android.util.JsonToken;

// Referenced classes of package com.amazon.now.util:
//            JsonDecoder

static class 
{

    static final int $SwitchMap$android$util$JsonToken[];

    static 
    {
        $SwitchMap$android$util$JsonToken = new int[JsonToken.values().length];
        try
        {
            $SwitchMap$android$util$JsonToken[JsonToken.BOOLEAN.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$android$util$JsonToken[JsonToken.NULL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$android$util$JsonToken[JsonToken.NUMBER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$android$util$JsonToken[JsonToken.STRING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$android$util$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$android$util$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$android$util$JsonToken[JsonToken.NAME.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$android$util$JsonToken[JsonToken.END_ARRAY.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$android$util$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$android$util$JsonToken[JsonToken.END_OBJECT.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
