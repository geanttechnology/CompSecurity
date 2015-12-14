// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;

import com.bumptech.glide.request.target.Target;

public interface RequestListener
{

    public abstract boolean onException(Exception exception, Object obj, Target target, boolean flag);

    public abstract boolean onResourceReady(Object obj, Object obj1, Target target, boolean flag, boolean flag1);
}
