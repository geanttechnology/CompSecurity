// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;


// Referenced classes of package com.twinprime.msgpack.unpacker:
//            Accept

final class MapAccept extends Accept
{

    int size;

    MapAccept()
    {
        super("map");
    }

    void acceptMap(int i)
    {
        size = i;
    }
}
