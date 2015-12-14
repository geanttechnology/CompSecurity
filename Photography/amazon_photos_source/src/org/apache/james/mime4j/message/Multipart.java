// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.message;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.james.mime4j.util.ByteSequence;
import org.apache.james.mime4j.util.ContentUtil;

// Referenced classes of package org.apache.james.mime4j.message:
//            Body, BodyPart, Entity

public class Multipart
    implements Body
{

    private List bodyParts;
    private ByteSequence epilogue;
    private transient String epilogueStrCache;
    private Entity parent;
    private ByteSequence preamble;
    private transient String preambleStrCache;
    private String subType;

    public Multipart(String s)
    {
        bodyParts = new LinkedList();
        parent = null;
        preamble = ByteSequence.EMPTY;
        preambleStrCache = "";
        epilogue = ByteSequence.EMPTY;
        epilogueStrCache = "";
        subType = s;
    }

    public void addBodyPart(BodyPart bodypart)
    {
        if (bodypart == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            bodyParts.add(bodypart);
            bodypart.setParent(parent);
            return;
        }
    }

    public List getBodyParts()
    {
        return Collections.unmodifiableList(bodyParts);
    }

    public String getEpilogue()
    {
        if (epilogueStrCache == null)
        {
            epilogueStrCache = ContentUtil.decode(epilogue);
        }
        return epilogueStrCache;
    }

    ByteSequence getEpilogueRaw()
    {
        return epilogue;
    }

    public Entity getParent()
    {
        return parent;
    }

    public String getPreamble()
    {
        if (preambleStrCache == null)
        {
            preambleStrCache = ContentUtil.decode(preamble);
        }
        return preambleStrCache;
    }

    ByteSequence getPreambleRaw()
    {
        return preamble;
    }

    public void setParent(Entity entity)
    {
        parent = entity;
        for (Iterator iterator = bodyParts.iterator(); iterator.hasNext(); ((BodyPart)iterator.next()).setParent(entity)) { }
    }
}
