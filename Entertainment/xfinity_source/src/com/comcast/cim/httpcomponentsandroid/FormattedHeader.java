// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid;

import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid:
//            Header

public interface FormattedHeader
    extends Header
{

    public abstract CharArrayBuffer getBuffer();

    public abstract int getValuePos();
}
