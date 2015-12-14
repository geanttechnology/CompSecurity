// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Set;

// Referenced classes of package com.parse:
//            PushConnection

public class this._cls0 extends this._cls0
{

    final PushConnection this$0;

    public this._cls0 runState()
    {
        this._cls0 _lcls0 = null;
        Set set = PushConnection.access$300(PushConnection.this)._mth0(new this._cls0[] {
            this._fld0, this._fld0
        });
        if (set.contains(this._fld0))
        {
            _lcls0 = new nit>(PushConnection.this);
        } else
        if (set.contains(this._fld0))
        {
            return new nit>(PushConnection.this, 0L);
        }
        return _lcls0;
    }

    public ()
    {
        this$0 = PushConnection.this;
        super(PushConnection.this);
    }
}
