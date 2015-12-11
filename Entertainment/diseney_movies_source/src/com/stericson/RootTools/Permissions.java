// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;


public class Permissions
{

    String group;
    String other;
    int permissions;
    String symlink;
    String type;
    String user;

    public Permissions()
    {
    }

    public String getGroupPermissions()
    {
        return group;
    }

    public String getOtherPermissions()
    {
        return other;
    }

    public int getPermissions()
    {
        return permissions;
    }

    public String getSymlink()
    {
        return symlink;
    }

    public String getType()
    {
        return type;
    }

    public String getUserPermissions()
    {
        return user;
    }

    public void setGroupPermissions(String s)
    {
        group = s;
    }

    public void setOtherPermissions(String s)
    {
        other = s;
    }

    public void setPermissions(int i)
    {
        permissions = i;
    }

    public void setSymlink(String s)
    {
        symlink = s;
    }

    public void setType(String s)
    {
        type = s;
    }

    public void setUserPermissions(String s)
    {
        user = s;
    }
}
