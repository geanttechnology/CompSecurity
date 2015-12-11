// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Bundle;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package co.vine.android.api:
//            VineParsers

public static abstract class 
    implements 
{

    public abstract ArrayList parse(JsonParser jsonparser, Bundle bundle)
        throws IOException;

    public ()
    {
    }
}
