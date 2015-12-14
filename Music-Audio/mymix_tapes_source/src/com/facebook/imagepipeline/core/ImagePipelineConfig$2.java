// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.core;

import android.content.Context;
import com.facebook.common.internal.Supplier;
import java.io.File;

// Referenced classes of package com.facebook.imagepipeline.core:
//            ImagePipelineConfig

static final class val.context
    implements Supplier
{

    final Context val$context;

    public File get()
    {
        return val$context.getApplicationContext().getCacheDir();
    }

    public volatile Object get()
    {
        return get();
    }

    (Context context1)
    {
        val$context = context1;
        super();
    }
}
