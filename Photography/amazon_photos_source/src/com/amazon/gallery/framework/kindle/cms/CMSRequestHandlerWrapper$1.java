// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;


// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSRequestHandlerWrapper, CMSRequestHandler

static final class ndlerFactory
    implements ndlerFactory
{

    public CMSRequestHandler newInstance(boolean flag)
    {
        return new CMSRequestHandlerWrapper();
    }

    ndlerFactory()
    {
    }
}
