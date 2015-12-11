// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Annotation;

// Referenced classes of package com.google.android.gms.wallet.fragment:
//            zzc

public final class WalletFragmentStyle
    implements SafeParcelable
{
    public static interface BuyButtonAppearance
        extends Annotation
    {

        public static final int GOOGLE_WALLET_CLASSIC = 1;
        public static final int GOOGLE_WALLET_GRAYSCALE = 2;
        public static final int GOOGLE_WALLET_MONOCHROME = 3;
    }

    public static interface BuyButtonText
        extends Annotation
    {

        public static final int BUY_WITH = 5;
        public static final int DONATE_WITH = 7;
    }

    public static interface Dimension
        extends Annotation
    {

        public static final int MATCH_PARENT = -1;
        public static final int UNIT_DIP = 1;
        public static final int UNIT_IN = 4;
        public static final int UNIT_MM = 5;
        public static final int UNIT_PT = 3;
        public static final int UNIT_PX = 0;
        public static final int UNIT_SP = 2;
        public static final int WRAP_CONTENT = -2;
    }

    public static interface LogoImageType
        extends Annotation
    {

        public static final int GOOGLE_WALLET_CLASSIC = 1;
        public static final int GOOGLE_WALLET_MONOCHROME = 2;
    }


    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    final int mVersionCode;
    Bundle zzbes;
    int zzbet;

    public WalletFragmentStyle()
    {
        mVersionCode = 1;
        zzbes = new Bundle();
    }

    WalletFragmentStyle(int i, Bundle bundle, int j)
    {
        mVersionCode = i;
        zzbes = bundle;
        zzbet = j;
    }

    private static int zza(long l, DisplayMetrics displaymetrics)
    {
        int i;
        int j;
        i = (int)(l >>> 32);
        j = (int)l;
        i;
        JVM INSTR lookupswitch 8: default 84
    //                   0: 121
    //                   1: 137
    //                   2: 142
    //                   3: 147
    //                   4: 152
    //                   5: 157
    //                   128: 114
    //                   129: 111;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        throw new IllegalStateException((new StringBuilder()).append("Unexpected unit or type: ").append(i).toString());
_L9:
        return j;
_L8:
        return TypedValue.complexToDimensionPixelSize(j, displaymetrics);
_L2:
        i = 0;
_L11:
        return Math.round(TypedValue.applyDimension(i, Float.intBitsToFloat(j), displaymetrics));
_L3:
        i = 1;
        continue; /* Loop/switch isn't completed */
_L4:
        i = 2;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 3;
        continue; /* Loop/switch isn't completed */
_L6:
        i = 4;
        continue; /* Loop/switch isn't completed */
_L7:
        i = 5;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private static long zza(int i, float f)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unrecognized unit: ").append(i).toString());

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return zzt(i, Float.floatToIntBits(f));
        }
    }

    private static long zza(TypedValue typedvalue)
    {
        switch (typedvalue.type)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected dimension type: ").append(typedvalue.type).toString());

        case 16: // '\020'
            return zzkx(typedvalue.data);

        case 5: // '\005'
            return zzt(128, typedvalue.data);
        }
    }

    private void zza(TypedArray typedarray, int i, String s)
    {
        if (!zzbes.containsKey(s))
        {
            if ((typedarray = typedarray.peekValue(i)) != null)
            {
                zzbes.putLong(s, zza(((TypedValue) (typedarray))));
                return;
            }
        }
    }

    private void zza(TypedArray typedarray, int i, String s, String s1)
    {
        if (!zzbes.containsKey(s) && !zzbes.containsKey(s1))
        {
            if ((typedarray = typedarray.peekValue(i)) != null)
            {
                if (((TypedValue) (typedarray)).type >= 28 && ((TypedValue) (typedarray)).type <= 31)
                {
                    zzbes.putInt(s, ((TypedValue) (typedarray)).data);
                    return;
                } else
                {
                    zzbes.putInt(s1, ((TypedValue) (typedarray)).resourceId);
                    return;
                }
            }
        }
    }

    private void zzb(TypedArray typedarray, int i, String s)
    {
        if (!zzbes.containsKey(s))
        {
            if ((typedarray = typedarray.peekValue(i)) != null)
            {
                zzbes.putInt(s, ((TypedValue) (typedarray)).data);
                return;
            }
        }
    }

    private static long zzkx(int i)
    {
        if (i < 0)
        {
            if (i == -1 || i == -2)
            {
                return zzt(129, i);
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Unexpected dimension value: ").append(i).toString());
            }
        } else
        {
            return zza(0, i);
        }
    }

    private static long zzt(int i, int j)
    {
        return (long)i << 32 | (long)j & 0xffffffffL;
    }

    public int describeContents()
    {
        return 0;
    }

    public WalletFragmentStyle setBuyButtonAppearance(int i)
    {
        zzbes.putInt("buyButtonAppearance", i);
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int i)
    {
        zzbes.putLong("buyButtonHeight", zzkx(i));
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int i, float f)
    {
        zzbes.putLong("buyButtonHeight", zza(i, f));
        return this;
    }

    public WalletFragmentStyle setBuyButtonText(int i)
    {
        zzbes.putInt("buyButtonText", i);
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int i)
    {
        zzbes.putLong("buyButtonWidth", zzkx(i));
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int i, float f)
    {
        zzbes.putLong("buyButtonWidth", zza(i, f));
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int i)
    {
        zzbes.remove("maskedWalletDetailsBackgroundResource");
        zzbes.putInt("maskedWalletDetailsBackgroundColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int i)
    {
        zzbes.remove("maskedWalletDetailsBackgroundColor");
        zzbes.putInt("maskedWalletDetailsBackgroundResource", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int i)
    {
        zzbes.remove("maskedWalletDetailsButtonBackgroundResource");
        zzbes.putInt("maskedWalletDetailsButtonBackgroundColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int i)
    {
        zzbes.remove("maskedWalletDetailsButtonBackgroundColor");
        zzbes.putInt("maskedWalletDetailsButtonBackgroundResource", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int i)
    {
        zzbes.putInt("maskedWalletDetailsButtonTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int i)
    {
        zzbes.putInt("maskedWalletDetailsHeaderTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int i)
    {
        zzbes.putInt("maskedWalletDetailsLogoImageType", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int i)
    {
        zzbes.putInt("maskedWalletDetailsLogoTextColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int i)
    {
        zzbes.putInt("maskedWalletDetailsTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setStyleResourceId(int i)
    {
        zzbet = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    public int zza(String s, DisplayMetrics displaymetrics, int i)
    {
        if (zzbes.containsKey(s))
        {
            i = zza(zzbes.getLong(s), displaymetrics);
        }
        return i;
    }

    public void zzaT(Context context)
    {
        int i;
        if (zzbet <= 0)
        {
            i = com.google.android.gms.R.style.WalletFragmentDefaultStyle;
        } else
        {
            i = zzbet;
        }
        context = context.obtainStyledAttributes(i, com.google.android.gms.R.styleable.WalletFragmentStyle);
        zza(context, com.google.android.gms.R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
        zza(context, com.google.android.gms.R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
        zzb(context, com.google.android.gms.R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
        zzb(context, com.google.android.gms.R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
        zzb(context, com.google.android.gms.R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
        zzb(context, com.google.android.gms.R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
        zza(context, com.google.android.gms.R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        zzb(context, com.google.android.gms.R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
        zza(context, com.google.android.gms.R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        zzb(context, com.google.android.gms.R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
        zzb(context, com.google.android.gms.R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
        context.recycle();
    }

}
