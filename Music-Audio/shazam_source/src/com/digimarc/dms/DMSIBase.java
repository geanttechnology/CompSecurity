// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.digimarc.dms:
//            DMSMessage, DMSPayload, DMSCache, DMSImageReaderMgr, 
//            DMSAudioReaderMgr, DMSIAudioSource, DMSIImageSource, DMSIListener

public class DMSIBase
{
    protected static class DMSEventHandler extends Handler
    {

        public void handleMessage(Message message)
        {
            Iterator iterator = DMSIBase.mListenerList.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                DMSIListener dmsilistener = (DMSIListener)iterator.next();
                if (dmsilistener == null)
                {
                    continue;
                }
                switch (message.what)
                {
                case 1: // '\001'
                    dmsilistener.onStatus(((DMSMessage)message.obj).getStatus());
                    break;

                case 101: // 'e'
                    dmsilistener.onImageWatermarkDetected((DMSMessage)message.obj);
                    break;

                case 100: // 'd'
                    dmsilistener.onAudioWatermarkDetected((DMSMessage)message.obj);
                    break;

                case 102: // 'f'
                    dmsilistener.onImageBarcodeDetected((DMSMessage)message.obj);
                    break;

                case 103: // 'g'
                    dmsilistener.onImageQRCodeDetected((DMSMessage)message.obj);
                    break;

                case 500: 
                case 501: 
                case 502: 
                case 503: 
                case 504: 
                case 505: 
                case 600: 
                    dmsilistener.onError(message.what);
                    break;
                }
            } while (true);
        }

