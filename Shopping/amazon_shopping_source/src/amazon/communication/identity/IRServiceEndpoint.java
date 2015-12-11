// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.identity;


public interface IRServiceEndpoint
{
    public static final class ClearTextConnection extends Enum
    {

        private static final ClearTextConnection $VALUES[];
        public static final ClearTextConnection ALLOWED;
        public static final ClearTextConnection NOT_ALLOWED;
        private final String mName;

        public static ClearTextConnection parse(String s)
        {
            if (s == null || s.trim().length() == 0)
            {
                throw new IllegalArgumentException("str must not be null or empty");
            }
            ClearTextConnection cleartextconnection = NOT_ALLOWED;
            if (s.equalsIgnoreCase(ALLOWED.toString()))
            {
                return ALLOWED;
            }
            if (s.equalsIgnoreCase(NOT_ALLOWED.toString()))
            {
                return NOT_ALLOWED;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("str: ").append(s).append(", cannot be parsed").toString());
            }
        }

        public static ClearTextConnection valueOf(String s)
        {
            return (ClearTextConnection)Enum.valueOf(amazon/communication/identity/IRServiceEndpoint$ClearTextConnection, s);
        }

        public static ClearTextConnection[] values()
        {
            return (ClearTextConnection[])$VALUES.clone();
        }

        public String toString()
        {
            return mName;
        }

        static 
        {
            ALLOWED = new ClearTextConnection("ALLOWED", 0, "allowed");
            NOT_ALLOWED = new ClearTextConnection("NOT_ALLOWED", 1, "not-allowed");
            $VALUES = (new ClearTextConnection[] {
                ALLOWED, NOT_ALLOWED
            });
        }

        private ClearTextConnection(String s, int i, String s1)
        {
            super(s, i);
            mName = s1;
        }
    }

    public static final class DataCompression extends Enum
    {

        private static final DataCompression $VALUES[];
        public static final DataCompression NEEDED;
        public static final DataCompression NOT_NEEDED;
        private final String mName;

        public static DataCompression parse(String s)
        {
            if (s == null || s.trim().length() == 0)
            {
                throw new IllegalArgumentException("str must not be null or empty");
            }
            DataCompression datacompression = NOT_NEEDED;
            if (s.equalsIgnoreCase(NEEDED.toString()))
            {
                return NEEDED;
            }
            if (s.equalsIgnoreCase(NOT_NEEDED.toString()))
            {
                return NOT_NEEDED;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("str: ").append(s).append(", cannot be parsed").toString());
            }
        }

        public static DataCompression valueOf(String s)
        {
            return (DataCompression)Enum.valueOf(amazon/communication/identity/IRServiceEndpoint$DataCompression, s);
        }

        public static DataCompression[] values()
        {
            return (DataCompression[])$VALUES.clone();
        }

        public String toString()
        {
            return mName;
        }

        static 
        {
            NEEDED = new DataCompression("NEEDED", 0, "needed");
            NOT_NEEDED = new DataCompression("NOT_NEEDED", 1, "not-needed");
            $VALUES = (new DataCompression[] {
                NEEDED, NOT_NEEDED
            });
        }

        private DataCompression(String s, int i, String s1)
        {
            super(s, i);
            mName = s1;
        }
    }

    public static final class DirectConnection extends Enum
    {

        private static final DirectConnection $VALUES[];
        public static final DirectConnection ALLOWED;
        public static final DirectConnection NOT_ALLOWED;
        public static final DirectConnection REQUIRED;
        private final String mName;

        public static DirectConnection parse(String s)
        {
            if (s == null || s.trim().length() == 0)
            {
                throw new IllegalArgumentException("str must not be null or empty");
            }
            DirectConnection directconnection = NOT_ALLOWED;
            if (s.equalsIgnoreCase(REQUIRED.toString()))
            {
                return REQUIRED;
            }
            if (s.equalsIgnoreCase(ALLOWED.toString()))
            {
                return ALLOWED;
            }
            if (s.equalsIgnoreCase(NOT_ALLOWED.toString()))
            {
                return NOT_ALLOWED;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("str: ").append(s).append(", cannot be parsed").toString());
            }
        }

        public static DirectConnection valueOf(String s)
        {
            return (DirectConnection)Enum.valueOf(amazon/communication/identity/IRServiceEndpoint$DirectConnection, s);
        }

        public static DirectConnection[] values()
        {
            return (DirectConnection[])$VALUES.clone();
        }

        public String toString()
        {
            return mName;
        }

        static 
        {
            REQUIRED = new DirectConnection("REQUIRED", 0, "required");
            ALLOWED = new DirectConnection("ALLOWED", 1, "allowed");
            NOT_ALLOWED = new DirectConnection("NOT_ALLOWED", 2, "not-allowed");
            $VALUES = (new DirectConnection[] {
                REQUIRED, ALLOWED, NOT_ALLOWED
            });
        }

        private DirectConnection(String s, int i, String s1)
        {
            super(s, i);
            mName = s1;
        }
    }

    public static final class Scheme extends Enum
    {

        private static final Scheme $VALUES[];
        public static final Scheme HTTP;
        public static final Scheme HTTPS;
        public static final Scheme WS;
        public static final Scheme WSS;
        private final String mName;

        public static Scheme valueOf(String s)
        {
            return (Scheme)Enum.valueOf(amazon/communication/identity/IRServiceEndpoint$Scheme, s);
        }

        public static Scheme[] values()
        {
            return (Scheme[])$VALUES.clone();
        }

        public String toString()
        {
            return mName;
        }

        static 
        {
            WS = new Scheme("WS", 0, "ws");
            WSS = new Scheme("WSS", 1, "wss");
            HTTP = new Scheme("HTTP", 2, "http");
            HTTPS = new Scheme("HTTPS", 3, "https");
            $VALUES = (new Scheme[] {
                WS, WSS, HTTP, HTTPS
            });
        }

        private Scheme(String s, int i, String s1)
        {
            super(s, i);
            mName = s1;
        }
    }


    public abstract ClearTextConnection getClearTextConnection();

    public abstract DataCompression getDataCompression();

    public abstract DirectConnection getDirectConnection();

    public abstract String getDomain();

    public abstract String getHostname();

    public abstract Integer getPort();

    public abstract String getRealm();

    public abstract Integer getSecurePort();

    public abstract int getTimeout();
}
