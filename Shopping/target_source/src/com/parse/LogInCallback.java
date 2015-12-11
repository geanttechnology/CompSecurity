// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback2, ParseUser, ParseException

public interface LogInCallback
    extends ParseCallback2
{

    public abstract void done(ParseUser parseuser, ParseException parseexception);
}
