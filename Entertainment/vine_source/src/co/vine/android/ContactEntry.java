// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;

public class ContactEntry
    implements Comparable
{

    public static final String sProjection[] = {
        "contact_id", "display_name", "display_name_alt", "mimetype", "data1"
    };
    public static final String sSelection = "mimetype=? OR mimetype=?";
    public static final String sSelectionArgs[] = {
        "vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/phone_v2"
    };
    public static final String sSortOrder = "contact_id ASC ";
    public static final Uri sUri;
    public String alternateName;
    public long contactId;
    public String displayName;
    public int typeFlag;
    public HashMap valueMimeMap;

    public ContactEntry(Cursor cursor)
    {
        int i = 1;
        super();
        valueMimeMap = new HashMap();
        contactId = cursor.getLong(0);
        displayName = cursor.getString(1);
        alternateName = cursor.getString(2);
        if (!"vnd.android.cursor.item/email_v2".equals(cursor.getString(3)))
        {
            i = 2;
        }
        typeFlag = i;
    }

    private int getCompareResult(String s, String s1)
    {
        boolean flag = Character.isLetter(s.charAt(0));
        boolean flag1 = Character.isLetter(s1.charAt(0));
        if (flag && flag1 || !flag && !flag1)
        {
            return s.compareTo(s1);
        }
        return !flag ? 1 : -1;
    }

    public int compareTo(ContactEntry contactentry)
    {
        if (alternateName != null && contactentry.alternateName != null)
        {
            return getCompareResult(alternateName.toLowerCase(), contactentry.alternateName.toLowerCase());
        } else
        {
            return getCompareResult(displayName.toLowerCase(), contactentry.displayName.toLowerCase());
        }
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((ContactEntry)obj);
    }

    public boolean isSameSection(ContactEntry contactentry)
    {
        return alternateName == null || contactentry.alternateName == null ? displayName.toLowerCase().charAt(0) != contactentry.displayName.toLowerCase().charAt(0) : alternateName.toLowerCase().charAt(0) != contactentry.alternateName.toLowerCase().charAt(0);
    }

    static 
    {
        sUri = android.provider.ContactsContract.Data.CONTENT_URI;
    }
}
