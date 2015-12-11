// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import com.abtnprojects.ambatana.models.CurrentUserLocation;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SaveCallback;

// Referenced classes of package android.support.v7:
//            aqo, iu

public class io
{

    public static void a(LetgoAddress letgoaddress)
    {
        ParseUser parseuser = ParseUser.getCurrentUser();
        String s2;
        parseuser.put("processed", Boolean.valueOf(false));
        parseuser.save();
        s2 = letgoaddress.getStreetName();
        String s;
        s = s2;
        if (s2 == null)
        {
            s = "";
        }
        parseuser.put("address", s);
        s2 = letgoaddress.getCity();
        s = s2;
        if (s2 == null)
        {
            s = "";
        }
        parseuser.put("city", s);
        s2 = letgoaddress.getCountryCode();
        s = s2;
        if (s2 == null)
        {
            s = "";
        }
        parseuser.put("country_code", s);
        s2 = letgoaddress.getZipCode();
        String s1 = s2;
        if (s2 == null)
        {
            s1 = "";
        }
        try
        {
            parseuser.put("zipcode", s1);
            parseuser.put("precisely_located", Boolean.valueOf(CurrentUserLocation.isPreciselyLocated(letgoaddress)));
            letgoaddress = letgoaddress.getPoint();
            parseuser.put("gpscoords", new ParseGeoPoint(letgoaddress.getLatitude(), letgoaddress.getLongitude()));
            parseuser.put("processed", Boolean.valueOf(false));
            parseuser.save();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (LetgoAddress letgoaddress)
        {
            aqo.b(letgoaddress, "saveUserLocation: error saving the current user location", new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (LetgoAddress letgoaddress)
        {
            aqo.b(letgoaddress, "saveUserLocation: error invalid user to save address", new Object[0]);
        }
        return;
    }

    public static void a(ParseUser parseuser, ParseInstallation parseinstallation)
    {
label0:
        {
            if (iu.c(parseuser))
            {
                String s = parseuser.getUsername();
                if (parseinstallation.has("username"))
                {
                    parseuser = parseinstallation.getString("username");
                } else
                {
                    parseuser = null;
                }
                if (!s.equals(parseuser))
                {
                    parseinstallation.put("username", ParseUser.getCurrentUser().getUsername());
                    parseuser = ParseUser.getCurrentUser().getObjectId();
                    if (!TextUtils.isEmpty(parseuser))
                    {
                        break label0;
                    }
                    parseuser = ParseUser.getCurrentUser();
                    parseuser.put("processed", Boolean.valueOf(false));
                    parseuser.saveInBackground(new SaveCallback(parseinstallation) {

                        final ParseInstallation a;

                        public void done(ParseException parseexception)
                        {
                            if (parseexception == null)
                            {
                                parseexception = ParseUser.getCurrentUser().getObjectId();
                                a.put("user_objectId", parseexception);
                                a.saveInBackground();
                            }
                        }

                        public volatile void done(Throwable throwable)
                        {
                            done((ParseException)throwable);
                        }

            
            {
                a = parseinstallation;
                super();
            }
                    });
                }
            }
            return;
        }
        parseinstallation.put("user_objectId", parseuser);
        parseinstallation.saveInBackground(new SaveCallback(parseuser) {

            final String a;

            public void done(ParseException parseexception)
            {
                if (parseexception != null)
                {
                    aqo.b(parseexception, "Error saving installation details userId : %s ", new Object[] {
                        a
                    });
                }
            }

            public volatile void done(Throwable throwable)
            {
                done((ParseException)throwable);
            }

            
            {
                a = s;
                super();
            }
        });
    }
}
