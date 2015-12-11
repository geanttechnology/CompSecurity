// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.web;

import com.amazon.ansel.fetch.tools.collection.CollectionMap;
import java.io.IOException;

// Referenced classes of package com.amazon.ansel.fetch.tools.web:
//            RequestContent, WebConnection

public interface WebClient
{

    public abstract WebConnection createConnection(String s, String s1, CollectionMap collectionmap, RequestContent requestcontent)
        throws IOException;
}
