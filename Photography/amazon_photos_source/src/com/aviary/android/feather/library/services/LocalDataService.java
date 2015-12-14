// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.aviary.android.feather.common.utils.PackageManagerUtils;
import com.aviary.android.feather.common.utils.ReflectionException;
import com.aviary.android.feather.common.utils.ReflectionUtils;
import com.aviary.android.feather.headless.utils.MegaPixels;
import com.aviary.android.feather.library.utils.ImageInfo;
import com.aviary.android.feather.library.vo.EditToolVO;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.library.services:
//            BaseContextService, IAviaryController

public final class LocalDataService extends BaseContextService
{

    private Uri destImageUri;
    private ImageInfo mImageInfo;
    private final Intent mOriginalIntent;
    private final List mRecipe = new ArrayList(0);
    private android.graphics.Bitmap.CompressFormat outputFormat;
    private Uri sourceImageUri;

    public LocalDataService(IAviaryController iaviarycontroller)
    {
        super(iaviarycontroller);
        iaviarycontroller = iaviarycontroller.getBaseActivity().getIntent();
        if (iaviarycontroller != null)
        {
            mOriginalIntent = iaviarycontroller;
        } else
        {
            mOriginalIntent = new Intent();
        }
    }

    private MegaPixels loadStandaloneOutputImageSize()
        throws ReflectionException
    {
        Object obj = getContext();
        if (obj == null)
        {
            return null;
        }
        obj = ((IAviaryController) (obj)).getBaseContext();
        if (obj == null)
        {
            return null;
        }
        if (PackageManagerUtils.isStandalone(((Context) (obj))))
        {
            obj = ReflectionUtils.invokeStaticMethod("com.aviary.android.feather.utils.SettingsUtils", "getInstance", new Class[] {
                android/content/Context
            }, new Object[] {
                obj
            });
            if (obj != null)
            {
                obj = ReflectionUtils.invokeMethod(obj, "getOutputImageSize");
                if (obj != null && (obj instanceof MegaPixels))
                {
                    return (MegaPixels)obj;
                }
            }
        }
        return null;
    }

    public void addRecipe(EditToolVO edittoolvo)
    {
        mRecipe.add(edittoolvo);
    }

    public void clearRecipe()
    {
        mRecipe.clear();
    }

    public void dispose()
    {
    }

    public Uri getDestImageUri()
    {
        if (destImageUri == null && mOriginalIntent.hasExtra("output"))
        {
            destImageUri = (Uri)mOriginalIntent.getParcelableExtra("output");
        }
        return destImageUri;
    }

    public ImageInfo getImageInfo()
    {
        return mImageInfo;
    }

    public Object getIntentExtra(String s, Object obj)
    {
        Bundle bundle = mOriginalIntent.getExtras();
        Object obj1 = obj;
        if (bundle != null)
        {
            obj1 = obj;
            if (bundle.containsKey(s))
            {
                try
                {
                    s = ((String) (bundle.get(s)));
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return obj;
                }
                obj1 = obj;
                if (s != null)
                {
                    obj1 = s;
                }
            }
        }
        return obj1;
    }

    public boolean getIntentHasExtra(String s)
    {
        return mOriginalIntent.hasExtra(s);
    }

    public Bundle getOptionalBundle()
    {
        return mOriginalIntent.getBundleExtra("extra-in-extras");
    }

    public Bundle getOriginalExtras()
    {
        return mOriginalIntent.getExtras();
    }

    public Intent getOriginalIntent()
    {
        return mOriginalIntent;
    }

    public android.graphics.Bitmap.CompressFormat getOutputFormat()
    {
        if (outputFormat == null)
        {
            String s = (String)getIntentExtra("output-format", android.graphics.Bitmap.CompressFormat.JPEG.name());
            if (s != null)
            {
                outputFormat = android.graphics.Bitmap.CompressFormat.valueOf(s);
            } else
            {
                outputFormat = android.graphics.Bitmap.CompressFormat.JPEG;
            }
        }
        return outputFormat;
    }

    public int getOutputQuality()
    {
        return ((Integer)getIntentExtra("output-quality", Integer.valueOf(97))).intValue();
    }

    public List getRecipe()
    {
        return mRecipe;
    }

    public int getRequestedMegaPixels()
    {
        int j = ((Integer)getIntentExtra("output-hires-megapixels", Integer.valueOf(-1))).intValue();
        int i = j;
        if (j < 0)
        {
            try
            {
                i = loadStandaloneOutputImageSize().ordinal();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                i = j;
            }
        }
        return Math.min(i, MegaPixels.Mp30.ordinal());
    }

    public Uri getSourceImageUri()
    {
        this;
        JVM INSTR monitorenter ;
        Uri uri = sourceImageUri;
        this;
        JVM INSTR monitorexit ;
        return uri;
        Exception exception;
        exception;
        throw exception;
    }

    public void remove(String s)
    {
        mOriginalIntent.removeExtra(s);
    }

    public void setDestImageUri(Uri uri)
    {
        destImageUri = uri;
    }

    public void setImageInfo(ImageInfo imageinfo)
    {
        mImageInfo = imageinfo;
    }

    public void setSourceImageUri(Uri uri)
    {
        this;
        JVM INSTR monitorenter ;
        sourceImageUri = uri;
        this;
        JVM INSTR monitorexit ;
        return;
        uri;
        throw uri;
    }
}
