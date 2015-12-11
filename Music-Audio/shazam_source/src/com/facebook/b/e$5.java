// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.os.Bundle;
import org.json.JSONObject;

// Referenced classes of package com.facebook.b:
//            e

static final class 
    implements 
{

    public final void a(Bundle bundle, String s, Object obj)
    {
        bundle.putString(s, (String)obj);
    }

    public final void a(JSONObject jsonobject, String s, Object obj)
    {
        jsonobject.put(s, obj);
    }

    ()
    {
    }
}
