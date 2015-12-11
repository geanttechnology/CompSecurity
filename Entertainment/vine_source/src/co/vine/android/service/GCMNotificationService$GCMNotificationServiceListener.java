// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import co.vine.android.api.VineSingleNotification;
import co.vine.android.client.AppSessionListener;
import co.vine.android.network.HttpResult;
import co.vine.android.util.SparseArray;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.util.video.VideoKey;
import com.edisonwang.android.slog.SLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package co.vine.android.service:
//            GCMNotificationService

private class <init> extends AppSessionListener
{

    final GCMNotificationService this$0;

    public void onMergeNotificationComplete(VineSingleNotification vinesinglenotification, ArrayList arraylist)
    {
        <init> <init>1;
        if (arraylist != null && !arraylist.isEmpty())
        {
            int i = GCMNotificationService.access$800(GCMNotificationService.this, vinesinglenotification);
            <init>1 = getNotificationEvent(i);
            if (<init>1.bjectId > 0L && vinesinglenotification.conversationRowId != <init>1.bjectId)
            {
                <init>1.bjectId();
                <init>1.bjectId = vinesinglenotification.conversationRowId;
            }
            <init>1. = arraylist;
            if (!vinesinglenotification.isMessaging())
            {
                break MISSING_BLOCK_LABEL_169;
            }
            try
            {
                arraylist = new Message();
                arraylist.what = 101;
                if (GCMNotificationService.access$000(GCMNotificationService.this) != null)
                {
                    GCMNotificationService.access$000(GCMNotificationService.this).send(arraylist);
                }
            }
            // Misplaced declaration of an exception variable
            catch (ArrayList arraylist)
            {
                SLog.e("Failed to send request to camera service.");
            }
            synchronized (GCMNotificationService.access$200(GCMNotificationService.this))
            {
                GCMNotificationService.access$200(GCMNotificationService.this).put(Long.valueOf(vinesinglenotification.conversationRowId), new this._cls0(GCMNotificationService.this, vinesinglenotification, <init>1));
            }
        }
        return;
        vinesinglenotification;
        arraylist;
        JVM INSTR monitorexit ;
        throw vinesinglenotification;
        GCMNotificationService.access$900(GCMNotificationService.this, vinesinglenotification, <init>1);
        return;
    }

    public void onPhotoImageError(ImageKey imagekey, HttpResult httpresult)
    {
        httpresult = new ArrayList();
        Iterator iterator = GCMNotificationService.access$600(GCMNotificationService.this).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            int i = ((Integer)iterator.next()).intValue();
            this._cls0 _lcls0 = (this._cls0)GCMNotificationService.access$600(GCMNotificationService.this).get(i);
            if (_lcls0._fld0 != null && imagekey.equals(_lcls0._fld0))
            {
                _lcls0._fld0 = null;
            }
            Iterator iterator1 = _lcls0..keySet().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                ImageKey imagekey1 = (ImageKey)iterator1.next();
                if (imagekey.equals(imagekey1))
                {
                    _lcls0..put(imagekey1, Boolean.valueOf(true));
                }
            } while (true);
            if (GCMNotificationService.access$700(GCMNotificationService.this, _lcls0))
            {
                httpresult.add(Integer.valueOf(i));
            }
        } while (true);
        GCMNotificationService.access$600(GCMNotificationService.this).removeAll(httpresult);
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        ArrayList arraylist = new ArrayList();
        if (!hashmap.isEmpty())
        {
            Iterator iterator = GCMNotificationService.access$600(GCMNotificationService.this).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                int i = ((Integer)iterator.next()).intValue();
                this._cls0 _lcls0 = (this._cls0)GCMNotificationService.access$600(GCMNotificationService.this).get(i);
                if (_lcls0._fld0 != null && hashmap.containsKey(_lcls0._fld0))
                {
                    UrlImage urlimage = (UrlImage)hashmap.get(_lcls0._fld0);
                    if (urlimage != null && urlimage.isValid())
                    {
                        _lcls0._fld0 = urlimage.bitmap;
                    }
                    _lcls0._fld0 = null;
                }
                Iterator iterator1 = _lcls0..keySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    ImageKey imagekey = (ImageKey)iterator1.next();
                    if (hashmap.containsKey(imagekey))
                    {
                        _lcls0..put(imagekey, Boolean.valueOf(true));
                    }
                } while (true);
                if (GCMNotificationService.access$700(GCMNotificationService.this, _lcls0))
                {
                    arraylist.add(Integer.valueOf(i));
                }
            } while (true);
        }
        GCMNotificationService.access$600(GCMNotificationService.this).removeAll(arraylist);
    }

    public void onVideoPathError(VideoKey videokey, HttpResult httpresult)
    {
        httpresult = new ArrayList();
        Iterator iterator = GCMNotificationService.access$600(GCMNotificationService.this).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            int i = ((Integer)iterator.next()).intValue();
            this._cls0 _lcls0 = (this._cls0)GCMNotificationService.access$600(GCMNotificationService.this).get(i);
            Iterator iterator1 = _lcls0._fld0.keySet().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                VideoKey videokey1 = (VideoKey)iterator1.next();
                if (videokey.equals(videokey1))
                {
                    _lcls0._fld0.put(videokey1, Boolean.valueOf(true));
                }
            } while (true);
            if (GCMNotificationService.access$700(GCMNotificationService.this, _lcls0))
            {
                httpresult.add(Integer.valueOf(i));
            }
        } while (true);
        GCMNotificationService.access$600(GCMNotificationService.this).removeAll(httpresult);
    }

    public void onVideoPathObtained(HashMap hashmap)
    {
        SLog.d("Video path obtained.");
        ArrayList arraylist = new ArrayList();
        Iterator iterator = GCMNotificationService.access$600(GCMNotificationService.this).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            int i = ((Integer)iterator.next()).intValue();
            this._cls0 _lcls0 = (this._cls0)GCMNotificationService.access$600(GCMNotificationService.this).get(i);
            Iterator iterator1 = _lcls0._fld0.keySet().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                VideoKey videokey = (VideoKey)iterator1.next();
                if (hashmap.containsKey(videokey))
                {
                    _lcls0._fld0.put(videokey, Boolean.valueOf(true));
                }
            } while (true);
            if (GCMNotificationService.access$700(GCMNotificationService.this, _lcls0))
            {
                arraylist.add(Integer.valueOf(i));
            }
        } while (true);
        GCMNotificationService.access$600(GCMNotificationService.this).removeAll(arraylist);
    }

    private ()
    {
        this$0 = GCMNotificationService.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
