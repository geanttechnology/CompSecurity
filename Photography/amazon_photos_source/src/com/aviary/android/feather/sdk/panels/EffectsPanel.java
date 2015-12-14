// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.headless.filters.INativeFilter;
import com.aviary.android.feather.headless.filters.NativeFilter;
import com.aviary.android.feather.headless.filters.NativeFilterProxy;
import com.aviary.android.feather.headless.filters.impl.EffectFilter;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaResult;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.services.ConfigService;
import com.aviary.android.feather.library.services.IAviaryController;
import it.sephiroth.android.library.picasso.Picasso;
import it.sephiroth.android.library.picasso.Request;
import it.sephiroth.android.library.picasso.RequestHandler;
import java.io.IOException;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            BordersPanel

public class EffectsPanel extends BordersPanel
{
    class EffectsListAdapter extends BordersPanel.ListAdapter
    {

        final EffectsPanel this$0;

        public EffectsListAdapter(Context context, int i, int j, int k, int l, Cursor cursor)
        {
            this$0 = EffectsPanel.this;
            super(EffectsPanel.this, context, i, j, k, l, cursor);
        }
    }

    protected class EffectsRenderTask extends BordersPanel.RenderTask
    {

        final EffectsPanel this$0;

        public EffectsRenderTask(int i, float f)
        {
            this$0 = EffectsPanel.this;
            super(EffectsPanel.this, i, f);
        }
    }

    static class EffectsRequestHandler extends RequestHandler
    {

        static final String FILTER_SCHEME = "aviary_effect";
        private final double mFactor;
        private final int mThumbPadding;
        private final int mThumbRoundedCorners;
        private final int mThumbSize;
        private final int mThumbStrokeColor;
        private final int mThumbStrokeWidth;
        private Bitmap srcBitmap;

        private INativeFilter loadFilter(CharSequence charsequence)
        {
            EffectFilter effectfilter = (EffectFilter)ToolLoaderFactory.get(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.EFFECTS);
            effectfilter.setMoaLiteEffect((String)charsequence);
            effectfilter.setPreviewSize(srcBitmap.getWidth(), srcBitmap.getHeight());
            return effectfilter;
        }

        MoaActionList actionsForRoundedThumbnail(boolean flag, INativeFilter inativefilter)
        {
            MoaActionList moaactionlist = MoaActionFactory.actionList();
            if (inativefilter != null)
            {
                moaactionlist.addAll(inativefilter.getActions());
            }
            if (mFactor != 1.0D)
            {
                inativefilter = MoaActionFactory.action("resize");
                inativefilter.setValue("size", mThumbSize);
                inativefilter.setValue("force", true);
                moaactionlist.add(inativefilter);
            }
            inativefilter = MoaActionFactory.action("ext-roundedborders");
            inativefilter.setValue("padding", mThumbPadding);
            inativefilter.setValue("roundPx", mThumbRoundedCorners);
            inativefilter.setValue("strokeColor", mThumbStrokeColor);
            inativefilter.setValue("strokeWeight", mThumbStrokeWidth);
            if (!flag)
            {
                inativefilter.setValue("overlaycolor", 0x99000000);
            }
            moaactionlist.add(inativefilter);
            return moaactionlist;
        }

        public Bitmap call(String s)
            throws Exception
        {
            boolean flag = true;
            Object obj = null;
            try
            {
                s = loadFilter(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                flag = false;
                s = obj;
            }
            s = NativeFilterProxy.prepareActions(actionsForRoundedThumbnail(flag, s), srcBitmap, null, 1, 1);
            s.execute();
            return ((MoaResult) (s)).outputBitmap;
        }

        public boolean canHandleRequest(Request request)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (request.uri != null)
            {
                request = request.uri.getScheme();
                flag = flag1;
                if (request != null)
                {
                    flag = flag1;
                    if ("aviary_effect".equals(request))
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        public Bitmap decode(Uri uri)
            throws IOException
        {
            try
            {
                uri = call(uri.getPath());
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                uri.printStackTrace();
                throw new IOException(uri);
            }
            return uri;
        }

        public it.sephiroth.android.library.picasso.RequestHandler.Result load(Request request)
            throws IOException
        {
            if (request.uri != null)
            {
                return new it.sephiroth.android.library.picasso.RequestHandler.Result(decode(request.uri), it.sephiroth.android.library.picasso.Picasso.LoadedFrom.NETWORK);
            } else
            {
                return null;
            }
        }

        public EffectsRequestHandler(Bitmap bitmap, double d, int i, int j, int k, int l, 
                int i1)
        {
            srcBitmap = bitmap;
            mFactor = d;
            mThumbSize = i;
            mThumbPadding = j;
            mThumbRoundedCorners = k;
            mThumbStrokeColor = l;
            mThumbStrokeWidth = i1;
        }
    }


    public static final double DEFAULT_THUMBNAIL_RESIZE_RATIO = 1.3999999999999999D;
    public static final double THUMBNAIL_RESIZE_RATIO_SLOW_CPU = 2D;
    private double mFactor;
    private RequestHandler mRequestHandler;
    protected Bitmap mThumbBitmap;
    private int mThumbPadding;
    private int mThumbRoundedCorners;
    private int mThumbStrokeColor;
    private int mThumbStrokeWidth;

    public EffectsPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry, com.aviary.android.feather.cds.AviaryCds.PackType.EFFECT);
    }

