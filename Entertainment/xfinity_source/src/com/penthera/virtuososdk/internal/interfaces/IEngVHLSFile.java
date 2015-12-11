// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.internal.interfaces;

import android.content.ContentResolver;
import android.content.Context;
import com.penthera.virtuososdk.client.IVirtuosoHLSFile;
import java.util.List;

// Referenced classes of package com.penthera.virtuososdk.internal.interfaces:
//            IEngVIdentifier, IEngFileFragment

public interface IEngVHLSFile
    extends IVirtuosoHLSFile, IEngVIdentifier
{

    public abstract List pendingFragments(Context context);

    public abstract void regenerateFilePath(ContentResolver contentresolver, String s, Context context);

    public abstract void setCompletedCount(int i);

    public abstract void setCurrentSize(double d);

    public abstract void setLocalBaseDir(String s);

    public abstract void setPending(boolean flag);

    public abstract boolean updateFragment(Context context, IEngFileFragment iengfilefragment);
}
