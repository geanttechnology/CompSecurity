// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.poshmark.utils:
//            AndroidContacts

class phone_numbers
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

    ()
    {
        this$0 = AndroidContacts.this;
        super();
        emails = new ArrayList();
        phone_numbers = new ArrayList();
    }
}
