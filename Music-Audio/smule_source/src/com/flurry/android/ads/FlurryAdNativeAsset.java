// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;

import android.content.Context;
import android.view.View;
import com.flurry.android.impl.ads.protocol.v13.NativeAsset;
import com.flurry.android.impl.ads.protocol.v13.NativeAssetType;
import com.flurry.sdk.i;
import com.flurry.sdk.m;

// Referenced classes of package com.flurry.android.ads:
//            FlurryAdNativeAssetType

public final class FlurryAdNativeAsset
{

    private NativeAsset a;
    private int b;

    FlurryAdNativeAsset(NativeAsset nativeasset, int j)
    {
        if (nativeasset == null)
        {
            throw new IllegalArgumentException("asset cannot be null");
        } else
        {
            a = nativeasset;
            b = j;
            return;
        }
    }

    public View getAssetView(Context context)
    {
        return i.a().j().a(context, a, b);
    }

    public String getName()
    {
        return a.name;
    }

    public FlurryAdNativeAssetType getType()
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[NativeAssetType.values().length];
                try
                {
                    a[NativeAssetType.STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[NativeAssetType.IMAGE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[a.type.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return FlurryAdNativeAssetType.TEXT;

        case 2: // '\002'
            return FlurryAdNativeAssetType.IMAGE;
        }
    }

    public String getValue()
    {
        switch (_cls1.a[a.type.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return a.value;

        case 2: // '\002'
            return i.a().j().a(a, b);
        }
    }

    public void loadAssetIntoView(View view)
    {
        i.a().j().a(a, view, b);
    }
}
