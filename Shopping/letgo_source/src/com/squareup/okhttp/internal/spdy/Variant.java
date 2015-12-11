// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import android.support.v7.apw;
import android.support.v7.apx;
import com.squareup.okhttp.Protocol;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameReader, FrameWriter

public interface Variant
{

    public abstract Protocol getProtocol();

    public abstract FrameReader newReader(apx apx, boolean flag);

    public abstract FrameWriter newWriter(apw apw, boolean flag);
}
