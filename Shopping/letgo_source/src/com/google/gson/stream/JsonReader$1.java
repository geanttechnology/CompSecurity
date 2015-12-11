// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.stream;

import android.support.v7.afw;
import android.support.v7.agh;
import java.io.IOException;

// Referenced classes of package com.google.gson.stream:
//            JsonReader

static final class  extends afw
{

    public void promoteNameToValue(JsonReader jsonreader)
        throws IOException
    {
        if (jsonreader instanceof agh)
        {
            ((agh)jsonreader).a();
            return;
        }
        int j = JsonReader.access$000(jsonreader);
        int i = j;
        if (j == 0)
        {
            i = JsonReader.access$100(jsonreader);
        }
        if (i == 13)
        {
            JsonReader.access$002(jsonreader, 9);
            return;
        }
        if (i == 12)
        {
            JsonReader.access$002(jsonreader, 8);
            return;
        }
        if (i == 14)
        {
            JsonReader.access$002(jsonreader, 10);
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected a name but was ").append(jsonreader.peek()).append(" ").append(" at line ").append(JsonReader.access$200(jsonreader)).append(" column ").append(JsonReader.access$300(jsonreader)).append(" path ").append(jsonreader.getPath()).toString());
        }
    }

    ()
    {
    }
}
