.class public Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;
.super Ljava/lang/Object;
.source "NanoHTTPD.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;,
        Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    }
.end annotation


# static fields
.field private static gmtFrmt:Ljava/text/SimpleDateFormat;

.field protected static myErr:Ljava/io/PrintStream;

.field protected static myOut:Ljava/io/PrintStream;

.field private static theBufferSize:I

.field private static theMimeTypes:Ljava/util/Hashtable;


# instance fields
.field private myRootDir:Ljava/io/File;

.field private final myServerSocket:Ljava/net/ServerSocket;

.field private myTcpPort:I

.field private myThread:Ljava/lang/Thread;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 967
    new-instance v1, Ljava/util/Hashtable;

    invoke-direct {v1}, Ljava/util/Hashtable;-><init>()V

    sput-object v1, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->theMimeTypes:Ljava/util/Hashtable;

    .line 970
    new-instance v0, Ljava/util/StringTokenizer;

    const-string v1, "css\t\ttext/css htm\t\ttext/html html\t\ttext/html xml\t\ttext/xml txt\t\ttext/plain asc\t\ttext/plain gif\t\timage/gif jpg\t\timage/jpeg jpeg\t\timage/jpeg png\t\timage/png mp3\t\taudio/mpeg m3u\t\taudio/mpeg-url mp4\t\tvideo/mp4 ogv\t\tvideo/ogg flv\t\tvideo/x-flv mov\t\tvideo/quicktime swf\t\tapplication/x-shockwave-flash js\t\t\tapplication/javascript pdf\t\tapplication/pdf doc\t\tapplication/msword ogg\t\tapplication/x-ogg zip\t\tapplication/octet-stream exe\t\tapplication/octet-stream class\t\tapplication/octet-stream "

    invoke-direct {v0, v1}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;)V

    .line 995
    .local v0, "st":Ljava/util/StringTokenizer;
    :goto_0
    invoke-virtual {v0}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 996
    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->theMimeTypes:Ljava/util/Hashtable;

    invoke-virtual {v0}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1000
    :cond_0
    const/16 v1, 0x4000

    sput v1, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->theBufferSize:I

    .line 1003
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    sput-object v1, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myOut:Ljava/io/PrintStream;

    .line 1004
    sget-object v1, Ljava/lang/System;->err:Ljava/io/PrintStream;

    sput-object v1, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myErr:Ljava/io/PrintStream;

    .line 1010
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "E, d MMM yyyy HH:mm:ss \'GMT\'"

    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v1, v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    sput-object v1, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->gmtFrmt:Ljava/text/SimpleDateFormat;

    .line 1011
    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->gmtFrmt:Ljava/text/SimpleDateFormat;

    const-string v2, "GMT"

    invoke-static {v2}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 1012
    return-void
.end method

.method public constructor <init>(ILjava/io/File;)V
    .locals 2
    .param p1, "port"    # I
    .param p2, "wwwroot"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 192
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 193
    iput p1, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myTcpPort:I

    .line 194
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myRootDir:Ljava/io/File;

    .line 195
    new-instance v0, Ljava/net/ServerSocket;

    iget v1, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myTcpPort:I

    invoke-direct {v0, v1}, Ljava/net/ServerSocket;-><init>(I)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myServerSocket:Ljava/net/ServerSocket;

    .line 196
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myThread:Ljava/lang/Thread;

    .line 206
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myThread:Ljava/lang/Thread;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setDaemon(Z)V

    .line 207
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 208
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;)Ljava/net/ServerSocket;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myServerSocket:Ljava/net/ServerSocket;

    return-object v0
.end method

.method static synthetic access$100()Ljava/text/SimpleDateFormat;
    .locals 1

    .prologue
    .line 71
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->gmtFrmt:Ljava/text/SimpleDateFormat;

    return-object v0
.end method

.method static synthetic access$200()I
    .locals 1

    .prologue
    .line 71
    sget v0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->theBufferSize:I

    return v0
.end method

