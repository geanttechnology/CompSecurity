// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.crashlytics.android.Crashlytics;

// Referenced classes of package com.instamag.activity.commonview:
//            FilterMagItemView

public class MagFilterActionBar extends LinearLayout
{

    String TAG;
    private FilterMagItemView btnAll;
    private FilterMagItemView btnLandScape;
    private FilterMagItemView btnPortrait;
    private FilterMagItemView btnSquare;
    private FilterMagItemView btnStrips;
    private HorizontalScrollView hscrollview;
    private LinearLayout mLayout;
    private ListView mlistView;
    private String sections[];
    private SectionIndexer selectionIndexer;

    public MagFilterActionBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = "MagFilterActionBar";
        selectionIndexer = null;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030050, this, true);
        btnPortrait = (FilterMagItemView)findViewById(0x7f0c016a);
        btnSquare = (FilterMagItemView)findViewById(0x7f0c016d);
        btnLandScape = (FilterMagItemView)findViewById(0x7f0c0170);
        btnStrips = (FilterMagItemView)findViewById(0x7f0c0173);
        btnAll = (FilterMagItemView)findViewById(0x7f0c0167);
        hscrollview = (HorizontalScrollView)findViewById(0x7f0c0174);
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        hscrollview.addView(mLayout);
        initTabItems();
    }

    public void handleIndexButtons()
    {
        mLayout.removeAllViews();
        int i = 0;
        do
        {
            if (i >= sections.length)
            {
                break;
            }
            try
            {
                View view = LayoutInflater.from(getContext()).inflate(0x7f030046, null);
                Button button = (Button)view.findViewById(0x7f0c013d);
                button.setText(sections[i]);
                button.setTextColor(getResources().getColor(0x7f0b0086));
                button.setTag(Integer.valueOf(i));
                button.setOnClickListener(new android.view.View.OnClickListener() {

                    final MagFilterActionBar a;

                    public void onClick(View view1)
                    {
                        int j = ((Integer)view1.getTag()).intValue();
                        if (a.selectionIndexer == null)
                        {
                            a.selectionIndexer = (SectionIndexer)a.mlistView.getAdapter();
                        }
                        if (j < 0)
                        {
                            j = 0;
                        }
                        int k = j;
                        if (a.sections != null)
                        {
                            k = j;
                            if (j >= a.sections.length)
                            {
                                k = a.sections.length - 1;
                            }
                        }
                        j = a.selectionIndexer.getPositionForSection(k);
                        Log.v(a.TAG, (new StringBuilder()).append(a.TAG).append("Touch on selectedIndex: ").append(String.valueOf(k)).toString());
                        if (j == -1)
                        {
                            return;
                        } else
                        {
                            a.mlistView.setSelection(j);
                            return;
                        }
                    }

            
            {
                a = MagFilterActionBar.this;
                super();
            }
                });
                mLayout.addView(view);
            }
            catch (android.content.res.Resources.NotFoundException notfoundexception)
            {
                Log.e(TAG, notfoundexception.getMessage());
                Crashlytics.logException(notfoundexception);
            }
            i++;
        } while (true);
    }

    public void initTabItems()
    {
        btnPortrait.setResId(0x7f02008b);
        btnPortrait.setSelectedResId(0x7f02008c);
        btnPortrait.setSelected(false);
        btnSquare.setResId(0x7f02008d);
        btnSquare.setSelectedResId(0x7f02008e);
        btnSquare.setSelected(false);
        btnLandScape.setResId(0x7f020087);
        btnLandScape.setSelectedResId(0x7f020088);
        btnLandScape.setSelected(false);
        btnStrips.setResId(0x7f020089);
        btnStrips.setSelectedResId(0x7f02008a);
        btnStrips.setSelected(false);
        btnAll.setResId(0x7f020072);
        btnAll.setSelectedResId(0x7f020073);
        btnAll.setSelected(false);
    }

    public void refreshIndex()
    {
        if (mlistView == null)
        {
            return;
        }
        selectionIndexer = (SectionIndexer)mlistView.getAdapter();
        Object aobj[] = selectionIndexer.getSections();
        sections = new String[aobj.length];
        for (int i = 0; i < aobj.length; i++)
        {
            sections[i] = aobj[i].toString();
        }

        handleIndexButtons();
    }

    public void setListView(ListView listview)
    {
        if (listview == null)
        {
            return;
        }
        mlistView = listview;
        selectionIndexer = (SectionIndexer)listview.getAdapter();
        listview = ((ListView) (selectionIndexer.getSections()));
        sections = new String[listview.length];
        for (int i = 0; i < listview.length; i++)
        {
            sections[i] = listview[i].toString();
        }

        handleIndexButtons();
    }



/*
    static SectionIndexer access$002(MagFilterActionBar magfilteractionbar, SectionIndexer sectionindexer)
    {
        magfilteractionbar.selectionIndexer = sectionindexer;
        return sectionindexer;
    }

*/


}
