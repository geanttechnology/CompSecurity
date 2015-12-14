// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.provider.BaseColumns;
import java.util.ArrayList;

public abstract class j
    implements BaseColumns
{

    private static String a[];

    public static String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("CREATE TABLE MakeupTemplateFileInfo (");
        stringbuilder.append(c());
        stringbuilder.append(");");
        return stringbuilder.toString();
    }

    public static String[] b()
    {
        if (a != null)
        {
            return a;
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add("Tid");
            arraylist.add("GUID");
            arraylist.add("Stamp");
            arraylist.add("FolderPath");
            arraylist.add("TemplateType");
            arraylist.add("PublishDate");
            arraylist.add("ExpiredDate");
            arraylist.add("IsNew");
            arraylist.add("Ext_1");
            arraylist.add("Ext_2");
            arraylist.add("Ext_3");
            arraylist.add("Ext_4");
            a = (String[])arraylist.toArray(new String[arraylist.size()]);
            return a;
        }
    }

    private static String c()
    {
        return "_id INTEGER PRIMARY KEY AUTOINCREMENT,Tid BIGINT,GUID TEXT,Stamp BIGINT,FolderPath TEXT,TemplateType INT,PublishDate BIGINT,ExpiredDate BIGINT,IsNew INT,Ext_1 TEXT,Ext_2 TEXT,Ext_3 INT,Ext_4 INT";
    }
}
