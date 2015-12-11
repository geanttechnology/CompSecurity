.class Lcom/adobe/mediacore/DefaultMediaPlayer$3;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/ResourceLoadedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mediacore/DefaultMediaPlayer;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;


# direct methods
.method constructor <init>(Lcom/adobe/mediacore/DefaultMediaPlayer;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$3;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoaded()V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$3;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_logger:Lcom/adobe/mediacore/logging/Logger;
    invoke-static {v0}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1600(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1400()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#endLoadResource"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Loading of media resource is complete. ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/DefaultMediaPlayer$3;->this$0:Lcom/adobe/mediacore/DefaultMediaPlayer;

    # getter for: Lcom/adobe/mediacore/DefaultMediaPlayer;->_resource:Lcom/adobe/mediacore/MediaResource;
    invoke-static {v3}, Lcom/adobe/mediacore/DefaultMediaPlayer;->access$1500(Lcom/adobe/mediacore/DefaultMediaPlayer;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
