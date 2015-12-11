// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java;

import android.content.Context;
import com.comcast.playerplatform.analytics.java.util.ObjectStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.playerplatform.analytics.java:
//            AnalyticsProvider

class 
    implements ObjectStream
{

    final Context val$appContext;
    final String val$fileName;

    public ObjectInputStream objectInputStream()
        throws IOException
    {
        ObjectInputStream objectinputstream = new ObjectInputStream(val$appContext.openFileInput(val$fileName));
        AnalyticsProvider.access$300().debug("objectInputStream created");
        return objectinputstream;
    }

    public ObjectOutputStream objectOutputStream()
        throws IOException
    {
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(val$appContext.openFileOutput(val$fileName, 0));
        AnalyticsProvider.access$300().debug("objectOutputStream created");
        return objectoutputstream;
    }
}
