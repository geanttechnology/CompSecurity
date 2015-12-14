// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import java.util.List;

// Referenced classes of package com.amazon.clouddrive.extended.model:
//            PendingPlan

public class CloudDriveSubscription
    implements Comparable
{

    private Boolean autoRenewEnabled;
    private String baseCurrencyCode;
    private String contractEndDate;
    private Long currentBillingPeriod;
    private Long currentContractPeriod;
    private String expectedStatusEndDate;
    private Long gracePeriodBeforeCancellation;
    private Boolean hasOpenProblems;
    private String marketplaceId;
    private String nextBillAmount;
    private String nextBillDate;
    private PendingPlan pendingPlan;
    private String planId;
    private String preferredPaymentPlanId;
    private String statusStartDate;
    private String subscriptionId;
    private List subscriptionProblemsList;
    private String subscriptionStartDate;
    private String subscriptionStatus;

    public CloudDriveSubscription()
    {
    }

    public int compareTo(CloudDriveSubscription clouddrivesubscription)
    {
        if (clouddrivesubscription != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        Object obj;
        Object obj1;
        if (clouddrivesubscription == this)
        {
            return 0;
        }
        obj = getBaseCurrencyCode();
        obj1 = clouddrivesubscription.getBaseCurrencyCode();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        obj = isAutoRenewEnabled();
        obj1 = clouddrivesubscription.isAutoRenewEnabled();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        obj = getCurrentContractPeriod();
        obj1 = clouddrivesubscription.getCurrentContractPeriod();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L9:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L10; else goto _L11
_L11:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L13; else goto _L12
_L12:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L14
_L14:
        obj = getSubscriptionId();
        obj1 = clouddrivesubscription.getSubscriptionId();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L13:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L14; else goto _L15
_L15:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L17; else goto _L16
_L16:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L18
_L18:
        obj = getSubscriptionStartDate();
        obj1 = clouddrivesubscription.getSubscriptionStartDate();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L17:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L18; else goto _L19
_L19:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L21; else goto _L20
_L20:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L22
_L22:
        obj = getMarketplaceId();
        obj1 = clouddrivesubscription.getMarketplaceId();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L21:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L22; else goto _L23
_L23:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L25; else goto _L24
_L24:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L26
_L26:
        obj = getPendingPlan();
        obj1 = clouddrivesubscription.getPendingPlan();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L25:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L26; else goto _L27
_L27:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L29; else goto _L28
_L28:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L30
_L30:
        obj = getExpectedStatusEndDate();
        obj1 = clouddrivesubscription.getExpectedStatusEndDate();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L29:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L30; else goto _L31
_L31:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L33; else goto _L32
_L32:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L34
_L34:
        obj = getSubscriptionProblemsList();
        obj1 = clouddrivesubscription.getSubscriptionProblemsList();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L33:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L34; else goto _L35
_L35:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L37; else goto _L36
_L36:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L38
_L38:
        obj = getPlanId();
        obj1 = clouddrivesubscription.getPlanId();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L37:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L38; else goto _L39
_L39:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L41; else goto _L40
_L40:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L42
_L42:
        obj = getPreferredPaymentPlanId();
        obj1 = clouddrivesubscription.getPreferredPaymentPlanId();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L41:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L42; else goto _L43
_L43:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L45; else goto _L44
_L44:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L46
_L46:
        obj = getGracePeriodBeforeCancellation();
        obj1 = clouddrivesubscription.getGracePeriodBeforeCancellation();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L45:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L46; else goto _L47
_L47:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L49; else goto _L48
_L48:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L50
_L50:
        obj = getCurrentBillingPeriod();
        obj1 = clouddrivesubscription.getCurrentBillingPeriod();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L49:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L50; else goto _L51
_L51:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L53; else goto _L52
_L52:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L54
_L54:
        obj = getNextBillDate();
        obj1 = clouddrivesubscription.getNextBillDate();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L53:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L54; else goto _L55
_L55:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L57; else goto _L56
_L56:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L58
_L58:
        obj = getNextBillAmount();
        obj1 = clouddrivesubscription.getNextBillAmount();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L57:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L58; else goto _L59
_L59:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L61; else goto _L60
_L60:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L62
_L62:
        obj = getContractEndDate();
        obj1 = clouddrivesubscription.getContractEndDate();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L61:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L62; else goto _L63
_L63:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L65; else goto _L64
_L64:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L66
_L66:
        obj = getSubscriptionStatus();
        obj1 = clouddrivesubscription.getSubscriptionStatus();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L65:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L66; else goto _L67
_L67:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L69; else goto _L68
_L68:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L70
_L70:
        obj = isHasOpenProblems();
        obj1 = clouddrivesubscription.isHasOpenProblems();
        if (obj == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L69:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L70; else goto _L71
_L71:
        if (obj1 == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L73; else goto _L72
_L72:
        k = ((Comparable)obj).compareTo(obj1);
        i = k;
        if (k != 0) goto _L6; else goto _L74
_L74:
        obj = getStatusStartDate();
        clouddrivesubscription = clouddrivesubscription.getStatusStartDate();
        if (obj == clouddrivesubscription)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L73:
        if (!obj.equals(obj1))
        {
            i = obj.hashCode();
            k = obj1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L74; else goto _L75
_L75:
        if (clouddrivesubscription == null)
        {
            return 1;
        }
        if (!(obj instanceof Comparable)) goto _L77; else goto _L76
_L76:
        k = ((Comparable)obj).compareTo(clouddrivesubscription);
        i = k;
        if (k != 0) goto _L6; else goto _L78
_L78:
        return 0;
_L77:
        if (!obj.equals(clouddrivesubscription))
        {
            int j = obj.hashCode();
            int l = clouddrivesubscription.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L78; else goto _L79
_L79:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((CloudDriveSubscription)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof CloudDriveSubscription)
            {
                if (compareTo((CloudDriveSubscription)obj) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public String getBaseCurrencyCode()
    {
        return baseCurrencyCode;
    }

    public String getContractEndDate()
    {
        return contractEndDate;
    }

    public Long getCurrentBillingPeriod()
    {
        return currentBillingPeriod;
    }

    public Long getCurrentContractPeriod()
    {
        return currentContractPeriod;
    }

    public String getExpectedStatusEndDate()
    {
        return expectedStatusEndDate;
    }

    public Long getGracePeriodBeforeCancellation()
    {
        return gracePeriodBeforeCancellation;
    }

    public String getMarketplaceId()
    {
        return marketplaceId;
    }

    public String getNextBillAmount()
    {
        return nextBillAmount;
    }

    public String getNextBillDate()
    {
        return nextBillDate;
    }

    public PendingPlan getPendingPlan()
    {
        return pendingPlan;
    }

    public String getPlanId()
    {
        return planId;
    }

    public String getPreferredPaymentPlanId()
    {
        return preferredPaymentPlanId;
    }

    public String getStatusStartDate()
    {
        return statusStartDate;
    }

    public String getSubscriptionId()
    {
        return subscriptionId;
    }

    public List getSubscriptionProblemsList()
    {
        return subscriptionProblemsList;
    }

    public String getSubscriptionStartDate()
    {
        return subscriptionStartDate;
    }

    public String getSubscriptionStatus()
    {
        return subscriptionStatus;
    }

    public int hashCode()
    {
        int k4 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        if (getBaseCurrencyCode() == null)
        {
            i = 0;
        } else
        {
            i = getBaseCurrencyCode().hashCode();
        }
        if (isAutoRenewEnabled() == null)
        {
            j = 0;
        } else
        {
            j = isAutoRenewEnabled().hashCode();
        }
        if (getCurrentContractPeriod() == null)
        {
            k = 0;
        } else
        {
            k = getCurrentContractPeriod().hashCode();
        }
        if (getSubscriptionId() == null)
        {
            l = 0;
        } else
        {
            l = getSubscriptionId().hashCode();
        }
        if (getSubscriptionStartDate() == null)
        {
            i1 = 0;
        } else
        {
            i1 = getSubscriptionStartDate().hashCode();
        }
        if (getMarketplaceId() == null)
        {
            j1 = 0;
        } else
        {
            j1 = getMarketplaceId().hashCode();
        }
        if (getPendingPlan() == null)
        {
            k1 = 0;
        } else
        {
            k1 = getPendingPlan().hashCode();
        }
        if (getExpectedStatusEndDate() == null)
        {
            l1 = 0;
        } else
        {
            l1 = getExpectedStatusEndDate().hashCode();
        }
        if (getSubscriptionProblemsList() == null)
        {
            i2 = 0;
        } else
        {
            i2 = getSubscriptionProblemsList().hashCode();
        }
        if (getPlanId() == null)
        {
            j2 = 0;
        } else
        {
            j2 = getPlanId().hashCode();
        }
        if (getPreferredPaymentPlanId() == null)
        {
            k2 = 0;
        } else
        {
            k2 = getPreferredPaymentPlanId().hashCode();
        }
        if (getGracePeriodBeforeCancellation() == null)
        {
            l2 = 0;
        } else
        {
            l2 = getGracePeriodBeforeCancellation().hashCode();
        }
        if (getCurrentBillingPeriod() == null)
        {
            i3 = 0;
        } else
        {
            i3 = getCurrentBillingPeriod().hashCode();
        }
        if (getNextBillDate() == null)
        {
            j3 = 0;
        } else
        {
            j3 = getNextBillDate().hashCode();
        }
        if (getNextBillAmount() == null)
        {
            k3 = 0;
        } else
        {
            k3 = getNextBillAmount().hashCode();
        }
        if (getContractEndDate() == null)
        {
            l3 = 0;
        } else
        {
            l3 = getContractEndDate().hashCode();
        }
        if (getSubscriptionStatus() == null)
        {
            i4 = 0;
        } else
        {
            i4 = getSubscriptionStatus().hashCode();
        }
        if (isHasOpenProblems() == null)
        {
            j4 = 0;
        } else
        {
            j4 = isHasOpenProblems().hashCode();
        }
        if (getStatusStartDate() != null)
        {
            k4 = getStatusStartDate().hashCode();
        }
        return 1 + i + j + k + l + i1 + j1 + k1 + l1 + i2 + j2 + k2 + l2 + i3 + j3 + k3 + l3 + i4 + j4 + k4;
    }

    public Boolean isAutoRenewEnabled()
    {
        return autoRenewEnabled;
    }

    public Boolean isHasOpenProblems()
    {
        return hasOpenProblems;
    }

    public void setAutoRenewEnabled(Boolean boolean1)
    {
        autoRenewEnabled = boolean1;
    }

    public void setBaseCurrencyCode(String s)
    {
        baseCurrencyCode = s;
    }

    public void setContractEndDate(String s)
    {
        contractEndDate = s;
    }

    public void setCurrentBillingPeriod(Long long1)
    {
        currentBillingPeriod = long1;
    }

    public void setCurrentContractPeriod(Long long1)
    {
        currentContractPeriod = long1;
    }

    public void setExpectedStatusEndDate(String s)
    {
        expectedStatusEndDate = s;
    }

    public void setGracePeriodBeforeCancellation(Long long1)
    {
        gracePeriodBeforeCancellation = long1;
    }

    public void setHasOpenProblems(Boolean boolean1)
    {
        hasOpenProblems = boolean1;
    }

    public void setMarketplaceId(String s)
    {
        marketplaceId = s;
    }

    public void setNextBillAmount(String s)
    {
        nextBillAmount = s;
    }

    public void setNextBillDate(String s)
    {
        nextBillDate = s;
    }

    public void setPendingPlan(PendingPlan pendingplan)
    {
        pendingPlan = pendingplan;
    }

    public void setPlanId(String s)
    {
        planId = s;
    }

    public void setPreferredPaymentPlanId(String s)
    {
        preferredPaymentPlanId = s;
    }

    public void setStatusStartDate(String s)
    {
        statusStartDate = s;
    }

    public void setSubscriptionId(String s)
    {
        subscriptionId = s;
    }

    public void setSubscriptionProblemsList(List list)
    {
        subscriptionProblemsList = list;
    }

    public void setSubscriptionStartDate(String s)
    {
        subscriptionStartDate = s;
    }

    public void setSubscriptionStatus(String s)
    {
        subscriptionStatus = s;
    }
}
