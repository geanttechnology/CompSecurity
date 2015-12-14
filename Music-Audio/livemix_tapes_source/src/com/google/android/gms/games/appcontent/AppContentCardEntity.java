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
    private final String zzFz;
    private final String zzagU;
    private final String zzaoB;
    private final ArrayList zzase;
    private final String zzasf;
    private final ArrayList zzaso;
    private final int zzasp;
    private final String zzasq;
    private final int zzasr;
    private final String zzwj;

    AppContentCardEntity(int i, ArrayList arraylist, ArrayList arraylist1, ArrayList arraylist2, String s, int j, String s1, 
            Bundle bundle, String s2, String s3, int k, String s4, String s5)
    {
        mVersionCode = i;
        mActions = arraylist;
        zzaso = arraylist1;
        zzase = arraylist2;
        zzasf = s;
        zzasp = j;
        zzaoB = s1;
        mExtras = bundle;
        zzwj = s5;
        zzasq = s2;
        zzagU = s3;
        zzasr = k;
        zzFz = s4;
    }

    public AppContentCardEntity(AppContentCard appcontentcard)
    {
        boolean flag = false;
        super();
        mVersionCode = 4;
        zzasf = appcontentcard.zztb();
        zzasp = appcontentcard.zztm();
        zzaoB = appcontentcard.getDescription();
        mExtras = appcontentcard.getExtras();
        zzwj = appcontentcard.getId();
        zzagU = appcontentcard.getTitle();
        zzasq = appcontentcard.zztn();
        zzasr = appcontentcard.zzto();
        zzFz = appcontentcard.getType();
        List list = appcontentcard.getActions();
        int l = list.size();
        mActions = new ArrayList(l);
        for (int i = 0; i < l; i++)
        {
            mActions.add((AppContentActionEntity)(AppContentActionEntity)((AppContentAction)list.get(i)).freeze());
        }

        list = appcontentcard.zztl();
        l = list.size();
        zzaso = new ArrayList(l);
        for (int j = 0; j < l; j++)
        {
            zzaso.add((AppContentAnnotationEntity)(AppContentAnnotationEntity)((AppContentAnnotation)list.get(j)).freeze());
        }

        appcontentcard = appcontentcard.zzta();
        l = appcontentcard.size();
        zzase = new ArrayList(l);
        for (int k = ((flag) ? 1 : 0); k < l; k++)
        {
            zzase.add((AppContentConditionEntity)(AppContentConditionEntity)((AppContentCondition)appcontentcard.get(k)).freeze());
        }

    }

    static int zza(AppContentCard appcontentcard)
    {
        return zzw.hashCode(new Object[] {
            appcontentcard.getActions(), appcontentcard.zztl(), appcontentcard.zzta(), appcontentcard.zztb(), Integer.valueOf(appcontentcard.zztm()), appcontentcard.getDescription(), appcontentcard.getExtras(), appcontentcard.getId(), appcontentcard.zztn(), appcontentcard.getTitle(), 
            Integer.valueOf(appcontentcard.zzto()), appcontentcard.getType()
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
        if (!zzw.equal(((AppContentCard) (obj)).getActions(), appcontentcard.getActions()) || !zzw.equal(((AppContentCard) (obj)).zztl(), appcontentcard.zztl()) || !zzw.equal(((AppContentCard) (obj)).zzta(), appcontentcard.zzta()) || !zzw.equal(((AppContentCard) (obj)).zztb(), appcontentcard.zztb()) || !zzw.equal(Integer.valueOf(((AppContentCard) (obj)).zztm()), Integer.valueOf(appcontentcard.zztm())) || !zzw.equal(((AppContentCard) (obj)).getDescription(), appcontentcard.getDescription()) || !zzw.equal(((AppContentCard) (obj)).getExtras(), appcontentcard.getExtras()) || !zzw.equal(((AppContentCard) (obj)).getId(), appcontentcard.getId()) || !zzw.equal(((AppContentCard) (obj)).zztn(), appcontentcard.zztn()) || !zzw.equal(((AppContentCard) (obj)).getTitle(), appcontentcard.getTitle()) || !zzw.equal(Integer.valueOf(((AppContentCard) (obj)).zzto()), Integer.valueOf(appcontentcard.zzto())))
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
        return zzw.zzu(appcontentcard).zzg("Actions", appcontentcard.getActions()).zzg("Annotations", appcontentcard.zztl()).zzg("Conditions", appcontentcard.zzta()).zzg("ContentDescription", appcontentcard.zztb()).zzg("CurrentSteps", Integer.valueOf(appcontentcard.zztm())).zzg("Description", appcontentcard.getDescription()).zzg("Extras", appcontentcard.getExtras()).zzg("Id", appcontentcard.getId()).zzg("Subtitle", appcontentcard.zztn()).zzg("Title", appcontentcard.getTitle()).zzg("TotalSteps", Integer.valueOf(appcontentcard.zzto())).zzg("Type", appcontentcard.getType()).toString();
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
        return zztp();
    }

    public List getActions()
    {
        return new ArrayList(mActions);
    }

    public String getDescription()
    {
        return zzaoB;
    }

    public Bundle getExtras()
    {
        return mExtras;
    }

    public String getId()
    {
        return zzwj;
    }

    public String getTitle()
    {
        return zzagU;
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
        AppContentCardEntityCreator.zza(this, parcel, i);
    }

    public List zzta()
    {
        return new ArrayList(zzase);
    }

    public String zztb()
    {
        return zzasf;
    }

    public List zztl()
    {
        return new ArrayList(zzaso);
    }

    public int zztm()
    {
        return zzasp;
    }

    public String zztn()
    {
        return zzasq;
    }

    public int zzto()
    {
        return zzasr;
    }

    public AppContentCard zztp()
    {
        return this;
    }

}