        protected DMSEventHandler()
        {
        }
    }

    public static final class DMS_PROFILES extends Enum
    {

        private static final DMS_PROFILES $VALUES[];
        public static final DMS_PROFILES HIGH;
        public static final DMS_PROFILES IDLE;
        public static final DMS_PROFILES LOW;
        public static final DMS_PROFILES MEDIUM;

        public static DMS_PROFILES valueOf(String s)
        {
            return (DMS_PROFILES)Enum.valueOf(com/digimarc/dms/DMSIBase$DMS_PROFILES, s);
        }

        public static DMS_PROFILES[] values()
        {
            return (DMS_PROFILES[])$VALUES.clone();
        }

        static 
        {
            IDLE = new DMS_PROFILES("IDLE", 0);
            LOW = new DMS_PROFILES("LOW", 1);
            MEDIUM = new DMS_PROFILES("MEDIUM", 2);
            HIGH = new DMS_PROFILES("HIGH", 3);
            $VALUES = (new DMS_PROFILES[] {
                IDLE, LOW, MEDIUM, HIGH
            });
        }

        private DMS_PROFILES(String s, int i)
        {
            super(s, i);
        }
    }


    protected static final int DEFAULT_CACHE_DEPTH = 1;
    protected static DMSCache mAudioPayloadCache = null;
    protected static int mCurrentAudioStatus = 301;
    protected static int mCurrentDMSStatus = 200;
    protected static int mCurrentImageStatus = 401;
    protected static DMSEventHandler mEventHandler = new DMSEventHandler();
    protected static DMSCache mImagePayloadCache = null;
    protected static List mListenerList = new ArrayList();
    protected static boolean mReportNewDetectionsOnly = true;
    protected static boolean mReportReaderInfoDiagnostics = false;
    private final String TAG = "DMSIBase";
    protected boolean mAaudioReadingEnabled;
    protected Context mAppContext;
    protected boolean mAudioBufferingEnabled;
    protected int mAudioPayloadCacheMaxDepth;
    protected DMSAudioReaderMgr mAudioReaderMgr;
    protected DMSIAudioSource mAudioSource;
    protected DMS_PROFILES mCurrentAudioProfile;
    protected DMS_PROFILES mCurrentImageProfile;
    protected int mImagePayloadCacheMaxDepth;
    protected DMSImageReaderMgr mImageReaderMgr;
    protected boolean mImageReadingEnabled;
    protected DMSIImageSource mImageSource;

    public DMSIBase()
    {
        mCurrentImageProfile = DMS_PROFILES.LOW;
        mCurrentAudioProfile = DMS_PROFILES.MEDIUM;
        mImagePayloadCacheMaxDepth = 1;
        mAudioPayloadCacheMaxDepth = 1;
        mImageReaderMgr = null;
        mAudioReaderMgr = null;
        mImageSource = null;
        mAudioSource = null;
        mAppContext = null;
    }

    private void postMessage(int i, Object obj)
    {
        if (mEventHandler != null)
        {
            obj = mEventHandler.obtainMessage(i, obj);
            mEventHandler.sendMessage(((Message) (obj)));
        }
    }

    public void DMS_Notify_Marks(int i, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mReportNewDetectionsOnly || !inCache(i, (DMSMessage)obj))
        {
            postMessage(i, obj);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    protected void DMS_Notify_Status(int i, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        postMessage(i, obj);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    protected void addListener(DMSIListener dmsilistener)
    {
        this;
        JVM INSTR monitorenter ;
        mListenerList.add(dmsilistener);
        this;
        JVM INSTR monitorexit ;
        return;
        dmsilistener;
        throw dmsilistener;
    }

    protected DMS_PROFILES getAudioProfile()
    {
        return mCurrentAudioProfile;
    }

    DMS_PROFILES getImageProfile()
    {
        return mCurrentImageProfile;
    }

    protected boolean inCache(int i, DMSMessage dmsmessage)
    {
label0:
        {
            {
                boolean flag3 = true;
                boolean flag1 = true;
                boolean flag2 = false;
                if (i != 101 && i != 102 && i != 103)
                {
                    break label0;
                }
                boolean flag = flag2;
                if (mImagePayloadCacheMaxDepth > 0)
                {
                    dmsmessage = dmsmessage.getPayload();
                    flag = flag2;
                    if (mImagePayloadCache != null)
                    {
                        String s = dmsmessage.getPayloadId();
                        flag = flag2;
                        if (s != null)
                        {
                            if (mImagePayloadCache.get(s) != null)
                            {
                                flag = flag1;
                            } else
                            {
                                flag = false;
                            }
                            mImagePayloadCache.set(s, dmsmessage);
                        }
                    }
                }
            }
            return flag;
        }
        flag = flag2;
        if (i == 100)
        {
            flag = flag2;
            if (mAudioPayloadCacheMaxDepth > 0)
            {
                dmsmessage = dmsmessage.getPayload();
                flag = flag2;
                if (mAudioPayloadCache != null)
                {
                    if (mAudioPayloadCache.get(dmsmessage.getPayloadId()) != null)
                    {
                        flag = flag3;
                    } else
                    {
                        flag = false;
                    }
                    mAudioPayloadCache.set(dmsmessage.getPayloadId(), dmsmessage);
                }
            }
        }
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_88;
        }
    }

    protected void initialize()
    {
        mImageReaderMgr = new DMSImageReaderMgr();
        mAudioReaderMgr = new DMSAudioReaderMgr();
    }

    protected void removeListeners()
    {
        this;
        JVM INSTR monitorenter ;
        mListenerList.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void setAppContext(Context context)
    {
        mAppContext = context;
    }

    public void setAudioPayloadCacheMaxDepth(int i)
    {
        this;
        JVM INSTR monitorenter ;
        mAudioPayloadCache = new DMSCache(i);
        mAudioPayloadCacheMaxDepth = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void setAudioProfile(DMS_PROFILES dms_profiles)
    {
        mCurrentAudioProfile = dms_profiles;
    }

    protected void setAudioSource(DMSIAudioSource dmsiaudiosource)
    {
        mAudioSource = dmsiaudiosource;
    }

    protected void setImagePayloadCacheMaxDepth(int i)
    {
        this;
        JVM INSTR monitorenter ;
        mImagePayloadCache = new DMSCache(i);
        mImagePayloadCacheMaxDepth = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void setImageProfile(DMS_PROFILES dms_profiles)
    {
        mCurrentImageProfile = dms_profiles;
    }

    protected void setImageSource(DMSIImageSource dmsiimagesource)
    {
        mImageSource = dmsiimagesource;
    }

    protected void updateAudioStatus(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i != mCurrentAudioStatus)
        {
            mCurrentAudioStatus = i;
            DMS_Notify_Status(1, new DMSMessage(null, "DMSIBase", mCurrentAudioStatus));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void updateDMSStatus(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (mCurrentDMSStatus != i)
        {
            mCurrentDMSStatus = i;
            DMS_Notify_Status(1, new DMSMessage(null, "DMSIBase", mCurrentDMSStatus));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void updateImageStatus(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i != mCurrentImageStatus)
        {
            mCurrentImageStatus = i;
            DMS_Notify_Status(1, new DMSMessage(null, "DMSIBase", mCurrentImageStatus));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
