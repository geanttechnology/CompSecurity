// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;

// Referenced classes of package com.medialets.thrift:
//            connectionState

final class d extends HashMap
{

    d()
    {
        put(Integer.valueOf(0), "MMNoConnection");
        put(Integer.valueOf(1), "MMUnknownConnection");
        put(Integer.valueOf(2), "MMCDNConnection");
        put(Integer.valueOf(3), "MMWiFiConnection");
    }
}
