// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.objectinfo;

import android.os.Parcel;
import android.os.Parcelable;
import com.a9.vs.mobile.library.impl.jni.TextCanvasInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlowTextCanvasInfo
{
    public static class ContactInfo
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ContactInfo createFromParcel(Parcel parcel)
            {
                return new ContactInfo(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public ContactInfo[] newArray(int i)
            {
                return new ContactInfo[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public ContactInfoAddress address;
        public ContactInfoEntity company;
        public ContactInfoEntity department;
        public List emails;
        public ContactInfoEntity jobTitle;
        public ContactInfoName name;
        public List otherText;
        public List phones;
        public List urls;

        private List entityListToStringList(List list)
        {
            ArrayList arraylist = new ArrayList();
            for (list = list.iterator(); list.hasNext(); arraylist.add(((ContactInfoEntity)list.next()).content)) { }
            return arraylist;
        }

        private void readStringArrayToEntityList(Parcel parcel, List list)
        {
            ArrayList arraylist = new ArrayList();
            parcel.readStringList(arraylist);
            for (parcel = arraylist.iterator(); parcel.hasNext(); list.add(new ContactInfoEntity((String)parcel.next()))) { }
        }

        private void readStringArrayToEntityListWithType(Parcel parcel, List list, int i)
        {
            if (i > 0)
            {
                String as[] = new String[i];
                parcel.readStringArray(as);
                for (i = 0; i < as.length; i += 2)
                {
                    list.add(new ContactInfoEntity(as[i], as[i + 1]));
                }

            }
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(name.firstname);
            parcel.writeString(name.middlename);
            parcel.writeString(name.lastname);
            parcel.writeString(address.addrStreet);
            parcel.writeString(address.addrCity);
            parcel.writeString(address.addrState);
            parcel.writeString(address.addrZipCode);
            parcel.writeString(company.content);
            parcel.writeString(department.content);
            parcel.writeString(jobTitle.content);
            parcel.writeInt(phones.size());
            if (phones.size() > 0)
            {
                String as[] = new String[phones.size() * 2];
                for (i = 0; i < phones.size(); i++)
                {
                    as[i * 2] = ((ContactInfoEntity)phones.get(i)).type;
                    as[i * 2 + 1] = ((ContactInfoEntity)phones.get(i)).content;
                }

                parcel.writeStringArray(as);
            }
            parcel.writeStringList(entityListToStringList(emails));
            parcel.writeStringList(entityListToStringList(urls));
            parcel.writeStringList(entityListToStringList(otherText));
        }


        public ContactInfo()
        {
            name = new ContactInfoName();
            address = new ContactInfoAddress();
            company = new ContactInfoEntity();
            department = new ContactInfoEntity();
            jobTitle = new ContactInfoEntity();
            phones = new ArrayList();
            emails = new ArrayList();
            urls = new ArrayList();
            otherText = new ArrayList();
        }

        public ContactInfo(Parcel parcel)
        {
            this();
            name.firstname = parcel.readString();
            name.middlename = parcel.readString();
            name.lastname = parcel.readString();
            address.addrStreet = parcel.readString();
            address.addrCity = parcel.readString();
            address.addrState = parcel.readString();
            address.addrZipCode = parcel.readString();
            company.content = parcel.readString();
            department.content = parcel.readString();
            jobTitle.content = parcel.readString();
            int i = parcel.readInt();
            phones = new ArrayList();
            if (i > 0)
            {
                readStringArrayToEntityListWithType(parcel, phones, i * 2);
            }
            emails = new ArrayList();
            readStringArrayToEntityList(parcel, emails);
            urls = new ArrayList();
            readStringArrayToEntityList(parcel, urls);
            otherText = new ArrayList();
            readStringArrayToEntityList(parcel, otherText);
        }
    }

    public class ContactInfo.ContactInfoAddress
    {

        public String addrCity;
        public String addrState;
        public String addrStreet;
        public String addrZipCode;
        public boolean isVerified;
        final ContactInfo this$0;

        public ContactInfo.ContactInfoAddress()
        {
            this$0 = ContactInfo.this;
            super();
            addrStreet = "";
            addrCity = "";
            addrState = "";
            addrZipCode = "";
            isVerified = false;
        }
    }

    public class ContactInfo.ContactInfoEntity
    {

        public String content;
        public boolean isVerified;
        final ContactInfo this$0;
        public String type;

        public ContactInfo.ContactInfoEntity()
        {
            this$0 = ContactInfo.this;
            super();
            type = "";
            content = "";
            isVerified = false;
        }

        public ContactInfo.ContactInfoEntity(String s)
        {
            this$0 = ContactInfo.this;
            super();
            type = "";
            content = "";
            isVerified = false;
            content = s;
        }

        public ContactInfo.ContactInfoEntity(String s, String s1)
        {
            this$0 = ContactInfo.this;
            super();
            type = "";
            content = "";
            isVerified = false;
            type = s;
            content = s1;
        }
    }

    public class ContactInfo.ContactInfoName
    {

        public String firstname;
        public boolean isVerified;
        public String lastname;
        public String middlename;
        final ContactInfo this$0;

        public ContactInfo.ContactInfoName()
        {
            this$0 = ContactInfo.this;
            super();
            firstname = "";
            middlename = "";
            lastname = "";
            isVerified = false;
        }
    }


    private int m_sessionId;
    protected TextCanvasInfo m_textCanvasInfo;
    private String m_uniqueId;

    public FlowTextCanvasInfo(int i, String s)
    {
        m_sessionId = i;
        m_uniqueId = s;
    }

    public FlowTextCanvasInfo(TextCanvasInfo textcanvasinfo)
    {
        m_textCanvasInfo = textcanvasinfo;
        m_sessionId = textcanvasinfo.getId();
        m_uniqueId = textcanvasinfo.getUniqueID();
    }
}