    private Bitmap generateThumbnail(Bitmap bitmap, int i, int j)
    {
        return ThumbnailUtils.extractThumbnail(bitmap, (int)((double)i / mFactor), (int)((double)j / mFactor));
    }

    protected volatile CursorAdapter createListAdapter(Context context, Cursor cursor)
    {
        return createListAdapter(context, cursor);
    }

    protected BordersPanel.ListAdapter createListAdapter(Context context, Cursor cursor)
    {
        return new EffectsListAdapter(context, com.aviary.android.feather.sdk.R.layout.aviary_frame_item, com.aviary.android.feather.sdk.R.layout.aviary_effect_item_more, com.aviary.android.feather.sdk.R.layout.aviary_effect_item_external, com.aviary.android.feather.sdk.R.layout.aviary_frame_item_divider, cursor);
    }

    protected BordersPanel.RenderTask createRenderTask(int i, float f)
    {
        return new EffectsRenderTask(i, f);
    }

    protected boolean getIntensityIsManaged()
    {
        return false;
    }

    protected boolean getIntensitySliderEnabled()
    {
        return ApiHelper.EFFECT_INTENSITY_AVAILABLE;
    }

    protected CharSequence[] getOptionalEffectsLabels()
    {
        return super.getOptionalEffectsLabels();
    }

    protected boolean isContentTutorialNeeded()
    {
        return false;
    }

    protected NativeFilter loadNativeFilter(com.aviary.android.feather.cds.TrayColumns.TrayCursorWrapper traycursorwrapper, int i, boolean flag, float f)
    {
        if (traycursorwrapper != null && i > -1)
        {
            EffectFilter effectfilter = (EffectFilter)ToolLoaderFactory.get(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.EFFECTS);
            effectfilter.setMoaLiteEffect((new StringBuilder()).append(traycursorwrapper.getPath()).append("/").append(traycursorwrapper.getIdentifier()).append(".json").toString());
            effectfilter.setPreviewSize(mPreview.getWidth(), mPreview.getHeight());
            effectfilter.setIntensity(f);
            return effectfilter;
        } else
        {
            return null;
        }
    }

    protected void onAddCustomRequestHandlers()
    {
        super.onAddCustomRequestHandlers();
        mThumbBitmap = generateThumbnail(mBitmap, mThumbSize, mThumbSize);
        mRequestHandler = new EffectsRequestHandler(mThumbBitmap, mFactor, mThumbSize, mThumbPadding, mThumbRoundedCorners, mThumbStrokeColor, mThumbStrokeWidth);
        try
        {
            mPicassoLibrary.addRequestHandler(mRequestHandler);
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            illegalstateexception.printStackTrace();
        }
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        mLogger.info((new StringBuilder()).append("FastPreview enabled: ").append(mEnableFastPreview).toString());
        mThumbPadding = mConfigService.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_effect_thumb_padding);
        mThumbRoundedCorners = mConfigService.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_effect_thumb_radius);
        mThumbStrokeWidth = mConfigService.getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_effect_thumb_stroke);
        mThumbStrokeColor = mConfigService.getColor(com.aviary.android.feather.sdk.R.color.aviary_effect_thumb_stroke_color);
        mFactor = 1.3999999999999999D;
        int i = com.aviary.android.feather.common.utils.SystemUtils.CpuInfo.getCpuMhz();
        if (i > 0)
        {
            if (i < 1000)
            {
                mFactor = 2D;
            }
            mLogger.log((new StringBuilder()).append("thumbnails scale factor: ").append(mFactor).append(" with cpu: ").append(i).toString());
        }
    }

    protected void onDispose()
    {
        super.onDispose();
        if (mThumbBitmap != null && !mThumbBitmap.isRecycled())
        {
            mThumbBitmap.recycle();
        }
        mThumbBitmap = null;
    }

    protected void onPostActivate()
    {
        super.onPostActivate();
    }

    protected void onProgressEnd()
    {
        if (!mEnableFastPreview)
        {
            super.onProgressModalEnd();
            return;
        } else
        {
            super.onProgressEnd();
            return;
        }
    }

    protected void onProgressStart()
    {
        if (!mEnableFastPreview)
        {
            super.onProgressModalStart();
            return;
        } else
        {
            super.onProgressStart();
            return;
        }
    }

    protected void onRemoveCustomRequestHandlers()
    {
        super.onRemoveCustomRequestHandlers();
        if (mRequestHandler != null)
        {
            mPicassoLibrary.removeRequestHandler(mRequestHandler);
        }
        mRequestHandler = null;
    }
}
