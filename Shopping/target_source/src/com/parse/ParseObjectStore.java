// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;

// Referenced classes of package com.parse:
//            ParseObject

interface ParseObjectStore
{

    public abstract j deleteAsync();

    public abstract j existsAsync();

    public abstract j getAsync();

    public abstract j setAsync(ParseObject parseobject);
}
