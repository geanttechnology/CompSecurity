// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.Tag;

public interface NetworkActionBarController
{

    public abstract void loadNetworkLogo(Network network);

    public abstract void loadNetworkLogoAndCategory(Network network, Tag tag);

    public abstract void setNetworkNameAndCategory(Network network, Tag tag);
}
