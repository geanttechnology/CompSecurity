// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.aviary.android.feather.cds.AviaryCds;
import com.aviary.android.feather.cds.CdsUtils;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.OverlayFilter;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.utils.DecodeUtils;
import com.aviary.android.feather.library.utils.ImageInfo;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.overlays.AviaryOverlay;
import com.aviary.android.feather.sdk.overlays.OverlayOverlay;
import com.aviary.android.feather.sdk.widget.ImageViewOverlay;
import java.util.HashMap;
import java.util.Locale;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            BordersPanel

public class OverlaysPanel extends BordersPanel
{

    private OverlayFilter mCurrentFilter;

    public OverlaysPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry, com.aviary.android.feather.cds.AviaryCds.PackType.OVERLAY);
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_overlays, null);
    }

    protected int getTutorialOverlayId()
    {
        return 7;
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
    }

    protected void onGenerateFinalBitmap()
    {
        if (mCurrentFilter != null)
        {
            Bitmap bitmap = ((ImageViewOverlay)mImageView).generateResultBitmap(mCurrentFilter);
            getEditToolResult().setActionList(mCurrentFilter.getActions());
            onComplete(bitmap);
            return;
        } else
        {
            getContext().cancel();
            return;
        }
    }

    protected void onSetupImageView()
    {
        ((ImageViewOverlay)mImageView).setImageBitmap(mPreview, null);
    }

    protected void renderEffect(com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper traycursorwrapper, int i, float f)
    {
        mLogger.info("renderEffect. item: %s", new Object[] {
            traycursorwrapper
        });
        if (traycursorwrapper != null)
        {
            Object obj = (new StringBuilder()).append(traycursorwrapper.getPath()).append("/").append(AviaryCds.getPackItemFilename(traycursorwrapper.getIdentifier(), com.aviary.android.feather.cds.AviaryCds.PackType.STICKER, com.aviary.android.feather.cds.AviaryCds.Size.Medium)).toString();
            i = Math.max(mPreview.getWidth(), mPreview.getHeight());
            mLogger.log("path: %s", new Object[] {
                obj
            });
            mLogger.log("max_size: %d", new Object[] {
                Integer.valueOf(i)
            });
            obj = DecodeUtils.decode(getContext().getBaseContext(), Uri.parse(((String) (obj))), i, i, new ImageInfo());
            if (((ImageViewOverlay)mImageView).getOverlayDrawable() != null)
            {
                ((ImageViewOverlay)mImageView).updateImageOverlay(((Bitmap) (obj)));
            } else
            {
                ((ImageViewOverlay)mImageView).setImageBitmap(mPreview, ((Bitmap) (obj)));
            }
            setIsChanged(true);
            obj = new ToolActionVO();
            ((ToolActionVO) (obj)).setPackIdentifier(traycursorwrapper.getPackageName());
            ((ToolActionVO) (obj)).setContentIdentifier(traycursorwrapper.getIdentifier());
            getEditToolResult().setToolAction(((ToolActionVO) (obj)));
            obj = CdsUtils.getPackContentPath(getContext().getBaseContext(), traycursorwrapper.getPackId());
            mLogger.log("packId: %d, contentPath: %s", new Object[] {
                Long.valueOf(traycursorwrapper.getId()), obj
            });
            mCurrentFilter = (OverlayFilter)ToolLoaderFactory.get(getName());
            mCurrentFilter.setSourceDir(((String) (obj)));
            mCurrentFilter.setUrl(traycursorwrapper.getIdentifier());
            obj = new HashMap();
            ((HashMap) (obj)).put("pack", traycursorwrapper.getPackageName());
            ((HashMap) (obj)).put("item", traycursorwrapper.getIdentifier());
            getContext().getTracker().tagEventAttributes((new StringBuilder()).append(getName().name().toLowerCase(Locale.US)).append(": item_previewed").toString(), ((HashMap) (obj)));
            mTrackingAttributes.put("pack", traycursorwrapper.getPackageName());
            mTrackingAttributes.put("item", traycursorwrapper.getIdentifier());
            if (AviaryOverlay.shouldShow(getContext(), 8))
            {
                traycursorwrapper = new OverlayOverlay(getContext().getBaseContext(), com.aviary.android.feather.sdk.R.style.AviaryWidget_Overlay_Overlay);
                if (traycursorwrapper.show())
                {
                    traycursorwrapper.setOnCloseListener(new com.aviary.android.feather.sdk.overlays.AviaryOverlay.OnCloseListener() {

                        final OverlaysPanel this$0;

                        public void onClose(AviaryOverlay aviaryoverlay)
                        {
                            aviaryoverlay.dismiss();
                        }

            
            {
                this$0 = OverlaysPanel.this;
                super();
            }
                    });
                }
            }
            return;
        } else
        {
            ((ImageViewOverlay)mImageView).setImageBitmap(mPreview, null);
            getEditToolResult().reset();
            setIsChanged(false);
            return;
        }
    }
}
