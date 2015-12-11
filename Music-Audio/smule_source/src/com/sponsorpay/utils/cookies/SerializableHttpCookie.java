// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils.cookies;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.HttpCookie;

public class SerializableHttpCookie
    implements Serializable
{

    private static final long serialVersionUID = 0xac0501b04dfa7c20L;
    private transient HttpCookie cookie;

    public SerializableHttpCookie(HttpCookie httpcookie)
    {
        cookie = httpcookie;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        cookie = new HttpCookie((String)objectinputstream.readObject(), (String)objectinputstream.readObject());
        cookie.setComment((String)objectinputstream.readObject());
        cookie.setCommentURL((String)objectinputstream.readObject());
        cookie.setDiscard(objectinputstream.readBoolean());
        cookie.setDomain((String)objectinputstream.readObject());
        cookie.setMaxAge(objectinputstream.readLong());
        cookie.setPath((String)objectinputstream.readObject());
        cookie.setPortlist((String)objectinputstream.readObject());
        cookie.setSecure(objectinputstream.readBoolean());
        cookie.setVersion(objectinputstream.readInt());
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(cookie.getName());
        objectoutputstream.writeObject(cookie.getValue());
        objectoutputstream.writeObject(cookie.getComment());
        objectoutputstream.writeObject(cookie.getCommentURL());
        objectoutputstream.writeBoolean(cookie.getDiscard());
        objectoutputstream.writeObject(cookie.getDomain());
        objectoutputstream.writeLong(cookie.getMaxAge());
        objectoutputstream.writeObject(cookie.getPath());
        objectoutputstream.writeObject(cookie.getPortlist());
        objectoutputstream.writeBoolean(cookie.getSecure());
        objectoutputstream.writeInt(cookie.getVersion());
    }

    public HttpCookie getCookie()
    {
        return cookie;
    }
}
