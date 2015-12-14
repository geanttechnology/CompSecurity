// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator.actions;

import com.socialin.android.brushlib.project.Project;
import com.socialin.android.videogenerator.layer.LayerConfig;
import java.io.File;
import java.util.List;
import java.util.UUID;
import myobfuscated.cz.a;

// Referenced classes of package com.socialin.android.videogenerator.actions:
//            AsyncAction

public class LayerAdditionAction extends AsyncAction
{

    private static final long serialVersionUID = 0xaac40dae97fca0d3L;
    private String imageBufferPath;
    private UUID layerId;

    public LayerAdditionAction(UUID uuid, String s, String s1)
    {
        super(s1);
        layerId = uuid;
        imageBufferPath = s;
        if (imageBufferPath == null)
        {
            imageBufferPath = "";
        }
    }

    public void apply(a a1)
    {
        Object obj;
        int i;
label0:
        {
            obj = new File(a1.a.getLayerOrigBuffersFolder(), imageBufferPath);
            if (!((File) (obj)).exists())
            {
                obj = new com.socialin.android.videogenerator.layer.a(getLayerId(), a1.c, a1.d, new LayerConfig(), a1.e, a1.f);
            } else
            {
                obj = new com.socialin.android.videogenerator.layer.a(getLayerId(), a1.c, a1.d, ((File) (obj)).getAbsolutePath(), new LayerConfig(), a1.e, a1.f);
            }
            i = a1.b.size();
            if (i >= 0 || i < a1.b.size())
            {
                if (i != a1.b.size())
                {
                    break label0;
                }
                a1.b.add(obj);
            }
            return;
        }
        a1.b.add(i, obj);
    }

    public String getActionDescription()
    {
        return "Layer Addition";
    }

    public String getImageBufferPath()
    {
        return imageBufferPath;
    }

    public UUID getLayerId()
    {
        return layerId;
    }

    public void setImageBufferPath(String s)
    {
        imageBufferPath = s;
    }

    public void setLayerId(UUID uuid)
    {
        layerId = uuid;
    }

    public String toString()
    {
        return (new StringBuilder("LayerAdditionAction Layer Id:")).append(layerId).append("  Buffer Path:").append(imageBufferPath).toString();
    }
}
