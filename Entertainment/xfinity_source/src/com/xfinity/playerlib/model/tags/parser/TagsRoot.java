// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags.parser;

import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import java.util.List;
import java.util.Set;

public interface TagsRoot
{

    public abstract Set getAllPublicGenres();

    public abstract String getClient();

    public abstract OrderedTag getGenreById(String s);

    public abstract Network getNetworkByCompanyId(long l);

    public abstract List getNetworks();

    public abstract Set getNetworksByCompanyIds(List list);

    public abstract List getPublicMovieGenres();

    public abstract List getPublicTvGenres();
}
