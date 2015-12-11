// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core;

import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.core:
//            JsonProcessingException, TreeNode, JsonParser, JsonGenerator

public abstract class TreeCodec
{

    public TreeCodec()
    {
    }

    public abstract TreeNode createArrayNode();

    public abstract TreeNode createObjectNode();

    public abstract TreeNode readTree(JsonParser jsonparser)
        throws IOException, JsonProcessingException;

    public abstract JsonParser treeAsTokens(TreeNode treenode);

    public abstract void writeTree(JsonGenerator jsongenerator, TreeNode treenode)
        throws IOException, JsonProcessingException;
}
