// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NameValue extends BaseDataMapped
    implements Parcelable, Serializable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public NameValue createFromParcel(Parcel parcel)
        {
            return new NameValue(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public NameValue[] newArray(int i)
        {
            return new NameValue[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final long serialVersionUID = 0x1b750a5a49b9327cL;
    private String name;
    private List values;

    public NameValue()
    {
        values = new ArrayList();
    }

    private NameValue(Parcel parcel)
    {
        values = new ArrayList();
        name = parcel.readString();
        parcel.readStringList(values);
    }


    public NameValue(String s, String s1)
    {
        values = new ArrayList();
        name = s;
        s = values;
        if (s1 == null)
        {
            s1 = "";
        }
        s.add(s1);
    }

    public NameValue(String s, List list)
    {
        values = new ArrayList();
        name = s;
        values.addAll(list);
    }

    public void addValue(String s)
    {
        values.add(s);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj instanceof NameValue)
                {
                    obj = (NameValue)obj;
                    if (!name.equals(((NameValue) (obj)).name) || !values.equals(((NameValue) (obj)).values))
                    {
                        break label0;
                    }
                    flag = true;
                }
            }
            return flag;
        }
        return false;
    }

    public String getName()
    {
        return name;
    }

    public int getNumValues()
    {
        return values.size();
    }

    public String getValue()
    {
        if (values.size() > 0)
        {
            return (String)values.get(0);
        } else
        {
            return null;
        }
    }

    public String getValue(int i)
    {
        if (values.size() > i)
        {
            return (String)values.get(i);
        } else
        {
            return null;
        }
    }

    public List getValues()
    {
        return values;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setValue(int i, String s)
    {
        if (values.size() > i)
        {
            values.set(i, s);
            return;
        } else
        {
            values.add(s);
            return;
        }
    }

    public void setValue(String s)
    {
        if (values.size() > 0)
        {
            values.set(0, s);
            return;
        } else
        {
            values.add(s);
            return;
        }
    }

    public void setValues(List list)
    {
        if (list != null)
        {
            values = list;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(name).append(": ");
        for (int i = 0; i < values.size(); i++)
        {
            stringbuilder.append((String)values.get(i));
            if (i < values.size() - 1)
            {
                stringbuilder.append(", ");
            }
        }

        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(name);
        parcel.writeStringList(values);
    }

}
