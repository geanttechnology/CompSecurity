// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.text.TextUtils;
import java.util.HashSet;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package co.vine.android.util:
//            Util

private static class timesContacted
{

    public HashSet emails;
    public String name;
    public HashSet phones;
    public boolean starred;
    public int timesContacted;

    public void addEmail(String s, String s1)
    {
        if (emails == null)
        {
            emails = new HashSet();
        }
        HashSet hashset = new HashSet();
        hashset.add(new BasicNameValuePair("emailAddress", s1));
        if (!TextUtils.isEmpty(s))
        {
            hashset.add(new BasicNameValuePair("label", s));
        }
        emails.add(hashset);
    }

    public void addPhone(String s, String s1)
    {
        if (phones == null)
        {
            phones = new HashSet();
        }
        HashSet hashset = new HashSet();
        hashset.add(new BasicNameValuePair("phoneNumber", s1));
        if (!TextUtils.isEmpty(s))
        {
            hashset.add(new BasicNameValuePair("label", s));
        }
        phones.add(hashset);
    }

    public void setStarred()
    {
        starred = true;
    }

    public void setTimesContacted(int i)
    {
        timesContacted = i;
    }

    public (String s)
    {
        name = s;
        starred = false;
        timesContacted = 0;
    }
}