.method private encodeUri(Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "uri"    # Ljava/lang/String;

    .prologue
    .line 755
    const-string v0, ""

    .line 756
    .local v0, "newUri":Ljava/lang/String;
    new-instance v1, Ljava/util/StringTokenizer;

    const-string v3, "/ "

    const/4 v4, 0x1

    invoke-direct {v1, p1, v3, v4}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 757
    .local v1, "st":Ljava/util/StringTokenizer;
    :goto_0
    invoke-virtual {v1}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 758
    invoke-virtual {v1}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v2

    .line 759
    .local v2, "tok":Ljava/lang/String;
    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 760
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 761
    :cond_0
    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 762
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "%20"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 764
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {v2}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 769
    .end local v2    # "tok":Ljava/lang/String;
    :cond_2
    return-object v0
.end method


# virtual methods
.method public serve(Ljava/lang/String;Ljava/lang/String;Ljava/util/Properties;Ljava/util/Properties;Ljava/util/Properties;)Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .locals 5
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "method"    # Ljava/lang/String;
    .param p3, "header"    # Ljava/util/Properties;
    .param p4, "parms"    # Ljava/util/Properties;
    .param p5, "files"    # Ljava/util/Properties;

    .prologue
    .line 88
    sget-object v2, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myOut:Ljava/io/PrintStream;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\' "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 90
    invoke-virtual {p3}, Ljava/util/Properties;->propertyNames()Ljava/util/Enumeration;

    move-result-object v0

    .line 91
    .local v0, "e":Ljava/util/Enumeration;
    :goto_0
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 92
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 93
    .local v1, "value":Ljava/lang/String;
    sget-object v2, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myOut:Ljava/io/PrintStream;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "  HDR: \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\' = \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 94
    invoke-virtual {p3, v1}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 93
    invoke-virtual {v2, v3}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_0

    .line 96
    .end local v1    # "value":Ljava/lang/String;
    :cond_0
    invoke-virtual {p4}, Ljava/util/Properties;->propertyNames()Ljava/util/Enumeration;

    move-result-object v0

    .line 97
    :goto_1
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 98
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 99
    .restart local v1    # "value":Ljava/lang/String;
    sget-object v2, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myOut:Ljava/io/PrintStream;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "  PRM: \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\' = \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 100
    invoke-virtual {p4, v1}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 99
    invoke-virtual {v2, v3}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_1

    .line 102
    .end local v1    # "value":Ljava/lang/String;
    :cond_1
    invoke-virtual {p5}, Ljava/util/Properties;->propertyNames()Ljava/util/Enumeration;

    move-result-object v0

    .line 103
    :goto_2
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 104
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 105
    .restart local v1    # "value":Ljava/lang/String;
    sget-object v2, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myOut:Ljava/io/PrintStream;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "  UPLOADED: \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\' = \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 106
    invoke-virtual {p5, v1}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 105
    invoke-virtual {v2, v3}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_2

    .line 109
    .end local v1    # "value":Ljava/lang/String;
    :cond_2
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myRootDir:Ljava/io/File;

    const/4 v3, 0x1

    invoke-virtual {p0, p1, p3, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->serveFile(Ljava/lang/String;Ljava/util/Properties;Ljava/io/File;Z)Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    move-result-object v2

    return-object v2
.end method

.method public serveFile(Ljava/lang/String;Ljava/util/Properties;Ljava/io/File;Z)Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .locals 40
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "header"    # Ljava/util/Properties;
    .param p3, "homeDir"    # Ljava/io/File;
    .param p4, "allowDirectoryListing"    # Z

    .prologue
    .line 787
    const/16 v29, 0x0

    .line 790
    .local v29, "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    invoke-virtual/range {p3 .. p3}, Ljava/io/File;->isDirectory()Z

    move-result v35

    if-nez v35, :cond_0

    .line 791
    new-instance v29, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    const-string v35, "500 Internal Server Error"

    const-string v36, "text/plain"

    const-string v37, "INTERNAL ERRROR: serveFile(): given homeDir is not a directory."

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    move-object/from16 v2, v35

    move-object/from16 v3, v36

    move-object/from16 v4, v37

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 795
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :cond_0
    if-nez v29, :cond_3

    .line 797
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v35

    sget-char v36, Ljava/io/File;->separatorChar:C

    const/16 v37, 0x2f

    invoke-virtual/range {v35 .. v37}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object p1

    .line 798
    const/16 v35, 0x3f

    move-object/from16 v0, p1

    move/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(I)I

    move-result v35

    if-ltz v35, :cond_1

    .line 799
    const/16 v35, 0x0

    const/16 v36, 0x3f

    move-object/from16 v0, p1

    move/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(I)I

    move-result v36

    move-object/from16 v0, p1

    move/from16 v1, v35

    move/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    .line 803
    :cond_1
    const-string v35, "src/main"

    move-object/from16 v0, p1

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v35

    if-nez v35, :cond_2

    const-string v35, "src/main"

    move-object/from16 v0, p1

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v35

    if-nez v35, :cond_2

    const-string v35, "../"

    move-object/from16 v0, p1

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v35

    if-ltz v35, :cond_3

    .line 804
    :cond_2
    new-instance v29, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    const-string v35, "403 Forbidden"

    const-string v36, "text/plain"

    const-string v37, "FORBIDDEN: Won\'t serve ../ for security reasons."

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    move-object/from16 v2, v35

    move-object/from16 v3, v36

    move-object/from16 v4, v37

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 809
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :cond_3
    new-instance v14, Ljava/io/File;

    move-object/from16 v0, p3

    move-object/from16 v1, p1

    invoke-direct {v14, v0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 810
    .local v14, "f":Ljava/io/File;
    if-nez v29, :cond_4

    invoke-virtual {v14}, Ljava/io/File;->exists()Z

    move-result v35

    if-nez v35, :cond_4

    .line 811
    new-instance v29, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    const-string v35, "404 Not Found"

    const-string v36, "text/plain"

    const-string v37, "Error 404, file not found."

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    move-object/from16 v2, v35

    move-object/from16 v3, v36

    move-object/from16 v4, v37

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 816
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :cond_4
    if-nez v29, :cond_19

    invoke-virtual {v14}, Ljava/io/File;->isDirectory()Z

    move-result v35

    if-eqz v35, :cond_19

    .line 819
    const-string v35, "/"

    move-object/from16 v0, p1

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v35

    if-nez v35, :cond_5

    .line 820
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "/"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 821
    new-instance v29, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    const-string v35, "301 Moved Permanently"

    const-string v36, "text/html"

    new-instance v37, Ljava/lang/StringBuilder;

    invoke-direct/range {v37 .. v37}, Ljava/lang/StringBuilder;-><init>()V

    const-string v38, "<html><body>Redirected: <a href=\""

    invoke-virtual/range {v37 .. v38}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    move-object/from16 v0, v37

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    const-string v38, "\">"

    invoke-virtual/range {v37 .. v38}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    move-object/from16 v0, v37

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    const-string v38, "</a></body></html>"

    invoke-virtual/range {v37 .. v38}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v37

    invoke-virtual/range {v37 .. v37}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    move-object/from16 v2, v35

    move-object/from16 v3, v36

    move-object/from16 v4, v37

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 824
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    const-string v35, "Location"

    move-object/from16 v0, v29

    move-object/from16 v1, v35

    move-object/from16 v2, p1

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 827
    :cond_5
    if-nez v29, :cond_19

    .line 829
    new-instance v35, Ljava/io/File;

    const-string v36, "index.html"

    move-object/from16 v0, v35

    move-object/from16 v1, v36

    invoke-direct {v0, v14, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual/range {v35 .. v35}, Ljava/io/File;->exists()Z

    move-result v35

    if-eqz v35, :cond_9

    .line 830
    new-instance v14, Ljava/io/File;

    .end local v14    # "f":Ljava/io/File;
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "/index.html"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, p3

    move-object/from16 v1, v35

    invoke-direct {v14, v0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .restart local v14    # "f":Ljava/io/File;
    move-object/from16 v30, v29

    .line 889
    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .local v30, "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :goto_0
    if-nez v30, :cond_18

    .line 891
    const/16 v21, 0x0

    .line 892
    .local v21, "mime":Ljava/lang/String;
    :try_start_0
    invoke-virtual {v14}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object v35

    const/16 v36, 0x2e

    invoke-virtual/range {v35 .. v36}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v10

    .line 893
    .local v10, "dot":I
    if-ltz v10, :cond_6

    .line 894
    sget-object v35, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->theMimeTypes:Ljava/util/Hashtable;

    invoke-virtual {v14}, Ljava/io/File;->getCanonicalPath()Ljava/lang/String;

    move-result-object v36

    add-int/lit8 v37, v10, 0x1

    invoke-virtual/range {v36 .. v37}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v35

    move-object/from16 v0, v35

    check-cast v0, Ljava/lang/String;

    move-object/from16 v21, v0

    .line 896
    :cond_6
    if-nez v21, :cond_7

    .line 897
    const-string v21, "application/octet-stream"

    .line 901
    :cond_7
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v14}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual {v14}, Ljava/io/File;->lastModified()J

    move-result-wide v36

    invoke-virtual/range {v35 .. v37}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, ""

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual {v14}, Ljava/io/File;->length()J

    move-result-wide v36

    invoke-virtual/range {v35 .. v37}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/String;->hashCode()I

    move-result v35

    invoke-static/range {v35 .. v35}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v11

    .line 904
    .local v11, "etag":Ljava/lang/String;
    const-wide/16 v32, 0x0

    .line 905
    .local v32, "startFrom":J
    const-wide/16 v12, -0x1

    .line 906
    .local v12, "endAt":J
    const-string v35, "range"

    move-object/from16 v0, p2

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v28

    .line 907
    .local v28, "range":Ljava/lang/String;
    if-eqz v28, :cond_8

    .line 908
    const-string v35, "bytes="

    move-object/from16 v0, v28

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v35

    if-eqz v35, :cond_8

    .line 909
    const-string v35, "bytes="

    invoke-virtual/range {v35 .. v35}, Ljava/lang/String;->length()I

    move-result v35

    move-object/from16 v0, v28

    move/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v28

    .line 910
    const/16 v35, 0x2d

    move-object/from16 v0, v28

    move/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(I)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v24

    .line 912
    .local v24, "minus":I
    if-lez v24, :cond_8

    .line 913
    const/16 v35, 0x0

    :try_start_1
    move-object/from16 v0, v28

    move/from16 v1, v35

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v35 .. v35}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v32

    .line 914
    add-int/lit8 v35, v24, 0x1

    move-object/from16 v0, v28

    move/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v35 .. v35}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-wide v12

    .line 922
    .end local v24    # "minus":I
    :cond_8
    :goto_1
    :try_start_2
    invoke-virtual {v14}, Ljava/io/File;->length()J

    move-result-wide v16

    .line 923
    .local v16, "fileLen":J
    if-eqz v28, :cond_16

    const-wide/16 v36, 0x0

    cmp-long v35, v32, v36

    if-ltz v35, :cond_16

    .line 924
    cmp-long v35, v32, v16

    if-ltz v35, :cond_13

    .line 925
    new-instance v29, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    const-string v35, "416 Requested Range Not Satisfiable"

    const-string v36, "text/plain"

    const-string v37, ""

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    move-object/from16 v2, v35

    move-object/from16 v3, v36

    move-object/from16 v4, v37

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 926
    .end local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :try_start_3
    const-string v35, "Content-Range"

    new-instance v36, Ljava/lang/StringBuilder;

    invoke-direct/range {v36 .. v36}, Ljava/lang/StringBuilder;-><init>()V

    const-string v37, "bytes 0-0/"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    move-object/from16 v0, v36

    move-wide/from16 v1, v16

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    move-object/from16 v0, v29

    move-object/from16 v1, v35

    move-object/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 927
    const-string v35, "ETag"

    move-object/from16 v0, v29

    move-object/from16 v1, v35

    invoke-virtual {v0, v1, v11}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    .line 962
    .end local v10    # "dot":I
    .end local v11    # "etag":Ljava/lang/String;
    .end local v12    # "endAt":J
    .end local v16    # "fileLen":J
    .end local v21    # "mime":Ljava/lang/String;
    .end local v28    # "range":Ljava/lang/String;
    .end local v32    # "startFrom":J
    :goto_2
    const-string v35, "Accept-Ranges"

    const-string v36, "bytes"

    move-object/from16 v0, v29

    move-object/from16 v1, v35

    move-object/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 963
    return-object v29

    .line 831
    :cond_9
    new-instance v35, Ljava/io/File;

    const-string v36, "index.htm"

    move-object/from16 v0, v35

    move-object/from16 v1, v36

    invoke-direct {v0, v14, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-virtual/range {v35 .. v35}, Ljava/io/File;->exists()Z

    move-result v35

    if-eqz v35, :cond_a

    .line 832
    new-instance v14, Ljava/io/File;

    .end local v14    # "f":Ljava/io/File;
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "/index.htm"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, p3

    move-object/from16 v1, v35

    invoke-direct {v14, v0, v1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .restart local v14    # "f":Ljava/io/File;
    move-object/from16 v30, v29

    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    goto/16 :goto_0

    .line 835
    .end local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :cond_a
    if-eqz p4, :cond_12

    invoke-virtual {v14}, Ljava/io/File;->canRead()Z

    move-result v35

    if-eqz v35, :cond_12

    .line 836
    invoke-virtual {v14}, Ljava/io/File;->list()[Ljava/lang/String;

    move-result-object v15

    .line 837
    .local v15, "files":[Ljava/lang/String;
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    const-string v36, "<html><body><h1>Directory "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    move-object/from16 v0, v35

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "</h1><br/>"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    .line 839
    .local v25, "msg":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v35

    const/16 v36, 0x1

    move/from16 v0, v35

    move/from16 v1, v36

    if-le v0, v1, :cond_b

    .line 840
    const/16 v35, 0x0

    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v36

    add-int/lit8 v36, v36, -0x1

    move-object/from16 v0, p1

    move/from16 v1, v35

    move/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v34

    .line 841
    .local v34, "u":Ljava/lang/String;
    const/16 v35, 0x2f

    invoke-virtual/range {v34 .. v35}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v31

    .line 842
    .local v31, "slash":I
    if-ltz v31, :cond_b

    invoke-virtual/range {v34 .. v34}, Ljava/lang/String;->length()I

    move-result v35

    move/from16 v0, v31

    move/from16 v1, v35

    if-ge v0, v1, :cond_b

    .line 843
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "<b><a href=\""

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const/16 v36, 0x0

    add-int/lit8 v37, v31, 0x1

    move-object/from16 v0, p1

    move/from16 v1, v36

    move/from16 v2, v37

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "\">..</a></b><br/>"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    .line 847
    .end local v31    # "slash":I
    .end local v34    # "u":Ljava/lang/String;
    :cond_b
    if-eqz v15, :cond_11

    .line 848
    const/16 v19, 0x0

    .local v19, "i":I
    :goto_3
    array-length v0, v15

    move/from16 v35, v0

    move/from16 v0, v19

    move/from16 v1, v35

    if-ge v0, v1, :cond_11

    .line 849
    new-instance v6, Ljava/io/File;

    aget-object v35, v15, v19

    move-object/from16 v0, v35

    invoke-direct {v6, v14, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 850
    .local v6, "curFile":Ljava/io/File;
    invoke-virtual {v6}, Ljava/io/File;->isDirectory()Z

    move-result v7

    .line 851
    .local v7, "dir":Z
    if-eqz v7, :cond_c

    .line 852
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "<b>"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    .line 853
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v36, v15, v19

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "/"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    aput-object v35, v15, v19

    .line 856
    :cond_c
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "<a href=\""

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    new-instance v36, Ljava/lang/StringBuilder;

    invoke-direct/range {v36 .. v36}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v36

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    aget-object v37, v15, v19

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    move-object/from16 v0, p0

    move-object/from16 v1, v36

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->encodeUri(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "\">"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    aget-object v36, v15, v19

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "</a>"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    .line 860
    invoke-virtual {v6}, Ljava/io/File;->isFile()Z

    move-result v35

    if-eqz v35, :cond_d

    .line 861
    invoke-virtual {v6}, Ljava/io/File;->length()J

    move-result-wide v22

    .line 862
    .local v22, "len":J
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, " &nbsp;<font size=2>("

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    .line 863
    const-wide/16 v36, 0x400

    cmp-long v35, v22, v36

    if-gez v35, :cond_f

    .line 864
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    move-object/from16 v0, v35

    move-wide/from16 v1, v22

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, " bytes"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    .line 871
    :goto_4
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, ")</font>"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    .line 873
    .end local v22    # "len":J
    :cond_d
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "<br/>"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    .line 874
    if-eqz v7, :cond_e

    .line 875
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "</b>"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    .line 848
    :cond_e
    add-int/lit8 v19, v19, 0x1

    goto/16 :goto_3

    .line 865
    .restart local v22    # "len":J
    :cond_f
    const-wide/32 v36, 0x100000

    cmp-long v35, v22, v36

    if-gez v35, :cond_10

    .line 866
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-wide/16 v36, 0x400

    div-long v36, v22, v36

    invoke-virtual/range {v35 .. v37}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "."

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-wide/16 v36, 0x400

    rem-long v36, v22, v36

    const-wide/16 v38, 0xa

    div-long v36, v36, v38

    const-wide/16 v38, 0x64

    rem-long v36, v36, v38

    invoke-virtual/range {v35 .. v37}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, " KB"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    goto/16 :goto_4

    .line 868
    :cond_10
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-wide/32 v36, 0x100000

    div-long v36, v22, v36

    invoke-virtual/range {v35 .. v37}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "."

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-wide/32 v36, 0x100000

    rem-long v36, v22, v36

    const-wide/16 v38, 0xa

    div-long v36, v36, v38

    const-wide/16 v38, 0x64

    rem-long v36, v36, v38

    invoke-virtual/range {v35 .. v37}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, " MB"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    goto/16 :goto_4

    .line 879
    .end local v6    # "curFile":Ljava/io/File;
    .end local v7    # "dir":Z
    .end local v19    # "i":I
    .end local v22    # "len":J
    :cond_11
    new-instance v35, Ljava/lang/StringBuilder;

    invoke-direct/range {v35 .. v35}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v35

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "</body></html>"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v25

    .line 880
    new-instance v29, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    const-string v35, "200 OK"

    const-string v36, "text/html"

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    move-object/from16 v2, v35

    move-object/from16 v3, v36

    move-object/from16 v4, v25

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    move-object/from16 v30, v29

    .line 881
    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    goto/16 :goto_0

    .line 882
    .end local v15    # "files":[Ljava/lang/String;
    .end local v25    # "msg":Ljava/lang/String;
    .end local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :cond_12
    new-instance v29, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    const-string v35, "403 Forbidden"

    const-string v36, "text/plain"

    const-string v37, "FORBIDDEN: No directory listing."

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    move-object/from16 v2, v35

    move-object/from16 v3, v36

    move-object/from16 v4, v37

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    move-object/from16 v30, v29

    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    goto/16 :goto_0

    .line 929
    .restart local v10    # "dot":I
    .restart local v11    # "etag":Ljava/lang/String;
    .restart local v12    # "endAt":J
    .restart local v16    # "fileLen":J
    .restart local v21    # "mime":Ljava/lang/String;
    .restart local v28    # "range":Ljava/lang/String;
    .restart local v32    # "startFrom":J
    :cond_13
    const-wide/16 v36, 0x0

    cmp-long v35, v12, v36

    if-gez v35, :cond_14

    .line 930
    const-wide/16 v36, 0x1

    sub-long v12, v16, v36

    .line 932
    :cond_14
    sub-long v36, v12, v32

    const-wide/16 v38, 0x1

    add-long v26, v36, v38

    .line 933
    .local v26, "newLen":J
    const-wide/16 v36, 0x0

    cmp-long v35, v26, v36

    if-gez v35, :cond_15

    .line 934
    const-wide/16 v26, 0x0

    .line 937
    :cond_15
    move-wide/from16 v8, v26

    .line 938
    .local v8, "dataLen":J
    :try_start_4
    new-instance v18, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$2;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v14, v8, v9}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$2;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/io/File;J)V

    .line 941
    .local v18, "fis":Ljava/io/FileInputStream;
    move-object/from16 v0, v18

    move-wide/from16 v1, v32

    invoke-virtual {v0, v1, v2}, Ljava/io/FileInputStream;->skip(J)J

    .line 943
    new-instance v29, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    const-string v35, "206 Partial Content"

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    move-object/from16 v2, v35

    move-object/from16 v3, v21

    move-object/from16 v4, v18

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    .line 944
    .end local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :try_start_5
    const-string v35, "Content-Length"

    new-instance v36, Ljava/lang/StringBuilder;

    invoke-direct/range {v36 .. v36}, Ljava/lang/StringBuilder;-><init>()V

    const-string v37, ""

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    move-object/from16 v0, v36

    invoke-virtual {v0, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    move-object/from16 v0, v29

    move-object/from16 v1, v35

    move-object/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 945
    const-string v35, "Content-Range"

    new-instance v36, Ljava/lang/StringBuilder;

    invoke-direct/range {v36 .. v36}, Ljava/lang/StringBuilder;-><init>()V

    const-string v37, "bytes "

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    move-object/from16 v0, v36

    move-wide/from16 v1, v32

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, "-"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    move-object/from16 v0, v36

    invoke-virtual {v0, v12, v13}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, "/"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    move-object/from16 v0, v36

    move-wide/from16 v1, v16

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    move-object/from16 v0, v29

    move-object/from16 v1, v35

    move-object/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 946
    const-string v35, "ETag"

    move-object/from16 v0, v29

    move-object/from16 v1, v35

    invoke-virtual {v0, v1, v11}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    goto/16 :goto_2

    .line 958
    .end local v8    # "dataLen":J
    .end local v18    # "fis":Ljava/io/FileInputStream;
    .end local v26    # "newLen":J
    :catch_0
    move-exception v20

    .line 959
    .end local v10    # "dot":I
    .end local v11    # "etag":Ljava/lang/String;
    .end local v12    # "endAt":J
    .end local v16    # "fileLen":J
    .end local v28    # "range":Ljava/lang/String;
    .end local v32    # "startFrom":J
    .local v20, "ioe":Ljava/io/IOException;
    :goto_5
    new-instance v29, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    const-string v35, "403 Forbidden"

    const-string v36, "text/plain"

    const-string v37, "FORBIDDEN: Reading file failed."

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    move-object/from16 v2, v35

    move-object/from16 v3, v36

    move-object/from16 v4, v37

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    goto/16 :goto_2

    .line 949
    .end local v20    # "ioe":Ljava/io/IOException;
    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v10    # "dot":I
    .restart local v11    # "etag":Ljava/lang/String;
    .restart local v12    # "endAt":J
    .restart local v16    # "fileLen":J
    .restart local v28    # "range":Ljava/lang/String;
    .restart local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v32    # "startFrom":J
    :cond_16
    :try_start_6
    const-string v35, "if-none-match"

    move-object/from16 v0, p2

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v35

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v35

    if-eqz v35, :cond_17

    .line 950
    new-instance v29, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    const-string v35, "304 Not Modified"

    const-string v36, ""

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    move-object/from16 v2, v35

    move-object/from16 v3, v21

    move-object/from16 v4, v36

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .end local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    goto/16 :goto_2

    .line 952
    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :cond_17
    new-instance v29, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;

    const-string v35, "200 OK"

    new-instance v36, Ljava/io/FileInputStream;

    move-object/from16 v0, v36

    invoke-direct {v0, v14}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    move-object/from16 v2, v35

    move-object/from16 v3, v21

    move-object/from16 v4, v36

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1

    .line 953
    .end local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :try_start_7
    const-string v35, "Content-Length"

    new-instance v36, Ljava/lang/StringBuilder;

    invoke-direct/range {v36 .. v36}, Ljava/lang/StringBuilder;-><init>()V

    const-string v37, ""

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    move-object/from16 v0, v36

    move-wide/from16 v1, v16

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    move-object/from16 v0, v29

    move-object/from16 v1, v35

    move-object/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 954
    const-string v35, "ETag"

    move-object/from16 v0, v29

    move-object/from16 v1, v35

    invoke-virtual {v0, v1, v11}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_0

    goto/16 :goto_2

    .line 958
    .end local v10    # "dot":I
    .end local v11    # "etag":Ljava/lang/String;
    .end local v12    # "endAt":J
    .end local v16    # "fileLen":J
    .end local v28    # "range":Ljava/lang/String;
    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .end local v32    # "startFrom":J
    .restart local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    :catch_1
    move-exception v20

    move-object/from16 v29, v30

    .end local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    goto/16 :goto_5

    .line 916
    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v10    # "dot":I
    .restart local v11    # "etag":Ljava/lang/String;
    .restart local v12    # "endAt":J
    .restart local v24    # "minus":I
    .restart local v28    # "range":Ljava/lang/String;
    .restart local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v32    # "startFrom":J
    :catch_2
    move-exception v35

    goto/16 :goto_1

    .end local v10    # "dot":I
    .end local v11    # "etag":Ljava/lang/String;
    .end local v12    # "endAt":J
    .end local v21    # "mime":Ljava/lang/String;
    .end local v24    # "minus":I
    .end local v28    # "range":Ljava/lang/String;
    .end local v32    # "startFrom":J
    :cond_18
    move-object/from16 v29, v30

    .end local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    goto/16 :goto_2

    :cond_19
    move-object/from16 v30, v29

    .end local v29    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    .restart local v30    # "res":Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
    goto/16 :goto_0
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 213
    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myServerSocket:Ljava/net/ServerSocket;

    invoke-virtual {v0}, Ljava/net/ServerSocket;->close()V

    .line 214
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->join()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 218
    :goto_0
    return-void

    .line 216
    :catch_0
    move-exception v0

    goto :goto_0

    .line 215
    :catch_1
    move-exception v0

    goto :goto_0
.end method
