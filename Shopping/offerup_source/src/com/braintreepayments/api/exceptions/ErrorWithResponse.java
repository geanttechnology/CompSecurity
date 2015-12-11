// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.api.exceptions;

import com.google.gson.Gson;
import java.util.Iterator;
import java.util.List;

public final class ErrorWithResponse extends Exception
{

    private final List fieldErrors;
    private final String message;
    private final int statusCode;

    public ErrorWithResponse(int i, BraintreeErrors braintreeerrors)
    {
        statusCode = i;
        if (braintreeerrors != null)
        {
            fieldErrors = braintreeerrors.getFieldErrors();
            message = braintreeerrors.getMessage();
            return;
        } else
        {
            fieldErrors = null;
            message = "Parsing error response failed";
            return;
        }
    }

    public ErrorWithResponse(int i, String s)
    {
        this(i, (BraintreeErrors)(new Gson()).fromJson(s, com/braintreepayments/api/exceptions/ErrorWithResponse$BraintreeErrors));
    }

    public final BraintreeError errorFor(String s)
    {
label0:
        {
            if (fieldErrors == null)
            {
                break label0;
            }
            Iterator iterator = fieldErrors.iterator();
            BraintreeError braintreeerror;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                braintreeerror = (BraintreeError)iterator.next();
            } while (!braintreeerror.field.equals(s));
            return braintreeerror;
        }
        return null;
    }

    public final List getFieldErrors()
    {
        return fieldErrors;
    }

    public final String getMessage()
    {
        return message;
    }

    public final int getStatusCode()
    {
        return statusCode;
    }

    public final String toString()
    {
        return (new StringBuilder("ErrorWithResponse (")).append(statusCode).append("): ").append(message).append("\n").append(fieldErrors.toString()).toString();
    }

    private class BraintreeErrors
        implements Parcelable
    {
        private class BraintreeError
            implements Parcelable
        {

            public static final android.os.Parcelable.Creator CREATOR = new _cls1();
            private String field;
            private List fieldErrors;
            private String message;

            public final int describeContents()
            {
                return 0;
            }

            public final BraintreeError errorFor(String s)
            {
label0:
                {
                    if (fieldErrors == null)
                    {
                        break label0;
                    }
                    Iterator iterator = fieldErrors.iterator();
                    BraintreeError braintreeerror;
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break label0;
                        }
                        braintreeerror = (BraintreeError)iterator.next();
                    } while (!braintreeerror.field.equals(s));
                    return braintreeerror;
                }
                return null;
            }

            public final String getField()
            {
                return field;
            }

            public final List getFieldErrors()
            {
                return fieldErrors;
            }

            public final String getMessage()
            {
                return message;
            }

            public final String toString()
            {
                StringBuilder stringbuilder = (new StringBuilder("BraintreeError for ")).append(field).append(": ").append(message).append(" -> ");
                String s;
                if (fieldErrors != null)
                {
                    s = fieldErrors.toString();
                } else
                {
                    s = "";
                }
                return stringbuilder.append(s).toString();
            }

            public final void writeToParcel(Parcel parcel, int i)
            {
                parcel.writeList(fieldErrors);
                parcel.writeString(field);
                parcel.writeString(message);
            }



            public BraintreeError()
            {
                fieldErrors = new ArrayList();
            }

            private BraintreeError(Parcel parcel)
            {
                fieldErrors = new ArrayList();
                fieldErrors = new ArrayList();
                parcel.readList(fieldErrors, java/util/ArrayList.getClassLoader());
                field = parcel.readString();
                message = parcel.readString();
            }

            BraintreeError(Parcel parcel, _cls1 _pcls1)
            {
                this(parcel);
            }

            class _cls1
                implements android.os.Parcelable.Creator
            {

                public final BraintreeError createFromParcel(Parcel parcel)
                {
                    return new BraintreeError(parcel, null);
                }

                public final volatile Object createFromParcel(Parcel parcel)
                {
                    return createFromParcel(parcel);
                }

                public final BraintreeError[] newArray(int i)
                {
                    return new BraintreeError[i];
                }

                public final volatile Object[] newArray(int i)
                {
                    return newArray(i);
                }

                    _cls1()
                    {
                    }
            }

        }


        public static final android.os.Parcelable.Creator CREATOR = new _cls1();
        private BraintreeError error;
        private List fieldErrors;

        public final int describeContents()
        {
            return 0;
        }

        protected final List getFieldErrors()
        {
            return fieldErrors;
        }

        protected final String getMessage()
        {
            if (error != null)
            {
                return error.getMessage();
            } else
            {
                return "Parsing error response failed";
            }
        }

        public final void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeTypedList(fieldErrors);
            parcel.writeParcelable(error, 0);
        }


        public BraintreeErrors()
        {
            fieldErrors = new ArrayList();
        }

        private BraintreeErrors(Parcel parcel)
        {
            fieldErrors = new ArrayList();
            parcel.readTypedList(fieldErrors, BraintreeError.CREATOR);
            error = (BraintreeError)parcel.readParcelable(com/braintreepayments/api/exceptions/ErrorWithResponse$BraintreeError.getClassLoader());
        }

        BraintreeErrors(Parcel parcel, _cls1 _pcls1)
        {
            this(parcel);
        }

        class _cls1
            implements android.os.Parcelable.Creator
        {

            public final BraintreeErrors createFromParcel(Parcel parcel)
            {
                return new BraintreeErrors(parcel, null);
            }

            public final volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public final BraintreeErrors[] newArray(int i)
            {
                return new BraintreeErrors[i];
            }

            public final volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

                _cls1()
                {
                }
        }

    }

}
