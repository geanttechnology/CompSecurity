// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;

// Referenced classes of package com.parse:
//            ParseUser

interface ParseQueryController
{

    public abstract j countAsync(ParseQuery.State state, ParseUser parseuser, j j);

    public abstract j findAsync(ParseQuery.State state, ParseUser parseuser, j j);

    public abstract j getFirstAsync(ParseQuery.State state, ParseUser parseuser, j j);
}
