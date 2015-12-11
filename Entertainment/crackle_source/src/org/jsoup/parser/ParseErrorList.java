// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;

import java.util.ArrayList;

class ParseErrorList extends ArrayList
{

    private static final int INITIAL_CAPACITY = 16;
    private final int maxSize;

    ParseErrorList(int i, int j)
    {
        super(i);
        maxSize = j;
    }

    static ParseErrorList noTracking()
    {
        return new ParseErrorList(0, 0);
    }

    static ParseErrorList tracking(int i)
    {
        return new ParseErrorList(16, i);
    }

    boolean canAddError()
    {
        return size() < maxSize;
    }

    int getMaxSize()
    {
        return maxSize;
    }
}
