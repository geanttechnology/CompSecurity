// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.EditText;

public class RobotoEditText extends EditText
{

    private static final int ROBOTO_BLACK = 10;
    private static final int ROBOTO_BLACK_ITALIC = 11;
    private static final int ROBOTO_BOLD = 8;
    private static final int ROBOTO_BOLD_ITALIC = 9;
    private static final int ROBOTO_CONDENSED = 12;
    private static final int ROBOTO_CONDENSED_BOLD = 14;
    private static final int ROBOTO_CONDENSED_BOLD_ITALIC = 15;
    private static final int ROBOTO_CONDENSED_ITALIC = 13;
    private static final int ROBOTO_ITALIC = 5;
    private static final int ROBOTO_LIGHT = 2;
    private static final int ROBOTO_LIGHT_ITALIC = 3;
    private static final int ROBOTO_MEDIUM = 6;
    private static final int ROBOTO_MEDIUM_ITALIC = 7;
    private static final int ROBOTO_REGULAR = 4;
    private static final int ROBOTO_THIN = 0;
    private static final int ROBOTO_THIN_ITALIC = 1;
    private static final SparseArray mTypefaces = new SparseArray(16);

    public RobotoEditText(Context context)
    {
        super(context);
    }

    public RobotoEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        if (!isInEditMode())
        {
            parseAttributes(context, attributeset);
        }
    }

    public RobotoEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (!isInEditMode())
        {
            parseAttributes(context, attributeset);
        }
    }

    private Typeface createTypeface(Context context, int i)
        throws IllegalArgumentException
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown `typeface` attribute value ").append(i).toString());

        case 0: // '\0'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Thin.ttf");

        case 1: // '\001'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-ThinItalic.ttf");

        case 2: // '\002'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");

        case 3: // '\003'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-LightItalic.ttf");

        case 4: // '\004'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");

        case 5: // '\005'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Italic.ttf");

        case 6: // '\006'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");

        case 7: // '\007'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-MediumItalic.ttf");

        case 8: // '\b'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Bold.ttf");

        case 9: // '\t'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BoldItalic.ttf");

        case 10: // '\n'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Black.ttf");

        case 11: // '\013'
            return Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-BlackItalic.ttf");

        case 12: // '\f'
            return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Regular.ttf");

        case 13: // '\r'
            return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Italic.ttf");

        case 14: // '\016'
            return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Bold.ttf");

        case 15: // '\017'
            return Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Bold-Italic.ttf");
        }
    }

    private Typeface obtaintTypeface(Context context, int i)
        throws IllegalArgumentException
    {
        Typeface typeface1 = (Typeface)mTypefaces.get(i);
        Typeface typeface = typeface1;
        if (typeface1 == null)
        {
            typeface = createTypeface(context, i);
            mTypefaces.put(i, typeface);
        }
        return typeface;
    }

    private void parseAttributes(Context context, AttributeSet attributeset)
    {
        attributeset = context.obtainStyledAttributes(attributeset, my.googlemusic.play.R.styleable.RobotoTextView);
        int i = attributeset.getInt(3, 0);
        attributeset.recycle();
        setTypeface(obtaintTypeface(context, i));
    }

}
