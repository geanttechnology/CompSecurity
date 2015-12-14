// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.pages.photoimport;

import java.io.Serializable;

public class ImageItem
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String appliedEffectImg;
    private String audioDuration;
    private String audioPath;
    private String bucket;
    private String bucketId;
    private boolean checked;
    private int childCount;
    private String description;
    private String handDrawImg;
    private String hashKey;
    private long imageId;
    private int orgHeight;
    private String orgImg;
    private int orgWidth;
    private int orientation;
    private String title;

    public ImageItem(String s, long l, String s1, String s2, String s3, int i, 
            int j, String s4)
    {
        this(s, l, s1, s2, s3, i, j, s4, "", "", "", "", "");
    }

    public ImageItem(String s, long l, String s1, String s2, String s3, int i, 
            int j, String s4, String s5, String s6, String s7, String s8, String s9)
    {
        bucket = s1;
        orgImg = s2;
        orgWidth = 0;
        orgHeight = 0;
        title = s3;
        bucketId = s;
        imageId = l;
        childCount = i;
        checked = false;
        orientation = j;
        hashKey = s4;
        description = s5;
        audioPath = s6;
        audioDuration = s7;
        handDrawImg = s8;
        appliedEffectImg = s9;
    }

    public long a()
    {
        return imageId;
    }

    public void a(int i)
    {
        childCount = i;
    }

    public String b()
    {
        return orgImg;
    }

    public int c()
    {
        return childCount;
    }

    public String d()
    {
        return hashKey;
    }

    public String toString()
    {
        String s = (new StringBuilder()).append("{").append("\"bucket\":\"").append(bucket).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"orgImg\":\"").append(orgImg).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"orgWidth\":\"").append(orgWidth).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"orgHeight\":\"").append(orgHeight).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"title\":\"").append(title).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"bucketId\":\"").append(bucketId).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"imageId\":\"").append(imageId).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"childCount\":\"").append(childCount).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"checked\":\"").append(checked).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"orientation\":\"").append(orientation).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"hashKey\":\"").append(hashKey).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"description\":\"").append(description).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"audioPath\":\"").append(audioPath).append("\",").toString();
        s = (new StringBuilder()).append(s).append("\"audioDuration\":\"").append(audioDuration).append("\"").toString();
        s = (new StringBuilder()).append(s).append("\"handDrawImg\":\"").append(handDrawImg).append("\"").toString();
        s = (new StringBuilder()).append(s).append("\"appliedEffectImg\":\"").append(appliedEffectImg).append("\"").toString();
        return (new StringBuilder()).append(s).append("}").toString();
    }
}
