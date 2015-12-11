.class Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$1;
.super Ljava/lang/Object;
.source "NanoHTTPD.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;-><init>(ILjava/io/File;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    .prologue
    .line 196
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 200
    :goto_0
    :try_start_0
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$1;->this$0:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    # getter for: Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->myServerSocket:Ljava/net/ServerSocket;
    invoke-static {v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->access$000(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;)Ljava/net/ServerSocket;

    move-result-object v2

    invoke-virtual {v2}, Ljava/net/ServerSocket;->accept()Ljava/net/Socket;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD$HTTPSession;-><init>(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;Ljava/net/Socket;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 202
    :catch_0
    move-exception v0

    .line 204
    return-void
.end method
