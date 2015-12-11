// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import com.comcast.cim.android.sideribbon.SideMenuBuilder;
import com.comcast.cim.android.sideribbon.SlideClosedRequestListener;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.config.PlayerConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.flyinmenu:
//            FlyinMenuAdapter, FlyinMenuOptions, PlayerActivityStarter

public class PlayerSideMenuBuilder
    implements SideMenuBuilder
{

    private List adapters;

    public PlayerSideMenuBuilder(Context context)
    {
        adapters = new ArrayList();
        List list;
        for (Iterator iterator = PlayerContainer.getInstance().getConfiguration().getFlyinMenuOptions().iterator(); iterator.hasNext(); adapters.add(new FlyinMenuAdapter(context, list)))
        {
            list = (List)iterator.next();
        }

    }

    private void inflateMenuGroup(final Activity activity, ViewGroup viewgroup, FlyinMenuAdapter flyinmenuadapter, final SlideClosedRequestListener slideClosedRequestListener)
    {
        for (int i = 0; flyinmenuadapter.getCount() > i; i++)
        {
            final FlyinMenuOptions item = flyinmenuadapter.getItem(i);
            View view = flyinmenuadapter.getView(i, null, viewgroup);
            int l = ((ViewGroup)view).getChildCount();
            if (!activity.getClass().equals(item.getActivity()))
            {
                view.setOnClickListener(new android.view.View.OnClickListener() {

                    final PlayerSideMenuBuilder this$0;
                    final Activity val$activity;
                    final FlyinMenuOptions val$item;
                    final SlideClosedRequestListener val$slideClosedRequestListener;

                    public void onClick(View view1)
                    {
                        slideClosedRequestListener.slideClosed(new PlayerActivityStarter(item.getActivity(), activity));
                    }

            
            {
                this$0 = PlayerSideMenuBuilder.this;
                slideClosedRequestListener = slideclosedrequestlistener;
                item = flyinmenuoptions;
                activity = activity1;
                super();
            }
                });
                ((Checkable)view).setChecked(false);
                for (int j = 0; j < l; j++)
                {
                    ((ViewGroup)view).getChildAt(j).setSelected(false);
                }

            } else
            {
                view.setOnClickListener(new android.view.View.OnClickListener() {

                    final PlayerSideMenuBuilder this$0;
                    final SlideClosedRequestListener val$slideClosedRequestListener;

                    public void onClick(View view1)
                    {
                        slideClosedRequestListener.slideClosed(null);
                    }

            
            {
                this$0 = PlayerSideMenuBuilder.this;
                slideClosedRequestListener = slideclosedrequestlistener;
                super();
            }
                });
                ((Checkable)view).setChecked(true);
                for (int k = 0; k < l; k++)
                {
                    ((ViewGroup)view).getChildAt(k).setSelected(true);
                }

            }
            viewgroup.addView(view);
        }

    }

    public View build(Activity activity, ViewGroup viewgroup, SlideClosedRequestListener slideclosedrequestlistener)
    {
        viewgroup = (ViewGroup)activity.getLayoutInflater().inflate(com.xfinity.playerlib.R.layout.flyin_menu, viewgroup, false);
        LinearLayout linearlayout = (LinearLayout)viewgroup.findViewById(com.xfinity.playerlib.R.id.flyin_menu_groups);
        LinearLayout linearlayout1;
        for (Iterator iterator = adapters.iterator(); iterator.hasNext(); linearlayout.addView(linearlayout1))
        {
            FlyinMenuAdapter flyinmenuadapter = (FlyinMenuAdapter)iterator.next();
            linearlayout1 = new LinearLayout(activity);
            linearlayout1.setOrientation(1);
            linearlayout1.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
            inflateMenuGroup(activity, linearlayout1, flyinmenuadapter, slideclosedrequestlistener);
        }

        return viewgroup;
    }
}
