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
    private final String zzagU;
    private final String zzaoB;
    private final Uri zzasi;
    private final String zzasj;
    private final String zzask;
    private final int zzasl;
    private final int zzasm;
    private final Bundle zzasn;
    private final String zzwj;

    AppContentAnnotationEntity(int i, String s, Uri uri, String s1, String s2, String s3, String s4, 
            int j, int k, Bundle bundle)
    {
        mVersionCode = i;
        zzaoB = s;
        zzwj = s2;
        zzask = s4;
        zzasl = j;
        zzasi = uri;
        zzasm = k;
        zzasj = s3;
        zzasn = bundle;
        zzagU = s1;
    }

    public AppContentAnnotationEntity(AppContentAnnotation appcontentannotation)
    {
        mVersionCode = 4;
        zzaoB = appcontentannotation.getDescription();
        zzwj = appcontentannotation.getId();
        zzask = appcontentannotation.zzte();
        zzasl = appcontentannotation.zztf();
        zzasi = appcontentannotation.zztg();
        zzasm = appcontentannotation.zzti();
        zzasj = appcontentannotation.zztj();
        zzasn = appcontentannotation.zzth();
        zzagU = appcontentannotation.getTitle();
    }

    static int zza(AppContentAnnotation appcontentannotation)
    {
        return zzw.hashCode(new Object[] {
            appcontentannotation.getDescription(), appcontentannotation.getId(), appcontentannotation.zzte(), Integer.valueOf(appcontentannotation.zztf()), appcontentannotation.zztg(), Integer.valueOf(appcontentannotation.zzti()), appcontentannotation.zztj(), appcontentannotation.zzth(), appcontentannotation.getTitle()
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
        if (!zzw.equal(((AppContentAnnotation) (obj)).getDescription(), appcontentannotation.getDescription()) || !zzw.equal(((AppContentAnnotation) (obj)).getId(), appcontentannotation.getId()) || !zzw.equal(((AppContentAnnotation) (obj)).zzte(), appcontentannotation.zzte()) || !zzw.equal(Integer.valueOf(((AppContentAnnotation) (obj)).zztf()), Integer.valueOf(appcontentannotation.zztf())) || !zzw.equal(((AppContentAnnotation) (obj)).zztg(), appcontentannotation.zztg()) || !zzw.equal(Integer.valueOf(((AppContentAnnotation) (obj)).zzti()), Integer.valueOf(appcontentannotation.zzti())) || !zzw.equal(((AppContentAnnotation) (obj)).zztj(), appcontentannotation.zztj()) || !zzw.equal(((AppContentAnnotation) (obj)).zzth(), appcontentannotation.zzth()))
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
        return zzw.zzu(appcontentannotation).zzg("Description", appcontentannotation.getDescription()).zzg("Id", appcontentannotation.getId()).zzg("ImageDefaultId", appcontentannotation.zzte()).zzg("ImageHeight", Integer.valueOf(appcontentannotation.zztf())).zzg("ImageUri", appcontentannotation.zztg()).zzg("ImageWidth", Integer.valueOf(appcontentannotation.zzti())).zzg("LayoutSlot", appcontentannotation.zztj()).zzg("Modifiers", appcontentannotation.zzth()).zzg("Title", appcontentannotation.getTitle()).toString();
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
        return zztk();
    }

    public String getDescription()
    {
        return zzaoB;
    }

    public String getId()
    {
        return zzwj;
    }

    public String getTitle()
    {
        return zzagU;
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

    public String zzte()
    {
        return zzask;
    }

    public int zztf()
    {
        return zzasl;
    }

    public Uri zztg()
    {
        return zzasi;
    }

    public Bundle zzth()
    {
        return zzasn;
    }

    public int zzti()
    {
        return zzasm;
    }

    public String zztj()
    {
        return zzasj;
    }

    public AppContentAnnotation zztk()
    {
        return this;
    }

}
