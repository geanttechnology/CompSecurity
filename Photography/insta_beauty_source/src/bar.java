// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import com.instamag.activity.compose.MagComposeLinkFragement;
import com.wantu.activity.link.model.TMetaInfo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class bar
    implements Comparator
{

    final MagComposeLinkFragement a;

    public bar(MagComposeLinkFragement magcomposelinkfragement)
    {
        a = magcomposelinkfragement;
        super();
    }

    public int compare(Object obj, Object obj1)
    {
        SimpleDateFormat simpledateformat;
        if (!(obj instanceof bin) || !(obj1 instanceof bin))
        {
            break MISSING_BLOCK_LABEL_125;
        }
        obj = (bin)obj;
        obj1 = (bin)obj1;
        obj = ((bin) (obj)).b;
        obj1 = ((bin) (obj1)).b;
        if (obj == null || obj1 == null || ((TMetaInfo) (obj)).getDateTime() == null || ((TMetaInfo) (obj1)).getDateTime() == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        simpledateformat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        obj = simpledateformat.parse(((TMetaInfo) (obj)).getDateTime());
        obj1 = simpledateformat.parse(((TMetaInfo) (obj1)).getDateTime());
        if (obj == null || obj1 == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (((Date) (obj)).after(((Date) (obj1))))
        {
            return 1;
        }
        boolean flag = ((Date) (obj)).before(((Date) (obj1)));
        if (flag)
        {
            return -1;
        }
        break MISSING_BLOCK_LABEL_125;
        obj;
        ((ParseException) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        return 0;
    }
}
