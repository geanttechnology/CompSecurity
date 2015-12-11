// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.metrics;

import com.a9.creditcardreaderlibrary.CreditCardResult;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.creditcardreader.activities.CreditCardScanActivity;
import java.util.List;

// Referenced classes of package com.creditcardreader.metrics:
//            CreditCardEvent

public class CreditCardMetricsRecorder
{

    private MetricEvent mMetricEvent;
    private MetricsFactory mMetricsFactory;
    private boolean mPortrait;

    public CreditCardMetricsRecorder(CreditCardScanActivity creditcardscanactivity)
    {
        setOrientation(creditcardscanactivity);
        mMetricsFactory = AndroidMetricsFactoryImpl.getInstance(creditcardscanactivity);
        mMetricEvent = mMetricsFactory.createConcurrentMetricEvent("MShopAndroidPhoneApp/CardScanner", "ShowCardScannerCredit");
    }

    private CreditCardEvent getSuccessType(CreditCardResult creditcardresult)
    {
        boolean flag3 = true;
        boolean flag = false;
        boolean flag2 = false;
        boolean flag4 = false;
        if (creditcardresult.getExpirationDate().length() > 0)
        {
            flag = true;
        }
        boolean flag1 = flag2;
        if (creditcardresult.getAlternateCardNumbers() != null)
        {
            flag1 = flag2;
            if (creditcardresult.getAlternateCardNumbers().size() > 0)
            {
                flag1 = true;
            }
        }
        flag2 = flag4;
        if (creditcardresult.getAlternateExpirationDates() != null)
        {
            flag2 = flag4;
            if (creditcardresult.getAlternateExpirationDates().size() > 0)
            {
                flag2 = true;
            }
        }
        if (flag && !flag1 && !flag2)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            return CreditCardEvent.SUCCESS_HIGH_CONFIDENCE;
        }
        if (!flag && !flag1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            return CreditCardEvent.SUCCESS_LOW_EXPIRATION_CONFIDENCE;
        }
        if (!flag && flag1)
        {
            flag = flag3;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return CreditCardEvent.SUCCESS_LOW_NUMBER_CONFIDENCE;
        } else
        {
            return CreditCardEvent.SUCCESS_LOW_NUMBER_AND_EXPIRATION_CONFIDENCE;
        }
    }

    private void setOrientation(CreditCardScanActivity creditcardscanactivity)
    {
        switch (creditcardscanactivity.getScreenOrientation())
        {
        default:
            mPortrait = false;
            return;

        case 1: // '\001'
            mPortrait = true;
            break;
        }
    }

    public void recordAlign()
    {
        if (mPortrait)
        {
            mMetricEvent.incrementCounter(CreditCardEvent.ALIGNED_PORTRAIT.getEvent(), 1.0D);
            return;
        } else
        {
            mMetricEvent.incrementCounter(CreditCardEvent.ALIGNED_LANDSCAPE.getEvent(), 1.0D);
            return;
        }
    }

    public void recordCameraError()
    {
        mMetricEvent.incrementCounter(CreditCardEvent.FAILURE_CAMERA_ERROR.getEvent(), 1.0D);
    }

    public void recordCancel()
    {
        mMetricEvent.incrementCounter(CreditCardEvent.CANCEL.getEvent(), 1.0D);
    }

    public void recordCancelOnBackground()
    {
        if (mPortrait)
        {
            mMetricEvent.incrementCounter(CreditCardEvent.CANCEL_ON_BACKGROUND_PORTRAIT.getEvent(), 1.0D);
            return;
        } else
        {
            mMetricEvent.incrementCounter(CreditCardEvent.CANCEL_ON_BACKGROUND_LANDSCAPE.getEvent(), 1.0D);
            return;
        }
    }

    public void recordHelp()
    {
        mMetricEvent.incrementCounter(CreditCardEvent.HELP.getEvent(), 1.0D);
    }

    public void recordMetric()
    {
        mMetricsFactory.record(mMetricEvent);
    }

    public void recordPromising()
    {
        mMetricEvent.incrementCounter(CreditCardEvent.PROMISING.getEvent(), 1.0D);
    }

    public void recordRescan()
    {
        mMetricEvent.incrementCounter(CreditCardEvent.RESCAN_AFTER_TIMEOUT.getEvent(), 1.0D);
    }

    public void recordSession()
    {
        if (mPortrait)
        {
            mMetricEvent.incrementCounter(CreditCardEvent.SESSION_PORTRAIT.getEvent(), 1.0D);
            return;
        } else
        {
            mMetricEvent.incrementCounter(CreditCardEvent.SESSION_LANDSCAPE.getEvent(), 1.0D);
            return;
        }
    }

    public void recordSuccess(CreditCardResult creditcardresult)
    {
        mMetricEvent.incrementCounter(getSuccessType(creditcardresult).getEvent(), 1.0D);
    }

    public void recordTimeout()
    {
        mMetricEvent.incrementCounter(CreditCardEvent.SCAN_TIMEOUT_PROMPT.getEvent(), 1.0D);
    }

    public void recordTimeoutCancel()
    {
        mMetricEvent.incrementCounter(CreditCardEvent.FAILURE_SCAN_TIMEOUT.getEvent(), 1.0D);
    }
}
