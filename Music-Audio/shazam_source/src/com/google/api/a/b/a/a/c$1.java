// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.b.a.a;

import android.util.JsonToken;
import com.google.api.a.e.i;

// Referenced classes of package com.google.api.a.b.a.a:
//            c

static final class 
{

    static final int a[];
    static final int b[];

    static 
    {
        b = new int[JsonToken.values().length];
        try
        {
            b[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            b[JsonToken.END_ARRAY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            b[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            b[JsonToken.END_OBJECT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            b[JsonToken.BOOLEAN.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            b[JsonToken.NULL.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            b[JsonToken.STRING.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            b[JsonToken.NUMBER.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            b[JsonToken.NAME.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        a = new int[i.values().length];
        try
        {
            a[i.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[i.c.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
