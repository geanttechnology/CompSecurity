// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Bundle;
import org.json.JSONException;

// Referenced classes of package android.support.v7:
//            jm

static final class tException
    implements tException
{

    public void a(Bundle bundle, String s, Object obj)
        throws JSONException
    {
        throw new IllegalArgumentException("Unexpected type from JSON");
    }

    tException()
    {
    }
}
