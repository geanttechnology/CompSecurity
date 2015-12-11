// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.message;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;

public interface LineFormatter
{

    public abstract CharArrayBuffer formatHeader(CharArrayBuffer chararraybuffer, Header header);

    public abstract CharArrayBuffer formatRequestLine(CharArrayBuffer chararraybuffer, RequestLine requestline);

    public abstract CharArrayBuffer formatStatusLine(CharArrayBuffer chararraybuffer, StatusLine statusline);
}
