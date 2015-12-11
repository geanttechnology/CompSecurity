// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bitstrips.outfitbuilder.models.OBBrand;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class BrandHeaderView extends FrameLayout
{

    private ImageView brandBackgroundImage;
    private ImageView brandLogoImage;
    private TextView brandTextualHeader;
    private int currentBrandId;

    public BrandHeaderView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        currentBrandId = 0;
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(getLayout(), this, true);
        brandTextualHeader = (TextView)findViewById(com.bitstrips.outfitbuilder.R.id.textual_brand_header);
        brandBackgroundImage = (ImageView)findViewById(com.bitstrips.outfitbuilder.R.id.background_brand_header);
        brandLogoImage = (ImageView)findViewById(com.bitstrips.outfitbuilder.R.id.background_brand_logo);
    }

    protected int getLayout()
    {
        return com.bitstrips.outfitbuilder.R.layout.brand_header;
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        brandLogoImage.setImageBitmap(null);
        brandBackgroundImage.setImageBitmap(null);
    }

    public void setBrandData(OBBrand obbrand)
    {
        if (obbrand.getId() == currentBrandId)
        {
            return;
        } else
        {
            brandTextualHeader.setBackgroundColor(obbrand.getHeaderBackgroundColor());
            brandTextualHeader.setTextColor(obbrand.getHeaderForegroundColor());
            brandTextualHeader.setText(obbrand.getName());
            Picasso.with(getContext()).load(obbrand.getHeaderBackground()).memoryPolicy(MemoryPolicy.NO_STORE, new MemoryPolicy[0]).fit().noPlaceholder().noFade().into(brandBackgroundImage);
            Picasso.with(getContext()).load(obbrand.getHeaderLogo()).memoryPolicy(MemoryPolicy.NO_STORE, new MemoryPolicy[0]).noPlaceholder().noFade().fit().centerInside().into(brandLogoImage);
            currentBrandId = obbrand.getId();
            return;
        }
    }
}
