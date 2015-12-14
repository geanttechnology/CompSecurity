// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.os.Bundle;
import java.util.HashMap;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            IAPDialogMain

public static class eventAttributes
    implements Cloneable
{
    public static class Builder
    {

        IAPDialogMain.IAPUpdater result;

        public Builder addEventAttributes(String s, String s1)
        {
            result.eventAttributes.put(s, s1);
            return this;
        }

        public IAPDialogMain.IAPUpdater build()
        {
            return result;
        }

        public Builder setEvent(String s)
        {
            result.eventName = s;
            return this;
        }

        public Builder setExtras(Bundle bundle)
        {
            result.dialogExtras = bundle;
            return this;
        }

        public Builder setFeaturedPackId(long l)
        {
            result.featuredPackId = l;
            return this;
        }

        public Builder setPackId(long l)
        {
            result.packId = l;
            return this;
        }

        public Builder setPackType(com.aviary.android.feather.cds.AviaryCds.PackType packtype)
        {
            result.packType = packtype;
            return this;
        }

        public Builder()
        {
            result = new IAPDialogMain.IAPUpdater();
        }
    }


    private Bundle dialogExtras;
    private HashMap eventAttributes;
    private String eventName;
    private long featuredPackId;
    private boolean isAnimating;
    private long packId;
    private com.aviary.android.feather.cds.pdater.featuredPackId packType;

    public Object clone()
    {
        packType packtype = new <init>();
        packtype.packId = packId;
        packtype.packType = packType;
        packtype.featuredPackId = featuredPackId;
        packtype.isAnimating = isAnimating;
        if (dialogExtras != null)
        {
            packtype.dialogExtras = (Bundle)dialogExtras.clone();
        }
        return packtype;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof dialogExtras)
        {
            obj = (dialogExtras)obj;
            return ((dialogExtras) (obj)).packId == packId && ((packId) (obj)).packType == packType;
        } else
        {
            return super.equals(obj);
        }
    }

    public Bundle getExtras()
    {
        return dialogExtras;
    }

    public long getFeaturedPackId()
    {
        return featuredPackId;
    }

    public boolean getIsAnimating()
    {
        return isAnimating;
    }

    public long getPackId()
    {
        return packId;
    }

    public com.aviary.android.feather.cds.pdater getPackType()
    {
        return packType;
    }

    public int hashCode()
    {
        return Long.valueOf(packId).hashCode() + packType.de() * 37;
    }

    public String toString()
    {
        return (new StringBuilder()).append("IAPUpdater{packType: ").append(packType).append(", packId: ").append(packId).append(", featuredPackId: ").append(featuredPackId).append("}").toString();
    }



/*
    static long access$102(Builder builder, long l)
    {
        builder.packId = l;
        return l;
    }

*/



/*
    static com.aviary.android.feather.cds.pdater access$202(packId packid, com.aviary.android.feather.cds.pdater pdater)
    {
        packid.packType = pdater;
        return pdater;
    }

*/



/*
    static String access$302(packType packtype, String s)
    {
        packtype.eventName = s;
        return s;
    }

*/



/*
    static boolean access$502(eventName eventname, boolean flag)
    {
        eventname.isAnimating = flag;
        return flag;
    }

*/


/*
    static long access$702(isAnimating isanimating, long l)
    {
        isanimating.featuredPackId = l;
        return l;
    }

*/


/*
    static Bundle access$802(featuredPackId featuredpackid, Bundle bundle)
    {
        featuredpackid.dialogExtras = bundle;
        return bundle;
    }

*/

    public <init>()
    {
        packId = -1L;
        packType = null;
        eventName = null;
        featuredPackId = -1L;
        eventAttributes = new HashMap();
    }
}
