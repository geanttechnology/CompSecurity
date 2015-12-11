// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.TypedValue;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            MetricCategory

public class BitmapFactoryInstrumentation
{

    private static final ArrayList categoryParams = new ArrayList(Arrays.asList(new String[] {
        "category", com/newrelic/agent/android/instrumentation/MetricCategory.getName(), "IMAGE"
    }));

    private BitmapFactoryInstrumentation()
    {
    }

    public static Bitmap decodeByteArray(byte abyte0[], int i, int j)
    {
        TraceMachine.enterMethod("BitmapFactory#decodeByteArray", categoryParams);
        abyte0 = BitmapFactory.decodeByteArray(abyte0, i, j);
        TraceMachine.exitMethod();
        return abyte0;
    }

    public static Bitmap decodeByteArray(byte abyte0[], int i, int j, android.graphics.BitmapFactory.Options options)
    {
        TraceMachine.enterMethod("BitmapFactory#decodeByteArray", categoryParams);
        abyte0 = BitmapFactory.decodeByteArray(abyte0, i, j, options);
        TraceMachine.exitMethod();
        return abyte0;
    }

    public static Bitmap decodeFile(String s)
    {
        TraceMachine.enterMethod("BitmapFactory#decodeFile", categoryParams);
        s = BitmapFactory.decodeFile(s);
        TraceMachine.exitMethod();
        return s;
    }

    public static Bitmap decodeFile(String s, android.graphics.BitmapFactory.Options options)
    {
        TraceMachine.enterMethod("BitmapFactory#decodeFile", categoryParams);
        s = BitmapFactory.decodeFile(s, options);
        TraceMachine.exitMethod();
        return s;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor filedescriptor)
    {
        TraceMachine.enterMethod("BitmapFactory#decodeFileDescriptor", categoryParams);
        filedescriptor = BitmapFactory.decodeFileDescriptor(filedescriptor);
        TraceMachine.exitMethod();
        return filedescriptor;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor filedescriptor, Rect rect, android.graphics.BitmapFactory.Options options)
    {
        TraceMachine.enterMethod("BitmapFactory#decodeFileDescriptor", categoryParams);
        filedescriptor = BitmapFactory.decodeFileDescriptor(filedescriptor, rect, options);
        TraceMachine.exitMethod();
        return filedescriptor;
    }

    public static Bitmap decodeResource(Resources resources, int i)
    {
        TraceMachine.enterMethod("BitmapFactory#decodeResource", categoryParams);
        resources = BitmapFactory.decodeResource(resources, i);
        TraceMachine.exitMethod();
        return resources;
    }

    public static Bitmap decodeResource(Resources resources, int i, android.graphics.BitmapFactory.Options options)
    {
        TraceMachine.enterMethod("BitmapFactory#decodeResource", categoryParams);
        resources = BitmapFactory.decodeResource(resources, i, options);
        TraceMachine.exitMethod();
        return resources;
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedvalue, InputStream inputstream, Rect rect, android.graphics.BitmapFactory.Options options)
    {
        TraceMachine.enterMethod("BitmapFactory#decodeResourceStream", categoryParams);
        resources = BitmapFactory.decodeResourceStream(resources, typedvalue, inputstream, rect, options);
        TraceMachine.exitMethod();
        return resources;
    }

    public static Bitmap decodeStream(InputStream inputstream)
    {
        TraceMachine.enterMethod("BitmapFactory#decodeStream", categoryParams);
        inputstream = BitmapFactory.decodeStream(inputstream);
        TraceMachine.exitMethod();
        return inputstream;
    }

    public static Bitmap decodeStream(InputStream inputstream, Rect rect, android.graphics.BitmapFactory.Options options)
    {
        TraceMachine.enterMethod("BitmapFactory#decodeStream", categoryParams);
        inputstream = BitmapFactory.decodeStream(inputstream, rect, options);
        TraceMachine.exitMethod();
        return inputstream;
    }

}
