// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib;

import com.socialin.android.brushlib.view.Camera;

// Referenced classes of package com.socialin.android.brushlib:
//            Transform

class MappedTransform extends Transform
{

    private static final long serialVersionUID = 1L;
    private final Camera mappingCamera;
    private final Transform transform;

    protected MappedTransform(Transform transform1, Camera camera)
    {
        transform = transform1;
        mappingCamera = camera;
    }

    public MappedTransform clone()
    {
        return new MappedTransform(transform.clone(), mappingCamera);
    }

    public volatile Transform clone()
    {
        return clone();
    }

    public volatile Object clone()
    {
        return clone();
    }

    public float getCx()
    {
        return mappingCamera.b(transform.getCx());
    }

    public float getCy()
    {
        return mappingCamera.c(transform.getCy());
    }

    public Camera getMappingCamera()
    {
        return mappingCamera;
    }

    public float getRotation()
    {
        return transform.getRotation();
    }

    public float getSx()
    {
        return mappingCamera.e * transform.getSx();
    }

    public float getSy()
    {
        return mappingCamera.e * transform.getSy();
    }

    public Transform setCx(float f)
    {
        transform.setCx(mappingCamera.d(f));
        return this;
    }

    public Transform setCy(float f)
    {
        transform.setCy(mappingCamera.e(f));
        return this;
    }

    public Transform setRotation(float f)
    {
        transform.setRotation(f);
        return this;
    }

    public Transform setSx(float f)
    {
        transform.setSx(f / mappingCamera.e);
        return this;
    }

    public Transform setSy(float f)
    {
        transform.setSy(f / mappingCamera.e);
        return this;
    }
}
