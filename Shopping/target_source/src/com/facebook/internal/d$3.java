// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.os.Bundle;
import org.json.JSONException;

// Referenced classes of package com.facebook.internal:
//            d

static final class 
    implements 
{

    public void a(Bundle bundle, String s, Object obj)
        throws JSONException
    {
        bundle.putLong(s, ((Long)obj).longValue());
    }

    ()
    {
    }
}
