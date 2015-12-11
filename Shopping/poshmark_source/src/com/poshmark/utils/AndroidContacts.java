// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.application.PMApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AndroidContacts
{
    class Contact
    {

        List emails;
        String first_name;
        String last_name;
        List phone_numbers;
        final AndroidContacts this$0;

        public void setContactEmail(String s, String s1)
        {
            HashMap hashmap = new HashMap();
            if (s != null && s1 != null)
            {
                hashmap.put(s, s1);
                emails.add(hashmap);
            }
        }

        public void setContactNumber(String s, String s1)
        {
            HashMap hashmap = new HashMap();
            if (s != null && s1 != null)
            {
                hashmap.put(s, s1);
                phone_numbers.add(hashmap);
            }
        }

        public void setFirstName(String s)
        {
            first_name = s;
        }

        public void setLastName(String s)
        {
            last_name = s;
        }

        Contact()
        {
            this$0 = AndroidContacts.this;
            super();
            emails = new ArrayList();
            phone_numbers = new ArrayList();
        }
    }


    List contacts;
    Map contactsMap;

    public AndroidContacts()
    {
        contactsMap = new HashMap();
        contacts = new ArrayList();
    }

    public String getAllPhoneContacts()
    {
        Cursor cursor = PMApplication.getContext().getContentResolver().query(android.provider.ContactsContract.Data.CONTENT_URI, new String[] {
            "contact_id", "mimetype", "data3", "data1", "data3", "data2", "display_name", "data1", "data2", "display_name"
        }, "mimetype = ? OR mimetype = ? OR mimetype = ?", new String[] {
            "vnd.android.cursor.item/name", "vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/phone_v2"
        }, null);
        if (cursor.getCount() > 0)
        {
            do
            {
                if (!cursor.moveToNext())
                {
                    break;
                }
                String s = cursor.getString(cursor.getColumnIndex("contact_id"));
                String s3 = cursor.getString(cursor.getColumnIndex("mimetype"));
                Contact contact;
                if (contactsMap.containsKey(s))
                {
                    contact = (Contact)contactsMap.get(s);
                } else
                {
                    contact = new Contact();
                    contactsMap.put(s, contact);
                    contacts.add(contact);
                }
                if (s3.equals("vnd.android.cursor.item/name"))
                {
                    contact.setLastName(cursor.getString(cursor.getColumnIndex("data3")));
                    contact.setFirstName(cursor.getString(cursor.getColumnIndex("data2")));
                }
                if (s3.equals("vnd.android.cursor.item/phone_v2"))
                {
                    String s5 = cursor.getString(cursor.getColumnIndex("data1"));
                    int i = cursor.getInt(cursor.getColumnIndex("data2"));
                    String s1 = android.provider.ContactsContract.CommonDataKinds.Phone.getTypeLabel(PMApplication.getContext().getResources(), i, "Custom").toString();
                    s = s1;
                    if (s1 == null)
                    {
                        s = "other";
                    }
                    contact.setContactNumber(s.toLowerCase(), s5);
                }
                if (s3.equals("vnd.android.cursor.item/email_v2"))
                {
                    String s4 = cursor.getString(cursor.getColumnIndex("data1"));
                    String s2 = cursor.getString(cursor.getColumnIndex("data3"));
                    s = s2;
                    if (s2 == null)
                    {
                        s = "other";
                    }
                    contact.setContactEmail(s.toLowerCase(), s4);
                }
            } while (true);
        }
        cursor.close();
        Gson gson = (new GsonBuilder()).create();
        List list = contacts;
        if (!(gson instanceof Gson))
        {
            return gson.toJson(list);
        } else
        {
            return GsonInstrumentation.toJson((Gson)gson, list);
        }
    }
}
