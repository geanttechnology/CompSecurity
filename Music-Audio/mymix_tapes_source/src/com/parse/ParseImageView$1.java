// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.graphics.BitmapFactory;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseImageView, ParseFile

class val.loadingFile
    implements Continuation
{

    final ParseImageView this$0;
    final ParseFile val$loadingFile;

    public Task then(Task task)
        throws Exception
    {
        byte abyte0[] = (byte[])task.getResult();
        Task task1;
        if (ParseImageView.access$000(ParseImageView.this) != val$loadingFile)
        {
            task1 = Task.cancelled();
        } else
        {
            task1 = task;
            if (abyte0 != null)
            {
                android.graphics.Bitmap bitmap = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
                task1 = task;
                if (bitmap != null)
                {
                    setImageBitmap(bitmap);
                    return task;
                }
            }
        }
        return task1;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ory()
    {
        this$0 = final_parseimageview;
        val$loadingFile = ParseFile.this;
        super();
    }
}
