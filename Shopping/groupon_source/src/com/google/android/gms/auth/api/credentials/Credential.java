// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.auth.api.credentials:
//            zza

public class Credential
    implements SafeParcelable
{
    public static class Builder
    {

        private String mName;
        private final String zzKI;
        private String zzOS;
        private String zzOT;
        private Uri zzOU;
        private List zzOV;
        private String zzOW;
        private String zzOX;

        public Credential build()
        {
            if (!TextUtils.isEmpty(zzOW) && !TextUtils.isEmpty(zzOX))
            {
                throw new IllegalStateException("Only one of password or accountType may be set");
            } else
            {
                return new Credential(1, zzOS, zzOT, zzKI, mName, zzOU, zzOV, zzOW, zzOX);
            }
        }

        public Builder setName(String s)
        {
            mName = s;
            return this;
        }

        public Builder setPassword(String s)
        {
            zzOW = s;
            return this;
        }

        public Builder(String s)
        {
            zzKI = s;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new zza();
    private final String mName;
    final int zzCY;
    private final String zzKI;
    private final String zzOS;
    private final String zzOT;
    private final Uri zzOU;
    private final List zzOV;
    private final String zzOW;
    private final String zzOX;

    Credential(int i, String s, String s1, String s2, String s3, Uri uri, List list, 
            String s4, String s5)
    {
        zzCY = i;
        zzOS = s;
        zzOT = s1;
        zzKI = (String)zzu.zzu(s2);
        mName = s3;
        zzOU = uri;
        if (list == null)
        {
            s = Collections.emptyList();
        } else
        {
            s = Collections.unmodifiableList(list);
        }
        zzOV = s;
        zzOW = s4;
        zzOX = s5;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAccountType()
    {
        return zzOX;
    }

    public String getId()
    {
        return zzKI;
    }

    public String getName()
    {
        return mName;
    }

    public String getPassword()
    {
        return zzOW;
    }

    public Uri getProfilePictureUri()
    {
        return zzOU;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zza.zza(this, parcel, i);
    }

    public String zzkZ()
    {
        return zzOS;
    }

    public String zzla()
    {
        return zzOT;
    }

    public List zzlb()
    {
        return zzOV;
    }

}
