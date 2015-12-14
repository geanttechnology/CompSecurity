// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit;

import java.util.List;

public interface Recognition
{
    public static interface Result
    {

        public abstract int getScore();

        public abstract String getText();
    }


    public abstract List getDetailedResults();

    public abstract Result getResult(int i);

    public abstract int getResultCount();

    public abstract String getSuggestion();
}
