// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            DibicProgram

public interface DibicResource
{

    public abstract Map getGenreMapForNetwork(Network network);

    public abstract DibicProgram getProgramByMerlinId(MerlinId merlinid);

    public abstract List getPrograms();

    public abstract List getProgramsMatchingGenreAndNetwork(OrderedTag orderedtag, Network network);

    public abstract Map getProgramsMatchingGenresAndNetwork(List list, Network network);

    public abstract List getProgramsMatchingTitleFilter(String s);
}
