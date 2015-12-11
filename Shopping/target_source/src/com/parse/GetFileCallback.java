// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.io.File;

// Referenced classes of package com.parse:
//            ParseCallback2, ParseException

public interface GetFileCallback
    extends ParseCallback2
{

    public abstract void done(File file, ParseException parseexception);
}
