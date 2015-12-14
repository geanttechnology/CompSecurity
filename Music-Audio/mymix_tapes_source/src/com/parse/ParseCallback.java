// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;


// Referenced classes of package com.parse:
//            ParseException

abstract class ParseCallback
{

    public ParseCallback()
    {
    }

    abstract void internalDone(Object obj, ParseException parseexception);
}
