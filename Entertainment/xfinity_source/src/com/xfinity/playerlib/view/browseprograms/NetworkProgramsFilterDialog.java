// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.content.Intent;
import android.os.Bundle;
import com.comcast.cim.cmasl.utils.collections.CollectionUtils;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.List;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterDialog, NetworkBrowseFilterCategoriesPanel, BrowseFilterCategoriesPanel, DibicProgramFilter

public class NetworkProgramsFilterDialog extends BrowseFilterDialog
{

    private String categoryId;
    private long companyId;

    public NetworkProgramsFilterDialog()
    {
    }

    public static Bundle createBundle(Long long1, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putLong("companyId", long1.longValue());
        bundle.putString("categoryId", s);
        return bundle;
    }

    protected BrowseFilterCategoriesPanel createBrowseFilterCategoriesPanel()
    {
        return NetworkBrowseFilterCategoriesPanel.newInstance(isDualPanel);
    }

    protected DibicProgramFilter getFilter()
    {
        return ((PlayerUserSettings)userManager.getUserSettings()).getNetworkProgramsFilter(companyId, categoryId);
    }

    protected List getGenres(TagsRoot tagsroot)
    {
        List list;
        Network network;
        network = tagsroot.getNetworkByCompanyId(companyId);
        list = null;
        if (!categoryId.equals(OrderedTag.ALL_MOVIES.getId())) goto _L2; else goto _L1
_L1:
        list = network.getMovieGenres();
_L4:
        List list1 = list;
        if (CollectionUtils.nullOrEmpty(list))
        {
            list1 = tagsroot.getPublicMovieGenres();
        }
        return list1;
_L2:
        if (categoryId.equals(OrderedTag.ALL_TV.getId()))
        {
            list = tagsroot.getPublicTvGenres();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (companyId == 0L && categoryId == null)
        {
            bundle = getIntent().getExtras();
            companyId = bundle.getLong("companyId");
            categoryId = bundle.getString("categoryId");
        }
        Validate.notNull(Long.valueOf(companyId));
        Validate.notNull(categoryId);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("categoryId", categoryId);
        bundle.putLong("companyId", companyId);
    }

    protected void processSavedInstanceState(Bundle bundle)
    {
        companyId = bundle.getLong("companyId");
        categoryId = bundle.getString("categoryId");
        Validate.notNull(Long.valueOf(companyId));
        Validate.notNull(categoryId);
    }
}
