// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaJavaUndo;
import com.aviary.android.feather.library.content.SessionDatabaseHelper;
import com.aviary.android.feather.library.utils.ImageInfo;
import com.aviary.android.feather.library.vo.EditToolResultVO;

// Referenced classes of package com.aviary.android.feather.library.services:
//            BaseContextService, IAviaryController, HiResBackgroundService

public class SessionService extends BaseContextService
{
    private final class SessionServiceHandler extends Handler
    {

        final com.aviary.android.feather.common.log.LoggerFactory.Logger logger = LoggerFactory.getLogger("SessionService-Handler");
        private long mCurrentActionId;
        private long mLastActionId;
        private long mSessionId;
        final SessionService this$0;

        private void handleLoad(Message message)
        {
            logger.info("handleLoad");
            if (mSessionId > -1L)
            {
                mDatabase.deleteSession(mSessionId);
                mSessionId = -1L;
                mLastActionId = -1L;
                mCurrentActionId = -1L;
            }
            message = message.getData();
            if (message != null)
            {
                long l = message.getLong("ptr");
                int i = message.getInt("bundle-megapixels");
                message = (ImageInfo)message.getParcelable("bundle-image-info");
                mSessionId = mDatabase.load(message.getUri().toString(), i, message.getOrientation());
                mLastActionId = -1L;
                mCurrentActionId = -1L;
                if (mSessionId > -1L)
                {
                    mLastActionId = mDatabase.push(mSessionId, l, null);
                    mCurrentActionId = mLastActionId;
                }
                hiResLoad(message, i);
                invokeReplayActions(mSessionId);
            }
        }

        private void handlePush(Message message)
        {
            boolean flag = false;
            logger.info("handlePush");
            message = message.getData();
            if (mSessionId > -1L && message != null)
            {
                if (mLastActionId != -1L)
                {
                    mDatabase.deleteActionsFrom(mSessionId, mLastActionId);
                }
                long l = message.getLong("ptr");
                message = (MoaActionList)message.getSerializable("bundle-actions");
                mLastActionId = mDatabase.push(mSessionId, l, message);
                invokeReplayActions(mSessionId);
                return;
            }
            com.aviary.android.feather.common.log.LoggerFactory.Logger logger1 = logger;
            long l1 = mSessionId;
            if (message == null)
            {
                flag = true;
            }
            logger1.error("handlePush failed. mSessionId: %d, data is null? %b", new Object[] {
                Long.valueOf(l1), Boolean.valueOf(flag)
            });
        }

        private void handleRedo(Message message)
        {
            logger.info("handleRedo");
            message = message.getData();
            if (mSessionId > -1L && message != null)
            {
                long l = message.getLong("ptr", -1L);
                mLastActionId = mDatabase.findActionByBitmap(mSessionId, l);
                logger.verbose("action: %d", new Object[] {
                    Long.valueOf(mLastActionId)
                });
                invokeReplayActions(mSessionId);
            }
        }

        private void handleReplayActions(Message message)
        {
            long l;
label0:
            {
                logger.info("handleReplayActions");
                message = message.getData();
                if (message != null && mSessionId > -1L)
                {
                    l = message.getLong("session-id", -1L);
                    if (l == mSessionId)
                    {
                        logger.verbose("mCurrentAction: %d, mLastAction: %d", new Object[] {
                            Long.valueOf(mCurrentActionId), Long.valueOf(mLastActionId)
                        });
                        if (mCurrentActionId != -1L)
                        {
                            break label0;
                        }
                        logger.warn("mCurrentActionId = -1. stop");
                    }
                }
                return;
            }
            if (mLastActionId == -1L)
            {
                logger.warn("mLastActionId = -1. stop");
                return;
            }
            if (mCurrentActionId >= mLastActionId)
            {
                logger.warn("mCurrentActionId >= mLastActionId");
                return;
            }
            message = mDatabase.findActionGreaterThan(l, mCurrentActionId);
            logger.verbose("action: %s", new Object[] {
                message
            });
            if (message != null)
            {
                HiResBackgroundService hiresbackgroundservice = (HiResBackgroundService)getService(com/aviary/android/feather/library/services/HiResBackgroundService);
                if (hiresbackgroundservice != null && hiresbackgroundservice.isRunning())
                {
                    hiresbackgroundservice.apply(((com.aviary.android.feather.library.content.SessionDatabaseHelper.ActionWrapper) (message)).actions);
                }
            }
            mCurrentActionId = ((com.aviary.android.feather.library.content.SessionDatabaseHelper.ActionWrapper) (message)).id;
            invokeReplayActions(l);
        }

