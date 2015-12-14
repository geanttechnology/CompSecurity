// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import com.picsart.shop.a;
import com.socialin.android.util.FileUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

public class TypefaceSpec
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            return new TypefaceSpec(parcel);
        }

        public final volatile Object[] newArray(int i)
        {
            return new TypefaceSpec[i];
        }

    };
    private static final HashMap fontsCache = new HashMap();
    private static final long serialVersionUID = 0x3e0157438eebe721L;
    private String fontName;
    private String fontPackageName;
    private String fontPackagePath;
    private String fontPath;
    private boolean fontPathFromSdCard;

    public TypefaceSpec()
    {
    }

    public TypefaceSpec(Parcel parcel)
    {
        readFromParcel(parcel);
    }

    public TypefaceSpec(TypefaceSpec typefacespec)
    {
        if (typefacespec == null)
        {
            return;
        }
        fontPackageName = typefacespec.getFontPackageName();
        fontPackagePath = typefacespec.getFontPackagePath();
        fontPath = typefacespec.getFontPath();
        fontPathFromSdCard = typefacespec.isFontPathFromSdCard();
        if (fontPath != null && (typefacespec.getFontName() == null || typefacespec.getFontName() == ""))
        {
            fontName = (new File(fontPath)).getName();
            return;
        } else
        {
            fontName = typefacespec.getFontName();
            return;
        }
    }

    private static Typeface getShopFont(Context context, String s, String s1, String s2)
    {
        Object obj;
        String s3;
        boolean flag;
        flag = false;
        s3 = (new StringBuilder()).append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0808dc)).append("/").append(s).toString();
        obj = FileUtils.a(s3, s2);
        if (!((File) (obj)).exists()) goto _L2; else goto _L1
_L1:
        s = Typeface.createFromFile(((File) (obj)));
        flag = true;
_L4:
        obj = s;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        obj = s;
        try
        {
            s1 = a.a(context).a(s1, s2);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return ((Typeface) (obj));
        }
        obj = s;
        context = Typeface.createFromFile(FileUtils.a(s3, s2, s1));
        obj = context;
        s1.close();
        obj = context;
        return ((Typeface) (obj));
        s;
        ((File) (obj)).delete();
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Typeface getTypeFace(Context context, TypefaceSpec typefacespec)
    {
        Typeface typeface = null;
        if (typefacespec == null)
        {
            return null;
        }
        if (!fontsCache.containsKey(typefacespec))
        {
            boolean flag = typefacespec.isFontPathFromSdCard();
            String s1 = typefacespec.getFontPackagePath();
            String s2 = typefacespec.getFontPackageName();
            String s = typefacespec.getFontPath();
            if (flag)
            {
                typeface = getShopFont(context, s2, s1, s);
            } else
            if (s != null)
            {
                typeface = Typeface.createFromAsset(context.getAssets(), s);
            }
            context = typeface;
            if (typeface == null)
            {
                typeface = Typeface.DEFAULT;
                context = typeface;
                if (flag)
                {
                    try
                    {
                        context = Typeface.createFromFile(s);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        context = typeface;
                    }
                }
            }
            fontsCache.put(new TypefaceSpec(typefacespec), context);
        }
        return (Typeface)fontsCache.get(typefacespec);
    }

    private void readFromParcel(Parcel parcel)
    {
        boolean flag = true;
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        fontPathFromSdCard = flag;
        fontPath = parcel.readString();
        fontPackagePath = parcel.readString();
        fontPackageName = parcel.readString();
        fontName = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (!(obj instanceof TypefaceSpec))
            {
                return false;
            }
            obj = (TypefaceSpec)obj;
            if (fontPackageName == null)
            {
                if (((TypefaceSpec) (obj)).fontPackageName != null)
                {
                    return false;
                }
            } else
            if (!fontPackageName.equals(((TypefaceSpec) (obj)).fontPackageName))
            {
                return false;
            }
            if (fontPackagePath == null)
            {
                if (((TypefaceSpec) (obj)).fontPackagePath != null)
                {
                    return false;
                }
            } else
            if (!fontPackagePath.equals(((TypefaceSpec) (obj)).fontPackagePath))
            {
                return false;
            }
            if (fontPath == null)
            {
                if (((TypefaceSpec) (obj)).fontPath != null)
                {
                    return false;
                }
            } else
            if (!fontPath.equals(((TypefaceSpec) (obj)).fontPath))
            {
                return false;
            }
            if (fontPathFromSdCard != ((TypefaceSpec) (obj)).fontPathFromSdCard)
            {
                return false;
            }
        }
        return true;
    }

    public String getFontName()
    {
        return fontName;
    }

    public String getFontPackageName()
    {
        return fontPackageName;
    }

    public String getFontPackagePath()
    {
        return fontPackagePath;
    }

    public String getFontPath()
    {
        return fontPath;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        char c;
        if (fontPackageName == null)
        {
            i = 0;
        } else
        {
            i = fontPackageName.hashCode();
        }
        if (fontPackagePath == null)
        {
            j = 0;
        } else
        {
            j = fontPackagePath.hashCode();
        }
        if (fontPath != null)
        {
            k = fontPath.hashCode();
        }
        if (fontPathFromSdCard)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        return c + ((j + (i + 31) * 31) * 31 + k) * 31;
    }

    public boolean isFontPathFromSdCard()
    {
        return fontPathFromSdCard;
    }

    public void setFontName(String s)
    {
        fontName = s;
    }

    public void setFontPackageName(String s)
    {
        fontPackageName = s;
    }

    public void setFontPackagePath(String s)
    {
        fontPackagePath = s;
    }

    public void setFontPath(String s)
    {
        fontPath = s;
    }

    public void setFontPathFromSdCard(boolean flag)
    {
        fontPathFromSdCard = flag;
    }

    public void setTypefaceSpec(TypefaceSpec typefacespec)
    {
        fontPathFromSdCard = typefacespec.fontPathFromSdCard;
        fontPath = typefacespec.fontPath;
        fontPackagePath = typefacespec.fontPackagePath;
        fontPackageName = typefacespec.fontPackageName;
        if (fontPath != null)
        {
            typefacespec.setFontName((new File(fontPath)).getName());
        }
        fontName = typefacespec.fontName;
    }

    public String toString()
    {
        return (new StringBuilder("[fontPackageName=")).append(fontPackageName).append(", fontPackagePath=").append(fontPackagePath).append(", fontPath=").append(fontPath).append(", fontPathFromSdCard=").append(fontPathFromSdCard).append(", hash=").append(hashCode()).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (fontPathFromSdCard)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(fontPath);
        parcel.writeString(fontPackagePath);
        parcel.writeString(fontPackageName);
        parcel.writeString(fontName);
    }

}
