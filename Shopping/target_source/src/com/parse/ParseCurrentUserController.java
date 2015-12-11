// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;

// Referenced classes of package com.parse:
//            ParseObjectCurrentController, ParseUser

interface ParseCurrentUserController
    extends ParseObjectCurrentController
{

    public abstract j getAsync(boolean flag);

    public abstract j getCurrentSessionTokenAsync();

    public abstract j logOutAsync();

    public abstract j setIfNeededAsync(ParseUser parseuser);
}
