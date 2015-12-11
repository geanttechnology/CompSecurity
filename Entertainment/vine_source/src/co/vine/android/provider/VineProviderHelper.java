// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import co.vine.android.api.VineRecipient;
import java.util.ArrayList;

public class VineProviderHelper
{

    public VineProviderHelper()
    {
    }

    public static ArrayList getConversationRecipients(ContentResolver contentresolver, long l)
    {
        ArrayList arraylist = new ArrayList();
        contentresolver = queryConversationRecipientsUsersView(contentresolver, l);
        if (contentresolver != null)
        {
            do
            {
                if (!contentresolver.moveToNext())
                {
                    break;
                }
                l = contentresolver.getLong(2);
                long l1 = contentresolver.getLong(6);
                String s = contentresolver.getString(5);
                String s1 = contentresolver.getString(4);
                String s2 = contentresolver.getString(3);
                if (l1 > 0L)
                {
                    arraylist.add(VineRecipient.fromUser(s2, l1, 0, l));
                } else
                if (!TextUtils.isEmpty(s))
                {
                    arraylist.add(VineRecipient.fromEmail(s2, -1L, s, l));
                } else
                if (!TextUtils.isEmpty(s1))
                {
                    arraylist.add(VineRecipient.fromPhone(s2, -1L, s1, l));
                }
            } while (true);
            contentresolver.close();
        }
        return arraylist;
    }

    public static Cursor queryConversationRecipientsUsersView(ContentResolver contentresolver, long l)
    {
        return contentresolver.query(Vine.ConversationRecipientsUsersView.CONTENT_URI_CONVERSATION.buildUpon().appendQueryParameter("conversation_row_id", String.valueOf(l)).build(), VineDatabaseSQL.ConversationRecipientsUsersViewQuery.PROJECTION, null, null, null);
    }
}
