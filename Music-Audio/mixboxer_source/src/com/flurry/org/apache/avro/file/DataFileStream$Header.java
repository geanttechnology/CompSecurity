// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import com.flurry.org.apache.avro.Schema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            DataFileStream

public static final class <init>
{

    Map meta;
    private transient List metaKeyList;
    Schema schema;
    byte sync[];



/*
    static List access$102( , List list)
    {
        .metaKeyList = list;
        return list;
    }

*/

    private metaKeyList()
    {
        meta = new HashMap();
        metaKeyList = new ArrayList();
        sync = new byte[16];
    }

    sync(sync sync1)
    {
        this();
    }
}
