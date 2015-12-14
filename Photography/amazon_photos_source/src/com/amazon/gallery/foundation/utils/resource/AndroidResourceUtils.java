// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.resource;

import android.content.Context;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

// Referenced classes of package com.amazon.gallery.foundation.utils.resource:
//            ResourceUtils

public class AndroidResourceUtils
    implements ResourceUtils
{

    public AndroidResourceUtils()
    {
    }

    public String loadResourceAsString(Context context, String s)
    {
        Context context1;
        Context context2;
        context2 = null;
        context1 = null;
        context = context.getClassLoader().getResourceAsStream(s);
        context1 = context;
        context2 = context;
        String s1 = IOUtils.toString(context);
        IOUtils.closeQuietly(context);
        return s1;
        context;
        context2 = context1;
        throw new RuntimeException((new StringBuilder()).append("Unable to read '").append(s).append("' as string.").toString(), context);
        context;
        IOUtils.closeQuietly(context2);
        throw context;
    }
}
