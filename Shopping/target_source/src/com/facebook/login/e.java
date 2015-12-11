// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class e
{

    private static final Set a = a();

    private static Set a()
    {
        return Collections.unmodifiableSet(new HashSet() {

            
            {
                add("ads_management");
                add("create_event");
                add("rsvp_event");
            }
        });
    }

    static boolean a(String s)
    {
        return s != null && (s.startsWith("publish") || s.startsWith("manage") || a.contains(s));
    }

}
