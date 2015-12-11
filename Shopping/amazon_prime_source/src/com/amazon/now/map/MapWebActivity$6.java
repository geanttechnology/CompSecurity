// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;


// Referenced classes of package com.amazon.now.map:
//            MapWebActivity

static class Type
{

    static final int $SwitchMap$com$amazon$now$map$MarkerInfo$MarkerType[];

    static 
    {
        $SwitchMap$com$amazon$now$map$MarkerInfo$MarkerType = new int[Type.values().length];
        try
        {
            $SwitchMap$com$amazon$now$map$MarkerInfo$MarkerType[Type.Destination.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$now$map$MarkerInfo$MarkerType[Type.Courier.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$now$map$MarkerInfo$MarkerType[Type.Origin.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
