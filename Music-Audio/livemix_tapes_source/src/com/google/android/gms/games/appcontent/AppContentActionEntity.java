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
    private final String zzFz;
    private final ArrayList zzase;
    private final String zzasf;
    private final AppContentAnnotationEntity zzasg;
    private final String zzash;
    private final String zzwj;

    AppContentActionEntity(int i, ArrayList arraylist, String s, Bundle bundle, String s1, String s2, AppContentAnnotationEntity appcontentannotationentity, 
            String s3)
    {
        mVersionCode = i;
        zzasg = appcontentannotationentity;
        zzase = arraylist;
        zzasf = s;
        mExtras = bundle;
        zzwj = s2;
        zzash = s3;
        zzFz = s1;
    }

    public AppContentActionEntity(AppContentAction appcontentaction)
    {
        mVersionCode = 5;
        zzasg = (AppContentAnnotationEntity)appcontentaction.zzsZ().freeze();
        zzasf = appcontentaction.zztb();
        mExtras = appcontentaction.getExtras();
        zzwj = appcontentaction.getId();
        zzash = appcontentaction.zztc();
        zzFz = appcontentaction.getType();
        appcontentaction = appcontentaction.zzta();
        int j = appcontentaction.size();
        zzase = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            zzase.add((AppContentConditionEntity)(AppContentConditionEntity)((AppContentCondition)appcontentaction.get(i)).freeze());
        }

    }

    static int zza(AppContentAction appcontentaction)
    {
        return zzw.hashCode(new Object[] {
            appcontentaction.zzsZ(), appcontentaction.zzta(), appcontentaction.zztb(), appcontentaction.getExtras(), appcontentaction.getId(), appcontentaction.zztc(), appcontentaction.getType()
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
        if (!zzw.equal(((AppContentAction) (obj)).zzsZ(), appcontentaction.zzsZ()) || !zzw.equal(((AppContentAction) (obj)).zzta(), appcontentaction.zzta()) || !zzw.equal(((AppContentAction) (obj)).zztb(), appcontentaction.zztb()) || !zzw.equal(((AppContentAction) (obj)).getExtras(), appcontentaction.getExtras()) || !zzw.equal(((AppContentAction) (obj)).getId(), appcontentaction.getId()) || !zzw.equal(((AppContentAction) (obj)).zztc(), appcontentaction.zztc()))
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
        return zzw.zzu(appcontentaction).zzg("Annotation", appcontentaction.zzsZ()).zzg("Conditions", appcontentaction.zzta()).zzg("ContentDescription", appcontentaction.zztb()).zzg("Extras", appcontentaction.getExtras()).zzg("Id", appcontentaction.getId()).zzg("OverflowText", appcontentaction.zztc()).zzg("Type", appcontentaction.getType()).toString();
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
        return zztd();
    }

    public Bundle getExtras()
    {
        return mExtras;
    }

    public String getId()
    {
        return zzwj;
    }

    public String getType()
    {
        return zzFz;
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

    public AppContentAnnotation zzsZ()
    {
        return zzasg;
    }

    public List zzta()
    {
        return new ArrayList(zzase);
    }

    public String zztb()
    {
        return zzasf;
    }

    public String zztc()
    {
        return zzash;
    }

    public AppContentAction zztd()
    {
        return this;
    }

}
