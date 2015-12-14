// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import android.content.Context;
import java.io.InputStream;
import myobfuscated.v.ac;
import myobfuscated.v.ae;
import myobfuscated.v.ag;
import myobfuscated.v.am;
import myobfuscated.v.t;

// Referenced classes of package com.socialin.android.apiv3:
//            StringModelLoader

public class 
    implements ag
{

    private final ac modelCache = new ac(100);

    public ae build(Context context, am am1)
    {
        return new StringModelLoader(am1.a(myobfuscated/v/t, java/io/InputStream), modelCache);
    }

    public void teardown()
    {
    }

    public ()
    {
    }
}
