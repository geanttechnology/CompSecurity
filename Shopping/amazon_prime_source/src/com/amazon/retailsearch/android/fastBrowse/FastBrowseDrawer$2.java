// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import com.amazon.retailsearch.android.categoryBrowse.CategoryBrowseController;
import com.amazon.retailsearch.android.ui.refinements.SpinnerHiderRelativeLayout;
import com.amazon.retailsearch.log.MessageLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseDrawer, FastBrowseItemClickListener, FastBrowseItem

class this._cls0
    implements android.widget.lickListener
{

    final FastBrowseDrawer this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        FastBrowseDrawer.access$400(FastBrowseDrawer.this).setVisibility(8);
        for (adapterview = FastBrowseDrawer.access$500(FastBrowseDrawer.this).iterator(); adapterview.hasNext(); ((FastBrowseItemClickListener)adapterview.next()).onBackButtonClick()) { }
          goto _L3
_L2:
        adapterview = ((FastBrowseItem)FastBrowseDrawer.access$000(FastBrowseDrawer.this).get(i)).getBrowseUrl();
        if (adapterview != null && !adapterview.isEmpty()) goto _L4; else goto _L3
_L3:
        return;
_L4:
        int j;
        boolean flag;
        j = 0;
        flag = false;
        if (i == 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        FastBrowseDrawer.access$602(FastBrowseDrawer.this, adapterview);
        view = Uri.parse(CategoryBrowseController.buildCategoryBrowseLink(Uri.parse(FastBrowseDrawer.access$600(FastBrowseDrawer.this)))).getQueryParameter("node");
        if (CategoryBrowseController.shouldLaunchAIVBrowse(view))
        {
            adapterview = FastBrowseDrawer.access$500(FastBrowseDrawer.this).iterator();
            while (adapterview.hasNext()) 
            {
                ((FastBrowseItemClickListener)adapterview.next()).onAIVItemClick();
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!CategoryBrowseController.shouldLaunchAppStoreBrowse(view))
        {
            break; /* Loop/switch isn't completed */
        }
        adapterview = FastBrowseDrawer.access$500(FastBrowseDrawer.this).iterator();
        while (adapterview.hasNext()) 
        {
            ((FastBrowseItemClickListener)adapterview.next()).onAppStoreItemClick();
        }
        if (true) goto _L3; else goto _L5
_L5:
        view = FastBrowseDrawer.access$500(FastBrowseDrawer.this).iterator();
        i = ((flag) ? 1 : 0);
        do
        {
            j = i;
            if (!view.hasNext())
            {
                break;
            }
            FastBrowseItemClickListener fastbrowseitemclicklistener = (FastBrowseItemClickListener)view.next();
            if (i != 0 || fastbrowseitemclicklistener.onItemClick(FastBrowseDrawer.access$600(FastBrowseDrawer.this)))
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } while (true);
        if (j != 0) goto _L3; else goto _L6
_L6:
        FastBrowseDrawer.access$700(FastBrowseDrawer.this).show();
        try
        {
            FastBrowseDrawer.access$800(FastBrowseDrawer.this, adapterview);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            FastBrowseDrawer.access$900().error("Could not fetch refinements", adapterview);
        }
        return;
    }

    ativeLayout()
    {
        this$0 = FastBrowseDrawer.this;
        super();
    }
}
