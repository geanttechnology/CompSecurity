// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.model.Model;
import java.util.ArrayList;

public class CaseResult extends Model
{

    public ArrayList cases;
    public Long modifyTime;
    public String status;

    public CaseResult()
    {
        status = null;
        cases = null;
        modifyTime = Long.valueOf(0L);
    }
}
