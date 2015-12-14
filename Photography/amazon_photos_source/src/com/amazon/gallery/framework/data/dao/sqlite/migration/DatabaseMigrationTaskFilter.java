// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            DatabaseMigrationTask

public interface DatabaseMigrationTaskFilter
{

    public abstract boolean doesTaskMatchFilter(DatabaseMigrationTask databasemigrationtask);
}
