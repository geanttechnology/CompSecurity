.class Lcom/comcast/cim/downloads/DownloadServiceManager$2;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Lcom/penthera/virtuososdk/client/IEngineObserver;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 160
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$2;, "Lcom/comcast/cim/downloads/DownloadServiceManager$2;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$2;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public downloadEngineStatusDidChange(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .locals 3
    .param p1, "status"    # Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    .prologue
    .line 163
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$2;, "Lcom/comcast/cim/downloads/DownloadServiceManager$2;"
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Callback downloadEngineStatusDidChange: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v2

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 164
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$2;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V

    .line 165
    return-void
.end method

.method public settingChanged(I)V
    .locals 0
    .param p1, "flags"    # I

    .prologue
    .line 170
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$2;, "Lcom/comcast/cim/downloads/DownloadServiceManager$2;"
    return-void
.end method
