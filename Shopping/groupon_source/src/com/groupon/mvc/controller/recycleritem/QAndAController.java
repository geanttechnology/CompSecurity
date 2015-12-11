// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.Deal;
import com.groupon.models.country.Country;
import com.groupon.mvc.model.QandA;
import com.groupon.service.countryanddivision.CurrentCountryManager;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class QAndAController extends RecyclerItemViewController
{
    private class OnQandAClickListener
        implements android.view.View.OnClickListener
    {

        final QAndAController this$0;

        public void onClick(View view)
        {
            view = deal.remoteId;
            Context context = QAndAController.this.context;
            if (showNativeScreen)
            {
                view = intentFactory.newQaDiscussionsNativeIntent(view);
            } else
            {
                view = intentFactory.newQaDiscussionsIntent(view);
            }
            context.startActivity(view);
        }

        private OnQandAClickListener()
        {
            this$0 = QAndAController.this;
            super();
        }

    }


    private CurrentCountryManager currentCountryManager;
    private Deal deal;
    private IntentFactory intentFactory;
    private int postsCount;
    private boolean showNativeScreen;

    public QAndAController(Context context)
    {
        super(context);
    }

    public android.view.View.OnClickListener getCallback()
    {
        return new OnQandAClickListener();
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public void processData()
    {
        model = new QandA();
        Object obj = (QandA)model;
        Object obj1 = context;
        int i;
        boolean flag;
        if (currentCountryManager.getCurrentCountry().isRussia())
        {
            i = 0x7f080137;
        } else
        {
            i = 0x7f080444;
        }
        obj.title = ((Context) (obj1)).getString(i);
        obj1 = (QandA)model;
        if (postsCount > 0)
        {
            obj = context.getResources().getQuantityString(0x7f0c0016, postsCount, new Object[] {
                Integer.valueOf(postsCount)
            });
        } else
        {
            obj = context.getResources().getString(0x7f0802f3);
        }
        obj1.postsCountText = ((String) (obj));
        obj = (QandA)model;
        if (postsCount > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj.shouldShowCount = flag;
        setState(2);
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setPostsCount(int i)
    {
        setState(1);
        postsCount = i;
    }

    public void setShowNativeScreen(boolean flag)
    {
        setState(1);
        showNativeScreen = flag;
    }



}
