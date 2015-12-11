// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.amazon.retailsearch.android.ui.listadapter.ContentSwitcherController;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.listadapter.ModelViewEntry;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ContentSwitcherModel

public class ContentSwitcher extends FrameLayout
    implements ModelView
{

    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/results/ContentSwitcher);
    private View childView;
    private int childViewType;
    private ContentSwitcherModel contentSwitcherModel;

    public ContentSwitcher(Context context)
    {
        super(context);
        init();
    }

    public ContentSwitcher(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private void init()
    {
        childViewType = -1;
        childView = null;
    }

    public void build(ContentSwitcherModel contentswitchermodel)
    {
        if (contentswitchermodel == null || !contentswitchermodel.isValid())
        {
            log.error("build was called on an invalid model");
            setVisibility(8);
            return;
        }
        contentSwitcherModel = contentswitchermodel;
        if (childView != null && childViewType != contentswitchermodel.getDesiredChildViewType())
        {
            removeAllViews();
            init();
        }
        if (childView == null)
        {
            try
            {
                childViewType = contentswitchermodel.getDesiredChildViewType();
                childView = (new ModelViewEntry(childViewType, contentswitchermodel.getDesiredChildViewClass(), contentswitchermodel.getDesiredChildViewModel())).createView(this);
                ((ContentSwitcherController)childView).setContentSwitcher(this);
                addView(childView);
            }
            catch (Exception exception)
            {
                log.error("Error creating a child view", exception);
            }
        }
        try
        {
            ((ModelView)childView).build(contentswitchermodel.getDesiredChildViewModel());
            setVisibility(0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ContentSwitcherModel contentswitchermodel)
        {
            log.error("Error building a child view", contentswitchermodel);
        }
    }

    public volatile void build(Object obj)
    {
        build((ContentSwitcherModel)obj);
    }

    public void switchViews(int i, Class class1, Object obj)
    {
        if (contentSwitcherModel == null)
        {
            log.error("switchViews called before build set a model");
            return;
        } else
        {
            contentSwitcherModel.setDesiredChildViewType(i);
            contentSwitcherModel.setDesiredChildViewClass(class1);
            contentSwitcherModel.setDesiredChildViewModel(obj);
            build(contentSwitcherModel);
            return;
        }
    }

    public void switchViews(ContentSwitcherModel contentswitchermodel)
    {
        contentSwitcherModel.copy(contentswitchermodel);
        build(contentSwitcherModel);
    }

}
