// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.io.File;

// Referenced classes of package com.parse:
//            ParseFile, ParseFileUtils

class >
    implements Continuation
{

    final ParseFile this$0;
    final boolean val$pinned;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        if ((!val$pinned || !isPinned()) && (val$pinned || isPinned()))
        {
            File file;
            if (val$pinned)
            {
                file = getCacheFile();
                task = getFilesFile();
            } else
            {
                file = getFilesFile();
                task = getCacheFile();
            }
            if (task == null)
            {
                throw new IllegalStateException("Unable to pin file before saving");
            }
            if (task.exists())
            {
                ParseFileUtils.deleteQuietly(task);
            }
            if (val$pinned && data != null)
            {
                ParseFileUtils.writeByteArrayToFile(task, data);
                if (file.exists())
                {
                    ParseFileUtils.deleteQuietly(file);
                    return null;
                }
            } else
            if (file == null || !file.exists())
            {
                throw new IllegalStateException("Unable to pin file before retrieving");
            } else
            {
                ParseFileUtils.moveFile(file, task);
                return null;
            }
        }
        return null;
    }

    ls()
    {
        this$0 = final_parsefile;
        val$pinned = Z.this;
        super();
    }
}
