// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;

// Referenced classes of package com.parse:
//            ParseFile, ParseFileUtils

class >
    implements ct
{

    final ParseFile this$0;
    final boolean val$pinned;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Void then(cu cu)
        throws Exception
    {
        if (ParseFile.access$400(ParseFile.this).url() == null)
        {
            throw new IllegalStateException("Unable to pin file before saving");
        }
        if ((!val$pinned || !isPinned()) && (val$pinned || isPinned()))
        {
            File file;
            if (val$pinned)
            {
                file = getCacheFile();
                cu = getFilesFile();
            } else
            {
                file = getFilesFile();
                cu = getCacheFile();
            }
            if (cu.exists())
            {
                ParseFileUtils.deleteQuietly(cu);
            }
            if (val$pinned && data != null)
            {
                ParseFileUtils.writeByteArrayToFile(cu, data);
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
                ParseFileUtils.moveFile(file, cu);
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
