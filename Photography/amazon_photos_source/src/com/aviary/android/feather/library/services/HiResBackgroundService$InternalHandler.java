// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import com.aviary.android.feather.cds.CdsUtils;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.IOUtils;
import com.aviary.android.feather.headless.AviaryExecutionException;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaHD;
import com.aviary.android.feather.headless.utils.CameraUtils;
import com.aviary.android.feather.headless.utils.MegaPixels;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.library.services:
//            HiResBackgroundService

private final class mHiResEnabled extends Handler
{

    private AtomicBoolean mHiResEnabled;
    final HiResBackgroundService this$0;

    private void handleActions(MoaActionList moaactionlist)
    {
        HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("InternalHandler::handleActions", new Object[0]);
        if (mHiResEnabled.get())
        {
            if (HiResBackgroundService.access$400(HiResBackgroundService.this) != null && HiResBackgroundService.access$400(HiResBackgroundService.this).isLoaded() && moaactionlist != null)
            {
                try
                {
                    HiResBackgroundService.access$400(HiResBackgroundService.this).applyActions(moaactionlist);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (MoaActionList moaactionlist)
                {
                    HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0(moaactionlist.getMessage());
                    moaactionlist.printStackTrace();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (MoaActionList moaactionlist)
                {
                    HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0(moaactionlist.getMessage());
                }
                moaactionlist.printStackTrace();
                return;
            } else
            {
                HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("moa is not loaded..");
                return;
            }
        } else
        {
            HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("hires is not enabled, skipping actions..");
            return;
        }
    }

    private void handleActions(String s)
    {
        HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("InternalHandler::handleActions(s)", new Object[0]);
        if (mHiResEnabled.get())
        {
            if (HiResBackgroundService.access$400(HiResBackgroundService.this) != null && HiResBackgroundService.access$400(HiResBackgroundService.this).isLoaded() && s != null)
            {
                try
                {
                    HiResBackgroundService.access$400(HiResBackgroundService.this).applyActions(s);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0(s.getMessage());
                }
                s.printStackTrace();
                return;
            } else
            {
                HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("moa is not loaded..");
                return;
            }
        } else
        {
            HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("hires is not enabled, skipping actions..");
            return;
        }
    }

    private void handleFile(Uri uri, int i, int j)
    {
label0:
        {
            HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("InternalHandler::handleFile: %s, maxSize: %d, orientation: %d", new Object[] {
                uri, Integer.valueOf(i), Integer.valueOf(j)
            });
            uri = HiResBackgroundService.access$700(HiResBackgroundService.this);
            if (uri == null)
            {
                HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("Context is gone");
                return;
            }
            HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0((new StringBuilder()).append("orientation: ").append(j).toString(), new Object[0]);
            if (j != 0)
            {
                HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("need to rotate the image", new Object[0]);
                handleRotate90(j);
            }
            j = i;
            if (uri == null)
            {
                break label0;
            }
            j = i;
            if (CdsUtils.getPermissions(uri).contains(com.aviary.android.feather.cds.ernalHandler.handleRotate90.handleRotate90()))
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
            HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("overriding maxSize due to permissions constrains");
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
        HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0((new StringBuilder()).append("InternalHandler::handleResize: ").append(i).toString(), new Object[0]);
        if (mHiResEnabled.get())
        {
            if (HiResBackgroundService.access$400(HiResBackgroundService.this) != null && HiResBackgroundService.access$400(HiResBackgroundService.this).isLoaded() && i > 0)
            {
                HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0((new StringBuilder()).append("need to resize to ").append(i).toString(), new Object[0]);
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
            HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("hires is not enabled, skipping resize");
            return;
        }
    }

    private void handleRotate90(int i)
    {
        HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0((new StringBuilder()).append("InternalHandler::handleRotate: ").append(i).toString(), new Object[0]);
        if (mHiResEnabled.get())
        {
            if (HiResBackgroundService.access$400(HiResBackgroundService.this) != null && HiResBackgroundService.access$400(HiResBackgroundService.this).isLoaded())
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
            HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("hires is not enabled, skipping rotate90");
            return;
        }
    }

    private void loadImage(Uri uri, int i, int j)
        throws AviaryExecutionException
    {
        HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("InternalHandler::loadImage (uri: %s, maxSize: %d, orientation: %d)", new Object[] {
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
        if (HiResBackgroundService.access$400(HiResBackgroundService.this) == null)
        {
            HiResBackgroundService.access$402(HiResBackgroundService.this, new MoaHD());
            HiResBackgroundService.access$400(HiResBackgroundService.this).setOriginalEnabled(ApiHelper.isHiResOriginalAvailable());
        }
        String s;
        if (HiResBackgroundService.access$400(HiResBackgroundService.this).isLoaded())
        {
            try
            {
                HiResBackgroundService.access$400(HiResBackgroundService.this).unload();
            }
            catch (AviaryExecutionException aviaryexecutionexception) { }
        }
        obj = HiResBackgroundService.access$700(HiResBackgroundService.this);
        if (obj != null) goto _L2; else goto _L1
_L1:
        HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("Context is gone");
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
        HiResBackgroundService.access$400(HiResBackgroundService.this).load(s);
_L5:
        if (HiResBackgroundService.access$400(HiResBackgroundService.this).isLoaded())
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
                    HiResBackgroundService.access$400(HiResBackgroundService.this).load(((java.io.InputStream) (obj)));
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
                    HiResBackgroundService.access$400(HiResBackgroundService.this).load(((ParcelFileDescriptor) (obj)).getFileDescriptor());
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
        HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("InternalHandler::saveImage: %s, format: %d, quality: %d ", new Object[] {
            s, Integer.valueOf(i), Integer.valueOf(j)
        });
        if (mHiResEnabled.get())
        {
            if (!HiResBackgroundService.access$400(HiResBackgroundService.this).isLoaded())
            {
                throw AviaryExecutionException.fromInt(3);
            }
            android.graphics.undService undservice1 = android.graphics.tion.fromInt;
            android.graphics.undService undservice = undservice1;
            if (i >= 0)
            {
                undservice = undservice1;
                if (i < android.graphics.tion.fromInt().length)
                {
                    undservice = android.graphics.tion.fromInt()[i];
                }
            }
            HiResBackgroundService.access$400(HiResBackgroundService.this).save(s, j, undservice);
            return;
        } else
        {
            HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("hires is not enabled, skipping save");
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
        HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0((new StringBuilder()).append("handleMessage: ").append(message.what).toString());
        Bundle bundle = message.getData();
        if (bundle != null && bundle.getLong("counter_id", 0L) == HiResBackgroundService.access$100(HiResBackgroundService.this).getId())
        {
            HiResBackgroundService hiresbackgroundservice = HiResBackgroundService.this;
            mHiResEnabled mhiresenabled = HiResBackgroundService.access$100(HiResBackgroundService.this);
            int i = mhiresenabled.index + 1;
            mhiresenabled.index = i;
            HiResBackgroundService.access$200(hiresbackgroundservice, i, HiResBackgroundService.access$100(HiResBackgroundService.this).total);
        }
        message.what;
        JVM INSTR lookupswitch 5: default 168
    //                   1000: 169
    //                   1001: 319
    //                   1002: 361
    //                   1003: 201
    //                   1999: 353;
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
            HiResBackgroundService.access$300(HiResBackgroundService.this, message);
        }
        return;
_L5:
        boolean flag;
        boolean flag1;
        if (!HiResBackgroundService.access$400(HiResBackgroundService.this).isLoaded())
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = false;
        flag = flag1;
        if (!HiResBackgroundService.access$400(HiResBackgroundService.this).getOriginalEnabled())
        {
            break MISSING_BLOCK_LABEL_270;
        }
        HiResBackgroundService.access$400(HiResBackgroundService.this).revert();
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
                HiResBackgroundService.access$300(HiResBackgroundService.this, message);
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
        HiResBackgroundService.access$500(HiResBackgroundService.this);
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
            HiResBackgroundService.access$000(HiResBackgroundService.this)._mth0("handled save error: %s", new Object[] {
                message
            });
            HiResBackgroundService.access$300(HiResBackgroundService.this, message);
            return;
        }
        HiResBackgroundService.access$600(HiResBackgroundService.this);
        return;
    }

    public (Looper looper)
    {
        this$0 = HiResBackgroundService.this;
        super(looper);
        mHiResEnabled = new AtomicBoolean(true);
    }
}
