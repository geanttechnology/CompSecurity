// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;

public interface MDBItem
{

    public abstract void convertFrom(Cursor cursor);

    public abstract ContentValues convertTo();
}
