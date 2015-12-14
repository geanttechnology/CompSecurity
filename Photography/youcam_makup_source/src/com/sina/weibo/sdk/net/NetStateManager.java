// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import org.apache.http.HttpHost;

public class NetStateManager
{

    public static NetState CUR_NETSTATE;
    private static Context mContext;

    public NetStateManager()
    {
    }

    public static HttpHost getAPN()
    {
        Object obj2 = null;
        Object obj1 = null;
        Object obj = Uri.parse("content://telephony/carriers/preferapn");
        Cursor cursor;
        if (mContext != null)
        {
            cursor = mContext.getContentResolver().query(((Uri) (obj)), null, null, null, null);
        } else
        {
            cursor = null;
        }
        obj = obj2;
        if (cursor != null)
        {
            obj = obj2;
            if (cursor.moveToFirst())
            {
                String s = cursor.getString(cursor.getColumnIndex("proxy"));
                obj = obj1;
                if (s != null)
                {
                    obj = obj1;
                    if (s.trim().length() > 0)
                    {
                        obj = new HttpHost(s, 80);
                    }
                }
                cursor.close();
            }
        }
        return ((HttpHost) (obj));
    }

    static 
    {
        CUR_NETSTATE = NetState.Mobile;
    }


    private class NetState extends Enum
    {

        private static final NetState ENUM$VALUES[];
        public static final NetState Mobile;
        public static final NetState NOWAY;
        public static final NetState WIFI;

        public static NetState valueOf(String s)
        {
            return (NetState)Enum.valueOf(com/sina/weibo/sdk/net/NetStateManager$NetState, s);
        }

        public static NetState[] values()
        {
            NetState anetstate[] = ENUM$VALUES;
            int i = anetstate.length;
            NetState anetstate1[] = new NetState[i];
            System.arraycopy(anetstate, 0, anetstate1, 0, i);
            return anetstate1;
        }

        static 
        {
            Mobile = new NetState("Mobile", 0);
            WIFI = new NetState("WIFI", 1);
            NOWAY = new NetState("NOWAY", 2);
            ENUM$VALUES = (new NetState[] {
                Mobile, WIFI, NOWAY
            });
        }

        private NetState(String s, int i)
        {
            super(s, i);
        }
    }

}
