// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseCallback, ParseException

class ParseMulticastDelegate
{

    private final List callbacks = new LinkedList();

    public ParseMulticastDelegate()
    {
    }

    public void clear()
    {
        callbacks.clear();
    }

    public void invoke(Object obj, ParseException parseexception)
    {
        for (Iterator iterator = (new ArrayList(callbacks)).iterator(); iterator.hasNext(); ((ParseCallback)iterator.next()).internalDone(obj, parseexception)) { }
    }

    public void subscribe(ParseCallback parsecallback)
    {
        callbacks.add(parsecallback);
    }

    public void unsubscribe(ParseCallback parsecallback)
    {
        callbacks.remove(parsecallback);
    }
}
