// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import bolts.Continuation;
import bolts.Task;

// Referenced classes of package com.parse:
//            ParseFile, Parse, GetDataCallback

public class ParseImageView extends ImageView
{

    private ParseFile file;
    private boolean isLoaded;
    private Drawable placeholder;

    public ParseImageView(Context context)
    {
        super(context);
        isLoaded = false;
    }

    public ParseImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        isLoaded = false;
    }

    public ParseImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        isLoaded = false;
    }

    public Task loadInBackground()
    {
        if (file == null)
        {
            return Task.forResult(null);
        } else
        {
            final ParseFile loadingFile = file;
            return file.getDataInBackground().onSuccessTask(new Continuation() {

                final ParseImageView this$0;
                final ParseFile val$loadingFile;

                public Task then(Task task)
                    throws Exception
                {
                    byte abyte0[] = (byte[])task.getResult();
                    Task task1;
                    if (file != loadingFile)
                    {
                        task1 = Task.cancelled();
                    } else
                    {
                        task1 = task;
                        if (abyte0 != null)
                        {
                            Bitmap bitmap = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
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

            
            {
                this$0 = ParseImageView.this;
                loadingFile = parsefile;
                super();
            }
            }, Task.UI_THREAD_EXECUTOR);
        }
    }

    public void loadInBackground(GetDataCallback getdatacallback)
    {
        Parse.callbackOnMainThreadAsync(loadInBackground(), getdatacallback, true);
    }

    protected void onDetachedFromWindow()
    {
        if (file != null)
        {
            file.cancel();
        }
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
        isLoaded = true;
    }

    public void setParseFile(ParseFile parsefile)
    {
        if (file != null)
        {
            file.cancel();
        }
        isLoaded = false;
        file = parsefile;
        setImageDrawable(placeholder);
    }

    public void setPlaceholder(Drawable drawable)
    {
        placeholder = drawable;
        if (!isLoaded)
        {
            setImageDrawable(placeholder);
        }
    }

}
