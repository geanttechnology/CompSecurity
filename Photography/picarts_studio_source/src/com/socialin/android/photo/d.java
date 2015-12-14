// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo;

import com.picsart.studio.ItemType;
import com.socialin.android.constants.CommonConstants;
import java.io.File;
import java.io.FileFilter;

public final class d
    implements FileFilter
{

    private ItemType a;

    public d(ItemType itemtype)
    {
        a = itemtype;
        super();
    }

    public final boolean accept(File file)
    {
        file = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(File.separator) + 1);
        return (file.startsWith(CommonConstants.b[a.getValue()]) || file.startsWith((new StringBuilder("i_")).append(CommonConstants.b[a.getValue()]).toString())) && !file.endsWith(".tmp");
    }
}
