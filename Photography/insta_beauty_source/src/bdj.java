// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import com.google.gson.Gson;
import com.instamag.activity.library.model.TResTypeManager;
import java.util.ArrayList;

public class bdj extends AsyncTask
{

    final TResTypeManager a;
    private ArrayList b;

    public bdj(TResTypeManager trestypemanager, ArrayList arraylist)
    {
        a = trestypemanager;
        super();
        b = null;
        b = arraylist;
    }

    protected transient Void a(Void avoid[])
    {
        if (b != null && b.size() > 0)
        {
            avoid = new Gson();
            try
            {
                avoid = avoid.toJson(b);
                TResTypeManager.access$300(a).a(TResTypeManager.access$200(), avoid, new cer());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                Crashlytics.logException(avoid);
            }
        }
        return null;
    }

    protected void a(Void void1)
    {
        super.onPostExecute(void1);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }
}
