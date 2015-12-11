// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events;

import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.util.JSONBuilder;
import com.amazon.device.analytics.util.JSONSerializable;
import com.amazon.device.analytics.util.StringUtil;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.analytics.events:
//            UniqueIdResolver

public abstract class UniqueIdResolverChain
    implements UniqueIdResolver, JSONSerializable
{

    private static Logger logger = Logging.getLogger(com/amazon/device/analytics/events/UniqueIdResolverChain);
    private final ReentrantLock lock;
    private final UniqueIdResolver nextResolver;

    public UniqueIdResolverChain()
    {
        this(null);
    }

    public UniqueIdResolverChain(UniqueIdResolver uniqueidresolver)
    {
        lock = new ReentrantLock(true);
        nextResolver = uniqueidresolver;
    }

    protected UniqueIdResolver next()
    {
        return nextResolver;
    }

    public String resolveUniqueId()
    {
        lock.lock();
        Object obj = tryResolve();
        lock.unlock();
        if (!StringUtil.isNullOrEmpty(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_84;
        }
        UniqueIdResolver uniqueidresolver = next();
        if (uniqueidresolver == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        obj = uniqueidresolver.resolveUniqueId();
        lock.lock();
        tryStore(((String) (obj)));
        lock.unlock();
        return ((String) (obj));
        obj;
        lock.unlock();
        throw obj;
        obj;
        lock.unlock();
        throw obj;
        logger.v(String.format("Resolved uniqueId: %s from UniqueIdResolver: %s", new Object[] {
            obj, this
        }));
        return ((String) (obj));
    }

    public JSONObject toJSONObject()
    {
        JSONBuilder jsonbuilder = new JSONBuilder(this);
        String s1 = tryResolve();
        String s = s1;
        if (s1 == null)
        {
            s = "";
        }
        jsonbuilder.withAttribute("uniqueId", s).withAttribute("nextResolver", next());
        return jsonbuilder.toJSONObject();
    }

    public String toString()
    {
        JSONObject jsonobject = toJSONObject();
        String s;
        try
        {
            s = jsonobject.toString(4);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject.toString();
        }
        return s;
    }

    protected abstract String tryResolve();

    protected abstract boolean tryStore(String s);

}
