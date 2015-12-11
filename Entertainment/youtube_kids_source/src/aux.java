// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.json.JSONArray;
import org.json.JSONObject;

public final class aux
{

    public long a;
    private double b;
    private int c;
    private int d;
    private long e;
    private long f;
    private double g;
    private boolean h;
    private long i[];

    public aux(JSONObject jsonobject)
    {
        a(jsonobject, 0);
    }

    public final int a(JSONObject jsonobject, int j)
    {
        byte byte0 = 2;
        boolean flag1 = false;
        boolean flag = true;
        long l1 = jsonobject.getLong("mediaSessionId");
        int l;
        int i1;
        if (l1 != a)
        {
            a = l1;
            l = 1;
        } else
        {
            l = 0;
        }
        i1 = l;
        if (jsonobject.has("playerState"))
        {
            long al[] = jsonobject.getString("playerState");
            int k;
            int j1;
            if (al.equals("IDLE"))
            {
                k = 1;
            } else
            if (al.equals("PLAYING"))
            {
                k = 2;
            } else
            if (al.equals("PAUSED"))
            {
                k = 3;
            } else
            if (al.equals("BUFFERING"))
            {
                k = 4;
            } else
            {
                k = 0;
            }
            j1 = l;
            if (k != c)
            {
                c = k;
                j1 = l | 2;
            }
            i1 = j1;
            if (k == 1)
            {
                i1 = j1;
                if (jsonobject.has("idleReason"))
                {
                    al = jsonobject.getString("idleReason");
                    double d1;
                    JSONArray jsonarray;
                    long l2;
                    boolean flag2;
                    if (al.equals("CANCELLED"))
                    {
                        k = byte0;
                    } else
                    if (al.equals("INTERRUPTED"))
                    {
                        k = 3;
                    } else
                    if (al.equals("FINISHED"))
                    {
                        k = 1;
                    } else
                    if (al.equals("ERROR"))
                    {
                        k = 4;
                    } else
                    {
                        k = 0;
                    }
                    i1 = j1;
                    if (k != d)
                    {
                        d = k;
                        i1 = j1 | 2;
                    }
                }
            }
        }
        k = i1;
        if (jsonobject.has("playbackRate"))
        {
            d1 = jsonobject.getDouble("playbackRate");
            k = i1;
            if (b != d1)
            {
                b = d1;
                k = i1 | 2;
            }
        }
        i1 = k;
        if (jsonobject.has("currentTime"))
        {
            i1 = k;
            if ((j & 2) == 0)
            {
                l2 = (long)(jsonobject.getDouble("currentTime") * 1000D);
                i1 = k;
                if (l2 != e)
                {
                    e = l2;
                    i1 = k | 2;
                }
            }
        }
        l = i1;
        if (jsonobject.has("supportedMediaCommands"))
        {
            l2 = jsonobject.getLong("supportedMediaCommands");
            l = i1;
            if (l2 != f)
            {
                f = l2;
                l = i1 | 2;
            }
        }
        k = l;
        if (jsonobject.has("volume"))
        {
            k = l;
            if ((j & 1) == 0)
            {
                al = jsonobject.getJSONObject("volume");
                d1 = al.getDouble("level");
                j = l;
                if (d1 != g)
                {
                    g = d1;
                    j = l | 2;
                }
                flag2 = al.getBoolean("muted");
                k = j;
                if (flag2 != h)
                {
                    h = flag2;
                    k = j | 2;
                }
            }
        }
        if (!jsonobject.has("activeTrackIds")) goto _L2; else goto _L1
_L1:
        jsonarray = jsonobject.getJSONArray("activeTrackIds");
        i1 = jsonarray.length();
        al = new long[i1];
        for (j = 0; j < i1; j++)
        {
            al[j] = jsonarray.getLong(j);
        }

        if (i != null) goto _L4; else goto _L3
_L3:
        j = ((flag) ? 1 : 0);
_L8:
        if (j != 0)
        {
            i = al;
        }
        l = j;
_L6:
        j = k;
        if (l != 0)
        {
            i = al;
            j = k | 2;
        }
        k = j;
        if (jsonobject.has("customData"))
        {
            jsonobject.getJSONObject("customData");
            k = j | 2;
        }
        j = k;
        if (jsonobject.has("media"))
        {
            jsonobject = jsonobject.getJSONObject("media");
            new auu(jsonobject);
            k |= 2;
            j = k;
            if (jsonobject.has("metadata"))
            {
                j = k | 4;
            }
        }
        return j;
_L4:
        j = ((flag) ? 1 : 0);
        if (i.length != i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        for (l = 0; l < i1; l++)
        {
            j = ((flag) ? 1 : 0);
            if (i[l] != al[l])
            {
                continue; /* Loop/switch isn't completed */
            }
        }

        break; /* Loop/switch isn't completed */
_L2:
        if (i != null)
        {
            l = 1;
            al = null;
        } else
        {
            al = null;
            l = ((flag1) ? 1 : 0);
        }
        if (true) goto _L6; else goto _L5
_L5:
        j = 0;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
