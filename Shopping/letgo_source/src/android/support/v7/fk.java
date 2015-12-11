// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.AsyncTask;
import com.abtnprojects.ambatana.datasource.entities.mapper.AddressMapper;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.ui.activities.profile.EditLocationActivity;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7:
//            aqo, di, dz, eo, 
//            ajx

public class fk extends AsyncTask
{

    private final WeakReference a;
    private final String b;
    private final String c;

    public fk(EditLocationActivity editlocationactivity, String s, String s1)
    {
        b = s;
        c = s1;
        a = new WeakReference(editlocationactivity);
    }

    protected transient LetgoAddress a(Void avoid[])
    {
        aqo.a((new StringBuilder()).append("placeId").append(b).toString(), new Object[0]);
        avoid = (new di(c)).a(b);
        if (avoid != null)
        {
            return (new AddressMapper()).fromJsonObjectAddress(avoid, "UserManual");
        } else
        {
            return null;
        }
    }

    protected void a(LetgoAddress letgoaddress)
    {
        if (a != null)
        {
            EditLocationActivity editlocationactivity = (EditLocationActivity)a.get();
            if (editlocationactivity != null && !editlocationactivity.isFinishing())
            {
                editlocationactivity.b(letgoaddress);
            }
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((LetgoAddress)obj);
    }

    protected void onPreExecute()
    {
        dz.a().a(new eo());
    }
}
