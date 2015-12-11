// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.home.StartFragment;
import com.ebay.mobile.home.channels.ChannelFragment;
import com.ebay.mobile.util.AdUtil;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.FwActivity;
import java.lang.ref.WeakReference;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment, DepartmentNameViewHolder, DepartmentNamesAdapter

public class DepartmentPageChangeListener
    implements android.support.v4.view.ViewPager.OnPageChangeListener
{

    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo LOGGER = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("DepartmentPager", 2, "Callbacks for Department Pager");
    private static final String LOG_TAG = "DepartmentPager";
    private final WeakReference activityReference;
    private final String channelName;
    private int currentPosition;
    private final WeakReference fragmentReference;
    private final RecyclerView navigationView;
    private int previousPosition;
    private int screenMidPointX;
    private int scrollStartPosition;

    public DepartmentPageChangeListener(StartFragment startfragment, RecyclerView recyclerview, Activity activity, String s)
    {
        currentPosition = 0;
        previousPosition = 0;
        scrollStartPosition = -1;
        screenMidPointX = 0;
        activityReference = new WeakReference(activity);
        fragmentReference = new WeakReference(startfragment);
        navigationView = recyclerview;
        channelName = s;
        startfragment = ((WindowManager)recyclerview.getContext().getSystemService("window")).getDefaultDisplay();
        recyclerview = new Point();
        startfragment.getSize(recyclerview);
        screenMidPointX = ((Point) (recyclerview)).x / 2;
    }

    public void onPageScrollStateChanged(int i)
    {
        Object obj;
        Object obj1;
        if (LOGGER.isLoggable)
        {
            FwLog.logMethod(LOGGER, new Object[] {
                Integer.valueOf(i)
            });
        }
        obj = (StartFragment)fragmentReference.get();
        obj1 = (Activity)activityReference.get();
        i;
        JVM INSTR tableswitch 0 1: default 72
    //                   0 223
    //                   1 73;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        scrollStartPosition = currentPosition;
        navigationView.setVisibility(0);
        if (obj != null && (obj1 instanceof com.ebay.mobile.home.StartFragment.StartChannelHost))
        {
            obj1 = (com.ebay.mobile.home.StartFragment.StartChannelHost)obj1;
            obj1 = ((com.ebay.mobile.home.StartFragment.StartChannelHost) (obj1)).getChannel(new int[] {
                ((com.ebay.mobile.home.StartFragment.StartChannelHost) (obj1)).getChannelIndex(ChannelEnum.SHOP), scrollStartPosition
            });
            if (obj1 != null)
            {
                obj = ((StartFragment) (obj)).getChildFragmentManager().findFragmentByTag(((Channel) (obj1)).getTrackingName());
                if (!(obj instanceof DepartmentFragment))
                {
                    continue; /* Loop/switch isn't completed */
                }
                obj = (DepartmentFragment)obj;
                ((DepartmentFragment) (obj)).setTitleVisibility(false);
                if (((DepartmentFragment) (obj)).isExpanded())
                {
                    ((DepartmentFragment) (obj)).dispatchCategoryExpansion(0.0F);
                    obj = (DepartmentNameViewHolder)navigationView.findViewHolderForAdapterPosition(scrollStartPosition);
                    if (obj != null)
                    {
                        ((DepartmentNameViewHolder) (obj)).setArrowVisible(false, false);
                        return;
                    }
                }
            }
        }
        continue; /* Loop/switch isn't completed */
        if (!(obj instanceof ChannelFragment)) goto _L1; else goto _L4
_L4:
        ((ChannelFragment)obj).setTitleVisibility(false);
        return;
_L2:
        if (currentPosition == scrollStartPosition && obj != null && (obj1 instanceof com.ebay.mobile.home.StartFragment.StartChannelHost))
        {
            Object obj2 = (com.ebay.mobile.home.StartFragment.StartChannelHost)obj1;
            obj2 = ((com.ebay.mobile.home.StartFragment.StartChannelHost) (obj2)).getChannel(new int[] {
                ((com.ebay.mobile.home.StartFragment.StartChannelHost) (obj2)).getChannelIndex(ChannelEnum.SHOP), currentPosition
            });
            if (obj2 != null)
            {
                obj2 = ((StartFragment) (obj)).getChildFragmentManager().findFragmentByTag(((Channel) (obj2)).getTrackingName());
                if (obj2 instanceof DepartmentFragment)
                {
                    obj2 = (DepartmentFragment)obj2;
                    Object obj3;
                    Channel channel;
                    boolean flag;
                    if (((DepartmentFragment) (obj2)).hasScrollOffset() || ((DepartmentFragment) (obj2)).isExpanded())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ((DepartmentFragment) (obj2)).setTitleVisibility(flag);
                    obj3 = navigationView;
                    if (flag)
                    {
                        i = 4;
                    } else
                    {
                        i = 0;
                    }
                    ((RecyclerView) (obj3)).setVisibility(i);
                    if (((DepartmentFragment) (obj2)).isExpanded())
                    {
                        ((DepartmentFragment) (obj2)).dispatchCategoryExpansion(1.0F);
                        obj2 = (DepartmentNameViewHolder)navigationView.findViewHolderForAdapterPosition(currentPosition);
                        if (obj2 != null)
                        {
                            ((DepartmentNameViewHolder) (obj2)).setArrowVisible(true, true);
                        }
                    }
                } else
                if (obj2 instanceof ChannelFragment)
                {
                    obj2 = (ChannelFragment)obj2;
                    boolean flag1 = ((ChannelFragment) (obj2)).hasScrollOffset();
                    ((ChannelFragment) (obj2)).setTitleVisibility(flag1);
                    obj2 = navigationView;
                    if (flag1)
                    {
                        i = 4;
                    } else
                    {
                        i = 0;
                    }
                    ((RecyclerView) (obj2)).setVisibility(i);
                }
            }
        }
        if (obj1 instanceof com.ebay.mobile.home.StartFragment.StartChannelHost)
        {
            obj3 = (com.ebay.mobile.home.StartFragment.StartChannelHost)obj1;
            i = ((com.ebay.mobile.home.StartFragment.StartChannelHost) (obj3)).getChannelIndex(ChannelEnum.SHOP);
            obj2 = ((com.ebay.mobile.home.StartFragment.StartChannelHost) (obj3)).getChannel(new int[] {
                i, currentPosition
            });
            channel = ((com.ebay.mobile.home.StartFragment.StartChannelHost) (obj3)).getChannel(new int[] {
                i, previousPosition
            });
            if (obj2 != null)
            {
                obj3 = new TrackingData("HomePage", TrackingType.PAGE_IMPRESSION);
                ((TrackingData) (obj3)).addKeyValuePair("chnl", channelName.toLowerCase(Locale.US), true);
                ((TrackingData) (obj3)).addKeyValuePair("subchnl", ((Channel) (obj2)).getTrackingName(), true);
                if (channel != null)
                {
                    ((TrackingData) (obj3)).addSourceIdentification(new SourceIdentification("HomePage", "carousel", TrackingData.sanitize(channel.getTrackingName())));
                }
                if (obj != null)
                {
                    obj = AdUtil.adsEnabledForShopSubChannel(((Channel) (obj2)).isDepartment, ((Channel) (obj2)).getTrackingName(), ((StartFragment) (obj)).getFwActivity().getEbayContext());
                    if (obj != null)
                    {
                        ((TrackingData) (obj3)).addExperimentServedTags((Treatment)((Pair) (obj)).second);
                    }
                }
                ((TrackingData) (obj3)).send(((Activity) (obj1)));
                return;
            }
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void onPageScrolled(int i, float f, int j)
    {
        if (LOGGER.isLoggable)
        {
            FwLog.logMethod(LOGGER, new Object[] {
                Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(j)
            });
        }
        LinearLayoutManager linearlayoutmanager = (LinearLayoutManager)navigationView.getLayoutManager();
        DepartmentNameViewHolder departmentnameviewholder = (DepartmentNameViewHolder)navigationView.findViewHolderForAdapterPosition(i);
        Object obj = (DepartmentNameViewHolder)navigationView.findViewHolderForAdapterPosition(i + 1);
        int k;
        if (departmentnameviewholder != null && departmentnameviewholder.isValid())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (obj != null && ((DepartmentNameViewHolder) (obj)).isValid())
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (j != 0 && k != 0)
        {
            j = departmentnameviewholder.itemView.getPaddingStart();
            k = ((DepartmentNameViewHolder) (obj)).itemView.getPaddingStart();
            TextView textview = departmentnameviewholder.nameView;
            obj = ((DepartmentNameViewHolder) (obj)).nameView;
            int l = ((android.view.ViewGroup.MarginLayoutParams)departmentnameviewholder.arrowView.getLayoutParams()).getMarginStart();
            int i1 = departmentnameviewholder.arrowView.getWidth();
            int j1;
            if (i == 0)
            {
                j = 0;
            } else
            {
                j = screenMidPointX - (textview.getMeasuredWidth() / 2 + j);
            }
            j1 = (textview.getMeasuredWidth() + ((View) (obj)).getMeasuredWidth()) / 2;
            linearlayoutmanager.scrollToPositionWithOffset(i, (int)((float)j - (float)(j1 + k + (i1 + l)) * f));
            return;
        }
        if (j != 0)
        {
            linearlayoutmanager.scrollToPositionWithOffset(i, screenMidPointX - departmentnameviewholder.nameView.getMeasuredWidth() / 2 - departmentnameviewholder.itemView.getPaddingStart());
            return;
        } else
        {
            linearlayoutmanager.scrollToPosition(i);
            return;
        }
    }

    public void onPageSelected(int i)
    {
        if (LOGGER.isLoggable)
        {
            FwLog.logMethod(LOGGER, new Object[] {
                Integer.valueOf(i)
            });
        }
        RecyclerContentAdapter recyclercontentadapter = (RecyclerContentAdapter)navigationView.getAdapter();
        if (recyclercontentadapter != null && (recyclercontentadapter instanceof DepartmentNamesAdapter))
        {
            ((DepartmentNamesAdapter)recyclercontentadapter).setCurrentPosition(i);
        }
        previousPosition = currentPosition;
        currentPosition = i;
    }

}
