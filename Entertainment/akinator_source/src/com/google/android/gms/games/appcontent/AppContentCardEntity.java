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
//            AppContentCard, AppContentCardEntityCreator, AppContentAction, AppContentActionEntity, 
//            AppContentAnnotation, AppContentAnnotationEntity, AppContentCondition, AppContentConditionEntity

public final class AppContentCardEntity
    implements SafeParcelable, AppContentCard
{

    public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
    private final ArrayList mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzGq;
    private final String zzajf;
    private final String zzaqZ;
    private final ArrayList zzauC;
    private final String zzauD;
    private final ArrayList zzauM;
    private final int zzauN;
    private final String zzauO;
    private final int zzauP;
    private final String zzwN;

    AppContentCardEntity(int i, ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2, String s, int j, String s1, 
            Bundle bundle, String s2, String s3, int k, String s4, String s5)
    {
        mVersionCode = i;
        mActions = arraylist;
        zzauM = arraylist1;
        zzauC = arraylist2;
        zzauD = s;
        zzauN = j;
        zzaqZ = s1;
        mExtras = bundle;
        zzwN = s5;
        zzauO = s2;
        zzajf = s3;
        zzauP = k;
        zzGq = s4;
    }

    public AppContentCardEntity(AppContentCard appcontentcard)
    {
        boolean flag = false;
        super();
        mVersionCode = 4;
        zzauD = appcontentcard.zztQ();
        zzauN = appcontentcard.zzub();
        zzaqZ = appcontentcard.getDescription();
        mExtras = appcontentcard.getExtras();
        zzwN = appcontentcard.getId();
        zzajf = appcontentcard.getTitle();
        zzauO = appcontentcard.zzuc();
        zzauP = appcontentcard.zzud();
        zzGq = appcontentcard.getType();
        List list = appcontentcard.getActions();
        int l = list.size();
        mActions = new ArrayList(l);
        for (int i = 0; i < l; i++)
        {
            mActions.add((AppContentActionEntity)(AppContentActionEntity)((AppContentAction)list.get(i)).freeze());
        }

        list = appcontentcard.zzua();
        l = list.size();
        zzauM = new ArrayList(l);
        for (int j = 0; j < l; j++)
        {
            zzauM.add((AppContentAnnotationEntity)(AppContentAnnotationEntity)((AppContentAnnotation)list.get(j)).freeze());
        }

        appcontentcard = appcontentcard.zztP();
        l = appcontentcard.size();
        zzauC = new ArrayList(l);
        for (int k = ((flag) ? 1 : 0); k < l; k++)
        {
            zzauC.add((AppContentConditionEntity)(AppContentConditionEntity)((AppContentCondition)appcontentcard.get(k)).freeze());
        }

    }

    static int zza(AppContentCard appcontentcard)
    {
        return zzw.hashCode(new Object[] {
            appcontentcard.getActions(), appcontentcard.zzua(), appcontentcard.zztP(), appcontentcard.zztQ(), Integer.valueOf(appcontentcard.zzub()), appcontentcard.getDescription(), appcontentcard.getExtras(), appcontentcard.getId(), appcontentcard.zzuc(), appcontentcard.getTitle(), 
            Integer.valueOf(appcontentcard.zzud()), appcontentcard.getType()
        });
    }

    static boolean zza(AppContentCard appcontentcard, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof AppContentCard) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (appcontentcard == obj) goto _L4; else goto _L3
_L3:
        obj = (AppContentCard)obj;
        if (!zzw.equal(((AppContentCard) (obj)).getActions(), appcontentcard.getActions()) || !zzw.equal(((AppContentCard) (obj)).zzua(), appcontentcard.zzua()) || !zzw.equal(((AppContentCard) (obj)).zztP(), appcontentcard.zztP()) || !zzw.equal(((AppContentCard) (obj)).zztQ(), appcontentcard.zztQ()) || !zzw.equal(Integer.valueOf(((AppContentCard) (obj)).zzub()), Integer.valueOf(appcontentcard.zzub())) || !zzw.equal(((AppContentCard) (obj)).getDescription(), appcontentcard.getDescription()) || !zzw.equal(((AppContentCard) (obj)).getExtras(), appcontentcard.getExtras()) || !zzw.equal(((AppContentCard) (obj)).getId(), appcontentcard.getId()) || !zzw.equal(((AppContentCard) (obj)).zzuc(), appcontentcard.zzuc()) || !zzw.equal(((AppContentCard) (obj)).getTitle(), appcontentcard.getTitle()) || !zzw.equal(Integer.valueOf(((AppContentCard) (obj)).zzud()), Integer.valueOf(appcontentcard.zzud())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((AppContentCard) (obj)).getType(), appcontentcard.getType())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(AppContentCard appcontentcard)
    {
        return zzw.zzv(appcontentcard).zzg("Actions", appcontentcard.getActions()).zzg("Annotations", appcontentcard.zzua()).zzg("Conditions", appcontentcard.zztP()).zzg("ContentDescription", appcontentcard.zztQ()).zzg("CurrentSteps", Integer.valueOf(appcontentcard.zzub())).zzg("Description", appcontentcard.getDescription()).zzg("Extras", appcontentcard.getExtras()).zzg("Id", appcontentcard.getId()).zzg("Subtitle", appcontentcard.zzuc()).zzg("Title", appcontentcard.getTitle()).zzg("TotalSteps", Integer.valueOf(appcontentcard.zzud())).zzg("Type", appcontentcard.getType()).toString();
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
        return zzue();
    }

    public List getActions()
    {
        return new ArrayList(mActions);
    }

    public String getDescription()
    {
        return zzaqZ;
    }

    public Bundle getExtras()
    {
        return mExtras;
    }

    public String getId()
    {
        return zzwN;
    }

    public String getTitle()
    {
        return zzajf;
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
        AppContentCardEntityCreator.zza(this, parcel, i);
    }

    public List zztP()
    {
        return new ArrayList(zzauC);
    }

    public String zztQ()
    {
        return zzauD;
    }

    public List zzua()
    {
        return new ArrayList(zzauM);
    }

    public int zzub()
    {
        return zzauN;
    }

    public String zzuc()
    {
        return zzauO;
    }

    public int zzud()
    {
        return zzauP;
    }

    public AppContentCard zzue()
    {
        return this;
    }

}
