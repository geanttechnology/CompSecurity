// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.stericson.RootTools:
//            RootTools, Mount, InternalVariables, InternalMethods

class Remounter
{

    Remounter()
    {
    }

    private Mount findMountPointRecursive(String s)
    {
        ArrayList arraylist;
        Iterator iterator;
        Mount mount;
        boolean flag;
        try
        {
            arraylist = RootTools.getMounts();
            s = new File(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (RootTools.debugMode)
            {
                s.printStackTrace();
            }
            return null;
        }
          goto _L1
_L6:
        iterator = arraylist.iterator();
_L4:
        if (!iterator.hasNext()) goto _L1; else goto _L2
_L2:
        mount = (Mount)iterator.next();
        flag = mount.getMountPoint().equals(s);
        if (!flag) goto _L4; else goto _L3
_L3:
        return mount;
_L1:
        if (s == null)
        {
            return null;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected boolean remount(String s, String s1)
    {
        String s2 = "";
        if (!RootTools.checkUtil("busybox")) goto _L2; else goto _L1
_L1:
        s2 = RootTools.utilPath;
_L12:
        String s3;
        boolean flag;
        s3 = s;
        if (s.endsWith("/"))
        {
            s3 = s.substring(0, s.lastIndexOf("/"));
        }
        flag = false;
_L7:
        if (flag)
        {
            Mount mount = findMountPointRecursive(s3);
            Log.i(InternalVariables.TAG, (new StringBuilder("Remounting ")).append(mount.getMountPoint().getAbsolutePath()).append(" as ").append(s1.toLowerCase()).toString());
            s = mount;
            if (!mount.getFlags().contains(s1.toLowerCase()))
            {
                boolean flag1;
                boolean flag2;
                try
                {
                    (new InternalMethods()).doExec(new String[] {
                        String.format((new StringBuilder(String.valueOf(s2))).append(" mount -o remount,%s %s %s").toString(), new Object[] {
                            s1.toLowerCase(), mount.getDevice().getAbsolutePath(), mount.getMountPoint().getAbsolutePath()
                        }), String.format("mount -o remount,%s %s %s", new Object[] {
                            s1.toLowerCase(), mount.getDevice().getAbsolutePath(), mount.getMountPoint().getAbsolutePath()
                        }), String.format("/system/bin/toolbox mount -o remount,%s %s %s", new Object[] {
                            s1.toLowerCase(), mount.getDevice().getAbsolutePath(), mount.getMountPoint().getAbsolutePath()
                        })
                    }, -1);
                }
                // Misplaced declaration of an exception variable
                catch (String s) { }
                s = findMountPointRecursive(s3);
            }
            Log.i(InternalVariables.TAG, (new StringBuilder()).append(s.getFlags()).append(" AND ").append(s1.toLowerCase()).toString());
            if (s.getFlags().contains(s1.toLowerCase()))
            {
                RootTools.log(s.getFlags().toString());
                return true;
            } else
            {
                RootTools.log(s.getFlags().toString());
                return false;
            }
        }
          goto _L3
_L2:
        if (RootTools.checkUtil("toolbox"))
        {
            s2 = RootTools.utilPath;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        s = RootTools.getMounts().iterator();
_L9:
        flag2 = s.hasNext();
        if (flag2) goto _L5; else goto _L4
_L4:
        flag1 = flag;
_L10:
        flag = flag1;
        if (flag1) goto _L7; else goto _L6
_L6:
        s3 = (new File(s3)).getParent().toString();
        flag = flag1;
          goto _L7
_L5:
        try
        {
            mount = (Mount)s.next();
            RootTools.log(mount.getMountPoint().toString());
            flag2 = s3.equals(mount.getMountPoint().toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (RootTools.debugMode)
            {
                s.printStackTrace();
            }
            return false;
        }
        if (!flag2) goto _L9; else goto _L8
_L8:
        flag1 = true;
          goto _L10
        s;
        s.printStackTrace();
        return false;
        if (true) goto _L12; else goto _L11
_L11:
    }
}
