// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseCallback2, ParseObject, ParseException

public interface RefreshCallback
    extends ParseCallback2
{

    public abstract void done(ParseObject parseobject, ParseException parseexception);
}
