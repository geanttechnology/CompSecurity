// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.maps.model:
//            zzg

public final class PolygonOptions
    implements SafeParcelable
{

    public static final zzg CREATOR = new zzg();
    private final int zzCY;
    private float zzaCX;
    private int zzaCY;
    private int zzaCZ;
    private final List zzaDA;
    private final List zzaDB;
    private boolean zzaDC;
    private float zzaDa;
    private boolean zzaDb;

    public PolygonOptions()
    {
        zzaCX = 10F;
        zzaCY = 0xff000000;
        zzaCZ = 0;
        zzaDa = 0.0F;
        zzaDb = true;
        zzaDC = false;
        zzCY = 1;
        zzaDA = new ArrayList();
        zzaDB = new ArrayList();
    }

    PolygonOptions(int i, List list, List list1, float f, int j, int k, float f1, 
            boolean flag, boolean flag1)
    {
        zzaCX = 10F;
        zzaCY = 0xff000000;
        zzaCZ = 0;
        zzaDa = 0.0F;
        zzaDb = true;
        zzaDC = false;
        zzCY = i;
        zzaDA = list;
        zzaDB = list1;
        zzaCX = f;
        zzaCY = j;
        zzaCZ = k;
        zzaDa = f1;
        zzaDb = flag;
        zzaDC = flag1;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getFillColor()
    {
        return zzaCZ;
    }

    public List getPoints()
    {
        return zzaDA;
    }

    public int getStrokeColor()
    {
        return zzaCY;
    }

    public float getStrokeWidth()
    {
        return zzaCX;
    }

    int getVersionCode()
    {
        return zzCY;
    }

    public float getZIndex()
    {
        return zzaDa;
    }

    public boolean isGeodesic()
    {
        return zzaDC;
    }

    public boolean isVisible()
    {
        return zzaDb;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

    List zzvK()
    {
        return zzaDB;
    }

}
