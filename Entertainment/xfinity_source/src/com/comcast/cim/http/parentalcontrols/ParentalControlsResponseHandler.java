// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.http.parentalcontrols;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.cmasl.xip.XipResponseHandler;
import com.comcast.cim.model.parentalcontrols.ParentalControlsSettings;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

public class ParentalControlsResponseHandler extends XipResponseHandler
{

    private final ObjectMapper mapper;
    private ParentalControlsSettings pcSettings;

    public ParentalControlsResponseHandler(ObjectMapper objectmapper)
    {
        mapper = objectmapper;
    }

    public ParentalControlsSettings getParentalControlsSettings()
    {
        return pcSettings;
    }

    public void handleResponseBody(InputStream inputstream)
    {
        try
        {
            pcSettings = (ParentalControlsSettings)mapper.readValue(inputstream, com/comcast/cim/model/parentalcontrols/ParentalControlsSettings);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new CimIOException(inputstream);
        }
    }
}
