// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

public interface LineFormatter
{

    public abstract CharArrayBuffer appendProtocolVersion(CharArrayBuffer chararraybuffer, ProtocolVersion protocolversion);

    public abstract CharArrayBuffer formatHeader(CharArrayBuffer chararraybuffer, Header header);

    public abstract CharArrayBuffer formatRequestLine(CharArrayBuffer chararraybuffer, RequestLine requestline);

    public abstract CharArrayBuffer formatStatusLine(CharArrayBuffer chararraybuffer, StatusLine statusline);
}
