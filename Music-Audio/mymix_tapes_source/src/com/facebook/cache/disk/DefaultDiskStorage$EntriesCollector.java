// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.disk;

import com.facebook.common.file.FileTreeVisitor;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.facebook.cache.disk:
//            DefaultDiskStorage

private class <init>
    implements FileTreeVisitor
{

    private final List result;
    final DefaultDiskStorage this$0;

    public List getEntries()
    {
        return Collections.unmodifiableList(result);
    }

    public void postVisitDirectory(File file)
    {
    }

    public void preVisitDirectory(File file)
    {
    }

    public void visitFile(File file)
    {
        result result1 = DefaultDiskStorage.access$100(DefaultDiskStorage.this, file);
        if (result1 != null && result1._fld0 == this._fld0)
        {
            result.add(new result(DefaultDiskStorage.this, file, null));
        }
    }

    private A()
    {
        this$0 = DefaultDiskStorage.this;
        super();
        result = new ArrayList();
    }

    result(result result1)
    {
        this();
    }
}
