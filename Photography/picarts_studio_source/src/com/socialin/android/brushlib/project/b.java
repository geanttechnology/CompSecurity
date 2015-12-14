// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.project;

import com.socialin.android.brushlib.state.LayerMetaInfo;
import com.socialin.android.brushlib.state.Snapshot;
import com.socialin.android.videogenerator.ActionCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import myobfuscated.br.e;

// Referenced classes of package com.socialin.android.brushlib.project:
//            c

public final class b
    implements c
{

    private final List a;
    private final Snapshot b;

    public b(e e1)
    {
        a = new ArrayList(Collections.unmodifiableList(e1.a));
        b = (Snapshot)e1.c();
    }

    public final boolean a(String s)
    {
        if (s.equals((new StringBuilder()).append(b.key).append(".thumb").toString()))
        {
            return true;
        }
        if (s.equals("INDEX"))
        {
            return true;
        }
        if (s.equals("editingdat.aaf"))
        {
            return true;
        }
        if (s.equals("brush-data"))
        {
            return true;
        }
        if (s.equals("orig-buffers"))
        {
            return true;
        }
        Iterator iterator = a.iterator();
label0:
        do
        {
            if (iterator.hasNext())
            {
                Object obj = (Snapshot)iterator.next();
                if (s.equals(((Snapshot) (obj)).key))
                {
                    return true;
                }
                if (((Snapshot) (obj)).cameraLayerInfo != null)
                {
                    if (s.equals(((Snapshot) (obj)).cameraLayerInfo.currentBufferKey))
                    {
                        return true;
                    }
                    if (s.equals(((Snapshot) (obj)).cameraLayerInfo.origBufferKey))
                    {
                        return true;
                    }
                    if (s.equals(((Snapshot) (obj)).cameraLayerInfo.key))
                    {
                        return true;
                    }
                }
                obj = ((Snapshot) (obj)).layerInfoList.iterator();
                LayerMetaInfo layermetainfo;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue label0;
                    }
                    layermetainfo = (LayerMetaInfo)((Iterator) (obj)).next();
                    if (s.equals(layermetainfo.key))
                    {
                        return true;
                    }
                    if (s.equals(layermetainfo.currentBufferKey))
                    {
                        return true;
                    }
                } while (!s.equals(layermetainfo.origBufferKey));
                break;
            } else
            {
                ActionCollector.a();
                return ActionCollector.a(s);
            }
        } while (true);
        return true;
    }
}
