// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp.annotation;

import java.lang.annotation.Annotation;

public interface Platform
    extends Annotation
{

    public abstract String[] cinclude();

    public abstract String[] define();

    public abstract String[] framework();

    public abstract String[] include();

    public abstract String[] includepath();

    public abstract String library();

    public abstract String[] link();

    public abstract String[] linkpath();

    public abstract String[] not();

    public abstract String[] options();

    public abstract String[] preload();

    public abstract String[] preloadpath();

    public abstract String[] value();
}
