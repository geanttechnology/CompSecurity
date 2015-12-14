// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.project;

import com.socialin.android.d;
import com.socialin.android.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

// Referenced classes of package com.socialin.android.brushlib.project:
//            a

public class Project
    implements Serializable
{

    private static final String TAG = com/socialin/android/brushlib/project/Project.getSimpleName();
    private static final long serialVersionUID = 1L;
    private boolean containsActions;
    private boolean isDraft;
    private File rootFolder;

    public Project(File file, boolean flag)
    {
        rootFolder = file;
        isDraft = flag;
        setProjectRoot(rootFolder);
    }

    public boolean containsActions()
    {
        return containsActions;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Project)
        {
            obj = (Project)obj;
            flag = flag1;
            if (((Project) (obj)).isDraft == isDraft)
            {
                flag = flag1;
                if (((Project) (obj)).rootFolder.equals(rootFolder))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public File getActionsFile()
    {
        rootFolder.mkdirs();
        File file = new File(rootFolder, "actions.vnf");
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException ioexception)
            {
                d.b(TAG, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
                });
                return file;
            }
        }
        return file;
    }

    public File getActionsInfoFile()
    {
        rootFolder.mkdirs();
        File file = new File(rootFolder, "actionsinfo.vnf");
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException ioexception)
            {
                d.b(TAG, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
                });
                return file;
            }
        }
        return file;
    }

    public String getDisplayName()
    {
        return rootFolder.getName();
    }

    public File getImageDataFolder()
    {
        File file = new File(rootFolder, "image-data");
        file.mkdirs();
        return file;
    }

    public File getIndexFile()
    {
        return new File(rootFolder, "INDEX");
    }

    public File getLayerOrigBuffersFolder()
    {
        if (containsActions)
        {
            File file = new File(rootFolder, "orig-buffers");
            file.mkdirs();
            return file;
        } else
        {
            return getRootFolder();
        }
    }

    public File getLayersInfoFile()
    {
        File file = new File(getLayerOrigBuffersFolder(), "layers.info");
        try
        {
            file.createNewFile();
        }
        catch (IOException ioexception)
        {
            d.b(TAG, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
            });
            return file;
        }
        return file;
    }

    public String getName()
    {
        return rootFolder.getName();
    }

    public File getRootFolder()
    {
        return rootFolder;
    }

    public long getSizeInBytes()
    {
        return FileUtils.g(rootFolder);
    }

    public File getTmpFolder()
    {
        File file = new File(rootFolder, "tmp");
        file.mkdirs();
        return file;
    }

    public int hashCode()
    {
        int j = rootFolder.hashCode();
        int i;
        if (isDraft)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + j * 31;
    }

    public boolean isDraft()
    {
        return isDraft;
    }

    public boolean isValid()
    {
        return a.a(rootFolder);
    }

    public boolean rename(String s)
    {
        s = new File(rootFolder.getParentFile(), s);
        if (rootFolder.renameTo(s))
        {
            setProjectRoot(s);
            return true;
        } else
        {
            return false;
        }
    }

    public void setDraft(boolean flag)
    {
        isDraft = flag;
    }

    public void setProjectRoot(File file)
    {
        rootFolder = file;
        boolean flag;
        if (!rootFolder.exists() || (new File(rootFolder, "actions.vnf")).exists())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        containsActions = flag;
        rootFolder.mkdirs();
    }

}
