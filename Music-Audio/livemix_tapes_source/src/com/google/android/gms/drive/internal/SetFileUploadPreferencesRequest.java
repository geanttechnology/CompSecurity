// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzbp, FileUploadPreferencesImpl

public class SetFileUploadPreferencesRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzbp();
    final int mVersionCode;
    final FileUploadPreferencesImpl zzajJ;

    SetFileUploadPreferencesRequest(int i, FileUploadPreferencesImpl fileuploadpreferencesimpl)
    {
        mVersionCode = i;
        zzajJ = fileuploadpreferencesimpl;
    }

    public SetFileUploadPreferencesRequest(FileUploadPreferencesImpl fileuploadpreferencesimpl)
    {
        this(1, fileuploadpreferencesimpl);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzbp.zza(this, parcel, i);
    }

}
