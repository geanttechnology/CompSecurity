// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.graphics.drawable.Drawable;

public class TaskInfo
{

    private Drawable icon;
    private int id;
    private boolean isCheck;
    private boolean isSystemProcess;
    private int memory;
    private String name;
    private String packageName;

    public TaskInfo()
    {
        isCheck = true;
    }

    public Drawable getIcon()
    {
        return icon;
    }

    public int getId()
    {
        return id;
    }

    public int getMemory()
    {
        return memory;
    }

    public String getName()
    {
        return name;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public boolean isCheck()
    {
        return isCheck;
    }

    public boolean isSystemProcess()
    {
        return isSystemProcess;
    }

    public void setCheck(boolean flag)
    {
        isCheck = flag;
    }

    public void setIcon(Drawable drawable)
    {
        icon = drawable;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setMemory(int i)
    {
        memory = i;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPackageName(String s)
    {
        packageName = s;
    }

    public void setSystemProcess(boolean flag)
    {
        isSystemProcess = flag;
    }
}
