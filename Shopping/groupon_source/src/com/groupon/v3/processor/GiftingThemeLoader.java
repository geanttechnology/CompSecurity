// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import com.groupon.db.dao.DaoGiftingCategory;
import com.groupon.db.dao.DaoGiftingTheme;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DerivedGiftTheme;
import com.groupon.db.models.GiftingCategory;
import com.groupon.db.models.GiftingTheme;
import com.groupon.db.models.Pagination;
import com.groupon.models.gift.DerivedGiftCategory;
import com.groupon.v3.processor.pipeline.ProcessingContext;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.processor:
//            BackgroundDataProcessor

public class GiftingThemeLoader extends BackgroundDataProcessor
{

    private static final String CATEGORY_UUID_FIELD_NAME = "categoryUuid";
    public static final String THUMBNAIL_SIZE = "t200x200.png";
    protected DaoGiftingCategory daoGiftingCategory;
    protected DaoGiftingTheme daoGiftingTheme;
    private String dbChannel;

    public GiftingThemeLoader(Context context, String s)
    {
        RoboGuice.getInjector(context).injectMembers(this);
        dbChannel = s;
    }

    public List process(List list, DealSubsetAttribute dealsubsetattribute, Pagination pagination, ProcessingContext processingcontext)
    {
        list = new ArrayList();
        dealsubsetattribute = daoGiftingCategory.queryForEq("channel", dbChannel).iterator();
_L1:
        if (!dealsubsetattribute.hasNext())
        {
            break MISSING_BLOCK_LABEL_182;
        }
        pagination = (GiftingCategory)dealsubsetattribute.next();
        Object obj = ((GiftingCategory) (pagination)).remoteId;
        pagination = ((GiftingCategory) (pagination)).displayName;
        processingcontext = new ArrayList();
        GiftingTheme giftingtheme;
        for (obj = daoGiftingTheme.queryForEq("categoryUuid", obj).iterator(); ((Iterator) (obj)).hasNext(); processingcontext.add(new DerivedGiftTheme((new StringBuilder()).append(giftingtheme.imageThumbnailUrl).append("t200x200.png").toString(), giftingtheme.id)))
        {
            giftingtheme = (GiftingTheme)((Iterator) (obj)).next();
        }

        try
        {
            list.add(new DerivedGiftCategory(pagination, processingcontext));
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            throw new RuntimeException(list);
        }
          goto _L1
        return list;
    }
}
