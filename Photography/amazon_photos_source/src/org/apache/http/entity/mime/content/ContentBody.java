// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.entity.mime.content;

import org.apache.james.mime4j.descriptor.ContentDescriptor;
import org.apache.james.mime4j.message.Body;

public interface ContentBody
    extends ContentDescriptor, Body
{

    public abstract String getFilename();
}
