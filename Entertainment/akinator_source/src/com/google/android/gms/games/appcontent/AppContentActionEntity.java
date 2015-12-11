// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.games.appcontent:
//            AppContentAction, AppContentActionEntityCreator, AppContentAnnotation, AppContentAnnotationEntity, 
//            AppContentCondition, AppContentConditionEntity

public final class AppContentActionEntity
    implements SafeParcelable, AppContentAction
{

    public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzGq;
    private final ArrayList zzauC;
    private final String zzauD;
    private final AppContentAnnotationEntity zzauE;
    private final String zzauF;
    private final String zzwN;

    AppContentActionEntity(int i, ArrayList arraylist, String s, Bundle bundle, String s1, String s2, AppContentAnnotationEntity appcontentannotationentity, 
            String s3)
    {
        mVersionCode = i;
        zzauE = appcontentannotationentity;
        zzauC = arraylist;
        zzauD = s;
        mExtras = bundle;
        zzwN = s2;
        zzauF = s3;
        zzGq = s1;
    }

    public AppContentActionEntity(AppContentAction appcontentaction)
    {
        mVersionCode = 5;
        zzauE = (AppContentAnnotationEntity)appcontentaction.zztO().freeze();
        zzauD = appcontentaction.zztQ();
        mExtras = appcontentaction.getExtras();
        zzwN = appcontentaction.getId();
        zzauF = appcontentaction.zztR();
        zzGq = appcontentaction.getType();
        appcontentaction = appcontentaction.zztP();
        int j = appcontentaction.size();
        zzauC = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            zzauC.add((AppContentConditionEntity)(AppContentConditionEntity)((AppContentCondition)appcontentaction.get(i)).freeze());
        }

    }

    static int zza(AppContentAction appcontentaction)
    {
        return zzw.hashCode(new Object[] {
            appcontentaction.zztO(), appcontentaction.zztP(), appcontentaction.zztQ(), appcontentaction.getExtras(), appcontentaction.getId(), appcontentaction.zztR(), appcontentaction.getType()
        });
    }

    static boolean zza(AppContentAction appcontentaction, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof AppContentAction) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (appcontentaction == obj) goto _L4; else goto _L3
_L3:
        obj = (AppContentAction)obj;
        if (!zzw.equal(((AppContentAction) (obj)).zztO(), appcontentaction.zztO()) || !zzw.equal(((AppContentAction) (obj)).zztP(), appcontentaction.zztP()) || !zzw.equal(((AppContentAction) (obj)).zztQ(), appcontentaction.zztQ()) || !zzw.equal(((AppContentAction) (obj)).getExtras(), appcontentaction.getExtras()) || !zzw.equal(((AppContentAction) (obj)).getId(), appcontentaction.getId()) || !zzw.equal(((AppContentAction) (obj)).zztR(), appcontentaction.zztR()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((AppContentAction) (obj)).getType(), appcontentaction.getType())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(AppContentAction appcontentaction)
    {
        return zzw.zzv(appcontentaction).zzg("Annotation", appcontentaction.zztO()).zzg("Conditions", appcontentaction.zztP()).zzg("ContentDescription", appcontentaction.zztQ()).zzg("Extras", appcontentaction.getExtras()).zzg("Id", appcontentaction.getId()).zzg("OverflowText", appcontentaction.zztR()).zzg("Type", appcontentaction.getType()).toString();
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
        return zztS();
    }

    public Bundle getExtras()
    {
        return mExtras;
    }

    public String getId()
    {
        return zzwN;
    }

    public String getType()
    {
        return zzGq;
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
        AppContentActionEntityCreator.zza(this, parcel, i);
    }

    public AppContentAnnotation zztO()
    {
        return zzauE;
    }

    public List zztP()
    {
        return new ArrayList(zzauC);
    }

    public String zztQ()
    {
        return zzauD;
    }

    public String zztR()
    {
        return zzauF;
    }

    public AppContentAction zztS()
    {
        return this;
    }

}
