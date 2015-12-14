// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.os.Parcel;
import android.os.Parcelable;
import com.socialin.android.NoProGuard;
import java.io.File;
import java.io.Serializable;

// Referenced classes of package com.socialin.android.photo.textart:
//            TypefaceSpec

public class TextArtStyle
    implements Parcelable, NoProGuard, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new TextArtStyle(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new TextArtStyle[i];
        }

    };
    private static final int DEFAULT_FILL_COLOR = -1;
    private static final int DEFAULT_FONT_SIZE = 30;
    public static final int STROKE_WIDTH = 1;
    private static final long serialVersionUID = 0xb6284557753a4d73L;
    private int alignment;
    private int fillColor;
    private int fillGradientBottomColor;
    private int fontSize;
    private boolean hasGradient;
    private boolean hasStroke;
    private int strokeColor;
    private int textHeight;
    private TypefaceSpec typefaceSpec;

    public TextArtStyle()
    {
        hasStroke = false;
        alignment = 19;
        typefaceSpec = new TypefaceSpec();
        reset();
    }

    public TextArtStyle(Parcel parcel)
    {
        hasStroke = false;
        alignment = 19;
        readFromParcel(parcel);
    }

    public static TextArtStyle getPreviewStyleObj(boolean flag, String s)
    {
        TextArtStyle textartstyle = new TextArtStyle();
        textartstyle.getTypefaceSpec().setFontPathFromSdCard(flag);
        textartstyle.getTypefaceSpec().setFontPath(s);
        return textartstyle;
    }

    private void readFromParcel(Parcel parcel)
    {
        boolean flag1 = true;
        typefaceSpec = (TypefaceSpec)parcel.readParcelable(com/socialin/android/photo/textart/TextArtStyle.getClassLoader());
        fontSize = parcel.readInt();
        boolean flag;
        if (parcel.readInt() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasGradient = flag;
        fillColor = parcel.readInt();
        fillGradientBottomColor = parcel.readInt();
        if (parcel.readInt() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        hasStroke = flag;
        strokeColor = parcel.readInt();
        alignment = parcel.readInt();
        textHeight = parcel.readInt();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof TextArtStyle))
        {
            return false;
        }
        obj = (TextArtStyle)obj;
        if (fillColor != ((TextArtStyle) (obj)).fillColor)
        {
            return false;
        }
        if (fillGradientBottomColor != ((TextArtStyle) (obj)).fillGradientBottomColor)
        {
            return false;
        }
        if (fontSize != ((TextArtStyle) (obj)).fontSize)
        {
            return false;
        }
        if (hasGradient != ((TextArtStyle) (obj)).hasGradient)
        {
            return false;
        }
        if (hasStroke != ((TextArtStyle) (obj)).hasStroke)
        {
            return false;
        }
        if (strokeColor != ((TextArtStyle) (obj)).strokeColor)
        {
            return false;
        }
        if (typefaceSpec != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((TextArtStyle) (obj)).typefaceSpec == null) goto _L1; else goto _L3
_L3:
        return false;
        if (typefaceSpec.equals(((TextArtStyle) (obj)).typefaceSpec)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int getAlignment()
    {
        return alignment;
    }

    public int getFillColor()
    {
        return fillColor;
    }

    public int getFillGradientBottomColor()
    {
        return fillGradientBottomColor;
    }

    public int getFontSize()
    {
        return fontSize;
    }

    public int getStrokeColor()
    {
        return strokeColor;
    }

    public int getTextHeight()
    {
        return textHeight;
    }

    public TypefaceSpec getTypefaceSpec()
    {
        if (typefaceSpec != null && typefaceSpec.getFontPath() != null)
        {
            typefaceSpec.setFontName((new File(typefaceSpec.getFontPath())).getName());
            return typefaceSpec;
        }
        if (typefaceSpec != null)
        {
            return typefaceSpec;
        } else
        {
            return new TypefaceSpec();
        }
    }

    public boolean hasGradient()
    {
        return hasGradient;
    }

    public boolean hasStroke()
    {
        return hasStroke;
    }

    public int hashCode()
    {
        char c1 = '\u04CF';
        int j = fillColor;
        int k = fillGradientBottomColor;
        int l = fontSize;
        char c;
        int i;
        int i1;
        if (hasGradient)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        if (!hasStroke)
        {
            c1 = '\u04D5';
        }
        i1 = strokeColor;
        if (typefaceSpec == null)
        {
            i = 0;
        } else
        {
            i = typefaceSpec.hashCode();
        }
        return i + (((c + (((j + 31) * 31 + k) * 31 + l) * 31) * 31 + c1) * 31 + i1) * 31;
    }

    public void reset()
    {
        fontSize = 30;
        hasGradient = false;
        fillColor = -1;
        fillGradientBottomColor = 0;
        hasStroke = false;
        strokeColor = 0;
    }

    public void setAlignment(int i)
    {
        alignment = i;
    }

    public void setFillColor(int i)
    {
        fillColor = i;
    }

    public void setFillGradientBottomColor(int i)
    {
        fillGradientBottomColor = i;
    }

    public void setFontSize(int i)
    {
        fontSize = i;
    }

    public void setHasGradient(boolean flag)
    {
        hasGradient = flag;
    }

    public void setHasStroke(boolean flag)
    {
        hasStroke = flag;
    }

    public void setStrokeColor(int i)
    {
        strokeColor = i;
    }

    public final void setTextArtStyle(TextArtStyle textartstyle)
    {
        typefaceSpec.setTypefaceSpec(textartstyle.getTypefaceSpec());
        fontSize = textartstyle.fontSize;
        hasGradient = textartstyle.hasGradient;
        fillColor = textartstyle.fillColor;
        fillGradientBottomColor = textartstyle.fillGradientBottomColor;
        hasStroke = textartstyle.hasStroke;
        strokeColor = textartstyle.strokeColor;
        alignment = textartstyle.alignment;
        textHeight = textartstyle.textHeight;
    }

    public void setTextHeight(int i)
    {
        textHeight = i;
    }

    public void setTypefaceSpec(TypefaceSpec typefacespec)
    {
        typefaceSpec = typefacespec;
    }

    public String toString()
    {
        return (new StringBuilder("TextArtStyle [typefaceSpec=")).append(typefaceSpec).append(", fontSize=").append(fontSize).append(", hasGradient=").append(hasGradient).append(", fillColor=").append(fillColor).append(", fillGradientBottomColor=").append(fillGradientBottomColor).append(", hasStroke=").append(hasStroke).append(", strokeColor=").append(strokeColor).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeParcelable(typefaceSpec, i);
        parcel.writeInt(fontSize);
        if (hasGradient)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(fillColor);
        parcel.writeInt(fillGradientBottomColor);
        if (hasStroke)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(strokeColor);
        parcel.writeInt(alignment);
        parcel.writeInt(textHeight);
    }

}
