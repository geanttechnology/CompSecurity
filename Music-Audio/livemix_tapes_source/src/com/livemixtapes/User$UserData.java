// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.util.Log;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.livemixtapes:
//            User

public static final class favoriteMixtapeIds
{

    public final Set favoriteMixtapeIds = new HashSet();
    public final List favoriteMixtapes;
    public final String firstName;
    public final String lastName;
    public List playlists;
    public final int radioFavoritesListId;
    public final int userId;
    public final String userName;

    public (String s, int i, String s1, String s2, int j, List list, List list1)
    {
        userName = s;
        userId = i;
        firstName = s1;
        lastName = s2;
        radioFavoritesListId = j;
        playlists = list;
        favoriteMixtapes = list1;
        Log.d("Nithin", list1.toString());
        i = 0;
        do
        {
            if (i >= list1.size())
            {
                return;
            }
            s = (String)((Map)list1.get(i)).get("id");
            favoriteMixtapeIds.add(Integer.valueOf(s));
            i++;
        } while (true);
    }
}
