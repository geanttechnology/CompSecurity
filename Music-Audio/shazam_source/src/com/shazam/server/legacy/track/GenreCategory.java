// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.track;


// Referenced classes of package com.shazam.server.legacy.track:
//            Genre

public class GenreCategory
{

    private Genre parentGenre;
    private Genre subGenre;

    private GenreCategory()
    {
    }

    public GenreCategory(Genre genre, Genre genre1)
    {
        parentGenre = genre;
        subGenre = genre1;
    }

    public Genre getParentGenre()
    {
        return parentGenre;
    }

    public Genre getSubGenre()
    {
        return subGenre;
    }
}
