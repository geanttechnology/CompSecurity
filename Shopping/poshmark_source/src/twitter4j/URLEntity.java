// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package twitter4j;

import java.io.Serializable;

public interface URLEntity
    extends Serializable
{

    public abstract String getDisplayURL();

    public abstract int getEnd();

    public abstract String getExpandedURL();

    public abstract int getStart();

    public abstract String getURL();
}
