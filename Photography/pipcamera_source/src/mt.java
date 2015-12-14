// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import com.fotoable.comlib.util.AsyncTask;

public class mt extends fq
{

    private Context f;

    public mt(Context context, int i)
    {
        super(context, i);
        a(context);
    }

    private void a(Context context)
    {
        f = context;
        e = AsyncTask.SERIAL_EXECUTOR;
    }

    protected Bitmap a(Object obj)
    {
        if (obj instanceof nu)
        {
            return ((nu)obj).a(f, a, b);
        }
        if (!(obj instanceof nr))
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj = ((nr)obj).a(f, a, b);
        return ((Bitmap) (obj));
        obj;
        return null;
    }

    protected String b(Object obj)
    {
        if (obj instanceof nr)
        {
            obj = (nr)obj;
            return (new StringBuilder()).append(((nr) (obj)).j()).append(b).append(a).toString();
        } else
        {
            return String.valueOf(obj);
        }
    }
}
