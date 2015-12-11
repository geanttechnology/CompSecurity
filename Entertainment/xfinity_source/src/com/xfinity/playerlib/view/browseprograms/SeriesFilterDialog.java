// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.os.Bundle;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterDialog, DibicProgramFilter

public class SeriesFilterDialog extends BrowseFilterDialog
{

    public SeriesFilterDialog()
    {
    }

    protected DibicProgramFilter getFilter()
    {
        return ((PlayerUserSettings)userManager.getUserSettings()).getSeriesFilter();
    }

    protected List getGenres(TagsRoot tagsroot)
    {
        return tagsroot.getPublicTvGenres();
    }

    protected void processSavedInstanceState(Bundle bundle)
    {
    }
}
