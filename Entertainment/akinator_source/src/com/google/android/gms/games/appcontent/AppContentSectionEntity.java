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
//            AppContentSection, AppContentSectionEntityCreator, AppContentAction, AppContentActionEntity, 
//            AppContentCard, AppContentCardEntity, AppContentAnnotation, AppContentAnnotationEntity

public final class AppContentSectionEntity
    implements SafeParcelable, AppContentSection
{

    public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
    private final ArrayList mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzGq;
    private final String zzajf;
    private final String zzauD;
    private final ArrayList zzauM;
    private final String zzauO;
    private final ArrayList zzauV;
    private final String zzauW;
    private final String zzwN;

    AppContentSectionEntity(int i, ArrayList arraylist, ArrayList arraylist1, String s, Bundle bundle, String s1, String s2, 
            String s3, String s4, String s5, ArrayList arraylist2)
    {
        mVersionCode = i;
        mActions = arraylist;
        zzauM = arraylist2;
        zzauV = arraylist1;
        zzauW = s5;
        zzauD = s;
        mExtras = bundle;
        zzwN = s4;
        zzauO = s1;
        zzajf = s2;
        zzGq = s3;
    }

    public AppContentSectionEntity(AppContentSection appcontentsection)
    {
        boolean flag = false;
        super();
        mVersionCode = 5;
        zzauW = appcontentsection.zzul();
        zzauD = appcontentsection.zztQ();
        mExtras = appcontentsection.getExtras();
        zzwN = appcontentsection.getId();
        zzauO = appcontentsection.zzuc();
        zzajf = appcontentsection.getTitle();
        zzGq = appcontentsection.getType();
        List list = appcontentsection.getActions();
        int l = list.size();
        mActions = new ArrayList(l);
        for (int i = 0; i < l; i++)
        {
            mActions.add((AppContentActionEntity)(AppContentActionEntity)((AppContentAction)list.get(i)).freeze());
        }

        list = appcontentsection.zzuk();
        l = list.size();
        zzauV = new ArrayList(l);
        for (int j = 0; j < l; j++)
        {
            zzauV.add((AppContentCardEntity)(AppContentCardEntity)((AppContentCard)list.get(j)).freeze());
        }

        appcontentsection = appcontentsection.zzua();
        l = appcontentsection.size();
        zzauM = new ArrayList(l);
        for (int k = ((flag) ? 1 : 0); k < l; k++)
        {
            zzauM.add((AppContentAnnotationEntity)(AppContentAnnotationEntity)((AppContentAnnotation)appcontentsection.get(k)).freeze());
        }

    }

    static int zza(AppContentSection appcontentsection)
    {
        return zzw.hashCode(new Object[] {
            appcontentsection.getActions(), appcontentsection.zzua(), appcontentsection.zzuk(), appcontentsection.zzul(), appcontentsection.zztQ(), appcontentsection.getExtras(), appcontentsection.getId(), appcontentsection.zzuc(), appcontentsection.getTitle(), appcontentsection.getType()
        });
    }

    static boolean zza(AppContentSection appcontentsection, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof AppContentSection) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (appcontentsection == obj) goto _L4; else goto _L3
_L3:
        obj = (AppContentSection)obj;
        if (!zzw.equal(((AppContentSection) (obj)).getActions(), appcontentsection.getActions()) || !zzw.equal(((AppContentSection) (obj)).zzua(), appcontentsection.zzua()) || !zzw.equal(((AppContentSection) (obj)).zzuk(), appcontentsection.zzuk()) || !zzw.equal(((AppContentSection) (obj)).zzul(), appcontentsection.zzul()) || !zzw.equal(((AppContentSection) (obj)).zztQ(), appcontentsection.zztQ()) || !zzw.equal(((AppContentSection) (obj)).getExtras(), appcontentsection.getExtras()) || !zzw.equal(((AppContentSection) (obj)).getId(), appcontentsection.getId()) || !zzw.equal(((AppContentSection) (obj)).zzuc(), appcontentsection.zzuc()) || !zzw.equal(((AppContentSection) (obj)).getTitle(), appcontentsection.getTitle()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((AppContentSection) (obj)).getType(), appcontentsection.getType())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(AppContentSection appcontentsection)
    {
        return zzw.zzv(appcontentsection).zzg("Actions", appcontentsection.getActions()).zzg("Annotations", appcontentsection.zzua()).zzg("Cards", appcontentsection.zzuk()).zzg("CardType", appcontentsection.zzul()).zzg("ContentDescription", appcontentsection.zztQ()).zzg("Extras", appcontentsection.getExtras()).zzg("Id", appcontentsection.getId()).zzg("Subtitle", appcontentsection.zzuc()).zzg("Title", appcontentsection.getTitle()).zzg("Type", appcontentsection.getType()).toString();
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
        return zzum();
    }

    public List getActions()
    {
        return new ArrayList(mActions);
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
        AppContentSectionEntityCreator.zza(this, parcel, i);
    }

    public String zztQ()
    {
        return zzauD;
    }

    public List zzua()
    {
        return new ArrayList(zzauM);
    }

    public String zzuc()
    {
        return zzauO;
    }

    public List zzuk()
    {
        return new ArrayList(zzauV);
    }

    public String zzul()
    {
        return zzauW;
    }

    public AppContentSection zzum()
    {
        return this;
    }

}
