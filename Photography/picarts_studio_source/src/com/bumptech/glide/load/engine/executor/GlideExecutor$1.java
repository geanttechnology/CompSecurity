// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.executor;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.bumptech.glide.load.engine.executor:
//            GlideExecutor

final class a
    implements FilenameFilter
{

    private Pattern a;

    public final boolean accept(File file, String s)
    {
        return a.matcher(s).matches();
    }

    (Pattern pattern)
    {
        a = pattern;
        super();
    }
}
