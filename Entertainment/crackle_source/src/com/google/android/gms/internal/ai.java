// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            aj

public final class ai
    implements SafeParcelable
{

    public static final aj CREATOR = new aj();
    public final int backgroundColor;
    public final int eZ;
    public final int fa;
    public final int fb;
    public final int fc;
    public final int fd;
    public final int fe;
    public final int ff;
    public final String fg;
    public final int fh;
    public final String fi;
    public final int fj;
    public final int fk;
    public final String fl;
    public final int versionCode;

    ai(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, String s, int j2, String s1, int k2, int l2, 
            String s2)
    {
        versionCode = i;
        eZ = j;
        backgroundColor = k;
        fa = l;
        fb = i1;
        fc = j1;
        fd = k1;
        fe = l1;
        ff = i2;
        fg = s;
        fh = j2;
        fi = s1;
        fj = k2;
        fk = l2;
        fl = s2;
    }

    public ai(SearchAdRequest searchadrequest)
    {
        versionCode = 1;
        eZ = searchadrequest.getAnchorTextColor();
        backgroundColor = searchadrequest.getBackgroundColor();
        fa = searchadrequest.getBackgroundGradientBottom();
        fb = searchadrequest.getBackgroundGradientTop();
        fc = searchadrequest.getBorderColor();
        fd = searchadrequest.getBorderThickness();
        fe = searchadrequest.getBorderType();
        ff = searchadrequest.getCallButtonColor();
        fg = searchadrequest.getCustomChannels();
        fh = searchadrequest.getDescriptionTextColor();
        fi = searchadrequest.getFontFace();
        fj = searchadrequest.getHeaderTextColor();
        fk = searchadrequest.getHeaderTextSize();
        fl = searchadrequest.getQuery();
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        aj.a(this, parcel, i);
    }

}
