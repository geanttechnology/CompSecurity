// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import com.groupon.db.dao.DaoGiftingTheme;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DerivedGiftTheme;
import com.groupon.db.models.GiftingTheme;
import com.groupon.db.models.Pagination;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class GiftingThemePreviewLoader extends BackgroundDataProcessor
{

    protected DaoGiftingTheme daoGiftingTheme;
    private String themeId;

    public GiftingThemePreviewLoader(Context context, String s)
    {
        RoboGuice.getInjector(context).injectMembers(this);
        themeId = s;
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        list = new ArrayList();
        try
        {
            dealsubsetattribute = (GiftingTheme)daoGiftingTheme.queryForFirstEq("id", themeId);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new RuntimeException(list);
        }
        if (dealsubsetattribute == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        list.add(new DerivedGiftTheme((new StringBuilder()).append(((GiftingTheme) (dealsubsetattribute)).imageThumbnailUrl).append("t200x200.png").toString(), ((GiftingTheme) (dealsubsetattribute)).id));
        return list;
    }
}
