.class public Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;
.super Ljava/lang/Object;
.source "NanoHTTPD.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Response"
.end annotation


# instance fields
.field public data:Ljava/io/InputStream;

.field public header:Ljava/util/Properties;

.field public mimeType:Ljava/lang/String;

.field public status:Ljava/lang/String;

.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    .locals 1
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;
    .param p2, "status"    # Ljava/lang/String;
    .param p3, "mimeType"    # Ljava/lang/String;
    .param p4, "data"    # Ljava/io/InputStream;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->this$0:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 161
    new-instance v0, Ljava/util/Properties;

    invoke-direct {v0}, Ljava/util/Properties;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->header:Ljava/util/Properties;

    .line 124
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->status:Ljava/lang/String;

    .line 125
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->mimeType:Ljava/lang/String;

    .line 126
    iput-object p4, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->data:Ljava/io/InputStream;

    .line 127
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;
    .param p2, "status"    # Ljava/lang/String;
    .param p3, "mimeType"    # Ljava/lang/String;
    .param p4, "txt"    # Ljava/lang/String;

    .prologue
    .line 133
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->this$0:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 161
    new-instance v1, Ljava/util/Properties;

    invoke-direct {v1}, Ljava/util/Properties;-><init>()V

    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->header:Ljava/util/Properties;

    .line 134
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->status:Ljava/lang/String;

    .line 135
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->mimeType:Ljava/lang/String;

    .line 137
    :try_start_0
    new-instance v1, Ljava/io/ByteArrayInputStream;

    const-string v2, "UTF-8"

    invoke-virtual {p4, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->data:Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 141
    :goto_0
    return-void

    .line 138
    :catch_0
    move-exception v0

    .line 139
    .local v0, "uee":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 145
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$Response;->header:Ljava/util/Properties;

    invoke-virtual {v0, p1, p2}, Ljava/util/Properties;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    return-void
.end method
