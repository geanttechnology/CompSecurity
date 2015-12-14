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
    private final String zzFz;
    private final String zzagU;
    private final String zzasf;
    private final ArrayList zzaso;
    private final String zzasq;
    private final ArrayList zzasx;
    private final String zzasy;
    private final String zzwj;

    AppContentSectionEntity(int i, ArrayList arraylist, ArrayList arraylist1, String s, Bundle bundle, String s1, String s2, 
            String s3, String s4, String s5, ArrayList arraylist2)
    {
        mVersionCode = i;
        mActions = arraylist;
        zzaso = arraylist2;
        zzasx = arraylist1;
        zzasy = s5;
        zzasf = s;
        mExtras = bundle;
        zzwj = s4;
        zzasq = s1;
        zzagU = s2;
        zzFz = s3;
    }

    public AppContentSectionEntity(AppContentSection appcontentsection)
    {
        boolean flag = false;
        super();
        mVersionCode = 5;
        zzasy = appcontentsection.zztw();
        zzasf = appcontentsection.zztb();
        mExtras = appcontentsection.getExtras();
        zzwj = appcontentsection.getId();
        zzasq = appcontentsection.zztn();
        zzagU = appcontentsection.getTitle();
        zzFz = appcontentsection.getType();
        List list = appcontentsection.getActions();
        int l = list.size();
        mActions = new ArrayList(l);
        for (int i = 0; i < l; i++)
        {
            mActions.add((AppContentActionEntity)(AppContentActionEntity)((AppContentAction)list.get(i)).freeze());
        }

        list = appcontentsection.zztv();
        l = list.size();
        zzasx = new ArrayList(l);
        for (int j = 0; j < l; j++)
        {
            zzasx.add((AppContentCardEntity)(AppContentCardEntity)((AppContentCard)list.get(j)).freeze());
        }

        appcontentsection = appcontentsection.zztl();
        l = appcontentsection.size();
        zzaso = new ArrayList(l);
        for (int k = ((flag) ? 1 : 0); k < l; k++)
        {
            zzaso.add((AppContentAnnotationEntity)(AppContentAnnotationEntity)((AppContentAnnotation)appcontentsection.get(k)).freeze());
        }

    }

    static int zza(AppContentSection appcontentsection)
    {
        return zzw.hashCode(new Object[] {
            appcontentsection.getActions(), appcontentsection.zztl(), appcontentsection.zztv(), appcontentsection.zztw(), appcontentsection.zztb(), appcontentsection.getExtras(), appcontentsection.getId(), appcontentsection.zztn(), appcontentsection.getTitle(), appcontentsection.getType()
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
        if (!zzw.equal(((AppContentSection) (obj)).getActions(), appcontentsection.getActions()) || !zzw.equal(((AppContentSection) (obj)).zztl(), appcontentsection.zztl()) || !zzw.equal(((AppContentSection) (obj)).zztv(), appcontentsection.zztv()) || !zzw.equal(((AppContentSection) (obj)).zztw(), appcontentsection.zztw()) || !zzw.equal(((AppContentSection) (obj)).zztb(), appcontentsection.zztb()) || !zzw.equal(((AppContentSection) (obj)).getExtras(), appcontentsection.getExtras()) || !zzw.equal(((AppContentSection) (obj)).getId(), appcontentsection.getId()) || !zzw.equal(((AppContentSection) (obj)).zztn(), appcontentsection.zztn()) || !zzw.equal(((AppContentSection) (obj)).getTitle(), appcontentsection.getTitle()))
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
        return zzw.zzu(appcontentsection).zzg("Actions", appcontentsection.getActions()).zzg("Annotations", appcontentsection.zztl()).zzg("Cards", appcontentsection.zztv()).zzg("CardType", appcontentsection.zztw()).zzg("ContentDescription", appcontentsection.zztb()).zzg("Extras", appcontentsection.getExtras()).zzg("Id", appcontentsection.getId()).zzg("Subtitle", appcontentsection.zztn()).zzg("Title", appcontentsection.getTitle()).zzg("Type", appcontentsection.getType()).toString();
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
        return zztx();
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
        AppContentSectionEntityCreator.zza(this, parcel, i);
    }

    public String zztb()
    {
        return zzasf;
    }

    public List zztl()
    {
        return new ArrayList(zzaso);
    }

    public String zztn()
    {
        return zzasq;
    }

    public List zztv()
    {
        return new ArrayList(zzasx);
    }

    public String zztw()
    {
        return zzasy;
    }

    public AppContentSection zztx()
    {
        return this;
    }

}
