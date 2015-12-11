// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import java.util.List;

// Referenced classes of package com.ebay.mobile.following:
//            FollowedSearchViewModel

public class FollowedSearchViewHolder extends ViewHolder
{

    private final View blueDot;
    private final TextView description;
    private final ImageButton removeFollowButton;
    private final TextView title;
    private final ImageButton toggleNotificationButton;
    private final View view;

    public FollowedSearchViewHolder(View view1)
    {
        super(view1);
        view = view1;
        title = (TextView)view1.findViewById(0x7f1000de);
        description = (TextView)view1.findViewById(0x7f1000df);
        removeFollowButton = (ImageButton)view1.findViewById(0x7f10018b);
        blueDot = view1.findViewById(0x7f1000dd);
        toggleNotificationButton = (ImageButton)view1.findViewById(0x7f10018d);
    }

    public void bind(ViewModel viewmodel)
    {
        boolean flag1 = false;
        super.bind(viewmodel);
        if (!(viewmodel instanceof FollowedSearchViewModel))
        {
            throw new IllegalArgumentException("Model is not instance of FollowedSearchViewModel");
        }
        FollowedSearchViewModel followedsearchviewmodel = (FollowedSearchViewModel)viewmodel;
        title.setText(followedsearchviewmodel.title);
        int i;
        if (blueDot != null)
        {
            viewmodel = blueDot;
            Object obj;
            Resources resources;
            boolean flag;
            if (followedsearchviewmodel.hasNewItems)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            viewmodel.setVisibility(i);
        }
        if (toggleNotificationButton != null)
        {
            viewmodel = toggleNotificationButton;
            if (followedsearchviewmodel.isNotifyEnabled != null)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            viewmodel.setVisibility(i);
            if (followedsearchviewmodel.isNotifyEnabled != null)
            {
                viewmodel = toggleNotificationButton;
                if (followedsearchviewmodel.isNotifyEnabled.booleanValue())
                {
                    i = 0x7f020288;
                } else
                {
                    i = 0x7f020287;
                }
                viewmodel.setImageResource(i);
            }
        }
        viewmodel = "";
        resources = view.getResources();
        if (followedsearchviewmodel.isNotifyEnabled.booleanValue())
        {
            viewmodel = (new StringBuilder()).append("").append(resources.getString(0x7f070165)).toString();
        }
        if (followedsearchviewmodel.categoryId != null && !followedsearchviewmodel.categoryId.isEmpty())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        flag = i;
        if (i == 0)
        {
            flag = i;
            if (followedsearchviewmodel.constraints != null)
            {
                flag = i;
                if (followedsearchviewmodel.constraints.scopedAspect != null)
                {
                    flag = i;
                    if (!followedsearchviewmodel.constraints.scopedAspect.isEmpty())
                    {
                        obj = (com.ebay.nautilus.domain.data.Feed.Entities.Interest.ScopedAspect)followedsearchviewmodel.constraints.scopedAspect.get(0);
                        flag = i;
                        if (obj != null)
                        {
                            flag = i;
                            if (((com.ebay.nautilus.domain.data.Feed.Entities.Interest.ScopedAspect) (obj)).aspect != null)
                            {
                                flag = i;
                                if (!((com.ebay.nautilus.domain.data.Feed.Entities.Interest.ScopedAspect) (obj)).aspect.isEmpty())
                                {
                                    flag = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        obj = viewmodel;
        if (flag)
        {
            obj = viewmodel;
            if (!TextUtils.isEmpty(viewmodel))
            {
                obj = (new StringBuilder()).append(viewmodel).append(", ").toString();
            }
            obj = (new StringBuilder()).append(((String) (obj))).append(resources.getString(0x7f0701df)).toString();
        }
        description.setText(((CharSequence) (obj)));
        viewmodel = description;
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        viewmodel.setVisibility(i);
        if (followedsearchviewmodel.listener != null)
        {
            view.setOnClickListener(this);
            if (removeFollowButton != null)
            {
                removeFollowButton.setOnClickListener(this);
            }
            if (toggleNotificationButton != null)
            {
                toggleNotificationButton.setOnClickListener(this);
            }
        }
    }
}
