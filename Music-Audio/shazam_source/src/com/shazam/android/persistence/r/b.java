// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.r;

import android.content.ContentValues;
import com.shazam.model.Track;
import java.util.List;

public interface b
{

    public abstract int a(ContentValues contentvalues, String s, String as[]);

    public abstract Track a(String s);

    public abstract void a(Track track);

    public abstract void a(String s, String s1);

    public abstract List b(List list);
}
