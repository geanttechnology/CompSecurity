// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.util;

import java.io.IOException;

// Referenced classes of package com.comcast.playerplatform.analytics.java.util:
//            JsonFileIo

public static interface 
{

    public abstract Object fromJson(String s)
        throws IOException;

    public abstract String toJson(Object obj)
        throws IOException;
}
