// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wjj.manager;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UnloadingResidueManager
{

    private List empty;
    private List packnamelist;
    private PackageManager pm;

    public UnloadingResidueManager(Context context)
    {
        pm = context.getPackageManager();
        empty = new ArrayList();
    }

    public List GGGfile(File file)
    {
        int i;
        int j;
        file = file.listFiles();
        j = file.length;
        i = 0;
_L2:
        File file1;
        if (i >= j)
        {
            return empty;
        }
        file1 = file[i];
        if (!file1.exists() || !file1.isDirectory())
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (file1.list().length > 0)
        {
            GGGfile(file1);
            break MISSING_BLOCK_LABEL_72;
        }
        try
        {
            empty.add(file1);
        }
        catch (Exception exception) { }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void delete(File file)
    {
        if (file.isFile())
        {
            file.delete();
        } else
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            if (afile == null || afile.length == 0)
            {
                file.delete();
                return;
            } else
            {
                file.delete();
                return;
            }
        }
    }
}
