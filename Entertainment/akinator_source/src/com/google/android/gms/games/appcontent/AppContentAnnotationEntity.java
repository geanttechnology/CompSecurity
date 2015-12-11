// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.games.appcontent:
//            AppContentAnnotation, AppContentAnnotationEntityCreator

public final class AppContentAnnotationEntity
    implements SafeParcelable, AppContentAnnotation
{

    public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
    private final int mVersionCode;
    private final String zzajf;
    private final String zzaqZ;
    private final Uri zzauG;
    private final String zzauH;
    private final String zzauI;
    private final int zzauJ;
    private final int zzauK;
    private final Bundle zzauL;
    private final String zzwN;

    AppContentAnnotationEntity(int i, String s, Uri uri, String s1, String s2, String s3, String s4, 
            int j, int k, Bundle bundle)
    {
        mVersionCode = i;
        zzaqZ = s;
        zzwN = s2;
        zzauI = s4;
        zzauJ = j;
        zzauG = uri;
        zzauK = k;
        zzauH = s3;
        zzauL = bundle;
        zzajf = s1;
    }

    public AppContentAnnotationEntity(AppContentAnnotation appcontentannotation)
    {
        mVersionCode = 4;
        zzaqZ = appcontentannotation.getDescription();
        zzwN = appcontentannotation.getId();
        zzauI = appcontentannotation.zztT();
        zzauJ = appcontentannotation.zztU();
        zzauG = appcontentannotation.zztV();
        zzauK = appcontentannotation.zztX();
        zzauH = appcontentannotation.zztY();
        zzauL = appcontentannotation.zztW();
        zzajf = appcontentannotation.getTitle();
    }

    static int zza(AppContentAnnotation appcontentannotation)
    {
        return zzw.hashCode(new Object[] {
            appcontentannotation.getDescription(), appcontentannotation.getId(), appcontentannotation.zztT(), Integer.valueOf(appcontentannotation.zztU()), appcontentannotation.zztV(), Integer.valueOf(appcontentannotation.zztX()), appcontentannotation.zztY(), appcontentannotation.zztW(), appcontentannotation.getTitle()
        });
    }

    static boolean zza(AppContentAnnotation appcontentannotation, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof AppContentAnnotation) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (appcontentannotation == obj) goto _L4; else goto _L3
_L3:
        obj = (AppContentAnnotation)obj;
        if (!zzw.equal(((AppContentAnnotation) (obj)).getDescription(), appcontentannotation.getDescription()) || !zzw.equal(((AppContentAnnotation) (obj)).getId(), appcontentannotation.getId()) || !zzw.equal(((AppContentAnnotation) (obj)).zztT(), appcontentannotation.zztT()) || !zzw.equal(Integer.valueOf(((AppContentAnnotation) (obj)).zztU()), Integer.valueOf(appcontentannotation.zztU())) || !zzw.equal(((AppContentAnnotation) (obj)).zztV(), appcontentannotation.zztV()) || !zzw.equal(Integer.valueOf(((AppContentAnnotation) (obj)).zztX()), Integer.valueOf(appcontentannotation.zztX())) || !zzw.equal(((AppContentAnnotation) (obj)).zztY(), appcontentannotation.zztY()) || !zzw.equal(((AppContentAnnotation) (obj)).zztW(), appcontentannotation.zztW()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((AppContentAnnotation) (obj)).getTitle(), appcontentannotation.getTitle())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(AppContentAnnotation appcontentannotation)
    {
        return zzw.zzv(appcontentannotation).zzg("Description", appcontentannotation.getDescription()).zzg("Id", appcontentannotation.getId()).zzg("ImageDefaultId", appcontentannotation.zztT()).zzg("ImageHeight", Integer.valueOf(appcontentannotation.zztU())).zzg("ImageUri", appcontentannotation.zztV()).zzg("ImageWidth", Integer.valueOf(appcontentannotation.zztX())).zzg("LayoutSlot", appcontentannotation.zztY()).zzg("Modifiers", appcontentannotation.zztW()).zzg("Title", appcontentannotation.getTitle()).toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Object freeze()
    {
        return zztZ();
    }

    public String getDescription()
    {
        return zzaqZ;
    }

    public String getId()
    {
        return zzwN;
    }

    public String getTitle()
    {
        return zzajf;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zza(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        AppContentAnnotationEntityCreator.zza(this, parcel, i);
    }

    public String zztT()
    {
        return zzauI;
    }

    public int zztU()
    {
        return zzauJ;
    }

    public Uri zztV()
    {
        return zzauG;
    }

    public Bundle zztW()
    {
        return zzauL;
    }

    public int zztX()
    {
        return zzauK;
    }

    public String zztY()
    {
        return zzauH;
    }

    public AppContentAnnotation zztZ()
    {
        return this;
    }

}
