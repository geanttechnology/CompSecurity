// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.AsyncTask;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.ui.activities.profile.EditLocationActivity;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7:
//            io

public class fv extends AsyncTask
{

    private final WeakReference a;
    private final LetgoAddress b;

    public fv(EditLocationActivity editlocationactivity, LetgoAddress letgoaddress)
    {
        a = new WeakReference(editlocationactivity);
        b = letgoaddress;
    }

    protected transient Boolean a(Void avoid[])
    {
        io.a(b);
        return Boolean.valueOf(true);
    }

    protected void a(Boolean boolean1)
    {
        boolean1 = (EditLocationActivity)a.get();
        if (boolean1 != null)
        {
            boolean1.D();
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

    protected void onPreExecute()
    {
    }
}
