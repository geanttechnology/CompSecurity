// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, Address, BusinessCardEntity, VectorOfBusinessCardEntities, 
//            Name

public class BusinessCardInfo
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public BusinessCardInfo()
    {
        this(A9VSMobileJNI.new_BusinessCardInfo(), true);
    }

    protected BusinessCardInfo(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(BusinessCardInfo businesscardinfo)
    {
        if (businesscardinfo == null)
        {
            return 0L;
        } else
        {
            return businesscardinfo.swigCPtr;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (swigCPtr != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                A9VSMobileJNI.delete_BusinessCardInfo(swigCPtr);
            }
            swigCPtr = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        delete();
    }

    public Address getAddress()
    {
        long l = A9VSMobileJNI.BusinessCardInfo_address_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new Address(l, false);
        }
    }

    public BusinessCardEntity getCompany()
    {
        long l = A9VSMobileJNI.BusinessCardInfo_company_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new BusinessCardEntity(l, false);
        }
    }

    public BusinessCardEntity getDepartment()
    {
        long l = A9VSMobileJNI.BusinessCardInfo_department_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new BusinessCardEntity(l, false);
        }
    }

    public VectorOfBusinessCardEntities getEmails()
    {
        long l = A9VSMobileJNI.BusinessCardInfo_emails_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfBusinessCardEntities(l, false);
        }
    }

    public BusinessCardEntity getJobTitle()
    {
        long l = A9VSMobileJNI.BusinessCardInfo_jobTitle_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new BusinessCardEntity(l, false);
        }
    }

    public Name getName()
    {
        long l = A9VSMobileJNI.BusinessCardInfo_name_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new Name(l, false);
        }
    }

    public VectorOfBusinessCardEntities getOtherText()
    {
        long l = A9VSMobileJNI.BusinessCardInfo_otherText_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfBusinessCardEntities(l, false);
        }
    }

    public VectorOfBusinessCardEntities getPhones()
    {
        long l = A9VSMobileJNI.BusinessCardInfo_phones_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfBusinessCardEntities(l, false);
        }
    }

    public VectorOfBusinessCardEntities getUrls()
    {
        long l = A9VSMobileJNI.BusinessCardInfo_urls_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfBusinessCardEntities(l, false);
        }
    }

    public void setAddress(Address address)
    {
        A9VSMobileJNI.BusinessCardInfo_address_set(swigCPtr, this, Address.getCPtr(address), address);
    }

    public void setCompany(BusinessCardEntity businesscardentity)
    {
        A9VSMobileJNI.BusinessCardInfo_company_set(swigCPtr, this, BusinessCardEntity.getCPtr(businesscardentity), businesscardentity);
    }

    public void setDepartment(BusinessCardEntity businesscardentity)
    {
        A9VSMobileJNI.BusinessCardInfo_department_set(swigCPtr, this, BusinessCardEntity.getCPtr(businesscardentity), businesscardentity);
    }

    public void setEmails(VectorOfBusinessCardEntities vectorofbusinesscardentities)
    {
        A9VSMobileJNI.BusinessCardInfo_emails_set(swigCPtr, this, VectorOfBusinessCardEntities.getCPtr(vectorofbusinesscardentities), vectorofbusinesscardentities);
    }

    public void setJobTitle(BusinessCardEntity businesscardentity)
    {
        A9VSMobileJNI.BusinessCardInfo_jobTitle_set(swigCPtr, this, BusinessCardEntity.getCPtr(businesscardentity), businesscardentity);
    }

    public void setName(Name name)
    {
        A9VSMobileJNI.BusinessCardInfo_name_set(swigCPtr, this, Name.getCPtr(name), name);
    }

    public void setOtherText(VectorOfBusinessCardEntities vectorofbusinesscardentities)
    {
        A9VSMobileJNI.BusinessCardInfo_otherText_set(swigCPtr, this, VectorOfBusinessCardEntities.getCPtr(vectorofbusinesscardentities), vectorofbusinesscardentities);
    }

    public void setPhones(VectorOfBusinessCardEntities vectorofbusinesscardentities)
    {
        A9VSMobileJNI.BusinessCardInfo_phones_set(swigCPtr, this, VectorOfBusinessCardEntities.getCPtr(vectorofbusinesscardentities), vectorofbusinesscardentities);
    }

    public void setUrls(VectorOfBusinessCardEntities vectorofbusinesscardentities)
    {
        A9VSMobileJNI.BusinessCardInfo_urls_set(swigCPtr, this, VectorOfBusinessCardEntities.getCPtr(vectorofbusinesscardentities), vectorofbusinesscardentities);
    }
}
