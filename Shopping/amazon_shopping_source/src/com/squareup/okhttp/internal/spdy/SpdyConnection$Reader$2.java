// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyConnection, FrameWriter

class this._cls1 extends NamedRunnable
{

    final er this$1;

    public void execute()
    {
        try
        {
            frameWriter.ackSettings();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    transient (String s, Object aobj[])
    {
        this$1 = this._cls1.this;
        super(s, aobj);
    }
}
