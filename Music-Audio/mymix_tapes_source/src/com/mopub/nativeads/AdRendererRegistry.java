// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.mopub.nativeads:
//            MoPubAdRenderer, NativeAd, BaseNativeAd

public class AdRendererRegistry
{

    private final ArrayList mMoPubAdRenderers = new ArrayList();

    public AdRendererRegistry()
    {
    }

    public int getAdRendererCount()
    {
        return mMoPubAdRenderers.size();
    }

    public MoPubAdRenderer getRendererForAd(BaseNativeAd basenativead)
    {
        Preconditions.checkNotNull(basenativead);
        for (Iterator iterator = mMoPubAdRenderers.iterator(); iterator.hasNext();)
        {
            MoPubAdRenderer mopubadrenderer = (MoPubAdRenderer)iterator.next();
            if (mopubadrenderer.supports(basenativead))
            {
                return mopubadrenderer;
            }
        }

        return null;
    }

    public MoPubAdRenderer getRendererForViewType(int i)
    {
        MoPubAdRenderer mopubadrenderer;
        try
        {
            mopubadrenderer = (MoPubAdRenderer)mMoPubAdRenderers.get(i - 1);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            return null;
        }
        return mopubadrenderer;
    }

    public Iterable getRendererIterable()
    {
        return mMoPubAdRenderers;
    }

    public int getViewTypeForAd(NativeAd nativead)
    {
        Preconditions.checkNotNull(nativead);
        for (int i = 0; i < mMoPubAdRenderers.size(); i++)
        {
            if (nativead.getMoPubAdRenderer() == mMoPubAdRenderers.get(i))
            {
                return i + 1;
            }
        }

        return 0;
    }

    public void registerAdRenderer(MoPubAdRenderer mopubadrenderer)
    {
        mMoPubAdRenderers.add(mopubadrenderer);
    }
}
