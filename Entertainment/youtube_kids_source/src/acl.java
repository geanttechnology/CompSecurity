// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Base64;
import android.util.SparseArray;
import java.nio.charset.Charset;

public final class acl
    implements cog
{

    public static final cog a = new acl();

    public acl()
    {
    }

    public final byte[] a()
    {
        return "AI39si6t7CpwCocT8WJah1apdDQRNxG-Go6wptv5FSowSWeKSIgRlyclGUnfjETUw2MUVCAAj95wxOPcnxsNP5kZ1noDqdfSSg".getBytes(Charset.forName("UTF-8"));
    }

    public final byte[] b()
    {
        return "MgZNg61RkArxX9c6iYU4xQ==".getBytes(Charset.forName("UTF-8"));
    }

    public final String c()
    {
        return "AIzaSyAxxQKWYcEX8jHlflLt2Qcbb-rlolzBhhk";
    }

    public final SparseArray d()
    {
        SparseArray sparsearray = new SparseArray();
        sparsearray.put(0, Base64.decode("oqJfa3AXNOuKcxa2L1vHKG/1/k/9ApQYVIQ2ilX1eqc=", 0));
        sparsearray.put(1, Base64.decode("nhIzwvKscHWOBIGcrC5c4TxXbEmuk3O9o9iAU0jeHpc=", 0));
        return sparsearray;
    }

}
