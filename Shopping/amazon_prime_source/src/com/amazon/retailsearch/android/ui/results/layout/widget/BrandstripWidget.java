// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.SearchImageLoader;
import com.amazon.retailsearch.android.ui.SearchImageLoaderListener;
import com.amazon.retailsearch.android.ui.listadapter.ModelView;
import com.amazon.retailsearch.android.ui.results.layout.model.BrandStripModel;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.searchapp.retailsearch.model.BrandCell;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.Link;
import java.util.List;

public class BrandstripWidget extends LinearLayout
    implements ModelView
{
    public static class BrandCellWrapper
    {

        ImageView brandIcon;
        RelativeLayout cell;
        ProgressBar progressBar;
        View selectedView;

        void beginLoad()
        {
            brandIcon.setImageBitmap(null);
            progressBar.setVisibility(0);
        }

        void endLoad()
        {
            progressBar.setVisibility(8);
        }

        void hide()
        {
            cell.setVisibility(8);
        }

        void show()
        {
            cell.setVisibility(0);
        }

        BrandCellWrapper(RelativeLayout relativelayout)
        {
            cell = relativelayout;
            brandIcon = (ImageView)relativelayout.findViewById(com.amazon.retailsearch.R.id.rs_brand_strip_icon);
            selectedView = relativelayout.findViewById(com.amazon.retailsearch.R.id.rs_brand_strip_select);
            progressBar = (ProgressBar)relativelayout.findViewById(com.amazon.retailsearch.R.id.rs_brand_strip_cell_progressBar);
        }
    }


    private LinearLayout brandCellsViewGroup;
    private List cellModelList;
    private List cellWrapperList;
    private LayoutInflater inflater;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private int offsets[] = {
        0, 0
    };
    private ResourceProvider resourceProvider;
    private HorizontalScrollView scrollView;
    private SearchImageLoader searchImageLoader;
    private int selectedBrandIndex;
    UserInteractionListener userInteractionListener;

    public BrandstripWidget(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        selectedBrandIndex = 0;
        layoutListener = null;
        init();
    }

    private void addBrandCells(BrandStripModel brandstripmodel)
    {
        if (brandstripmodel.getBrandCells().size() > brandstripmodel.getBrandCellWrappers().size())
        {
            List list = brandstripmodel.getBrandCellWrappers();
            int j = brandstripmodel.getBrandCells().size();
            int k = list.size();
            int i = 0;
            while (i < j - k) 
            {
                brandstripmodel = inflater.inflate(com.amazon.retailsearch.R.layout.rs_brand_cell, this, false);
                brandCellsViewGroup.addView(brandstripmodel);
                list.add(new BrandCellWrapper((RelativeLayout)brandstripmodel));
                i++;
            }
        }
    }

    private void init()
    {
        RetailSearchDaggerGraphController.inject(this);
        setOrientation(1);
        inflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
        inflate(getContext(), com.amazon.retailsearch.R.layout.rs_brand_strip, this);
        scrollView = (HorizontalScrollView)findViewById(com.amazon.retailsearch.R.id.rs_brand_strip_scrollView);
        brandCellsViewGroup = (LinearLayout)findViewById(com.amazon.retailsearch.R.id.rs_brand_strip_cells);
    }

    private void loadAllUnselectedBrands()
    {
        for (int i = 0; i < cellModelList.size(); i++)
        {
            if (i != selectedBrandIndex)
            {
                BrandCell brandcell = (BrandCell)cellModelList.get(i);
                BrandCellWrapper brandcellwrapper = (BrandCellWrapper)cellWrapperList.get(i);
                setupClickListener(brandcellwrapper.brandIcon, brandcell.getLink().getUrl());
                loadBadgeImage(brandcellwrapper, brandcell.getImage().getUrl(), false);
                updateSelected(brandcellwrapper.selectedView, brandcell.getSelected());
                brandcellwrapper.show();
            }
        }

    }

    private void loadBadgeImage(final BrandCellWrapper cellWrapper, String s, final boolean isSelectedBrand)
    {
        if (TextUtils.isEmpty(s) || cellWrapper == null)
        {
            return;
        }
        if (searchImageLoader == null)
        {
            searchImageLoader = (new com.amazon.retailsearch.android.ui.GeneralSearchImageLoader.Builder(resourceProvider, getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_brand_strip_image_height))).build();
        }
        searchImageLoader.load(s, new SearchImageLoaderListener() {

            final BrandstripWidget this$0;
            final BrandCellWrapper val$cellWrapper;
            final boolean val$isSelectedBrand;

            public void onLoad(Bitmap bitmap)
            {
                if (bitmap != null)
                {
                    Bitmap bitmap1 = bitmap;
                    if (bitmap.getConfig() == null)
                    {
                        bitmap1 = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, false);
                    }
                    cellWrapper.brandIcon.setImageBitmap(bitmap1);
                    cellWrapper.endLoad();
                    if (isSelectedBrand)
                    {
                        loadAllUnselectedBrands();
                        setVisibility(0);
                        return;
                    }
                }
            }

            
            {
                this$0 = BrandstripWidget.this;
                cellWrapper = brandcellwrapper;
                isSelectedBrand = flag;
                super();
            }
        });
    }

    private void setupClickListener(ImageView imageview, final String url)
    {
        imageview.setOnClickListener(new android.view.View.OnClickListener() {

            final BrandstripWidget this$0;
            final String val$url;

            public void onClick(View view)
            {
                userInteractionListener.search(url);
            }

            
            {
                this$0 = BrandstripWidget.this;
                url = s;
                super();
            }
        });
    }

    private void updateSelected(final View view, boolean flag)
    {
        Object obj = getResources();
        int i;
        if (flag)
        {
            i = com.amazon.retailsearch.R.color.rs_widgets_brand_strip_icon_selected;
        } else
        {
            i = com.amazon.retailsearch.R.color.rs_widgets_brand_strip_icon_unselected;
        }
        view.setBackgroundColor(((Resources) (obj)).getColor(i));
        obj = view.getLayoutParams();
        if (obj == null)
        {
            return;
        }
        if (flag)
        {
            obj.height = (int)getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_brand_strip_icon_bar_height_selected);
            ViewTreeObserver viewtreeobserver = scrollView.getViewTreeObserver();
            if (layoutListener == null)
            {
                layoutListener = new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                    final BrandstripWidget this$0;
                    final View val$view;

                    public void onGlobalLayout()
                    {
                        view.getLocationOnScreen(offsets);
                        scrollView.scrollTo(scrollView.getScrollX() + offsets[0], 0);
                    }

            
            {
                this$0 = BrandstripWidget.this;
                view = view1;
                super();
            }
                };
                viewtreeobserver.addOnGlobalLayoutListener(layoutListener);
            }
        } else
        {
            obj.height = (int)getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_brand_strip_icon_bar_height_unselected);
        }
        view.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
    }

    public void build(BrandStripModel brandstripmodel)
    {
        setVisibility(8);
        if (brandstripmodel == null)
        {
            return;
        }
        addBrandCells(brandstripmodel);
        resourceProvider = brandstripmodel.getResourceProvider();
        cellModelList = brandstripmodel.getBrandCells();
        cellWrapperList = brandstripmodel.getBrandCellWrappers();
        for (int i = 0; i < cellWrapperList.size(); i++)
        {
            ((BrandCellWrapper)cellWrapperList.get(i)).hide();
            ((BrandCellWrapper)cellWrapperList.get(i)).beginLoad();
        }

        int j = 0;
        do
        {
label0:
            {
                if (j < cellModelList.size())
                {
                    if (!((BrandCell)cellModelList.get(j)).getSelected())
                    {
                        break label0;
                    }
                    selectedBrandIndex = j;
                }
                brandstripmodel = (BrandCell)brandstripmodel.getBrandCells().get(selectedBrandIndex);
                BrandCellWrapper brandcellwrapper = (BrandCellWrapper)cellWrapperList.get(selectedBrandIndex);
                setupClickListener(brandcellwrapper.brandIcon, brandstripmodel.getLink().getUrl());
                loadBadgeImage(brandcellwrapper, brandstripmodel.getImage().getUrl(), true);
                updateSelected(brandcellwrapper.selectedView, brandstripmodel.getSelected());
                brandcellwrapper.show();
                return;
            }
            j++;
        } while (true);
    }

    public volatile void build(Object obj)
    {
        build((BrandStripModel)obj);
    }



}
