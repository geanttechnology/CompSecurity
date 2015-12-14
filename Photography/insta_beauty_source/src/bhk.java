// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import com.google.gson.Gson;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import java.util.List;

public class bhk extends AsyncTask
{

    final TPhotoMagComposeManager a;
    private List b;

    public bhk(TPhotoMagComposeManager tphotomagcomposemanager, List list)
    {
        a = tphotomagcomposemanager;
        super();
        b = null;
        b = list;
    }

    protected transient Void a(Void avoid[])
    {
        if (a._styleInfoArray != null && a._styleInfoArray.size() > 0)
        {
            Log.v(TPhotoMagComposeManager.TAG, (new StringBuilder()).append(TPhotoMagComposeManager.TAG).append(" AsyncArChiveTask archive begin size:").append(b.size()).toString());
            avoid = new Gson();
            try
            {
                avoid = avoid.toJson(b);
                FileManager.getInstance().archiveFilterManger(EOnlineResType.MAG_MASK_INFO, avoid);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                Crashlytics.logException(avoid);
            }
        }
        Log.v(TPhotoMagComposeManager.TAG, (new StringBuilder()).append(TPhotoMagComposeManager.TAG).append("AsyncArChiveTask  archive end").toString());
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
