// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.print;

import android.net.Uri;
import java.io.FileNotFoundException;

// Referenced classes of package android.support.v4.print:
//            PrintHelper

static interface A
{

    public abstract void printBitmap(String s, Uri uri, A a)
        throws FileNotFoundException;
}
