// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Manage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdMediationDB;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.model.res.TResInfo;
import fr;
import ix;
import ja;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import jc;
import kf;
import of;
import sb;
import te;
import tf;

public class OnlineGridViewAdapter extends BaseAdapter
    implements android.view.View.OnClickListener
{

    public static final int MIN_SPACING = 10;
    private static final String TAG = "SectionedAdapter";
    public static final int VIEW_TYPE_HEADER = 0;
    public static final int VIEW_TYPE_ROW = 1;
    private int childSpacing;
    private int childrenSpacing[];
    private Button clickedBtn;
    private int gridItemSize;
    private SparseBooleanArray idAnimations;
    private int listItemRowWidth;
    private int listViewHeight;
    private tf listener;
    private Context mContext;
    private fr mImageWorker;
    private HashMap nativeMap;
    private int numberOfChildrenInRow;
    private LinkedHashMap sectionInfos;
    private LinkedHashMap sectionRowsCount;

    public OnlineGridViewAdapter(Context context, LinkedHashMap linkedhashmap, int i, int j, int k, fr fr1)
    {
        boolean flag = false;
        super();
        idAnimations = new SparseBooleanArray();
        listItemRowWidth = -1;
        gridItemSize = -1;
        listViewHeight = -1;
        numberOfChildrenInRow = -1;
        childrenSpacing = null;
        childSpacing = -1;
        sectionInfos = null;
        sectionRowsCount = new LinkedHashMap();
        mContext = null;
        nativeMap = new HashMap();
        listener = null;
        mContext = context;
        sectionInfos = linkedhashmap;
        listItemRowWidth = i;
        gridItemSize = k;
        listViewHeight = j;
        mImageWorker = fr1;
        if (gridItemSize > listItemRowWidth)
        {
            throw new IllegalArgumentException("Griditem size cannot be greater that list item row size");
        }
        numberOfChildrenInRow = listItemRowWidth / gridItemSize;
        j = listItemRowWidth % gridItemSize;
        i = j;
        if (j == 0)
        {
            numberOfChildrenInRow = numberOfChildrenInRow - 1;
            i = gridItemSize;
        }
        k = 0;
        int l = 0;
        j = i;
        i = k;
        for (k = l; childSpacing < 10; k++)
        {
            numberOfChildrenInRow = numberOfChildrenInRow - k;
            j += gridItemSize * k;
            i = numberOfChildrenInRow;
            childSpacing = j / (i + 1);
        }

        childrenSpacing = new int[i];
        k = 0;
        do
        {
            l = ((flag) ? 1 : 0);
            if (k >= i)
            {
                break;
            }
            childrenSpacing[k] = childSpacing;
            k++;
        } while (true);
        for (; l < j % i; l++)
        {
            context = childrenSpacing;
            context[l] = context[l] + 1;
        }

    }

    private void addLayoutToFramelayout(View view, View view1, TResInfo tresinfo)
    {
        if (view1 != null && (view1 instanceof LinearLayout))
        {
            view1 = (LinearLayout)view1;
            for (int i = 0; i < view1.getChildCount(); i++)
            {
                Object obj = view1.getChildAt(i);
                if (!(obj instanceof FrameLayout))
                {
                    continue;
                }
                view.setTag("NativeView");
                ((View) (obj)).setTag(tresinfo);
                ((FrameLayout)obj).addView(view, new android.widget.FrameLayout.LayoutParams(gridItemSize, -1));
                if (nativeMap == null || !nativeMap.containsKey(tresinfo))
                {
                    continue;
                }
                obj = (jc)nativeMap.get(tresinfo);
                if (obj != null)
                {
                    ((jc) (obj)).a(view);
                }
            }

        }
    }

    private void createFBNativeLayout(View view, TResInfo tresinfo, te te1)
    {
        try
        {
            te1 = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x7f03004d, null);
            te1.setOnClickListener(new android.view.View.OnClickListener() {

                final OnlineGridViewAdapter a;

                public void onClick(View view1)
                {
                }

            
            {
                a = OnlineGridViewAdapter.this;
                super();
            }
            });
            ImageView imageview = (ImageView)te1.findViewById(0x7f0c015d);
            if (mImageWorker != null && tresinfo.icon != null && !tresinfo.icon.isEmpty())
            {
                fr.a(imageview);
                mImageWorker.a(tresinfo, imageview);
            }
            requestNativeAdForiegn(tresinfo, te1);
            te1.setBackgroundColor(-1);
            addLayoutToFramelayout(te1, view, tresinfo);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Log.e("SectionedAdapter", (new StringBuilder()).append("SectionedAdapter ").append(view.toString()).toString());
        }
        Crashlytics.logException(view);
    }

    private int getMargePixelSize()
    {
        return mContext.getResources().getDimensionPixelSize(0x7f08004d);
    }

    private boolean isLastRowInSection(int i)
    {
        for (Iterator iterator = sectionInfos.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            int j = ((Integer)sectionRowsCount.get(s)).intValue() + 1;
            if (i == j - 1)
            {
                return true;
            }
            i -= j;
        }

        return false;
    }

    private boolean isNativeAdInfo(TResInfo tresinfo)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (tresinfo != null)
        {
            flag = flag1;
            if (tresinfo.resId >= TPhotoMagComposeManager.KFBNATIVEID)
            {
                flag = flag1;
                if (tresinfo.resId <= (TPhotoMagComposeManager.KFBNATIVEID + sectionInfos.keySet().size()) - 1)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private boolean isSectionHeader(int i)
    {
        for (Iterator iterator = sectionInfos.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            int j = ((Integer)sectionRowsCount.get(s)).intValue();
            if (i == 0)
            {
                return true;
            }
            i -= j + 1;
        }

        return false;
    }

    private int positionInSection(int i)
    {
        for (Iterator iterator = sectionInfos.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            int j = ((Integer)sectionRowsCount.get(s)).intValue() + 1;
            if (i < j)
            {
                return i - 1;
            }
            i -= j;
        }

        return -1;
    }

    private void removeLayoutFromeParent(View view)
    {
        if (view == null) goto _L2; else goto _L1
_L1:
        if (!(view instanceof LinearLayout)) goto _L2; else goto _L3
_L3:
        view = (LinearLayout)view;
        int i = 0;
_L7:
        if (i >= view.getChildCount()) goto _L2; else goto _L4
_L4:
        View view1;
        View view2;
        view1 = view.getChildAt(i);
        if (!(view1 instanceof FrameLayout))
        {
            break MISSING_BLOCK_LABEL_123;
        }
        view2 = view1.findViewWithTag("NativeView");
        if (view2 == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        ((FrameLayout)view1).removeView(view2);
        if (view1.getTag() == null || !(view1.getTag() instanceof TResInfo) || nativeMap == null || !nativeMap.containsKey(view1.getTag())) goto _L2; else goto _L5
_L5:
        view = (jc)nativeMap.get(view1.getTag());
        if (view == null) goto _L2; else goto _L6
_L6:
        view.c();
_L2:
        return;
        i++;
          goto _L7
        view;
        Crashlytics.logException(view);
        return;
    }

    private void requestFbNativeAd(TResInfo tresinfo, View view)
    {
        if (view != null)
        {
            try
            {
                ImageView imageview = (ImageView)view.findViewById(0x7f0c015d);
                if (mContext != null && tresinfo.icon != null && tresinfo.icon.isEmpty())
                {
                    ix.b(mContext).loadNativeAd(FotoAdMediationDB.getFBResIconAdID(mContext), new ja(tresinfo, view, imageview) {

                        final TResInfo a;
                        final View b;
                        final ImageView c;
                        final OnlineGridViewAdapter d;

                        public void adIconFailed()
                        {
                            FlurryAgent.logEvent("FBNatice_PIPResIcon_Failed");
                        }

                        public void adIconLoaded(FotoNativeIcon fotonativeicon)
                        {
                            if (d.mContext != null)
                            {
                                (new Handler(d.mContext.getMainLooper())).post(new Runnable(this, fotonativeicon) {

                                    final FotoNativeIcon a;
                                    final _cls2 b;

                                    public void run()
                                    {
                                        b.a.icon = a.nativeItem.b();
                                        b.d.nativeMap.put(b.a, a.nativeItem);
                                        a.nativeItem.a(b.b);
                                        if (b.d.mImageWorker != null)
                                        {
                                            b.d.mImageWorker.a(b.a, b.c);
                                        }
                                        FlurryAgent.logEvent("FBNatice_PIPResIcon_loaded");
                                    }

            
            {
                b = _pcls2;
                a = fotonativeicon;
                super();
            }
                                });
                            }
                            Log.e("SectionedAdapter", "SectionedAdapter fbnative ad loaded");
                        }

            
            {
                d = OnlineGridViewAdapter.this;
                a = tresinfo;
                b = view;
                c = imageview;
                super();
            }
                    });
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (TResInfo tresinfo)
            {
                return;
            }
        }
    }

    private void requestNativeAdForiegn(TResInfo tresinfo, View view)
    {
        if (!NativeAdWrapper.needFBNative(mContext))
        {
            return;
        }
        try
        {
            if (kf.a(mContext, "com.facebook.katana"))
            {
                requestFbNativeAd(tresinfo, view);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (TResInfo tresinfo)
        {
            Crashlytics.logException(tresinfo);
        }
        return;
    }

    private String whichSection(int i)
    {
        for (Iterator iterator = sectionInfos.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            int j = ((Integer)sectionRowsCount.get(s)).intValue() + 1;
            if (i < j)
            {
                return s;
            }
            i -= j;
        }

        return null;
    }

    public int gapBetweenChildrenInRow()
    {
        return childSpacing;
    }

    public int getCount()
    {
        sectionRowsCount.clear();
        int i = sectionInfos.size();
        for (Iterator iterator = sectionInfos.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            int l = ((ArrayList)sectionInfos.get(s)).size();
            int k = l / numberOfChildrenInRow;
            int j = k;
            if (l % numberOfChildrenInRow != 0)
            {
                j = k + 1;
            }
            sectionRowsCount.put(s, Integer.valueOf(j));
            i += j;
        }

        return i;
    }

    public Object getItem(int i)
    {
        return null;
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public int getItemViewType(int i)
    {
        return !isSectionHeader(i) ? 1 : 0;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        boolean flag = isSectionHeader(i);
        if (view != null) goto _L2; else goto _L1
_L1:
        Object obj = (LayoutInflater)mContext.getSystemService("layout_inflater");
        if (!flag) goto _L4; else goto _L3
_L3:
        view = ((LayoutInflater) (obj)).inflate(0x7f030063, null);
_L2:
        viewgroup = whichSection(i);
        LinearLayout linearlayout1;
        int j;
        if (flag)
        {
            obj = (TextView)view.findViewById(0x7f0c0087);
            i = ((ArrayList)sectionInfos.get(viewgroup)).size();
            ((TextView) (obj)).setText((new StringBuilder()).append(viewgroup).append("(").append(i).append(")").toString());
        } else
        {
            LinearLayout linearlayout = (LinearLayout)((LinearLayout)view).findViewById(0x7f0c0234);
            boolean flag1 = isLastRowInSection(i);
            i = positionInSection(i);
            ArrayList arraylist = (ArrayList)sectionInfos.get(viewgroup);
            int l = numberOfChildrenInRow;
            int k = 0;
            i = l * i;
            while (k < numberOfChildrenInRow * 2) 
            {
                Object obj1 = linearlayout.getChildAt(k);
                ((View) (obj1)).setVisibility(0);
                if (k % 2 == 0)
                {
                    continue;
                }
                if (i > -1 && i < arraylist.size())
                {
                    TResInfo tresinfo = (TResInfo)arraylist.get(i);
                    Object obj2 = new te();
                    obj2.b = viewgroup;
                    obj2.c = i;
                    obj2.d = ((View) (obj1));
                    obj2.a = tresinfo;
                    removeLayoutFromeParent(((View) (obj1)));
                    if (isNativeAdInfo(tresinfo))
                    {
                        createFBNativeLayout(((View) (obj1)), tresinfo, ((te) (obj2)));
                    } else
                    {
                        ImageView imageview = (ImageView)((View) (obj1)).findViewById(0x7f0c022c);
                        if (mImageWorker != null && tresinfo != null)
                        {
                            fr.a(imageview);
                            mImageWorker.a(tresinfo, imageview);
                        }
                        imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                        imageview.setTag(obj2);
                        imageview.setOnClickListener(this);
                        obj2 = (ImageView)((View) (obj1)).findViewById(0x7f0c0230);
                        ((ImageView) (obj2)).setVisibility(0);
                        imageview = (ImageView)((View) (obj1)).findViewById(0x7f0c022d);
                        if (tresinfo.needSharing && tresinfo.wxdlShareInfo != null && (new of(mContext)).b())
                        {
                            imageview.setVisibility(0);
                            ((ImageView) (obj2)).setVisibility(4);
                        } else
                        {
                            imageview.setVisibility(4);
                        }
                        imageview = (ImageView)((View) (obj1)).findViewById(0x7f0c022e);
                        if (tresinfo.otherAppStoreId != null && tresinfo.otherAppStoreId.compareToIgnoreCase("0") != 0 && tresinfo.otherAppStoreId.compareToIgnoreCase("") != 0 && !isAppInstalled(tresinfo.otherAppStoreId))
                        {
                            imageview.setVisibility(0);
                            ((ImageView) (obj2)).setVisibility(4);
                        } else
                        {
                            imageview.setVisibility(4);
                        }
                        obj1 = (ImageView)((View) (obj1)).findViewById(0x7f0c022f);
                        if (tresinfo.needReviewing && !sb.c())
                        {
                            ((ImageView) (obj1)).setVisibility(0);
                            ((ImageView) (obj2)).setVisibility(4);
                        } else
                        {
                            ((ImageView) (obj1)).setVisibility(4);
                        }
                    }
                }
                i++;
                k++;
            }
            if (flag1)
            {
                i = ((ArrayList)sectionInfos.get(viewgroup)).size() % numberOfChildrenInRow;
                if (i > 0)
                {
                    i += i;
                    while (i < linearlayout.getChildCount()) 
                    {
                        linearlayout.getChildAt(i).setVisibility(4);
                        i++;
                    }
                }
            }
        }
        return view;
_L4:
        viewgroup = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f030080, null);
        linearlayout1 = (LinearLayout)viewgroup.findViewById(0x7f0c0234);
        j = 0;
_L6:
        view = viewgroup;
        if (j >= numberOfChildrenInRow) goto _L2; else goto _L5
_L5:
        view = ((LayoutInflater) (obj)).inflate(0x7f03007e, null);
        if (j < numberOfChildrenInRow)
        {
            linearlayout1.addView(new View(mContext), new android.widget.LinearLayout.LayoutParams(childrenSpacing[j], gridItemSize));
        }
        linearlayout1.addView(view, new android.widget.LinearLayout.LayoutParams(gridItemSize, -2));
        j++;
          goto _L6
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean isAppInstalled(String s)
    {
        boolean flag = false;
        try
        {
            s = PIPCameraApplication.a.getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = null;
        }
        if (s != null)
        {
            flag = true;
        }
        return flag;
    }

    public boolean isEnabled(int i)
    {
        return false;
    }

    public void onClick(View view)
    {
label0:
        {
            if (view != null)
            {
                view = (te)view.getTag();
                if (listener != null && view != null && !isNativeAdInfo(((te) (view)).a))
                {
                    break label0;
                }
            }
            return;
        }
        listener.a(((te) (view)).a, ((te) (view)).b, ((te) (view)).c);
    }

    public void setItemListener(tf tf1)
    {
        listener = tf1;
    }



}
