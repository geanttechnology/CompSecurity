// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import java.util.Locale;

public class ActionViewBuilder
{

    public static final String BARCODE_SEARCH_QUERY_KEYWORD = "BARCODE_SEARCH_QUERY_KEYWORD";
    public static final String IMAGE_SEARCH_QUERY_KEYWORD = "IMAGE_SEARCH_QUERY_KEYWORD";
    public static final String VOICE_SEARCH_QUERY_KEYWORD = "VOICE_SEARCH_QUERY_KEYWORD";
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/entry/ActionViewBuilder);
    private SearchBoxLogger searchBoxLogger;
    private final QuerySubmitListener searchHandler;
    boolean showFlow;
    boolean showScan;
    boolean showSnap;
    boolean showVisualScan;
    boolean showVoice;
    private final LinearLayout view;

    ActionViewBuilder(LinearLayout linearlayout, QuerySubmitListener querysubmitlistener)
    {
        searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
        RetailSearchDaggerGraphController.inject(this);
        view = linearlayout;
        searchHandler = querysubmitlistener;
    }

    private void addActionButton(int i, int j, int k, android.view.View.OnClickListener onclicklistener, int l)
    {
        if (view.getChildCount() > 0)
        {
            View.inflate(view.getContext(), com.amazon.retailsearch.R.layout.rs_entry_action_divider, view);
        }
        View.inflate(view.getContext(), com.amazon.retailsearch.R.layout.rs_entry_btn, view);
        LinearLayout linearlayout = (LinearLayout)view.getChildAt(view.getChildCount() - 1);
        byte byte0;
        if (l == 1)
        {
            byte0 = 3;
        } else
        {
            byte0 = 17;
        }
        linearlayout.setGravity(byte0);
        ((ImageView)linearlayout.findViewById(com.amazon.retailsearch.R.id.rs_entry_btn_img)).setImageDrawable(view.getResources().getDrawable(i));
        ((TextView)linearlayout.findViewById(com.amazon.retailsearch.R.id.rs_entry_btn_text)).setText(view.getResources().getString(j));
        if (k > 0 && l == 1 && "en".equals(Locale.getDefault().getLanguage()))
        {
            TextView textview = (TextView)linearlayout.findViewById(com.amazon.retailsearch.R.id.rs_entry_btn_description);
            textview.setText(view.getResources().getString(k));
            textview.setVisibility(0);
        }
        linearlayout.setOnClickListener(onclicklistener);
    }

    private void doBuild()
    {
        int l = 0;
        if (view != null && searchHandler != null)
        {
            view.removeAllViews();
            int i;
            int k;
            if (showVoice)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (showScan)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            if (showFlow || showSnap)
            {
                l = 1;
            }
            k = i + k + l;
            if (showVoice)
            {
                android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

                    final ActionViewBuilder this$0;

                    public void onClick(View view1)
                    {
                        searchHandler.onQuerySubmit(new RetailSearchQuery("VOICE_SEARCH_QUERY_KEYWORD"));
                        searchBoxLogger.recordEntryVoiceInvoked();
                    }

            
            {
                this$0 = ActionViewBuilder.this;
                super();
            }
                };
                addActionButton(com.amazon.retailsearch.R.drawable.vs_iss_voice_selector, com.amazon.retailsearch.R.string.rs_entry_voice, com.amazon.retailsearch.R.string.rs_speak_search, onclicklistener, k);
            }
            if (showScan)
            {
                android.view.View.OnClickListener onclicklistener1 = new android.view.View.OnClickListener() {

                    final ActionViewBuilder this$0;

                    public void onClick(View view1)
                    {
                        searchHandler.onQuerySubmit(new RetailSearchQuery("BARCODE_SEARCH_QUERY_KEYWORD"));
                        searchBoxLogger.recordScanItInvoked();
                    }

            
            {
                this$0 = ActionViewBuilder.this;
                super();
            }
                };
                addActionButton(com.amazon.retailsearch.R.drawable.rs_iss_barcode_selector, com.amazon.retailsearch.R.string.rs_bc_search_button, com.amazon.retailsearch.R.string.rs_scan_barcode, onclicklistener1, k);
            }
            if (showFlow)
            {
                android.view.View.OnClickListener onclicklistener2 = new android.view.View.OnClickListener() {

                    final ActionViewBuilder this$0;

                    public void onClick(View view1)
                    {
                        searchHandler.onQuerySubmit(new RetailSearchQuery("IMAGE_SEARCH_QUERY_KEYWORD"));
                        searchBoxLogger.recordFlowInvoked();
                    }

            
            {
                this$0 = ActionViewBuilder.this;
                super();
            }
                };
                int i1 = com.amazon.retailsearch.R.drawable.rs_iss_camera_selector;
                if (showVisualScan)
                {
                    i = com.amazon.retailsearch.R.string.rs_visual_scan;
                } else
                {
                    i = com.amazon.retailsearch.R.string.rs_view_it_flow;
                }
                addActionButton(i1, i, com.amazon.retailsearch.R.string.rs_scan_product, onclicklistener2, k);
                return;
            }
            if (showSnap)
            {
                android.view.View.OnClickListener onclicklistener3 = new android.view.View.OnClickListener() {

                    final ActionViewBuilder this$0;

                    public void onClick(View view1)
                    {
                        searchHandler.onQuerySubmit(new RetailSearchQuery("IMAGE_SEARCH_QUERY_KEYWORD"));
                        searchBoxLogger.recordSnapItInvoked();
                    }

            
            {
                this$0 = ActionViewBuilder.this;
                super();
            }
                };
                int j1 = com.amazon.retailsearch.R.drawable.rs_search_suggestion_snapit;
                int j;
                if (showVisualScan)
                {
                    j = com.amazon.retailsearch.R.string.rs_visual_scan;
                } else
                {
                    j = com.amazon.retailsearch.R.string.rs_snapit;
                }
                addActionButton(j1, j, com.amazon.retailsearch.R.string.rs_scan_product, onclicklistener3, k);
                return;
            }
        }
    }

    void build()
    {
        try
        {
            doBuild();
            return;
        }
        catch (Exception exception)
        {
            log.error("Failed to build action view", exception);
        }
    }



}
