// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

// Referenced classes of package co.vine.android.util:
//            ContactsHelper, CrashUtil

private static class  extends CursorLoader
{

    public Cursor loadInBackground()
    {
        Cursor cursor;
        try
        {
            cursor = super.loadInBackground();
        }
        catch (Throwable throwable)
        {
            CrashUtil.logException(throwable);
            return null;
        }
        return cursor;
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public (Context context, Uri uri, String as[], String s, String as1[], String s1)
    {
        super(context, uri, as, s, as1, s1);
    }
}
