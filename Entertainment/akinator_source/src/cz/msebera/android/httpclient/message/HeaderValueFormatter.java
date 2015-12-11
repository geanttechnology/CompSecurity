// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

public interface HeaderValueFormatter
{

    public abstract CharArrayBuffer formatElements(CharArrayBuffer chararraybuffer, HeaderElement aheaderelement[], boolean flag);

    public abstract CharArrayBuffer formatHeaderElement(CharArrayBuffer chararraybuffer, HeaderElement headerelement, boolean flag);

    public abstract CharArrayBuffer formatNameValuePair(CharArrayBuffer chararraybuffer, NameValuePair namevaluepair, boolean flag);

    public abstract CharArrayBuffer formatParameters(CharArrayBuffer chararraybuffer, NameValuePair anamevaluepair[], boolean flag);
}
