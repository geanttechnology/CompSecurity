// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.design.widget.al;
import android.support.v4.b.f;
import android.support.v4.b.g;
import android.support.v4.e.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;

final class az
    implements g
{

    final int a;
    al b;
    f c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;
    boolean h;
    boolean i;
    private Bundle j;
    private boolean k;
    private Object l;
    private boolean m;

    final void a()
    {
        e = false;
        if (!f && c != null && i)
        {
            i = false;
            c.a(this);
            c.c(this);
            c.b();
        }
    }

    public final void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s);
        printwriter.print("mId=");
        printwriter.print(a);
        printwriter.print(" mArgs=");
        printwriter.println(j);
        printwriter.print(s);
        printwriter.print("mCallbacks=");
        printwriter.println(null);
        printwriter.print(s);
        printwriter.print("mLoader=");
        printwriter.println(c);
        if (c != null)
        {
            c.a((new StringBuilder()).append(s).append("  ").toString(), printwriter);
        }
        if (d)
        {
            printwriter.print(s);
            printwriter.print("mHaveData=");
            printwriter.print(false);
            printwriter.print("  mDeliveredData=");
            printwriter.println(d);
            printwriter.print(s);
            printwriter.print("mData=");
            printwriter.println(null);
        }
        printwriter.print(s);
        printwriter.print("mStarted=");
        printwriter.print(e);
        printwriter.print(" mReportNextStart=");
        printwriter.print(h);
        printwriter.print(" mDestroyed=");
        printwriter.println(m);
        printwriter.print(s);
        printwriter.print("mRetaining=");
        printwriter.print(f);
        printwriter.print(" mRetainingStarted=");
        printwriter.print(g);
        printwriter.print(" mListenerRegistered=");
        printwriter.println(i);
    }

    final void b()
    {
        m = true;
        d = false;
        b = null;
        l = null;
        k = false;
        if (c != null)
        {
            if (i)
            {
                i = false;
                c.a(this);
                c.c(this);
            }
            c.c();
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append("LoaderInfo{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" #");
        stringbuilder.append(a);
        stringbuilder.append(" : ");
        android.support.v4.e.a.a(c, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }
}
