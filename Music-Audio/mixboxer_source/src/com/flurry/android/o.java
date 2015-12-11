// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.text.TextUtils;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.flurry.android:
//            aw, an, fl, cy, 
//            fs

final class o
{

    private static final Set P;
    private static final String p = com/flurry/android/o.getName();

    o()
    {
    }

    public static String a(Context context)
    {
        boolean flag = false;
        if (context != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if (context != null) goto _L4; else goto _L3
_L3:
        Object obj = null;
_L7:
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return ((String) (obj));
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (!TextUtils.isEmpty(((CharSequence) (obj)))) goto _L6; else goto _L5
_L5:
        if (!flag)
        {
            obj = null;
        } else
        {
            obj = (new StringBuilder()).append("AND").append(((String) (obj))).toString();
        }
        if (true) goto _L7; else goto _L6
_L6:
        String s = ((String) (obj)).toLowerCase(Locale.US);
        if (!P.contains(s))
        {
            flag = true;
        }
          goto _L5
        if (context == null) goto _L1; else goto _L8
_L8:
        Object obj1;
        obj = b(context);
        obj1 = obj;
        if (!TextUtils.isEmpty(((CharSequence) (obj)))) goto _L10; else goto _L9
_L9:
        obj1 = c(context);
        obj = obj1;
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            if (context == null)
            {
                obj = null;
            } else
            {
                long l = Double.doubleToLongBits(Math.random());
                long l1 = System.nanoTime();
                long l2 = aw.j(context).hashCode() * 37;
                obj = (new StringBuilder()).append("ID").append(Long.toString(l + 37L * (l1 + l2), 16)).toString();
            }
        }
        obj1 = obj;
        if (context == null) goto _L10; else goto _L11
_L11:
        if (!TextUtils.isEmpty(((CharSequence) (obj)))) goto _L13; else goto _L12
_L12:
        obj1 = obj;
_L10:
        return ((String) (obj1));
_L13:
        context = context.getFileStreamPath(".flurryb.");
        obj1 = obj;
        if (!an.a(context)) goto _L10; else goto _L14
_L14:
        obj1 = new DataOutputStream(new FileOutputStream(context));
        context = ((Context) (obj1));
        ((DataOutput) (obj1)).writeInt(1);
        context = ((Context) (obj1));
        ((DataOutput) (obj1)).writeUTF(((String) (obj)));
        fl.a(((java.io.Closeable) (obj1)));
        obj1 = obj;
          goto _L10
        Throwable throwable;
        throwable;
        obj1 = null;
_L17:
        context = ((Context) (obj1));
        cy.a(6, p, "Error when saving phoneId", throwable);
        fl.a(((java.io.Closeable) (obj1)));
        obj1 = obj;
          goto _L10
        Exception exception;
        exception;
        context = null;
_L16:
        fl.a(context);
        throw exception;
        exception;
        if (true) goto _L16; else goto _L15
_L15:
        throwable;
          goto _L17
    }

    private static String b(Context context)
    {
        Object obj1 = null;
        if (context != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        if ((context = context.getFileStreamPath(".flurryb.")) == null || !context.exists()) goto _L1; else goto _L3
_L3:
        Object obj = new DataInputStream(new FileInputStream(context));
        context = ((Context) (obj));
        int i = ((DataInput) (obj)).readInt();
        if (1 == i) goto _L5; else goto _L4
_L4:
        context = ((Context) (obj1));
_L7:
        fl.a(((java.io.Closeable) (obj)));
        return context;
_L5:
        context = ((Context) (obj));
        obj1 = ((DataInput) (obj)).readUTF();
        context = ((Context) (obj1));
        if (true) goto _L7; else goto _L6
_L6:
        Object obj2;
        obj2;
        obj = null;
_L11:
        context = ((Context) (obj));
        cy.a(6, p, "Error when loading phoneId", ((Throwable) (obj2)));
        fl.a(((java.io.Closeable) (obj)));
        return null;
        context;
        obj2 = null;
        obj = context;
_L9:
        fl.a(((java.io.Closeable) (obj2)));
        throw obj;
        obj;
        obj2 = context;
        if (true) goto _L9; else goto _L8
_L8:
        obj2;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private static String c(Context context)
    {
        Object obj1 = null;
        if (context != null) goto _L2; else goto _L1
_L1:
        Object obj;
        return null;
_L2:
        String as[];
        if ((obj = context.getFilesDir()) == null || ((as = ((File) (obj)).list(new fs())) == null || as.length == 0) || ((context = context.getFileStreamPath(as[0])) == null || !context.exists())) goto _L1; else goto _L3
_L3:
        as = new DataInputStream(new FileInputStream(context));
        context = as;
        int i = as.readUnsignedShort();
        if (46586 == i) goto _L5; else goto _L4
_L4:
        fl.a(as);
        return ((String) (obj1));
_L5:
        context = as;
        if (2 != as.readUnsignedShort())
        {
            continue; /* Loop/switch isn't completed */
        }
        context = as;
        as.readUTF();
        context = as;
        obj1 = as.readUTF();
        if (true) goto _L4; else goto _L6
_L6:
        Object obj2;
        obj2;
        as = null;
_L10:
        context = as;
        cy.a(6, p, "Error when loading phoneId", ((Throwable) (obj2)));
        fl.a(as);
        return null;
        context;
        obj2 = null;
        as = context;
_L8:
        fl.a(((java.io.Closeable) (obj2)));
        throw as;
        as;
        obj2 = context;
        if (true) goto _L8; else goto _L7
_L7:
        obj2;
        if (true) goto _L10; else goto _L9
_L9:
    }

    static 
    {
        HashSet hashset = new HashSet();
        hashset.add("null");
        hashset.add("9774d56d682e549c");
        hashset.add("dead00beef");
        P = Collections.unmodifiableSet(hashset);
    }
}
