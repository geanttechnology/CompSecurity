// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Manage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.model.res.TResInfo;
import fr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import tg;
import th;
import tu;

public class SectionGridViewAdapter extends BaseAdapter
    implements android.view.View.OnClickListener
{

    public static final int MIN_SPACING = 10;
    private static final String TAG = "SectionedGridViewAdapter";
    public static final int VIEW_TYPE_HEADER = 0;
    public static final int VIEW_TYPE_ROW = 1;
    private int childSpacing;
    private int childrenSpacing[];
    private Button clickedBtn;
    private int gridItemSize;
    private SparseBooleanArray idAnimations;
    private int listItemRowWidth;
    private int listViewHeight;
    private th listener;
    private Context mContext;
    private fr mImageWorker;
    private int numberOfChildrenInRow;
    private LinkedHashMap sectionInfos;
    private LinkedHashMap sectionRowsCount;

    public SectionGridViewAdapter(Context context, LinkedHashMap linkedhashmap, int i, int j, int k, fr fr1)
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
        listener = null;
        mContext = context;
        sectionInfos = linkedhashmap;
        listItemRowWidth = i - getMargePixelSize() * 2;
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
            i = numberOfChildrenInRow - 1;
            childSpacing = j / i;
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

    private Dialog ExitDialog(Context context)
    {
        context = new android.app.AlertDialog.Builder(context);
        context.setTitle(mContext.getResources().getString(0x7f060277));
        context.setMessage(mContext.getResources().getString(0x7f0600b6));
        context.setPositiveButton(mContext.getResources().getString(0x7f0602b7), new android.content.DialogInterface.OnClickListener() {

            final SectionGridViewAdapter a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                if (a.clickedBtn != null)
                {
                    dialoginterface = (tg)a.clickedBtn.getTag();
                    if (a.listener != null && dialoginterface != null)
                    {
                        a.listener.a(((tg) (dialoginterface)).a, ((tg) (dialoginterface)).b, ((tg) (dialoginterface)).c);
                    }
                }
            }

            
            {
                a = SectionGridViewAdapter.this;
                super();
            }
        });
        context.setNegativeButton(mContext.getResources().getString(0x7f06016e), new android.content.DialogInterface.OnClickListener() {

            final SectionGridViewAdapter a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

            
            {
                a = SectionGridViewAdapter.this;
                super();
            }
        });
        return context.create();
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
        return mContext.getResources().getDimensionPixelSize(0x7f080045);
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
        view = ((LayoutInflater) (obj)).inflate(0x7f03007f, null);
_L2:
        obj = whichSection(i);
        if (flag)
        {
            Object obj1 = (TextView)view.findViewById(0x7f0c0087);
            ArrayList arraylist;
            Object obj2;
            Button button;
            tg tg1;
            int j;
            int k;
            boolean flag1;
            if (((String) (obj)).equalsIgnoreCase(tu.getStringByResType(EOnlineResType.PIP_SCENE)))
            {
                viewgroup = mContext.getResources().getString(0x7f0600a6);
            } else
            if (((String) (obj)).equalsIgnoreCase(tu.getStringByResType(EOnlineResType.PIP_SCENE2)))
            {
                viewgroup = mContext.getResources().getString(0x7f0600fb);
            } else
            {
                viewgroup = ((ViewGroup) (obj));
            }
            ((TextView) (obj1)).setText(viewgroup);
        } else
        {
            obj1 = (LinearLayout)((LinearLayout)view).findViewById(0x7f0c0234);
            flag1 = isLastRowInSection(i);
            i = positionInSection(i);
            arraylist = (ArrayList)sectionInfos.get(obj);
            k = numberOfChildrenInRow;
            j = 0;
            i = k * i;
            while (j < numberOfChildrenInRow * 2 - 1) 
            {
                obj2 = ((LinearLayout) (obj1)).getChildAt(j);
                ((View) (obj2)).setVisibility(0);
                if (j % 2 != 0)
                {
                    continue;
                }
                if (i > -1 && i < arraylist.size())
                {
                    viewgroup = (TResInfo)arraylist.get(i);
                    button = (Button)((View) (obj2)).findViewById(0x7f0c0232);
                    button.setText(mContext.getResources().getString(0x7f0600cb));
                    tg1 = new tg();
                    tg1.a = ((String) (obj));
                    tg1.b = i;
                    tg1.c = ((View) (obj2));
                    button.setTag(tg1);
                    button.setOnClickListener(this);
                } else
                {
                    viewgroup = null;
                }
                obj2 = (ImageView)((View) (obj2)).findViewById(0x7f0c022c);
                if (mImageWorker != null && viewgroup != null)
                {
                    mImageWorker.a(viewgroup, ((ImageView) (obj2)));
                }
                ((ImageView) (obj2)).setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                i++;
                j++;
            }
            if (flag1)
            {
                i = ((ArrayList)sectionInfos.get(obj)).size() % numberOfChildrenInRow;
                if (i > 0)
                {
                    i += i - 1;
                    while (i < ((LinearLayout) (obj1)).getChildCount()) 
                    {
                        ((LinearLayout) (obj1)).getChildAt(i).setVisibility(4);
                        i++;
                    }
                }
            }
        }
        return view;
_L4:
        viewgroup = (LinearLayout)((LayoutInflater) (obj)).inflate(0x7f030080, null);
        obj1 = (LinearLayout)viewgroup.findViewById(0x7f0c0234);
        j = 0;
_L6:
        view = viewgroup;
        if (j >= numberOfChildrenInRow) goto _L2; else goto _L5
_L5:
        ((LinearLayout) (obj1)).addView(((LayoutInflater) (obj)).inflate(0x7f03007e, null), new android.widget.LinearLayout.LayoutParams(gridItemSize, -2));
        if (j < numberOfChildrenInRow - 1)
        {
            ((LinearLayout) (obj1)).addView(new View(mContext), new android.widget.LinearLayout.LayoutParams(childrenSpacing[j], ((LinearLayout) (obj1)).getHeight()));
        }
        j++;
          goto _L6
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean isEnabled(int i)
    {
        return false;
    }

    public void onClick(View view)
    {
        clickedBtn = (Button)view;
        if (clickedBtn != null)
        {
            view = (tg)clickedBtn.getTag();
            if (listener != null && view != null)
            {
                listener.a(((tg) (view)).a, ((tg) (view)).b, ((tg) (view)).c);
            }
        }
    }

    public void setItemListener(th th1)
    {
        listener = th1;
    }


}
