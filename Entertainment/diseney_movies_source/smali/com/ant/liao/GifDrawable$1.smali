.class Lcom/ant/liao/GifDrawable$1;
.super Landroid/os/Handler;
.source "GifDrawable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/ant/liao/GifDrawable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/ant/liao/GifDrawable;


# direct methods
.method constructor <init>(Lcom/ant/liao/GifDrawable;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/ant/liao/GifDrawable$1;->this$0:Lcom/ant/liao/GifDrawable;

    .line 243
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 246
    :try_start_0
    iget-object v1, p0, Lcom/ant/liao/GifDrawable$1;->this$0:Lcom/ant/liao/GifDrawable;

    # invokes: Lcom/ant/liao/GifDrawable;->drawImage()V
    invoke-static {v1}, Lcom/ant/liao/GifDrawable;->access$0(Lcom/ant/liao/GifDrawable;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 250
    :goto_0
    return-void

    .line 247
    :catch_0
    move-exception v0

    .line 248
    .local v0, "ex":Ljava/lang/Exception;
    const-string v1, "GifView"

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
