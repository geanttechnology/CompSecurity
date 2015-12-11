// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Parcel;
import com.jumio.netverify.sdk.extraction.templatematcher.TemplateInfoWrapper;

public final class ji
    implements android.os.Parcelable.Creator
{

    public ji()
    {
    }

    public final TemplateInfoWrapper a(Parcel parcel)
    {
        return new TemplateInfoWrapper(parcel, null);
    }

    public final TemplateInfoWrapper[] a(int i)
    {
        return new TemplateInfoWrapper[i];
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return a(i);
    }
}
