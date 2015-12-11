// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.base;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class Text
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Text createFromParcel(Parcel parcel)
        {
            return new Text(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Text[] newArray(int i)
        {
            return new Text[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final int HASH_PRIME = 31;
    public String content;
    public String language;
    public String translatedFromContent;
    public String translatedFromLanguage;

    protected Text(Parcel parcel)
    {
        if (parcel != null)
        {
            content = parcel.readString();
            language = parcel.readString();
            translatedFromContent = parcel.readString();
            translatedFromLanguage = parcel.readString();
        }
    }

    public Text(String s)
    {
        content = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof Text))
            {
                return false;
            }
            obj = (Text)obj;
            if (!TextUtils.equals(content, ((Text) (obj)).content))
            {
                return false;
            }
            if (!TextUtils.equals(language, ((Text) (obj)).language))
            {
                return false;
            }
            if (!TextUtils.equals(translatedFromContent, ((Text) (obj)).translatedFromContent))
            {
                return false;
            }
            if (!TextUtils.equals(translatedFromLanguage, ((Text) (obj)).translatedFromLanguage))
            {
                return false;
            }
        }
        return true;
    }

    public String getText(boolean flag)
    {
        if (!flag && !TextUtils.isEmpty(translatedFromContent))
        {
            return translatedFromContent;
        } else
        {
            return content;
        }
    }

    boolean hasTranslatedText()
    {
        return !TextUtils.isEmpty(translatedFromContent);
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (content != null)
        {
            i = content.hashCode();
        } else
        {
            i = 0;
        }
        if (language != null)
        {
            j = language.hashCode();
        } else
        {
            j = 0;
        }
        if (translatedFromContent != null)
        {
            k = translatedFromContent.hashCode();
        } else
        {
            k = 0;
        }
        if (translatedFromLanguage != null)
        {
            l = translatedFromLanguage.hashCode();
        }
        return ((i * 31 + j) * 31 + k) * 31 + l;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(content);
        parcel.writeString(language);
        parcel.writeString(translatedFromContent);
        parcel.writeString(translatedFromLanguage);
    }

}
