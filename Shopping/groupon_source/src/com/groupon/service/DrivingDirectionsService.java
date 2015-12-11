// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.models.drivingdirection.DrivingDirections;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            ApiServiceBase

public class DrivingDirectionsService
{
    public static final class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode BICYCLING;
        public static final Mode DRIVING;
        public static final Mode WALKING;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/groupon/service/DrivingDirectionsService$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        public String toString()
        {
            return super.toString().toLowerCase();
        }

        static 
        {
            DRIVING = new Mode("DRIVING", 0);
            WALKING = new Mode("WALKING", 1);
            BICYCLING = new Mode("BICYCLING", 2);
            $VALUES = (new Mode[] {
                DRIVING, WALKING, BICYCLING
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String URL_FORMAT = "http://maps.googleapis.com/maps/api/directions/json?origin=%f,%f&destination=%f,%f&mode=%s&sensor=false";
    private Context context;
    private ApiServiceBase getService;

    public DrivingDirectionsService()
    {
    }

    public void getDirections(double d, double d1, double d2, double d3, Mode mode, Function1 function1, ReturningFunction1 returningfunction1, Function0 function0)
    {
        if (!isEnabled())
        {
            return;
        } else
        {
            mode = String.format("http://maps.googleapis.com/maps/api/directions/json?origin=%f,%f&destination=%f,%f&mode=%s&sensor=false", new Object[] {
                Double.valueOf(d), Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3), mode
            });
            Ln.d("DIRECTIONS: url = %s", new Object[] {
                mode
            });
            getService.execute(function1, returningfunction1, function0, mode, "GET", null);
            return;
        }
    }

    public void init()
    {
        getService = new ApiServiceBase(context, com/groupon/models/drivingdirection/DrivingDirections);
    }

    public boolean isEnabled()
    {
        return false;
    }
}
