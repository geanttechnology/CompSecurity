// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.io.IOException;
import java.io.InputStream;

public interface ObjectParser
{

    public abstract Object parse(InputStream inputstream, Class class1)
        throws IOException;
}
