// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import com.fotoable.comlib.util.AsyncTask;
import com.google.gson.Gson;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import java.util.Iterator;
import java.util.List;

public class ur extends AsyncTask
{

    final TPhotoMagComposeManager a;

    private ur(TPhotoMagComposeManager tphotomagcomposemanager)
    {
        a = tphotomagcomposemanager;
        super();
    }

    public ur(TPhotoMagComposeManager tphotomagcomposemanager, com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager._cls1 _pcls1)
    {
        this(tphotomagcomposemanager);
    }

    protected transient Void a(Void avoid[])
    {
        if (a._styleInfoArray != null && a._styleInfoArray.size() > 0)
        {
            avoid = new Gson();
            Iterator iterator = a._styleInfoArray.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                TPhotoComposeInfo tphotocomposeinfo = (TPhotoComposeInfo)iterator.next();
                if (tphotocomposeinfo.icon == null || tphotocomposeinfo.icon != null && tphotocomposeinfo.icon.length() == 0)
                {
                    iterator.remove();
                }
            } while (true);
            try
            {
                avoid = avoid.toJson(a._styleInfoArray);
                FileManager.getInstance().archiveFilterManger(EOnlineResType.MAG_MASK_INFO, avoid);
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
