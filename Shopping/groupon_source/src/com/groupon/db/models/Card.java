// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import android.content.Context;
import java.sql.SQLException;
import java.util.List;

public abstract class Card
{

    public Object data;
    public List displayOptions;

    public Card()
    {
    }

    public abstract void save(String s, Context context, int i, int j)
        throws SQLException;

    public boolean skipWhenCalculatingTrackingPosition()
    {
        return false;
    }
}
