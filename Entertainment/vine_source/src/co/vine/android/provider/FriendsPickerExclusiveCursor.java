// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.database.Cursor;
import co.vine.android.api.VineRecipient;
import co.vine.android.api.VineUser;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.provider:
//            ExclusiveHybridCursor

public class FriendsPickerExclusiveCursor extends ExclusiveHybridCursor
{

    public FriendsPickerExclusiveCursor(Cursor cursor)
    {
        super(cursor);
        setMode(ExclusiveHybridCursor.Mode.CURSOR);
    }

    public FriendsPickerExclusiveCursor(ArrayList arraylist)
    {
        super(arraylist);
        setMode(ExclusiveHybridCursor.Mode.LIST);
    }

    public VineRecipient createItemFromCursor(Cursor cursor)
    {
        return VineDatabaseSQL.UsersQuery.getVineRecipient(cursor);
    }

    public volatile Object createItemFromCursor(Cursor cursor)
    {
        return createItemFromCursor(cursor);
    }

    public VineRecipient createItemsFromRemoteData(VineUser vineuser)
    {
        VineRecipient vinerecipient = VineRecipient.fromUser(vineuser.username, vineuser.userId, 0, -1L);
        vinerecipient.avatarUrl = vineuser.avatarUrl;
        return vinerecipient;
    }

    public volatile Object createItemsFromRemoteData(Object obj)
    {
        return createItemsFromRemoteData((VineUser)obj);
    }

    public int getColumnIndexOrThrow(String s)
        throws IllegalArgumentException
    {
        if (mCursor != null)
        {
            return mCursor.getColumnIndexOrThrow(s);
        } else
        {
            return -1;
        }
    }
}
