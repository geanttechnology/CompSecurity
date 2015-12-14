// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;

import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.Clock;
import java.io.File;

// Referenced classes of package com.facebook.cache.disk:
//            DefaultDiskStorage

private class <init>
    implements FileTreeVisitor
{

    private boolean insideBaseDirectory;
    final DefaultDiskStorage this$0;

    private boolean isExpectedFile(File file)
    {
        boolean flag = false;
        <init> <init>1 = DefaultDiskStorage.access$100(DefaultDiskStorage.this, file);
        if (<init>1 == null)
        {
            return false;
        }
        if (<init>1._fld0 == this._fld0)
        {
            return isRecentFile(file);
        }
        if (<init>1.isRecentFile == T)
        {
            flag = true;
        }
        Preconditions.checkState(flag);
        return true;
    }

    private boolean isRecentFile(File file)
    {
        return file.lastModified() > DefaultDiskStorage.access$500(DefaultDiskStorage.this).now() - DefaultDiskStorage.TEMP_FILE_LIFETIME_MS;
    }

    public void postVisitDirectory(File file)
    {
        if (!DefaultDiskStorage.access$400(DefaultDiskStorage.this).equals(file) && !insideBaseDirectory)
        {
            file.delete();
        }
        if (insideBaseDirectory && file.equals(DefaultDiskStorage.access$300(DefaultDiskStorage.this)))
        {
            insideBaseDirectory = false;
        }
    }

    public void preVisitDirectory(File file)
    {
        if (!insideBaseDirectory && file.equals(DefaultDiskStorage.access$300(DefaultDiskStorage.this)))
        {
            insideBaseDirectory = true;
        }
    }

    public void visitFile(File file)
    {
        if (!insideBaseDirectory || !isExpectedFile(file))
        {
            file.delete();
        }
    }

    private ()
    {
        this$0 = DefaultDiskStorage.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
