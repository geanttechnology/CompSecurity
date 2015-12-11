// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.sdk.SdkService;
import com.igexin.sdk.db.DBHelper;

// Referenced classes of package com.igexin.sdk.data:
//            DynamicConfig

public class ConfigDataManager
{

    private static String downloadUrl = null;
    private static boolean encryptEnable = false;
    private static String masterAppID = "so6J4ecxpZ8Fnq7AaaZdN";
    private static String masterPkgName = "com.amazon.pushservice";
    private static String masterServiceAction = "com.amazon.pushservice.start";

    public ConfigDataManager()
    {
    }

    public static String getDownloadUrl()
    {
        return downloadUrl;
    }

    public static boolean getEncryptEnable()
    {
        return encryptEnable;
    }

    public static String getMasterAppID()
    {
        return masterAppID;
    }

    public static String getMasterPkgName()
    {
        return masterPkgName;
    }

    public static String getMasterServiceAction()
    {
        return masterServiceAction;
    }

    public static void init()
    {
        read();
    }

    private static void read()
    {
        Cursor cursor = SdkService.getInstance().getDBHelper().getReadableDatabase().rawQuery("select id, value from config order by id", null);
        if (cursor != null)
        {
            do
            {
                if (!cursor.moveToNext())
                {
                    break;
                }
                int i = cursor.getInt(0);
                String s = cursor.getString(0 + 1);
                switch (i)
                {
                case 1: // '\001'
                    boolean flag;
                    if ("true".equals(s))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    encryptEnable = flag;
                    break;

                case 2: // '\002'
                    if (!s.equals("null"))
                    {
                        downloadUrl = s;
                    }
                    break;

                case 3: // '\003'
                    if (!s.equals("null"))
                    {
                        masterPkgName = s;
                    }
                    break;

                case 4: // '\004'
                    if (!s.equals("null"))
                    {
                        masterAppID = s;
                    }
                    break;

                case 5: // '\005'
                    if (!s.equals("null"))
                    {
                        masterServiceAction = s;
                    }
                    break;
                }
            } while (true);
            cursor.close();
        }
    }

    public static void setDownloadUrl(String s)
    {
        downloadUrl = s;
    }

    public static void setEncryptEnable(boolean flag)
    {
        encryptEnable = flag;
    }

    public static void setMasterAppID(String s)
    {
        masterAppID = s;
    }

    public static void setMasterPkgName(String s)
    {
        masterPkgName = s;
    }

    public static void setMasterServiceAction(String s)
    {
        masterServiceAction = s;
    }

    public static void updateDBValue(int i, String s, String s1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("id", Integer.valueOf(i));
        contentvalues.put("name", s);
        contentvalues.put("value", s1);
        SdkService.getInstance().getDBHelper().getWritableDatabase().replace("config", null, contentvalues);
    }

    public static void write(DynamicConfig dynamicconfig)
    {
        String s;
        if (dynamicconfig.isEncrypt())
        {
            s = "true";
        } else
        {
            s = "false";
        }
        updateDBValue(1, "encrypt", s);
        if (dynamicconfig.getDownloadUrl() != null)
        {
            updateDBValue(2, "downloadUrl", dynamicconfig.getDownloadUrl());
        }
        if (dynamicconfig.getMasterPkgName() != null)
        {
            updateDBValue(3, "masterPkgName", dynamicconfig.getMasterPkgName());
        }
        if (dynamicconfig.getMasterAppID() != null)
        {
            updateDBValue(4, "masterAppID", dynamicconfig.getMasterAppID());
        }
        if (dynamicconfig.getMasterServiceAction() != null)
        {
            updateDBValue(5, "masterServiceAction", dynamicconfig.getMasterServiceAction());
        }
    }

}
