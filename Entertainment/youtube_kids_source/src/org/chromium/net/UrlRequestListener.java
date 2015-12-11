// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import java.nio.ByteBuffer;

// Referenced classes of package org.chromium.net:
//            ExtendedResponseInfo, ResponseInfo, UrlRequestException

public interface UrlRequestListener
{

    public abstract void a(ExtendedResponseInfo extendedresponseinfo);

    public abstract void a(ResponseInfo responseinfo);

    public abstract void a(ResponseInfo responseinfo, String s);

    public abstract void a(ResponseInfo responseinfo, ByteBuffer bytebuffer);

    public abstract void a(ResponseInfo responseinfo, UrlRequestException urlrequestexception);
}
