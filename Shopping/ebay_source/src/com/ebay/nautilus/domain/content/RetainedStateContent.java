// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.RetainedState;
import java.io.Closeable;
import java.io.IOException;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            Content

public class RetainedStateContent extends Content
    implements Closeable
{

    private boolean _dispatched;
    private RetainedState _state;

    public RetainedStateContent(RetainedState retainedstate, Object obj, ResultStatus resultstatus)
    {
        super(obj, resultstatus);
        _state = retainedstate;
        _dispatched = false;
    }

    public boolean canDispatch()
    {
        if (_dispatched)
        {
            return false;
        } else
        {
            _dispatched = true;
            return true;
        }
    }

    public void close()
        throws IOException
    {
        if (_state != null)
        {
            _state.release();
            _state = null;
        }
    }
}
