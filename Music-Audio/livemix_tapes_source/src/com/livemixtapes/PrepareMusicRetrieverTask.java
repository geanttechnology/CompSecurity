// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.os.AsyncTask;

// Referenced classes of package com.livemixtapes:
//            MusicRetriever

public class PrepareMusicRetrieverTask extends AsyncTask
{
    public static interface MusicRetrieverPreparedListener
    {

        public abstract void onMusicRetrieverPrepared();
    }


    MusicRetrieverPreparedListener mListener;
    MusicRetriever mRetriever;

    public PrepareMusicRetrieverTask(MusicRetriever musicretriever, MusicRetrieverPreparedListener musicretrieverpreparedlistener)
    {
        mRetriever = musicretriever;
        mListener = musicretrieverpreparedlistener;
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        mRetriever.prepare();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        mListener.onMusicRetrieverPrepared();
    }
}
