// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.model.Model;
import java.util.ArrayList;

public class Tags extends Model
{

    public ArrayList circleTags;
    public ArrayList emojiTags;
    public String lookTag;
    public ArrayList productTags;
    public ArrayList receiverTag;

    public Tags()
    {
        emojiTags = null;
        productTags = null;
        circleTags = null;
        receiverTag = null;
        lookTag = null;
    }
}
