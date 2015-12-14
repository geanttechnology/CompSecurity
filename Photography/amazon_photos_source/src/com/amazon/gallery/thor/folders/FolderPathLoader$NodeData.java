// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.folders;


// Referenced classes of package com.amazon.gallery.thor.folders:
//            FolderPathLoader

private static class isRoot
{

    private final boolean isRoot;
    private final String name;
    private final String nodeId;

    public String getName()
    {
        return name;
    }

    public String getNodeId()
    {
        return nodeId;
    }

    public boolean isRootNode()
    {
        return isRoot;
    }

    public (String s, String s1, boolean flag)
    {
        nodeId = s;
        name = s1;
        isRoot = flag;
    }
}
