// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import com.aviary.android.feather.cds.CdsUtils;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.headless.AviaryExecutionException;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaHD;
import com.aviary.android.feather.headless.utils.CameraUtils;
import com.aviary.android.feather.headless.utils.MegaPixels;
import com.aviary.android.feather.library.utils.ImageInfo;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.library.services:
//            BaseContextService, IAviaryController

public final class HiResBackgroundService extends BaseContextService
{
    private final class InternalHandler extends Handler
    {

        private AtomicBoolean mHiResEnabled;
        final HiResBackgroundService this$0;

        private void handleActions(MoaActionList moaactionlist)
        {
            logger.verbose("InternalHandler::handleActions", new Object[0]);
            if (mHiResEnabled.get())
            {
                if (moa != null && moa.isLoaded() && moaactionlist != null)
                {
                    try
                    {
                        moa.applyActions(moaactionlist);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (MoaActionList moaactionlist)
                    {
                        logger.error(moaactionlist.getMessage());
                        moaactionlist.printStackTrace();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (MoaActionList moaactionlist)
                    {
                        logger.error(moaactionlist.getMessage());
                    }
                    moaactionlist.printStackTrace();
                    return;
                } else
                {
                    logger.warn("moa is not loaded..");
                    return;
                }
            } else
            {
                logger.warn("hires is not enabled, skipping actions..");
                return;
            }
        }

        private void handleActions(String s)
        {
            logger.verbose("InternalHandler::handleActions(s)", new Object[0]);
            if (mHiResEnabled.get())
            {
                if (moa != null && moa.isLoaded() && s != null)
                {
                    try
                    {
                        moa.applyActions(s);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        logger.error(s.getMessage());
                    }
                    s.printStackTrace();
                    return;
                } else
                {
                    logger.warn("moa is not loaded..");
                    return;
                }
            } else
            {
                logger.warn("hires is not enabled, skipping actions..");
                return;
            }
        }

        private void handleFile(Uri uri, int i, int j)
        {
label0:
            {
                logger.verbose("InternalHandler::handleFile: %s, maxSize: %d, orientation: %d", new Object[] {
                    uri, Integer.valueOf(i), Integer.valueOf(j)
                });
                uri = getActivityContext();
                if (uri == null)
                {
                    logger.warn("Context is gone");
                    return;
                }
                logger.verbose((new StringBuilder()).append("orientation: ").append(j).toString(), new Object[0]);
                if (j != 0)
                {
                    logger.verbose("need to rotate the image", new Object[0]);
                    handleRotate90(j);
                }
                j = i;
                if (uri == null)
                {
                    break label0;
                }
                j = i;
                if (CdsUtils.getPermissions(uri).contains(com.aviary.android.feather.cds.AviaryCds.Permission.hires.name()))
                {
                    break label0;
                }
                if (i > 0)
                {
                    j = i;
                    if (i <= CameraUtils.getNormalMegaPixels().ordinal())
                    {
                        break label0;
                    }
                }
                logger.warn("overriding maxSize due to permissions constrains");
                j = CameraUtils.getNormalMegaPixels().ordinal();
            }
            MegaPixels megapixels = MegaPixels.Mp3;
            uri = megapixels;
            if (j >= 0)
            {
                uri = megapixels;
                if (j < MegaPixels.values().length)
                {
                    uri = MegaPixels.values()[j];
                }
            }
            handleResize(uri.ordinal());
        }

        private void handleResize(int i)
        {
            logger.verbose((new StringBuilder()).append("InternalHandler::handleResize: ").append(i).toString(), new Object[0]);
            if (mHiResEnabled.get())
            {
                if (moa != null && moa.isLoaded() && i > 0)
                {
                    logger.verbose((new StringBuilder()).append("need to resize to ").append(i).toString(), new Object[0]);
                    MoaActionList moaactionlist = MoaActionFactory.actionList(new String[] {
                        "resize"
                    });
                    MoaAction moaaction = moaactionlist.get(0);
                    moaaction.setValue("size", i);
                    moaaction.setValue("sizeInMegaPixels", true);
                    handleActions(moaactionlist);
                }
                return;
            } else
            {
                logger.warn("hires is not enabled, skipping resize");
                return;
            }
        }

        private void handleRotate90(int i)
        {
            logger.verbose((new StringBuilder()).append("InternalHandler::handleRotate: ").append(i).toString(), new Object[0]);
            if (mHiResEnabled.get())
            {
                if (moa != null && moa.isLoaded())
                {
                    MoaActionList moaactionlist = MoaActionFactory.actionList();
                    if (i != 0)
                    {
                        MoaAction moaaction = MoaActionFactory.action("rotate90");
                        moaaction.setValue("angle", i);
                        moaactionlist.add(moaaction);
                    }
                    if (moaactionlist.size() > 0)
                    {
                        handleActions(moaactionlist);
                    }
                }
                return;
            } else
            {
                logger.warn("hires is not enabled, skipping rotate90");
                return;
            }
        }

        private void loadImage(Uri uri, int i, int j)
            throws AviaryExecutionException
        {
            logger.verbose("InternalHandler::loadImage (uri: %s, maxSize: %d, orientation: %d)", new Object[] {
                uri, Integer.valueOf(i), Integer.valueOf(j)
            });
            Object obj;
            boolean flag;
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mHiResEnabled.set(flag);
            if (moa == null)
            {
                moa = new MoaHD();
                moa.setOriginalEnabled(ApiHelper.isHiResOriginalAvailable());
            }
            String s;
            if (moa.isLoaded())
            {
                try
                {
                    moa.unload();
                }
                catch (AviaryExecutionException aviaryexecutionexception) { }
            }
            obj = getActivityContext();
            if (obj != null) goto _L2; else goto _L1
_L1:
            logger.warn("Context is gone");
_L4:
            return;
_L2:
            if (!flag)
            {
                continue; /* Loop/switch isn't completed */
            }
            s = IOUtils.getRealFilePath(((Context) (obj)), uri);
            if (s == null)
            {
                break; /* Loop/switch isn't completed */
            }
            moa.load(s);
_L5:
            if (moa.isLoaded())
            {
                handleFile(uri, i, j);
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (ApiHelper.isHoneyComb())
            {
                try
                {
                    obj = ((Context) (obj)).getContentResolver().openInputStream(uri);
                }
                // Misplaced declaration of an exception variable
                catch (Uri uri)
                {
                    throw AviaryExecutionException.fromInt(1);
                }
                if (obj != null)
                {
                    try
                    {
                        moa.load(((java.io.InputStream) (obj)));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Uri uri)
                    {
                        throw uri;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Uri uri)
                    {
                        throw AviaryExecutionException.fromInt(8);
                    }
                    IOUtils.closeSilently(((java.io.Closeable) (obj)));
                }
            } else
            {
                try
                {
                    obj = ((Context) (obj)).getContentResolver().openFileDescriptor(uri, "r");
                }
                // Misplaced declaration of an exception variable
                catch (Uri uri)
                {
                    throw AviaryExecutionException.fromInt(1);
                }
                if (obj != null)
                {
                    try
                    {
                        moa.load(((ParcelFileDescriptor) (obj)).getFileDescriptor());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Uri uri)
                    {
                        throw uri;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Uri uri)
                    {
                        throw AviaryExecutionException.fromInt(8);
                    }
                    IOUtils.closeSilently(((ParcelFileDescriptor) (obj)));
                }
            }
              goto _L5
            if (true) goto _L4; else goto _L6
_L6:
        }

        private void saveImage(String s, int i, int j)
            throws AviaryExecutionException
        {
            logger.verbose("InternalHandler::saveImage: %s, format: %d, quality: %d ", new Object[] {
                s, Integer.valueOf(i), Integer.valueOf(j)
            });
            if (mHiResEnabled.get())
            {
                if (!moa.isLoaded())
                {
                    throw AviaryExecutionException.fromInt(3);
                }
                android.graphics.Bitmap.CompressFormat compressformat1 = android.graphics.Bitmap.CompressFormat.JPEG;
                android.graphics.Bitmap.CompressFormat compressformat = compressformat1;
                if (i >= 0)
                {
                    compressformat = compressformat1;
                    if (i < android.graphics.Bitmap.CompressFormat.values().length)
                    {
                        compressformat = android.graphics.Bitmap.CompressFormat.values()[i];
                    }
                }
                moa.save(s, j, compressformat);
                return;
            } else
            {
                logger.warn("hires is not enabled, skipping save");
                return;
            }
        }

        public boolean getHiresEnabled()
        {
            return mHiResEnabled.get();
        }

        public void handleMessage(Message message)
        {
            super.handleMessage(message);
            logger.log((new StringBuilder()).append("handleMessage: ").append(message.what).toString());
            Bundle bundle = message.getData();
            if (bundle != null && bundle.getLong("counter_id", 0L) == mCounter.getId())
            {
                HiResBackgroundService hiresbackgroundservice = HiResBackgroundService.this;
                ProgressCounter progresscounter = mCounter;
                int i = progresscounter.index + 1;
                progresscounter.index = i;
                hiresbackgroundservice.dispatchProgress(i, mCounter.total);
            }
            message.what;
            JVM INSTR lookupswitch 5: default 168
        //                       1000: 169
        //                       1001: 319
        //                       1002: 361
        //                       1003: 201
        //                       1999: 353;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            return;
_L2:
            Uri uri = (Uri)message.obj;
            try
            {
                loadImage(uri, message.arg1, message.arg2);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                dispatchError(message);
            }
            return;
_L5:
            boolean flag;
            boolean flag1;
            if (!moa.isLoaded())
            {
                continue; /* Loop/switch isn't completed */
            }
            flag1 = false;
            flag = flag1;
            if (!moa.getOriginalEnabled())
            {
                break MISSING_BLOCK_LABEL_270;
            }
            moa.revert();
            if (message.arg2 != 0)
            {
                handleRotate90(message.arg2);
            }
            handleResize(message.arg1);
            flag = true;
_L8:
            if (!flag)
            {
                Uri uri1 = (Uri)message.obj;
                try
                {
                    loadImage(uri1, message.arg1, message.arg2);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    dispatchError(message);
                }
                return;
            }
            if (true) goto _L1; else goto _L7
_L7:
            AviaryExecutionException aviaryexecutionexception;
            aviaryexecutionexception;
            aviaryexecutionexception.printStackTrace();
            flag = flag1;
              goto _L8
_L3:
            if (message.obj instanceof String)
            {
                handleActions((String)message.obj);
                return;
            } else
            {
                handleActions((MoaActionList)message.obj);
                return;
            }
_L6:
            quit();
            return;
_L4:
            try
            {
                int j = message.arg1;
                int k = message.arg2;
                saveImage((String)message.obj, j, k);
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                logger.error("handled save error: %s", new Object[] {
                    message
                });
                dispatchError(message);
                return;
            }
            dispatchSaveComplete();
            return;
        }

        public InternalHandler(Looper looper)
        {
            this$0 = HiResBackgroundService.this;
            super(looper);
            mHiResEnabled = new AtomicBoolean(true);
        }
    }

    public static interface OnHiresListener
    {

        public abstract void onHiresComplete();

        public abstract void onHiresError(AviaryExecutionException aviaryexecutionexception);

        public abstract void onHiresProgress(int i, int j);
    }

    private static class ProgressCounter
    {

        private long id;
        int index;
        int total;

        public long getId()
        {
            this;
            JVM INSTR monitorenter ;
            long l = id;
            this;
            JVM INSTR monitorexit ;
            return l;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void reset()
        {
            this;
            JVM INSTR monitorenter ;
            id = id + 1L;
            index = 0;
            total = 0;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        void toBundle(Bundle bundle)
        {
            bundle.putLong("counter_id", id);
            bundle.putInt("counter_index", index);
            bundle.putInt("counter_total", total);
        }

        public ProgressCounter()
        {
            id = 0L;
            index = 0;
            total = 0;
        }
    }


    public static final int HIRES_APPLY_ACTIONS = 1001;
    public static final int HIRES_LOAD = 1000;
    public static final int HIRES_REVERT = 1003;
    public static final int HIRES_SAVE = 1002;
    public static final int HIRES_STOP = 1999;
    private final com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private final ProgressCounter mCounter = new ProgressCounter();
    private OnHiresListener mListener;
    private InternalHandler mServiceHandler;
    private volatile Looper mServiceLooper;
    private MoaHD moa;
    private boolean running;
    private final HandlerThread thread = new HandlerThread("hires-looper", 10);

    public HiResBackgroundService(IAviaryController iaviarycontroller)
    {
        super(iaviarycontroller);
        logger = LoggerFactory.getLogger("HiResBackgroundService", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
        thread.start();
    }

    private void dispatchError(AviaryExecutionException aviaryexecutionexception)
    {
        logger.error("dispatchError: %d", new Object[] {
            Integer.valueOf(aviaryexecutionexception.getCode())
        });
        aviaryexecutionexception.printStackTrace();
        if (mListener != null)
        {
            mListener.onHiresError(aviaryexecutionexception);
            return;
        } else
        {
            logger.warn("no listeners attached");
            return;
        }
    }

    private void dispatchProgress(int i, int j)
    {
        logger.log((new StringBuilder()).append("dispatchProgress: ").append(i).append("/").append(j).toString());
        if (mListener != null)
        {
            mListener.onHiresProgress(i, j);
        }
    }

    private void dispatchSaveComplete()
    {
        if (mListener != null)
        {
            mListener.onHiresComplete();
        }
    }

    private Context getActivityContext()
    {
        IAviaryController iaviarycontroller = getContext();
        if (iaviarycontroller == null)
        {
            return null;
        } else
        {
            return iaviarycontroller.getBaseContext();
        }
    }

    private Handler getHandler()
    {
        return mServiceHandler;
    }

    private void internalLoad(Uri uri, int i, ImageInfo imageinfo)
    {
        logger.verbose((new StringBuilder()).append("internalLoad, size: ").append(i).toString(), new Object[0]);
        if (mServiceHandler != null)
        {
            removeAllMessages();
            mCounter.reset();
            int j = mCounter.index;
            Object obj = mCounter;
            int k = ((ProgressCounter) (obj)).total + 1;
            obj.total = k;
            dispatchProgress(j, k);
            i = Math.min(i, MegaPixels.Mp30.ordinal());
            obj = new Bundle();
            mCounter.toBundle(((Bundle) (obj)));
            Message message = mServiceHandler.obtainMessage(1000);
            message.obj = uri;
            message.arg1 = i;
            message.arg2 = imageinfo.getOrientation();
            message.setData(((Bundle) (obj)));
            mServiceHandler.sendMessage(message);
        }
    }

    private void quit()
    {
        logger.info("quit");
        running = false;
        if (moa != null)
        {
            if (moa.isLoaded())
            {
                try
                {
                    moa.unload();
                }
                catch (AviaryExecutionException aviaryexecutionexception) { }
            }
            moa.dispose();
        }
        moa = null;
        mServiceLooper.quit();
    }

    public void apply(MoaActionList moaactionlist)
    {
        logger.info("apply");
        if (mServiceHandler != null)
        {
            int i = mCounter.index;
            Object obj = mCounter;
            int j = ((ProgressCounter) (obj)).total + 1;
            obj.total = j;
            dispatchProgress(i, j);
            obj = new Bundle();
            mCounter.toBundle(((Bundle) (obj)));
            Message message = mServiceHandler.obtainMessage(1001);
            message.obj = moaactionlist;
            message.setData(((Bundle) (obj)));
            mServiceHandler.sendMessage(message);
        }
    }

    public void apply(String s)
    {
        logger.info("apply(s)");
        if (mServiceHandler != null)
        {
            int i = mCounter.index;
            Object obj = mCounter;
            int j = ((ProgressCounter) (obj)).total + 1;
            obj.total = j;
            dispatchProgress(i, j);
            obj = new Bundle();
            mCounter.toBundle(((Bundle) (obj)));
            Message message = mServiceHandler.obtainMessage(1001);
            message.obj = s;
            message.setData(((Bundle) (obj)));
            mServiceHandler.sendMessage(message);
        }
    }

    public void dispose()
    {
        logger.info("dispose");
        stop();
    }

    public boolean getHiresEnabled()
    {
        if (mServiceHandler != null)
        {
            return mServiceHandler.getHiresEnabled();
        } else
        {
            return false;
        }
    }

    public boolean isRunning()
    {
        return running;
    }

    public void load(Uri uri, int i, ImageInfo imageinfo)
    {
        logger.info("load: %s, maxSize: %d", new Object[] {
            uri, Integer.valueOf(i)
        });
        internalLoad(uri, i, imageinfo);
    }

    protected void removeAllMessages()
    {
        if (mServiceHandler != null)
        {
            mServiceHandler.removeMessages(1000);
            mServiceHandler.removeMessages(1003);
            mServiceHandler.removeMessages(1001);
        }
    }

    public void revert(Uri uri, int i, int j)
    {
        logger.info("revert: %s, maxSize: %d, orientation: %d", new Object[] {
            uri, Integer.valueOf(i), Integer.valueOf(j)
        });
        if (mServiceHandler != null)
        {
            removeAllMessages();
            mCounter.reset();
            int k = mCounter.index;
            Object obj = mCounter;
            int l = ((ProgressCounter) (obj)).total + 1;
            obj.total = l;
            dispatchProgress(k, l);
            i = Math.min(i, MegaPixels.Mp30.ordinal());
            obj = new Bundle();
            mCounter.toBundle(((Bundle) (obj)));
            Message message = mServiceHandler.obtainMessage(1003);
            message.obj = uri;
            message.arg1 = i;
            message.arg2 = j;
            message.setData(((Bundle) (obj)));
            mServiceHandler.sendMessage(message);
        }
    }

    public void save(String s, android.graphics.Bitmap.CompressFormat compressformat, int i)
    {
        logger.info("save");
        if (mServiceHandler != null)
        {
            int j = mCounter.index;
            Object obj = mCounter;
            int k = ((ProgressCounter) (obj)).total + 1;
            obj.total = k;
            dispatchProgress(j, k);
            obj = new Bundle();
            mCounter.toBundle(((Bundle) (obj)));
            Message message = mServiceHandler.obtainMessage(1002);
            message.obj = s;
            message.arg1 = compressformat.ordinal();
            message.arg2 = i;
            message.setData(((Bundle) (obj)));
            mServiceHandler.sendMessage(message);
        }
    }

    public void setOnHiresListener(OnHiresListener onhireslistener)
    {
        mListener = onhireslistener;
    }

    public void start()
    {
        logger.info("start");
        if (!running)
        {
            mServiceLooper = thread.getLooper();
            mServiceHandler = new InternalHandler(mServiceLooper);
            running = true;
        }
    }

    public void stop()
    {
        logger.info("stop");
        removeAllMessages();
        mServiceHandler.sendEmptyMessage(1999);
    }







/*
    static MoaHD access$402(HiResBackgroundService hiresbackgroundservice, MoaHD moahd)
    {
        hiresbackgroundservice.moa = moahd;
        return moahd;
    }

*/



}
