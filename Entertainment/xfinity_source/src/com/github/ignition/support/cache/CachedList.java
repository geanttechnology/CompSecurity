// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.cache;

import android.os.Parcel;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

// Referenced classes of package com.github.ignition.support.cache:
//            CachedModel

public class CachedList extends CachedModel
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CachedList createFromParcel(Parcel parcel)
        {
            try
            {
                parcel = new CachedList(parcel);
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                parcel.printStackTrace();
                return null;
            }
            return parcel;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CachedList[] newArray(int i)
        {
            return new CachedList[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    protected Class clazz;
    protected ArrayList list;

    public CachedList()
    {
        list = new ArrayList();
    }

    public CachedList(Parcel parcel)
        throws IOException
    {
        super(parcel);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag = obj instanceof CachedList;
        if (flag) goto _L2; else goto _L1
_L1:
        flag = flag1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        obj = (CachedList)obj;
        flag = flag1;
        boolean flag2;
        if (!clazz.equals(((CachedList) (obj)).clazz))
        {
            continue; /* Loop/switch isn't completed */
        }
        flag2 = list.equals(((CachedList) (obj)).list);
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public void readFromParcel(Parcel parcel)
        throws IOException
    {
        super.readFromParcel(parcel);
        String s = parcel.readString();
        try
        {
            clazz = Class.forName(s);
            list = parcel.createTypedArrayList((android.os.Parcelable.Creator)clazz.getField("CREATOR").get(this));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.writeToParcel(parcel, i);
        parcel.writeString(clazz.getCanonicalName());
        parcel.writeTypedList(list);
    }

}
