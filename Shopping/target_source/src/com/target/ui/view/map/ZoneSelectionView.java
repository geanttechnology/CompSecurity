// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pointinside.model.Venue;
import com.pointinside.model.Zone;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZoneSelectionView extends LinearLayout
{
    private static class a
    {

        final View arrow;
        final View container;
        final TextView currentZone;
        final View currentZoneWrapper;
        final LinearLayout otherZonesWrapper;

        public a(View view)
        {
            container = view.findViewById(0x7f1005f0);
            arrow = view.findViewById(0x7f1005f3);
            currentZone = (TextView)view.findViewById(0x7f1005f2);
            currentZoneWrapper = view.findViewById(0x7f1005f1);
            otherZonesWrapper = (LinearLayout)view.findViewById(0x7f1005f4);
        }
    }

    public static final class b extends Enum
    {

        private static final b $VALUES[];
        public static final b HIGHER;
        public static final b LOWER;
        public static final b NO_CHANGE;

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/target/ui/view/map/ZoneSelectionView$b, s);
        }

        public static b[] values()
        {
            return (b[])$VALUES.clone();
        }

        static 
        {
            NO_CHANGE = new b("NO_CHANGE", 0);
            HIGHER = new b("HIGHER", 1);
            LOWER = new b("LOWER", 2);
            $VALUES = (new b[] {
                NO_CHANGE, HIGHER, LOWER
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface c
    {

        public abstract void B();

        public abstract void a(b b1, Zone zone);
    }


    private boolean mAnimating;
    private int mCurrentZoneIdx;
    private List mListeners;
    private Zone mNewZone;
    private int mPreviousZoneIdx;
    private boolean mShowingOtherZones;
    private Venue mVenue;
    private String mVenueUuid;
    private a mViews;

    public ZoneSelectionView(Context context)
    {
        super(context);
        mAnimating = false;
        a(context);
    }

    public ZoneSelectionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mAnimating = false;
        a(context);
    }

    public ZoneSelectionView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mAnimating = false;
        a(context);
    }

    private void a(Context context)
    {
        mViews = new a(LayoutInflater.from(context).inflate(0x7f03020e, this, true));
        mListeners = new ArrayList();
        a(true);
        b();
    }

    private void a(Zone zone, int i)
    {
        mCurrentZoneIdx = i;
        mViews.currentZone.setText(zone.getName());
        mNewZone = zone;
        c();
        if (mShowingOtherZones)
        {
            d();
        }
        mVenue.setZoneByUUID(zone.getUUID());
    }

    static void a(ZoneSelectionView zoneselectionview)
    {
        zoneselectionview.d();
    }

    static void a(ZoneSelectionView zoneselectionview, Zone zone, int i)
    {
        zoneselectionview.a(zone, i);
    }

    static boolean a(ZoneSelectionView zoneselectionview, boolean flag)
    {
        zoneselectionview.mShowingOtherZones = flag;
        return flag;
    }

    private void b()
    {
        mShowingOtherZones = false;
        al.c(mViews.otherZonesWrapper);
    }

    static boolean b(ZoneSelectionView zoneselectionview)
    {
        return zoneselectionview.mShowingOtherZones;
    }

    static boolean b(ZoneSelectionView zoneselectionview, boolean flag)
    {
        zoneselectionview.mAnimating = flag;
        return flag;
    }

    private void c()
    {
        Iterator iterator = mVenue.getAllZones().iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            Zone zone = (Zone)iterator.next();
            al.a(mViews.otherZonesWrapper.getChildAt(i).findViewById(0x7f1005f6), mNewZone.equals(zone));
        }

    }

    private void d()
    {
        if (mAnimating)
        {
            return;
        }
        if (!mShowingOtherZones)
        {
            for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((c)iterator.next()).B()) { }
        } else
        {
            Iterator iterator1 = mListeners.iterator();
            while (iterator1.hasNext()) 
            {
                c c1 = (c)iterator1.next();
                b b1;
                if (mCurrentZoneIdx == mPreviousZoneIdx)
                {
                    b1 = b.NO_CHANGE;
                } else
                if (mCurrentZoneIdx > mPreviousZoneIdx)
                {
                    b1 = b.HIGHER;
                } else
                {
                    b1 = b.LOWER;
                }
                c1.a(b1, mNewZone);
            }
        }
        mPreviousZoneIdx = mCurrentZoneIdx;
        AnimatorSet animatorset = aj.a(mViews.otherZonesWrapper, mViews.arrow, mShowingOtherZones);
        Animator animator;
        int i;
        int j;
        if (mShowingOtherZones)
        {
            j = getResources().getColor(0x7f0f00ef);
            i = getResources().getColor(0x7f0f00f9);
        } else
        {
            j = getResources().getColor(0x7f0f00f9);
            i = getResources().getColor(0x7f0f00ef);
        }
        animator = aj.a(mViews.container, j, i);
        animatorset.addListener(new AnimatorListenerAdapter() {

            final ZoneSelectionView this$0;

            public void onAnimationEnd(Animator animator1)
            {
                super.onAnimationEnd(animator1);
                animator1 = ZoneSelectionView.this;
                boolean flag;
                if (!ZoneSelectionView.b(ZoneSelectionView.this))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ZoneSelectionView.a(animator1, flag);
                ZoneSelectionView.b(ZoneSelectionView.this, false);
            }

            public void onAnimationStart(Animator animator1)
            {
                super.onAnimationStart(animator1);
                ZoneSelectionView.b(ZoneSelectionView.this, true);
            }

            
            {
                this$0 = ZoneSelectionView.this;
                super();
            }
        });
        animatorset.playTogether(new Animator[] {
            animator
        });
        if (mShowingOtherZones)
        {
            animator = aj.a(mViews.currentZone, 0.0F, 1.0F);
        } else
        {
            animator = aj.a(mViews.currentZone, 1.0F, 0.0F);
        }
        animatorset.playTogether(new Animator[] {
            animator
        });
        animatorset.start();
    }

    public void a()
    {
        if (!mShowingOtherZones)
        {
            return;
        } else
        {
            d();
            return;
        }
    }

    public void a(Zone zone)
    {
        if (mViews != null && mVenue != null && mVenue.getAllZones().size() >= 2)
        {
            Iterator iterator = mVenue.getAllZones().iterator();
            int i = 0;
            while (iterator.hasNext()) 
            {
                Zone zone1 = (Zone)iterator.next();
                if (zone1.getUUID().equals(zone.getUUID()))
                {
                    mPreviousZoneIdx = i;
                    a(zone1, i);
                    return;
                }
                i++;
            }
        }
    }

    public void a(c c1)
    {
        mListeners.add(c1);
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            mViews.currentZoneWrapper.setOnClickListener(new android.view.View.OnClickListener() {

                final ZoneSelectionView this$0;

                public void onClick(View view)
                {
                    ZoneSelectionView.a(ZoneSelectionView.this);
                }

            
            {
                this$0 = ZoneSelectionView.this;
                super();
            }
            });
            return;
        } else
        {
            mViews.currentZoneWrapper.setOnClickListener(null);
            return;
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mViews = null;
        if (mListeners != null)
        {
            mListeners.clear();
        }
    }

    public void setVenue(Venue venue)
    {
        if (mViews != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        mVenue = venue;
        if (venue != null) goto _L4; else goto _L3
_L3:
        mVenueUuid = null;
_L6:
        if (mVenue.getAllZones().size() < 2)
        {
            setVisibility(8);
            return;
        }
        break MISSING_BLOCK_LABEL_69;
_L4:
        venue = venue.getUUID();
        if (venue.equals(mVenueUuid))
        {
            break; /* Loop/switch isn't completed */
        }
        mVenueUuid = venue;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L1; else goto _L7
_L7:
        setVisibility(0);
        mCurrentZoneIdx = 0;
        mPreviousZoneIdx = mCurrentZoneIdx;
        mNewZone = mVenue.getCurrentZone();
        mViews.currentZone.setText(mVenue.getCurrentZone().getName());
        venue = LayoutInflater.from(getContext());
        Iterator iterator = mVenue.getAllZones().iterator();
        for (final int zoneIdx = 0; iterator.hasNext(); zoneIdx++)
        {
            final Zone zone = (Zone)iterator.next();
            View view = venue.inflate(0x7f03020f, null);
            ((TextView)view.findViewById(0x7f1005f5)).setText(zone.getName());
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final ZoneSelectionView this$0;
                final Zone val$zone;
                final int val$zoneIdx;

                public void onClick(View view1)
                {
                    ZoneSelectionView.a(ZoneSelectionView.this, zone, zoneIdx);
                }

            
            {
                this$0 = ZoneSelectionView.this;
                zone = zone1;
                zoneIdx = i;
                super();
            }
            });
            mViews.otherZonesWrapper.addView(view);
        }

        c();
        return;
    }
}
