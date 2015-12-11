// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package co.vine.android.network:
//            HttpResult

public interface HttpOperationReader
{

    public abstract void onHandleError(HttpResult httpresult);

    public abstract void readInput(int i, int j, InputStream inputstream)
        throws IOException;
}
