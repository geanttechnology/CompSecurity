// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;

import java.util.Locale;

public class BSUser
{

    String appName;
    String email;
    String firstName;
    String lastName;
    String password;

    public BSUser()
    {
    }

    public BSUser(String s, String s1, String s2, String s3, String s4)
    {
        firstName = s;
        lastName = s1;
        email = s2;
        password = s3;
        appName = s4;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof BSUser))
            {
                return false;
            }
            obj = (BSUser)obj;
            if (email == null ? ((BSUser) (obj)).email != null : !email.equals(((BSUser) (obj)).email))
            {
                return false;
            }
            if (firstName == null ? ((BSUser) (obj)).firstName != null : !firstName.equals(((BSUser) (obj)).firstName))
            {
                return false;
            }
            if (lastName == null ? ((BSUser) (obj)).lastName != null : !lastName.equals(((BSUser) (obj)).lastName))
            {
                return false;
            }
            if (password == null ? ((BSUser) (obj)).password != null : !password.equals(((BSUser) (obj)).password))
            {
                return false;
            }
            if (appName == null ? ((BSUser) (obj)).appName != null : !appName.equals(((BSUser) (obj)).appName))
            {
                return false;
            }
        }
        return true;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public int hashCode()
    {
        int i1 = 0;
        int i;
        int j;
        int k;
        int l;
        if (firstName != null)
        {
            i = firstName.hashCode();
        } else
        {
            i = 0;
        }
        if (lastName != null)
        {
            j = lastName.hashCode();
        } else
        {
            j = 0;
        }
        if (email != null)
        {
            k = email.hashCode();
        } else
        {
            k = 0;
        }
        if (password != null)
        {
            l = password.hashCode();
        } else
        {
            l = 0;
        }
        if (appName != null)
        {
            i1 = appName.hashCode();
        }
        return (((i * 31 + j) * 31 + k) * 31 + l) * 31 + i1;
    }

    public void setAppName(String s)
    {
        appName = s;
    }

    public void setEmail(String s)
    {
        email = s;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setLastName(String s)
    {
        lastName = s;
    }

    public void setPassword(String s)
    {
        password = s;
    }

    public String toString()
    {
        return String.format(Locale.US, "%s %s - %s", new Object[] {
            firstName, lastName, email
        });
    }
}
