// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.select;

import org.jsoup.nodes.Node;

public interface NodeVisitor
{

    public abstract void head(Node node, int i);

    public abstract void tail(Node node, int i);
}
