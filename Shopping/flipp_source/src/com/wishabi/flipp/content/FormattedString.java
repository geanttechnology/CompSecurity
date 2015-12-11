// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

// Referenced classes of package com.wishabi.flipp.content:
//            y, z

public class FormattedString
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new y();
    private final Part a[];
    private Spannable b;

    private FormattedString(Parcel parcel)
    {
        a = (Part[])parcel.createTypedArray(Part.CREATOR);
        b = null;
    }

    FormattedString(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    public transient FormattedString(Part apart[])
    {
        a = apart;
        b = null;
    }

    public final Spannable a()
    {
        SpannableStringBuilder spannablestringbuilder;
        Part apart[];
        int i;
        int k;
        if (b != null)
        {
            return b;
        }
        spannablestringbuilder = new SpannableStringBuilder();
        apart = a;
        k = apart.length;
        i = 0;
_L11:
        Format aformat[];
        int j;
        int l;
        int i1;
        int j1;
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        Part part = apart[i];
        l = spannablestringbuilder.length();
        spannablestringbuilder.append(part.a);
        i1 = spannablestringbuilder.length();
        aformat = part.b;
        j1 = aformat.length;
        j = 0;
_L8:
        Format format;
        if (j >= j1)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        format = aformat[j];
        z.a[format.a - 1];
        JVM INSTR tableswitch 1 5: default 136
    //                   1 145
    //                   2 166
    //                   3 187
    //                   4 212
    //                   5 237;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_237;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L9:
        j++;
        if (true) goto _L8; else goto _L7
_L7:
        spannablestringbuilder.setSpan(new StyleSpan(1), l, i1, 33);
          goto _L9
_L3:
        spannablestringbuilder.setSpan(new StyleSpan(2), l, i1, 33);
          goto _L9
_L4:
        spannablestringbuilder.setSpan(new ForegroundColorSpan(format.b), l, i1, 33);
          goto _L9
_L5:
        spannablestringbuilder.setSpan(new BackgroundColorSpan(format.b), l, i1, 33);
          goto _L9
        spannablestringbuilder.setSpan(new RelativeSizeSpan(format.c), l, i1, 33);
          goto _L9
        i++;
        if (true) goto _L11; else goto _L10
_L10:
        b = spannablestringbuilder;
        return b;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeTypedArray(a, i);
    }


    private class Part
        implements Parcelable
    {
        private class Format
            implements Parcelable
        {

            public static final android.os.Parcelable.Creator CREATOR = new aa();
            final int a;
            final int b;
            final float c;

            public int describeContents()
            {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i)
            {
                parcel.writeInt(a - 1);
                parcel.writeInt(b);
                parcel.writeFloat(c);
            }


            public Format(int i)
            {
                this(i, (byte)0);
            }

            private Format(int i, byte byte0)
            {
                byte0 = i;
                if (i == 0)
                {
                    byte0 = ab.a;
                }
                a = byte0;
                b = -1;
                c = -1F;
            }

            private Format(Parcel parcel)
            {
                a = ab.a()[parcel.readInt()];
                b = parcel.readInt();
                c = parcel.readFloat();
            }

            Format(Parcel parcel, byte byte0)
            {
                this(parcel);
            }
        }


        public static final android.os.Parcelable.Creator CREATOR = new ac();
        final String a;
        final Format b[];

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(a);
            parcel.writeTypedArray(b, i);
        }


        private Part(Parcel parcel)
        {
            a = parcel.readString();
            b = (Format[])parcel.createTypedArray(Format.CREATOR);
        }

        Part(Parcel parcel, byte byte0)
        {
            this(parcel);
        }

        public transient Part(String s, Format aformat[])
        {
            a = s;
            b = aformat;
        }
    }

}
