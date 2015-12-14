// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.model;

import android.os.Parcel;

public class Badge
{

    private boolean available;
    private int id;
    private int idUsed;
    private String message;
    private String name;

    public Badge(int i, int j, String s, String s1, boolean flag)
    {
        id = i;
        name = s;
        idUsed = j;
        message = s1;
        available = flag;
    }

    private Badge(Parcel parcel)
    {
        boolean flag = true;
        super();
        id = parcel.readInt();
        name = parcel.readString();
        message = parcel.readString();
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        available = flag;
    }

    public int getId()
    {
        return id;
    }

    public int getIdUsed()
    {
        return idUsed;
    }

    public String getMessage()
    {
        return message;
    }

    public String getName()
    {
        return name;
    }

    public boolean isAvailable()
    {
        return available;
    }
}
