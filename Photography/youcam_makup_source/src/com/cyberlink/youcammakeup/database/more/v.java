// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.provider.BaseColumns;

public abstract class v
    implements BaseColumns
{

    public static String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("CREATE TABLE TemplateFileInfo (");
        stringbuilder.append(b());
        stringbuilder.append(");");
        return stringbuilder.toString();
    }

    private static String b()
    {
        return "_id INTEGER PRIMARY KEY AUTOINCREMENT,Tid BIGINT,Stamp BIGINT,FolderPath TEXT,TemplateType TEXT,CollageType TEXT,CollageLayout TEXT,CollageSourceAmount INT";
    }
}