        private void handleRevert(Message message)
        {
            logger.info("handleRevert");
            message = message.getData();
            if (mSessionId > -1L && message != null)
            {
                long l = message.getLong("ptr", -1L);
                if (l > -1L)
                {
                    mDatabase.deleteActions(mSessionId);
                    mLastActionId = mDatabase.push(mSessionId, l, null);
                    mCurrentActionId = mLastActionId;
                    logger.verbose("mCurrentActionId: %d", new Object[] {
                        Long.valueOf(mCurrentActionId)
                    });
                }
                message = mDatabase.findSession(mSessionId);
                if (message != null)
                {
                    hiresRevert(((com.aviary.android.feather.library.content.SessionDatabaseHelper.SessionWrapper) (message)).data, ((com.aviary.android.feather.library.content.SessionDatabaseHelper.SessionWrapper) (message)).megapixels, ((com.aviary.android.feather.library.content.SessionDatabaseHelper.SessionWrapper) (message)).orientation);
                } else
                {
                    logger.error("failed to revert. Session is null");
                }
                if (l > -1L)
                {
                    invokeReplayActions(mSessionId);
                }
            }
        }

        private void handleSave(Message message)
        {
            Object obj;
label0:
            {
                logger.info("handleSave");
                obj = message.getData();
                if (mSessionId > -1L && obj != null)
                {
                    if (!hasPendingMessages())
                    {
                        break label0;
                    }
                    logger.warn("Other messages pending... append the message at the end of the queue...");
                    obj = Message.obtain(mInternalHandler);
                    ((Message) (obj)).copyFrom(message);
                    ((Message) (obj)).sendToTarget();
                }
                return;
            }
            hiresSave(((Bundle) (obj)).getString("path"), (android.graphics.Bitmap.CompressFormat)((Bundle) (obj)).getSerializable("compress-format"), ((Bundle) (obj)).getInt("quality"));
        }

        private void handleStop(Message message)
        {
            logger.info("handleStop");
        }

        private void handleUndo(Message message)
        {
            logger.info("handleUndo");
            message = message.getData();
            if (mSessionId > -1L && message != null)
            {
                long l = message.getLong("ptr", -1L);
                mCurrentActionId = -1L;
                mLastActionId = mDatabase.findActionByBitmap(mSessionId, l);
                if (mLastActionId > -1L)
                {
                    message = mDatabase.findActionGreaterThan(mSessionId, -1L);
                    if (message != null)
                    {
                        mCurrentActionId = ((com.aviary.android.feather.library.content.SessionDatabaseHelper.ActionWrapper) (message)).id;
                    }
                    message = Message.obtain(this, 8);
                    message.setData(new Bundle());
                    message.sendToTarget();
                    invokeReplayActions(mSessionId);
                }
                logger.verbose("mCurrentActionId: %d, mLastActionId: %d", new Object[] {
                    Long.valueOf(mCurrentActionId), Long.valueOf(mLastActionId)
                });
            }
        }

        private boolean hasPendingMessages()
        {
            while (hasMessages(1) || hasMessages(2) || hasMessages(3) || hasMessages(4) || hasMessages(5) || hasMessages(6) || hasMessages(7) || hasMessages(8) || hasMessages(9)) 
            {
                return true;
            }
            return false;
        }

        private void invokeReplayActions(long l)
        {
            Message message = Message.obtain(this, 7);
            Bundle bundle = new Bundle();
            bundle.putLong("session-id", l);
            message.setData(bundle);
            message.sendToTarget();
        }

        public void handleMessage(Message message)
        {
            message.what;
            JVM INSTR tableswitch 1 9: default 56
        //                       1 126
        //                       2 57
        //                       3 69
        //                       4 87
        //                       5 114
        //                       6 120
        //                       7 81
        //                       8 63
        //                       9 75;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
            return;
_L3:
            handleLoad(message);
            return;
_L9:
            handleRevert(message);
            return;
_L4:
            handlePush(message);
            return;
_L10:
            handleSave(message);
            return;
_L8:
            handleReplayActions(message);
            return;
_L5:
            if (mSessionId > -1L)
            {
                mDatabase.deleteActions(mSessionId);
                return;
            }
              goto _L1
_L6:
            handleUndo(message);
            return;
_L7:
            handleRedo(message);
            return;
_L2:
            handleStop(message);
            return;
        }

        void hiResLoad(ImageInfo imageinfo, int i)
        {
            logger.info("hiresLoad");
            HiResBackgroundService hiresbackgroundservice = (HiResBackgroundService)getService(com/aviary/android/feather/library/services/HiResBackgroundService);
            if (hiresbackgroundservice != null && hiresbackgroundservice.isRunning())
            {
                hiresbackgroundservice.load(imageinfo.getUri(), i, imageinfo);
            }
        }

