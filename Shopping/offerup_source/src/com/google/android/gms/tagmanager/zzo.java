// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.os.Looper;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.tagmanager:
//            ContainerHolder, TagManager, Container, zzbg

class zzo
    implements ContainerHolder
{

    private Status zzSC;
    private Container zzaVY;
    private Container zzaVZ;
    private zzb zzaWa;
    private zza zzaWb;
    private TagManager zzaWc;
    private final Looper zzaaO;
    private boolean zzajJ;

    public zzo(Status status)
    {
        zzSC = status;
        zzaaO = null;
    }

    public zzo(TagManager tagmanager, Looper looper, Container container, zza zza1)
    {
        zzaWc = tagmanager;
        if (looper == null)
        {
            looper = Looper.getMainLooper();
        }
        zzaaO = looper;
        zzaVY = container;
        zzaWb = zza1;
        zzSC = Status.zzabb;
        tagmanager.zza(this);
    }

    private void zzCw()
    {
        if (zzaWa != null)
        {
            zzaWa.zzeF(zzaVZ.zzCt());
        }
    }

    public Container getContainer()
    {
        Container container = null;
        this;
        JVM INSTR monitorenter ;
        if (!zzajJ) goto _L2; else goto _L1
_L1:
        zzbg.e("ContainerHolder is released.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return container;
_L2:
        if (zzaVZ != null)
        {
            zzaVY = zzaVZ;
            zzaVZ = null;
        }
        container = zzaVY;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    String getContainerId()
    {
        if (zzajJ)
        {
            zzbg.e("getContainerId called on a released ContainerHolder.");
            return "";
        } else
        {
            return zzaVY.getContainerId();
        }
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public void refresh()
    {
        this;
        JVM INSTR monitorenter ;
        if (!zzajJ) goto _L2; else goto _L1
_L1:
        zzbg.e("Refreshing a released ContainerHolder.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzaWb.zzCx();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void release()
    {
        this;
        JVM INSTR monitorenter ;
        if (!zzajJ) goto _L2; else goto _L1
_L1:
        zzbg.e("Releasing a released ContainerHolder.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzajJ = true;
        zzaWc.zzb(this);
        zzaVY.release();
        zzaVY = null;
        zzaVZ = null;
        zzaWb = null;
        zzaWa = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void setContainerAvailableListener(ContainerHolder.ContainerAvailableListener containeravailablelistener)
    {
        this;
        JVM INSTR monitorenter ;
        if (!zzajJ) goto _L2; else goto _L1
_L1:
        zzbg.e("ContainerHolder is released.");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (containeravailablelistener != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        zzaWa = null;
          goto _L3
        containeravailablelistener;
        throw containeravailablelistener;
        zzaWa = new zzb(containeravailablelistener, zzaaO);
        if (zzaVZ != null)
        {
            zzCw();
        }
          goto _L3
    }

    String zzCv()
    {
        if (zzajJ)
        {
            zzbg.e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
            return "";
        } else
        {
            return zzaWb.zzCv();
        }
    }

    public void zza(Container container)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = zzajJ;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (container != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        zzbg.e("Unexpected null container.");
          goto _L1
        container;
        throw container;
        zzaVZ = container;
        zzCw();
          goto _L1
    }

    public void zzeC(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = zzajJ;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        zzaVY.zzeC(s);
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    void zzeE(String s)
    {
        if (zzajJ)
        {
            zzbg.e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
            return;
        } else
        {
            zzaWb.zzeE(s);
            return;
        }
    }

    private class zzb extends Handler
    {

        private final ContainerHolder.ContainerAvailableListener zzaWd;
        final zzo zzaWe;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                zzbg.e("Don't know how to handle this message.");
                return;

            case 1: // '\001'
                zzeG((String)message.obj);
                break;
            }
        }

        public void zzeF(String s)
        {
            sendMessage(obtainMessage(1, s));
        }

        protected void zzeG(String s)
        {
            zzaWd.onContainerAvailable(zzaWe, s);
        }

        public zzb(ContainerHolder.ContainerAvailableListener containeravailablelistener, Looper looper)
        {
            zzaWe = zzo.this;
            super(looper);
            zzaWd = containeravailablelistener;
        }
    }


    private class zza
    {

        public abstract String zzCv();

        public abstract void zzCx();

        public abstract void zzeE(String s);
    }

}
