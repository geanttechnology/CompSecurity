// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.ct;
import android.support.v7.cu;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;

// Referenced classes of package com.parse:
//            ParseFile, ParseExecutors, ParseTaskUtils, GetDataCallback

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

    public cu loadInBackground()
    {
        if (file == null)
        {
            return cu.a(null);
        } else
        {
            final ParseFile loadingFile = file;
            return file.getDataInBackground().d(new ct() {

                final ParseImageView this$0;
                final ParseFile val$loadingFile;

                public cu then(cu cu1)
                    throws Exception
                {
                    byte abyte0[] = (byte[])cu1.e();
                    cu cu2;
                    if (file != loadingFile)
                    {
                        cu2 = cu.h();
                    } else
                    {
                        cu2 = cu1;
                        if (abyte0 != null)
                        {
                            Bitmap bitmap = BitmapFactoryInstrumentation.decodeByteArray(abyte0, 0, abyte0.length);
                            cu2 = cu1;
                            if (bitmap != null)
                            {
                                setImageBitmap(bitmap);
                                return cu1;
                            }
                        }
                    }
                    return cu2;
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseImageView.this;
                loadingFile = parsefile;
                super();
            }
            }, ParseExecutors.main());
        }
    }

    public void loadInBackground(GetDataCallback getdatacallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(loadInBackground(), getdatacallback, true);
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
