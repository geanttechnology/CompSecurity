// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.crittercism.app.Crittercism;
import com.groupon.db.models.Finder;
import com.groupon.deeplink.DeepLinkValidator;
import com.groupon.deeplink.FinderCardDeepLinkValidator;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.callbacks.FinderCardCallback;
import com.groupon.v3.view.holder.GrouponViewHolder;
import com.groupon.view.widgetcards.FinderCardView;
import com.groupon.view.widgetcards.FrameViewContainer;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            Mapping, VersionableCard

public class FinderCardMapping extends Mapping
    implements VersionableCard
{

    private final DeepLinkValidator deepLinkValidator = new FinderCardDeepLinkValidator();

    public FinderCardMapping()
    {
        super(com/groupon/db/models/Finder);
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        universallistadapter = (Finder)universallistadapter.getItem(i);
        ((FrameViewContainer)(FrameViewContainer)viewholder.itemView).setInfo(universallistadapter);
        viewholder.itemView.setTag(0x7f100001, universallistadapter);
        viewholder = (FinderCardCallback)getCallback(com/groupon/v3/view/callbacks/FinderCardCallback);
        if (viewholder != null)
        {
            viewholder.onFinderCardBound(universallistadapter);
        }
    }

    public View createView(Context context)
    {
        return new FinderCardView(context);
    }

    public android.support.v7.widget.RecyclerView.ViewHolder createViewHolder(Context context, UniversalListAdapter universallistadapter)
    {
        return getHolderWithCallback(context, universallistadapter);
    }

    protected GrouponViewHolder getHolderWithCallback(Context context, UniversalListAdapter universallistadapter)
    {
        return new GrouponViewHolder(universallistadapter) {

            final FinderCardMapping this$0;
            final UniversalListAdapter val$universalListAdapter;

            public void onClick(View view)
            {
                FinderCardCallback findercardcallback = (FinderCardCallback)getCallback(com/groupon/v3/view/callbacks/FinderCardCallback);
                if (findercardcallback != null)
                {
                    findercardcallback.onFinderCardClicked(view, (Finder)universalListAdapter.getItem(getPosition()));
                }
            }

            
            {
                this$0 = FinderCardMapping.this;
                universalListAdapter = universallistadapter;
                super(final_view);
            }
        };
    }

    public boolean isSupported(Object obj)
    {
        boolean flag = false;
        if (!(obj instanceof Finder))
        {
            return false;
        }
        obj = (Finder)obj;
        if (Strings.isEmpty(((Finder) (obj)).titleText) || Strings.isEmpty(((Finder) (obj)).callToActionText) || !"Bookable".equalsIgnoreCase(((Finder) (obj)).type)) goto _L2; else goto _L1
_L1:
        boolean flag1 = deepLinkValidator.validateDeepLink(((Finder) (obj)).deepLink);
        flag = flag1;
_L3:
        return flag;
        obj;
        if (Ln.isDebugEnabled())
        {
            Ln.e(((Throwable) (obj)));
        } else
        {
            Crittercism.logHandledException(((Throwable) (obj)));
        }
        if (true) goto _L3; else goto _L2
_L2:
        return false;
    }
}
