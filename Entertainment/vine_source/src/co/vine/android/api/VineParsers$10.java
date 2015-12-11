// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import android.os.Bundle;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

// Referenced classes of package co.vine.android.api:
//            VineParsers, VinePrivateMessage

static final class er extends ordParser
{

    public VinePrivateMessage parse(JsonParser jsonparser, Bundle bundle)
        throws IOException
    {
        return VineParsers.parsePrivateMessage(jsonparser);
    }

    public volatile Object parse(JsonParser jsonparser, Bundle bundle)
        throws IOException
    {
        return parse(jsonparser, bundle);
    }

    er()
    {
    }
}
