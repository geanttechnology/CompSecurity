// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.graphics.Typeface;

public class Typefaces
{

    public static final int WEIGHT_BOLD = 4;
    public static final int WEIGHT_LIGHT = 1;
    public static final int WEIGHT_MEDIUM = 3;
    public static final int WEIGHT_NORMAL = 2;
    private static Typefaces sInstance;
    public final Typeface boldContent;
    public final Typeface boldContentBold;
    public final Typeface boldContentBoldItalic;
    public final Typeface boldContentDetail;
    public final Typeface boldContentItalic;
    public final Typeface lightContent;
    public final Typeface lightContentBold;
    public final Typeface lightContentBoldItalic;
    public final Typeface lightContentDetail;
    public final Typeface lightContentItalic;
    public final Typeface mediumContent;
    public final Typeface mediumContentBold;
    public final Typeface mediumContentBoldItalic;
    public final Typeface mediumContentDetail;
    public final Typeface mediumContentItalic;
    public final Typeface regularContent;
    public final Typeface regularContentBold;
    public final Typeface regularContentBoldItalic;
    public final Typeface regularContentDetail;
    public final Typeface regularContentItalic;

    private Typefaces(Context context)
    {
        context = context.getAssets();
        Typeface typeface = Typeface.createFromAsset(context, "fonts/Roboto-Regular.ttf");
        regularContent = typeface;
        regularContentItalic = Typeface.createFromAsset(context, "fonts/Roboto-Italic.ttf");
        regularContentBold = Typeface.createFromAsset(context, "fonts/Roboto-Bold.ttf");
        regularContentBoldItalic = Typeface.create(regularContentBold, 2);
        regularContentDetail = typeface;
        typeface = Typeface.createFromAsset(context, "fonts/Roboto-Bold.ttf");
        boldContent = typeface;
        boldContentItalic = Typeface.createFromAsset(context, "fonts/Roboto-BoldItalic.ttf");
        boldContentBold = typeface;
        boldContentBoldItalic = Typeface.create(typeface, 2);
        boldContentDetail = typeface;
        typeface = Typeface.createFromAsset(context, "fonts/Roboto-Medium.ttf");
        mediumContent = typeface;
        mediumContentItalic = Typeface.createFromAsset(context, "fonts/Roboto-MediumItalic.ttf");
        mediumContentBold = boldContent;
        mediumContentBoldItalic = Typeface.create(mediumContentBold, 2);
        mediumContentDetail = typeface;
        typeface = Typeface.createFromAsset(context, "fonts/Roboto-Light.ttf");
        lightContent = typeface;
        lightContentItalic = Typeface.createFromAsset(context, "fonts/Roboto-LightItalic.ttf");
        lightContentBold = regularContent;
        lightContentBoldItalic = Typeface.create(lightContentBold, 2);
        lightContentDetail = typeface;
    }

    public static Typefaces get(Context context)
    {
        co/vine/android/widget/Typefaces;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new Typefaces(context);
        }
        context = sInstance;
        co/vine/android/widget/Typefaces;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public Typeface getContentTypeface(int i, int j)
    {
        switch (j)
        {
        case 2: // '\002'
        default:
            if ((i & 1) != 0 && (i & 2) != 0)
            {
                return regularContentBoldItalic;
            }
            break;

        case 1: // '\001'
            if ((i & 1) != 0 && (i & 2) != 0)
            {
                return lightContentBoldItalic;
            }
            if ((i & 1) != 0)
            {
                return lightContentBold;
            }
            if ((i & 2) != 0)
            {
                return lightContentItalic;
            } else
            {
                return lightContent;
            }

        case 3: // '\003'
            if ((i & 1) != 0 && (i & 2) != 0)
            {
                return mediumContentBoldItalic;
            }
            if ((i & 1) != 0)
            {
                return mediumContentBold;
            }
            if ((i & 2) != 0)
            {
                return mediumContentItalic;
            } else
            {
                return mediumContent;
            }

        case 4: // '\004'
            if ((i & 1) != 0 && (i & 2) != 0)
            {
                return boldContentBoldItalic;
            }
            if ((i & 1) != 0)
            {
                return boldContentBold;
            }
            if ((i & 2) != 0)
            {
                return boldContentItalic;
            } else
            {
                return boldContent;
            }
        }
        if ((i & 1) != 0)
        {
            return regularContentBold;
        }
        if ((i & 2) != 0)
        {
            return regularContentItalic;
        } else
        {
            return regularContent;
        }
    }
}
