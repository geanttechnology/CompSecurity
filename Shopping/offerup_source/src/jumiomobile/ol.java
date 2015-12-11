// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Intent;
import com.jumio.netverify.sdk.core.ModelTemplate;

// Referenced classes of package jumiomobile:
//            ai, oa, ba, ob

class ol extends ai
{

    final oa e;

    private ol(oa oa1)
    {
        e = oa1;
        super();
    }

    ol(oa oa1, ob ob)
    {
        this(oa1);
    }

    protected transient Boolean a(Void avoid[])
    {
        return Boolean.TRUE;
    }

    protected void a(Boolean boolean1)
    {
        try
        {
            ba.a(oa.a(e).a).a(new Intent("com.jumio.netverify.sdk.ACTION_UPLOAD_FINISHED"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Boolean boolean1)
        {
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
