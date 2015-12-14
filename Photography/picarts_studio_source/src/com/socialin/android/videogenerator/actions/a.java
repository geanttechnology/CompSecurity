// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import com.socialin.android.d;
import com.socialin.android.util.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            Action, b

public class a
{

    public static final String a = com/socialin/android/videogenerator/actions/a.getSimpleName();
    private static int e = 0;
    public ObjectOutputStream b;
    private File c;
    private ObjectInputStream d;

    public a(File file)
    {
        c = file;
    }

    private Action e()
    {
        Action action;
        boolean flag;
        flag = false;
        action = null;
_L2:
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        Action action1;
        b();
        if (d.skipBytes(e) == 0)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        action1 = (Action)d.readObject();
        flag = true;
        action = action1;
        continue; /* Loop/switch isn't completed */
        flag = true;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        if (exception instanceof OptionalDataException)
        {
            flag = true;
        }
        d();
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
        if (true) goto _L2; else goto _L1
_L1:
        return action;
    }

    public final boolean a()
    {
        if (FileUtils.g(c) != 0L)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        b = new ObjectOutputStream(new FileOutputStream(c));
        return true;
        try
        {
            b = new b(new FileOutputStream(c, true));
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
            });
            return false;
        }
        return true;
    }

    public final boolean a(Action action)
    {
        if (b != null)
        {
            try
            {
                b.writeObject(action);
            }
            // Misplaced declaration of an exception variable
            catch (Action action)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(action.getMessage()).toString()
                });
                return false;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean b()
    {
        try
        {
            d = new ObjectInputStream(new FileInputStream(c));
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
            });
            return false;
        }
        return true;
    }

    public final Action c()
    {
        Action action;
        try
        {
            e += d.available();
            action = (Action)d.readObject();
        }
        catch (Exception exception)
        {
            if (exception instanceof StreamCorruptedException)
            {
                d();
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
                return e();
            } else
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
                return null;
            }
        }
        return action;
    }

    public final void d()
    {
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        d.close();
        return;
        IOException ioexception;
        ioexception;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
        });
        return;
    }

}
