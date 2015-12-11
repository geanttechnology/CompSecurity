// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseUser

interface ParseQueryController
{

    public abstract cu countAsync(ParseQuery.State state, ParseUser parseuser, cu cu);

    public abstract cu findAsync(ParseQuery.State state, ParseUser parseuser, cu cu);

    public abstract cu getFirstAsync(ParseQuery.State state, ParseUser parseuser, cu cu);
}
