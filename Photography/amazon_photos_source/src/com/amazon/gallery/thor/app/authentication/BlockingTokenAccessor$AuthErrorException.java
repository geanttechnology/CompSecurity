// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import android.os.Bundle;

// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            BlockingTokenAccessor

public class mBundle extends yException
{

    private Bundle mBundle;
    final BlockingTokenAccessor this$0;

    public yException(Bundle bundle)
    {
        this$0 = BlockingTokenAccessor.this;
        super(BlockingTokenAccessor.this);
        mBundle = bundle;
    }
}