        void hiresApplyActions(MoaActionList moaactionlist)
        {
            logger.info("hiresApplyActions");
            if (moaactionlist != null)
            {
                HiResBackgroundService hiresbackgroundservice = (HiResBackgroundService)getService(com/aviary/android/feather/library/services/HiResBackgroundService);
                if (hiresbackgroundservice != null && hiresbackgroundservice.isRunning())
                {
                    hiresbackgroundservice.apply(moaactionlist);
                }
            }
        }

        void hiresRevert(Uri uri, int i, int j)
        {
            logger.info("hiresRevert");
            HiResBackgroundService hiresbackgroundservice = (HiResBackgroundService)getService(com/aviary/android/feather/library/services/HiResBackgroundService);
            if (hiresbackgroundservice != null && hiresbackgroundservice.isRunning())
            {
                hiresbackgroundservice.revert(uri, i, j);
            }
        }

        void hiresSave(String s, android.graphics.Bitmap.CompressFormat compressformat, int i)
        {
            logger.info("hiresSave");
            HiResBackgroundService hiresbackgroundservice = (HiResBackgroundService)getService(com/aviary/android/feather/library/services/HiResBackgroundService);
            if (hiresbackgroundservice != null && hiresbackgroundservice.isRunning())
            {
                hiresbackgroundservice.save(s, compressformat, i);
            }
        }

        public SessionServiceHandler(Looper looper)
        {
            this$0 = SessionService.this;
            super(looper);
            mSessionId = -1L;
            mLastActionId = -1L;
            mCurrentActionId = -1L;
        }
    }


    private static final int ACTION_DELETE_ACTIONS = 4;
    private static final int ACTION_LOAD = 2;
    private static final int ACTION_PUSH = 3;
    private static final int ACTION_REDO = 6;
    private static final int ACTION_REPLAY_ACTIONS = 7;
    private static final int ACTION_REVERT = 8;
    private static final int ACTION_SAVE = 9;
    private static final int ACTION_STOP = 1;
    private static final int ACTION_UNDO = 5;
    private static final String BUNDLE_ACTIONS = "bundle-actions";
    private static final String BUNDLE_IMAGE_INFO = "bundle-image-info";
    private static final String BUNDLE_MEGAPIXELS = "bundle-megapixels";
    private static final String BUNDLE_PTR = "ptr";
    private static final String BUNDLE_SESSION_ID = "session-id";
    SessionDatabaseHelper mDatabase;
    private SessionServiceHandler mInternalHandler;
    private Looper mLooper;
    private HandlerThread mThread;
    private boolean mUndoEnabled;
    MoaJavaUndo moaJavaUndo;
    private boolean running;

    public SessionService(IAviaryController iaviarycontroller)
    {
        super(iaviarycontroller);
        mUndoEnabled = ApiHelper.isUndoRedoAvailable();
        logger.verbose("undoEnabled: %b", new Object[] {
            Boolean.valueOf(mUndoEnabled)
        });
        mThread = new HandlerThread("session-service-thread", 10);
        mThread.start();
        moaJavaUndo = new MoaJavaUndo(mUndoEnabled);
        mDatabase = new SessionDatabaseHelper(iaviarycontroller.getBaseContext());
    }

    private void removeAllMessages()
    {
        logger.info("removeAllMessages");
        mInternalHandler.removeCallbacksAndMessages(null);
    }

