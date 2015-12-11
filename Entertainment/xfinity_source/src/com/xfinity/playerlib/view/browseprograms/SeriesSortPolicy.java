// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import com.xfinity.playerlib.model.comparator.DibicProgramNewProgramComparator;
import com.xfinity.playerlib.model.comparator.DibicProgramPopularityComparator;
import com.xfinity.playerlib.model.comparator.DibicProgramTitleComparator;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            SortPolicy

public class SeriesSortPolicy extends SortPolicy
{

    protected final Comparator newSortComparator = new DibicProgramNewProgramComparator();
    protected final Comparator popularityComparator = new DibicProgramPopularityComparator();
    protected final List sortTypes;
    protected final Comparator titleComparator = new DibicProgramTitleComparator(true);
    protected final PlayNowUserManager userManager;

    public SeriesSortPolicy(PlayNowUserManager playnowusermanager)
    {
        sortTypes = Collections.unmodifiableList(Arrays.asList(new SortPolicy.SortType[] {
            SortPolicy.SortType.POPULAR, SortPolicy.SortType.NEW, SortPolicy.SortType.ALPHA
        }));
        userManager = playnowusermanager;
    }

    public Comparator getComparator(SortPolicy.SortType sorttype)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[];

            static 
            {
                $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType = new int[SortPolicy.SortType.values().length];
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[SortPolicy.SortType.POPULAR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[SortPolicy.SortType.NEW.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType[SortPolicy.SortType.ALPHA.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType[sorttype.ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected sort type: ").append(sorttype).toString());

        case 1: // '\001'
            return popularityComparator;

        case 2: // '\002'
            return newSortComparator;

        case 3: // '\003'
            return titleComparator;
        }
    }

    public SortPolicy.SortType getCurrentSortType()
    {
        return ((PlayerUserSettings)userManager.getUserSettings()).getSeriesSort();
    }

    public List getSortTypes()
    {
        return sortTypes;
    }

    public void setCurrentSortType(SortPolicy.SortType sorttype)
    {
        ((PlayerUserSettings)userManager.getUserSettings()).setSeriesSort(sorttype);
    }
}
