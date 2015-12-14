// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import android.net.Uri;
import com.aviary.android.feather.headless.filters.INativeFilter;
import com.aviary.android.feather.headless.filters.NativeFilterProxy;
import com.aviary.android.feather.headless.filters.impl.EffectFilter;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaResult;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import it.sephiroth.android.library.picasso.Request;
import it.sephiroth.android.library.picasso.RequestHandler;
import java.io.IOException;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            EffectsPanel

static class mThumbStrokeWidth extends RequestHandler
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
        EffectFilter effectfilter = (EffectFilter)ToolLoaderFactory.get(com.aviary.android.feather.library.filters.bStrokeWidth);
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

    public it.sephiroth.android.library.picasso. load(Request request)
        throws IOException
    {
        if (request.uri != null)
        {
            return new it.sephiroth.android.library.picasso.(decode(request.uri), it.sephiroth.android.library.picasso..decode);
        } else
        {
            return null;
        }
    }

    public (Bitmap bitmap, double d, int i, int j, int k, int l, 
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
