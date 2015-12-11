// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.util.CharArrayBuffer;

// Referenced classes of package cz.msebera.android.httpclient:
//            Header

public interface FormattedHeader
    extends Header
{

    public abstract CharArrayBuffer getBuffer();

    public abstract int getValuePos();
}
