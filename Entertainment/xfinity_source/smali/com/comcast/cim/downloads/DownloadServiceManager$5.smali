.class Lcom/comcast/cim/downloads/DownloadServiceManager$5;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager;->showCrashDialog(Landroid/content/Context;Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

.field final synthetic val$e:Ljava/lang/Exception;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 304
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$5;, "Lcom/comcast/cim/downloads/DownloadServiceManager$5;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$5;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iput-object p2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$5;->val$e:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 306
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$5;, "Lcom/comcast/cim/downloads/DownloadServiceManager$5;"
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 307
    new-instance v0, Ljava/lang/RuntimeException;

    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$5;->val$e:Ljava/lang/Exception;

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method
