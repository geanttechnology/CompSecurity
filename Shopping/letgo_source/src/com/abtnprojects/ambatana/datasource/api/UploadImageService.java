// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import com.abtnprojects.ambatana.models.product.ApiImageToken;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedString;

public interface UploadImageService
{

    public abstract ApiImageToken uploadImage(TypedString typedstring, TypedInput typedinput);
}
