// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.image.NetworkLogoImageLoader;
import com.xfinity.playerlib.model.EditorialProgram;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            FeaturedAdapter

public class PhoneCoverAdapter extends FeaturedAdapter
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/featured/PhoneCoverAdapter);
    protected static int coverImageHeightPx = 0;
    protected final PlayerConfiguration configuration;

    public PhoneCoverAdapter(LayoutInflater layoutinflater, CoverArtImageLoader coverartimageloader, NetworkLogoImageLoader networklogoimageloader, PlayerConfiguration playerconfiguration, String s)
    {
        super(layoutinflater, coverartimageloader, networklogoimageloader, s, null);
        configuration = playerconfiguration;
        coverImageHeightPx = getCoverImageHeight().y;
    }

    protected void adjustImageHeight(View view)
    {
        view = (ImageView)view.findViewById(com.xfinity.playerlib.R.id.cover_art);
        view.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, coverImageHeightPx));
        view.requestLayout();
    }

    protected Point getCoverImageHeight()
    {
        Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
        return new Point(display.getWidth(), display.getWidth() / 2);
    }

    public String getImageUrl(int i, int j, MerlinId merlinid)
    {
        return String.format(Locale.US, "%s/%d/%d/%d?noRedir=true", new Object[] {
            configuration.getEntityThumbnailUri(), merlinid.getSimpleId(), Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    protected String getImageUrl(EditorialProgram editorialprogram)
    {
        if (editorialprogram.getImageKey() != null && editorialprogram.getImageKey().length() > 0)
        {
            return editorialprogram.getImageKey();
        } else
        {
            return getImageUrl(context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.editorial_cover_src_width), context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.editorial_cover_src_height), editorialprogram.getParentMerlinIdIfApplicable());
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = super.getView(i, view, viewgroup);
        adjustImageHeight(view);
        return view;
    }

    protected int getViewLayoutId()
    {
        return com.xfinity.playerlib.R.layout.phone_cover_item;
    }

    protected void setupLockedIndicator(ImageView imageview, EditorialProgram editorialprogram, VideoEntitlement videoentitlement)
    {
        setupLockedIndicator(imageview, editorialprogram, videoentitlement, 8);
    }

    protected void setupNetworkLogo(ImageView imageview, EditorialProgram editorialprogram, NetworkLogoImageLoader networklogoimageloader, Map map)
    {
        setupNetworkLogo(imageview, editorialprogram, networklogoimageloader, map, 8);
    }

    protected void setupProgramArt(FeaturedAdapter.VideoViewHolder videoviewholder, EditorialProgram editorialprogram)
    {
        setupProgramArt(videoviewholder, editorialprogram, true);
    }

}
