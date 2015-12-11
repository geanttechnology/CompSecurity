// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            Logger

public class CvAudience
{

    public static int NUMBER_OF_CHILDREN_UNKNOWN = -1;
    private Calendar birthDate;
    private Gender gender;
    private int numberOfChildren;
    private RelationshipStatus relationshipStatus;

    private CvAudience()
    {
    /* block-local class not found */
    class Gender {}

        gender = Gender.UNKNOWN;
        birthDate = null;
    /* block-local class not found */
    class RelationshipStatus {}

        relationshipStatus = RelationshipStatus.UNKNOWN;
        numberOfChildren = NUMBER_OF_CHILDREN_UNKNOWN;
    }

    CvAudience(_cls1 _pcls1)
    {
        this();
    }

    static CvAudience getInstance()
    {
    /* block-local class not found */
    class CvAudienceHolder {}

        return CvAudienceHolder.INSTANCE;
    }

    public int getAge()
    {
        if (birthDate == null)
        {
            return -1;
        } else
        {
            return (new GregorianCalendar()).get(1) - birthDate.get(1);
        }
    }

    public Calendar getBirthDate()
    {
        return birthDate;
    }

    String getBirthDateString()
    {
        if (birthDate == null)
        {
            return "";
        } else
        {
            return (new SimpleDateFormat("yyyy-MM-dd")).format(birthDate.getTime());
        }
    }

    public Gender getGender()
    {
        return gender;
    }

    String getGenderString()
    {
        return gender.toString();
    }

    JSONObject getJSON()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("gender", getGenderString());
            jsonobject.put("birthDate", getBirthDateString());
            jsonobject.put("relationshipStatus", getRelationshipStatusString());
            jsonobject.put("numberOfChildren", getNumberOfChildrenString());
        }
        catch (JSONException jsonexception)
        {
            Logger.get().e(jsonexception, new Object[] {
                "Cannot build JSON from audience"
            });
            return jsonobject;
        }
        return jsonobject;
    }

    public int getNumberOfChildren()
    {
        return numberOfChildren;
    }

    String getNumberOfChildrenString()
    {
        if (numberOfChildren == NUMBER_OF_CHILDREN_UNKNOWN)
        {
            return "";
        } else
        {
            return String.format("%d", new Object[] {
                Integer.valueOf(numberOfChildren)
            });
        }
    }

    public RelationshipStatus getRelationshipStatus()
    {
        return relationshipStatus;
    }

    String getRelationshipStatusString()
    {
        return relationshipStatus.toString();
    }

    public void setAge(int i)
    {
        if (i <= 0)
        {
            setBirthDate(null);
            return;
        } else
        {
            GregorianCalendar gregoriancalendar = new GregorianCalendar();
            gregoriancalendar.add(1, i * -1);
            setBirthDate(gregoriancalendar);
            return;
        }
    }

    public void setBirthDate(Calendar calendar)
    {
        if (calendar == null || calendar.get(1) >= (new GregorianCalendar()).get(1))
        {
            birthDate = null;
            return;
        } else
        {
            birthDate = calendar;
            return;
        }
    }

    public void setGender(Gender gender1)
    {
        gender = gender1;
    }

    public void setNumberOfChildren(int i)
    {
        if (i < 0)
        {
            numberOfChildren = NUMBER_OF_CHILDREN_UNKNOWN;
        }
        numberOfChildren = i;
    }

    public void setRelationshipStatus(RelationshipStatus relationshipstatus)
    {
        relationshipStatus = relationshipstatus;
    }

}
