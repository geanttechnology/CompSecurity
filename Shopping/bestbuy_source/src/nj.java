// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class nj
{

    public static Object a(Context context, String s)
    {
        return (new ObjectInputStream(context.openFileInput(s))).readObject();
    }

    public static void a(Context context, String s, Object obj)
    {
        context = context.openFileOutput(s, 0);
        s = new ObjectOutputStream(context);
        s.writeObject(obj);
        s.close();
        context.close();
    }
}