    private transient void removeMessages(int ai[])
    {
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            int k = ai[i];
            logger.verbose("removeMessage: %d", new Object[] {
                Integer.valueOf(k)
            });
            mInternalHandler.removeMessages(k);
        }

    }

    private void stop()
    {
        moaJavaUndo.dispose();
        removeAllMessages();
        mInternalHandler.sendEmptyMessage(1);
        running = false;
    }

    public boolean canRedo()
    {
        return getEnabled() && moaJavaUndo.canRedo();
    }

    public boolean canUndo()
    {
        return getEnabled() && moaJavaUndo.canUndo();
    }

    public void clearAll()
    {
        logger.info("clearAll");
        if (!running)
        {
            return;
        } else
        {
            moaJavaUndo.clearAll();
            Message.obtain(mInternalHandler, 4).sendToTarget();
            return;
        }
    }

    public void dispose()
    {
        stop();
    }

    public boolean getEnabled()
    {
        return mUndoEnabled;
    }

    public boolean isRunning()
    {
        return running;
    }

    public void load(Bitmap bitmap, int i, ImageInfo imageinfo)
    {
        logger.info("load");
        if (!running)
        {
            return;
        }
        long l = 0L;
        if (getEnabled())
        {
            long l1 = moaJavaUndo.load(bitmap);
            l = l1;
            if (l1 <= 0L)
            {
                logger.error("failed to load bitmap, we have to disable session.service");
                setEnabled(false);
                l = l1;
            }
        }
        logger.verbose("result: %d", new Object[] {
            Long.valueOf(l)
        });
        if (getEnabled())
        {
            removeAllMessages();
            bitmap = Message.obtain(mInternalHandler, 2);
            Bundle bundle = new Bundle();
            bundle.putLong("ptr", l);
            bundle.putInt("bundle-megapixels", i);
            bundle.putParcelable("bundle-image-info", imageinfo);
            bitmap.setData(bundle);
            bitmap.sendToTarget();
            return;
        } else
        {
            mInternalHandler.hiResLoad(imageinfo, i);
            return;
        }
    }

    public void push(Bitmap bitmap, EditToolResultVO edittoolresultvo)
    {
        logger.info("push: %s", new Object[] {
            edittoolresultvo.getActionList()
        });
        if (running)
        {
            if (getEnabled())
            {
                long l = moaJavaUndo.push(bitmap);
                logger.verbose("result: 0x%x", new Object[] {
                    Long.valueOf(l)
                });
                if (l > 0L)
                {
                    bitmap = new Bundle();
                    bitmap.putLong("ptr", l);
                    bitmap.putSerializable("bundle-actions", edittoolresultvo.getActionList());
                    edittoolresultvo = Message.obtain(mInternalHandler, 3);
                    edittoolresultvo.setData(bitmap);
                    edittoolresultvo.sendToTarget();
                    return;
                }
            } else
            {
                mInternalHandler.hiresApplyActions(edittoolresultvo.getActionList());
                return;
            }
        }
    }

    public Bitmap redo()
    {
        if (running && getEnabled())
        {
            com.aviary.android.feather.headless.moa.MoaJavaUndo.MoaUndoBitmap moaundobitmap = moaJavaUndo.redo();
            logger.info("redo result: %s", new Object[] {
                moaundobitmap
            });
            if (moaundobitmap != null)
            {
                Bundle bundle = new Bundle();
                bundle.putLong("ptr", moaundobitmap.ptr);
                Message message = Message.obtain(mInternalHandler, 6);
                message.setData(bundle);
                message.sendToTarget();
                return moaundobitmap.bitmap;
            }
        }
        return null;
    }

    public void revert(Bitmap bitmap, Uri uri, int i, ImageInfo imageinfo)
    {
        logger.info("revert");
        long l;
        if (running)
        {
            if (getEnabled())
            {
                if ((l = moaJavaUndo.load(bitmap)) > 0L)
                {
                    removeAllMessages();
                    bitmap = Message.obtain(mInternalHandler, 8);
                    uri = new Bundle();
                    uri.putLong("ptr", l);
                    bitmap.setData(uri);
                    bitmap.sendToTarget();
                    return;
                }
            } else
            {
                mInternalHandler.hiresRevert(uri, i, imageinfo.getOrientation());
                return;
            }
        }
    }

    public void save(String s, android.graphics.Bitmap.CompressFormat compressformat, int i)
    {
        logger.info("save");
        if (!running)
        {
            return;
        }
        if (getEnabled())
        {
            mInternalHandler.removeMessages(9);
            Bundle bundle = new Bundle();
            bundle.putString("path", s);
            bundle.putSerializable("compress-format", compressformat);
            bundle.putInt("quality", i);
            s = Message.obtain(mInternalHandler, 9);
            s.setData(bundle);
            s.sendToTarget();
            return;
        } else
        {
            mInternalHandler.hiresSave(s, compressformat, i);
            return;
        }
    }

    void setEnabled(boolean flag)
    {
        mUndoEnabled = flag;
    }

    public int size()
    {
        if (!getEnabled())
        {
            return 0;
        } else
        {
            return moaJavaUndo.size();
        }
    }

    public void start()
    {
        if (!running)
        {
            running = true;
            mLooper = mThread.getLooper();
            mInternalHandler = new SessionServiceHandler(mLooper);
            HiResBackgroundService hiresbackgroundservice = (HiResBackgroundService)getService(com/aviary/android/feather/library/services/HiResBackgroundService);
            if (hiresbackgroundservice != null && !hiresbackgroundservice.isRunning())
            {
                hiresbackgroundservice.start();
            }
        }
    }

    public Bitmap undo()
    {
        if (running && getEnabled())
        {
            com.aviary.android.feather.headless.moa.MoaJavaUndo.MoaUndoBitmap moaundobitmap = moaJavaUndo.undo();
            logger.info("undo result: %s", new Object[] {
                moaundobitmap
            });
            if (moaundobitmap != null)
            {
                removeMessages(new int[] {
                    5, 7
                });
                Bundle bundle = new Bundle();
                bundle.putLong("ptr", moaundobitmap.ptr);
                Message message = Message.obtain(mInternalHandler, 5);
                message.setData(bundle);
                message.sendToTarget();
                return moaundobitmap.bitmap;
            }
        }
        return null;
    }

}
