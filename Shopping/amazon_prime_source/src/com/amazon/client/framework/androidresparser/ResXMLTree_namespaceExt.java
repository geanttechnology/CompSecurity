// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;


// Referenced classes of package com.amazon.client.framework.androidresparser:
//            WordReader

public class ResXMLTree_namespaceExt
{

    public static final int sizeof = 8;
    public int prefix;
    public int uri;

    public ResXMLTree_namespaceExt()
    {
    }

    public static int readNamespace(byte abyte0[], int i, ResXMLTree_namespaceExt resxmltree_namespaceext)
    {
        resxmltree_namespaceext.prefix = WordReader.readBytesFrom(abyte0, i, 4);
        resxmltree_namespaceext.uri = WordReader.readBytesFrom(abyte0, i + 4, 4);
        return 8;
    }
}
