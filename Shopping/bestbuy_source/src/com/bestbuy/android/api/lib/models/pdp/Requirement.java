// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class Requirement
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList download;
    private ArrayList mac;
    private ArrayList pc;
    private ArrayList system;

    public Requirement()
    {
    }

    public ArrayList getDownload()
    {
        return download;
    }

    public ArrayList getMacSpecifications()
    {
        return mac;
    }

    public ArrayList getPcSpecifications()
    {
        return pc;
    }

    public ArrayList getSystem()
    {
        return system;
    }

    public void setDownload(ArrayList arraylist)
    {
        download = arraylist;
    }

    public void setMacSpecifications(ArrayList arraylist)
    {
        mac = arraylist;
    }

    public void setPcSpecifications(ArrayList arraylist)
    {
        pc = arraylist;
    }

    public void setSystem(ArrayList arraylist)
    {
        system = arraylist;
    }
}
