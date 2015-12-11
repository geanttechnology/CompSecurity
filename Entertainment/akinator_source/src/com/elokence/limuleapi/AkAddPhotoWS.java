// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import android.content.Context;
import android.graphics.Bitmap;
import com.elokence.limuleapi.Exceptions.AkException;
import com.elokence.limuleapi.exceptions.AkWsException;
import java.io.File;
import java.io.FileNotFoundException;
import org.w3c.dom.Document;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebservice, SessionFactory, Session

class AkAddPhotoWS extends AkWebservice
{

    Bitmap mBitmap;
    File mFilePhoto;
    boolean mModeBitmap;
    Session mSession;

    public AkAddPhotoWS(int i, Bitmap bitmap)
    {
        mWsService = "post_photo.php";
        mSession = SessionFactory.sharedInstance().getSession();
        mModeBitmap = true;
        mBitmap = bitmap;
        mFilePhoto = null;
        addParameter("base", "0");
        addParameter("channel", mSession.getChannel());
        addParameter("session", mSession.getSession());
        addParameter("signature", mSession.getSignature());
        addParameter("id_base", (new StringBuilder()).append("").append(i).toString());
        addParameter("player", SessionFactory.sharedInstance().getPlayerName());
        addParameter("uid", SessionFactory.sharedInstance().getDeviceId());
        addParameter("source", "android");
    }

    public AkAddPhotoWS(int i, File file)
    {
        mWsService = "post_photo.php";
        mSession = SessionFactory.sharedInstance().getSession();
        mModeBitmap = false;
        mBitmap = null;
        mFilePhoto = file;
        addParameter("base", "0");
        addParameter("channel", mSession.getChannel());
        addParameter("session", mSession.getSession());
        addParameter("signature", mSession.getSignature());
        addParameter("id_base", (new StringBuilder()).append("").append(i).toString());
        addParameter("player", SessionFactory.sharedInstance().getPlayerName());
        addParameter("uid", SessionFactory.sharedInstance().getDeviceId());
        addParameter("source", "android");
    }

    public int call()
    {
        try
        {
            if (mModeBitmap)
            {
                String s = (new StringBuilder()).append("android_upload-").append(System.currentTimeMillis()).append(".jpg").toString();
                java.io.FileOutputStream fileoutputstream = SessionFactory.sharedInstance().getApplicationContext().openFileOutput(s, 0);
                s = (new StringBuilder()).append(SessionFactory.sharedInstance().getApplicationContext().getFilesDir().getAbsolutePath()).append("/").append(s).toString();
                mBitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, fileoutputstream);
                mFilePhoto = new File(s);
            }
            addPostParam("fichier", mFilePhoto);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            filenotfoundexception.printStackTrace();
            return 400;
        }
        return super.call();
    }

    void parseWSResponse(Document document)
        throws AkException, AkWsException
    {
    }
}
