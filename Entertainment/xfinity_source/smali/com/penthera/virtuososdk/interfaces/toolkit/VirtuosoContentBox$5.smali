.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$5;
.super Ljava/lang/Object;
.source "VirtuosoContentBox.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->signalDownloadedChange()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$5;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    .line 968
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 973
    :try_start_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox$5;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;

    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->iDownloadedCallbackHandler:Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;
    invoke-static {v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$14(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;)Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;

    move-result-object v1

    invoke-interface {v1}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;->engineDownloadedListChanged()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 978
    :goto_0
    return-void

    .line 974
    :catch_0
    move-exception v0

    .line 976
    .local v0, "ex":Landroid/os/RemoteException;
    # getter for: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->access$8()Ljava/lang/String;

    move-result-object v1

    const-string v2, "failed to signal downloaded list change"

    invoke-static {v1, v2, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
