// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn.scheme;


// Referenced classes of package com.comcast.cim.httpcomponentsandroid.conn.scheme:
//            SocketFactoryAdaptor, LayeredSocketFactory, LayeredSchemeSocketFactory

class LayeredSocketFactoryAdaptor extends SocketFactoryAdaptor
    implements LayeredSocketFactory
{

    private final LayeredSchemeSocketFactory factory;

    LayeredSocketFactoryAdaptor(LayeredSchemeSocketFactory layeredschemesocketfactory)
    {
        super(layeredschemesocketfactory);
        factory = layeredschemesocketfactory;
    }
}
