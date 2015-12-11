// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

public class ShowPropertyParam
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ShowPropertyParam createFromParcel(Parcel parcel)
        {
            return new ShowPropertyParam(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShowPropertyParam[] newArray(int i)
        {
            return new ShowPropertyParam[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private List fields;
    private String property;

    protected ShowPropertyParam(Parcel parcel)
    {
        fields = new ArrayList();
        property = parcel.readString();
        fields = parcel.createTypedArrayList(CREATOR);
    }

    public ShowPropertyParam(String s)
    {
        fields = new ArrayList();
        property = s;
    }

    public ShowPropertyParam addField(ShowPropertyParam showpropertyparam)
    {
        fields.add(showpropertyparam);
        return this;
    }

    public String asUrlParam()
    {
        String s = property;
        String s1 = fieldsAsString();
        if (!Strings.isEmpty(s1))
        {
            s = String.format("%s(%s)", new Object[] {
                property, s1
            });
        }
        return s;
    }

    public int describeContents()
    {
        return 0;
    }

    public int fieldCount()
    {
        return fields.size();
    }

    public String fieldsAsString()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = fields.iterator(); iterator.hasNext(); arraylist.add(((ShowPropertyParam)iterator.next()).asUrlParam())) { }
        if (arraylist.isEmpty())
        {
            return null;
        } else
        {
            return Strings.join(",", arraylist);
        }
    }

    public ShowPropertyParam findField(String s)
    {
        for (Iterator iterator = fields.iterator(); iterator.hasNext();)
        {
            ShowPropertyParam showpropertyparam = (ShowPropertyParam)iterator.next();
            if (Strings.equals(s, showpropertyparam.getProperty()))
            {
                return showpropertyparam;
            }
        }

        return null;
    }

    public String getProperty()
    {
        return property;
    }

    public void removeField(String s)
    {
        Object obj = null;
        Iterator iterator = fields.iterator();
        ShowPropertyParam showpropertyparam;
        do
        {
            showpropertyparam = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            showpropertyparam = (ShowPropertyParam)iterator.next();
        } while (!Strings.equals(s, showpropertyparam.getProperty()));
        fields.remove(showpropertyparam);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(property);
        parcel.writeTypedList(fields);
    }

}
