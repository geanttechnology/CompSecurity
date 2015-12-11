// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.groupon.models.hotel.HotelReservation;
import com.groupon.service.marketrate.HotelsService;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.IovationBlackboxUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class HotelReservationServiceFragment extends Fragment
{
    public static interface Callback
    {

        public abstract void onNewReservationFinished(HotelReservation hotelreservation, Exception exception);

        public abstract void onUpdateReservationFinished(HotelReservation hotelreservation, Exception exception);
    }


    public static final String TAG = com/groupon/fragment/HotelReservationServiceFragment.getName();
    private static final Callback dummyCallback = new Callback() {

        public void onNewReservationFinished(HotelReservation hotelreservation, Exception exception)
        {
        }

        public void onUpdateReservationFinished(HotelReservation hotelreservation, Exception exception)
        {
        }

    };
    private Callback callback;
    HotelsService hotelsService;
    IovationBlackboxUtil iovationBlackboxUtil;
    private HotelReservation reservation;
    private String roomToken;

    public HotelReservationServiceFragment()
    {
        callback = dummyCallback;
    }

    private void newReservation()
    {
        reservation = null;
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new String[] {
            "room_token", roomToken
        }));
        hotelsService.createReservation(arraylist, null, new Function1() {

            final HotelReservationServiceFragment this$0;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                if (list != null && !list.isEmpty())
                {
                    reservation = (HotelReservation)list.get(0);
                    callback.onNewReservationFinished(reservation, null);
                    return;
                } else
                {
                    callback.onNewReservationFinished(null, new IllegalStateException("The list of reservations should not be empty"));
                    return;
                }
            }

            
            {
                this$0 = HotelReservationServiceFragment.this;
                super();
            }
        }, new Function1() {

            final HotelReservationServiceFragment this$0;

            public void execute(Exception exception)
            {
                callback.onNewReservationFinished(null, exception);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Exception)obj);
            }

            
            {
                this$0 = HotelReservationServiceFragment.this;
                super();
            }
        }, null, new Function0() {

            final HotelReservationServiceFragment this$0;

            public void execute()
            {
                callback.onNewReservationFinished(null, null);
            }

            
            {
                this$0 = HotelReservationServiceFragment.this;
                super();
            }
        });
    }

    public HotelReservation getReservation()
    {
        return reservation;
    }

    public boolean hasReservation()
    {
        return reservation != null;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        callback = (Callback)activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
        setRetainInstance(true);
        if (bundle != null)
        {
            roomToken = bundle.getString("room_token");
        }
        newReservation();
    }

    public void onDetach()
    {
        super.onDetach();
        callback = dummyCallback;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("room_token", roomToken);
        super.onSaveInstanceState(bundle);
    }

    public void setRoomToken(String s)
    {
        roomToken = s;
    }

    public void updateReservation(String s, String s1, String s2, String s3)
    {
        if (reservation == null)
        {
            callback.onNewReservationFinished(null, new IllegalStateException("Reservation must be created first."));
            return;
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(Arrays.asList(new String[] {
                "user_id", s
            }));
            arraylist.addAll(Arrays.asList(new String[] {
                "traveler_first_name", s1
            }));
            arraylist.addAll(Arrays.asList(new String[] {
                "traveler_last_name", s2
            }));
            arraylist.addAll(Arrays.asList(new String[] {
                "billing_record_id", s3
            }));
            iovationBlackboxUtil.addIovationParameterIfNeeded(arraylist);
            hotelsService.updateReservation(reservation.uuid, arraylist, null, new Function1() {

                final HotelReservationServiceFragment this$0;

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((List)obj);
                }

                public void execute(List list)
                {
                    callback.onUpdateReservationFinished(reservation, null);
                }

            
            {
                this$0 = HotelReservationServiceFragment.this;
                super();
            }
            }, new Function1() {

                final HotelReservationServiceFragment this$0;

                public void execute(Exception exception)
                {
                    callback.onNewReservationFinished(null, exception);
                }

                public volatile void execute(Object obj)
                    throws Exception
                {
                    execute((Exception)obj);
                }

            
            {
                this$0 = HotelReservationServiceFragment.this;
                super();
            }
            }, null, null);
            return;
        }
    }




/*
    static HotelReservation access$002(HotelReservationServiceFragment hotelreservationservicefragment, HotelReservation hotelreservation)
    {
        hotelreservationservicefragment.reservation = hotelreservation;
        return hotelreservation;
    }

*/

}
