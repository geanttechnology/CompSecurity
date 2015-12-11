// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pinterest.android.pdk;

import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.pinterest.android.pdk:
//            PDKBoard, PDKInterest, PDKPin, PDKUser, 
//            PDKClient, PDKCallback

public class PDKResponse
{

    protected String _cursor;
    protected Object _data;
    protected HashMap _params;
    protected String _path;
    protected int _statusCode;

    public PDKResponse(JSONObject jsonobject)
    {
        _cursor = null;
        _statusCode = -1;
        if (jsonobject != null)
        {
            if (jsonobject.has("data"))
            {
                try
                {
                    setData(jsonobject.get("data"));
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                }
            }
            if (jsonobject.has("page"))
            {
                try
                {
                    jsonobject = jsonobject.getJSONObject("page");
                    if (jsonobject.has("cursor"))
                    {
                        _cursor = jsonobject.getString("cursor");
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    jsonobject.printStackTrace();
                    return;
                }
            }
        }
    }

    public PDKBoard getBoard()
    {
        return PDKBoard.makeBoard(_data);
    }

    public List getBoardList()
    {
        return PDKBoard.makeBoardList(_data);
    }

    public Object getData()
    {
        return _data;
    }

    public PDKInterest getInterest()
    {
        return PDKInterest.makeInterest(_data);
    }

    public List getInterestList()
    {
        return PDKInterest.makeInterestList(_data);
    }

    public PDKPin getPin()
    {
        return PDKPin.makePin(_data);
    }

    public List getPinList()
    {
        return PDKPin.makePinList(_data);
    }

    public final int getStatusCode()
    {
        return _statusCode;
    }

    public PDKUser getUser()
    {
        return PDKUser.makeUser(_data);
    }

    public List getUserList()
    {
        return PDKUser.makeUserList(_data);
    }

    public boolean hasNext()
    {
        return _cursor != null && _cursor.length() > 0 && !_cursor.equalsIgnoreCase("null");
    }

    public boolean isValid()
    {
        return _data != null;
    }

    public void loadNext(PDKCallback pdkcallback)
    {
        _params.put("cursor", _cursor);
        PDKClient.getInstance().getPath(_path, _params, pdkcallback);
    }

    public void setData(Object obj)
    {
        _data = obj;
    }

    public void setParams(HashMap hashmap)
    {
        _params = hashmap;
    }

    public void setPath(String s)
    {
        _path = s;
    }

    public final void setStatusCode(int i)
    {
        _statusCode = i;
    }
}
